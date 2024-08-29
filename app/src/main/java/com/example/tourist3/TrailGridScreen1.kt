package com.example.tourist3

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun TrailGridScreen1(navController: NavHostController) {
    val mountainTrails = listOf(
        Trail("Czerwone Wierchy", "skala trudności", "2.8 km", "czerwony szlak", "2h 30'", R.drawable.ic_launcher_background),
                Trail("Na Giewont przez Dolinę Strążyską", "skala trudności", "6.7 km", "czerwony szlak", "3h 15'", R.drawable.ic_launcher_background),
        Trail("Na Giewont z Kuźnic", "skala trudności", "6.5 km", "niebieski szlak", "3h 15'", R.drawable.ic_launcher_background),
        Trail("Na Kasprowy Wierch z Kuźnic", "skala trudności", "7.5 km", "zielony szlak", "2h 30'", R.drawable.ic_launcher_background),
        Trail("Na Kasprowy Wierch z Kopy Kondrackiej", "skala trudności", "4.2 km", "czerwony szlak", "1h 55'", R.drawable.ic_launcher_background),
        Trail("Na Kopę Kondracką przez Przełęcz pod Kopą Kondracką", "skala trudności", "3.7 km", "niebieski szlak, zielony szlak, czerwony szlak", "1h 35'", R.drawable.ic_launcher_background),
        Trail("Na Giewont przez Dolinę Małej Łąki", "skala trudności", "7.0 km", "żółty szlak", "2h 45'", R.drawable.ic_launcher_background),
        Trail("Na Małołączniak przez Przysłop Miętusi", "skala trudności", "7.5 km", "niebieski szlak", "3h 15'", R.drawable.ic_launcher_background)

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


