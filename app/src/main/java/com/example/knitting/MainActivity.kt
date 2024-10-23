package com.example.knitting

import android.os.Bundle
import android.view.WindowInsets
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
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
            //.windowInsetsPadding(WindowInsets.safeDrawing)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        NavHost(navController, startDestination = NavRoutes.Lessons.route) {
            composable(NavRoutes.Home.route) { Home() }
            composable(NavRoutes.Lessons.route) { Lessons() }
            composable(NavRoutes.Designations.route) { Designations() }
            composable(NavRoutes.Settings.route) { Settings() }
        }
        NavBar(navController = navController)
    }
}

@Composable
fun NavBar(navController: NavController) {
    val myColor = Color(0xFF485A6C)
    Row(
        Modifier
            .fillMaxWidth()
            .background(myColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavBarButton(modifier = Modifier
            .clickable { navController.navigate(NavRoutes.Home.route) }
            .weight(0.25f)
            .padding(vertical = 10.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.home),
            contentDescription = "Главная"
        )
        NavBarButton(modifier = Modifier
            .clickable { navController.navigate(NavRoutes.Lessons.route) }
            .weight(0.25f)
            .padding(vertical = 10.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.list),
            contentDescription = "Уроки"
        )
        NavBarButton(
            modifier = Modifier
                .clickable { navController.navigate(NavRoutes.Designations.route) }
                .weight(0.25f)
                .padding(vertical = 10.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.knitting),
            contentDescription = "Обозначения",
        )
        NavBarButton(modifier = Modifier
            .clickable { navController.navigate(NavRoutes.Settings.route) }
            .weight(0.25f)
            .padding(vertical = 10.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.settings),
            contentDescription = "Настройки"
        )
    }
}

@Composable
fun NavBarButton(
    modifier: Modifier,
    bitmap: ImageBitmap,
    contentDescription: String
) {
    Column(modifier) {
        Image(
            modifier = Modifier
                .size(40.dp)
                .align(Alignment.CenterHorizontally),
            bitmap = bitmap,
            contentDescription = contentDescription,
        )
        Text(
            contentDescription,
            Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 5.dp),
            fontSize = 12.sp,
            color = Color(0xFFFFFFFF)
        )
    }
}

@Composable
fun Home() {
    Column(
        Modifier
        //.fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            bitmap = ImageBitmap.imageResource(R.drawable.yarn_balls),
            contentScale = ContentScale.FillWidth,
            contentDescription = "Вязание с нуля",
        )
        Text(
            "Ваш прогресс:",
            Modifier
                .padding(start = 20.dp, top = 10.dp),
            fontSize = 30.sp
        )
    }
}

@Composable
fun Lessons() {
    val myColor = Color(0xFF485A6C)
    Column {
        Text(
            "Уроки",
            Modifier
                .background(myColor)
                .padding(vertical = 20.dp)
                .fillMaxWidth(),
            fontSize = 30.sp,
            color = Color(0xFFFFFFFF)
        )
        Text(
            "1 урок",
            Modifier
                //.background(myColor)
                .padding(vertical = 20.dp)
                .fillMaxWidth(),
            fontSize = 30.sp,
            //color = Color(0xFFFFFFFF)
        )
    }
}

@Composable
fun Designations() {
    Column(
        Modifier
    ) {
        Text(
            "Обозначения",
            Modifier
                .fillMaxWidth(),
            fontSize = 30.sp
        )
        Text(
            "Здесь будут условные обозначения",
            Modifier.padding(top = 30.dp),
            fontSize = 30.sp
        )
    }
}

@Composable
fun Settings() {
    Text(
        "Настройки",
        Modifier.padding(30.dp),
        fontSize = 30.sp
    )
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
    //Designations()
}