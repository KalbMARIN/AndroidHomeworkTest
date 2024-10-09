package com.practicum.androidhomeworktest

fun main() {

    val list: List<Int> = listOf(4, 4, 2)
    val list2: MutableList<Int> = mutableListOf(1, 2, 3)

    val mutableSet = mutableSetOf("", null)
    val set = setOf("", null)

    val mutableMap = mutableMapOf("key" to "pair")
    val map = mapOf("key" to "pair")

    println(list)
    println(list2)
}