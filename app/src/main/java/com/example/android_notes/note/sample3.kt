package com.example.android_notes.note

import java.lang.Integer.parseInt
import java.lang.NumberFormatException

fun main() {
/*    val items: List<String> = listOf("a", "b", "c")
    var index = 0
    // list 반복
    for (item in items) {
        println(item)
    }

    // list while문 반복
    while(index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
    // list 인덱스 접근
    for(index in items.indices) {
        println("index: $index, values: ${items[index]}")
    }*/

    /*==============================================*/

/*
    // 범위 활용
    val x = 10
    val y = 9
    val list = listOf("a", "b", "c")
    if(x in 1..y+1) {
        println("범위 안")
    }

    // 1..2
    if(-1 !in 1..list.lastIndex) {
        println("-1은 범위 안에 없다")
    }

    // list.size -> 3, list.indices 0..2
    if(list.size !in list.indices){
        println("리스트 인덱스 넘어갔다")
    }
*/
    /*==============================================*/

/*
    // for 문
    for(x in 1..10 step 2) {
        println(x)
    }

    for(x in 9 downTo 0){
        println(x)
    }

    for(x in 9 downTo 0 step 2){
        println(x)
    } //9, 7, 5, 3, 1
*/

    /*==============================================*/

/*
    // setOf
    val items = setOf("apple", "banana", "kiwi")

    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
*/
    /*==============================================*/

/*
    // listOf Attribute
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter {it.startsWith("a")} // a로 시작하는 item
        .sortedBy{ it } // 정렬
        .map {it.toUpperCase()} // 대문자로 변경
        .forEach { println(it) }
*/

}

/*==============================================*/

/*// when 활용
// 1
fun describe(obj: Any): String {
    return when(obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Double -> "Long"
        !is String -> "Not a String"
        else -> "Unknown"
    }
}
//2
fun describe2(obj: Any): String =
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Double -> "Long"
        !is String -> "Not a String"
        else -> "Unknown"
    }*/


/*==============================================*/

/*
// 문자열 길이 측정 -> 문자열이 아니면 null 반환
fun getStringLenghth(obj: Any): Int? {
    if(obj is String) {
        return obj.length
    }
    return null
}*/

/*==============================================*/

/*
// string -> int로 변경 단, null일 경우 null 반환
fun parseInt(str: String): Int? {
    var myNum: Int? = null

    try{ myNum = str.toInt()}
    // NumberFormatException -> 숫자가 아니면 실행
    catch (nfe: NumberFormatException) {return null}

    return myNum
}*/

/*==============================================*/

/* // Replace
fun strReplace() {
    val str = "코로나 조심하세요"

    // Replace
    var str1 = "${str.replace(" 조심하세요 ", " 이겨내요 ")}!!"
    var str2 = str.replace("조싱하세요","이겨내요") + "!!"
}*/
