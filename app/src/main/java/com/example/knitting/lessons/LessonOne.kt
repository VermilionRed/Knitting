package com.example.knitting.lessons

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.knitting.NavRoutes
import com.example.knitting.R
import com.example.knitting.ReturnButton

@Composable
fun LessonOne(navController: NavHostController) {
    val darkBlue = Color(0xFF485A6C)
    Column(
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 15.dp)
            .verticalScroll(rememberScrollState())
    ) {
        ReturnButton(modifier = Modifier
            .padding(top = 20.dp)
            .clickable { navController.navigate(NavRoutes.Lessons.route) }
            .border(width = 2.dp, color = darkBlue, shape = RoundedCornerShape(20.dp))
            .padding(10.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.left_arrow),
            contentDescription = "Вернуться к урокам"
        )
        Text(
            text = "КАК ДЕРЖАТЬ НИТЬ",
            Modifier
                .padding(20.dp)
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.L1_1),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.how_to_hold_the_thread_1),
            contentDescription = "how_to_hold_the_thread_1"
        )
        Text(
            text = stringResource(R.string.L1_2),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.how_to_hold_the_thread_2),
            contentDescription = "how_to_hold_the_thread_2"
        )
        Text(
            text = "КАК ДЕРЖАТЬ КРЮЧОК",
            Modifier
                .padding(20.dp)
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.L1_3) +
                    stringResource(R.string.L1_4),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.how_to_hold_the_hook),
            contentDescription = "how_to_hold_the_thread_1"
        )
        Text(
            text = stringResource(R.string.L1_5),
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LessonOnePreview() {
    LessonOne(navController = rememberNavController())
}