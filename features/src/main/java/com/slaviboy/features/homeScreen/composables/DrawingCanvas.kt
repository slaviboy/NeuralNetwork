package com.slaviboy.features.homeScreen.composables

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.onGloballyPositioned
import com.slaviboy.composeunits.dw
import com.slaviboy.features.homeScreen.ui.sectionBackgroundColor
import com.slaviboy.features.homeScreen.viewmodels.HomeViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DrawingCanvas(viewModel: HomeViewModel, modifier: Modifier) {

    val bitmap = viewModel.bitmap
    val infiniteTransition = rememberInfiniteTransition()
    val trigger by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = modifier
            .background(
                color = sectionBackgroundColor,
                shape = RoundedCornerShape(0.02.dw)
            )
            .onGloballyPositioned { coordinates ->
                val width = coordinates.size.width
                val height = coordinates.size.height
                if (width == height && (bitmap.width != width || bitmap.height != height)) {
                    viewModel.setBitmap(width, height)
                }
            }
            .pointerInteropFilter {
                viewModel.onMotionEvent(it)
            }
    ) {
        if (trigger.isFinite()) {
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = null
            )
        }
    }
}