package com.github.xepozz.php_opcodes_language.language.reference

import com.github.xepozz.php_opcodes_language.language.psi.PHPOpFunctionName
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult

class PhpFunctionNameReference(
    val myElement: PHPOpFunctionName,
) : PsiPolyVariantReferenceBase<PsiElement>(myElement) {
    override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult> {
        val functionName = myElement.name ?: return emptyArray()

        return PhpEntityResolver.resolveFunction(myElement.project, functionName)
            .let { PsiElementResolveResult.createResults(it); }
    }
}