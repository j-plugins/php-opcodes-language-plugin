package com.github.xepozz.php_opcodes_language.folding

import com.github.xepozz.php_opcodes_language.language.psi.PHPOpBlock
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil

class PHPOpFoldingBuilder : FoldingBuilderEx(), DumbAware {
    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean) =
        collectFoldingBlocks(root).toTypedArray()

    private fun collectFoldingBlocks(element: PsiElement) =
        PsiTreeUtil
            .findChildrenOfType(element, PHPOpBlock::class.java)
            .mapNotNull {
                val startOffset = it.blockName.textRange.endOffset + 1
                val endOffset = it.textRange.endOffset - 1
                if (endOffset <= startOffset) return@mapNotNull null

                FoldingDescriptor(
                    it.node,
                    TextRange(startOffset, endOffset)
                )
            }

    override fun getPlaceholderText(node: ASTNode) = "{ ... }"

    override fun isCollapsedByDefault(node: ASTNode) = false
}
