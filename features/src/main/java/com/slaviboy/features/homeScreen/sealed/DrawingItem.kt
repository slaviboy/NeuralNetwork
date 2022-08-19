package com.slaviboy.features.homeScreen.sealed

import androidx.annotation.DrawableRes
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import com.slaviboy.features.R
import com.slaviboy.features.homeScreen.ui.alertStatusColor
import com.slaviboy.features.homeScreen.ui.iconNormalColor
import com.slaviboy.features.homeScreen.ui.iconSelectedColor

sealed class DrawingItem(
    @DrawableRes var resId: Int,
    var isSelectable: Boolean = false,
    var isCheckable: Boolean = false,
    var isSelected: Boolean = false,
    var isChecked: Boolean = false
) {

    var color = mutableStateOf(getColor())

    fun update(drawingItems: List<DrawingItem>) {
        if (isSelectable) {
            isSelected = true
            drawingItems.forEach {
                if (it != this && it.isSelectable) {
                    it.apply {
                        isSelected = false
                        updateColor()
                    }
                }
            }
        }
        if (isCheckable) {
            isChecked = !isChecked
        }
        updateColor()
    }

    private fun updateColor() {
        color.value = getColor()
    }

    private fun getColor(): Color {
        return if (isSelectable && isSelected) {
            iconSelectedColor
        } else if (isCheckable && isChecked) {
            alertStatusColor
        } else {
            iconNormalColor
        }
    }
}

class DrawItem : DrawingItem(resId = R.drawable.ic_draw, isSelected = true, isSelectable = true)
class EraseItem : DrawingItem(resId = R.drawable.ic_erase, isSelected = false, isSelectable = true)
class ClearItem : DrawingItem(resId = R.drawable.ic_clear)
class InvertItem : DrawingItem(resId = R.drawable.ic_invert, isChecked = false, isCheckable = true)