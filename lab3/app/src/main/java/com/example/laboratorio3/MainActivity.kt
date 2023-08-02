package com.example.laboratorio3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio3.ui.theme.Laboratorio3Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio3Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Nelson", 22434)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String,carnet: Int, modifier: Modifier = Modifier) {
    Surface(color = Color.Blue){
        Text(
            text = "Hola mi nombre es $name! y mi numero de carnet es $carnet",
            modifier = modifier.padding(24.dp),
            fontSize = 24.sp,
            color = Color.White

        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Laboratorio3Theme {
        Greeting("Nelson",22434)
    }
}