package com.slaviboy.neuralnetwork

/**
 * A basic artificial neural network inspired by animal brains. It is made by three layers (input, hidden, output layers).
 * It is backed by a native implementation written in C++. Construct and initialize a neural network with random picked weights.
 * @param learningRate the network learning rate
 * @param inputNodes the amount of input layer nodes
 * @param hiddenNodes the amount of hidden layer nodes
 * @param outputNodes the amount of output layer nodes
 */
class NeuralNetwork(
    learningRate: Double,
    inputNodes: Int,
    hiddenNodes: Int,
    outputNodes: Int
) {

    companion object {
        init {
            System.loadLibrary("neuralnetwork")
        }
    }

    private val nativeHandle: Long = 0 // Hold pointer to c++ NeuralNet object

    init {
        init(learningRate, inputNodes, hiddenNodes, outputNodes)
    }

    external fun init(learningRate: Double, inputNodes: Int, hiddenNodes: Int, outputNodes: Int)

    /**
     * Dispose all allocated resources.
     */
    external fun dispose()

    /**
     * Query the network with the given inputs.
     * @param inputs a vector containing a list of inputs. The array length must equal the amount of input nodes.
     * @return the network response as an array of outputs. The response array length equals to the amount of output nodes.
     */
    external fun query(inputs: DoubleArray?): DoubleArray?

    /**
     * Train the neural network. Targets are used to calculate the error.
     * @param inputs an array containing a list of inputs. The array length must equal the amount of input nodes.
     * @param targets an array containing a list of targets. The array length must equal the amount of output nodes.
     */
    external fun train(inputs: DoubleArray?, targets: DoubleArray?)

    /**
     * Set weight matrix between hidden and output layers. This can be used to load a saved model.
     * @param wih the weights matrix between hidden and output layers.
     */
    external fun setWih(wih: Array<DoubleArray?>?)

    /**
     * Set weight matrix between hidden and output layers. This can be used to load a saved model.
     * @param who the weights matrix between hidden and output layers.
     */
    external fun setWho(who: Array<DoubleArray?>?)

    /**
     * @return the weights matrix between input and hidden layers.
     */
    external fun getWih(): Array<DoubleArray?>?

    /**
     * @return the weights matrix between hidden and output layers.
     */
    external fun getWho(): Array<DoubleArray?>?

    /**
     * @return the network learning rate.
     */
    external fun getLearningRate(): Double

    /**
     * @return the amount of input layer nodes.
     */
    external fun getInputNodes(): Int

    /**
     * @return the amount of hidden layer nodes.
     */
    external fun getHiddenNodes(): Int

    /**
     * @return the amount of output layer nodes.
     */
    external fun getOutputNodes(): Int
}