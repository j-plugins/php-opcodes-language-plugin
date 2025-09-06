package com.github.xepozz.php_opcodes_language

object ReflectionUtil {
    inline fun <reified T> callMethodOrNull(`object`: Any, methodName: String, vararg args: Any?): T? {
        return try {
            val method = `object`::class.java.getDeclaredMethod(methodName, *args.map { it?.javaClass }.toTypedArray())
            method.isAccessible = true
            method.invoke(`object`, *args) as? T
        } catch (e: Exception) {
            println("error: $e, arguments: $`object`, $methodName, ${args.joinToString(",")}")
            null
        }
    }
}

