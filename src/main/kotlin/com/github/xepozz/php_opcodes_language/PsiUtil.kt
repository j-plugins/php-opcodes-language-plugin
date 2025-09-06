package com.github.xepozz.php_opcodes_language

import com.intellij.psi.PsiFileSystemItem

object PsiUtil {
    tailrec fun getTopmostParent(element: PsiFileSystemItem): PsiFileSystemItem {
        val parent = element.parent
        return if (parent != null) getTopmostParent(parent) else element
    }
}