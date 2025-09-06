package com.github.xepozz.php_opcodes_language.language.reference

import com.github.xepozz.php_opcodes_language.language.psi.PHPOpClassName
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult

class PhpClassNameReference(
    val myElement: PHPOpClassName,
) : PsiPolyVariantReferenceBase<PsiElement>(myElement) {
    override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult> {
        val className = myElement.text

        return PhpEntityResolver.resolveClasses(myElement.project, className)
            .let { PsiElementResolveResult.createResults(it); }
    }
}