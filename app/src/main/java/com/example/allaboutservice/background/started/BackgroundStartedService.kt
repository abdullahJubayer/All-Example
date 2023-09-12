package com.example.allaboutservice.background.started

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.HandlerThread
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.os.Process
import com.example.allaboutservice.show


class BackgroundStartedService : Service() {

    private lateinit var serviceHandler: ServiceHandler

    private inner class ServiceHandler(looper: Looper) : Handler(looper) {
        override fun handleMessage(msg: Message) {
            "HandleMessage : ${msg.arg1}".show()

            "ServiceHandlerThread.Start".show()
            Thread.sleep(60*1000)
            "ServiceHandlerThread.End".show()

        }

    }


    override fun onCreate() {
        super.onCreate()
        "onCreate".show()


        /* Create Thread */
        val backgroundThread = HandlerThread("MyService Thread", Process.THREAD_PRIORITY_BACKGROUND)
        /* Start Thread */
        backgroundThread.start()
        /* Get Looper From Thread */
        serviceHandler = ServiceHandler(backgroundThread.looper)

    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        "onStartCommand ${startId}".show()

        /*This will block the main thread which hosting this service*/
        /**
        "Thread.Start".show()
        Thread.sleep(50000)
        "Thread.End".show()
         */


        /* We can use HandlerThread to handle our operation in background. and this execute like a queue when new Intent arrived */
        serviceHandler.obtainMessage().also {
            it.arg1 = intent?.getStringExtra("Id")?.toInt() ?: -1
            serviceHandler.sendMessage(it)
        }


        /* Or We can use Thread class to handle our operation in background. But this will execute as soon as new Intent arrived */
//        Thread(Runnable {
//            run {
//                "Thread2.Start".show()
//                Thread.sleep(50000)
//                "Thread2.End".show()
//            }
//        }).start()


        /*START_NOT_STICKY FLAG*/
        /* If we use start not sticky flag, this service will not auto-create after been killed by system. but if we call the service again this will re-create the service*/
        /*For example if we want to download 3 files. when first file downloading system kill the service. after sometimes start the service to download second file,this will work fine*/
        /*START_NOT_STICKY FLAG*/

        return Service.START_NOT_STICKY
    }

    /* Return Null Because No  Binding Needed */
    override fun onBind(p0: Intent?): IBinder? {
        "onBind".show()
        return null
    }


    override fun onDestroy() {
        "onDestroy".show()
        super.onDestroy()
    }

}