package com.example.knitting

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

//The function that controls the buttons. Throws it at other windows
@Composable
fun NavigationGraph(modifier: Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavRoutes.Home.route
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