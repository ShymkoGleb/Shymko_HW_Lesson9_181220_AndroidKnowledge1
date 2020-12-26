package com.example.step_by_step

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Message
import android.util.Log

class MyService : Service() {
    var Tag = "MyService"

    /*companion object
    var serviceState = 0
*/


    companion object {
        var resultsofServiceCalculation:Int = 0
        var serviceOnStartCommand = 0
    }



    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        ShowLog("onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
/*
        ShowLog("onStartCommand")
        val intent = Intent()
        val runnable = Runnable {
            for (i in 1..10) {
                serviceState = 0
                intent.putExtra(MyReceiver.MY_RECEIVER_MESSAGE, "serviceState is $serviceState")
                intent.action=MyReceiver.MY_RECEIVER_ACTION
                sendBroadcast(intent)
                ShowLog("Service doing something $i")
                Thread.sleep(1000)
            }
            stopSelf()
            serviceState = 1
//            val intent = Intent()
            intent.putExtra(MyReceiver.MY_RECEIVER_MESSAGE, "serviceState is $serviceState")
            intent.action=MyReceiver.MY_RECEIVER_ACTION
            sendBroadcast(intent)
        }

        val thread =Thread(runnable)
        thread.start()
*/








        ///////
        ShowLog( "onStartCommand")
        serviceOnStartCommand=0
        resultsofServiceCalculation =0
        for (i in 1 .. 5 ){

            resultsofServiceCalculation++
            ShowLog("calculation iteration is $i value of resultsofServiceCalculation is $resultsofServiceCalculation   serviceOnStartCommand is $serviceOnStartCommand")

            Thread.sleep(1000)
        }
        ShowLog("Result of calculation is - $resultsofServiceCalculation")

        serviceOnStartCommand = 1
        val intent = Intent()
        intent.putExtra(MyReceiver.MY_RECEIVER_MESSAGE, "serviceState is $serviceOnStartCommand")
        intent.action=MyReceiver.MY_RECEIVER_ACTION
        sendBroadcast(intent)
        ShowLog("serviceOnStartCommand is - $serviceOnStartCommand")








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


/*

    companion object {
        var resultsofServiceCalculation:Int = 0
        var serviceOnStartCommand = 0
    }
*/
/*



    val tag = "Custom Service"
    fun ShowLog(massege:String){
        Log.d(tag, massege)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        ShowLog( "onStartCommand")
        serviceOnStartCommand=0
        resultsofServiceCalculation =0
        for (i in 1 .. 5 ){

            resultsofServiceCalculation++
            ShowLog("calculation iteration is $i value of resultsofServiceCalculation is $resultsofServiceCalculation   serviceOnStartCommand is $serviceOnStartCommand")

            Thread.sleep(1000)
        }
        ShowLog("Result of calculation is - $resultsofServiceCalculation")

        serviceOnStartCommand = 1
        ShowLog("serviceOnStartCommand is - $serviceOnStartCommand")
        return super.onStartCommand(intent, flags, startId)
    }

*/



