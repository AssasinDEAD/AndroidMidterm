package com.example.midterm

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddFilmDialog(onAddFilm: (Film) -> Unit, onDismiss: () -> Unit) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf("") }
    val context = LocalContext.current

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = "Добавить новый фильм") },
        text = {
            Column {
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Название фильма") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Описание фильма") },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 5
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextField(
                    value = rating,
                    onValueChange = { rating = it },
                    label = { Text("Рейтинг") },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Заглушка для изображения, если пользователь не выбрал изображение
                Image(
                    painter = painterResource(id = R.drawable.sample_image),
                    contentDescription = "Выбрать изображение",
                    modifier = Modifier.size(100.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text("Выберите изображение (заглушка)")
            }
        },
        confirmButton = {
            Button(onClick = {
                if (title.isNotEmpty() && description.isNotEmpty() && rating.isNotEmpty()) {
                    val parsedRating = rating.toFloatOrNull() ?: 0f
                    // Добавление фильма с заглушкой изображения
                    onAddFilm(Film(title, description, parsedRating, R.drawable.sample_image))
                } else {
                    Toast.makeText(context, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text("Добавить")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text("Отмена")
            }
        }
    )
}
