package com.slaviboy.neuralnetworkexample

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.onGloballyPositioned
import com.slaviboy.neuralnetwork.NeuralNetwork


class MainActivity : ComponentActivity() {

    private val path = Path()
    val paint = Paint().apply {
        isAntiAlias = true
    }

    fun Canvas.drawCircleOnBitmap(x: Float, y: Float) {
        drawCircle(
            x,
            y,
            20f,
            paint
        )
        /* drawCircle(
             x,
             y,
             20f,
             paint.apply {
                 style = Paint.Style.FILL
                 shader = RadialGradient(
                     x,
                     y,
                     30f,
                     intArrayOf(
                         Color.BLACK,
                         Color.argb(5, 0, 0, 0)
                     ),
                     floatArrayOf(0f, 1f),
                     Shader.TileMode.CLAMP
                 )
             }
         )*/
    }

    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val neuralNetwork = NeuralNetwork(4.0, 4, 6, 3)
        val learningRate = neuralNetwork.getLearningRate()
 
        setContent {

            var workingBitmap by remember { mutableStateOf(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)) }
            var canvas by remember { mutableStateOf(Canvas(workingBitmap)) }

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
                                canvas.drawCircleOnBitmap(it.x, it.y)
                            }
                            MotionEvent.ACTION_MOVE -> {
                                canvas.drawCircleOnBitmap(it.x, it.y)
                            }
                            MotionEvent.ACTION_UP -> {
                                canvas.drawCircleOnBitmap(it.x, it.y)
                            }
                            else -> false
                        }
                        true
                    }
            )

            /*Canvas(
                modifier = Modifier
                    .blur(radius = 16.dp)
                    .fillMaxSize()
                    .background(color = Color.Gray)
                    .pointerInteropFilter {
                        when (it.action) {
                            MotionEvent.ACTION_DOWN -> {
                                path.moveTo(it.x, it.y)
                            }
                            MotionEvent.ACTION_MOVE -> {
                                path.lineTo(it.x, it.y)
                            }
                            MotionEvent.ACTION_UP -> {
                                path.lineTo(it.x, it.y)
                            }
                            else -> false
                        }
                        true
                    }
            ) {
                if (trigger.isFinite()) {
                    drawPath(
                        path = path,
                        color = Color.Green,
                        alpha = 1f,
                        style = Stroke(width = 40f)
                    )
                }
            }*/

        }
    }
}