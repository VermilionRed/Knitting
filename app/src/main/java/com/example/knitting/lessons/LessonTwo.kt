package com.example.knitting.lessons

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.knitting.NavRoutes
import com.example.knitting.R
import com.example.knitting.ReturnButton

@Composable
fun LessonTwo(navController: NavHostController) {
    val darkBlue = Color(0xFF485A6C)
    Column(
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 15.dp)
            .verticalScroll(rememberScrollState())
    ) {
        ReturnButton(modifier = Modifier
            .border(width = 2.dp, color = darkBlue, shape = RoundedCornerShape(20.dp))
            .clickable { navController.navigate(NavRoutes.Lessons.route) }
            .padding(10.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.left_arrow),
            contentDescription = "Вернуться к урокам"
        )
        Text(
            text = stringResource(R.string.L2_1),
            Modifier.padding(top = 20.dp),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.step_a),
            contentDescription = "step_a"
        )
        Text(
            text = stringResource(R.string.L2_2),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.step_b),
            contentDescription = "step_b"
        )
        Text(
            text = stringResource(R.string.L2_3) +
                    stringResource(R.string.L2_4),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.step_c),
            contentDescription = "step_c"
        )
        Text(
            text = stringResource(R.string.L2_5),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.all_chain),
            contentDescription = "all_chain"
        )
        Text(
            text = stringResource(R.string.L2_6) +
                    "\n" +
                    stringResource(R.string.L2_7),
            fontSize = 18.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 20.dp),
            bitmap = ImageBitmap.imageResource(R.drawable.steps),
            contentDescription = "steps"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LessonTwoPreview() {
    LessonTwo(navController = rememberNavController())
}