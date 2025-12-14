package com.github.xepozz.php_opcodes_language.folding

import com.github.xepozz.php_opcodes_language.language.psi.PHPOpLiveRange
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class PHPOpLiveRangeFoldingBuilder : FoldingBuilderEx(), DumbAware {
    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean) =
        collectFoldingBlocks(root).toTypedArray()

    private fun collectFoldingBlocks(element: PsiElement) =
        PsiTreeUtil
            .findChildrenOfType(element, PHPOpLiveRange::class.java)
            .mapNotNull {
                FoldingDescriptor(
                    it.node,
                    it.textRange
                )
            }

    override fun getPlaceholderText(node: ASTNode) = "Live Range"

    override fun isCollapsedByDefault(node: ASTNode) = true
}
