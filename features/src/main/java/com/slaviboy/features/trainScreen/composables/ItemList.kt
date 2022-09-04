package com.slaviboy.features.trainScreen.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.slaviboy.composeunits.dw
import com.slaviboy.features.trainScreen.entities.Item

@Composable
fun ItemList(items: List<Item>) {
    Column() {
        items.forEachIndexed { i, item ->
            Item(
                modifier = Modifier
                    .width(0.9.dw)
                    .height(0.195.dw),
                item = item,
                cornerRadius = 0.02.dw,
                isTopItem = (i == 0),
                isBottomItem = (i == items.lastIndex)
            )
        }
    }
}