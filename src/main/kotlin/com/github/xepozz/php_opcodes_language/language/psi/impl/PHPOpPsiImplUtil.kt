package com.github.xepozz.php_opcodes_language.language.psi.impl

import com.github.xepozz.php_opcodes_language.language.psi.PHPOpBlockName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpParameter
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpTypes
import com.intellij.lang.ASTNode
import com.jetbrains.php.config.PhpLanguageLevel
import com.jetbrains.php.refactoring.PhpNameUtil

class PHPOpPsiImplUtil {
    companion object {
        @JvmStatic
        fun isVariable(element: PHPOpParameter): Boolean = element.text.matches(Regex("(?:[TV]|CV)\\d+"))

        @JvmStatic
        fun isFqn(element: PHPOpBlockName): Boolean = element.node.getChildren(null).run {
            size == 1 && get(0).run { elementType == PHPOpTypes.IDENTIFIER && isValidFqn(element) }
        }

        private fun ASTNode.isValidFqn(element: PHPOpBlockName): Boolean =
            PhpNameUtil.isValidNamespaceFullName(text, true, PhpLanguageLevel.current(element.project))

        @JvmStatic
        fun isClassMethod(element: PHPOpBlockName): Boolean = element.node.let {
            val children = it.getChildren(null)
            children.size == 4
                    && children[0].elementType == PHPOpTypes.IDENTIFIER
                    && children[1].elementType == PHPOpTypes.COLON
                    && children[2].elementType == PHPOpTypes.COLON
                    && children[3].elementType == PHPOpTypes.IDENTIFIER
        }

        @JvmStatic
        fun isMain(element: PHPOpBlockName): Boolean = element.text == $$"$_main"
    }
}
