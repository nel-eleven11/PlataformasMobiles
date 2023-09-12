package com.example.quenotesalgacaro

import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quenotesalgacaro.ui.theme.QueNoTeSalgaCaroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QueNoTeSalgaCaroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val context = LocalContext.current
    val dates = arrayOf("Ago 2023", "Sep 2023", "Oct 2023", "Nov 2023", "Dic 2023")
    val wallets = arrayOf("Wallet 1", "Wallet 2", "Wallet 3", "Wallet 4", "Wallet 5")
    var expandedDate by remember { mutableStateOf(false) }
    var expandedWallet by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf(dates[0]) }
    var selectedWallet by remember { mutableStateOf(wallets[0]) }

    val saldo = 7430.41
    val total = 12000.00
    val progress = (total - saldo)/total

    var elementosTabla = mutableListOf<FilaTabla>(
        FilaTabla("1", "Comida", "Q100.00"),
        FilaTabla("2", "Comida", "Q100.00"),
        FilaTabla("2","Cine","Q50.00"),
        FilaTabla("3", "Comida", "Q100.00"),
        FilaTabla("4", "Comida", "Q100.00"),
        FilaTabla("5", "Comida", "Q100.00"),
        FilaTabla("6", "Gasolina", "Q400.00"),
        FilaTabla("7", "Comida", "Q100.00"),
        FilaTabla("8", "Comida", "Q100.00"),
        FilaTabla("9","Super","Q2000.00")
    )
    Column (
        modifier = Modifier.fillMaxWidth()
    ) {
        Box {
            Surface (
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Text(
                    text = "Que no te salga caro",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,

                )
            }
            Box (
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ){
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .align(alignment = Alignment.CenterEnd)
                        .width(53.dp)
                        .height(53.dp)
                    ) {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.outline_settings_24
                        ),
                        contentDescription = "Settings",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )

                }
            }
        }

        ExposedDropdownMenuBox(
            expanded = expandedDate,
            onExpandedChange = {
                expandedDate = !expandedDate
            },
            modifier = Modifier
                .padding(12.dp)
                .align(alignment = Alignment.CenterHorizontally),

        ) {

            TextField(
                value = selectedDate,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedDate) },
                modifier = Modifier
                    .menuAnchor()
                    .width(180.dp),
                label = {
                    Text(
                        text = "Fecha"
                    )
                },
            )
            ExposedDropdownMenu(
                expanded = expandedDate,
                onDismissRequest = { expandedDate = false }
            ) {
                dates.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedDate = item
                            expandedDate = false
                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
        Row {
            Column (
                modifier = Modifier
                    .weight(5f)
                    .padding(12.dp),
            ){
                ExposedDropdownMenuBox(
                    expanded = expandedWallet,
                    onExpandedChange = {
                        expandedWallet = !expandedWallet
                    },
                    modifier = Modifier
                        .padding(12.dp)
                        .align(alignment = Alignment.CenterHorizontally),

                    ) {

                    TextField(
                        value = selectedWallet,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedWallet) },
                        modifier = Modifier
                            .menuAnchor(),
                        label = {
                            Text(
                                text = "Wallet"
                            )
                        },
                    )
                    ExposedDropdownMenu(
                        expanded = expandedWallet,
                        onDismissRequest = { expandedWallet = false }
                    ) {
                        wallets.forEach { item ->
                            DropdownMenuItem(
                                text = { Text(text = item) },
                                onClick = {
                                    selectedWallet = item
                                    expandedWallet = false
                                    Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                                }
                            )
                        }
                    }
                }
                Column (
                    modifier = Modifier.padding(12.dp),
                ){
                    Text (
                        text = "Saldo",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text (
                        text = "Q$saldo",
                        style = MaterialTheme.typography.displaySmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
            Box (
                modifier = Modifier.weight(4f),
            ) {
                CircularProgressIndicator(
                    progress = progress.toFloat(),
                    modifier = Modifier
                        .width(160.dp)
                        .aspectRatio(1f)
                        .align(alignment = Alignment.Center)
                        .padding(12.dp),
                    strokeWidth = 16.dp,
                    color = when(progress) {
                        in 0.0..0.5 -> Color(57,255,20)
                        in 0.5..0.8 -> Color(255,255,0)
                        in 0.8..0.99 -> Color(255,0,0)
                        else -> {
                            Color(80,0,0)
                        }
                    }
                )
                Text (
                    text = "${(progress*100).toInt()}%",
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.align(alignment = Alignment.Center)
                )
            }
        }
        Row {
            Text(
                text = "Dia",
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp),
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = "Cantegoria",
                modifier = Modifier
                    .weight(3f)
                    .padding(12.dp)
            )
            Text(
                text = "Monto",
                modifier = Modifier
                    .weight(2f)
                    .padding(12.dp)
            )
            Text(
                text = "",
                modifier = Modifier
                    .weight(2f)
                    .padding(12.dp)
            )
        }
        LazyColumn (
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(elementosTabla.size) { index ->
                Row {

                    Text(
                        text = elementosTabla[index].dia,
                        modifier = Modifier
                            .weight(1f)
                            .padding(12.dp),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = elementosTabla[index].categoria,
                        modifier = Modifier
                            .weight(3f)
                            .padding(12.dp)
                    )
                    Text(
                        text = elementosTabla[index].monto,
                        modifier = Modifier
                            .weight(2f)
                            .padding(12.dp)
                    )
                    IconButton(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .weight(2f)
                            ) {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.option
                            ),
                            contentDescription = "Opciones",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}




@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    QueNoTeSalgaCaroTheme {
        MainScreen()
    }
}