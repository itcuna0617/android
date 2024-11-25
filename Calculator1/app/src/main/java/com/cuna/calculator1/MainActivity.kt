package com.cuna.calculator1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

enum class Arithmetic(val symbol: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIV("/");
}

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView

    // 사칙 연산 부호 클릭 여부
    var arithmetic: Arithmetic? = null

    // 디스플레이 할 정수
    var displayA: String = ""
    var displayB: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 디스플레이 텍스트뷰
        textView = findViewById<TextView>(R.id.textView)

        // 숫자 키패드 버튼
        val numberButtons = arrayOf(
            R.id.Button0, R.id.Button1, R.id.Button2, R.id.Button3,
            R.id.Button4, R.id.Button5, R.id.Button6, R.id.Button7,
            R.id.Button8, R.id.Button9
        )

        for(button in numberButtons){
            findViewById<Button>(button).setOnClickListener{ view ->
                setNumberKeypadClicked((view as Button).text.toString())
            }
        }
//        val button0 = findViewById<Button>(R.id.Button0)
//        val button1 = findViewById<Button>(R.id.Button1)
//        val button2 = findViewById<Button>(R.id.Button2)
//        val button3 = findViewById<Button>(R.id.Button3)
//        val button4 = findViewById<Button>(R.id.Button4)
//        val button5 = findViewById<Button>(R.id.Button5)
//        val button6 = findViewById<Button>(R.id.Button6)
//        val button7 = findViewById<Button>(R.id.Button7)
//        val button8 = findViewById<Button>(R.id.Button8)
//        val button9 = findViewById<Button>(R.id.Button9)

        // 기능 버튼
        val plusButton = findViewById<Button>(R.id.PlusButton)
        val minusButton = findViewById<Button>(R.id.MinusButton)
        val multiplyButton = findViewById<Button>(R.id.MultiplyButton)
        val divButton = findViewById<Button>(R.id.DivButton)
        val resultButton = findViewById<Button>(R.id.ResultButton)
        val buttonC = findViewById<Button>(R.id.ButtonC)

        // 숫자 버튼 클릭했을 때 동작
//        button0.setOnClickListener{ view ->
//            setNumberKeypadClicked((view as Button).text.toString())
//        }
//
//        button1.setOnClickListener{ view ->
//            setNumberKeypadClicked((view as Button).text.toString())
//        }
//
//        button2.setOnClickListener{ view ->
//            setNumberKeypadClicked((view as Button).text.toString())
//        }
//
//        button3.setOnClickListener{ view ->
//            setNumberKeypadClicked((view as Button).text.toString())
//        }
//
//        button4.setOnClickListener{ view ->
//            setNumberKeypadClicked((view as Button).text.toString())
//        }
//
//        button5.setOnClickListener{ view ->
//            setNumberKeypadClicked((view as Button).text.toString())
//        }
//
//        button6.setOnClickListener{ view ->
//            setNumberKeypadClicked((view as Button).text.toString())
//        }
//
//        button7.setOnClickListener{ view ->
//            setNumberKeypadClicked((view as Button).text.toString())
//        }
//
//        button8.setOnClickListener{ view ->
//            setNumberKeypadClicked((view as Button).text.toString())
//        }
//
//        button9.setOnClickListener{ view ->
//            setNumberKeypadClicked((view as Button).text.toString())
//        }

        // 사칙연산 버튼 클릭
        plusButton.setOnClickListener{ view ->
            setArithmeticClicked((view as Button).text.toString())
        }

        minusButton.setOnClickListener{ view ->
            setArithmeticClicked((view as Button).text.toString())
        }

        multiplyButton.setOnClickListener{ view ->
            setArithmeticClicked((view as Button).text.toString())
        }

        divButton.setOnClickListener{ view ->
            setArithmeticClicked((view as Button).text.toString())
        }

        // Equal 부호 클릭
        resultButton.setOnClickListener{
            val result = when (arithmetic){
                Arithmetic.PLUS -> displayA.toInt() + displayB.toInt()
                Arithmetic.MINUS -> displayA.toInt() - displayB.toInt()
                Arithmetic.MULTIPLY -> displayA.toInt() * displayB.toInt()
                Arithmetic.DIV -> displayA.toInt() / displayB.toInt()
                null -> {}
            }
//            textView.text = textView.text.toString() + " = " + result.toString()
            displayA = result.toString()
            displayB = ""
            arithmetic = null
            textView.text = displayA
        }

        // 초기화 버튼 클릭
        buttonC.setOnClickListener{
            textView.text = ""
            displayA = ""
            displayB = ""
            arithmetic = null
        }
    }

    // 숫자 키패드 클릭 시 실행 함수
    fun setNumberKeypadClicked(number: String){
        if(arithmetic == null){ // 사칙연산 부호가 클릭 안되었을 때 : a 값이 된다.
            displayA = displayA + number
            textView.text = displayA
        } else{ // 사칙연산 부호가 클릭 되었을 때 : b 값이 된다.
            displayB = displayB + number
            textView.text = displayA + " ${arithmetic!!.symbol} " + displayB
        }
    }

    // 사칙연산 부호 클릭 시 실행 함수
    fun setArithmeticClicked(simbol: String){
        when(simbol){
            "+" -> arithmetic = Arithmetic.PLUS
            "-" -> arithmetic = Arithmetic.MINUS
            "*" -> arithmetic = Arithmetic.MULTIPLY
            "/" -> arithmetic = Arithmetic.DIV
        }
        textView.text = textView.text.toString() + " " + simbol
    }
}