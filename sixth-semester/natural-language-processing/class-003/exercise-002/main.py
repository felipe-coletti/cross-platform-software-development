import numpy as np

# 1. Array de inteiros de 1 a 10
integer_array = np.arange(1, 11)
print("Array de inteiros:", integer_array)

# 2. Array de floats aleatórios com forma (300, 200, 3)
float_array = np.random.rand(300, 200, 3)
print("Forma do array de floats aleatórios:", float_array.shape)

# 3. Notas de 20 alunos com 3 notas cada (inteiros aleatórios de 1 a 10)
students_grades = np.random.randint(1, 11, size=(20, 3))
print("Notas dos alunos:\n", students_grades)

# 4. Array com 12 elementos redimensionado para 3x4 e transposto
elements_array = np.arange(1, 13)
reshaped_matrix = elements_array.reshape((3, 4))
transposed_matrix = reshaped_matrix.T
print("Array redimensionado:\n", reshaped_matrix)
print("Array transposto:\n", transposed_matrix)

# 5. Operações aritméticas básicas
first_array = np.array([1, 2, 3, 4])
second_array = np.array([5, 6, 7, 8])
print("Adição:", first_array + second_array)
print("Subtração:", first_array - second_array)
print("Multiplicação:", first_array * second_array)
print("Divisão:", first_array / second_array)

# 6. Elementos pares de 1 a 20
range_array = np.arange(1, 21)
even_elements = range_array[range_array % 2 == 0]
print("Números pares:", even_elements)

# 7. Números aleatórios entre 1 e 100 e filtro > 50
random_numbers = np.random.randint(1, 101, 20)
filtered_numbers = random_numbers[random_numbers > 50]
print("Números aleatórios:", random_numbers)
print("Números maiores que 50:", filtered_numbers)

# 8. Estatísticas: média, mediana, desvio padrão
stats_data = np.random.rand(10) * 100
mean_value = np.mean(stats_data)
median_value = np.median(stats_data)
std_deviation = np.std(stats_data)
print("Dados:", stats_data)
print("Média:", mean_value)
print("Mediana:", median_value)
print("Desvio padrão:", std_deviation)
