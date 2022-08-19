package com.slaviboy.features.homeScreen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.slaviboy.composeunits.dw
import com.slaviboy.features.homeScreen.ui.sectionBackgroundColor
import com.slaviboy.features.homeScreen.viewmodels.HomeViewModel

@Composable
fun DrawingCanvasInstruments(
    viewModel: HomeViewModel,
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .background(
                color = sectionBackgroundColor,
                shape = RoundedCornerShape(0.02.dw)
            )
            .padding(vertical = 0.02.dw)
    ) {
        viewModel.drawingItems.forEach {
            DrawingCanvasInstrumentsItem(it, viewModel.onDrawingItemClickListener)
        }
    }
}