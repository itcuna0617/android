import java.util.Scanner

fun main() {

    // Ctrl + Shift + / -> 블럭 주석
    /*print("")
    print("")
    print("")
    print("")
    print("")*/

    /**
     * 문서 주석
     */

    /** 클래스 설명 제목
     * 클래스 설명 1
     * 클래스 설명 2
     */

    /**
     * 입력 관련
     */
    val scanner = Scanner(System.`in`)  // in은 백틱값으로 감싸준다.
    // 정수 입력 받기
//    println("정수를 입력해주세요")
//    val int = scanner.nextInt()
//    println("정수는 ${int}입니다")

    // 문자열 입력 받기
//    println("문자열을 입력해주세요")
//    val string = scanner.next() // 개행 or 공백을 기준으로 앞에 있는 한 단어만 입력을 받음
//    println("문자열은 ${string}입니다")

//    println("문자열을 입력해주세요")
//    val line = scanner.nextLine() // 한 줄을 입력 받음
//    println("문자열은 ${line}입니다")

//    println("논리값을 입력해주세요")
//    val boolean = scanner.nextBoolean() // 한 줄을 입력 받음
//    println(boolean)

    println("문자열을 입력해주세요.")
    val readLine =  readLine()
    println(readLine)
}