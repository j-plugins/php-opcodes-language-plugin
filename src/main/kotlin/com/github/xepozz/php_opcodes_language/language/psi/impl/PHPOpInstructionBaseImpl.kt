package com.github.xepozz.php_opcodes_language.language.psi.impl

import com.github.xepozz.php_opcodes_language.language.psi.PHPOpBlock
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpInstruction
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.psi.search.LocalSearchScope
import com.intellij.psi.search.SearchScope
import com.jetbrains.php.lang.psi.PhpPsiUtil

abstract class PHPOpInstructionBaseImpl : PHPOpInstruction, PHPOpElementImpl {
    constructor(node: ASTNode) : super(node)

    override fun getName(): String? = this.parameter.name

    override fun setName(name: @NlsSafe String): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun getPresentation() = PresentationData(text, null, getIcon(0), null)

    override fun getIcon(flags: Int) = AllIcons.Nodes.Property

    override fun getUseScope(): SearchScope {
        val block = PhpPsiUtil.getParentOfClass(this, PHPOpBlock::class.java) ?: return LocalSearchScope.EMPTY
        return LocalSearchScope(block.statementList.toTypedArray())
    }
}