package com.example.midterm

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navController: NavHostController) {
    var films by remember { mutableStateOf(filmList) }

    var showAddFilmDialog by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 56.dp)
        ) {
            items(films.size) { index ->
                FilmItem(
                    film = films[index],
                    navController = navController,
                    onDelete = { filmToDelete ->
                        films = films.filter { it != filmToDelete }
                    }
                )
            }
        }

        FloatingActionButton(
            onClick = { showAddFilmDialog = true },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Text("+", fontSize = 24.sp)
        }

        if (showAddFilmDialog) {
            AddFilmDialog(
                onAddFilm = { newFilm ->
                    films = films + newFilm
                    showAddFilmDialog = false
                },
                onDismiss = { showAddFilmDialog = false }
            )
        }
    }
}
