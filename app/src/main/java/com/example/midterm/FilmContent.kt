package com.example.midterm

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource

@Composable
fun FilmContent(
    film: Film,
    modifier: Modifier = Modifier,
    showFullContent: Boolean = false
) {
    if (showFullContent) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = film.imageRes),
                contentDescription = "Film poster",
                modifier = Modifier.size(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = film.title, fontSize = 24.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = film.description, fontSize = 16.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Rating: ${film.rating}", fontSize = 16.sp)
        }
    } else {
        Row(
            modifier = modifier
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
                Text(text = film.title, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Rating: ${film.rating}", fontSize = 16.sp)
            }
        }
    }
}
