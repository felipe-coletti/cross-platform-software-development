import numpy as np

weather_data = np.array([25, 26, 27, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12])

average_temp = np.mean(weather_data)
print("Temperatura média anual:", average_temp)

max_temp = np.max(weather_data)
print("Temperatura máxima registrada:", max_temp)

min_temp = np.min(weather_data)
print("Temperatura mínima registrada:", min_temp)

std_temp = np.std(weather_data)
print("Desvio padrão da temperatura:", std_temp)
