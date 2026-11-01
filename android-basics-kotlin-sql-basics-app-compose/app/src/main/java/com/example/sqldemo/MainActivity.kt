/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.sqldemo

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Room
import com.example.sqldemo.ui.theme.SQLDemoTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    val TAG = "MainActivity"
    lateinit var db : AppDatabase
    lateinit var emailDao: EmailDao

    companion object {
        var maxId: Int = 0
        // var emailList : List<Email> = List<Email>(size = 100, init = { id : Int ->  Email(folder = "inbox", starred = false, read = false, received = 1, sender = "sender1", subject = "subject1",id=-100) })
        var emailList :ArrayList<Email> = ArrayList<Email>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch {
            AppDatabase.getDatabase(applicationContext).emailDao().getAll()
        }
        this.createDB()
        this.createDao()
        this.getMaxId()

        setContentView(R.layout.database_layout)
    }

    fun createDB(){
        this.db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
    }

    fun createDao(){
        this.emailDao = this.db.emailDao()
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun queryData(view: View) {
        try {
            Log.d(TAG,"start call of queryData method.")
            val resultTextView = findViewById<TextView>(R.id.result_id)
            val subjectEditText = findViewById<EditText>(R.id.subject_id)
            val senderEditText = findViewById<EditText>(R.id.sender_id)
            GlobalScope.launch {
                MainActivity.emailList = AppDatabase.getDatabase(applicationContext).emailDao()
                    .getRows(
                        subject = subjectEditText.text.toString(),
                        sender = senderEditText.text.toString()
                    ) as ArrayList<Email>
            }

            Log.d(TAG,"The length of MainActivity.emailList: ${MainActivity.emailList.size}")
            var resultText: String = ""
            for (i in 0..MainActivity.emailList.size - 1) {
                val email: Email = MainActivity.emailList.get(i)
                Log.d(TAG,"i:${i},email.toString():${email.toString()}")
                if(email.id != -100) {
                    Log.d(TAG,"i:${i},email.id:${email.id}")
                    resultText += email.toString()
                }
            }
            Log.d(TAG,"The resultText: $resultText")

            resultTextView.text = resultText
        }catch (e : Exception){
            Log.e(TAG,e.stackTraceToString())
        }finally {
            Log.d(TAG,"end call of queryData method.")
        }
    }
    @OptIn(DelicateCoroutinesApi::class)
    fun getMaxId(){
        try{
            Log.d(TAG,"Start call of getMaxId method.")
            GlobalScope.launch {
                MainActivity.maxId = AppDatabase.getDatabase(applicationContext).emailDao().getMaxId()
            }
        }catch(e:Exception){
            Log.e(TAG,e.stackTraceToString())
        }finally {
            Log.d(TAG,"end call of getMaxId method.")
        }
    }
    @OptIn(DelicateCoroutinesApi::class)
    fun insertData(view: View){
        try {
            Log.d(TAG,"Start to call insertData method.")

            this.getMaxId()

            val subjectEditText = findViewById<EditText>(R.id.subject_id)
            val senderEditText = findViewById<EditText>(R.id.sender_id)
            val email: Email = Email(folder = "inbox", starred = false, read = false, received = 1, sender = senderEditText.text.toString(), subject = subjectEditText.text.toString(),id=MainActivity.maxId+1)

            Log.d(TAG,email.toString())

            GlobalScope.launch {
                AppDatabase.getDatabase(applicationContext).emailDao().insertOne(email)
            }
        }catch (e:Exception){
            Log.e(TAG,e.message?:"null")
            Log.e(TAG,e.stackTraceToString())
        }finally{
            Log.d(TAG,"Finish to call insertData method.")
        }
    }
}
