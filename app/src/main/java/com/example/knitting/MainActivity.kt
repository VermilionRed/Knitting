package com.example.knitting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val myColor = Color(0xFF485A6C)

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing),
        //  ^^^ This remains System UI bars.
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = myColor,
                    titleContentColor = Color.White,
                ),
                title = {
                    Text(currentRoute.toString())
                }
            )
        },
        bottomBar = { NavBar(navController = navController) },
    ) { innerPadding ->
        NavigationGraph(
            modifier = Modifier
                .padding(innerPadding),
            navController = navController
        )
    }
}

@Composable
fun NavigationGraph(modifier: Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavRoutes.Lessons.route
    ) {
        composable(NavRoutes.Home.route) { Home() }
        composable(NavRoutes.Lessons.route) { Lessons(navController) }
        composable(NavRoutes.Designations.route) { Designations() }
        composable(NavRoutes.Settings.route) { Settings() }
        composable(NavRoutes.One.route) { One() }
    }
}

@Composable
fun NavBar(navController: NavHostController) {
    val myColor = Color(0xFF485A6C)
    BottomAppBar(
        containerColor = myColor,
        actions = {
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
    )
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
                .size(35.dp)
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
fun Lessons(navController: NavHostController) {
    val myColor = Color(0xFF485A6C)
    Column {
        LessonButton(modifier = Modifier
            .clickable { navController.navigate(NavRoutes.One.route) },
            text = "ZZdng"
        )
    }
}

@Composable
fun One(){
    Text(text = "kn df klvnfsvk f")
}

@Composable
fun LessonButton(modifier: Modifier, text: String) {
    Text(
        text = text,
        modifier = modifier
    )
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
    object Home : NavRoutes("Главная")
    object Lessons : NavRoutes("Уроки")
    object Designations : NavRoutes("Обозначения")
    object Settings : NavRoutes("Настройки")
    object One : NavRoutes("One")
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Main()
}