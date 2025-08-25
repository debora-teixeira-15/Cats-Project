package com.example.catsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.catsapp.CatDetails.CatDetailsScreen
import com.example.catsapp.CatsList.CatsListScreen
import com.example.catsapp.ui.theme.CatsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CatsAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "cats_list_screen"
                ) {
                    composable("cats_list_screen") {
                        CatsListScreen(navController)
                    }
                    composable(
                        "cat_details_screen/{catName}",
                        arguments = listOf(navArgument("catName") {
                            type = NavType.StringType
                        })
                    ) {
                        val catName = remember {
                            it.arguments?.getString("catName")
                        }
                        CatDetailsScreen()
                    }
                }
            }
        }
    }
}