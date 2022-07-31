LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
LOCAL_MODULE := neuralnetwork
LOCAL_SRC_FILES := MathUtils.h \ MathUtils.cpp \ Matrix.cpp \ Matrix.h \ com_slaviboy_neuralnetwork_NeuralNetwork.h \ NeuralNet.cpp \ NeuralNet.h \ com_slaviboy_neuralnetwork_NeuralNetwork.cpp \ Handle.h
LOCAL_CPP_FEATURES := exceptions
LOCAL_ALLOW_UNDEFINED_SYMBOLS := true
LOCAL_LDLIBS := -llog -ldl -lstdc++ -landroid
include $(BUILD_SHARED_LIBRARY)