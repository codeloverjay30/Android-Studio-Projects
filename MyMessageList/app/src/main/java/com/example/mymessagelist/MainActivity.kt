package com.example.mymessagelist

import android.os.Bundle
import android.os.Message
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mymessagelist.ui.theme.MyMessageListTheme

val TAG = "MainActivity"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyMessageListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    Column(
                        modifier = Modifier
                            .padding(padding)
                    ) {
                        Log.d(TAG,"Start!!!")
                        Text("Hello")
                        AddItems()
                        val messages = AddMessages()
                        MessageList(messages = messages)
                        Log.d(TAG,"Done!!!")
                    }
                }
            }
        }
    }

    private fun AddMessages() : List<Message> {
        val messages = List<Message>(5,  { index: Int -> InitMessage(index = index) } )
        return messages

    }
    private fun InitMessage(index:Int) : Message{
        var message = Message()
        message.arg1 = index
        message.arg2 = index
        return message
    }


    @Composable
    private fun AddItems() {
        Log.d(TAG,"AddItems() was called.")
        LazyColumn {
            // Add a single item
            item {
                Text(text = "First item")
            }

            // Add 5 items
            items(5) { index ->
                Text(text = "Item: $index")
            }

            // Add another single item
            item {
                Text(text = "Last item")
            }
        }
        Log.d(TAG,"AddItems() was finish called.")
    }
}

@Composable
fun MessageList(messages: List<Message>) {
    Column {
        messages.forEach { message ->
            MessageRow(message)
        }
    }
}

@Composable
fun MessageRow(message: Message) {
    Log.d(TAG,message.toString())
}
