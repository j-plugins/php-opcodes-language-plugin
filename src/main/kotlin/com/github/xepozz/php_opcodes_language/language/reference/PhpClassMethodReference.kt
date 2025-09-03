package com.github.xepozz.php_opcodes_language.language.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult

class PhpClassMethodReference(val myElement: PsiElement) : PsiPolyVariantReferenceBase<PsiElement>(myElement) {
    override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult?> {
        val className = myElement.text.substringBefore("::")
        val methodName = myElement.text.substringAfter("::")

        return PhpEntityResolver().resolveClasses(myElement.project, className)
            .flatMap { it.methods }
            .filter { it.name == methodName }
            .let { PsiElementResolveResult.createResults(it) }
    }

    override fun isSoft() = false
    override fun getRangeInElement(): TextRange {
        val text = myElement.text
        val separatorIndex = text.indexOf("::")

        return if (separatorIndex != -1) {
            TextRange(separatorIndex + 2, text.length)
        } else myElement.textRange
    }
}