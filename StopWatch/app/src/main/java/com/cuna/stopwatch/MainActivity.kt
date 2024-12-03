package com.cuna.stopwatch

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var running: Boolean = false
    var time: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewTime = findViewById<TextView>(R.id.textViewTime)
        val listView = findViewById<ListView>(R.id.listView)
        val buttonStart = findViewById<Button>(R.id.buttonStart)
        val buttonPause = findViewById<Button>(R.id.buttonPause)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val buttonLap = findViewById<Button>(R.id.buttonLap)

        val timeList = mutableListOf<String>()

        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,
            timeList)
        listView.adapter = adapter

        val handler = Handler(Looper.getMainLooper())

        val runnable = object : Runnable{
            override fun run(){
                if(running){
                    time += 0.01
                    textViewTime.text = String.format("%.2f", time)
                    handler.postDelayed(this, 10)
                }
            }
        }

        buttonStart.setOnClickListener{
            running = true
            handler.post(runnable)
        }

        buttonPause.setOnClickListener{
            running = false
        }

        buttonReset.setOnClickListener{
            running = false
            time = 0.0
            textViewTime.text = "0.00"

            timeList.clear()
            adapter.notifyDataSetChanged()
        }

        buttonLap.setOnClickListener{
            timeList.add(textViewTime.text.toString())
            adapter.notifyDataSetChanged()
        }
    }
}