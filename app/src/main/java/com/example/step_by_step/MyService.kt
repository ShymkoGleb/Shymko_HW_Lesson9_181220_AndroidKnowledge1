package com.example.step_by_step

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.TextView

class MyService : Service() {
    var Tag = "MyService"

    companion object {
        var resultsofServiceCalculation: Int = 0
        var serviceOnStartCommand = false
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        ShowLog("onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        ShowLog("onStartCommand")
        serviceOnStartCommand = false
        resultsofServiceCalculation = 0
        for (i in 1..5) {
            resultsofServiceCalculation++
            ShowLog("calculation iteration is $i value of resultsofServiceCalculation is $resultsofServiceCalculation   serviceOnStartCommand is $serviceOnStartCommand")

            Thread.sleep(1000)
        }
        ShowLog("Result of calculation is - $resultsofServiceCalculation")

        serviceOnStartCommand = true
        val intent = Intent()
        intent.putExtra(
            MyReceiver.MY_RECEIVER_MESSAGE,
            "Result of calculation is $resultsofServiceCalculation"
        )
        intent.action = MyReceiver.MY_RECEIVER_ACTION
        sendBroadcast(intent)
        ShowLog("serviceOnStartCommand is - $serviceOnStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        ShowLog("onDestroy")
        super.onDestroy()
    }

    fun ShowLog(message: String) {
        Log.d(Tag, message)
    }
}
