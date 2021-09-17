import numpy as np

def tanh(x):
    return np.tanh(x)
def tan_deriv(x):
    return 1.0 - np.tanh(x) * np.tan(x)
def logistic(x):
    return 1 / (1 + np.exp(-x))
def logistic_derivative(x):
    return logistic(x) * (1 - logistic(x))

class neuralnetwork:
    def __init__(self, layers, activation='tanh'):
        if activation == 'logistic':
            self.activation = logistic
            self.activation_deriv = logistic_derivative
        elif activation == 'tanh':
            self.activation = tanh
            self.activation_deriv = tan_deriv
            self.weights = []
            for i in range(1, len(layers) - 1):
                self.weights.append((2 * np.random.random((layers[i - 1] + 1, layers[i] + 1)) - 1) * 0.25)
                self.weights.append((2 * np.random.random((layers[i] + 1, layers[i + 1])) - 1) * 0.25)
    
    def fit(self, x, y, learning_rate=0.2, epochs=10000):
        x = np.atleast_2d(x)
        temp = np.ones([x.shape[0], x.shape[1] + 1])
        temp[:, 0: -1] = x
        x = temp
        y = np.array(y)
        for k in range(epochs):
            i = np.random.randint(x.shape[0])
            a = [x[i]]
        for l in range(len(self.weights)):
            a.append(self.activation(np.dot(a[l], self.weights[l])))
            error = y[i] - a[-1]
            deltas = [error * self.activation_deriv(a[-1])]
        for l in range(len(a) - 2, 0, -1):
            deltas.append(deltas[-1].dot(self.weights[l].t) * self.activation_deriv(a[l]))
            deltas.reverse()
        for i in range(len(self.weights)):
            layer = np.atleast_2d(a[i])
            delta = np.atleast_2d(deltas[i])
            self.weights[i] += learning_rate * layer.t.dot(delta)
            
    def predict(self, x):
        x = np.array(x)
        temp = np.ones(x.shape[0] + 1)
        temp[0:-1] = x
        a = temp
        for l in range(0, len(self.weights)):
            a = self.activation(np.dot(a, self.weights[l]))
            return a
            
