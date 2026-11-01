package com.example.mynavigation2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.mynavigation2.ui.theme.MyNavigation2Theme
import kotlinx.serialization.Serializable



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNavigation2Theme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting()
{
    val navController = rememberNavController()

    @Serializable
    object FriendsList

    navController.navigate(route = FriendsList.toString())
}
