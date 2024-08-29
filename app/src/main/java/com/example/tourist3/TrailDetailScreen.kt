package com.example.tourist3

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun TrailDetailScreen(trailId: String?) {
    val context = LocalContext.current  // Retrieve the context for launching intents

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            Text(text = "Details of $trailId")

            Spacer(modifier = Modifier.height(16.dp))

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
}
