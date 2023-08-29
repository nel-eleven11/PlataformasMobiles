package com.example.laboratorio5

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio5.ui.theme.Laboratorio5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio5Theme {
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
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Bold
        )
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(5.dp)
        )
        Text(
            text = "Destacados",
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(5.dp),
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ){
            Column(modifier = Modifier
                .weight(1f)
                .padding(5.dp)){
                Image(
                    painter = image2,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .height(140.dp)
                        .fillMaxWidth()
                        .border(
                            width = 0.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clip(RoundedCornerShape(4.dp))
                )
                Surface(
                    color = Color(35, 171, 54),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 0.dp,
                            color = Color(35, 171, 54),
                            shape = MaterialTheme.shapes.medium
                        )
                        .clip(RoundedCornerShape(4.dp))
                ){
                    Text(
                        text = "Service Now ",
                        fontSize = 20.sp,
                        modifier = modifier.padding(7.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Column(modifier = Modifier
                .weight(1f)
                .padding(5.dp)){
                Image(
                    painter = image3,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .height(140.dp)
                        .fillMaxWidth()
                        .border(
                            width = 0.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clip(RoundedCornerShape(4.dp))
                )
                Surface(
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 0.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clip(RoundedCornerShape(4.dp))
                ){
                    Text(
                        text = "Actualidad UVG",
                        fontSize = 20.sp,
                        modifier = modifier.padding(7.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Text(
            text = "Servicios y Recursos",
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(5.dp),
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ){
            Column(modifier = Modifier
                .weight(1f)
                .padding(5.dp)){
                Image(
                    painter = image4,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .height(140.dp)
                        .fillMaxWidth()
                        .border(
                            width = 0.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clip(RoundedCornerShape(4.dp))
                )
                Surface(
                    color = Color(35, 171, 54),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 0.dp,
                            color = Color(35, 171, 54),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clip(RoundedCornerShape(4.dp))

                ){
                    Text(
                        text = "Directorio Servi",
                        fontSize = 20.sp,
                        modifier = modifier.padding(7.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Column(modifier = Modifier
                .weight(1f)
                .padding(5.dp)){
                Image(
                    painter = image5,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .height(140.dp)
                        .fillMaxWidth()
                        .border(
                            width = 0.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clip(RoundedCornerShape(4.dp))
                )
                Surface(
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 0.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .clip(RoundedCornerShape(4.dp))
                ){
                    Text(
                        text = "Portal Web",
                        fontSize = 20.sp,
                        modifier = modifier.padding(7.dp),
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Laboratorio5Theme {
        MainCard()
    }
}