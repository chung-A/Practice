package com.chung

object CountManager{
    var count:Int =0
}

data class User(val id: Int, var name: String)

fun main() {
    val count = CountManager.count
    println(count)
    val user = User(1, "Hello")
    println(user)
}

fun sum(a: Int, b: Int) = a + b

fun sum2(a: Int, b: Int): Int {
    return a + b
}
