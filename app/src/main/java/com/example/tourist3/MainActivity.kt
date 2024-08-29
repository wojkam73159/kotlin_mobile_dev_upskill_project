package com.example.tourist3

import TrailGridScreen2
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tourist3.ui.theme.Tourist3Theme
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var showSplash by remember { mutableStateOf(true) }  // State to show/hide splash screen

            if (showSplash) {
                SplashScreen(onSplashFinished = { showSplash = false })
            } else {
                Box(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    SetupNavGraph(navController = navController)
                }
            }
        }
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "main_grid_screen"
    ) {
        composable("main_grid_screen") {
            MainGridScreen(navController)
        }
        composable("trail_grid_screen1") {
            TrailGridScreen1(navController)
        }
        composable("trail_grid_screen2") {
            TrailGridScreen2(navController)
        }
        composable("trail_detail_screen/{trailId}") { backStackEntry ->
            TrailDetailScreen(trailId = backStackEntry.arguments?.getString("trailId"))
        }
    }
}



@Composable
fun MainGridScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = { navController.navigate("trail_grid_screen1") }) {
            Text(text = "Okolice Giewontu i Czerwonych Wierchów")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("trail_grid_screen2") }) {
            Text(text = "Dolina Chochołowska")
        }
    }
}





// TrailGridScreen2.kt

