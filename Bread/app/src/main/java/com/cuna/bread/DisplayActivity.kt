package com.cuna.bread

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cuna.bread.models.Bread
import com.cuna.bread.models.FishBread
import com.cuna.bread.models.FlowerBread

class DisplayActivity : AppCompatActivity() {
    var bread: Bread = Bread()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 컴포넌트 초기화
        val imageView = findViewById<ImageView>(R.id.imageView)
        val radioGroupBread = findViewById<RadioGroup>(R.id.radioGroupBread)
        val radioGroupSauce = findViewById<RadioGroup>(R.id.radioGroupSauce)
        val radioButtonFish = findViewById<RadioButton>(R.id.radioButtonFish)
        val radioButtonFlower = findViewById<RadioButton>(R.id.radioButtonFlower)
        val radioButtonBean = findViewById<RadioButton>(R.id.radioButtonBean)
        val radioButtonCream = findViewById<RadioButton>(R.id.radioButtonCream)
        val buttonBake = findViewById<Button>(R.id.buttonBake)
        val buttonCancel = findViewById<Button>(R.id.buttonCancel)

        // 빵 고르기 라디오 버튼
        radioButtonFish.setOnClickListener{
            imageView.setImageResource(R.drawable.fish_mold)
            bread.shape = "붕어빵"
        }

        radioButtonFlower.setOnClickListener{
            imageView.setImageResource(R.drawable.flower_mold)
            bread.shape = "국화빵"
        }

        // 소스 선택 라디오 버튼
        radioButtonBean.setOnClickListener{
            bread.sauce = "팥앙금"
        }
        radioButtonCream.setOnClickListener{
            bread.sauce = "슈크림"
        }

        // 만들기 버튼
        buttonBake.setOnClickListener{
            // 결과를 반환하는 코드
            val resultIntent = Intent(applicationContext, MainActivity::class.java)
            resultIntent.putExtra("shape", bread.shape) // 결과 데티어를 인텐트에 담기
            resultIntent.putExtra("sauce", bread.sauce) // 결과 데티어를 인텐트에 담기
            setResult(Activity.RESULT_OK, resultIntent) // 결과 코드와 인텐트 설정
            finish()
        }
    }
}