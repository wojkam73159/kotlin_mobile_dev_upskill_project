import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.tourist3.R
import com.example.tourist3.Trail
import com.example.tourist3.TrailGridItem

@Composable
fun TrailGridScreen2(navController: NavHostController) {
    // List of trails for "Dolina Chochołowska"
    val chocholowskaTrails = listOf(
        Trail("Granią od Starorobociańskiego Wierchu do Wołowca", "skala trudności", "5.5 km", "czerwony szlak", "2h 45'", R.drawable.ic_launcher_background),
        Trail("Na Grzesia, Rakoń i Wołowiec z Polany Chochołowskiej", "skala trudności", "7.2 km", "żółty szlak, niebieski szlak", "2h 45'", R.drawable.ic_launcher_background),
        Trail("Na Zawracie z Polany Chochołowskiej", "skala trudności", "7.2 km", "zielony szlak", "2h 10'", R.drawable.ic_launcher_background),
        Trail("Na Przełęcz Bobrowiecką z Polany Chochołowskiej", "skala trudności", "1.5 km", "żółty szlak, niebieski szlak", "50'", R.drawable.ic_launcher_background),
        Trail("Na Trzydniowiański Wierch i Kończysty Wierch z Polany Chochołowskiej", "skala trudności", "6.8 km", "czerwony szlak, zielony szlak", "2h 45'", R.drawable.ic_launcher_background),
        Trail("Na Siwą Przełęcz przez Iwaniacką Przełęcz", "skala trudności", "12.0 km", "zielony szlak, zółty szlak", "3h 45'", R.drawable.ic_launcher_background),
        Trail("Na Trzydniowiański Wierch i Kończysty Wierch z Polany Trzydniówki", "skala trudności", "4.8 km", "czerwony szlak, zielony szlak", "2h 30'", R.drawable.ic_launcher_background),
        Trail("Na Starorobociański Wierch z Siwej Polany przez Siwą Przełęcz", "skala trudności", "12.5 km", "zielony szlak, czarny szlak, czerwony szlak", "4h 15'", R.drawable.ic_launcher_background),
        Trail("Na Halę Ornak z Polany Chochołowskiej", "skala trudności", "7.7 km", "zielony szlak, żółty szlak", "2h 25'", R.drawable.ic_launcher_background)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(16.dp)
    ) {
        items(chocholowskaTrails) { trail ->
            TrailGridItem(trail) {
                navController.navigate("trail_detail_screen/${trail.name}")
            }
        }
    }
}