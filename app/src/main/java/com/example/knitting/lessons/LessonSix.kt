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
fun LessonSix(navController: NavHostController) {
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
            text = stringResource(R.string.L6_1),
            Modifier.padding(top = 20.dp),
            
            fontSize = 18.sp
        )
        Text(
            text = "Лицевой (выпуклый) рельефный столбик с одним накидом",
            Modifier
                .padding(20.dp)
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.L6_2) +
                    stringResource(R.string.L6_3) +
                    stringResource(R.string.L6_4) +
                    stringResource(R.string.L6_5),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.front_dc),
            contentDescription = "front_dc"
        )
        Text(
            text = "Изнаночный (вогнутый) рельефный столбик с одним накидом",
            Modifier
                .padding(20.dp)
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.L6_6) +
                    stringResource(R.string.L6_7) +
                    stringResource(R.string.L6_8) +
                    stringResource(R.string.L6_9),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.back_dc),
            contentDescription = "back_dc"
        )
        Text(
            text = "Лицевой (выпуклый) рельефный столбик с двумя накидами",
            Modifier
                .padding(20.dp)
                .align(alignment = Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.L6_10) +
                    stringResource(R.string.L6_11),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.front_tr1),
            contentDescription = "front_tr1"
        )
        Text(
            text = stringResource(R.string.L6_12) +
                    stringResource(R.string.L6_13) +
                    stringResource(R.string.L6_14),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.front_tr2),
            contentDescription = "front_tr2"
        )
    }
}