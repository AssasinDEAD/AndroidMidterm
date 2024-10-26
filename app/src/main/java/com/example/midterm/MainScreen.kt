package com.example.midterm

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navController: NavHostController) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(filmList.size) { index ->
            FilmItem(film = filmList[index], navController = navController)
        }
    }
}

@Composable
fun FilmItem(film: Film, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                navController.navigate("detail/${film.title}")
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        FilmContent(film = film, modifier = Modifier.fillMaxSize(), showFullContent = false)
    }
}
