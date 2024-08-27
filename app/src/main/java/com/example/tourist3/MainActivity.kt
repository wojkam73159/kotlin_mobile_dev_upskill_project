package com.example.tourist3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
//import androidx.compose.material.icons.filled.Bookmarks
//import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenContent()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenContent() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerContent(navController = navController, drawerState = drawerState)
            }
        },
        content = {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = { Text("Mountain Trails") }
                    )
                },
                snackbarHost = { SnackbarHost(snackbarHostState) },
                floatingActionButton = {
                    var clickCount by remember { mutableStateOf(0) }
                    ExtendedFloatingActionButton(
                        onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar("Snackbar # ${++clickCount}")
                            }
                        }
                    ) {
                        Text("Show snackbar")
                    }
                },
                content = { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        SetupNavGraph(navController = navController)
                    }
                }
            )
        }
    )
}

@Composable
fun DrawerContent(navController: NavHostController, drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        DrawerHeader()  // Adding header to the drawer

        Spacer(modifier = Modifier.height(16.dp))  // Spacer for spacing between header and items

        Text(
            text = "Okolice Giewontu i Czerwonych Wierchów",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    scope.launch { drawerState.close() }
                    navController.navigate("trail_grid_screen")
                }
        )
        // Add more navigation items here
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "trail_grid_screen"
    ) {
        composable("trail_grid_screen") {
            TrailGridScreen(navController)
        }
        composable("trail_detail_screen/{trailId}") { backStackEntry ->
            TrailDetailScreen(trailId = backStackEntry.arguments?.getString("trailId"))
        }
    }
}
