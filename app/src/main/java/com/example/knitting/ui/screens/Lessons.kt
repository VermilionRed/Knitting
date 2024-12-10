package com.example.knitting.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.knitting.ui.navigation.NavRoutes

//The lessons window
@Composable
fun Lessons(navController: NavHostController) {
    Column {
        LessonButton(
            modifier = Modifier
                .clickable { navController.navigate(NavRoutes.LessonOne.route) }
                .fillMaxWidth(),
            text = "Урок №1: Как правильно держать крючок и нить"
        )
        LessonButton(
            modifier = Modifier
                .clickable { navController.navigate(NavRoutes.LessonTwo.route) }
                .fillMaxWidth(),
            text = "Урок №2: Набор петель крючком"
        )
        LessonButton(
            modifier = Modifier
                .clickable { navController.navigate(NavRoutes.LessonThree.route) }
                .fillMaxWidth(),
            text = "Урок №3: Полустолбик"
        )
        LessonButton(
            modifier = Modifier
                .clickable { navController.navigate(NavRoutes.LessonFour.route) }
                .fillMaxWidth(),
            text = "Урок №4: Столбик без накида"
        )
        LessonButton(
            modifier = Modifier
                .clickable { navController.navigate(NavRoutes.LessonFive.route) }
                .fillMaxWidth(),
            text = "Урок №5: Столбик с накидом"
        )
        LessonButton(
            modifier = Modifier
                .clickable { navController.navigate(NavRoutes.LessonSix.route) }
                .fillMaxWidth(),
            text = "Урок №6: Рельефные столбики"
        )
    }
}

@Composable
fun ToggleButtonColumn(viewModel: ToggleButtonViewModel) {
    val toggleButtons by viewModel.allToggleButtons.observeAsState(emptyList())
    val uiState = ToggleButtonUiState(toggleButtons)

    Column {
        uiState.toggleButtons.forEach { toggleButton ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Toggle Button ${toggleButton.id}")
                Switch(
                    checked = toggleButton.isChecked,
                    onCheckedChange = { isChecked ->
                        val updatedButton = toggleButton.copy(isChecked = isChecked)
                        viewModel.updateToggleButton(updatedButton)
                    }
                )
            }
        }
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

@Preview(showBackground = true)
@Composable
fun LessonsPreview() {
    Lessons(navController = rememberNavController())
}