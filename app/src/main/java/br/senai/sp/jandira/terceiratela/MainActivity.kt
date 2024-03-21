package br.senai.sp.jandira.terceiratela

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.terceiratela.ui.theme.TerceiraTelaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TerceiraTelaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Image(
        painter = painterResource(id = R.drawable.mcqueen),
        contentDescription = "Background da tela",
        contentScale = ContentScale.Crop
    )
    Column(
        modifier = Modifier.padding(32.dp)
    ){
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Botão de Busca",
                        tint = Color.White
                    )
                }
            },
            placeholder = {
                Text(
                    text = "Buscar McQueen",
                    color = Color(0xFFFFFFFF)
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
               unfocusedBorderColor = Color.White,
                focusedBorderColor = Color(0xFFFFFFFF)
                )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Lista de CARROS",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ){
            items(10){
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(bottom = 8.dp),
                    colors = CardDefaults
                        .cardColors(containerColor = Color(0x75000000)
                        ),
                    border = BorderStroke(
                        width = 4.dp,
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color.Yellow, Color.Red),

                        )
                    )
                ) {
                    Row (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Card(
                            modifier = Modifier
                                .size(width = 100.dp, height = 100.dp),
                            shape = CircleShape
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.carros),
                                contentDescription = "",
                                contentScale = ContentScale.Crop
                            )
                        }
                        Column (
                            modifier = Modifier
                                .padding(start = 20.dp)
                        ){
                            Text(
                                text = "McQueen",
                                fontSize = 28.sp,
                                color = Color.Red,
                                letterSpacing = 8.sp

                            )
                            Text(
                                text = "O astro das corridas, Relâmpago McQueen, e o carro-guincho",
                                fontSize = 14.sp,
                                color = Color.Yellow,
                                lineHeight = 20.sp,

                            )
                        }
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TerceiraTelaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting()
        }
    }
}