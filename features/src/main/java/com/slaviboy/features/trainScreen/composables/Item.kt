package com.slaviboy.features.trainScreen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.slaviboy.composeunits.dw
import com.slaviboy.composeunits.sw
import com.slaviboy.features.homeScreen.ui.*
import com.slaviboy.features.trainScreen.entities.Item

@Composable
fun Item(
    modifier: Modifier,
    item: Item,
    cornerRadius: Dp = 0.dw,
    isTopItem: Boolean = false,
    isBottomItem: Boolean = false
) {
    val topStart = if (isTopItem) cornerRadius else 0.dw
    val topEnd = if (isTopItem) cornerRadius else 0.dw
    val bottomEnd = if (isBottomItem) cornerRadius else 0.dw
    val bottomStart = if (isBottomItem) cornerRadius else 0.dw
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .wrapContentSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .background(
                    itemBackgroundColor,
                    RoundedCornerShape(
                        topStart = topStart,
                        topEnd = topEnd,
                        bottomEnd = bottomEnd,
                        bottomStart = bottomStart
                    )
                )
        ) {
            Spacer(modifier = Modifier.width(0.04.dw))
            Image(
                painter = painterResource(id = item.leftIconResId),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(0.13.dw)
                    .wrapContentHeight()
            )
            Spacer(modifier = Modifier.width(0.04.dw))
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(0.5.dw)
                    .fillMaxHeight()
            ) {
                Text(
                    text = stringResource(id = item.titleResId),
                    fontSize = 0.04.sw,
                    fontWeight = FontWeight.SemiBold,
                    color = itemTitleColor,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.height(0.01.dw))
                Text(
                    text = stringResource(id = item.subtitleResId),
                    fontSize = 0.032.sw,
                    fontWeight = FontWeight.Normal,
                    color = itemSubtitleColor,
                    textAlign = TextAlign.Start
                )
            }
            Spacer(modifier = Modifier.width(0.03.dw))
            if (item.showCheckIcon || item.showChevronIcon) {
                Image(
                    painter = painterResource(
                        id = if (item.showChevronIcon) {
                            item.chevronIconResId
                        } else {
                            item.checkedIconResId
                        }
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .width(0.07.dw)
                        .wrapContentHeight(),
                    colorFilter = if (item.showChevronIcon) {
                        ColorFilter.tint(chevronColor)
                    } else {
                        null
                    }
                )
            }
        }
        if (item.showDivider) {
            Divider(
                color = dividerStrokeColor,
                thickness = 1.dp,
                modifier = Modifier.width(0.76.dw)
            )
        }
    }
}