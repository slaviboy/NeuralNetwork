package com.slaviboy.features.homeScreen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.slaviboy.composeunits.dw
import com.slaviboy.features.homeScreen.sealed.DrawingItem

@Composable
fun DrawingCanvasInstrumentsItem(
    drawingItem: DrawingItem,
    onClickListener: (drawingItem: DrawingItem) -> Unit
) {
    val interactionSource by remember { mutableStateOf(MutableInteractionSource()) }
    Image(
        painter = painterResource(id = drawingItem.resId),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                onClickListener.invoke(drawingItem)
            }
            .padding(0.02.dw),
        colorFilter = ColorFilter.tint(drawingItem.color.value)
    )
}