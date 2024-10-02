package com.example.knitting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.knitting.ui.theme.KnittingTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main()
        }
    }
}

@Composable
fun Main() {
    val navController = rememberNavController()
    Column(
        Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        NavHost(navController, startDestination = NavRoutes.Home.route) {
            composable(NavRoutes.Home.route) { Home() }
            composable(NavRoutes.Lessons.route) { Lessons()  }
            composable(NavRoutes.Designations.route) { Designations() }
            composable(NavRoutes.Settings.route) { Settings() }
        }
        NavBar(navController = navController)
    }
}
@Composable
fun NavBar(navController: NavController){
    val myColor = Color(0xFF485A6C)
    Row(
        Modifier
            .fillMaxWidth()
            .background(myColor),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text("Главная",
            Modifier
                .weight(0.33f)
                .clickable { navController.navigate(NavRoutes.Home.route) }
                .padding(vertical = 20.dp),
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color= Color(0xFFFFFFFF))
        Text("Все уроки",
            Modifier
                .weight(0.33f)
                .clickable { navController.navigate(NavRoutes.Lessons.route) },
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color= Color(0xFFFFFFFF))
        Text("Обозначения",
            Modifier
                .weight(0.33f)
                .clickable { navController.navigate(NavRoutes.Designations.route) },
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color= Color(0xFFFFFFFF))
        Text("Настройки",
            Modifier
                .weight(0.33f)
                .clickable { navController.navigate(NavRoutes.Settings.route) },
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color= Color(0xFFFFFFFF))
    }
}

@Composable
fun Home(){
    Text("Здесь будет инфа о прогрессе",
        Modifier.padding(30.dp),
        fontSize = 30.sp)
}
@Composable
fun Lessons(){
    Text("Здесь будут уроки",
        Modifier.padding(30.dp),
        fontSize = 30.sp)
}
@Composable
fun Designations(){
    Text("Здесь будут условные обозначения",
        Modifier.padding(30.dp),
        fontSize = 30.sp)
}
@Composable
fun Settings(){
    Text("Настройки",
        Modifier.padding(30.dp),
        fontSize = 30.sp)
}

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object Lessons : NavRoutes("lessons")
    object Designations : NavRoutes("designations")
    object Settings : NavRoutes("settings")
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Main()
}