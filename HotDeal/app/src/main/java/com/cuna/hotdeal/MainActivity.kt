package com.cuna.hotdeal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        // Singleton으로 Product 설정
//        ProductManager.addOrUpdateProduct(name = "Laptop", price = 1500)
//
//        // Singleton에서 Product 가져오기
//        val product = ProductManager.getProductByName("Laptop")
//        product?.let {
//            println("Product Name: ${it.name}, Price: ${it.price}")
//        } ?: println("Product not found")

        val newButton = findViewById<Button>(R.id.NewButton)
        val listButton = findViewById<Button>(R.id.ListButton)

        newButton.setOnClickListener{
            val intent = Intent(applicationContext, InputActivity::class.java)
            startActivity(intent)
        }

        listButton.setOnClickListener{
            val intent = Intent(applicationContext, ResultActivity::class.java)
            startActivity(intent)
        }
    }
}