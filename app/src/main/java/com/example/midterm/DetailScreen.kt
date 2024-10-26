package com.example.midterm

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(itemName: String, navController: NavHostController) {
    // Находим фильм по названию из списка
    val film = filmList.find { it.title == itemName } ?: return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FilmContent(film = film, showFullContent = true)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Back")
        }
    }
}
