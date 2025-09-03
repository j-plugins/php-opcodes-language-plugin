package com.github.xepozz.php_opcodes_language.language.reference

import com.intellij.openapi.project.Project
import com.jetbrains.php.PhpIndex
import com.jetbrains.php.config.PhpLanguageLevel
import com.jetbrains.php.lang.PhpLangUtil
import com.jetbrains.php.lang.psi.elements.Function
import com.jetbrains.php.lang.psi.elements.PhpClass
import com.jetbrains.php.refactoring.PhpNameUtil

class PhpEntityResolver {
    fun resolveClasses(project: Project, fqn: String): Collection<PhpClass> {
        if (!PhpNameUtil.isValidNamespaceFullName(fqn, true, PhpLanguageLevel.current(project))) return emptyList()

        return PhpIndex.getInstance(project).getAnyByFQN(fqn)
    }

    fun resolveFunction(project: Project, fqn: String): Collection<Function> {
        if (!PhpNameUtil.isValidNamespaceFullName(fqn, true, PhpLanguageLevel.current(project))) return emptyList()
        val fqn = PhpLangUtil.toFQN(fqn)

        return PhpIndex.getInstance(project).getFunctionsByFQN(fqn)
    }
}