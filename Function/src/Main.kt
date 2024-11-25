fun main() {
    /**
     * Function
     * 코드를 미리 작성해놓고 필요할 때 불러 쓰는 개념
     */
    val d = firstFunction(30, 40)
//    println("d는 $d 입니다")

//    secondFunction(200, 400)    // 전달인자가 있을 떄
//    secondFunction()    // 전달인자가 없을 때

//    function()
//    function(100)
//    function(200.00)
//    function(200,400)

    outer()
//    inner() // 함수 외부에서 호출하게 되면 에러 발생
}

fun firstFunction(a: Int, b: Int): Int {
    // 수행문
    val c = a + b
//    println(c)
    return c;
}

fun secondFunction(a: Int = 100, b: Int = 200) {
    println("secondFunction ${a + b}")
}

/** 함수 오버로딩
 *
 */
fun function(){
    println("매개변수 없을 때")
}

fun function(a: Int){
    println("매개변수가 정수 하나일 때")
}

fun function(a: Double){
    println("매개변수가 실수 하나일 때")
}

fun function(a: Int, b: Int){
    println("매개변수가 정수 두 개 일 때, $a, $b")
}

/** 지역함수
 * 함수 안에 함수 정의 및 호출
 * 함수 밖에서는 호출 안됨
 */
fun outer(){
    println("함수 outer() 호출")

    fun inner(){
        println("함수 inner() 호출")
    }

    inner()
}










