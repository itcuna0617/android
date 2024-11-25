fun main() {
    /** 반복문
     * 코드 일부분을 원하는 만큼 반복 시키고자 할 때 사용한다.
     * for, while, do~while 문을 제공한다.
     */

    /** for문
     * 배열과 같이 값들을 관리하는 요소들을 이용해 코드를 반복한다.
     * 다음과 같이 값을 4개 갖고 있는 배열이 있을 경우 4번을 반복한다.
     * 자바의 일반적인 for문 형식은 사용이 불가능하고 for-each문 형태로 사용 가능
     */
//    val numbers = arrayOf(1, 2, 3, 4)
//    for (number in numbers) {
//        println(number)
//    }

    // 범위 연산자를 활용한 for문("0..9")
//    for(i in 0..9){
//        println(i)
//    }

    // Java에서 사용하는 for문 형식 -> 사용 불가
//    for(int i = 0; i < 10; i++){
//        println(i)
//    }

    // for문의 step을 원하는 만큼 증가시킬 수 있다.("0..9")
//    val a2 = 0..9 step 2
//    for(i in a2){
//        println(i)
//    }

    // 범위연산자를 활용한 for문 역순으로( 10 downTo 1 )
//    val a3 = 10 downTo 1 step 2
//    for(i in a3){
//        println(i)
//    }

//    val a4 = 10 .. 1
//    for(i in a4){   // for문에서 사용 불가
//        println(i)
//    }

//    val a4 = 10..1 step -1 // step은 양수만 가능하다 음수를 입력할 수는 없음
//    for(i in a4){
//        println(i)
//    }

    /** while문
     * - 주어진 조건이 만족할 경우 반복한다.
     * - 조건식이 상단에 있으므로 조건식이 거짓이면 단 한 번도 수행되지 않는다.
     * - 코드를 수행할 때마다 조건식을 확인하기 때문에 영원히 조건식이 참일 경우에는 주의가 필요하다.
     */

//    var a5 = 0
//    while (true) {    // 이런 경우에는 계속 실행되기 때문에 주의 필요
//    while(a5 < 5){
//        println(a5)
//        a5++
//    } // a5가 5가 될 때 while문을 빠져 나간다.

    /** do~while문
     * - 주어진 조건이 만족할 경우 반복한다
     * - 조건식이 하단에 있으므로 조건식이 거짓이라도 한 번은 실행된다.
     * - 코드를 수행할 때마다 조건식을 확인하기 때문에 영원히 조건식이 참일 경우에는 주의가 필요하다.
     */
    var a6 = 0
    do{
        println(a6)
        a6++
    } while(a6 < 5)















}