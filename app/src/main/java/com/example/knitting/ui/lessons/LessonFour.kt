package com.example.knitting.ui.lessons

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.knitting.R
import com.example.knitting.ui.navigation.NavRoutes
import com.example.knitting.ui.navigation.ReturnButton

@Composable
fun LessonFour(navController: NavHostController) {
    val darkBlue = Color(0xFF485A6C)
    Column(
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 15.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
    ) {
        ReturnButton(modifier = Modifier
            .padding(top = 20.dp)
            .border(width = 2.dp, color = darkBlue, shape = RoundedCornerShape(20.dp))
            .clickable { navController.navigate(NavRoutes.Lessons.route) }
            .padding(10.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.left_arrow),
            contentDescription = "Вернуться к урокам"
        )
        Text(
            text = "СТОЛБИК БЕЗ НАКИДА",
            Modifier
                .padding(20.dp)
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.L4_1) +
                    "\n" +
                    stringResource(R.string.L4_2),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.front_back),
            contentDescription = "front_back"
        )
        Text(
            text = stringResource(R.string.L4_3) +
                    "\n" +
                    stringResource(R.string.L4_4),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.take_chain),
            contentDescription = "take_chain"
        )
        Text(
            text = stringResource(R.string.L4_5),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.sc1),
            contentDescription = "sc1"
        )
        Text(
            text = stringResource(R.string.L4_6),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.sc2),
            contentDescription = "sc2"
        )
        Text(
            text = stringResource(R.string.L4_7),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.sc3),
            contentDescription = "sc3"
        )
        Text(
            text = stringResource(R.string.L4_8),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.sc4),
            contentDescription = "sc4"
        )
        Text(
            text = stringResource(R.string.L4_9) +
                    "\n" +
                    stringResource(R.string.L4_10) +
                    stringResource(R.string.L4_11),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.sc),
            contentDescription = "sc"
        )
    }
}