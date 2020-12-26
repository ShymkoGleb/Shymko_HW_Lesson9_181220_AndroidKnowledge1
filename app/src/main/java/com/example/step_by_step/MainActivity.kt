package com.example.step_by_step

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //////////////    MyReceiver   ////////////////


        registerReceiver(MyReceiver(),IntentFilter(MyReceiver.MY_RECEIVER_ACTION))
        val intent = Intent(this, MyService::class.java)
        startService(intent)


        //////////////    Service     ////////////////////

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
            }
        }

        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
//            Intent(this, MyService::class.java).also {
//                stopService(it)
/*
            val intent = Intent()
            intent.putExtra(MyReceiver.MY_RECEIVER_MESSAGE, "AOKDJASj")
            intent.action=MyReceiver.MY_RECEIVER_ACTION
            sendBroadcast(intent)
*/
            }
        }

    //////////////    BroadcustResiver ////////////////////

//        IntentFilter(Intent.ACTION_DEFAULT).also {
//
//            registerReceiver(MyReceiver(), it)
//        }
//    }



    }
//}