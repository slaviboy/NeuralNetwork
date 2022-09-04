package com.slaviboy.neuralnetworkexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import com.slaviboy.composeunits.initSize
import com.slaviboy.features.NavGraphs
import com.slaviboy.features.destinations.HomePageDestination
import com.slaviboy.features.destinations.TrainPageDestination
import com.slaviboy.features.homeScreen.viewmodels.HomeViewModel
import com.slaviboy.neuralnetwork.NeuralNetwork
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val neuralNetwork = NeuralNetwork(4.0, 4, 6, 3)
        val learningRate = neuralNetwork.getLearningRate()

        initSize()
        setContent {
            DestinationsNavHost(
                navGraph = NavGraphs.root,
                dependenciesContainerBuilder = {
                    dependency(HomePageDestination) { hiltViewModel<HomeViewModel>() }
                    dependency(TrainPageDestination) { hiltViewModel<HomeViewModel>() }
                }
            )
        }
    }
}