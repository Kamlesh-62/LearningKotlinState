package com.example.learningstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.learningstate.ui.theme.LearningStateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            LearningStateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Incrementer()
                }
            }
        }
    }

    @Composable
    fun Incrementer(){
        var value = remember { mutableStateOf(0) }
        var lastButton by remember { mutableStateOf("") }

        Column {
            Text("Current Value : ${value.value}")
            Text("Last Button : ${lastButton} triggered")

            Button(onClick = {
                value.value += 1
                lastButton = "Increase"
            }) {
                Text("Increase")
            }

            Button(onClick = {
                if (value.value != 0) {
                    value.value -= 1

                }
                lastButton = "Decrease"
            }) {
                Text("Decrease")
            }
        }
    }
}
