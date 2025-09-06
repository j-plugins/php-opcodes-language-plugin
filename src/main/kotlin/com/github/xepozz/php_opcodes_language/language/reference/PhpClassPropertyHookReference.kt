package com.github.xepozz.php_opcodes_language.language.reference

import com.github.xepozz.php_opcodes_language.ReflectionUtil
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult
import com.jetbrains.php.lang.psi.elements.Field
import com.jetbrains.php.lang.psi.elements.Method

class PhpClassPropertyHookReference(val myElement: PsiElement, val targetHook: Boolean) :
    PsiPolyVariantReferenceBase<PsiElement>(myElement) {
    override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult?> {
        val className = myElement.text.substringBefore("::")
        val propertyName = myElement.text.substringAfter("::$").substringBefore("::")
        val hookName = myElement.text.substringAfter("::$") // hook name is id::get

        return PhpEntityResolver().resolveClasses(myElement.project, className)
            .flatMap { it.fields }
            .filter { it.name == propertyName }
            .run { if (!targetHook) this else flatMap { it.filterPropertyHooksCompatible(hookName) } }
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

private fun Field.filterPropertyHooksCompatible(hookName: String): List<Method> {
    return ReflectionUtil.callMethodOrNull<List<Method>>(this, "getPropertyHooksList")
        ?.filter { it.name == hookName }
        ?: emptyList()
}
