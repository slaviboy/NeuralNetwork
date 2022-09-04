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
import com.slaviboy.features.homeScreen.ui.titleTextColor

@Composable
fun SmallTitle(
    @StringRes titleResId: Int
) {
    Text(
        stringResource(id = titleResId).capitalizeWords(),
        fontFamily = NotoSansFont,
        fontSize = 0.02.sw,
        fontWeight = FontWeight.Medium,
        color = titleTextColor,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
}