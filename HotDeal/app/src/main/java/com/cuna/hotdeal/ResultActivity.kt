package com.cuna.hotdeal

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    private lateinit var arrayAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // ListView 가져오기
        val listView = findViewById<ListView>(R.id.listView)
        val homeButton = findViewById<Button>(R.id.homeButton)
        val inputButton = findViewById<Button>(R.id.inputButton)

        // ProductManager에서 데이터 가져오기
        val productList = ProductManager.getProducts()

        // 데이터를 텍스트 형태로 변환하여 ArrayAdapter에 추가
        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            productList.map { product -> "상품명: ${product.name} | 가격: ${product.price} 원" }
        )
        listView.adapter = arrayAdapter

        homeButton.setOnClickListener{
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        inputButton.setOnClickListener{
            val intent = Intent(applicationContext, InputActivity::class.java)
            startActivity(intent)
        }
    }
}