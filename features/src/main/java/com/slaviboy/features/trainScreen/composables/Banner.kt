package com.slaviboy.features.trainScreen.composables

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.slaviboy.composeunits.dw
import com.slaviboy.composeunits.sw
import com.slaviboy.features.R
import com.slaviboy.features.homeScreen.ui.bannerBackgroundColor
import com.slaviboy.features.homeScreen.ui.bannerTitleColor
import com.slaviboy.features.trainScreen.entities.Highlight

@Composable
fun Banner(
    @DrawableRes iconRedId: Int,
    @StringRes titleResId: Int,
    @StringRes detailsResId: Int,
    linkText: String
) {
    Column(
        modifier = Modifier
            .width(0.9.dw)
            .wrapContentHeight()
            .background(
                color = bannerBackgroundColor,
                shape = RoundedCornerShape(size = 0.02.dw)
            )
    ) {
        Row(
            modifier = Modifier
                .wrapContentSize()
                .padding(vertical = 0.04.dw)
        ) {
            Spacer(modifier = Modifier.width(0.04.dw))
            Image(
                painter = painterResource(id = iconRedId),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(0.145.dw)
                    .wrapContentHeight()
            )
            Spacer(modifier = Modifier.width(0.03.dw))
            Column(
                modifier = Modifier
                    .width(0.54.dw)
            ) {
                Text(
                    text = stringResource(id = titleResId),
                    fontSize = 0.039.sw,
                    fontWeight = FontWeight.SemiBold,
                    color = bannerTitleColor,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(0.01.dw))
                HighlightedText(
                    text = stringResource(id = detailsResId),
                    highlights = listOf(
                        Highlight(
                            text = stringResource(id = R.string.train_details_link),
                            data = linkText,
                            onClick = { link ->
                                val a = 4
                            }
                        )
                    )
                )
                Spacer(modifier = Modifier.height(0.02.dw))
            }
            Image(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(0.055.dw)
                    .wrapContentHeight()
            )
            Spacer(modifier = Modifier.width(0.019.dw))
        }
    }
}