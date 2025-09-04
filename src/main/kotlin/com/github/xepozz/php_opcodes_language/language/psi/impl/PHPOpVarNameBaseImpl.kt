package com.github.xepozz.php_opcodes_language.language.psi.impl

import com.github.xepozz.php_opcodes_language.language.psi.PHPOpBlock
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpBlockName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpTypes
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpVarName
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.NlsSafe
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiPolyVariantReference
import com.intellij.psi.search.LocalSearchScope
import com.intellij.psi.search.SearchScope
import com.jetbrains.php.lang.psi.PhpPsiUtil

abstract class PHPOpVarNameBaseImpl : PHPOpVarName, PHPOpElementImpl, PsiNamedElement, PsiPolyVariantReference {
    constructor(node: ASTNode) : super(node)

    override fun getName(): String {
        val keyNode = this.node.findChildByType(PHPOpTypes.IDENTIFIER)

        return keyNode?.text ?: ""
    }

    override fun setName(name: @NlsSafe String): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun getPresentation() = PresentationData(text, null, getIcon(0), null)

    override fun getIcon(flags: Int) = AllIcons.Nodes.Property

    override fun getElement() = this

    override fun getRangeInElement() = TextRange(0, textLength)

    override fun resolve() = multiResolve(false).firstOrNull()?.element

    override fun multiResolve(incompleteCode: Boolean) = PsiElementResolveResult.createResults(this)

    override fun getCanonicalText(): String = text

    override fun handleElementRename(newName: String) = this.setName(newName)

    override fun bindToElement(element: PsiElement): PsiElement? {
        throw UnsupportedOperationException("Method bindToElement is not yet implemented in " + this.javaClass.getName())
    }

    override fun canNavigate() = parent !is PHPOpBlockName

    override fun isReferenceTo(psiElement: PsiElement) = when (psiElement) {
        is PHPOpVarName -> this.text == psiElement.text
        else -> false
    }

    override fun isSoft() = false

    override fun getUseScope(): SearchScope {
        if (parent is PHPOpBlockName) return LocalSearchScope.EMPTY

        val block = PhpPsiUtil.getParentOfClass(this, PHPOpBlock::class.java) ?: return LocalSearchScope.EMPTY
        return LocalSearchScope(block.statementList.toTypedArray())
    }
}