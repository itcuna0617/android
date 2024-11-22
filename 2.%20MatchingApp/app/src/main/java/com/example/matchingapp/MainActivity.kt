package com.example.matchingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View 초기화
        val editText1 = findViewById<EditText>(R.id.editText1)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val button = findViewById<Button>(R.id.button)

        // 버튼 클릭 시 동작
        button.setOnClickListener {

            if(editText1.text.isEmpty() || editText2.text.isEmpty()){
                Toast.makeText(applicationContext, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // User1 이름 첫 글자 가져오기
            var char1: Char = editText1.text.toString()[0];
            var char2: Char = editText2.text.toString()[0];

            // 유니코드 번호로 변환
            val int1: Int = char1.code
            val int2: Int = char2.code

            var percentage = (int1 + int2) % 100

            Log.d("MainActivity", "매칭 확률은 $percentage% 입니다.")

            showDefaultDialog(editText1.text.toString(), editText2.text.toString(), percentage)
        }
    }

    fun calcPer(user1: String, user2: String): Int {
        val result: Int = user1.length + user2.length

        return result
    }

    fun showDefaultDialog(user1: String, user2: String, percentage: Int){
        var builder = AlertDialog.Builder(this)
        builder.setTitle("커플 매칭 확률")
        builder.setMessage("${user1}님과 ${user2}님의 매칭확률은 $percentage% 입니다.")
        builder.setPositiveButton("OK"){ dialog, _ ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }

    // 기본 다이얼로그 표시 함수
    private fun showBasicDialog() {
        val builder = AlertDialog.Builder(this)

        val randomNumber = Random.nextInt(0, 101)

        builder.setTitle("커플 매칭 확률")
        builder.setMessage("$randomNumber% 입니다.")

        // 확인 버튼 추가
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss() // 다이얼로그 닫기
        }

        // 다이얼로그 생성 및 표시
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}