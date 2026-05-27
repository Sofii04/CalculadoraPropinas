package com.example.calculadorapropinas

// Importa la clase Bundle, necesaria para iniciar la Activity
import android.os.Bundle

// Clase base para crear una pantalla principal en Android
import androidx.activity.ComponentActivity

// Permite usar Jetpack Compose dentro de la Activity
import androidx.activity.compose.setContent

// Permite mostrar imágenes en Compose
import androidx.compose.foundation.Image

// Permite colocar fondos de color o degradados
import androidx.compose.foundation.background

// Permite organizar elementos con espacios
import androidx.compose.foundation.layout.Arrangement

// Permite centrar contenido o colocar elementos encima de otros
import androidx.compose.foundation.layout.Box

// Permite organizar los elementos verticalmente
import androidx.compose.foundation.layout.Column

// Permite agregar espacios entre elementos
import androidx.compose.foundation.layout.Spacer

// Permite que un elemento ocupe toda la pantalla
import androidx.compose.foundation.layout.fillMaxSize

// Permite que un elemento ocupe todo el ancho disponible
import androidx.compose.foundation.layout.fillMaxWidth

// Permite definir una altura específica
import androidx.compose.foundation.layout.height

// Permite agregar espacio alrededor o dentro de los elementos
import androidx.compose.foundation.layout.padding

// Permite definir tamaño, por ejemplo para el logo
import androidx.compose.foundation.layout.size

// Permite crear bordes redondeados
import androidx.compose.foundation.shape.RoundedCornerShape

// Componente para crear botones
import androidx.compose.material3.Button

// Permite personalizar los colores del botón
import androidx.compose.material3.ButtonDefaults

// Componente para crear tarjetas visuales
import androidx.compose.material3.Card

// Permite personalizar el color de las tarjetas
import androidx.compose.material3.CardDefaults

// Componente para mostrar textos
import androidx.compose.material3.Text

// Indica que una función es una pantalla o componente de Compose
import androidx.compose.runtime.Composable

// Permite leer estados de Compose
import androidx.compose.runtime.getValue

// Permite crear estados que pueden cambiar
import androidx.compose.runtime.mutableStateOf

// Permite recordar valores cuando la pantalla se actualiza
import androidx.compose.runtime.remember

// Permite cambiar estados de Compose
import androidx.compose.runtime.setValue

// Permite alinear elementos
import androidx.compose.ui.Alignment

// Permite modificar tamaño, fondo, padding, sombra, etc.
import androidx.compose.ui.Modifier

// Permite agregar sombra a elementos
import androidx.compose.ui.draw.shadow

// Permite crear degradados de colores
import androidx.compose.ui.graphics.Brush

// Permite usar colores personalizados
import androidx.compose.ui.graphics.Color

// Controla cómo se ajusta la imagen dentro de su espacio
import androidx.compose.ui.layout.ContentScale

// Permite cargar imágenes desde la carpeta drawable
import androidx.compose.ui.res.painterResource

// Permite aplicar negrita y otros pesos al texto
import androidx.compose.ui.text.font.FontWeight

// Permite centrar textos
import androidx.compose.ui.text.style.TextAlign

// Unidad para tamaños y espacios
import androidx.compose.ui.unit.dp

// Unidad para tamaño de letra
import androidx.compose.ui.unit.sp

// Importa el tema visual del proyecto
import com.example.calculadorapropinas.ui.theme.CalculadoraPropinasTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContent permite dibujar la interfaz usando Jetpack Compose
        setContent {

            // Aplicamos el tema visual del proyecto
            CalculadoraPropinasTheme {

                // Esta variable controla qué pantalla se muestra.
                // Al inicio está en false, por eso se muestra la portada.
                var mostrarCalculadora by remember {
                    mutableStateOf(false)
                }

                // Si mostrarCalculadora es true, se muestra la calculadora.
                // Si es false, se muestra la portada.
                if (mostrarCalculadora) {
                    PantallaCalculadora()
                } else {
                    PantallaPortada(
                        onIniciarClick = {
                            // Al presionar el botón Iniciar,
                            // cambiamos el estado para mostrar la calculadora.
                            mostrarCalculadora = true
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaPortada(onIniciarClick: () -> Unit) {

    // Fondo degradado parecido al ejemplo de portada
    val fondoDegradado = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFF9A825), // naranja
            Color(0xFF5FD3C4), // verde agua
            Color(0xFF0D47A1)  // azul
        )
    )

    // Box ocupa toda la pantalla y centra la tarjeta
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(fondoDegradado)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {

        // Card es la tarjeta blanca central
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 12.dp,
                    shape = RoundedCornerShape(24.dp)
                ),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            // Column organiza los elementos de arriba hacia abajo
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // Logo cargado desde res/drawable/logo.jpeg
                // En Kotlin se llama R.drawable.logo, sin escribir .jpeg
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo Universitario Rumiñahui",
                    modifier = Modifier.size(90.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Universitario Rumiñahui",
                    color = Color(0xFF0D47A1),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(22.dp))

                Text(
                    text = "Estudiante:",
                    color = Color(0xFF0D47A1),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Acosta Sofía",
                    color = Color.DarkGray,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "Materia:",
                    color = Color(0xFF0D47A1),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Aplicaciones Móviles",
                    color = Color.DarkGray,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(28.dp))

                Text(
                    text = "Calculadora de\nPropinas",
                    color = Color(0xFFE87500),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    lineHeight = 34.sp
                )

                Spacer(modifier = Modifier.height(30.dp))

                // Botón que cambia de la portada a la pantalla de cálculo
                Button(
                    onClick = onIniciarClick,
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

@Composable
fun PantallaCalculadora() {

    // Estado para guardar el monto ingresado por el usuario
    var montoCuenta by remember {
        mutableStateOf("")
    }

    // Estado para guardar el porcentaje de propina ingresado por el usuario
    var porcentajePropina by remember {
        mutableStateOf("")
    }

    // Usamos el mismo fondo para mantener el diseño de la app
    val fondoDegradado = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFF9A825),
            Color(0xFF5FD3C4),
            Color(0xFF0D47A1)
        )
    )

    // Contenedor principal de la pantalla de calculadora
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(fondoDegradado)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {

        // Tarjeta blanca donde irá la calculadora
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 12.dp,
                    shape = RoundedCornerShape(24.dp)
                ),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            // Column organiza los elementos de la calculadora verticalmente
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Calculadora de Propinas",
                    color = Color(0xFF0D47A1),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Campo para ingresar el monto de la cuenta
                OutlinedTextField(
                    value = montoCuenta,
                    onValueChange = { nuevoTexto ->
                        montoCuenta = nuevoTexto
                    },
                    label = {
                        Text("Monto de la cuenta")
                    },
                    placeholder = {
                        Text("Ejemplo: 25.50")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Campo para ingresar el porcentaje de propina
                OutlinedTextField(
                    value = porcentajePropina,
                    onValueChange = { nuevoTexto ->
                        porcentajePropina = nuevoTexto
                    },
                    label = {
                        Text("Porcentaje de propina")
                    },
                    placeholder = {
                        Text("Ejemplo: 10")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Botón temporal. En el siguiente commit hará el cálculo.
                Button(
                    onClick = {
                        // En el siguiente commit implementaremos el cálculo.
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
                        text = "Calcular Propina",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Ingresa los datos y presiona el botón.",
                    color = Color.DarkGray,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
