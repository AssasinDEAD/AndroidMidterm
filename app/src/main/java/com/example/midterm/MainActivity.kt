package com.example.midterm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.example.midterm.ui.theme.MidtermTheme
import com.example.midterm.FilmItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MidtermTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController)  // Вызов функции из MainScreen.kt
        }
        composable(
            "detail/{itemName}",
            arguments = listOf(navArgument("itemName") { type = NavType.StringType })
        ) { backStackEntry ->
            val itemName = backStackEntry.arguments?.getString("itemName")
            itemName?.let {
                DetailScreen(it, navController)
            }
        }
    }
}
