package com.github.xepozz.php_opcodes_language.language

import com.github.xepozz.php_opcodes_language.Opcodes
import com.github.xepozz.php_opcodes_language.Primitives
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpBlockName
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpLineNumber
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpParameter
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpParenParameter
import com.github.xepozz.php_opcodes_language.language.psi.PHPOpVarName
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.jetbrains.php.lang.highlighter.PhpHighlightingData

class PHPOpAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
//        println("Annotating $element: ${element.text}")
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

            is PHPOpBlockName -> {
                when {
                    element.isFqn -> {
                        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                            .range(element.textRange)
                            .textAttributes(PhpHighlightingData.FUNCTION)
                            .create()
                    }

                    element.isClassMethod -> {
                        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                            .range(
                                TextRange(
                                    element.text.indexOf("::") + 2,
                                    element.text.length
                                ).shiftRight(element.textRange.startOffset)
                            )
                            .textAttributes(PhpHighlightingData.FUNCTION_CALL)
                            .create()
                    }

                    element.isClassPropertyHook -> {
                        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                            .range(
                                TextRange(element.text.indexOf("::") + 2, element.text.lastIndexOf("::")).shiftRight(
                                    element.textRange.startOffset
                                )
                            )
                            .textAttributes(PhpHighlightingData.INSTANCE_FIELD)
                            .create()

                        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                            .range(
                                TextRange(
                                    element.text.lastIndexOf("::") + 2,
                                    element.text.length
                                ).shiftRight(element.textRange.startOffset)
                            )
                            .textAttributes(PhpHighlightingData.FUNCTION_CALL)
                            .create()
                    }
                }
            }
        }
    }

    private fun isPrimitive(element: PHPOpParameter): Boolean = Primitives.entries
        .map { it.name }
        .contains(element.text)
}