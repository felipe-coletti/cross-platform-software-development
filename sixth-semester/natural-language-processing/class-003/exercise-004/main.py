import numpy as np

height = np.array([1.65, 1.75, 1.80, 1.70, 1.68, 1.72, 1.78, 1.60, 1.85, 1.73, 1.69, 1.75, 1.62, 1.80, 1.77, 1.68, 1.79, 1.81, 1.76, 1.74])
weight = np.array([65, 70, 75, 80, 60, 68, 72, 58, 90, 72, 65, 70, 55, 78, 79, 62, 85, 88, 70, 75])

bmi = weight / (height ** 2)

underweight = np.sum(bmi < 18.5)
normal_weight = np.sum((bmi >= 18.5) & (bmi < 25))
overweight = np.sum((bmi >= 25) & (bmi < 30))
obese = np.sum(bmi >= 30)

print("IMCs:", bmi)
print("Abaixo do peso:", underweight)
print("Peso normal:", normal_weight)
print("Sobrepeso:", overweight)
print("Obesos:", obese)
