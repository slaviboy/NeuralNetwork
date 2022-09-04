package com.slaviboy.features.homeScreen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.slaviboy.composeunits.dw
import com.slaviboy.composeunits.sw
import com.slaviboy.features.homeScreen.ui.NotoSansFont
import com.slaviboy.features.homeScreen.ui.outputResultBarColor
import com.slaviboy.features.homeScreen.ui.outputResultTextColor

@Composable
fun OutputResultItem(outputResultItem: OutputResultItem) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(0.4.dw)
            .wrapContentHeight()
    ) {
        Text(
            modifier = Modifier
                .width(0.09.dw),
            text = "${outputResultItem.number} - ${outputResultItem.probability.toInt()}%",
            color = outputResultTextColor,
            fontFamily = NotoSansFont,
            fontSize = 0.026.sw,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.width(0.04.dw))
        Box(
            modifier = Modifier
                .width(0.18.dw.times(outputResultItem.probability / 100f))
                .height(0.02.dw)
                .background(
                    color = outputResultBarColor,
                    shape = RoundedCornerShape(0.02.dw)
                )
        )
    }
}