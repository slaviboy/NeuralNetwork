package com.slaviboy.features.homeScreen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.slaviboy.composeunits.dw
import com.slaviboy.composeunits.sw
import com.slaviboy.features.R
import com.slaviboy.features.homeScreen.ui.NotoSansFont
import com.slaviboy.features.homeScreen.ui.dividerColor
import com.slaviboy.features.homeScreen.ui.sectionTextColor
import com.slaviboy.features.homeScreen.viewmodels.HomeViewModel

@Composable
fun OutputSection(viewModel: HomeViewModel) {
    Spacer(modifier = Modifier.height(0.1.dw))
    Divider(
        modifier = Modifier
            .height(1.dp)
            .background(dividerColor)
    )
    Spacer(modifier = Modifier.height(0.06.dw))
    Text(
        stringResource(id = R.string.output),
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
            .fillMaxHeight()
    ) {
        OutputResultCanvas(
            viewModel = viewModel,
            modifier = Modifier
                .width(0.36.dw)
                .fillMaxHeight()
        )
        Spacer(modifier = Modifier.width(0.08.dw))
        OutputResultInfo(viewModel)
    }
}