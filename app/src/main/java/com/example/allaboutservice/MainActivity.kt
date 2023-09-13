package com.example.allaboutservice

import android.app.PendingIntent
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.allaboutservice.background.bound.StartedAndBoundService
import com.example.allaboutservice.background.started.BackgroundStartedService


class MainActivity : AppCompatActivity() {
    private lateinit var mService: StartedAndBoundService
    private var mBound: Boolean = false


    private val serviceConnection : ServiceConnection = object  : ServiceConnection{
        override fun onServiceConnected(p0: ComponentName?, binder: IBinder?) {
            mService = (binder as StartedAndBoundService.MyBinder).getStartedAndBoundService()
            mBound=true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            mBound=false
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        "MainActivity-onCreate".show()

        /* service before 40s. then call the pending intent to start the service again*/
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            run {
                Intent(this@MainActivity,StartedAndBoundService::class.java).apply {
                    bindService(this,serviceConnection,Context.BIND_AUTO_CREATE)
                }
            }
        }, 40*1000)


        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            run {
                if (mBound){

                }
            }
        }, 60*1000)

    }


    override fun onStart() {
        startService(Intent(this, BackgroundStartedService::class.java))
        super.onStart()
    }

    override fun onDestroy() {
//        stopService(Intent(this, BackgroundStartedService::class.java))
        super.onDestroy()
    }
}