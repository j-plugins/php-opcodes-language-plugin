package com.github.xepozz.php_opcodes_language.language.reference

import com.github.xepozz.php_opcodes_language.Opcodes
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpBlockName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpLineNumber
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpParameter
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpParenParameter
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpVarName
import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.PsiReferenceRegistrar
import com.intellij.util.ProcessingContext

class PHPOpReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {

        registrar.registerReferenceProvider(
            PlatformPatterns.or(
                PlatformPatterns.psiElement(PHPOpVarName::class.java),
                PlatformPatterns.psiElement(PHPOpLineNumber::class.java),
                PlatformPatterns.and(
                    PlatformPatterns.psiElement(PHPOpParameter::class.java),
                    PlatformPatterns.not(
                        PlatformPatterns.psiElement(PHPOpParameter::class.java).withName(Opcodes.THIS.name)
                    )
                ),
                PlatformPatterns.psiElement(PHPOpParenParameter::class.java),
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
            PlatformPatterns.psiElement(PHPOpBlockName::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    if (element !is PHPOpBlockName) return PsiReference.EMPTY_ARRAY

                    return when {
                        element.isFqn -> arrayOf(
                            PhpClassReference(element),
                            PhpFunctionReference(element),
                        )

                        element.isClassMethod -> arrayOf(
                            PhpClassReference(element, TextRange(0, element.classFqn.length)),
                            PhpClassMethodReference(element),
                        )

                        element.isClassPropertyHook -> arrayOf(
                            PhpClassReference(element, TextRange(0, element.classFqn.length)),
                            PhpClassPropertyHookReference(element, false),
                            PhpClassPropertyHookReference(element, true),
                        )

                        else -> PsiReference.EMPTY_ARRAY
                    }
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
    }
}

