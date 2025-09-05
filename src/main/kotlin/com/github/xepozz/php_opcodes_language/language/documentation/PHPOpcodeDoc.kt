package com.github.xepozz.php_opcodes_language.language.documentation

data class ParameterDoc(
    val name: String,
    val number: Int,
    val description: String = """**description is currently unavailable**""",
    val examplePhp: String? = $$"""
        <?php

        //
        // Currently Unavailable
        //
        // You can help with the documentation of this opcode by
        // submitting a PR to 
        // https://github.com/j-plugins/php-opcodes-language-plugin
        //
    """.trimIndent(),
    val exampleOpcode: String? = $$"""
        ;
        ; Currently Unavailable
        ;
        ; You can help with the documentation of this opcode by
        ; submitting a PR to 
        ; https://github.com/j-plugins/php-opcodes-language-plugin
        ;
    """.trimIndent()
)