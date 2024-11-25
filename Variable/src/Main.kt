fun main() {

    // 리터럴 : 변수에 담기는 값 자체
    val variable = "variable"   // "variable" 자체가 리터럴
    val int = 3 // 3 자체가 리터럴

    // 정수 리터럴과 자릿수 구분
    var int2 = 222_222

    // 실수 리터럴
//    println(33.33)  // F가 없으면 더블형 변수 -> 8 바이트
//    println(33.33F)  // F가 있으면 플롯형 변수 -> 4 바이트

    // 문자열과 문자
    val string: String = "문자열"
    val char: Char = 'a'

    // 논리값
    val t: Boolean = true
    val f: Boolean = false

    // Raw String (앞의 공백도 그대로 출력됨 -> 이를 제거하기 위해서는 아래처럼 작성)
//    println("""
//        이렇게 쓰면 여러줄인 문자열도
//        그대로 출력할 수 있음
//    """)

    // Raw String with trim indentation
//    println("""
//        이렇게 쓰면 여러줄인 문자열도
//        그대로 출력할 수 있음
//    """.trimIndent())

    /** var, val로 변수 선언
     * var: 변수
     * val: 상수
     */
    var text: String = "리터럴입니다."
    var text2 = "리터럴입니다."   // : String은 생략 가능

    text = "리터럴입니까?"    // 변수의 값 변경 가능

    val text3 = "변하지 않아요."
//    text3 = "변하나요?"   // val로 선언한 변수는 값 변경 불가능

    // String: 문자열, Int: 정수, Boolean: 논리값, Float/Double: 실수

    // 문자열 보간법(문자열 안에다가 변수/리터럴을 사용할 수 있는 것)
//    println("저는 ${19}살이에요.")
    val age = 29
//    println("저는 ${age} 살이에요.")
//    println("저는 $age 살이에요.")    // 뒤에 공백이 있거나 마침표로 구분이 된다면 중괄호 생략 가능
    val greeting = "저는 " + age + "세 입니다."
//    println(greeting)

    /** Nullable 변수
     * null 허용 변수
     */
    var a: String? = null   // 자료형 뒤에 ?를 붙여주면 null 값을 입력할 수 있는 변수가 된다
//    var b: String = nulls  // 에러

    println(a)  // null 출력
     var c: String = a!!    // null이면 에러 발생하고 null 아니면 값이 대입됨(!!)

    // null인지 체크 후 대입 -> 안전하게 언래필
    if(a != null){
        var d = a
    }

    // 새로운 변수로 선언하면서 null일 때 디폴트 값 사용
    var s: String = a ?: "asdf"




}