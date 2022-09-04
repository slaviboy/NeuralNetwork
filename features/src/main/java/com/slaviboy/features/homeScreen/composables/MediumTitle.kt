package com.slaviboy.features.homeScreen.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.slaviboy.composeunits.sw
import com.slaviboy.features.homeScreen.extensions.capitalizeWords
import com.slaviboy.features.homeScreen.ui.NotoSansFont
import com.slaviboy.features.homeScreen.ui.subtitleTextColor

@Composable
fun MediumTitle(
    @StringRes titleResId: Int
) {
    Text(
        stringResource(id = titleResId).uppercase(),
        fontFamily = NotoSansFont,
        fontSize = 0.03.sw,
        fontWeight = FontWeight.Normal,
        color = subtitleTextColor,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
}