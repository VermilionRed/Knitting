package com.example.knitting

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

//The lessons window
@Composable
fun Lessons(navController: NavHostController) {
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

@Preview(showBackground = true)
@Composable
fun LessonsPreview() {
    Lessons(navController = rememberNavController())
}