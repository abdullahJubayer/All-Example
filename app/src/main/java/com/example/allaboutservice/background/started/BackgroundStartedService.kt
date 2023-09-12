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
import java.lang.Exception


class BackgroundStartedService : Service() {

    private lateinit var serviceHandler: ServiceHandler
    private lateinit var backgroundThread: HandlerThread

    private inner class ServiceHandler(looper: Looper) : Handler(looper) {
        override fun handleMessage(msg: Message) {
            "HandleMessage : ${msg.arg1}".show()

            try {
                "ServiceHandlerThread${msg.arg1}.Start".show()
                Thread.sleep(400)
                "ServiceHandlerThread${msg.arg1}.End".show()
            }catch (_:Exception){
                "ServiceHandlerThread.ForceStop".show()
            }

        }

    }


    override fun onCreate() {
        super.onCreate()
        "onCreate".show()


        /* Create Thread */
        backgroundThread = HandlerThread("MyService Thread", Process.THREAD_PRIORITY_BACKGROUND)
        /* Start Thread */
        backgroundThread.start()
        /* Get Looper From Thread */
        serviceHandler = ServiceHandler(backgroundThread.looper)

    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        "onStartCommand".show()

        /*This will block the main thread which hosting this service*/
        /**
        "Thread.Start".show()
        Thread.sleep(50000)
        "Thread.End".show()
         */


        /* We can use HandlerThread to handle our operation in background. and this execute like a queue when new Intent arrived */
        serviceHandler.obtainMessage().also {
            it.arg1 = intent?.getIntExtra("Id",-1) ?: -1
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

        return Service.START_NOT_STICKY
    }

    /* Return Null Because No  Binding Needed */
    override fun onBind(p0: Intent?): IBinder? {
        "onBind".show()
        return null
    }


    /* Very important that if we use handler in another thread. even the service is destroy still the handler will do its work. so we need to remove handler and stop the thread */
    override fun onDestroy() {
        "onDestroy".show()
        destroyThreadAndHandler()
        super.onDestroy()
    }

    private fun  destroyThreadAndHandler(){
        /* This is very important to remove callback from handler & stop the background thread*/
        serviceHandler.removeCallbacksAndMessages(null)
        if (backgroundThread.isAlive){
            backgroundThread.quit() /* quite() will remove all pending work for this thread. but currently running work will not stop */
            backgroundThread.interrupt() /* So interrupt() will stop current work and  throw an interrupt exception and we should handle this exception */
        }
    }

}