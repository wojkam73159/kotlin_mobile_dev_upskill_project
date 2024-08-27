package com.example.tourist3

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.clickable

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Header", fontSize = 60.sp)
    }
}

//@Composable
//fun DrawerContent(navController: NavHostController) {
//    Column {
//        DrawerHeader()  // Adding header to the drawer
//
//        Spacer(modifier = Modifier.height(16.dp))  // Spacer for spacing between header and items
//
//        Text(
//            text = "Okolice Giewontu i Czerwonych Wierchów",
//            modifier = Modifier
//                .padding(16.dp)
//                .clickable {
//                    navController.navigate("trail_grid_screen")
//                }
//        )
//        // Add more navigation items here
//    }
//}
