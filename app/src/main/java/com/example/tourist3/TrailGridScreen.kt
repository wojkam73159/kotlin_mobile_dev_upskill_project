package com.example.tourist3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun TrailGridScreen(navController: NavHostController) {
    // List of mountain trails
    val mountainTrails = listOf(
        Trail("Czerwone Wierchy", "skala trudności", "2.8 km", "czerwony szlak", "2h 30'"),
        Trail("Na Giewont przez Dolinę Strążyską", "skala trudności", "6.7 km", "czerwony szlak", "3h 15'"),
        Trail("Na Giewont z Kuźnic", "skala trudności", "6.5 km", "niebieski szlak", "3h 15'"),
        Trail("Na Kasprowy Wierch z Kuźnic", "skala trudności", "7.5 km", "zielony szlak", "2h 30'"),
        Trail("Na Kasprowy Wierch z Kopy Kondrackiej", "skala trudności", "4.2 km", "czerwony szlak", "1h 55'"),
        Trail("Na Kopę Kondracką przez Przełęcz pod Kopą Kondracką", "skala trudności", "3.7 km", "niebieski szlak, zielony szlak, czerwony szlak", "1h 35'"),
        Trail("Na Giewont przez Dolinę Małej Łąki", "skala trudności", "7.0 km", "żółty szlak", "2h 45'"),
        Trail("Na Małołączniak przez Przysłop Miętusi", "skala trudności", "7.5 km", "niebieski szlak", "3h 15'")
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(16.dp)
    ) {
        items(mountainTrails) { trail ->
            TrailGridItem(trail) {
                navController.navigate("trail_detail_screen/${trail.name}")
            }
        }
    }
}

@Composable
fun TrailGridItem(trail: Trail, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Trasa: ${trail.name}")
            Text(text = "Trudność: ${trail.difficulty}")
            Text(text = "Długość: ${trail.length}")
            Text(text = "Szlak: ${trail.color}")
            Text(text = "Czas: ${trail.time}")
        }
    }
}
