package com.slaviboy.neuralnetworkexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.slaviboy.composeunits.initSize
import com.slaviboy.features.homeScreen.composables.pages.HomePage
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
            val homeViewModel: HomeViewModel = hiltViewModel()
            HomePage(homeViewModel)
        }
    }
}