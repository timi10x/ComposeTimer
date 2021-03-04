package com.example

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DetailsScreen(){
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFF3F51B5))
        ) {

            val windowHeight = LocalConfiguration.current.screenHeightDp
            var isStarted by remember { mutableStateOf(true) }
            val targetHeight = if (isStarted) {
                0
            } else {
                windowHeight
            }

            val animatedHeight by animateIntAsState(
                targetValue = targetHeight,
                animationSpec = tween(3000)
            )

            // Animating Box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(animatedHeight.dp)
                    .background(color = Color(0xFFF85D78))
            ){
                Text(text = "I am animating")
            }

            // Trigger
            Button(
                modifier = Modifier.padding(bottom = 20.dp),
                onClick = {
                    isStarted = !isStarted
                }
            ) {
                Text("Animate")
            }
        }
}