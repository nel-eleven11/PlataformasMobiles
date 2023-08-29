package com.example.laboratorio5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio5.ui.theme.Laboratorio5Theme


class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio5Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainCard3()
                }
            }
        }
    }
}

@Composable
fun MainCard3(modifier: Modifier = Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.padding(5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.equis_playstore),
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
                    text = "Settings",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(7.dp)
                        .offset(x = -20.dp)
                )
            }
        }
        HorizontalCard(imagen = R.drawable.profile_playstore, titulo = "Edit Profile")
        HorizontalCard(imagen = R.drawable.email_playstore, titulo = "Email Addresses")
        HorizontalCard(imagen = R.drawable.campana_playstore, titulo = "Notifications")
        HorizontalCard(imagen = R.drawable.privacidad_playstore, titulo = "Privacy")
        Surface(
            color = Color.LightGray,
            modifier = Modifier.fillMaxWidth()
        ){
            Spacer(
                modifier = Modifier.height(10.dp)
            )
        }
        HorizontalCardDoubleText(imagen = R.drawable.interrogacion_playstore, titulo = "Help & Feedback", texto ="Troubleshooting tips and guides")
        HorizontalCardDoubleText(imagen = R.drawable.info_playstore, titulo = "About", texto ="App information and documents")
        Surface(
            color = Color.LightGray,
            modifier = Modifier.fillMaxWidth()
        ){
            Spacer(
                modifier = Modifier.height(10.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(5.dp)
                .drawBehind {
                    val borderSize = 1.dp.toPx()
                    drawLine(
                        color = Color.LightGray,
                        start = Offset(x = 0f, y = size.height),
                        end = Offset(x = size.width, y = size.height),
                        strokeWidth = borderSize
                    )
                }
        ){
            Text(
                text = "Logout",
                fontSize = 20.sp,
                modifier = Modifier.padding(7.dp),
                textAlign = TextAlign.Center,
                color = Color.Red
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview3() {
    Laboratorio5Theme {
        MainCard3()
    }
}