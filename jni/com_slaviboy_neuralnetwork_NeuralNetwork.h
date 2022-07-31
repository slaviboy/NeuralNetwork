/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_slaviboy_neuralnetwork_NeuralNetwork */

#ifndef _Included_com_slaviboy_neuralnetwork_NeuralNetwork
#define _Included_com_slaviboy_neuralnetwork_NeuralNetwork
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_slaviboy_neuralnetwork_NeuralNetwork
 * Method:    init
 * Signature: (DIII)V
 */
JNIEXPORT void JNICALL Java_com_slaviboy_neuralnetwork_NeuralNetwork_init
  (JNIEnv *, jobject, jdouble, jint, jint, jint);

/*
 * Class:     com_slaviboy_neuralnetwork_NeuralNetwork
 * Method:    dispose
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_slaviboy_neuralnetwork_NeuralNetwork_dispose
  (JNIEnv *, jobject);

/*
 * Class:     com_slaviboy_neuralnetwork_NeuralNetwork
 * Method:    query
 * Signature: ([D)[D
 */
JNIEXPORT jdoubleArray JNICALL Java_com_slaviboy_neuralnetwork_NeuralNetwork_query
  (JNIEnv *, jobject, jdoubleArray);

/*
 * Class:     com_slaviboy_neuralnetwork_NeuralNetwork
 * Method:    train
 * Signature: ([D[D)V
 */
JNIEXPORT void JNICALL Java_com_slaviboy_neuralnetwork_NeuralNetwork_train
  (JNIEnv *, jobject, jdoubleArray, jdoubleArray);

/*
 * Class:     com_slaviboy_neuralnetwork_NeuralNetwork
 * Method:    setWih
 * Signature: ([[D)V
 */
JNIEXPORT void JNICALL Java_com_slaviboy_neuralnetwork_NeuralNetwork_setWih
  (JNIEnv *, jobject, jobjectArray);

/*
 * Class:     com_slaviboy_neuralnetwork_NeuralNetwork
 * Method:    setWho
 * Signature: ([[D)V
 */
JNIEXPORT void JNICALL Java_com_slaviboy_neuralnetwork_NeuralNetwork_setWho
  (JNIEnv *, jobject, jobjectArray);

/*
 * Class:     com_slaviboy_neuralnetwork_NeuralNetwork
 * Method:    getWih
 * Signature: ()[[D
 */
JNIEXPORT jobjectArray JNICALL Java_com_slaviboy_neuralnetwork_NeuralNetwork_getWih
  (JNIEnv *, jobject);

/*
 * Class:     com_slaviboy_neuralnetwork_NeuralNetwork
 * Method:    getWho
 * Signature: ()[[D
 */
JNIEXPORT jobjectArray JNICALL Java_com_slaviboy_neuralnetwork_NeuralNetwork_getWho
  (JNIEnv *, jobject);

/*
 * Class:     com_slaviboy_neuralnetwork_NeuralNetwork
 * Method:    getLearningRate
 * Signature: ()D
 */
JNIEXPORT jdouble JNICALL Java_com_slaviboy_neuralnetwork_NeuralNetwork_getLearningRate
  (JNIEnv *, jobject);

/*
 * Class:     com_slaviboy_neuralnetwork_NeuralNetwork
 * Method:    getInputNodes
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_slaviboy_neuralnetwork_NeuralNetwork_getInputNodes
  (JNIEnv *, jobject);

/*
 * Class:     com_slaviboy_neuralnetwork_NeuralNetwork
 * Method:    getHiddenNodes
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_slaviboy_neuralnetwork_NeuralNetwork_getHiddenNodes
  (JNIEnv *, jobject);

/*
 * Class:     com_slaviboy_neuralnetwork_NeuralNetwork
 * Method:    getOutputNodes
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_slaviboy_neuralnetwork_NeuralNetwork_getOutputNodes
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
