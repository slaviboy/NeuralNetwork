package com.slaviboy.features.trainScreen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.slaviboy.composeunits.dw
import com.slaviboy.composeunits.sw
import com.slaviboy.features.R
import com.slaviboy.features.destinations.TrainPageDestination
import com.slaviboy.features.homeScreen.composables.BigTitle
import com.slaviboy.features.homeScreen.composables.Button
import com.slaviboy.features.homeScreen.composables.MediumTitle
import com.slaviboy.features.homeScreen.composables.Subtitle
import com.slaviboy.features.homeScreen.extensions.capitalizeWords
import com.slaviboy.features.homeScreen.ui.*
import com.slaviboy.features.homeScreen.viewmodels.HomeViewModel
import com.slaviboy.features.trainScreen.entities.Item

@RootNavGraph(start = true)
@Destination
@Composable
fun TrainPage(
    viewModel: HomeViewModel,
    navigator: DestinationsNavigator
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(screenBackgroundColor)
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 0.08.dw),
        userScrollEnabled = viewModel.userScrollEnabled
    ) {
        item {
            //TopNavigationHeader(navigator)
            Spacer(modifier = Modifier.height(0.02.dw))
            BigTitle(R.string.train)
            Subtitle(R.string.train_subtitle)
            Spacer(modifier = Modifier.height(0.05.dw))
            Banner(
                iconRedId = R.drawable.ic_shoe,
                titleResId = R.string.train_title,
                detailsResId = R.string.train_details,
                linkText = "http://yann.lecun.com/exdb/mnist/"
            )
            Spacer(modifier = Modifier.height(0.09.dw))
            Divider(color = dividerStrokeColor, thickness = 1.dp)
            Spacer(modifier = Modifier.height(0.05.dw))
            MediumTitle(R.string.load_training_data)
            Spacer(modifier = Modifier.height(0.04.dw))
            ItemList(
                listOf(
                    Item(
                        leftIconResId = R.drawable.ic_database,
                        titleResId = R.string.training_data_title,
                        subtitleResId = R.string.training_data_subtitle,
                        showDivider = true
                    ),
                    Item(
                        leftIconResId = R.drawable.ic_tag,
                        titleResId = R.string.training_labels_title,
                        subtitleResId = R.string.training_labels_subtitle
                    )
                )
            )
            Spacer(modifier = Modifier.height(0.08.dw))
            MediumTitle(R.string.load_testing_data)
            Spacer(modifier = Modifier.height(0.04.dw))
            ItemList(
                listOf(
                    Item(
                        leftIconResId = R.drawable.ic_folder,
                        titleResId = R.string.testing_data_title,
                        subtitleResId = R.string.testing_data_subtitle,
                        showDivider = true
                    ),
                    Item(
                        leftIconResId = R.drawable.ic_notes,
                        titleResId = R.string.testing_labels_title,
                        subtitleResId = R.string.testing_labels_subtitle
                    )
                )
            )

            Spacer(modifier = Modifier.height(0.09.dw))
            Divider(color = dividerStrokeColor, thickness = 1.dp)
            Spacer(modifier = Modifier.height(0.05.dw))
            MediumTitle(R.string.training_states)
            Spacer(modifier = Modifier.height(0.04.dw))
            TrainingStates(
                states = listOf(
                    stringResource(id = R.string.training),
                    stringResource(id = R.string.testing),
                    stringResource(id = R.string.finished)
                )
            )
            Spacer(modifier = Modifier.height(0.05.dw))
            InputOutputSection()
            Spacer(modifier = Modifier.height(0.03.dw))
            Button(normalButtonColor, R.string.start_training) {
                navigator.navigate(TrainPageDestination())
            }
        }
    }
}

@Composable
fun InputOutputSection(
    output: String = "0"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(0.39.dw)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(0.39.dw)
                    .height(0.39.dw)
                    .background(
                        color = sectionBackgroundColor,
                        shape = RoundedCornerShape(0.02.dw)
                    )
            ) {

            }
            Text(
                stringResource(id = R.string.input_data).capitalizeWords(),
                fontFamily = NotoSansFont,
                fontSize = 0.03.sw,
                fontWeight = FontWeight.Normal,
                color = subtitleTextColor,
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(0.39.dw)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(0.39.dw)
                    .height(0.39.dw)
                    .background(
                        color = sectionBackgroundColor,
                        shape = RoundedCornerShape(0.02.dw)
                    )
            ) {
                Text(
                    output,
                    fontFamily = NotoSansFont,
                    fontSize = 0.16.sw,
                    fontWeight = FontWeight.Normal,
                    color = checkedColor,
                    textAlign = TextAlign.Center
                )
            }
            Text(
                stringResource(id = R.string.output_label).capitalizeWords(),
                fontFamily = NotoSansFont,
                fontSize = 0.03.sw,
                fontWeight = FontWeight.Normal,
                color = subtitleTextColor,
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center
            )
        }
    }
}
