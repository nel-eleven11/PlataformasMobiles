package com.example.migaleriaproy

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.migaleriaproy.ui.theme.MiGaleriaProyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiGaleriaProyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardLogin()
                }
            }
        }
    }
    @Deprecated("Deprecated", ReplaceWith("finishAffinity()"))
    override fun onBackPressed() {
        finishAffinity()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardLogin(modifier: Modifier = Modifier){
    var usuarioInput by remember {mutableStateOf("") }
    var contraseñaInput by remember {mutableStateOf("") }
    val context = LocalContext.current
    val configuracionVista = LocalConfiguration.current
    var contraseñaVisible by remember { mutableStateOf(false) }
    val icon = if(contraseñaVisible) R.drawable.visib_on_foreground else R.drawable.visib_off_foreground
    val maxChar1 = 10
    val maxChar2 = 8
    val usuario = "admin"
    val contraseña = "admin"

    when(configuracionVista.orientation){
        Configuration.ORIENTATION_PORTRAIT ->{
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ){
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "Login Mi Galería",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(7.dp),
                        textAlign = TextAlign.Center
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .drawBehind {
                            val borderSize = 1.dp.toPx()
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(x = 0f, y = 0f),
                                end = Offset(x = size.width, y = 0f),
                                strokeWidth = borderSize
                            )
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(x = 0f, y = size.height),
                                end = Offset(x = size.width, y = size.height),
                                strokeWidth = borderSize
                            )
                        }
                ){
                    OutlinedTextField(
                        value = usuarioInput,
                        singleLine = true,
                        onValueChange = {
                            if(it.length <= maxChar1){
                                usuarioInput = it
                            }
                            else{
                                Toast.makeText(context, "Máximo 10 caracteres", Toast.LENGTH_SHORT).show()
                            }
                        },
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.user_foreground),null)},
                        label = { Text(stringResource(R.string.usuario)) },
                        placeholder = { Text("Escriba su Usuario") },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(7.dp),
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .drawBehind {
                            val borderSize = 1.dp.toPx()
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(x = 0f, y = 0f),
                                end = Offset(x = size.width, y = 0f),
                                strokeWidth = borderSize
                            )
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(x = 0f, y = size.height),
                                end = Offset(x = size.width, y = size.height),
                                strokeWidth = borderSize
                            )
                        }
                ){
                    OutlinedTextField(
                        value = contraseñaInput,
                        singleLine = true,
                        onValueChange = {
                            if(it.length <= maxChar2){
                                contraseñaInput = it
                            }
                            else{
                                Toast.makeText(context, "Máximo 8 caracteres", Toast.LENGTH_SHORT).show()
                            }
                        },
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.llave_foreground),null)},
                        label = { Text(stringResource(R.string.contraseña)) },
                        placeholder = { Text("Escriba su Contraseña") },
                        trailingIcon = {
                            IconButton(
                                onClick = { contraseñaVisible = !contraseñaVisible }
                            ){
                                Icon(
                                    painterResource(id = icon),
                                    contentDescription = null
                                )
                            }
                        },
                        visualTransformation = if(contraseñaVisible) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(7.dp),
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        if(contraseñaInput == contraseña && usuarioInput == usuario){
                            Toast.makeText(context, "Bienvenido", Toast.LENGTH_SHORT).show()
                            val intent = Intent(context, MainGalery::class.java)
                            context.startActivity(intent)
                        }else {
                            Toast.makeText(context, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                        }
                    },
                    contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
                    modifier = Modifier
                        .padding(25.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(35, 171, 54)
                    )
                ){
                    Text(
                        text = "Iniciar Sesión",
                        modifier = Modifier
                            .padding(7.dp)
                            .fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }

        Configuration.ORIENTATION_LANDSCAPE ->{
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ){
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "Login Mi Galería",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(7.dp),
                        textAlign = TextAlign.Center
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .drawBehind {
                            val borderSize = 1.dp.toPx()
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(x = 0f, y = 0f),
                                end = Offset(x = size.width, y = 0f),
                                strokeWidth = borderSize
                            )
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(x = 0f, y = size.height),
                                end = Offset(x = size.width, y = size.height),
                                strokeWidth = borderSize
                            )
                        }
                ){
                    OutlinedTextField(
                        value = usuarioInput,
                        singleLine = true,
                        onValueChange = {
                            if(it.length <= maxChar1){
                                usuarioInput = it
                            }
                            else{
                                Toast.makeText(context, "Máximo 10 caracteres", Toast.LENGTH_SHORT).show()
                            }
                        },
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.user_foreground),null)},
                        label = { Text(stringResource(R.string.usuario)) },
                        placeholder = { Text("Escriba su Usuario") },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .padding(7.dp),
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .drawBehind {
                            val borderSize = 1.dp.toPx()
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(x = 0f, y = 0f),
                                end = Offset(x = size.width, y = 0f),
                                strokeWidth = borderSize
                            )
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(x = 0f, y = size.height),
                                end = Offset(x = size.width, y = size.height),
                                strokeWidth = borderSize
                            )
                        }
                ){
                    OutlinedTextField(
                        value = contraseñaInput,
                        singleLine = true,
                        onValueChange = {
                            if(it.length <= maxChar2){
                                contraseñaInput = it
                            }
                            else{
                                Toast.makeText(context, "Máximo 8 caracteres", Toast.LENGTH_SHORT).show()
                            }
                        },
                        leadingIcon = { Icon(painter = painterResource(id = R.drawable.llave_foreground),null)},
                        label = { Text(stringResource(R.string.contraseña)) },
                        placeholder = { Text("Escriba su Contraseña") },
                        trailingIcon = {
                            IconButton(
                                onClick = { contraseñaVisible = !contraseñaVisible }
                            ){
                                Icon(
                                    painterResource(id = icon),
                                    contentDescription = null
                                )
                            }
                        },
                        visualTransformation = if(contraseñaVisible) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .padding(7.dp),
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        if(contraseñaInput == contraseña && usuarioInput == usuario){
                            Toast.makeText(context, "Bienvenido", Toast.LENGTH_SHORT).show()
                            val intent = Intent(context, MainGalery::class.java)
                            context.startActivity(intent)
                        }else {
                            Toast.makeText(context, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                        }
                    },
                    contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
                    modifier = Modifier
                        .padding(25.dp)
                        .fillMaxWidth(0.4f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(35, 171, 54)
                    )
                ){
                    Text(
                        text = "Iniciar Sesión",
                        modifier = Modifier
                            .padding(7.dp)
                            .fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MiGaleriaProyTheme {
        CardLogin()
    }
}