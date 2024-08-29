package com.example.tourist3

import androidx.compose.runtime.*
import kotlinx.coroutines.delay

class StopwatchState {
    private var time by mutableLongStateOf(0L)
    private var isRunning by mutableStateOf(false)

    val formattedTime: String
        get() = formatTime(time)

    fun start() {
        if (isRunning) return
        isRunning = true
    }

    fun pause() {
        isRunning = false
    }

    fun reset() {
        isRunning = false
        time = 0L
    }

    fun tick() {
        if (isRunning) {
            time += 1000L
        }
    }

    private fun formatTime(timeMillis: Long): String {
        val seconds = (timeMillis / 1000) % 60
        val minutes = (timeMillis / 1000 / 60) % 60
        val hours = (timeMillis / 1000 / 3600)
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }
}
