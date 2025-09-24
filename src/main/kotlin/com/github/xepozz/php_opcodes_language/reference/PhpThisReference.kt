package com.github.xepozz.php_opcodes_language.reference

import com.github.xepozz.php_opcodes_language.language.psi.PHPOpBlock
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpBlockName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpParameter
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiPolyVariantReferenceBase
import com.intellij.psi.ResolveResult
import com.intellij.psi.search.LocalSearchScope

class PhpThisReference(
    val myElement: PHPOpParameter,
) : PsiPolyVariantReferenceBase<PsiElement>(myElement) {
    override fun multiResolve(incompleteCode: Boolean): Array<out ResolveResult> {
        val useScope = myElement.useScope as? LocalSearchScope ?: return emptyArray()
        val block = useScope.scope.firstOrNull()?.parent as? PHPOpBlock ?: return emptyArray()
        val blockName = block.children.firstOrNull() as? PHPOpBlockName ?: return emptyArray()

        val className = blockName.classFqn

        return PhpEntityResolver.resolveClasses(myElement.project, className)
            .let { PsiElementResolveResult.createResults(it); }
    }
}