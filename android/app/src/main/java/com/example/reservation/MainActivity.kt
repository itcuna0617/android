package com.example.reservation

import android.app.AlertDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.reservation.ui.theme.ReservationTheme

class MainActivity : ComponentActivity() {
    var location: String = ""
    var date: String = ""
    var name: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View 초기화
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val buttonDate = findViewById<Button>(R.id.buttonDate)
        val buttonBook = findViewById<Button>(R.id.buttonBook)

        // 스피너에 나타낼 지점 목록
        val locationList = listOf(
            "서울", "양양", "대전", "부산", "광주"
        )

        // 스피너 어댑터 설정
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, locationList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // 선택 이벤트 처리
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                location = p0!!.getItemAtPosition(p2).toString()
                Toast.makeText(applicationContext, location, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        // 예약 이벤트 처리
        buttonBook.setOnClickListener {
            name = editTextName.text.toString()
            showDefaultDialog(name, location, date)
        }

        // 날짜 선택
        buttonDate.setOnClickListener{
            val calendar = Calendar.getInstance();
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            // DatePickerDialog 생성
            val datePickerDialog =
                android.app.DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                    // 선택한 날짜를 버튼에 표시
                    date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    buttonDate.text = date
                }, year, month, day)

            datePickerDialog.show()
        }
    }

    fun showDefaultDialog(name: String, location: String,date: String){
        var builder = AlertDialog.Builder(this)
        builder.setTitle("예약 정보")
        builder.setMessage("${name}님의 예약 정보\n" +
                "예약 지점 : ${location} 지점\n" +
                "예약 날짜 : ${date}")
        builder.setPositiveButton("OK"){ dialog, _ ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }
}