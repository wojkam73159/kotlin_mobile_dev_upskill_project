package com.example.tourist3

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplashFinished: () -> Unit) {
    // Define an animatable scale state
    var scale by remember { mutableStateOf(0f) }

    // Animate the scale
    val animatedScale by animateFloatAsState(
        targetValue = scale,
        animationSpec = tween(
            durationMillis = 1000,
            easing = FastOutSlowInEasing
        )
    )

    // Launch an effect to trigger the animation and delay
    LaunchedEffect(Unit) {
        scale = 1f
        delay(2000L)  // Keep the splash screen for 2 seconds
        onSplashFinished()
    }

    // Compose the Splash Screen UI with scaling animation
    Box(
        modifier = Modifier
            .fillMaxSize()
            .scale(animatedScale),
        contentAlignment = Alignment.Center
    ) {
        // Replace with your app's logo or splash image
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),  // Replace with your splash drawable
            contentDescription = "App Logo",
            modifier = Modifier.size(100.dp)
        )
    }
}
