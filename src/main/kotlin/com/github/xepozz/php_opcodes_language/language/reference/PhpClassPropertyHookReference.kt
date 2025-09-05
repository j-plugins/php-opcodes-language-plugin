package com.github.xepozz.php_opcodes_language.language.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult

class PhpClassPropertyHookReference(val myElement: PsiElement, val targetHook: Boolean) :
    PsiPolyVariantReferenceBase<PsiElement>(myElement) {
    override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult?> {
        val className = myElement.text.substringBefore("::")
        val propertyName = myElement.text.substringAfter("::$").substringBefore("::")
        val hookName = myElement.text.substringAfter("::$") // hook name is id::get

        return PhpEntityResolver().resolveClasses(myElement.project, className)
            .flatMap { it.fields }
            .filter { it.name == propertyName }
            .run { if (!targetHook) this else flatMap { it.propertyHooksList }.filter { it.name == hookName } }
            .let { PsiElementResolveResult.createResults(it) }
    }

    override fun isSoft() = false

    override fun getRangeInElement(): TextRange {
        val text = myElement.text
        val propertySeparatorIndex = text.indexOf("::")
        val hookSeparatorIndex = text.lastIndexOf("::")

        return when {
            propertySeparatorIndex == -1 -> myElement.textRange
            targetHook && hookSeparatorIndex != -1 -> TextRange(hookSeparatorIndex + 2, text.length)
            !targetHook && hookSeparatorIndex != -1 -> TextRange(propertySeparatorIndex + 2, hookSeparatorIndex)
            !targetHook && hookSeparatorIndex == -1 -> TextRange(propertySeparatorIndex + 2, text.length)
            else -> myElement.textRange
        }
    }
}