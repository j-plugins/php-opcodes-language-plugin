package com.github.xepozz.php_opcodes_language.language.reference

import com.github.xepozz.php_opcodes_language.language.psi.PHPOpMethodName
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult

class PhpMethodNameReference(val myElement: PHPOpMethodName) : PsiPolyVariantReferenceBase<PsiElement>(myElement) {
    override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult> {
        val className = myElement.className.name ?: return emptyArray()
        val methodName = myElement.name

        return PhpEntityResolver.resolveClasses(myElement.project, className)
            .flatMap { it.methods }
            .filter { it.name == methodName }
            .let { PsiElementResolveResult.createResults(it) }
    }

    override fun isSoft() = false

    override fun getRangeInElement() = myElement.methodNameRange
}