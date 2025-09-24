package com.github.xepozz.php_opcodes_language.reference

import com.github.xepozz.php_opcodes_language.language.psi.PHPOpMethodName
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult

class PhpMethodNameReference(
    val myElement: PsiElement,
    val className: String,
    val methodName: String,
    val elementRange: TextRange,
) : PsiPolyVariantReferenceBase<PsiElement>(myElement, elementRange) {
    override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult> {
        return PhpEntityResolver.resolveClasses(myElement.project, className)
            .flatMap { it.methods }
            .filter { it.name == methodName }
            .let { PsiElementResolveResult.createResults(it) }
    }

    override fun isSoft() = false

    companion object {
        fun of(element: PHPOpMethodName): PhpMethodNameReference = PhpMethodNameReference(
            element,
            element.className.name!!,
            element.name!!,
            element.methodNameRange,
        )
    }
}