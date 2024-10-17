package com.example.main

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.example.allaboutservice.R
import com.example.custom_views.SunView


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        "MainActivity-onCreate".show()

        val sunView = findViewById<SunView>(R.id.sun_view)
        val progress_horizontal = findViewById<SeekBar>(R.id.progress_horizontal)


        progress_horizontal.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                sunView.moveSun(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })



    }
}