package com.slaviboy.neuralnetworkexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.slaviboy.neuralnetwork.NeuralNetwork

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val neuralNetwork = NeuralNetwork(4.0, 4, 6, 3)
        val learningRate = neuralNetwork.getLearningRate()
        setContent {

        }
    }
}