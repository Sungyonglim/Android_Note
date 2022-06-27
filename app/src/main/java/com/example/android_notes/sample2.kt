package com.example.android_notes

// 1. Lambda
/*
- 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명 함수
1) 메소드의 파라미터로 넘겨줄 수 있다.
2) return 값으로 사용할 수 가 있다.

- 람다의 기본정의
    - val lambdaName : Type = { argumentList -> codeBody }
*/
// ex)
val square : (Int) -> (Int)  = {number -> number * number}

val nameAge = {name: String, age: Int ->
    "My name is $name, I'm $age"
}

//=================================================================================

// 2. 확장함수
// ex)
val x: String.() -> String = {
    "$this Kotlin is the best!"
}

fun extendString(name: String, age: Int): String {
    // this가 가리키는 것은 확장함수가 불러줄 object(string) it이 가리키는 것은 파라미터(Int)
    val introduce: String.(Int) -> String = {"I am $this and $it years old"}
    return name.introduce(age)
}

//=================================================================================

//3. 람다의 return
// ex)
val calculate : (Int) -> String = {
    when(it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "prefect"
        else -> "Nothing"
    }
}

//=================================================================================

// 4. 람다를 표현하는 여러가지 방법
// ex)
fun invokeLambda(x: (Double) -> Boolean): Boolean {
    return x(5.234)
}
/* Output
val x = {number: Double ->
    number == 4.3213
}

println(invokeLambda{ it > 63 })
*/

//=================================================================================

// 5. data class -> 객체에 내용을 자주 볼 경우 좋음

// 데이터 클래스를 정의하고 컴파일하면 메소드(toString(), hashCode(), equals(), copy())들이 만들어짐
data class Ticket(val companyName: String, val name: String, var date: String, var seatNumber: Int)
//println(ticketA) // data class는 데이터 값이 나옴

class TicketNormal(val companyName: String, val name: String, var date: String, var seatNumber: Int)
//println(ticketB) // 일단 클래스는 클래스 주솟값이 나옴

// 6. companion Obejct
class Book private constructor(val id: Int, val name: String) {
    companion object BookFactory : IdProvider{
        override fun getId() = 4444

        val myBook = "new book"
        fun create() = Book(getId(), myBook)
    }
}

interface IdProvider {
    fun getId() : Int
}
// Output
/*
    var book = Book.create()
    val bookId = Book.BookFactory.getId()
    val bookName = Book.BookFactory.myBook
    println("${bookId}, ${bookName}")
* */

//=================================================================================

// 6. Object

// Singleton Pattern
object CarFactory {
    val cars2 = arrayListOf<Car>()
    val cars = mutableListOf<Car>()
    fun makeCar(horsePower: Int): Car{
        val car = Car(horsePower)
        cars.add(car)
        cars2.add(car)
        return car
    }
}

data class Car(val horsePower: Int)

fun main() {
    val car = CarFactory.makeCar(10)
    val car23 = CarFactory.makeCar(200)

    println(car)
    println(car23)
    println(CarFactory.cars.size.toString())
    println(CarFactory.cars2.size.toString())
}
