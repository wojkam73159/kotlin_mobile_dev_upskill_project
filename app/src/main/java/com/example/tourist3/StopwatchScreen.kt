package com.example.tourist3

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StopwatchScreen() {
    val stopwatchState = remember { StopwatchState() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display formatted time
        Text(
            text = stopwatchState.formattedTime,
            style = MaterialTheme.typography.displayMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Start/Stop button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { stopwatchState.start() }) {
                Text("Start")
            }

            Button(onClick = { stopwatchState.pause() }) {
                Text("Pause")
            }

            Button(onClick = { stopwatchState.reset() }) {
                Text("Reset")
            }
        }
    }
}
