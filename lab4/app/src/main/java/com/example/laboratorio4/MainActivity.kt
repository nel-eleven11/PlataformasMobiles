package com.example.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio4.ui.theme.Laboratorio4Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainCard()
                }
            }
        }
    }
}

@Composable
fun MainCard(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.niebla1)
    val image2 = painterResource(R.drawable.niebla2)
    val image3 = painterResource(R.drawable.niebla3)
    val image4 = painterResource(R.drawable.niebla4)
    val image5 = painterResource(R.drawable.niebla5)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        Text(
            text = "Campus Central",
            fontSize = 20.sp,
            modifier = Modifier.padding(5.dp)
        )
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Text(
            text = "Destacados",
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Start).padding(5.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth().height(150.dp)
        ){
            Column(modifier = Modifier.weight(1f).padding(5.dp)){

                Image(
                    painter = image2,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clip(RoundedCornerShape(4.dp))
                )
                Surface(
                    color = Color.Green,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.Green,
                            shape = MaterialTheme.shapes.medium
                        )
                        .clip(RoundedCornerShape(4.dp))
                ){
                    Text(
                        text = "Service Now ",
                        fontSize = 20.sp,
                        modifier = modifier.padding(5.dp),
                        color = Color.White
                    )
                }
            }
            Column(modifier = Modifier.weight(1f).padding(5.dp)){
                Image(
                    painter = image3,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clip(RoundedCornerShape(4.dp))
                )
                Surface(
                    color = Color.Green,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.Green,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clip(RoundedCornerShape(4.dp))
                ){
                    Text(
                        text = "Actualidad UVG",
                        fontSize = 20.sp,
                        modifier = modifier.padding(5.dp),
                        color = Color.White
                    )
                }
            }
        }
        Text(
            text = "Servicios y Recursos",
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Start).padding(5.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth().height(150.dp)
        ){
            Column(modifier = Modifier.weight(1f).padding(5.dp)){
                Image(
                    painter = image4,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clip(RoundedCornerShape(4.dp))
                )
                Surface(
                    color = Color.Green,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.Green,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clip(RoundedCornerShape(4.dp))
                ){
                    Text(
                        text = "Servicios Estudiantiles",
                        fontSize = 20.sp,
                        modifier = modifier.padding(5.dp),
                        color = Color.White
                    )
                }
            }
            Column(modifier = Modifier.weight(1f).padding(5.dp)){
                Image(
                    painter = image5,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clip(RoundedCornerShape(4.dp))
                )
                Surface(
                    color = Color.Green,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.Green,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clip(RoundedCornerShape(4.dp))
                ){
                    Text(
                        text = "Portal Web",
                        fontSize = 20.sp,
                        modifier = modifier.padding(5.dp),
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Laboratorio4Theme {
        MainCard()
    }
}