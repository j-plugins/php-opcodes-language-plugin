package com.github.xepozz.php_opcodes_language

import com.intellij.patterns.ElementPattern
import com.intellij.patterns.PatternCondition
import com.intellij.patterns.PsiElementPattern
import com.intellij.patterns.TreeElementPattern
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext


fun <T : PsiElement, Self : PsiElementPattern<T, Self>> TreeElementPattern<PsiElement, T, Self>.beforeSibling(pattern: ElementPattern<T>): Self {
    return with(object : PatternCondition<T>("beforeSibling") {
        override fun accepts(t: T, context: ProcessingContext?): Boolean {
            val parent = t.parent ?: return false
            val children = parent.children
            val i = children.indexOf(t)
            if (i + 1 >= children.size) return false
            return pattern.accepts(children[i + 1], context)
        }
    })
}
