package com.cuna.mazeapp

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){ result ->
            if(result.resultCode == Activity.RESULT_OK){
                var result = result.data
                val returnedResult = result?.getBooleanExtra(
                    "result", false
                )

                showBasicAlert(returnedResult!!)
            }
        }

        val viewLeft = findViewById<TextView>(R.id.viewLeft)
        val viewRight = findViewById<TextView>(R.id.viewRight)

        viewLeft.setOnClickListener{
            // intent는 다른 화면으로 넘어갈때 데이터를 옮겨주는 역할
            val intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("firstDirection", "Left")
//            startActivity(intent) // 그냥 액티비티 전환만 할 때
            resultLauncher.launch(intent) // 액티비티 호출 후 result data 받을 때
        }

        viewRight.setOnClickListener{
            // intent는 다른 화면으로 넘어갈때 데이터를 옮겨주는 역할
            val intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("firstDirection", "Right")
//            startActivity(intent)
            resultLauncher.launch(intent)
        }
    }

    fun showBasicAlert(success: Boolean){
        val builder = AlertDialog.Builder(t ㄷhis)

        if(success == true){
            builder.setTitle("성공! 보물을 찾았어요!!")
        } else{
            builder.setTitle("실패! 보물을 찾지 못했어요!!")
        }
        builder.setPositiveButton("확인"){ dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }
}