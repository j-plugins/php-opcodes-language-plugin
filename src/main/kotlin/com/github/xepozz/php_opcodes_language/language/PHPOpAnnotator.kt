package com.github.xepozz.php_opcodes_language.language

import com.github.xepozz.php_opcodes_language.Opcodes
import com.github.xepozz.php_opcodes_language.Primitives
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpClassName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpFunctionName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpLineNumber
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpMethodName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpParameter
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpParenParameter
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpPropertyHookName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpPropertyName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpVarName
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.jetbrains.php.lang.highlighter.PhpHighlightingData

class PHPOpAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        when (element) {
            is PHPOpVarName -> {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element)
                    .textAttributes(PhpHighlightingData.VAR)
                    .create()
            }

            is PHPOpLineNumber -> {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element)
                    .textAttributes(PhpHighlightingData.NUMBER)
                    .create()
            }

            is PHPOpParameter -> {
                val attributesKey = when {
                    element.isVariable && element.parent !is PHPOpParenParameter -> PhpHighlightingData.VAR
                    element.text == Opcodes.THIS.name -> PhpHighlightingData.THIS_VAR
                    isPrimitive(element) -> PhpHighlightingData.PRIMITIVE_TYPE_HINT
                    else -> PhpHighlightingData.FUNCTION_CALL
                }

                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element)
                    .textAttributes(attributesKey)
                    .create()

            }

            is PHPOpFunctionName -> {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.textRange)
                    .textAttributes(PhpHighlightingData.FUNCTION)
                    .create()
            }

            is PHPOpClassName -> {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.textRange)
                    .textAttributes(PhpHighlightingData.CLASS)
                    .create()
            }

            is PHPOpMethodName -> {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.methodNameRange.shiftRight(element.textOffset))
                    .textAttributes(PhpHighlightingData.STATIC_METHOD_CALL)
                    .create()
            }

            is PHPOpPropertyName -> {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.propertyNameRange.shiftRight(element.textOffset))
                    .textAttributes(PhpHighlightingData.INSTANCE_FIELD)
                    .create()
            }

            is PHPOpPropertyHookName -> {
                holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element.propertyHookNameRange.shiftRight(element.textOffset))
                    .textAttributes(PhpHighlightingData.INSTANCE_METHOD_CALL)
                    .create()
            }
        }
    }

    private fun isPrimitive(element: PHPOpParameter): Boolean = Primitives.entries
        .map { it.name }
        .contains(element.text)
}