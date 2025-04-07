import numpy as np

def calculate_scores(grades_matrix, weights_vector):
    return np.dot(grades_matrix, weights_vector)

students_num = int(input("Informe o número de alunos: "))
sections_num = int(input("Informe a quantidade de seções da avaliação: "))

weights_list = []

print(f"Informe os {sections_num} pesos (a soma deve ser 10.0):")

for i in range(sections_num):
    weight = float(input(f"Peso da seção {i + 1}: "))
    weights_list.append(weight)

weights_vector = np.array(weights_list)

if not np.isclose(np.sum(weights_vector), 10.0):
    print("Erro: a soma dos pesos deve ser igual a 10.0")
    exit()

grades_list = []

for i in range(students_num):
    student_grades = []

    print(f"Notas do aluno {i + 1}:")

    for j in range(sections_num):
        grade = float(input(f"Nota da seção {j + 1}: "))
        student_grades.append(grade)

    grades_list.append(student_grades)

grades_matrix = np.array(grades_list)
final_scores = calculate_scores(grades_matrix, weights_vector)

print("Pontuações finais dos alunos:")

for i, score in enumerate(final_scores, start = 1):
    print(f"Aluno {i}: {score:.2f}")
