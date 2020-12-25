package com.example.step_by_step

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Message
import android.util.Log

class MyService : Service() {
    var Tag = "MyService"

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        ShowLog("onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        ShowLog("onStartCommand")
        val runnable = Runnable {
            for (i in 1..5) {
                ShowLog("Service doing something $i")
                Thread.sleep(1000)
            }
            stopSelf()
        }

        val thread =Thread(runnable)
        thread.start()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        ShowLog("onDestroy")
        super.onDestroy()
    }

    fun ShowLog(message: String){
        Log.d(Tag,message)
    }

}