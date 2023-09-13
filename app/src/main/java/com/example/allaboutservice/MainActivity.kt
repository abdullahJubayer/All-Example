package com.example.allaboutservice

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.allaboutservice.background.started.BackgroundStartedService


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        "MainActivity-onCreate".show()



        /* START_NOT_STICKY FLAG */
        /* Kill the service before 40s. then call the pending intent to start the service again*/
        startService(Intent(this, BackgroundStartedService::class.java).putExtra("Id",1))

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            run {
                val pendingIntent = PendingIntent.getService(
                    this@MainActivity, 0, Intent(this@MainActivity, BackgroundStartedService::class.java).putExtra("Id",2), PendingIntent.FLAG_MUTABLE
                )
                "Fire PendingIntent".show()
                pendingIntent.send()
            }
        }, 40*1000)

    }


    override fun onStart() {
        super.onStart()
    }

    override fun onDestroy() {
        stopService(Intent(this, BackgroundStartedService::class.java))
        super.onDestroy()
    }
}