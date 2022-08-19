package com.slaviboy.features.homeScreen.viewmodels

import android.graphics.*
import android.view.MotionEvent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import com.slaviboy.composeunits.DpToPx
import com.slaviboy.composeunits.dw
import com.slaviboy.features.homeScreen.composables.pages.OutputResultItem
import com.slaviboy.features.homeScreen.sealed.*
import com.slaviboy.features.homeScreen.ui.canvasStrokeColor
import com.slaviboy.features.homeScreen.ui.sectionBackgroundColor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    companion object {

        fun randomFloat(min: Float = 0f, max: Float = 100f): Float {
            return (min + Math.random() * (max - min)).toFloat()
        }

        fun Bitmap.getRoundedCornerBitmap(roundPixelSize: Int): Bitmap {
            val output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(output)
            val paint = Paint()
            val rect = Rect(0, 0, width, height)
            val rectF = RectF(rect)
            val roundPx = roundPixelSize.toFloat()
            paint.isAntiAlias = true
            canvas.drawRoundRect(rectF, roundPx, roundPx, paint)
            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
            canvas.drawBitmap(this, rect, rect, paint)
            return output
        }

        private val defaultBitmap = Bitmap
            .createBitmap(1, 1, Bitmap.Config.ARGB_8888)

        private val defaultPaint = Paint().apply {
            isAntiAlias = true
            style = Paint.Style.STROKE
            strokeCap = Paint.Cap.ROUND
            strokeJoin = Paint.Join.ROUND
            color = canvasStrokeColor.toArgb()
        }

        private val defaultStrokeWidth = (0.07.dw)
            .value
            .DpToPx
    }

    var onDrawingItemClickListener: (drawingItem: DrawingItem) -> Unit = {
        it.update(drawingItems)
        paint.color = getCanvasStrokeColor()
        if (it is ClearItem || it is InvertItem) {
            drawCanvas(
                getCanvasBackgroundColor()
            )
        }
    }

    var strokeWidth: Float by mutableStateOf(defaultStrokeWidth)
        private set

    var bitmap: Bitmap by mutableStateOf(defaultBitmap)
        private set

    var canvas: Canvas by mutableStateOf(Canvas(bitmap))
        private set

    var path: Path by mutableStateOf(Path())
        private set

    var paint: Paint by mutableStateOf(
        defaultPaint.apply {
            strokeWidth = this@HomeViewModel.strokeWidth
        })
        private set

    var drawingItems: List<DrawingItem> by mutableStateOf(
        listOf(
            DrawItem(),
            EraseItem(),
            ClearItem(),
            InvertItem()
        )
    )
        private set

    var outputResults: List<OutputResultItem> by mutableStateOf(List(10) {
        OutputResultItem(it, randomFloat())
    })
        private set

    var outputResult: OutputResultItem by mutableStateOf(outputResults.first())
        private set

    var userScrollEnabled: Boolean by mutableStateOf(true)
        private set

    fun setBitmap(width: Int, height: Int) {
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        canvas = Canvas(bitmap).also {
            drawCanvas(
                getCanvasBackgroundColor()
            )
        }
    }

    fun onMotionEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                userScrollEnabled = false
                moveTo(x, y)
            }
            MotionEvent.ACTION_UP -> {
                userScrollEnabled = true
                lineTo(x, y)
            }
            MotionEvent.ACTION_MOVE -> lineTo(x, y)
            else -> return false
        }
        return true
    }

    private val selectedDrawingItem: DrawingItem?
        get() = drawingItems.find {
            it.isSelectable && it.isSelected
        }

    private val isInverted: Boolean
        get() = drawingItems.find {
            it is InvertItem
        }?.isChecked ?: false

    private val canvasColors = (sectionBackgroundColor.toArgb() to canvasStrokeColor.toArgb())

    private fun getCanvasStrokeColor(): Int {
        return when (selectedDrawingItem) {
            is EraseItem -> {
                if (!isInverted) canvasColors.first else canvasColors.second
            }
            is DrawItem -> {
                if (!isInverted) canvasColors.second else canvasColors.first
            }
            else -> Color.Black.toArgb()
        }
    }

    private fun getCanvasBackgroundColor(): Int {
        return if (isInverted) {
            canvasColors.second
        } else {
            canvasColors.first
        }
    }

    private fun drawCanvas(color: Int) {
        canvas.drawColor(color)
    }

    private fun moveTo(x: Float, y: Float) {
        path.apply {
            reset()
            moveTo(x, y)
        }
    }

    private fun lineTo(x: Float, y: Float) {
        path.lineTo(x, y)
        if (selectedDrawingItem is DrawItem || selectedDrawingItem is EraseItem) {
            canvas.drawPath(path, paint)
        }
        path.rewind()
        path.moveTo(x, y)
    }
}