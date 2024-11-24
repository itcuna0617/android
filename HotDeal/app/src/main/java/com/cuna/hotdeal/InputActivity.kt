package com.cuna.hotdeal

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InputActivity : AppCompatActivity() {

    private var name: String = ""
    private var price: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)
        val confirmButton = findViewById<Button>(R.id.confirmButton)
        val textView = findViewById<TextView>(R.id.textView)
        val listButton = findViewById<Button>(R.id.homeButton)

        confirmButton.setOnClickListener{
            val editName = findViewById<EditText>(R.id.editName).text.toString()
            val editPrice = findViewById<EditText>(R.id.editPrice).text.toString()
            if(editName.isBlank() || editName.isEmpty()){
                InvalidInputAlert(0);
            } else if(editPrice.isBlank() || editPrice.isEmpty()){
                InvalidInputAlert(1);
            } else{
                val product = ProductManager.getProductByName(editName)
                product?.let {
                    if(it.price <= editPrice.toIntOrNull() ?: 0){
                        textView.text = "기존 최저가보다 높은 가격입니다.\n" +
                                "기존 - 상품명 : ${it.name}, 가격 : ${it.price}\n" +
                                "입력 - 상품명 : ${editName}, 가격 : ${editPrice.toIntOrNull() ?: 0}\n"
                    } else{
                        textView.text = "역대가 갱신입니다!\n" +
                                "기존 - 상품명 : ${it.name}, 가격 : ${it.price}\n" +
                                "입력 - 상품명 : ${editName}, 가격 : ${editPrice.toIntOrNull() ?: 0}\n"
                        ProductManager.addOrUpdateProduct(name = editName, price = editPrice.toIntOrNull() ?: 0)
                    }
                } ?: let{
                    textView.text = "신규 상품입니다!\n" +
                            "기존 - 상품명 : ${it.name}, 가격 : ${it.price}\n" +
                            "입력 - 상품명 : ${editName}, 가격 : ${editPrice.toIntOrNull() ?: 0}\n"
                    ProductManager.addOrUpdateProduct(name = editName, price = editPrice.toIntOrNull() ?: 0)
                }

                findViewById<EditText>(R.id.editName).text.clear()
                findViewById<EditText>(R.id.editPrice).text.clear()
            }
        }

        listButton.setOnClickListener{
            val intent = Intent(applicationContext, ResultActivity::class.java)
            startActivity(intent)
        }
    }

    fun InvalidInputAlert(type: Int){
        val builder = AlertDialog.Builder(this)

        builder.setTitle("올바르지 않은 입력")

        if(type == 1){
            builder.setMessage("가격 정보가 올바르지 않습니다. 빈 칸으로 입력하지 않았는지 확인해주세요")
        } else{
            builder.setMessage("제품명이 올바르지 않습니다. 빈 칸으로 입력하지 않았는지 확인해주세요")
        }

        builder.setPositiveButton("확인"){ dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }
}