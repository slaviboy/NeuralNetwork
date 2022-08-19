package com.slaviboy.features.homeScreen.composables

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.slaviboy.composeunits.dw
import com.slaviboy.features.homeScreen.viewmodels.HomeViewModel

@Composable
fun OutputResultInfo(viewModel: HomeViewModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        viewModel.outputResults.forEach {
            OutputResultItem(it)
            Spacer(modifier = Modifier.height(0.02.dw))
        }
    }
}