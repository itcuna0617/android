/** Companion
 * Java에서 static과 동일히다.
 * 클래스 내에서 companion 멤버로 정의된 요소들은 객체 생성 없이 사용이 가능하며
 * 클래스의 이름을 통해 접근한다.
 * companion 변수의 경우 딱 하나만 생성되어 사용할 수 있다.
 */

fun main() {
    var testClass1 = TestClass1()
    // 일반 클래스의 멤버에 접근하기 위해서는 인스턴스를 생성하고 나서 접근해야 한다.
    println("testClass1.a1 = ${testClass1.a1}")
    testClass1.testMethod1()
    // 컴패니언은 직접 클래스로 접근한다.
    println("TestClass1.a2 = ${TestClass1.a2}")
    TestClass1.testMethod2()

    // Java 코드로 만들어진 클래스를 통해 객체를 생성한다.
    val javaMain = JavaMain()
    println("javaMain.javaA1 : ${javaMain.javaA1}")
    javaMain.javaMethod1()

    // 자바 정적 멤버에 접근할 때도 똑같이 클래스로 접근한다.
//    println("javaMain.javaA2 : ${javaMain.javaA2}")
//    javaMain.javaMethod2()
    println("JavaMain.javaA2 : ${JavaMain.javaA2}")
    JavaMain.javaMethod2()
}

class TestClass1{
    // 일반 멤버 변수
    var a1 = 100
    // 일반 메서드
    fun testMethod1(){
        println("testMethod1()")
        // 일반 멤버 변수 사용
        println("testMethod2() - a1 : $a1")
        // 정적 멤버 변수 사용
        println("testMethod2() - a2 : $a2")
    }

    // Companion
    companion object{
        // 컴패니언 멤버 변수
        var a2 = 200
        // 컴패니언 메소드
        fun testMethod2(){
            println("testMethod2()")
            // 일반 멤버 변수 사용
//            println("testMethod2() - a1 : $a1") // 클래스 일반 멤버 변수에는 접근이 안됨
            // 정적 멤버 변수 사용
            println("testMethod2() - a2 : $a2")
        }

        // @JvmStatic : companion 멤버를 자바에서 사용할 때 Companion를 클래스를 거치지 않고
        // 직접 사용할 수 있도록 할 수 있다.
        @JvmStatic
        var a3 = 300
        @JvmStatic
        fun testMethod3(){
            println("testMethod3()")
        }
    }
}