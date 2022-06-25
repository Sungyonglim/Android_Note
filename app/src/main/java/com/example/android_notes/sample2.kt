package com.example.android_notes

// 1. Lambda
/*
- 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명 함수
1) 메소드의 파라미터로 넘겨줄 수 있다.
2) return 값으로 사용할 수 가 있다.

- 람다의 기본정의
    - val lambdaName : Type = { argumentList -> codeBody }
*/

val square : (Int) -> (Int) = { it * it }

val nameAge = { name:String, age:Int ->
    "my name is $name I'm $age"
}

fun main() {
    val x = { number: Double -> number == 4.213 }
    println(invokeLambda(x))

    println(invokeLambda{ it > 2.32 }) //마지막 파라미터가 람다식일 경우 이런 함수이름 { } 형태가 나옴
}

// 2. 확장 함수
val pizza: String.() -> String = {
    "$this Pizza is the best"
}
fun extendString(name: String, age: Int): String {
    val intro : String.(Int) -> String = {
        "Im am $this and $it years old  "// this는 String을 가리키거 it은 매개벼누 iNT
    }
    return name.intro(age)

}

// 3. 람다의 Return
val calculator: (Int) -> String = {
    when(it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

// 4. 람다를 표현하는 다양한 방법
fun invokeLambda(lambda: (Double) -> Boolean): Boolean {
    return lambda(5.2342)
}