package com.github.xepozz.php_opcodes_language.language.documentation

/**
 * @example https://phpdoctest.github.io/en/internals2.opcodes.list.html
 */
object OpcodesDictionary {
    private val directives = listOf(
        ParameterDoc(
            name = "T",
            number = 0,,
            description = """T-variable is a temporary variable, aimed to be pass the value between opcodes""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return time() + 1;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 INIT_FCALL 0 80 string("time")
                0001 V1 = DO_ICALL
                0002 T0 = ADD V1 int(1)
                0003 RETURN T0
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "V",
            number = 0,,
            description = """V-variable is a temporary variable, aimed to hold value of the called function""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return time();
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 INIT_FCALL 0 80 string("time")
                0001 V0 = DO_ICALL
                0002 RETURN V0
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "NOP",
            number = 0,,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ADD",
            number = 1,
            description = """Used for addition operations""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a + $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = ADD CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SUB",
            number = 2,
            description = """Used for subtraction operations""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a - $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = SUB CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "MUL",
            number = 3,
            description = """Used for multiply operations""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a * $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = MUL CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "DIV",
            number = 4,
            description = """Used for division operations""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a / $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = DIV CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "MOD",
            number = 5,
            description = """Used for modulo operations""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a % $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = MOD CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SL",
            number = 6,
            description = """Used for bitwise left shift operations""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a << $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = SL CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SR",
            number = 7,
            description = """Used for bitwise right shift operations""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a >> $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = SR CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "CONCAT",
            number = 8,
            description = """Used for concatenation operations""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a . $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = CONCAT CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "BW_OR",
            number = 9,
            description = """Used for bitwise "OR" operations""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a | $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = BW_OR CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "BW_AND",
            number = 10,
            description = """Used for bitwise "AND" operations""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a & $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = BW_AND CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "BW_XOR",
            number = 11,
            description = """Used for bitwise "XOR" operations""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a ^ $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = BW_XOR CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "POW",
            number = 12,
            description = """Used for exponentiation operations""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a ** $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = POW CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "BW_NOT",
            number = 13,
            description = """Used to perform bit reversal operations in a number""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return ~$a;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T1 = BW_NOT CV0($a)
                0001 RETURN T1
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "BOOL_NOT",
            number = 14,
            description = """**description is currently unavailable**""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "BOOL_XOR",
            number = 15,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "IS_IDENTICAL",
            number = 16,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "IS_NOT_IDENTICAL",
            number = 17,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "IS_EQUAL",
            number = 18,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "IS_NOT_EQUAL",
            number = 19,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "IS_SMALLER",
            number = 20,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "IS_SMALLER_OR_EQUAL",
            number = 21,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ASSIGN",
            number = 22,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ASSIGN_DIM",
            number = 23,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ASSIGN_OBJ",
            number = 24,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ASSIGN_STATIC_PROP",
            number = 25,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ASSIGN_OP",
            number = 26,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ASSIGN_DIM_OP",
            number = 27,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ASSIGN_OBJ_OP",
            number = 28,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ASSIGN_STATIC_PROP_OP",
            number = 29,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ASSIGN_REF",
            number = 30,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "QM_ASSIGN",
            number = 31,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ASSIGN_OBJ_REF",
            number = 32,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ASSIGN_STATIC_PROP_REF",
            number = 33,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "PRE_INC",
            number = 34,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "PRE_DEC",
            number = 35,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "POST_INC",
            number = 36,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "POST_DEC",
            number = 37,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "PRE_INC_STATIC_PROP",
            number = 38,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "PRE_DEC_STATIC_PROP",
            number = 39,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "POST_INC_STATIC_PROP",
            number = 40,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "POST_DEC_STATIC_PROP",
            number = 41,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "JMP",
            number = 42,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "JMPZ",
            number = 43,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "JMPNZ",
            number = 44,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "JMPZ_EX",
            number = 46,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "JMPNZ_EX",
            number = 47,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "CASE",
            number = 48,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "CHECK_VAR",
            number = 49,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SEND_VAR_NO_REF_EX",
            number = 50,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "CAST",
            number = 51,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "BOOL",
            number = 52,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FAST_CONCAT",
            number = 53,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ROPE_INIT",
            number = 54,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ROPE_ADD",
            number = 55,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ROPE_END",
            number = 56,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "BEGIN_SILENCE",
            number = 57,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "END_SILENCE",
            number = 58,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "INIT_FCALL_BY_NAME",
            number = 59,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "DO_FCALL",
            number = 60,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "INIT_FCALL",
            number = 61,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "RETURN",
            number = 62,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "RECV",
            number = 63,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "RECV_INIT",
            number = 64,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SEND_VAL",
            number = 65,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SEND_VAR_EX",
            number = 66,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SEND_REF",
            number = 67,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "NEW",
            number = 68,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "INIT_NS_FCALL_BY_NAME",
            number = 69,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FREE",
            number = 70,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "INIT_ARRAY",
            number = 71,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ADD_ARRAY_ELEMENT",
            number = 72,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "INCLUDE_OR_EVAL",
            number = 73,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "UNSET_VAR",
            number = 74,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "UNSET_DIM",
            number = 75,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "UNSET_OBJ",
            number = 76,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FE_RESET_R",
            number = 77,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FE_FETCH_R",
            number = 78,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_R",
            number = 80,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_DIM_R",
            number = 81,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_OBJ_R",
            number = 82,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_W",
            number = 83,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_DIM_W",
            number = 84,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_OBJ_W",
            number = 85,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_RW",
            number = 86,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_DIM_RW",
            number = 87,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_OBJ_RW",
            number = 88,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_IS",
            number = 89,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_DIM_IS",
            number = 90,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_OBJ_IS",
            number = 91,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_FUNC_ARG",
            number = 92,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_DIM_FUNC_ARG",
            number = 93,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_OBJ_FUNC_ARG",
            number = 94,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_UNSET",
            number = 95,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_DIM_UNSET",
            number = 96,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_OBJ_UNSET",
            number = 97,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_LIST_R",
            number = 98,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_CONSTANT",
            number = 99,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "CHECK_FUNC_ARG",
            number = 100,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "EXT_STMT",
            number = 101,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "EXT_FCALL_BEGIN",
            number = 102,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "EXT_FCALL_END",
            number = 103,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "EXT_NOP",
            number = 104,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "TICKS",
            number = 105,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SEND_VAR_NO_REF",
            number = 106,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "CATCH",
            number = 107,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "THROW",
            number = 108,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_CLASS",
            number = 109,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "CLONE",
            number = 110,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "RETURN_BY_REF",
            number = 111,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "INIT_METHOD_CALL",
            number = 112,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "INIT_STATIC_METHOD_CALL",
            number = 113,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ISSET_ISEMPTY_VAR",
            number = 114,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ISSET_ISEMPTY_DIM_OBJ",
            number = 115,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SEND_VAL_EX",
            number = 116,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SEND_VAR",
            number = 117,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "INIT_USER_CALL",
            number = 118,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SEND_ARRAY",
            number = 119,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SEND_USER",
            number = 120,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "STRLEN",
            number = 121,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "DEFINED",
            number = 122,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "TYPE_CHECK",
            number = 123,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "VERIFY_RETURN_TYPE",
            number = 124,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FE_RESET_RW",
            number = 125,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FE_FETCH_RW",
            number = 126,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FE_FREE",
            number = 127,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "INIT_DYNAMIC_CALL",
            number = 128,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "DO_ICALL",
            number = 129,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "DO_UCALL",
            number = 130,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "DO_FCALL_BY_NAME",
            number = 131,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "PRE_INC_OBJ",
            number = 132,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "PRE_DEC_OBJ",
            number = 133,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "POST_INC_OBJ",
            number = 134,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "POST_DEC_OBJ",
            number = 135,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ECHO",
            number = 136,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "OP_DATA",
            number = 137,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "INSTANCEOF",
            number = 138,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "GENERATOR_CREATE",
            number = 139,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "MAKE_REF",
            number = 140,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "DECLARE_FUNCTION",
            number = 141,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "DECLARE_LAMBDA_FUNCTION",
            number = 142,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "DECLARE_CONST",
            number = 143,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "DECLARE_CLASS",
            number = 144,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "DECLARE_CLASS_DELAYED",
            number = 145,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "DECLARE_ANON_CLASS",
            number = 146,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ADD_ARRAY_UNPACK",
            number = 147,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ISSET_ISEMPTY_PROP_OBJ",
            number = 148,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "HANDLE_EXCEPTION",
            number = 149,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "USER_OPCODE",
            number = 150,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ASSERT_CHECK",
            number = 151,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "JMP_SET",
            number = 152,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "UNSET_CV",
            number = 153,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ISSET_ISEMPTY_CV",
            number = 154,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_LIST_W",
            number = 155,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SEPARATE",
            number = 156,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_CLASS_NAME",
            number = 157,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "CALL_TRAMPOLINE",
            number = 158,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "DISCARD_EXCEPTION",
            number = 159,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "YIELD",
            number = 160,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "GENERATOR_RETURN",
            number = 161,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FAST_CALL",
            number = 162,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FAST_RET",
            number = 163,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "RECV_VARIADIC",
            number = 164,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SEND_UNPACK",
            number = 165,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "YIELD_FROM",
            number = 166,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "COPY_TMP",
            number = 167,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "BIND_GLOBAL",
            number = 168,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "COALESCE",
            number = 169,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SPACESHIP",
            number = 170,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FUNC_NUM_ARGS",
            number = 171,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FUNC_GET_ARGS",
            number = 172,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_STATIC_PROP_R",
            number = 173,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_STATIC_PROP_W",
            number = 174,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_STATIC_PROP_RW",
            number = 175,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_STATIC_PROP_IS",
            number = 176,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_STATIC_PROP_FUNC_ARG",
            number = 177,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_STATIC_PROP_UNSET",
            number = 178,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "UNSET_STATIC_PROP",
            number = 179,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ISSET_ISEMPTY_STATIC_PROP",
            number = 180,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_CLASS_CONSTANT",
            number = 181,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "BIND_LEXICAL",
            number = 182,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "BIND_STATIC",
            number = 183,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_THIS",
            number = 184,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SEND_FUNC_ARG",
            number = 185,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ISSET_ISEMPTY_THIS",
            number = 186,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SWITCH_LONG",
            number = 187,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "SWITCH_STRING",
            number = 188,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "IN_ARRAY",
            number = 189,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "COUNT",
            number = 190,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "GET_CLASS",
            number = 191,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "GET_CALLED_CLASS",
            number = 192,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "GET_TYPE",
            number = 193,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ARRAY_KEY_EXISTS",
            number = 194,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "MATCH",
            number = 195,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "CASE_STRICT",
            number = 196,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "MATCH_ERROR",
            number = 197,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "JMP_NULL",
            number = 198,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "CHECK_UNDEF_ARGS",
            number = 199,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FETCH_GLOBALS",
            number = 200,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "VERIFY_NEVER_TYPE",
            number = 201,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "CALLABLE_CONVERT",
            number = 202,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "BIND_INIT_STATIC_OR_JMP",
            number = 203,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FRAMELESS_ICALL_0",
            number = 204,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FRAMELESS_ICALL_1",
            number = 205,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FRAMELESS_ICALL_2",
            number = 206,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "FRAMELESS_ICALL_3",
            number = 207,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "JMP_FRAMELESS",
            number = 208,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "INIT_PARENT_PROPERTY_HOOK_CALL",
            number = 209,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "DECLARE_ATTRIBUTED_CONST",
            number = 210,
            description = ,
            // language=injectablephp
            examplePhp = $$"""
                <?php

                //
                // Currently Unavailable
                //
                // You can help with the documentation of this opcode by
                // submitting a PR to 
                // https://github.com/j-plugins/php-opcodes-language-plugin
                //
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                ;
                ; Currently Unavailable
                ;
                ; You can help with the documentation of this opcode by
                ; submitting a PR to 
                ; https://github.com/j-plugins/php-opcodes-language-plugin
                ;
            """.trimIndent(),
        ),
    ).associateBy { it.name }

    fun getDocumentation(directiveName: String): ParameterDoc? {
        return directives[directiveName]
    }
}