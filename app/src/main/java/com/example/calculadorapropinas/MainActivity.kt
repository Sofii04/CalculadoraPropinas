package com.example.calculadorapropinas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadorapropinas.R
import com.example.calculadorapropinas.ui.theme.CalculadoraPropinasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContent permite mostrar la interfaz hecha con Jetpack Compose
        setContent {
            // Tema visual del proyecto
            CalculadoraPropinasTheme {
                // Llamamos a la pantalla de portada
                PantallaPortada()
            }
        }
    }
}

@Composable
fun PantallaPortada() {

    // Creamos un fondo degradado vertical parecido al ejemplo
    val fondoDegradado = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFF9A825), // Color naranja en la parte superior
            Color(0xFF5FD3C4), // Color verde agua en el centro
            Color(0xFF0D47A1)  // Color azul en la parte inferior
        )
    )

    // Box permite colocar elementos encima de otros y centrar el contenido
    Box(
        modifier = Modifier
            .fillMaxSize() // Ocupa toda la pantalla
            .background(fondoDegradado) // Aplica el fondo degradado
            .padding(24.dp), // Espacio alrededor de la pantalla
        contentAlignment = Alignment.Center // Centra la tarjeta en pantalla
    ) {

        // Card es la tarjeta blanca central donde va la información
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 12.dp,
                    shape = RoundedCornerShape(24.dp)
                ),
            shape = RoundedCornerShape(24.dp), // Bordes redondeados
            colors = CardDefaults.cardColors(
                containerColor = Color.White // Color de la tarjeta
            )
        ) {

            // Column organiza los elementos de arriba hacia abajo
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(28.dp), // Espacio interno de la tarjeta
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // Imagen del logo cargada desde la carpeta drawable
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo Universitario Rumiñahui",
                    modifier = Modifier
                        .size(90.dp), // Tamaño del logo
                    contentScale = ContentScale.Fit // Ajusta la imagen sin deformarla
                )

                // Spacer agrega espacio vertical entre elementos
                Spacer(modifier = Modifier.height(20.dp))

                // Nombre de la institución
                Text(
                    text = "Universitario Rumiñahui",
                    color = Color(0xFF0D47A1),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(22.dp))

                // Etiqueta del estudiante
                Text(
                    text = "Estudiante:",
                    color = Color(0xFF0D47A1),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                // Nombre del estudiante
                Text(
                    text = "Acosta Sofía",
                    color = Color.DarkGray,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(18.dp))

                // Etiqueta de la materia
                Text(
                    text = "Materia:",
                    color = Color(0xFF0D47A1),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                // Nombre de la materia
                Text(
                    text = "Aplicaciones Móviles",
                    color = Color.DarkGray,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(28.dp))

                // Título principal de la aplicación
                Text(
                    text = "Calculadora de\nPropinas",
                    color = Color(0xFFE87500),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    lineHeight = 34.sp
                )

                Spacer(modifier = Modifier.height(30.dp))

                // Botón de inicio
                Button(
                    onClick = {
                        // En el siguiente paso este botón abrirá
                        // la pantalla donde calcularemos la propina
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF0D47A1)
                    )
                ) {
                    Text(
                        text = "Iniciar",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}