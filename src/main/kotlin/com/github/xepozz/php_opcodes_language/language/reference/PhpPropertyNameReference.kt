package com.github.xepozz.php_opcodes_language.language.reference

import com.github.xepozz.php_opcodes_language.language.psi.PHPOpPropertyName
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult

class PhpPropertyNameReference(
    val myElement: PHPOpPropertyName,
) : PsiPolyVariantReferenceBase<PsiElement>(myElement) {
    override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult> {
        val className = myElement.className.name ?: return emptyArray()
        val propertyName = myElement.name

        return PhpEntityResolver.resolveClasses(myElement.project, className)
            .flatMap { it.fields }
            .filter { it.name == propertyName }
            .let { PsiElementResolveResult.createResults(it) }
    }

    override fun isSoft() = false

    override fun getRangeInElement() = myElement.propertyNameRange
}