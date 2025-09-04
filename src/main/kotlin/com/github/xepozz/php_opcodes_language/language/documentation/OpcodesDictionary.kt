package com.github.xepozz.php_opcodes_language.language.documentation

/**
 * @example https://phpdoctest.github.io/en/internals2.opcodes.list.html
 */
object OpcodesDictionary {
    private val directives = listOf(
        ParameterDoc(
            name = "T",
            number = 0,
            description = """T-variable is a temporary variable, aimed to be pass the value between opcodes""",
            // language=injectablephp
            examplePhp = $$"""
                <?php
                $c = time() + 1;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                $_main:
                
                0000 EXT_STMT
                0001 INIT_FCALL 0 96 string("time")
                0002 V1 = DO_ICALL
                0003 T2 = ADD V1 int(1)
                0004 ASSIGN CV0($c) T2
                0005 RETURN int(1)
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "V",
            number = 0,
            description = """V-variable is a temporary variable, aimed to hold value of the called function""",
            // language=injectablephp
            examplePhp = $$"""
                <?php
                echo time();
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                $_main:
                
                0000 EXT_STMT
                0001 INIT_FCALL 0 96 string("time")
                0002 V0 = DO_ICALL
                0003 ECHO V0
                0004 RETURN int(1)
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ADD",
            number = 1,
            description = """Adds "value1" to "value2" and stores the result into "result"""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                $a = 1;
                $b = 2;
                $c = $a + $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                $_main:
                
                0000 EXT_STMT
                0001 ASSIGN CV0($a) int(1)
                0002 EXT_STMT
                0003 ASSIGN CV1($b) int(2)
                0004 EXT_STMT
                0005 T5 = ADD CV0($a) CV1($b)
                0006 ASSIGN CV2($c) T5
                0007 RETURN int(1)
            """.trimIndent(),
        ),
    ).associateBy { it.name }

    fun getDocumentation(directiveName: String): ParameterDoc? {
        return directives[directiveName]
    }
}