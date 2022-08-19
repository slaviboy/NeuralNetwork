package com.slaviboy.features.homeScreen.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.slaviboy.composeunits.dw
import com.slaviboy.composeunits.sw
import com.slaviboy.features.R
import com.slaviboy.features.homeScreen.ui.NotoSansFont
import com.slaviboy.features.homeScreen.ui.sectionTextColor
import com.slaviboy.features.homeScreen.viewmodels.HomeViewModel

@Composable
fun InputSection(viewModel: HomeViewModel) {
    Spacer(modifier = Modifier.height(0.05.dw))
    Text(
        stringResource(id = R.string.input),
        fontFamily = NotoSansFont,
        fontSize = 0.05.sw,
        fontWeight = FontWeight.Normal,
        color = sectionTextColor
    )
    Spacer(modifier = Modifier.height(0.04.dw))
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(0.63.dw)
    ) {
        DrawingCanvas(
            viewModel = viewModel,
            modifier = Modifier
                .width(0.63.dw)
                .fillMaxHeight()
        )
        DrawingCanvasInstruments(
            viewModel = viewModel,
            modifier = Modifier
                .width(0.12.dw)
                .fillMaxHeight()
        )
    }
}