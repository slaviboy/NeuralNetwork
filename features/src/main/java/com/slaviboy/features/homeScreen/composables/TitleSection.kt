package com.slaviboy.features.homeScreen.composables

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.slaviboy.composeunits.dw
import com.slaviboy.composeunits.sw
import com.slaviboy.features.homeScreen.ui.NotoSansFont
import com.slaviboy.features.homeScreen.ui.headerTextColor

@Composable
fun TitleSection(
    @StringRes titleResId: Int,
    @DrawableRes iconResId: Int? = null
) {
    Spacer(modifier = Modifier.height(0.05.dw))
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            stringResource(id = titleResId),
            fontFamily = NotoSansFont,
            fontSize = 0.1.sw,
            fontWeight = FontWeight.Medium,
            color = headerTextColor
        )
        if (iconResId != null) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(0.13.dw)
                    .padding(0.02.dw)
                    .offset(x = -(0.02.dw)),
                colorFilter = ColorFilter.tint(headerTextColor)
            )
        }
    }
}