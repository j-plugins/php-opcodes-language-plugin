package com.github.xepozz.php_opcodes_language.language.psi.impl

import com.github.xepozz.php_opcodes_language.language.psi.PHPOpBlock
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpStringLiteral
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.psi.LiteralTextEscaper
import com.intellij.psi.PsiLanguageInjectionHost
import com.intellij.psi.search.LocalSearchScope
import com.intellij.psi.search.SearchScope
import com.jetbrains.php.lang.psi.PhpPsiUtil

abstract class PHPOpStringLiteralBaseImpl : PHPOpStringLiteral, PHPOpElementImpl {
    constructor(node: ASTNode) : super(node)

    override fun getPresentation() = PresentationData(text, null, getIcon(0), null)

    override fun getIcon(flags: Int) = AllIcons.Nodes.Property

    override fun isValidHost() = true

    override fun updateText(newText: String): PsiLanguageInjectionHost? {
//        this.replace(PHPOpElementFactory.createStringLiteral(project, newText))
        return this
    }

    override fun createLiteralTextEscaper() = LiteralTextEscaper.createSimple(this)

    override fun getUseScope(): SearchScope {
        val block = PhpPsiUtil.getParentOfClass(this, PHPOpBlock::class.java) ?: return LocalSearchScope.EMPTY
        return LocalSearchScope(block.statementList.toTypedArray())
    }
}