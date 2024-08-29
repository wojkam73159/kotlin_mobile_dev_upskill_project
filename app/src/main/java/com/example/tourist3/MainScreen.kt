package com.example.tourist3

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

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
