package com.github.xepozz.php_opcodes_language.reference

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult

class PhpFunctionNameReference(
    val myElement: PsiElement,
    val functionName: String,
) : PsiPolyVariantReferenceBase<PsiElement>(myElement) {
    override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult> {
        return PhpEntityResolver.resolveFunction(myElement.project, functionName)
            .let { PsiElementResolveResult.createResults(it); }
    }
}