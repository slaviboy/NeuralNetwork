package com.slaviboy.features.homeScreen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.slaviboy.features.homeScreen.ui.outputTextColor
import com.slaviboy.features.homeScreen.ui.sectionBackgroundColor
import com.slaviboy.features.homeScreen.viewmodels.HomeViewModel

@Composable
fun OutputResultCanvas(viewModel: HomeViewModel, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(0.54.dw)
                .background(
                    color = sectionBackgroundColor,
                    shape = RoundedCornerShape(0.02.dw)
                )
        ) {
            Text(
                text = viewModel.outputResult.number.toString(),
                color = outputTextColor,
                fontFamily = NotoSansFont,
                fontSize = 0.22.sw,
                fontWeight = FontWeight.Normal
            )
        }
        Spacer(modifier = Modifier.height(0.02.dw))
        Text(
            text = stringResource(id = R.string.confidence) + ": ${viewModel.outputResult.probability2Digits()}%",
            color = outputTextColor,
            fontFamily = NotoSansFont,
            fontSize = 0.025.sw,
            fontWeight = FontWeight.Medium
        )
    }
}