package com.github.xepozz.php_opcodes_language.reference

import com.github.xepozz.php_opcodes_language.Opcodes
import com.github.xepozz.php_opcodes_language.Primitives
import com.github.xepozz.php_opcodes_language.PsiUtil
import com.github.xepozz.php_opcodes_language.beforeSibling
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpArgument
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpBlock
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpBlockName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpClassName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpFunctionName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpInstruction
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpLineNumber
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpMethodName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpParameter
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpParenExpr
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpParenParameter
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpPathAbsolute
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpPropertyHookName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpPropertyName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpStringLiteral
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpVarName
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileSystemItem
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.PsiReferenceRegistrar
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FileReferenceSet
import com.intellij.psi.search.LocalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.ProcessingContext

class PHPOpReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {

        registrar.registerReferenceProvider(
            PlatformPatterns.or(
                PlatformPatterns.psiElement(PHPOpVarName::class.java),
                PlatformPatterns.psiElement(PHPOpLineNumber::class.java),
                PlatformPatterns.psiElement(PHPOpParameter::class.java),
            ),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    if (element !is PsiReference) return PsiReference.EMPTY_ARRAY

                    return arrayOf(element)
                }
            }
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PHPOpClassName::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    if (element !is PHPOpClassName) return PsiReference.EMPTY_ARRAY

                    return arrayOf(PhpClassNameReference(element, element.name ?: return PsiReference.EMPTY_ARRAY))
                }
            }
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PHPOpMethodName::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    if (element !is PHPOpMethodName) return PsiReference.EMPTY_ARRAY

                    return arrayOf(PhpMethodNameReference.of(element))
                }
            }
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PHPOpFunctionName::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    if (element !is PHPOpFunctionName) return PsiReference.EMPTY_ARRAY

                    return arrayOf(PhpFunctionNameReference(element, element.name ?: return PsiReference.EMPTY_ARRAY))
                }
            }
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PHPOpPropertyName::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    if (element !is PHPOpPropertyName) return PsiReference.EMPTY_ARRAY

                    return arrayOf(PhpPropertyNameReference.of(element))
                }
            }
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PHPOpPropertyHookName::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    if (element !is PHPOpPropertyHookName) return PsiReference.EMPTY_ARRAY

                    return arrayOf(PhpPropertyHookNameReference(element))
                }
            }
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PHPOpParameter::class.java).withName(Opcodes.THIS.name),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    if (element !is PHPOpParameter) return PsiReference.EMPTY_ARRAY

                    return arrayOf(PhpThisReference(element))
                }
            }
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PHPOpPathAbsolute::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<out PsiReference> {
                    if (element !is PHPOpPathAbsolute) return PsiReference.EMPTY_ARRAY

                    return object : FileReferenceSet(element) {
                        override fun getDefaultContexts(): Collection<PsiFileSystemItem> {
                            return listOf(PsiUtil.getTopmostParent(element.containingFile))
                        }
                    }.allReferences
                }
            }
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PHPOpStringLiteral::class.java)
                .withParent(
                    PlatformPatterns.psiElement(PHPOpParenExpr::class.java)
                        .withParent(
                            PlatformPatterns.psiElement(PHPOpParenParameter::class.java)
                                .withParent(
                                    PlatformPatterns.psiElement(PHPOpArgument::class.java)
                                        .withParent(
                                            PlatformPatterns.psiElement(PHPOpInstruction::class.java)
                                                .withName(
                                                    *arrayOf(
                                                        Opcodes.INIT_NS_FCALL_BY_NAME,
                                                        Opcodes.INIT_FCALL,
                                                        Opcodes.INIT_FCALL_BY_NAME,
                                                        Opcodes.SEND_VAL_EX,
                                                    )
                                                        .map { it.name }
                                                        .toTypedArray(),
                                                )
                                        )
                                )
                        )
                ),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<out PsiReference> {
                    if (element !is PHPOpStringLiteral) return PsiReference.EMPTY_ARRAY

                    val functionName = element.value.replace("\\\\", "\\")
                    return arrayOf(PhpFunctionNameReference(element, functionName))
                }
            }
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PHPOpParameter::class.java)
                .withParent(
                    PlatformPatterns.psiElement(PHPOpParenExpr::class.java)
                        .withParent(
                            PlatformPatterns.psiElement(PHPOpArgument::class.java)
                                .withParent(
                                    PlatformPatterns.psiElement(PHPOpInstruction::class.java)
                                        .withName(
                                            *arrayOf(
                                                Opcodes.FRAMELESS_ICALL_0,
                                                Opcodes.FRAMELESS_ICALL_1,
                                                Opcodes.FRAMELESS_ICALL_2,
                                                Opcodes.FRAMELESS_ICALL_3,
                                            )
                                                .map { it.name }
                                                .toTypedArray(),
                                        )
                                )
                        )
                ),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<out PsiReference> {
                    println("PHPOpTypes.IDENTIFIER: ${element.text}")
                    val functionName = element.text
                    return arrayOf(PhpFunctionNameReference(element, functionName))
                }
            }
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PHPOpStringLiteral::class.java)
                .withParent(
                    PlatformPatterns.psiElement(PHPOpParenExpr::class.java)
                        .withParent(
                            PlatformPatterns.psiElement(PHPOpParenParameter::class.java)
                                .withParent(
                                    PlatformPatterns.psiElement(PHPOpArgument::class.java)
                                        .withParent(
                                            PlatformPatterns.psiElement(PHPOpInstruction::class.java)
                                                .withName(
                                                    *arrayOf(
                                                        Opcodes.NEW,
                                                        Opcodes.FETCH_CLASS_CONSTANT,
                                                        Opcodes.DECLARE_CLASS_DELAYED,
                                                        Opcodes.SEND_VAL_EX,
                                                    )
                                                        .map { it.name }
                                                        .toTypedArray(),
                                                )
                                        )
                                )
                        )
                ),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<out PsiReference> {
                    if (element !is PHPOpStringLiteral) return PsiReference.EMPTY_ARRAY

                    val className = element.value.replace("\\\\", "\\")
                    return arrayOf(PhpClassNameReference(element, className))
                }
            }
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PHPOpStringLiteral::class.java)
                .withParent(
                    PlatformPatterns.psiElement(PHPOpParenExpr::class.java)
                        .withParent(
                            PlatformPatterns.psiElement(PHPOpParenParameter::class.java)
                                .withParent(
                                    PlatformPatterns.psiElement(PHPOpArgument::class.java)
                                        .withParent(
                                            PlatformPatterns.psiElement(PHPOpInstruction::class.java)
                                                .withName(
                                                    *arrayOf(
                                                        Opcodes.INIT_METHOD_CALL,
                                                    )
                                                        .map { it.name }
                                                        .toTypedArray(),
                                                )
                                        )
                                        .afterSibling(
                                            PlatformPatterns.psiElement(PHPOpArgument::class.java)
                                                .withChild(
                                                    PlatformPatterns.psiElement(PHPOpParameter::class.java)
                                                        .withName(Opcodes.THIS.name)
                                                )
                                        )
                                )
                        )
                ),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<out PsiReference> {
                    if (element !is PHPOpStringLiteral) return PsiReference.EMPTY_ARRAY

                    val methodName = element.value
                    val useScope = element.useScope as? LocalSearchScope ?: return emptyArray()
                    val block = useScope.scope.firstOrNull()?.parent as? PHPOpBlock ?: return emptyArray()
                    val blockName = block.children.firstOrNull() as? PHPOpBlockName ?: return emptyArray()

                    val className = blockName.classFqn

                    return arrayOf(
                        PhpMethodNameReference(
                            element,
                            className,
                            methodName,
                            element.textRangeInParent.shiftLeft(1),
                        )
                    )
                }
            }
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PHPOpStringLiteral::class.java)
                .withParent(
                    PlatformPatterns.psiElement(PHPOpParenExpr::class.java)
                        .withParent(
                            PlatformPatterns.psiElement(PHPOpParenParameter::class.java)
                                .withParent(
                                    PlatformPatterns.psiElement(PHPOpArgument::class.java)
                                        .withParent(
                                            PlatformPatterns.psiElement(PHPOpInstruction::class.java)
                                                .withName(
                                                    *arrayOf(
                                                        Opcodes.INIT_STATIC_METHOD_CALL,
                                                    )
                                                        .map { it.name }
                                                        .toTypedArray(),
                                                )
                                        )
                                        .afterSibling(
                                            PlatformPatterns.psiElement(PHPOpArgument::class.java)
                                                .withChild(
                                                    PlatformPatterns.psiElement(PHPOpParenParameter::class.java)
                                                        .withFirstChild(
                                                            PlatformPatterns.psiElement(PHPOpParameter::class.java)
                                                                .withText(Primitives.string.name)
                                                        )
                                                        .withLastChild(
                                                            PlatformPatterns.psiElement(PHPOpParenExpr::class.java)
                                                                .withChild(
                                                                    PlatformPatterns.psiElement(PHPOpStringLiteral::class.java)
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                ),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<out PsiReference> {
                    if (element !is PHPOpStringLiteral) return PsiReference.EMPTY_ARRAY

                    val methodArgument = PsiTreeUtil.getParentOfType(element, PHPOpArgument::class.java)
                        ?: return emptyArray()

                    val classElement = PsiTreeUtil
                        .getParentOfType(element, PHPOpInstruction::class.java)
                        ?.argumentList
                        ?.lastOrNull { it !== methodArgument }
                        ?.run { PsiTreeUtil.findChildOfType(this, PHPOpStringLiteral::class.java) }
                        ?: return emptyArray()

                    val methodName = element.value
                    val className = classElement.value

                    return arrayOf(
                        PhpMethodNameReference(
                            element,
                            className,
                            methodName,
                            element.textRangeInParent.shiftLeft(1),
                        )
                    )
                }
            }
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PHPOpStringLiteral::class.java)
                .withParent(
                    PlatformPatterns.psiElement(PHPOpParenExpr::class.java)
                        .withParent(
                            PlatformPatterns.psiElement(PHPOpParenParameter::class.java)
                                .withParent(
                                    PlatformPatterns.psiElement(PHPOpArgument::class.java)
                                        .withParent(
                                            PlatformPatterns.psiElement(PHPOpInstruction::class.java)
                                                .withName(
                                                    *arrayOf(
                                                        Opcodes.INIT_STATIC_METHOD_CALL,
                                                    )
                                                        .map { it.name }
                                                        .toTypedArray(),
                                                )
                                        )
                                        .beforeSibling(
                                            PlatformPatterns.psiElement(PHPOpArgument::class.java)
                                                .withChild(
                                                    PlatformPatterns.psiElement(PHPOpParenParameter::class.java)
                                                        .withFirstChild(
                                                            PlatformPatterns.psiElement(PHPOpParameter::class.java)
                                                                .withText(Primitives.string.name)
                                                        )
                                                        .withLastChild(
                                                            PlatformPatterns.psiElement(PHPOpParenExpr::class.java)
                                                                .withChild(
                                                                    PlatformPatterns.psiElement(PHPOpStringLiteral::class.java)
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                ),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<out PsiReference> {
                    if (element !is PHPOpStringLiteral) return PsiReference.EMPTY_ARRAY

                    val className = element.value

                    return arrayOf(PhpClassNameReference(element, className))
                }
            }
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PHPOpStringLiteral::class.java)
                .withParent(
                    PlatformPatterns.psiElement(PHPOpParenExpr::class.java)
                        .withParent(
                            PlatformPatterns.psiElement(PHPOpParenParameter::class.java)
                                .withParent(
                                    PlatformPatterns.psiElement(PHPOpArgument::class.java)
                                        .withParent(
                                            PlatformPatterns.psiElement(PHPOpInstruction::class.java)
                                                .withName(
                                                    *arrayOf(
                                                        Opcodes.FETCH_STATIC_PROP_R,
                                                        Opcodes.ASSIGN_STATIC_PROP,
                                                    )
                                                        .map { it.name }
                                                        .toTypedArray(),
                                                )
                                        )
                                        .beforeSibling(
                                            PlatformPatterns.psiElement(PHPOpArgument::class.java)
                                                .withChild(
                                                    PlatformPatterns.psiElement(PHPOpParenParameter::class.java)
                                                        .withFirstChild(
                                                            PlatformPatterns.psiElement(PHPOpParameter::class.java)
                                                                .withText(Primitives.string.name)
                                                        )
                                                        .withLastChild(
                                                            PlatformPatterns.psiElement(PHPOpParenExpr::class.java)
                                                                .withChild(
                                                                    PlatformPatterns.psiElement(PHPOpStringLiteral::class.java)
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                ),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<out PsiReference> {
                    if (element !is PHPOpStringLiteral) return PsiReference.EMPTY_ARRAY

                    val propertyArgument = PsiTreeUtil.getParentOfType(element, PHPOpArgument::class.java)
                        ?: return emptyArray()

                    val classElement = PsiTreeUtil
                        .getParentOfType(element, PHPOpInstruction::class.java)
                        ?.argumentList
                        ?.lastOrNull { it !== propertyArgument }
                        ?.run { PsiTreeUtil.findChildOfType(this, PHPOpStringLiteral::class.java) }
                        ?: return emptyArray()

                    val propertyName = element.value
                    val className = classElement.value.replace("\\\\", "\\")

                    return arrayOf(
                        PhpPropertyNameReference(
                            element,
                            className,
                            propertyName,
                            element.textRangeInParent.shiftLeft(1),
                        )
                    )
                }
            }
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PHPOpStringLiteral::class.java)
                .withParent(
                    PlatformPatterns.psiElement(PHPOpParenExpr::class.java)
                        .withParent(
                            PlatformPatterns.psiElement(PHPOpParenParameter::class.java)
                                .withParent(
                                    PlatformPatterns.psiElement(PHPOpArgument::class.java)
                                        .withParent(
                                            PlatformPatterns.psiElement(PHPOpInstruction::class.java)
                                                .withName(
                                                    *arrayOf(
                                                        Opcodes.FETCH_STATIC_PROP_R,
                                                        Opcodes.ASSIGN_STATIC_PROP,
                                                    )
                                                        .map { it.name }
                                                        .toTypedArray(),
                                                )
                                        )
                                        .afterSibling(
                                            PlatformPatterns.psiElement(PHPOpArgument::class.java)
                                                .withChild(
                                                    PlatformPatterns.psiElement(PHPOpParenParameter::class.java)
                                                        .withFirstChild(
                                                            PlatformPatterns.psiElement(PHPOpParameter::class.java)
                                                                .withText(Primitives.string.name)
                                                        )
                                                        .withLastChild(
                                                            PlatformPatterns.psiElement(PHPOpParenExpr::class.java)
                                                                .withChild(
                                                                    PlatformPatterns.psiElement(PHPOpStringLiteral::class.java)
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                ),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<out PsiReference> {
                    if (element !is PHPOpStringLiteral) return PsiReference.EMPTY_ARRAY

                    val className = element.value.replace("\\\\", "\\")

                    return arrayOf(PhpClassNameReference(element, className))
                }
            }
        )

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(PHPOpStringLiteral::class.java)
                .withParent(
                    PlatformPatterns.psiElement(PHPOpParenExpr::class.java)
                        .withParent(
                            PlatformPatterns.psiElement(PHPOpParenParameter::class.java)
                                .withParent(
                                    PlatformPatterns.psiElement(PHPOpArgument::class.java)
                                        .withParent(
                                            PlatformPatterns.psiElement(PHPOpInstruction::class.java)
                                                .withName(
                                                    *arrayOf(
                                                        Opcodes.FETCH_OBJ_R,
                                                        Opcodes.ASSIGN_OBJ,
                                                    )
                                                        .map { it.name }
                                                        .toTypedArray(),
                                                )
                                        )
                                        .afterSibling(
                                            PlatformPatterns.psiElement(PHPOpArgument::class.java)
                                                .withChild(
                                                    PlatformPatterns.psiElement(PHPOpParameter::class.java)
                                                        .withName(Opcodes.THIS.name)
                                                )
                                        )
                                )
                        )
                ),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<out PsiReference> {
                    if (element !is PHPOpStringLiteral) return PsiReference.EMPTY_ARRAY

                    val fieldName = element.value
                    val useScope = element.useScope as? LocalSearchScope ?: return emptyArray()
                    val block = useScope.scope.firstOrNull()?.parent as? PHPOpBlock ?: return emptyArray()
                    val blockName = block.children.firstOrNull() as? PHPOpBlockName ?: return emptyArray()

                    val className = blockName.classFqn

                    return arrayOf(
                        PhpPropertyNameReference(
                            element,
                            className,
                            fieldName,
                            element.textRangeInParent.shiftLeft(1),
                        )
                    )
                }
            }
        )
    }
}
