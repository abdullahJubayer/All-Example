package com.example.allaboutservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.allaboutservice.background.started.BackgroundStartedService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            run {
                startActivity(Intent(this@MainActivity, MainActivity2::class.java))
            }
        }, 2000)
    }


    override fun onStart() {
        super.onStart()
        startService(Intent(this, BackgroundStartedService::class.java))
    }

    override fun onDestroy() {
        stopService(Intent(this, BackgroundStartedService::class.java))
        super.onDestroy()
    }
}