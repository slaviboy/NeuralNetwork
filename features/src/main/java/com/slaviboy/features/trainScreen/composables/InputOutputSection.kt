package com.slaviboy.features.trainScreen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.slaviboy.composeunits.dw
import com.slaviboy.composeunits.sw
import com.slaviboy.features.R
import com.slaviboy.features.homeScreen.extensions.capitalizeWords
import com.slaviboy.features.homeScreen.ui.NotoSansFont
import com.slaviboy.features.homeScreen.ui.checkedColor
import com.slaviboy.features.homeScreen.ui.sectionBackgroundColor
import com.slaviboy.features.homeScreen.ui.subtitleTextColor

@Composable
fun InputOutputSection(
    output: String = "0"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(0.39.dw)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(0.39.dw)
                    .height(0.39.dw)
                    .background(
                        color = sectionBackgroundColor,
                        shape = RoundedCornerShape(0.02.dw)
                    )
            ) {

            }
            Text(
                stringResource(id = R.string.input_data).capitalizeWords(),
                fontFamily = NotoSansFont,
                fontSize = 0.03.sw,
                fontWeight = FontWeight.Normal,
                color = subtitleTextColor,
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(0.39.dw)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(0.39.dw)
                    .height(0.39.dw)
                    .background(
                        color = sectionBackgroundColor,
                        shape = RoundedCornerShape(0.02.dw)
                    )
            ) {
                Text(
                    output,
                    fontFamily = NotoSansFont,
                    fontSize = 0.16.sw,
                    fontWeight = FontWeight.Normal,
                    color = checkedColor,
                    textAlign = TextAlign.Center
                )
            }
            Text(
                stringResource(id = R.string.output_label).capitalizeWords(),
                fontFamily = NotoSansFont,
                fontSize = 0.03.sw,
                fontWeight = FontWeight.Normal,
                color = subtitleTextColor,
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }
    }
}