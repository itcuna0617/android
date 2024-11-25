fun main() {
    /** 조건문
     * IF
     */

    // 기본 if문 : if 문의 조건식이 참일 때만 내부의 코드를 실행한다.
//    val a = 10
//    if(a == 10){
//        println("a는 10입니다.")
//    }

    // else문 : 조건식이 참이 아닐 때 수행한다.
//    if(a == 11){
//        println("a는 11입니다")
//    } else {
//        println("a는 11이 아닙니다.")
//    }

    // else if문 : 순차적으로 조건식을 판별하고 참인 else if문의 코드를 수행하고 끝난다.
//    if(a == 11){
//        println("a는 11입니다.")
//    } else if(a == 12){
//        println("a는 12입니다.")
//    } else{
//        println("a는 11, 12가 아닙니다.")
//    }

    // 모든 조건을 만족해야 할 경우
//    val a2 = 10
//    val b2 = 20
//    if (a2 == 10 && b2 == 20 && b2 == 30){
//        println("a2는 10이고, b2는 20입니다.")
//    }

    // 하나의 조건만 만족해도 되는 경우
//    if(a2 == 10 || b2 == 20 || b2 == 30){
//        println("a2가 10이거나, 또는 b2가 30입니다.")
//    }

    // if문을 활용한 변수 값 설정
    var a3 = 10
    var b3 = ""
//    if(a3 == 10){
//        b3 = "10입니다."
//    } else{
//        b3 = "10 아입니다."
//    }
//    println("a3는 $b3")

    var c3 = if(a3 == 10) "10입니다." else "10이 아닙니다."
    // 쉽게 변수를 선언하면서 조건에 따라 값을 할당할 수 있다.
    // 나중에 null 값이 아닐 경우에만 값을 저장하는 등 실무에 매우 유용.(약간 자바의 삼항 연산자 느낌인듯)
    println("a3는 $c3")

    var c6 = if(a3 == 10){      // 중괄호를 통해 코드를 보기 쉽게 개행
        println("실행 코드 블럭") // 조건식에 만족하면 코드 실행도 가능
        println("실행 코드 블럭")
        println("실행 코드 블럭")
        "10입니다."    // 마지막 값만 변수에 저장
    } else{
        println("실행 코드 블럭")
        println("실행 코드 블럭")
        "10이 아닙니다."
    }









}