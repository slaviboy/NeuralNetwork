package com.slaviboy.features.homeScreen.composables.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.slaviboy.composeunits.dw
import com.slaviboy.features.R
import com.slaviboy.features.homeScreen.composables.Button
import com.slaviboy.features.homeScreen.composables.InputSection
import com.slaviboy.features.homeScreen.composables.OutputSection
import com.slaviboy.features.homeScreen.composables.TitleSection
import com.slaviboy.features.homeScreen.ui.normalButtonColor
import com.slaviboy.features.homeScreen.ui.screenBackgroundColor
import com.slaviboy.features.homeScreen.viewmodels.HomeViewModel

@Composable
fun HomePage(viewModel: HomeViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(screenBackgroundColor)
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 0.1.dw),
        userScrollEnabled = viewModel.userScrollEnabled
    ) {
        item {
            TitleSection(R.string.home, R.drawable.ic_github)
            InputSection(viewModel)
            OutputSection(viewModel)
            Button(normalButtonColor, R.string.train)
        }
    }
}

class OutputResultItem(
    val number: Int = 0,
    val probability: Float = 0f
) {
    fun probability2Digits(): String {
        return String.format("%.2f", probability)
    }
}