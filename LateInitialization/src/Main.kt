fun main() {
    val obj1 = TestClass1()
    println("obj1.a1: ${obj1.a1}")
    println("obj1.a2: ${obj1.a2}")
//    obj1.testMethod1()

//    println("obj1.a3: ${obj1.a3}")
    obj1.testMethod1()

    println("obj1.a4: ${obj1.a4}")
}

class TestClass1 {
    var a1 = 100
    var a2: Int
    // lateinit 키워드는 참조형 변수에만 사용이 가능 -> Int와 같은 기본 자료형에는 사용 불가
    lateinit var a3: String

    val a4: String by lazy {
        println("a4 init")
        "문자열2"
    }

    init {
        a2 = 200
    }

    fun testMethod1() {
        if (!::a3.isInitialized) {
            a3 = "문자열"
        }
        println("a3: $a3")

    }
}