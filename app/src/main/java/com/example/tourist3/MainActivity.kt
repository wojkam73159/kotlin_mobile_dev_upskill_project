package com.example.tourist3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tourist3.ui.theme.Tourist3Theme
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tourist3Theme {
                var showSplash by remember { mutableStateOf(true) }  // State to show/hide splash screen

                if (showSplash) {
                    SplashScreen(onSplashFinished = { showSplash = false })
                } else {
                    val navController = rememberNavController()
                    Box(modifier = Modifier.fillMaxSize()) {
                        SetupNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}


@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home_screen"
    ) {
        composable("home_screen") {
            HomeScreen(navController)
        }
        composable("main_screen") {
            MainScreen(navController)
        }
        composable("trail_detail_screen/{trailId}") { backStackEntry ->
            TrailDetailScreen(trailId = backStackEntry.arguments?.getString("trailId"))
        }
    }
}