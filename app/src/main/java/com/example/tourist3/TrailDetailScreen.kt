package com.example.tourist3

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.material3.MaterialTheme

@Composable
fun TrailDetailScreen(trailId: String?) {
    val context = LocalContext.current
    val stopwatchState = remember { StopwatchState() } // Initialize the StopwatchState

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display trail details
        Text(text = "Details of $trailId", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Display formatted time for the stopwatch
        Text(
            text = stopwatchState.formattedTime,
            style = MaterialTheme.typography.displayMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Stopwatch control buttons
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

        Spacer(modifier = Modifier.height(32.dp))

        // SMS Button
        Button(onClick = {
            val smsIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto:")  // Only SMS apps should handle this
                putExtra("sms_body", "Hi from trail: $trailId")
            }
            context.startActivity(smsIntent)  // Launch the SMS app with the intent
        }) {
            Text(text = "Send SMS")
        }
    }
}
