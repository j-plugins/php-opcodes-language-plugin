package com.github.xepozz.php_opcodes_language.language.navigation

import com.github.xepozz.php_opcodes_language.language.psi.PHPOpAssignmentInstruction
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpLineNumber
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpParameter
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpVarName
import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler
import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.search.PsiSearchScopeUtil
import com.intellij.psi.util.PsiTreeUtil

class DeclarationHandler : GotoDeclarationHandler {
    override fun getGotoDeclarationTargets(
        sourceElement: PsiElement?,
        offset: Int,
        editor: Editor
    ): Array<out PsiElement> = ReadAction.compute<Array<out PsiElement>, Throwable> {
        val parent = sourceElement?.parent
        when (parent) {
            is PHPOpVarName -> findPHPVariableDefinitions(parent)
            is PHPOpLineNumber -> findLinesDefinitions(parent)
            is PHPOpParameter -> findZendVariableDefinitions(parent)
            else -> emptyArray()
        }
    }

    private fun findPHPVariableDefinitions(sourceElement: PHPOpVarName): Array<PsiElement> {
        if (sourceElement.text.isEmpty()) return emptyArray()

        return PsiTreeUtil
            .findChildrenOfAnyType(sourceElement.containingFile, PHPOpVarName::class.java)
            .filter { PsiSearchScopeUtil.isInScope(sourceElement.useScope, it) }
            .filter { it.text == sourceElement.text }
            .run { if (firstOrNull() !== sourceElement) listOf(firstOrNull()) else filter { it !== sourceElement } }
            .filterNotNull()
            .toTypedArray()
    }

    private fun findLinesDefinitions(sourceElement: PHPOpLineNumber): Array<PsiElement> {
        if (sourceElement.text.length < 4) return emptyArray()

        return PsiTreeUtil
            .findChildrenOfAnyType(sourceElement.containingFile, PHPOpLineNumber::class.java)
            .filter { PsiSearchScopeUtil.isInScope(sourceElement.useScope, it) }
            .filter { it.text == sourceElement.text }
            .run { if (firstOrNull() !== sourceElement) listOf(firstOrNull()) else filter { it !== sourceElement } }
            .filterNotNull()
            .toTypedArray()
    }

    private fun findZendVariableDefinitions(sourceElement: PHPOpParameter): Array<PsiElement> {
        if (!sourceElement.isVariable) return emptyArray()

        return PsiTreeUtil
            .findChildrenOfAnyType(sourceElement.containingFile, PHPOpParameter::class.java)
            .filter { PsiSearchScopeUtil.isInScope(sourceElement.useScope, it) }
            .filter { it.isVariable }
            .run {
                if (sourceElement.parent !is PHPOpAssignmentInstruction)
                    filter { it.parent is PHPOpAssignmentInstruction }
                else this
            }
            .filter { it !== sourceElement }
            .filter { it.text == sourceElement.text }
            .toTypedArray()
    }
}