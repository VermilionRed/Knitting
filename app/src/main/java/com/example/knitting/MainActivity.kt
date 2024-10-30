package com.example.knitting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
    val darkBlue = Color(0xFF485A6C)

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing),
        //  ^^^ This remains System UI bars.
        contentWindowInsets = ScaffoldDefaults.contentWindowInsets,
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = darkBlue,
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

//The function that controls the buttons. Throws it at other windows
@Composable
fun NavigationGraph(modifier: Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavRoutes.Designations.route
    ) {
        composable(NavRoutes.Home.route) { Home() }
        composable(NavRoutes.Lessons.route) { Lessons(navController) }
        composable(NavRoutes.Designations.route) { Designations() }
        composable(NavRoutes.Settings.route) { Settings() }
        composable(NavRoutes.LessonOne.route) { LessonOne(navController) }
        composable(NavRoutes.LessonTwo.route) { LessonTwo(navController) }
        composable(NavRoutes.LessonThree.route) { LessonThree(navController) }
    }
}

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("Главная")
    object Lessons : NavRoutes("Уроки")
    object Designations : NavRoutes("Обозначения")
    object Settings : NavRoutes("Настройки")
    object LessonOne : NavRoutes("Урок №1")
    object LessonTwo : NavRoutes("Урок №2")
    object LessonThree : NavRoutes("Урок №3")
}

//Changing the bottom bar, buttons, images
@Composable
fun NavBar(navController: NavHostController) {
    val darkBlue = Color(0xFF485A6C)
    BottomAppBar(
        containerColor = darkBlue,
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

//Bottom bar button pattern, design
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

//The home window
@Composable
fun Home() {
    Column(
        Modifier
    ) {
        Box(modifier = Modifier) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                alpha = 0.3f,
                bitmap = ImageBitmap.imageResource(R.drawable.yarn_balls),
                contentScale = ContentScale.FillWidth,
                contentDescription = "Вязание с нуля",
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(70.dp),
                    bitmap = ImageBitmap.imageResource(R.drawable.knitting_colored),
                    contentDescription = "Вязание с нуля",
                )
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(220.dp),
                    bitmap = ImageBitmap.imageResource(R.drawable.title),
                    contentDescription = "Вязание с нуля",
                )
            }
        }
        Text(
            "Ваш прогресс:",
            Modifier
                .padding(start = 20.dp, top = 10.dp),
            fontSize = 18.sp
        )
    }
}

//The lessons window
@Composable
fun Lessons(navController: NavHostController) {
    val darkBlue = Color(0xFF485A6C)
    Column {
        LessonButton(
            modifier = Modifier
                .clickable { navController.navigate(NavRoutes.LessonOne.route) }
                .fillMaxWidth(),
            text = "Урок №1"
        )
        LessonButton(
            modifier = Modifier
                .clickable { navController.navigate(NavRoutes.LessonTwo.route) }
                .fillMaxWidth(),
            text = "Урок №2"
        )
        LessonButton(
            modifier = Modifier
                .clickable { navController.navigate(NavRoutes.LessonThree.route) }
                .fillMaxWidth(),
            text = "Урок №3"
        )
    }
}

//Lesson button pattern, design
@Composable
fun LessonButton(
    modifier: Modifier,
    text: String
) {
    Text(
        text = text,
        modifier = modifier
            .border(width = 1.dp, color = Color.Gray)
            .padding(6.dp),
        fontSize = 20.sp
    )
}

//Windows inside the lessons
@Composable
fun LessonOne(navController: NavHostController) {
    val darkBlue = Color(0xFF485A6C)
    Column(
        modifier = Modifier.padding(top = 5.dp, start = 5.dp)
    ) {
        ReturnButton(modifier = Modifier
            .border(width = 2.dp, color = darkBlue, shape = RoundedCornerShape(20.dp))
            .clickable { navController.navigate(NavRoutes.Lessons.route) }
            .padding(10.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.left_arrow),
            contentDescription = "Вернуться к урокам"
        )
        Text(text = "111")
    }
}

@Composable
fun LessonTwo(navController: NavHostController) {
    val darkBlue = Color(0xFF485A6C)
    Column(
        modifier = Modifier.padding(top = 5.dp, start = 5.dp)
    ) {
        ReturnButton(modifier = Modifier
            .border(width = 2.dp, color = darkBlue, shape = RoundedCornerShape(20.dp))
            .clickable { navController.navigate(NavRoutes.Lessons.route) }
            .padding(10.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.left_arrow),
            contentDescription = "Вернуться к урокам"
        )
        Text(text = "222")
    }
}

@Composable
fun LessonThree(navController: NavHostController) {
    val darkBlue = Color(0xFF485A6C)
    Column(
        modifier = Modifier.padding(top = 5.dp, start = 5.dp)
    ) {
        ReturnButton(modifier = Modifier
            .border(width = 2.dp, color = darkBlue, shape = RoundedCornerShape(20.dp))
            .clickable { navController.navigate(NavRoutes.Lessons.route) }
            .padding(10.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.left_arrow),
            contentDescription = "Вернуться к урокам"
        )
        Text(text = "333")
    }
}

//Return button pattern, design
@Composable
fun ReturnButton(
    modifier: Modifier,
    bitmap: ImageBitmap,
    contentDescription: String
) {
    Row(modifier) {
        Image(
            modifier = Modifier
                .size(25.dp),
            bitmap = bitmap,
            contentDescription = contentDescription,
        )
        Text(
            contentDescription,
            Modifier
                .align(Alignment.CenterVertically),
            fontSize = 18.sp
        )
    }
}

@Composable
fun Designations() {
    Column(
        Modifier
    ) {
        val desList = listOf(
            Designation("Символ/Sumbol"),
            Designation("US Crochet term"),
            Designation("Обозначение"),

            Image(ImageBitmap.imageResource(R.drawable.left_arrow)),
            Designation("Start"),
            Designation("Начало вязания"),

            Image(ImageBitmap.imageResource(R.drawable.left_arrow)),
            Designation("End"),
            Designation("Конец вязания"),

            Image(ImageBitmap.imageResource(R.drawable.left_arrow)),
            Designation("ch, chain stitch"),
            Designation("в.п., воздушная петля, петля, цепочка из петель"),

            Image(ImageBitmap.imageResource(R.drawable.left_arrow)),
            Designation("End"),
            Designation("Конец вязания"),

            Image(ImageBitmap.imageResource(R.drawable.left_arrow)),
            Designation("End"),
            Designation("Конец вязания"),

            Image(ImageBitmap.imageResource(R.drawable.left_arrow)),
            Designation("End"),
            Designation("Конец вязания"),

            Image(ImageBitmap.imageResource(R.drawable.left_arrow)),
            Designation("End"),
            Designation("Конец вязания"),

            Image(ImageBitmap.imageResource(R.drawable.left_arrow)),
            Designation("End"),
            Designation("Конец вязания"),

            Image(ImageBitmap.imageResource(R.drawable.left_arrow)),
            Designation("End"),
            Designation("Конец вязания"),
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize()
        ) {
            itemsIndexed(desList){ index, item ->
                when (item) {
                    is Designation -> {
                        Text(
                            item.text,
                            fontSize = 24.sp,
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                    is Image -> {
                        Image(
                            bitmap = item.imageBitmap,
                            contentDescription = "image",
                            modifier = Modifier
                                .size(50.dp)
                                .padding(5.dp)
                        )
                    }
                }
            }
        }
    }
}

data class Designation(val text: String)
data class Image(val imageBitmap: ImageBitmap)

@Composable
fun Settings() {
    Text(
        "Настройки",
        Modifier.padding(30.dp),
        fontSize = 30.sp
    )
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Main()
}