package com.example.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio4.ui.theme.Laboratorio4Theme


class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainCard2()
                }
            }
        }
    }
}

@Composable
fun MainCard2(modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth()
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row(
                modifier = Modifier
                    .padding(5.dp)
                    .offset(x = 130.dp)
            ){
                Text(
                    text = "My Profile",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(7.dp),
                    textAlign = TextAlign.Center
                )
            }
            Row(
                modifier = Modifier.padding(5.dp)
            ){
                Image(
                    painter = painterResource(R.drawable.config_foreground),
                    contentDescription = null,
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ){
            Image(
                painter = painterResource(R.drawable.niebla6),
                contentDescription = null,
                modifier = Modifier
                    .alpha(0.7f)
                    .fillMaxWidth()
                    .height(230.dp),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 160.dp)
                    .clip(RoundedCornerShape(75.dp))
            ){
                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(5.dp)
                        .width(130.dp)
                        .height(130.dp)
                        .border(
                            width = 2.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(75.dp)
                        )
                        .clip(RoundedCornerShape(75.dp))
                        .align(Alignment.Center)
                        .fillMaxSize()
                        .background(Color.LightGray),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Spacer(modifier = Modifier.height(70.dp))
        Text(
            text = "Nelson Eduardo García Bravatti",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(7.dp),
            textAlign = TextAlign.Center
        )
        HorizontalCardDoubleText(R.drawable.sombrero_foreground, "My Campus","Campus Central")
        HorizontalCard(R.drawable.amigos_foreground, "My Friends")
        HorizontalCard(R.drawable.calendario_foreground, "My Calendar")
        HorizontalCard(R.drawable.libro_foreground, "My Courses")
        HorizontalCard(R.drawable.notas_foreground, "My Grades")
        HorizontalCard(R.drawable.puntos_foreground, "My Groups")
        HorizontalCard(R.drawable.calendario2_foreground, "My Upcoming Events")
    }
}

@Composable
fun HorizontalCard(@DrawableRes imagen: Int, titulo: String,modifier: Modifier = Modifier){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .drawBehind {
                val borderSize = 1.dp.toPx()
                drawLine(
                    color = Color.LightGray,
                    start = Offset(x = 0f, y = 0f),
                    end = Offset(x = size.width, y = 0f),
                    strokeWidth = borderSize
                )
            }
    ){
        Box(
            modifier = Modifier
                .align(Alignment.CenterVertically)
        ){
            Image(
                painter = painterResource(imagen),
                contentDescription = null
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth()
        ){
            Text(
                text = titulo,
                fontSize = 20.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(4.dp)
            )
        }
    }
}

@Composable
fun HorizontalCardDoubleText(@DrawableRes imagen: Int, titulo: String, texto: String,modifier: Modifier = Modifier){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .drawBehind {
                val borderSize = 1.dp.toPx()
                drawLine(
                    color = Color.LightGray,
                    start = Offset(x = 0f, y = 0f),
                    end = Offset(x = size.width, y = 0f),
                    strokeWidth = borderSize
                )
            }
    ){
        Box(
            modifier = Modifier
                .align(Alignment.CenterVertically)
        ){
            Image(
                painter = painterResource(imagen),
                contentDescription = null
            )
        }
        Box(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth()
                .fillMaxHeight()
        ){
            Text(
                text = titulo,
                fontSize = 20.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.TopStart)
            )
            Text(
                text = texto,
                fontSize = 15.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.BottomStart)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    Laboratorio4Theme {
        MainCard2()
    }
}


