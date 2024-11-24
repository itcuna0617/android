package com.cuna.mazeapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val viewLeft = findViewById<TextView>(R.id.viewLeft)
        val viewRight = findViewById<TextView>(R.id.viewRight)
        val viewUp = findViewById<TextView>(R.id.viewUp)
        val viewDown = findViewById<TextView>(R.id.viewDown)

        val firstDirection = intent.getStringExtra("firstDirection")
        println(firstDirection)

        viewUp.setOnClickListener{
            checkAnswer(firstDirection!!, "Up")
        }
        viewLeft.setOnClickListener{
            checkAnswer(firstDirection!!, "Left")
        }
        viewRight.setOnClickListener{
            checkAnswer(firstDirection!!, "Right")
        }
        viewDown.setOnClickListener{
            checkAnswer(firstDirection!!, "Down")
        }
    }

    fun checkAnswer(firstDirection: String, secondDirection: String){
        val resultIntent = Intent()
        if(firstDirection == "Left" && secondDirection == "Left"){
            resultIntent.putExtra("result", true)
        } else{
            resultIntent.putExtra("result", false)
        }
        // 화면 이동할 때 값이 잘 돌아갔는지의 여부 위의 true, false값과 다른 것
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}