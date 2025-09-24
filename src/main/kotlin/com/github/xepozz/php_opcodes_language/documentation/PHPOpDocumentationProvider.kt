package com.github.xepozz.php_opcodes_language.documentation

import com.github.xepozz.php_opcodes_language.language.psi.PHPOpParameter
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpParenParameter
import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.markdown.utils.lang.CodeBlockHtmlSyntaxHighlighter
import com.intellij.psi.PsiElement

class PHPOpDocumentationProvider : AbstractDocumentationProvider() {
    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? = when (element) {
        is PHPOpParenParameter -> getQuickNavigateInfo(element.parameter, originalElement)
        is PHPOpParameter -> {
            val doc = OpcodesDictionary.getDocumentation(element.text!!)

            doc?.description
        }

        else -> null
    }

    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? = when (element) {
        is PHPOpParenParameter -> generateDoc(element.parameter, originalElement)
        is PHPOpParameter -> {
            val elementName = element.text ?: return null
            val directiveName = when {
                element.isVariable -> elementName.trimEnd { it.isDigit() }
                else -> elementName
            }
            val doc = OpcodesDictionary.getDocumentation(directiveName) ?: return null

            val highlighter = CodeBlockHtmlSyntaxHighlighter(element.project)

            buildString {
                append("<div class='definition'>")
                append("<pre><b>Name</b>: ${elementName}</pre>")
                if (doc.number >= 0) {
                    append("<pre><b>Number</b>: ${doc.number}</pre>")
                }
                append("</div>")

                append("<div class='content'>")
                if (doc.description != null) {
                    append("<p>${doc.description}</p>")
                } else {
                    append("<p class='grayed'>No description provided</p>")
                }

                if (doc.examplePhp != null) {
                    append("<p>Example PHP</p>")
                    append("<pre>")
                    append(highlighter.color("InjectablePHP", "<?php\n"))
                    append(highlighter.color("InjectablePHP", doc.examplePhp))
                    append("</pre>")
                } else {
                    append("<p class='grayed'>No PHP example provided</p>")
                }

                if (doc.exampleOpcode != null) {
                    append("<p>Example Opcodes</p>")
                    append("<pre>${highlighter.color("PHP Opcodes", doc.exampleOpcode)}</pre>")
                } else {
                    append("<p class='grayed'>No Opcodes example provided</p>")
                }

                append("</div>")

                append("<div class='content'>")

                append("<p class='grayed'>")
                append("Improve the documentation by submitting a pull request to the ")
                append("<a href='https://github.com/j-plugins/php-opcodes-language-plugin'>repository</a>")
                append("</p>")


                append("</div>")
            }
        }

        else -> null
    }
}