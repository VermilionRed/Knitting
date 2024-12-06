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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.knitting.NavRoutes
import com.example.knitting.R
import com.example.knitting.ReturnButton

@Composable
fun LessonFive(navController: NavHostController) {
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
            text = "СТОЛБИК С НАКИДОМ (ССН)",
            Modifier
                .padding(20.dp)
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.L5_1) +
                    "\n" +
                    stringResource(R.string.L5_2),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.dc1),
            contentDescription = "dc1"
        )
        Text(
            text = stringResource(R.string.L5_3),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.dc2),
            contentDescription = "dc2"
        )
        Text(
            text = stringResource(R.string.L5_4),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.dc3),
            contentDescription = "dc3"
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.dc),
            contentDescription = "dc"
        )
        Text(
            text = "СТОЛБИК С ДВУМЯ НАКИДАМИ (С2Н)",
            Modifier
                .padding(20.dp)
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.L5_5) +
                    "\n" +
                    stringResource(R.string.L5_6) +
                    stringResource(R.string.L5_7) +
                    stringResource(R.string.L5_8) +
                    stringResource(R.string.L5_9),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.tr),
            contentDescription = "tr"
        )
        Text(
            text = "СТОЛБИК С ТРЕМЯ НАКИДАМИ (С3Н)",
            Modifier
                .padding(20.dp)
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.L5_10),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.dtr),
            contentDescription = "dtr"
        )
    }
}