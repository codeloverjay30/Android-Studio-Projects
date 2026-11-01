package com.example.myalarmexample1

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.AlarmClock.ACTION_SET_ALARM
import android.provider.AlarmClock.EXTRA_HOUR
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.provider.AlarmClock.EXTRA_MINUTES
import android.util.Log
import android.view.View
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold

import androidx.compose.ui.Modifier
import com.example.myalarmexample1.ui.theme.MyAlarmExample1Theme

class MainActivity : ComponentActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    private fun addAnAlarm(
                            hour:Int,
                           minute:Int,
                           second:Int,
                            extra_message: String
    )
    {
        val alarm_awake_notify_message = findViewById<TextView>(R.id.alarm_awake_notify_message)
        alarm_awake_notify_message.visibility=VISIBLE
        // Create the text message with a string.
        val intent = Intent().apply {
            action = ACTION_SET_ALARM
            putExtra(EXTRA_HOUR, hour)
            putExtra(EXTRA_MINUTES, minute)
            putExtra(EXTRA_MINUTES, second)
            putExtra(EXTRA_MESSAGE,extra_message)
            // clear all previous activity
            intent.setFlags(FLAG_ACTIVITY_CLEAR_TOP)
        }
        // Try to invoke the intent.
        startActivity(intent)
    }
    fun AddAlarm(view: View){
        try {
            // Theoritically, one will add alarms where (hour,minute) is {(0,0),(0,1),(0,2),...,(23,59)}
            // However, since one device can NOT set lots of alarms,
            // thus, the alarm with random hour and random minute is set.
            val second = 0
            for(hour in 0..24 - 1) {
                for(minute in 0..60 - 1) {
                    this.addAnAlarm(hour,minute,second,"morning call")
                }
            }
        } catch (e: Exception) {
            // Define what your app should do if no activity can handle the intent.
            Log.e(TAG, e.message ?: "null")
        }
    }
}



