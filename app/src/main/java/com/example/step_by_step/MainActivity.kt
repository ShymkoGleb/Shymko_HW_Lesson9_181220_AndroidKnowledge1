package com.example.step_by_step

import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.p2p.WifiP2pManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //////////////    MyReceiver   ////////////////

        registerReceiver(MyReceiver(), IntentFilter(MyReceiver.MY_RECEIVER_ACTION))

        //////////////    Service     ////////////////////
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                supportFragmentManager.beginTransaction().apply {
                    replace(
                        R.id.fragment,
                        FragmentBlank.newInstance(MyService.resultsofServiceCalculation)
                    )
                    commit()
                }
            }


        }

    }
}
