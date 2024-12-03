// 이번 시간에는 제네릭에 대해서 살펴보도록 하겠습니다.

// 우리가 보통 클래스를 만들 때
class Test {
    var a1: Int = 100 // 타입을 작성해주죠. 변수를 선언할 때 타입을 결정을 한거구요.
    var a2 = 200 // 또는 타입을 생략할 경우도 있습니다. 변수에 최초로 집어넣는 값에 의해서 타입이 결정이 되므로 타입을 결정해줬다고 생각할 수 있다.
    // 이처럼 변수 같은 것을 정의할 때 반드시 타입이 결정해준다.
}

// 변수가 어떨 때는 정수형, 어떨때는 문자열로 선언해주고 싶을 때가 있지 않을까.

// 주생성자 매개변수로 어떨때는 Int, 어떨때는 String으로 받고 싶다면
// 이렇게 하려면 클래스를 두 개 만들어야 한다
class Test2(var a1: Int)
class Test3(var a1: String)

// 만약에 이 자료형을 객체를 생성할 때 정할 수 있다고 한다면 클래스를 여러개 만들지 않아도 되지 않을까?
// 이럴 때 사용하는 것이 제네릭이다.

/** Generic이란
 * 클래스를 설계할 때 특정 변수의 타입을 유동적으로 하고 싶을 때가 있을 수도 있다.
 * 이 때 Generic 개념을 활용하면 클래스 작성시가 아닌 객체 생성 시에 해당 변수의 타입을 설정할 수 있다.
 */

fun main(){
    // 제네릭 타입은 객체를 생성할 때 타입을 결정해 줘야 한다.
    // T 타입으로 정의된 변수의 타입을 Int로 결정한다.
    val t1 = TestClass1<Int>()
    t1.testMethod1(100)

    // T 타입으로 정의된 변수의 타입을 String으로 결정한다.
    val t2 = TestClass1<String>()
    t2.testMethod1("안녕하세요")

    val t3 = TestClass2<Int, Double, Boolean, String>(100,11.11)
    t3.testMethod3(true, "문자열1")

    val t4 = TestClass2<Double, String, Boolean, Int>(22.22, "문자열2")
    t4.testMethod3(false, 200)

    // 불변성 : 객체를 생성할 때 설정한 제네릭과 같은 변수에 담을 수 있다.
    // 클래스간의 상속 관계에 상관없이 제네릭에 설정한 클래스 타입이 다르면 오류가 발생한다.
    val t5:TestClass3<SubClass1> = TestClass3<SubClass1>()
    // 변수의 타입에 제네릭을 설정하였기 때문에 생략이 가능하다.
    // val t5:TestClass3<SubClass1> = TestClass3()
    // val t6:TestClass3<SuperClass1> = TestClass3<SubClass1>()
    // val t7:TestClass3<SubClass2> = TestClass3<SubClass1>()

    // 공변성 : 변수에 설정한 제네릭이 객체를 생성했을 때 사용한 제네릭과 같거나
    // 부모 클래스인 경우 담을 수 있다.
    val t8:TestClass4<SubClass1> = TestClass4<SubClass1>()
    val t9:TestClass4<SuperClass1> = TestClass4<SubClass1>()
    // val t10:TestClass4<SubClass2> = TestClass4<SubClass1>()

    // 반 공변성 : 변수에 설정한 제네릭이 객체를 생성했을 때 사용한 제네릭과 같거나
    // 자식 클래스인 경우에 담을 수 있다.
    val t11:TestClass5<SubClass1> = TestClass5<SubClass1>()
    // val t12:TestClass5<SuperClass1> = TestClass5<SubClass1>()
    val t13:TestClass5<SubClass2> = TestClass5<SubClass1>()
}

// < > : 안에 단어를 넣어준다. 보통 대문자 한글자를 작성한다.
// 이 단어는 아직 결정되지 않은 타입을 의미한다.
// 어떠한 타입인지는 결정되지 않았지만 이 타입의 변수들을 정의하여
// 클래스를 작성하고 향후, 객체를 생성할 때 타입을 결정할 수 있다.
// T : 타입
// E : 리스트나 배열 등과 같이 객체들을 관리하는 요소들이 관리하는 객체 타입
// K : 키. 맵과 같이 이름을 통해 객체를 관리하는 요소들의 이름으로 사용할 타입
// V : 리턴 값 또는 매핑된 값
// N : 숫자
// S, U, V : 2번째, 3번째, 4번째 선언된 타입
class TestClass1<T>{
    fun testMethod1(a1:T){
        println("a1 : $a1")
    }
}

class TestClass2<A, B, C, D>(var a1:A, var a2:B){

    fun testMethod3(a3:C, a4:D){
        println("a1 : $a1")
        println("a2 : $a2")
        println("a3 : $a3")
        println("a4 : $a4")
    }
}

open class SuperClass1
open class SubClass1 : SuperClass1()
class SubClass2 : SubClass1()

// 불변성 (제네릭에 키워드를 붙히지 않는다)
class TestClass3<T>
// 공변성
class TestClass4<out A>()
// 반 공변성
class TestClass5<in A>()