class View(
    val id: String,
    val width: Int,
    val height: Int
) {
    var onClickListener: OnClickListener? = null

    init{
        draw()
    }

    fun draw() {
        println("뷰가 생성되었습니다. 가로 : $width, 세로 : $height")
    }

    fun clicked(){
        onClickListener?.onClick(this)
    }

    fun registerOnClickListener(onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }

    interface OnClickListener{
        fun onClick(view: View)
    }
}