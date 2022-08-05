package com.slaviboy.features.homeScreen.composables

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.view.MotionEvent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.onGloballyPositioned

@Composable
fun Home() {

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DrawingCanvas() {

    val strokeWidth2 by remember {
        mutableStateOf(
            40f
        )
    }
    var workingBitmap by remember {
        mutableStateOf(
            Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)
        )
    }
    var canvas by remember {
        mutableStateOf(
            Canvas(workingBitmap)
        )
    }
    val path by remember {
        mutableStateOf(
            Path()
        )
    }
    val paint by remember {
        mutableStateOf(
            Paint().apply {
                isAntiAlias = true
                style = Paint.Style.STROKE
                strokeWidth = strokeWidth2
                strokeCap = Paint.Cap.ROUND
                strokeJoin = Paint.Join.ROUND
            }
        )
    }

    val infiniteTransition = rememberInfiniteTransition()
    val trigger by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    if (trigger.isFinite()) {
        Image(
            bitmap = workingBitmap.asImageBitmap(),
            contentDescription = null
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .onGloballyPositioned { coordinates ->
                workingBitmap = Bitmap.createBitmap(coordinates.size.width, coordinates.size.height, Bitmap.Config.ARGB_8888)
                canvas = Canvas(workingBitmap)
            }
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        path.apply {
                            reset()
                            moveTo(it.x, it.y)
                        }
                    }
                    MotionEvent.ACTION_MOVE -> {
                        path.lineTo(it.x, it.y)
                        canvas.drawPath(path, paint)
                        path.rewind()
                        path.moveTo(it.x, it.y)
                    }
                    MotionEvent.ACTION_UP -> {
                        path.lineTo(it.x, it.y)
                        canvas.drawPath(path, paint)
                        path.rewind()
                        path.moveTo(it.x, it.y)
                    }
                    else -> return@pointerInteropFilter false
                }
                true
            }
    )
}