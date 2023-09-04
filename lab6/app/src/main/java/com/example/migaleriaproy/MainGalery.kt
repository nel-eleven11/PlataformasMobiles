package com.example.migaleriaproy

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.migaleriaproy.ui.theme.MiGaleriaProyTheme
import kotlinx.coroutines.launch

class MainGalery : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiGaleriaProyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Galery()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Galery(modifier: Modifier = Modifier){
    val context = LocalContext.current
    val jugadores = listOf(
        R.drawable.cristiano,
        R.drawable.kroos,
        R.drawable.lahm,
        R.drawable.neuer,
        R.drawable.muller,
        R.drawable.ramos,
        R.drawable.bastian,
        R.drawable.modric,
        R.drawable.casemiro,
        R.drawable.lewa,
    )
    val jugInfo = listOf(
        "Cristiano Ronaldo",
        "Toni Kroos",
        "Philipp Lahm",
        "Manuel Neuer",
        "Thomas Müller",
        "Sergio Ramos",
        "Bastian Schweinsteiger",
        "Luka Modric",
        "Casemiro",
        "Robert Lewandowski",
    )
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ){
        HorizontalPager(
            pageCount = jugadores.size,
            state = pagerState,
            pageSize = PageSize.Fill
        ){index ->
            Image(
                painter = painterResource(id = jugadores[index]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Box(
            modifier = Modifier
                .offset(y = (20).dp)
                .fillMaxWidth(0.5f)
                .clip(RoundedCornerShape(100))
                .background(MaterialTheme.colorScheme.background.copy(alpha = 0.5f))
                .align(Alignment.TopCenter)
        ){
            IconButton(
                onClick = { val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)},
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
            ){
                Icon(painter = painterResource(id = R.drawable.logout_foreground) , contentDescription = "Terminar Sesión")
            }
        }

        Box(
            modifier = Modifier
                .offset(y = -(90).dp)
                .fillMaxWidth(0.7f)
                .height(50.dp)
                .clip(RoundedCornerShape(100))
                .background(MaterialTheme.colorScheme.background.copy(alpha = 0.5f))
                .align(Alignment.BottomCenter)
        ){
            Text(
                text = jugInfo[pagerState.currentPage],
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
        }

        Box(
            modifier = Modifier
                .offset(y = -(16).dp)
                .fillMaxWidth(0.5f)
                .clip(RoundedCornerShape(100))
                .background(MaterialTheme.colorScheme.background)
                .padding(8.dp)
                .align(Alignment.BottomCenter)
        ){
            IconButton(
                onClick = {
                    scope.launch{
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                },
                modifier = Modifier.align(Alignment.CenterStart),
            ) {
                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "Anterior" )
            }
            IconButton(
                onClick = {
                    scope.launch{
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                },                    modifier = Modifier.align(Alignment.CenterEnd),
            ) {
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "Siguiente" )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    MiGaleriaProyTheme {
        Galery()
    }
}