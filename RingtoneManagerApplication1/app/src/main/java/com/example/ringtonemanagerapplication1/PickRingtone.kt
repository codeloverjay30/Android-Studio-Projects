package com.example.ringtonemanagerapplication1

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.hardware.Sensor.TYPE_ALL
import android.media.RingtoneManager
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContract
import androidx.core.content.ContextCompat.startActivity

class PickRingtone : ActivityResultContract<Int, Uri?>() {
    lateinit var intent : Intent
    override fun createIntent(context: Context, ringtoneType: Int): Intent {
        val intent = Intent(RingtoneManager.ACTION_RINGTONE_PICKER).apply {
            putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, ringtoneType)
        }
        this.intent = intent
        return intent
    }


    override fun parseResult(resultCode: Int, result: Intent?) : Uri? {
        if (resultCode != Activity.RESULT_OK) {
            return null
        }
        return result?.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI)
    }
}