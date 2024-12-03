package com.cuna.bread

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cuna.bread.models.Bread
import com.cuna.bread.models.FishBread
import com.cuna.bread.models.FlowerBread

class MainActivity : AppCompatActivity() {
    var bread = Bread()
    // Intent로 화면 이동할 때 데이터를 받아오기 위한 변수
    private lateinit var getResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val imageView1 = findViewById<ImageView>(R.id.imageView1)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)
        val imageView4 = findViewById<ImageView>(R.id.imageView4)
        val imageView5 = findViewById<ImageView>(R.id.imageView5)
        val imageView6 = findViewById<ImageView>(R.id.imageView6)
        val imageView7 = findViewById<ImageView>(R.id.imageView7)
        val imageView8 = findViewById<ImageView>(R.id.imageView8)
        val imageView9 = findViewById<ImageView>(R.id.imageView9)

        getResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){ result ->
            // 결과값으로 Bread 객체를 만든다.
            val data: Intent? = result.data
            val shape = data?.getStringExtra("shape")
            val sauce = data?.getStringExtra("sauce")
            bread = if(shape == "붕어빵") FishBread() else FlowerBread()
            bread.shape = shape!!
            bread.sauce = sauce!!
            
            // 이미지 뷰에 만든 빵 이미지 셋팅
            when(bread.shape){
                "붕어빵" -> imageView1.setImageResource(R.drawable.fish)
                "국화빵" -> imageView1.setImageResource(R.drawable.flower)
            }
        }

        val buttonProd = findViewById<Button>(R.id.buttonProd)

        buttonProd.setOnClickListener{
            val intent = Intent(applicationContext, DisplayActivity::class.java)
            startActivity(intent)
        }
    }
}