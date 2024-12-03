/** OnClickListener 관련 이해를 돕기 위한 간소화 코드
 * 실제 안드로이드의 View 클래스가 이런 형태로 작성되어 있다.
 * registerOnClickListener는 안드로이드에서 setOnClickListener에 해당하는 메소드
 * 안드로이드에서 인터페이스를 어떻게, 왜 사용하는지 알아보자
 */

fun main() {
    val view = View("view1", 100, 200)
    val onClickListener = OnClickListener1()
    view.registerOnClickListener(onClickListener)
    view.clicked()


    val view2 = View("view2", 100, 200)
    val onClickListener2 = OnClickListener2()
    view.registerOnClickListener(onClickListener2)
    view.clicked()

}

class OnClickListener1 : View.OnClickListener {
    override fun onClick(view: View) {
        println("안녕하세요. 저는 ${view.id}입니다.")
    }
}

class OnClickListener2 : View.OnClickListener {
    override fun onClick(view: View) {
        println("Hello. I'm ${view.id}")
    }
}