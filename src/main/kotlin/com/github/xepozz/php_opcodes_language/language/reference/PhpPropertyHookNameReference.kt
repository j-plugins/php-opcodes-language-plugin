package com.github.xepozz.php_opcodes_language.language.reference

import com.github.xepozz.php_opcodes_language.ReflectionUtil
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpPropertyHookName
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult
import com.jetbrains.php.lang.psi.elements.Field
import com.jetbrains.php.lang.psi.elements.Method

class PhpPropertyHookNameReference(
    val myElement: PHPOpPropertyHookName,
) : PsiPolyVariantReferenceBase<PsiElement>(myElement) {
    override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult> {
        val className = myElement.propertyName.className.name ?: return emptyArray()
        val propertyName = myElement.propertyName.name ?: return emptyArray()
        val hookName = myElement.name?.let { "$propertyName::$it" } ?: return emptyArray()

        return PhpEntityResolver.resolveClasses(myElement.project, className)
            .flatMap { it.fields }
            .filter { it.name == propertyName }
            .flatMap { it.filterPropertyHooksCompatible(hookName) }
            .let { PsiElementResolveResult.createResults(it) }
    }

    override fun isSoft() = false

    override fun getRangeInElement() = myElement.propertyHookNameRange
}

private fun Field.filterPropertyHooksCompatible(hookName: String): List<Method> {
    return ReflectionUtil.callMethodOrNull<List<Method>>(this, "getPropertyHooksList")
        ?.filter { it.name == hookName }
        ?: emptyList()
}
