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


class MainActivity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainCard4()
                }
            }
        }
    }
}

@Composable
fun MainCard4(modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth()
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .drawBehind {
                    val borderSize = 2.dp.toPx()
                    drawLine(
                        color = Color.LightGray,
                        start = Offset(x = 0f, y = 0f),
                        end = Offset(x = size.width, y = 0f),
                        strokeWidth = borderSize
                    )
                }
        ) {
            Row(
                modifier = Modifier.padding(5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.equis_foreground),
                    contentDescription = null,
                )
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Emergency Contacts",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(7.dp)
                        .offset(x = -20.dp)
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
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
            HorizontalCardDoubleTextRoundImg(imagen = R.drawable.emergencia_foreground, titulo ="Emergencias",
                texto ="Si se presenta un incidente o percance por favor marca el número de emergencia y rápidamente te apoyamos.")
            NumberCard(numero = "5978-1736")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
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
            HorizontalCardDoubleTextRoundImg(imagen = R.drawable.niebla14, titulo ="Clínica UVG",
                texto ="La Clínica UVG, presta los siguientes servicios:\n" +
                        "°Atención a Emergencias" +"°Atención Primaria a Enfermedades Comunes" +
                        "°Plan Educacional sobre Enfermedades\n" +
                        "Horario de Atención: 7:00a.m. a 8:30p.m." +
                        "Campues Central Edificio F 119-120.")
            NumberCard(numero = "2507-1500 ex 21312")
        }
    }
}

@Composable
fun HorizontalCardDoubleTextRoundImg(@DrawableRes imagen: Int, titulo: String, texto: String,modifier: Modifier = Modifier){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ){
        Box(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clip(RoundedCornerShape(4.dp))
        ){
            Image(
                painter = painterResource(imagen),
                contentDescription = null,
                modifier = Modifier
                    .padding(5.dp)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .clip(RoundedCornerShape(4.dp))
                    .align(Alignment.Center)
                    .fillMaxSize()
                    .background(Color.White),
                contentScale = ContentScale.Crop
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
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.TopStart)
            )
            Text(
                text = texto,
                fontSize = 10.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.BottomStart)
            )
        }
    }
}

@Composable
fun NumberCard(numero: String,modifier: Modifier = Modifier){
    Surface(
        color = Color.Green,
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 7.dp,
                color = Color.White,
                shape = RoundedCornerShape(4.dp)
            )
            .clip(RoundedCornerShape(4.dp))
    ){
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ){
            Box(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            ){
                Image(
                    painter = painterResource(R.drawable.telefono_foreground),
                    contentDescription = null
                )
            }
            Box(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxWidth()
            ){
                Text(
                    text = "Call "+numero,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    color = Color.White,
                    modifier = Modifier
                        .padding(4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview4() {
    Laboratorio4Theme {
        MainCard4()
    }
}