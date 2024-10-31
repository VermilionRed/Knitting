package com.example.knitting

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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