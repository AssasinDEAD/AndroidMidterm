package com.example.midterm

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Dialog

@Composable
fun FilmContent(
    film: Film,
    modifier: Modifier = Modifier,
    showFullContent: Boolean = false
) {
    // Состояние для управления отображением полноэкранного изображения
    var showFullScreenImage by remember { mutableStateOf(false) }

    if (showFullScreenImage) {
        // Полноэкранное изображение
        Dialog(onDismissRequest = { showFullScreenImage = false }) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { showFullScreenImage = false }, // Закрытие при клике
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = film.imageRes),
                    contentDescription = "Film poster",
                    modifier = Modifier.fillMaxSize() // Изображение на весь экран
                )
            }
        }
    } else {
        if (showFullContent) {
            // Вертикальное расположение для детального экрана
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Изображение с возможностью увеличения
                Image(
                    painter = painterResource(id = film.imageRes),
                    contentDescription = "Film poster",
                    modifier = Modifier
                        .size(200.dp)
                        .clickable { showFullScreenImage = true } // Нажатие для увеличения
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = film.title, fontSize = 24.sp)

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = film.description, fontSize = 16.sp)

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Рейтинг: ${film.rating}", fontSize = 16.sp)
            }
        } else {
            // Горизонтальное расположение для списка
            Row(
                modifier = modifier
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = film.imageRes),
                    contentDescription = "Film poster",
                    modifier = Modifier
                        .size(100.dp)
                        .clickable { showFullScreenImage = true } // Нажатие для увеличения
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(text = film.title, fontSize = 18.sp)

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Рейтинг: ${film.rating}", fontSize = 16.sp)
                }
            }
        }
    }
}
