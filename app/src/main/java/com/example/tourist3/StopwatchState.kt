package com.example.tourist3

import androidx.compose.runtime.*
import kotlinx.coroutines.*

class StopwatchState {
    private var time by mutableStateOf(0L)
    private var isRunning by mutableStateOf(false)
    private var coroutineScope: CoroutineScope? = null

    val formattedTime: String
        get() = formatTime(time)

    fun start() {
        if (isRunning) return
        isRunning = true
        coroutineScope = CoroutineScope(Dispatchers.Main)
        coroutineScope?.launch {
            while (isRunning) {
                delay(1000L)  // Tick every second
                time += 1000L
            }
        }
    }

    fun pause() {
        isRunning = false
        coroutineScope?.cancel()
    }

    fun reset() {
        pause()
        time = 0L
    }

    private fun formatTime(timeMillis: Long): String {
        val seconds = (timeMillis / 1000) % 60
        val minutes = (timeMillis / 1000 / 60) % 60
        val hours = (timeMillis / 1000 / 3600)
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }
}
