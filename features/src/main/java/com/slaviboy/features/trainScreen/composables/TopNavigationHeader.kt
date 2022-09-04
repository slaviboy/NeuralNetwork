package com.slaviboy.features.trainScreen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.slaviboy.composeunits.dw
import com.slaviboy.composeunits.sw
import com.slaviboy.features.R
import com.slaviboy.features.destinations.HomePageDestination
import com.slaviboy.features.homeScreen.ui.titleTextColor

@Composable
fun TopNavigationHeader(navigator: DestinationsNavigator) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(0.13.dw)
    ) {
        val interactionSource by remember { mutableStateOf(MutableInteractionSource()) }
        Image(
            painter = painterResource(id = R.drawable.ic_left_arrow),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .width(0.07.dw)
                .wrapContentHeight()
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    navigator.navigate(HomePageDestination)
                },
            colorFilter = ColorFilter.tint(titleTextColor)
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .align(alignment = Alignment.CenterVertically),
        ) {
            Text(
                text = stringResource(id = R.string.train_network),
                fontSize = 0.055.sw,
                fontWeight = FontWeight.Normal,
                color = titleTextColor,
                textAlign = TextAlign.Center
            )
        }

    }
}