fun main() {
    /** when
     * 자바 또는 다른 대부분의 언어에서 사용하는 switch문과 비슷하다.
     * break를 사용하지 않고,
     * 정수 뿐만 아니라 다양한 타입의 값과 비교할 수 있어 더 유용하고 편리할 수 있다.
     */

    // 기본 문법
    val a = 2
    when(a){
        1 -> println("a는 1입니다.")
        2 -> println("a는 2입니다.")
        3 -> println("a는 3입니다.")
        else -> println("알 수 없는 숫자입니다.")
    }

    // 여러 조건 처리
    when(a){
        1, 2 -> println("a는 1 또는 2 입니다.")   // 1 || 2 와 같음
        3 -> println("a는 3 입니다.")
        else -> println("알 수 없는 숫자")
    }

    // 범위 조건 : "in 1 .. 5" 사용
    when(a){
        in 1 .. 5 -> println("a는 1에서 5 사이의 값")
        in 6 .. 10 -> println("a는 6에서 10 사이의 값")
    }

    // 값 할당. 코드 블럭 실행.
    val b = when(a) {
        1 -> {
            "a는 1입니다."
        }
        2 -> {
            println("코드 블럭 실행")
            "a는 2입니다."
        }
        3 -> "a는 3입니다."
        else -> "Unknown Number"
    }
    println(b)

    val c = function(1)
    println(c)

    val d = function(3)
    println(d)
}

// 함수형
fun function(a: Int) = when (a) {
    1 -> "1입니다."
    2 -> "2입니다."
    else -> "Unknown"
}

// if문도 함수형으로 사용할 수 있다.
fun function2(a: Int) = if(a == 2 || a == 1){
    println("a is 1 or 2")
} else{
    println("a is Unknown Number")
}