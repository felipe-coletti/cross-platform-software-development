import numpy as np
import matplotlib.pyplot as plt

noise = np.random.random(size=100)

rain_mm = np.arange(50, 150)
rain_mm = rain_mm * (noise * 0.10)

harvest = np.arange(3, 103)
harvest = harvest * (noise * 0.10)

x = (rain_mm - np.mean(rain_mm)) / np.std(rain_mm)
y = (harvest - np.mean(harvest)) / np.std(harvest)

def compute_cost(w, b, x, y):
    predictions = w * x + b
    errors = predictions - y
    return np.mean(errors ** 2)

def gradient_descent(x, y, learning_rate = 0.001, epochs = 1000):
    w = 0.0
    b = 0.0
    costs = []

    for epoch in range(epochs):
        predictions = w * x + b
        errors = predictions - y

        dw = (2 / len(x)) * np.dot(errors, x)
        db = (2 / len(x)) * np.sum(errors)

        w -= learning_rate * dw
        b -= learning_rate * db

        cost = compute_cost(w, b, x, y)
        costs.append(cost)

        if epoch % 100 == 0:
            print(f"Epoch {epoch}: cost = {cost:.4f}, w = {w:.4f}, b = {b:.4f}")

    return w, b, costs

best_w, best_b, cost_history = gradient_descent(x, y, learning_rate=0.001, epochs=1000)

print(f"Best parameters found: w = {best_w:.4f}, b = {best_b:.4f}")

x_plot = rain_mm
y_pred_normalized = best_w * x + best_b
y_pred = y_pred_normalized * np.std(harvest) + np.mean(harvest)

plt.scatter(rain_mm, harvest, label="Data")
plt.plot(rain_mm, y_pred, color="red", label="Best Fit Line")
plt.xlabel("Rainfall (mm)")
plt.ylabel("Harvest")
plt.title("Rainfall vs Harvest (Linear Regression)")
plt.legend()
plt.grid(True)
plt.show()

plt.plot(cost_history)
plt.title("Cost Over Epochs")
plt.xlabel("Epoch")
plt.ylabel("Cost")
plt.grid(True)
plt.show()
