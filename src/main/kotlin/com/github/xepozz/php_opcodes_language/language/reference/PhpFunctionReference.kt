package com.github.xepozz.php_opcodes_language.language.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult

class PhpFunctionReference(
    val myElement: PsiElement,
    val textRange: TextRange = myElement.textRangeInParent,
) : PsiPolyVariantReferenceBase<PsiElement>(myElement, textRange) {
    override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult?> {
        val className = textRange.substring(myElement.text)

        return PhpEntityResolver().resolveFunction(myElement.project, className)
            .let { PsiElementResolveResult.createResults(it); }
    }
}