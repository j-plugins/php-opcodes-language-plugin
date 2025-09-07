package com.github.xepozz.php_opcodes_language.language.reference

import com.github.xepozz.php_opcodes_language.language.psi.PHPOpPropertyName
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult

class PhpPropertyNameReference(
    val myElement: PsiElement,
    val className: String,
    val propertyName: String,
    val elementRange: TextRange,
) : PsiPolyVariantReferenceBase<PsiElement>(myElement, elementRange) {
    override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult> {
        return PhpEntityResolver.resolveClasses(myElement.project, className)
            .flatMap { it.fields }
            .filter { it.name == propertyName }
            .let { PsiElementResolveResult.createResults(it) }
    }

    override fun isSoft() = false

    companion object {
        fun of(element: PHPOpPropertyName): PhpPropertyNameReference = PhpPropertyNameReference(
            element,
            element.className.name!!,
            element.name!!,
            element.propertyNameRange,
        )
    }
}