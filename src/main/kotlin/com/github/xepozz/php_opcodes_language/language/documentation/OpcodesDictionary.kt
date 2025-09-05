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
            description = """Used for logical negation""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return !$a;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T1 = BOOL_NOT CV0($a)
                0001 RETURN T1
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "BOOL_XOR",
            number = 15,
            description = """Used for logical "XOR" operations""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a xor $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = BOOL_XOR CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "IS_IDENTICAL",
            number = 16,
            description = """Used for logical strict identity comparison""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a === $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = IS_IDENTICAL CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "IS_NOT_IDENTICAL",
            number = 17,
            description = """Used for logical strict comparison of non-identity""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a !== $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = IS_NOT_IDENTICAL CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "IS_EQUAL",
            number = 18,
            description = """Used for logical non-strict equivalence comparison""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a == $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = IS_EQUAL CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "IS_NOT_EQUAL",
            number = 19,
            description = """Used for logical non-strict comparison of non-equivalence""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a != $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = IS_NOT_EQUAL CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "IS_SMALLER",
            number = 20,
            description = """Used for logical "less than" comparison""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a < $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = IS_SMALLER CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "IS_SMALLER_OR_EQUAL",
            number = 21,
            description = """Used for logical "less than or equal" comparison""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a <= $b;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T2 = IS_SMALLER_OR_EQUAL CV0($a) CV1($b)
                0001 RETURN T2
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ASSIGN",
            number = 22,
            description = """Used to assign a value to a variable""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a = 42;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T1 = ASSIGN CV0($a) int(42)
                0001 RETURN T1
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ASSIGN_DIM",
            number = 23,
            description = """Used to select an array element for further assignment of a value""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a[0] = 42;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T1 = ASSIGN_DIM CV0($a) int(0)
                0001 OP_DATA int(42)
                0002 RETURN T1
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ASSIGN_OBJ",
            number = 24,
            description = """Used to select an object's property for further assignment of a value""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return $a->property = 42;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T1 = ASSIGN_OBJ CV0($a) string("property")
                0001 OP_DATA int(42)
                0002 RETURN T1
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ASSIGN_STATIC_PROP",
            number = 25,
            description = """Used to select a static property of a class for further assignment of a value to it""",
            // language=injectablephp
            examplePhp = $$"""
                <?php

                return Example::$property = 42;
            """.trimIndent(),
            // language="PHP Opcodes"
            exampleOpcode = $$"""
                0000 T0 = ASSIGN_STATIC_PROP string("property") string("Example")
                0001 OP_DATA int(42)
                0002 RETURN T0
            """.trimIndent(),
        ),
        ParameterDoc(
            name = "ASSIGN_OP",
            number = 26,
        ),
        ParameterDoc(
            name = "ASSIGN_DIM_OP",
            number = 27,
        ),
        ParameterDoc(
            name = "ASSIGN_OBJ_OP",
            number = 28,
        ),
        ParameterDoc(
            name = "ASSIGN_STATIC_PROP_OP",
            number = 29,
        ),
        ParameterDoc(
            name = "ASSIGN_REF",
            number = 30,
        ),
        ParameterDoc(
            name = "QM_ASSIGN",
            number = 31,
        ),
        ParameterDoc(
            name = "ASSIGN_OBJ_REF",
            number = 32,
        ),
        ParameterDoc(
            name = "ASSIGN_STATIC_PROP_REF",
            number = 33,
        ),
        ParameterDoc(
            name = "PRE_INC",
            number = 34,
        ),
        ParameterDoc(
            name = "PRE_DEC",
            number = 35,
        ),
        ParameterDoc(
            name = "POST_INC",
            number = 36,
        ),
        ParameterDoc(
            name = "POST_DEC",
            number = 37,
        ),
        ParameterDoc(
            name = "PRE_INC_STATIC_PROP",
            number = 38,
        ),
        ParameterDoc(
            name = "PRE_DEC_STATIC_PROP",
            number = 39,
        ),
        ParameterDoc(
            name = "POST_INC_STATIC_PROP",
            number = 40,
        ),
        ParameterDoc(
            name = "POST_DEC_STATIC_PROP",
            number = 41,
        ),
        ParameterDoc(
            name = "JMP",
            number = 42,
        ),
        ParameterDoc(
            name = "JMPZ",
            number = 43,
        ),
        ParameterDoc(
            name = "JMPNZ",
            number = 44,
        ),
        ParameterDoc(
            name = "JMPZ_EX",
            number = 46,
        ),
        ParameterDoc(
            name = "JMPNZ_EX",
            number = 47,
        ),
        ParameterDoc(
            name = "CASE",
            number = 48,
        ),
        ParameterDoc(
            name = "CHECK_VAR",
            number = 49,
        ),
        ParameterDoc(
            name = "SEND_VAR_NO_REF_EX",
            number = 50,
        ),
        ParameterDoc(
            name = "CAST",
            number = 51,
        ),
        ParameterDoc(
            name = "BOOL",
            number = 52,
        ),
        ParameterDoc(
            name = "FAST_CONCAT",
            number = 53,
        ),
        ParameterDoc(
            name = "ROPE_INIT",
            number = 54,
        ),
        ParameterDoc(
            name = "ROPE_ADD",
            number = 55,
        ),
        ParameterDoc(
            name = "ROPE_END",
            number = 56,
        ),
        ParameterDoc(
            name = "BEGIN_SILENCE",
            number = 57,
        ),
        ParameterDoc(
            name = "END_SILENCE",
            number = 58,
        ),
        ParameterDoc(
            name = "INIT_FCALL_BY_NAME",
            number = 59,
        ),
        ParameterDoc(
            name = "DO_FCALL",
            number = 60,
        ),
        ParameterDoc(
            name = "INIT_FCALL",
            number = 61,
        ),
        ParameterDoc(
            name = "RETURN",
            number = 62,
        ),
        ParameterDoc(
            name = "RECV",
            number = 63,
        ),
        ParameterDoc(
            name = "RECV_INIT",
            number = 64,
        ),
        ParameterDoc(
            name = "SEND_VAL",
            number = 65,
        ),
        ParameterDoc(
            name = "SEND_VAR_EX",
            number = 66,
        ),
        ParameterDoc(
            name = "SEND_REF",
            number = 67,
        ),
        ParameterDoc(
            name = "NEW",
            number = 68,
        ),
        ParameterDoc(
            name = "INIT_NS_FCALL_BY_NAME",
            number = 69,
        ),
        ParameterDoc(
            name = "FREE",
            number = 70,
        ),
        ParameterDoc(
            name = "INIT_ARRAY",
            number = 71,
        ),
        ParameterDoc(
            name = "ADD_ARRAY_ELEMENT",
            number = 72,
        ),
        ParameterDoc(
            name = "INCLUDE_OR_EVAL",
            number = 73,
        ),
        ParameterDoc(
            name = "UNSET_VAR",
            number = 74,
        ),
        ParameterDoc(
            name = "UNSET_DIM",
            number = 75,
        ),
        ParameterDoc(
            name = "UNSET_OBJ",
            number = 76,
        ),
        ParameterDoc(
            name = "FE_RESET_R",
            number = 77,
        ),
        ParameterDoc(
            name = "FE_FETCH_R",
            number = 78,
        ),
        ParameterDoc(
            name = "FETCH_R",
            number = 80,
        ),
        ParameterDoc(
            name = "FETCH_DIM_R",
            number = 81,
        ),
        ParameterDoc(
            name = "FETCH_OBJ_R",
            number = 82,
        ),
        ParameterDoc(
            name = "FETCH_W",
            number = 83,
        ),
        ParameterDoc(
            name = "FETCH_DIM_W",
            number = 84,
        ),
        ParameterDoc(
            name = "FETCH_OBJ_W",
            number = 85,
        ),
        ParameterDoc(
            name = "FETCH_RW",
            number = 86,
        ),
        ParameterDoc(
            name = "FETCH_DIM_RW",
            number = 87,
        ),
        ParameterDoc(
            name = "FETCH_OBJ_RW",
            number = 88,
        ),
        ParameterDoc(
            name = "FETCH_IS",
            number = 89,
        ),
        ParameterDoc(
            name = "FETCH_DIM_IS",
            number = 90,
        ),
        ParameterDoc(
            name = "FETCH_OBJ_IS",
            number = 91,
        ),
        ParameterDoc(
            name = "FETCH_FUNC_ARG",
            number = 92,
        ),
        ParameterDoc(
            name = "FETCH_DIM_FUNC_ARG",
            number = 93,
        ),
        ParameterDoc(
            name = "FETCH_OBJ_FUNC_ARG",
            number = 94,
        ),
        ParameterDoc(
            name = "FETCH_UNSET",
            number = 95,
        ),
        ParameterDoc(
            name = "FETCH_DIM_UNSET",
            number = 96,
        ),
        ParameterDoc(
            name = "FETCH_OBJ_UNSET",
            number = 97,
        ),
        ParameterDoc(
            name = "FETCH_LIST_R",
            number = 98,
        ),
        ParameterDoc(
            name = "FETCH_CONSTANT",
            number = 99,
        ),
        ParameterDoc(
            name = "CHECK_FUNC_ARG",
            number = 100,
        ),
        ParameterDoc(
            name = "EXT_STMT",
            number = 101,
        ),
        ParameterDoc(
            name = "EXT_FCALL_BEGIN",
            number = 102,
        ),
        ParameterDoc(
            name = "EXT_FCALL_END",
            number = 103,
        ),
        ParameterDoc(
            name = "EXT_NOP",
            number = 104,
        ),
        ParameterDoc(
            name = "TICKS",
            number = 105,
        ),
        ParameterDoc(
            name = "SEND_VAR_NO_REF",
            number = 106,
        ),
        ParameterDoc(
            name = "CATCH",
            number = 107,
        ),
        ParameterDoc(
            name = "THROW",
            number = 108,
        ),
        ParameterDoc(
            name = "FETCH_CLASS",
            number = 109,
        ),
        ParameterDoc(
            name = "CLONE",
            number = 110,
        ),
        ParameterDoc(
            name = "RETURN_BY_REF",
            number = 111,
        ),
        ParameterDoc(
            name = "INIT_METHOD_CALL",
            number = 112,
        ),
        ParameterDoc(
            name = "INIT_STATIC_METHOD_CALL",
            number = 113,
        ),
        ParameterDoc(
            name = "ISSET_ISEMPTY_VAR",
            number = 114,
        ),
        ParameterDoc(
            name = "ISSET_ISEMPTY_DIM_OBJ",
            number = 115,
        ),
        ParameterDoc(
            name = "SEND_VAL_EX",
            number = 116,
        ),
        ParameterDoc(
            name = "SEND_VAR",
            number = 117,
        ),
        ParameterDoc(
            name = "INIT_USER_CALL",
            number = 118,
        ),
        ParameterDoc(
            name = "SEND_ARRAY",
            number = 119,
        ),
        ParameterDoc(
            name = "SEND_USER",
            number = 120,
        ),
        ParameterDoc(
            name = "STRLEN",
            number = 121,
        ),
        ParameterDoc(
            name = "DEFINED",
            number = 122,
        ),
        ParameterDoc(
            name = "TYPE_CHECK",
            number = 123,
        ),
        ParameterDoc(
            name = "VERIFY_RETURN_TYPE",
            number = 124,
        ),
        ParameterDoc(
            name = "FE_RESET_RW",
            number = 125,
        ),
        ParameterDoc(
            name = "FE_FETCH_RW",
            number = 126,
        ),
        ParameterDoc(
            name = "FE_FREE",
            number = 127,
        ),
        ParameterDoc(
            name = "INIT_DYNAMIC_CALL",
            number = 128,
        ),
        ParameterDoc(
            name = "DO_ICALL",
            number = 129,
        ),
        ParameterDoc(
            name = "DO_UCALL",
            number = 130,
        ),
        ParameterDoc(
            name = "DO_FCALL_BY_NAME",
            number = 131,
        ),
        ParameterDoc(
            name = "PRE_INC_OBJ",
            number = 132,
        ),
        ParameterDoc(
            name = "PRE_DEC_OBJ",
            number = 133,
        ),
        ParameterDoc(
            name = "POST_INC_OBJ",
            number = 134,
        ),
        ParameterDoc(
            name = "POST_DEC_OBJ",
            number = 135,
        ),
        ParameterDoc(
            name = "ECHO",
            number = 136,
        ),
        ParameterDoc(
            name = "OP_DATA",
            number = 137,
        ),
        ParameterDoc(
            name = "INSTANCEOF",
            number = 138,
        ),
        ParameterDoc(
            name = "GENERATOR_CREATE",
            number = 139,
        ),
        ParameterDoc(
            name = "MAKE_REF",
            number = 140,
        ),
        ParameterDoc(
            name = "DECLARE_FUNCTION",
            number = 141,
        ),
        ParameterDoc(
            name = "DECLARE_LAMBDA_FUNCTION",
            number = 142,
        ),
        ParameterDoc(
            name = "DECLARE_CONST",
            number = 143,
        ),
        ParameterDoc(
            name = "DECLARE_CLASS",
            number = 144,
        ),
        ParameterDoc(
            name = "DECLARE_CLASS_DELAYED",
            number = 145,
        ),
        ParameterDoc(
            name = "DECLARE_ANON_CLASS",
            number = 146,
        ),
        ParameterDoc(
            name = "ADD_ARRAY_UNPACK",
            number = 147,
        ),
        ParameterDoc(
            name = "ISSET_ISEMPTY_PROP_OBJ",
            number = 148,
        ),
        ParameterDoc(
            name = "HANDLE_EXCEPTION",
            number = 149,
        ),
        ParameterDoc(
            name = "USER_OPCODE",
            number = 150,
        ),
        ParameterDoc(
            name = "ASSERT_CHECK",
            number = 151,
        ),
        ParameterDoc(
            name = "JMP_SET",
            number = 152,
        ),
        ParameterDoc(
            name = "UNSET_CV",
            number = 153,
        ),
        ParameterDoc(
            name = "ISSET_ISEMPTY_CV",
            number = 154,
        ),
        ParameterDoc(
            name = "FETCH_LIST_W",
            number = 155,
        ),
        ParameterDoc(
            name = "SEPARATE",
            number = 156,
        ),
        ParameterDoc(
            name = "FETCH_CLASS_NAME",
            number = 157,
        ),
        ParameterDoc(
            name = "CALL_TRAMPOLINE",
            number = 158,
        ),
        ParameterDoc(
            name = "DISCARD_EXCEPTION",
            number = 159,
        ),
        ParameterDoc(
            name = "YIELD",
            number = 160,
        ),
        ParameterDoc(
            name = "GENERATOR_RETURN",
            number = 161,
        ),
        ParameterDoc(
            name = "FAST_CALL",
            number = 162,
        ),
        ParameterDoc(
            name = "FAST_RET",
            number = 163,
        ),
        ParameterDoc(
            name = "RECV_VARIADIC",
            number = 164,
        ),
        ParameterDoc(
            name = "SEND_UNPACK",
            number = 165,
        ),
        ParameterDoc(
            name = "YIELD_FROM",
            number = 166,
        ),
        ParameterDoc(
            name = "COPY_TMP",
            number = 167,
        ),
        ParameterDoc(
            name = "BIND_GLOBAL",
            number = 168,
        ),
        ParameterDoc(
            name = "COALESCE",
            number = 169,
        ),
        ParameterDoc(
            name = "SPACESHIP",
            number = 170,
        ),
        ParameterDoc(
            name = "FUNC_NUM_ARGS",
            number = 171,
        ),
        ParameterDoc(
            name = "FUNC_GET_ARGS",
            number = 172,
        ),
        ParameterDoc(
            name = "FETCH_STATIC_PROP_R",
            number = 173,
        ),
        ParameterDoc(
            name = "FETCH_STATIC_PROP_W",
            number = 174,
        ),
        ParameterDoc(
            name = "FETCH_STATIC_PROP_RW",
            number = 175,
        ),
        ParameterDoc(
            name = "FETCH_STATIC_PROP_IS",
            number = 176,
        ),
        ParameterDoc(
            name = "FETCH_STATIC_PROP_FUNC_ARG",
            number = 177,
        ),
        ParameterDoc(
            name = "FETCH_STATIC_PROP_UNSET",
            number = 178,
        ),
        ParameterDoc(
            name = "UNSET_STATIC_PROP",
            number = 179,
        ),
        ParameterDoc(
            name = "ISSET_ISEMPTY_STATIC_PROP",
            number = 180,
        ),
        ParameterDoc(
            name = "FETCH_CLASS_CONSTANT",
            number = 181,
        ),
        ParameterDoc(
            name = "BIND_LEXICAL",
            number = 182,
        ),
        ParameterDoc(
            name = "BIND_STATIC",
            number = 183,
        ),
        ParameterDoc(
            name = "FETCH_THIS",
            number = 184,
        ),
        ParameterDoc(
            name = "SEND_FUNC_ARG",
            number = 185,
        ),
        ParameterDoc(
            name = "ISSET_ISEMPTY_THIS",
            number = 186,
        ),
        ParameterDoc(
            name = "SWITCH_LONG",
            number = 187,
        ),
        ParameterDoc(
            name = "SWITCH_STRING",
            number = 188,
        ),
        ParameterDoc(
            name = "IN_ARRAY",
            number = 189,
        ),
        ParameterDoc(
            name = "COUNT",
            number = 190,
        ),
        ParameterDoc(
            name = "GET_CLASS",
            number = 191,
        ),
        ParameterDoc(
            name = "GET_CALLED_CLASS",
            number = 192,
        ),
        ParameterDoc(
            name = "GET_TYPE",
            number = 193,
        ),
        ParameterDoc(
            name = "ARRAY_KEY_EXISTS",
            number = 194,
        ),
        ParameterDoc(
            name = "MATCH",
            number = 195,
        ),
        ParameterDoc(
            name = "CASE_STRICT",
            number = 196,
        ),
        ParameterDoc(
            name = "MATCH_ERROR",
            number = 197,
        ),
        ParameterDoc(
            name = "JMP_NULL",
            number = 198,
        ),
        ParameterDoc(
            name = "CHECK_UNDEF_ARGS",
            number = 199,
        ),
        ParameterDoc(
            name = "FETCH_GLOBALS",
            number = 200,
        ),
        ParameterDoc(
            name = "VERIFY_NEVER_TYPE",
            number = 201,
        ),
        ParameterDoc(
            name = "CALLABLE_CONVERT",
            number = 202,
        ),
        ParameterDoc(
            name = "BIND_INIT_STATIC_OR_JMP",
            number = 203,
        ),
        ParameterDoc(
            name = "FRAMELESS_ICALL_0",
            number = 204,
        ),
        ParameterDoc(
            name = "FRAMELESS_ICALL_1",
            number = 205,
        ),
        ParameterDoc(
            name = "FRAMELESS_ICALL_2",
            number = 206,
        ),
        ParameterDoc(
            name = "FRAMELESS_ICALL_3",
            number = 207,
        ),
        ParameterDoc(
            name = "JMP_FRAMELESS",
            number = 208,
        ),
        ParameterDoc(
            name = "INIT_PARENT_PROPERTY_HOOK_CALL",
            number = 209,
        ),
        ParameterDoc(
            name = "DECLARE_ATTRIBUTED_CONST",
            number = 210,
        ),
    ).associateBy { it.name }

    fun getDocumentation(directiveName: String): ParameterDoc? {
        return directives[directiveName]
    }
}