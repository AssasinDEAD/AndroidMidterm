package com.example.midterm

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete

@Composable
fun FilmItem(film: Film, navController: NavHostController, onDelete: (Film) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                // Переход на детальный экран фильма
                navController.navigate("detail/${film.title}")
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = film.imageRes),
                contentDescription = "Film poster",
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = film.title, fontSize = 20.sp)

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Рейтинг: ${film.rating}", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Кнопка "Удалить"
            IconButton(onClick = { onDelete(film) }) {
                Icon(Icons.Default.Delete, contentDescription = "Удалить фильм")
            }
        }
    }
}
