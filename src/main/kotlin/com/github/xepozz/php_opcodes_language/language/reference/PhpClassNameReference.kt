package com.github.xepozz.php_opcodes_language.language.reference

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult

class PhpClassNameReference(
    val myElement: PsiElement,
    val className: String,
) : PsiPolyVariantReferenceBase<PsiElement>(myElement) {
    override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult> {
        return PhpEntityResolver.resolveClasses(myElement.project, className)
            .let { PsiElementResolveResult.createResults(it); }
    }
}