package com.example.step_by_step

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    companion object {
        const val MY_RECEIVER_ACTION = "MY_RECEIVER_ACTION"
        const val MY_RECEIVER_MESSAGE = "MY_RECEIVER_MESSAGE"
    }


    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, intent.getStringExtra(MY_RECEIVER_MESSAGE), Toast.LENGTH_SHORT)
            .show()
    }
}
