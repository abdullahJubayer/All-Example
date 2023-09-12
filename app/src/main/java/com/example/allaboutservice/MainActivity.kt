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



        /* START_NOT_STICKY FLAG */
        /* Kill the service before 60s. then call the second activity to start the service again*/
        startService(Intent(this, BackgroundStartedService::class.java).putExtra("Id",1))

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            run {
                startService(Intent(this, BackgroundStartedService::class.java).putExtra("Id",2))
            }
        }, 6000)

    }


    override fun onStart() {
        super.onStart()
    }

    override fun onDestroy() {
        stopService(Intent(this, BackgroundStartedService::class.java))
        super.onDestroy()
    }
}