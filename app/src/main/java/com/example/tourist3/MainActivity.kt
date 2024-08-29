package com.example.tourist3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tourist3.ui.theme.Tourist3Theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.unit.dp

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

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen(navController: NavHostController) {
    val pagerState = rememberPagerState()
    val tabTitles = listOf("Okolice Giewontu", "Dolina Chochołowska", "Inne Trasy")
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            edgePadding = 0.dp,
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }

        HorizontalPager(
            count = tabTitles.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            when (page) {
                0 -> TrailListScreen(navController, trailData = getGiewontTrails())
                1 -> TrailListScreen(navController, trailData = getChocholowskaTrails())
                2 -> TrailListScreen(navController, trailData = getOtherTrails())
            }
        }
    }
}

@Composable
fun TrailListScreen(navController: NavHostController, trailData: List<Trail>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(16.dp)
    ) {
        items(trailData) { trail ->
            TrailGridItem(trail) {
                navController.navigate("trail_detail_screen/${trail.name}")
            }
        }
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "main_screen"
    ) {
        composable("main_screen") {
            MainScreen(navController)
        }
        composable("trail_detail_screen/{trailId}") { backStackEntry ->
            TrailDetailScreen(trailId = backStackEntry.arguments?.getString("trailId"))
        }
    }
}


fun getGiewontTrails(): List<Trail> {
    return listOf(
        Trail(
            name = "Czerwone Wierchy",
            difficulty = "skala trudności",
            length = "2.8 km",
            color = "czerwony szlak",
            time = "2h 30'",
            imageResId = R.drawable.ic_launcher_background
        ),
        Trail(
            name = "Na Giewont przez Dolinę Strążyską",
            difficulty = "skala trudności",
            length = "6.7 km",
            color = "czerwony szlak",
            time = "3h 15'",
            imageResId = R.drawable.ic_launcher_background
        ),
        Trail(
            name = "Na Giewont z Kuźnic",
            difficulty = "skala trudności",
            length = "6.5 km",
            color = "niebieski szlak",
            time = "3h 15'",
            imageResId = R.drawable.ic_launcher_background
        ),
        Trail(
            name = "Na Kasprowy Wierch z Kuźnic",
            difficulty = "skala trudności",
            length = "7.5 km",
            color = "zielony szlak",
            time = "2h 30'",
            imageResId = R.drawable.ic_launcher_background
        ),
        Trail(
            name = "Na Kasprowy Wierch z Kopy Kondrackiej",
            difficulty = "skala trudności",
            length = "4.2 km",
            color = "czerwony szlak",
            time = "1h 55'",
            imageResId = R.drawable.ic_launcher_background
        ),
        Trail(
            name = "Na Kopę Kondracką przez Przełęcz pod Kopą Kondracką",
            difficulty = "skala trudności",
            length = "3.7 km",
            color = "niebieski szlak, zielony szlak, czerwony szlak",
            time = "1h 35'",
            imageResId = R.drawable.ic_launcher_background
        ),
        Trail(
            name = "Na Giewont przez Dolinę Małej Łąki",
            difficulty = "skala trudności",
            length = "7.0 km",
            color = "żółty szlak",
            time = "2h 45'",
            imageResId = R.drawable.ic_launcher_background
        ),
        Trail(
            name = "Na Małołączniak przez Przysłop Miętusi",
            difficulty = "skala trudności",
            length = "7.5 km",
            color = "niebieski szlak",
            time = "3h 15'",
            imageResId = R.drawable.ic_launcher_background
        )
    )
}

fun getChocholowskaTrails(): List<Trail> {
    return listOf(
        Trail(
            name = "Granią od Starorobociańskiego Wierchu do Wołowca",
            difficulty = "skala trudności",
            length = "5.5 km",
            color = "czerwony szlak",
            time = "2h 45'",
            imageResId = R.drawable.ic_launcher_background
        ),
        Trail(
            name = "Na Grzesia, Rakoń i Wołowiec z Polany Chochołowskiej",
            difficulty = "skala trudności",
            length = "7.2 km",
            color = "żółty szlak, niebieski szlak",
            time = "2h 45'",
            imageResId = R.drawable.ic_launcher_background
        ),
        Trail(
            name = "Na Zawracie z Polany Chochołowskiej",
            difficulty = "skala trudności",
            length = "7.2 km",
            color = "zielony szlak",
            time = "2h 10'",
            imageResId = R.drawable.ic_launcher_background
        ),
        Trail(
            name = "Na Przełęcz Bobrowiecką z Polany Chochołowskiej",
            difficulty = "skala trudności",
            length = "1.5 km",
            color = "żółty szlak, niebieski szlak",
            time = "50'",
            imageResId = R.drawable.ic_launcher_background
        ),
        Trail(
            name = "Na Trzydniowiański Wierch i Kończysty Wierch z Polany Chochołowskiej",
            difficulty = "skala trudności",
            length = "6.8 km",
            color = "czerwony szlak, zielony szlak",
            time = "2h 45'",
            imageResId = R.drawable.ic_launcher_background
        ),
        Trail(
            name = "Na Siwą Przełęcz przez Iwaniacką Przełęcz",
            difficulty = "skala trudności",
            length = "12.0 km",
            color = "zielony szlak, żółty szlak",
            time = "3h 45'",
            imageResId = R.drawable.ic_launcher_background
        ),
        Trail(
            name = "Na Trzydniowiański Wierch i Kończysty Wierch z Polany Trzydniówki",
            difficulty = "skala trudności",
            length = "4.8 km",
            color = "czerwony szlak, zielony szlak",
            time = "2h 30'",
            imageResId = R.drawable.ic_launcher_background
        ),
        Trail(
            name = "Na Starorobociański Wierch z Siwej Polany przez Siwą Przełęcz",
            difficulty = "skala trudności",
            length = "12.5 km",
            color = "zielony szlak, czarny szlak, czerwony szlak",
            time = "4h 15'",
            imageResId = R.drawable.ic_launcher_background
        ),
        Trail(
            name = "Na Halę Ornak z Polany Chochołowskiej",
            difficulty = "skala trudności",
            length = "7.7 km",
            color = "zielony szlak, żółty szlak",
            time = "2h 25'",
            imageResId = R.drawable.ic_launcher_background
        )
    )
}


fun getOtherTrails(): List<Trail> {
        return listOf(
        Trail(
            name = "Na Halę Stoły",
            difficulty = "skala trudności",
            length = "4,3 km",
            color = "niebieski szlak",
            time = "1h 20'",
            imageResId = R.drawable.ic_launcher_background // Replace with actual image resource
        ),
        Trail(
            name = "Na Starorobociański Wierch z Hali Ornak przez grzbiet Ornaku",
            difficulty = "skala trudności",
            length = "9,0 km",
            color = "żółty szlak zielony szlak czerwony szlak",
            time = "3h 45'",
            imageResId = R.drawable.ic_launcher_background // Replace with actual image resource
        ),
        Trail(
            name = "Na Czerwone Wierchy (Ciemniak) przez Upłaziańską Kopkę",
            difficulty = "skala trudności",
            length = "6,3 km",
            color = "czerwony szlak",
            time = "3h 15'",
            imageResId = R.drawable.ic_launcher_background // Replace with actual image resource
        )
    )

}
