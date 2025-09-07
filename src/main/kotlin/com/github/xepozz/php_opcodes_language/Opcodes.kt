package com.github.xepozz.php_opcodes_language

enum class Opcodes() {
    INIT_NS_FCALL_BY_NAME,
    INIT_FCALL,
    NEW,
    FETCH_CLASS_CONSTANT,
    DECLARE_CLASS_DELAYED,
    SEND_VAL_EX,
    INIT_METHOD_CALL,
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
