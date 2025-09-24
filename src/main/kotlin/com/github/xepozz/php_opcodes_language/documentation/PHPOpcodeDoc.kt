package com.github.xepozz.php_opcodes_language.documentation

data class ParameterDoc(
    val name: String,
    val number: Int,
    val description: String? = null,
    val examplePhp: String? = null,
    val exampleOpcode: String? = null
)