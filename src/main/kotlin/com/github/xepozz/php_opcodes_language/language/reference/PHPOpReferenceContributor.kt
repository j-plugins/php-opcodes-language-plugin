package com.github.xepozz.php_opcodes_language.language.reference

import com.github.xepozz.php_opcodes_language.Opcodes
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpClassName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpFunctionName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpLineNumber
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpMethodName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpParameter
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpParenParameter
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpPropertyHookName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpPropertyName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpVarName
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
            PlatformPatterns.psiElement(PHPOpClassName::class.java),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    if (element !is PHPOpClassName) return PsiReference.EMPTY_ARRAY

                    return arrayOf(PhpClassNameReference(element))
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

                    return arrayOf(PhpMethodNameReference(element))
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

                    return arrayOf(PhpFunctionNameReference(element))
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

                    return arrayOf(PhpPropertyNameReference(element))
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
    }
}

