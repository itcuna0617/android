fun main() {
    /** 연산자
     * 키보드의 일부를 제외한 대부분의 특수문자를 연산자로 사용한다.
     * 주어진 값을 정해진 방식에 따라 계산하고 그 값을 되돌려준다.
     * kotlin은 함수를 사용하는 방법과 연산자를 사용하는 방법 두 가지를 제공한다.
     */

    // 부호 연산자 "-"
    val a1 = 10
    val r1 = -a1
    println(r1)

    // 논리값 연산자 "!"
    val a2 = true
    val r2 = !a2
    println(r2)

    // 증강연산자 "++", "--"
    var a3 = 100
    println(a3++)   // a3 = a3 + 1 과 같다. 헤다 줄의 코드를 먼저 실행하고 1을 증가시켜준다.
    var a4 = 200
    println(++a4)   // 먼저 1을 증가시켜 준 후 해당 줄의 코드를 잘 실핸한다.

    /** 산술 연산자
     * * a .. b : 범위 연산자
     */
    val range: IntRange = 1 .. 10 // 자료형 IntRange로 되어있다.
    println(range)
    
    // 임의의 크기의 배열 생성
    val array = Array(5){"0"}   // 0은 각 아이템의 초기값

    /** 대입 연산자
     */
    var a6 = 3
    var b6 = 4
    a6 += b6

    /** 비교 연산자 -> true or false 반환
     *
     */
    val a7 = 10
    val b7 = 11
    val c7 = 10
    println("a7 == b7 : ${a7 == b7}")
    println("a7 == c7 : ${a7 == c7}")
    println("a7 != b7 : ${a7 != b7}")

    val r7 = a7 > 20
    val r8 = a7 < 20
    val r9 = a7 >= 10
    val r10 = a7 <= 10
    println("$r7, $r8, $r9, $r10")
}