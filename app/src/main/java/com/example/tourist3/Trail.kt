package com.example.tourist3

import androidx.annotation.DrawableRes

data class Trail(
    val name: String,      // Trasa
    val difficulty: String, // Trudność
    val length: String,    // Długość
    val color: String,     // Szlak
    val time: String,      // Czas
    @DrawableRes val imageResId: Int
)