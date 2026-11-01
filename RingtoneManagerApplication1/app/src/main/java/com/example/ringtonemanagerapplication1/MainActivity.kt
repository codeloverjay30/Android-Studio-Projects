package com.example.ringtonemanagerapplication1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ringtonemanagerapplication1.ui.theme.RingtoneManagerApplication1Theme

class MainActivity : ComponentActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.manageRingtone()
    }
    fun manageRingtone(){
        try {
            val pickRingtone = PickRingtone()
            startActivity(pickRingtone.intent)
        }catch(e:Exception){
            Log.e(TAG,e.message?:"null")
        }
    }
}