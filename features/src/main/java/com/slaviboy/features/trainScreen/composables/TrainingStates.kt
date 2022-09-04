package com.slaviboy.features.trainScreen.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.slaviboy.composeunits.dw
import com.slaviboy.composeunits.sw
import com.slaviboy.features.R
import com.slaviboy.features.homeScreen.ui.NotoSansFont
import com.slaviboy.features.homeScreen.ui.finishedTrainingState
import com.slaviboy.features.homeScreen.ui.subtitleTextColor
import com.slaviboy.features.homeScreen.ui.unfinishedTrainingState

@Composable
fun TrainingStates(
    modifier: Modifier = Modifier,
    states: List<String>,
    loadingPercentage: Float = 0.4f,
    @DrawableRes finishedIconResId: Int = R.drawable.ic_checked,
    @DrawableRes unfinishedIconResId: Int = R.drawable.ic_unchecked,
) {
    val totalWidth = 0.8.dw
    val widthPerStateSpacer = 0.01.dw
    val numberOfStatesLine = states.size - 1
    val totalStateSpacersWidth = widthPerStateSpacer.times(numberOfStatesLine * 2f)
    val widthPerStateCircle = 0.08.dw
    val totalStateCirclesWidth = widthPerStateCircle.times(states.size)
    val totalStateLinesWidth = totalWidth.minus(totalStateCirclesWidth.plus(totalStateSpacersWidth))
    val widthPerStateLine = totalStateLinesWidth.div(numberOfStatesLine)
    val loadingPercentagePerLine = 1f / numberOfStatesLine

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top,
            modifier = modifier
                .width(totalWidth)
        ) {
            states.forEachIndexed { i, state ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .size(widthPerStateCircle)
                ) {
                    val isChecked = (i == 0 && loadingPercentage >= 0f) ||
                            (loadingPercentage >= i * loadingPercentagePerLine) ||
                            (i == states.lastIndex && loadingPercentage >= 1f)
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(
                                id = if (isChecked) {
                                    finishedIconResId
                                } else {
                                    unfinishedIconResId
                                }
                            ),
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .width(widthPerStateCircle)
                                .wrapContentHeight(),
                            colorFilter = ColorFilter.tint(
                                if (isChecked) {
                                    finishedTrainingState
                                } else {
                                    unfinishedTrainingState
                                }
                            )

                        )
                        if (!isChecked) {
                            Text(
                                "${i + 1}",
                                fontFamily = NotoSansFont,
                                fontSize = 0.038.sw,
                                fontWeight = FontWeight.Normal,
                                color = unfinishedTrainingState,
                                modifier = Modifier.fillMaxSize(),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.width(widthPerStateSpacer))
                if (i < states.lastIndex) {
                    val loadPercentageForCurrentLine = (loadingPercentage - (i * loadingPercentagePerLine)) / loadingPercentagePerLine
                    Box(
                        modifier = Modifier
                            .width(widthPerStateLine)
                            .height(0.01.dw)
                            .offset(y = widthPerStateCircle.div(2))
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    color = unfinishedTrainingState,
                                    RoundedCornerShape(0.2.dw)
                                )
                        )
                        Box(
                            modifier = Modifier
                                .width(widthPerStateLine.times(loadPercentageForCurrentLine))
                                .fillMaxHeight()
                                .background(
                                    color = finishedTrainingState,
                                    RoundedCornerShape(0.2.dw)
                                )
                        )
                    }
                    Spacer(modifier = Modifier.width(widthPerStateSpacer))
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
            modifier = modifier
                .width(totalWidth.plus(0.08.dw))
        ) {
            states.forEach { state ->
                Text(
                    state,
                    fontFamily = NotoSansFont,
                    fontSize = 0.03.sw,
                    fontWeight = FontWeight.Normal,
                    color = subtitleTextColor
                )
            }
        }
    }
}