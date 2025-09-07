package com.github.xepozz.php_opcodes_language

enum class Opcodes() {
    INIT_NS_FCALL_BY_NAME,
    INIT_FCALL,
    INIT_FCALL_BY_NAME,
    NEW,
    FETCH_CLASS_CONSTANT,
    DECLARE_CLASS_DELAYED,
    SEND_VAL_EX,
    INIT_METHOD_CALL,
    INIT_STATIC_METHOD_CALL,
    FETCH_OBJ_R,
    ASSIGN_OBJ,
    RETURN,
    THIS,
    EXT_STMT;

    companion object {
        val selfReference = listOf(
            RETURN,
            THIS,
            EXT_STMT,
        )
    }
}
