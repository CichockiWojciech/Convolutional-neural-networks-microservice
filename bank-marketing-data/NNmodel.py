import keras
from keras import Sequential
from keras.activations import relu
from keras.layers import Dense, Conv2D, Flatten, Conv1D


def create_model(optimizer='rmsprop', neuron_in_first=32, neuron_in_second=64, neuron_in_cnn=32, kernel_size=1,
                 activation_in_first='relu', activation_in_second='relu'):
    nn = Sequential()
    nn.add(Dense(neuron_in_first, input_dim=14, activation=activation_in_first))
    nn.add(Conv1D(neuron_in_cnn, kernel_size=kernel_size, activation=activation_in_second))

    nn.add(Dense(neuron_in_second, activation=activation_in_second))

    nn.add(Dense(1, activation='sigmoid'))

    nn.compile(loss=keras.losses.binary_crossentropy,
               optimizer=optimizer,
               metrics=['accuracy'])
    return nn


def best_model():
    nn = Sequential()
    nn.add(Dense(32, input_dim=14, activation='relu'))
    nn.add(Conv1D(32, kernel_size=2, activation='relu'))
    nn.add(Dense(64, activation='relu'))
    nn.add(Dense(1, activation='sigmoid'))

    nn.compile(loss=keras.losses.binary_crossentropy,
               optimizer='rmsprop',
               metrics=['accuracy'])
    return nn
