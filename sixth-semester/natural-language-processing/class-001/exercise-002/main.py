comments = [
    {
        'author': 'João',
        'comment': 'Estou tão feliz hoje!',
        'feeling': 'Positivo'
    },
    {
        'author': 'Maria',
        'comment': 'Este filme é tão triste.',
        'feeling': 'Negativo'
    },
    {
        'author': 'Carlos',
        'comment': 'Que dia chuvoso entediante...',
        'feeling': 'Negativo'
    },
    {
        'author': 'Ana',
        'comment': 'Adorei a nova música da banda!',
        'feeling': 'Positivo'
    },
    {
        'author': 'Roberto',
        'comment': 'Eureka, consegui resolver este problema',
        'feeling': 'Positivo'
    }
]

totalCount = len(comments)
positiveCount = sum(1 for comment in comments if comment['feeling'] == 'Positivo')
negativeCount = sum(1 for comment in comments if comment['feeling'] == 'Negativo')
positivePercent = positiveCount / totalCount * 100
negativePercent = negativeCount / totalCount * 100

print(f'Quantidade de comentários positivos: {positiveCount}')
print(f'Quantidade de comentários negativos: {negativeCount}')
print(f'Porcentagem de comentários positivos: {positivePercent}%')
print(f'Porcentagem de comentários negativos: {negativePercent}%')

print('Comentários positivos:')

for comment in comments:
    if comment['feeling'] == 'Positivo':
        print(comment['comment'])

for comment in comments:
    if comment['feeling'] == 'Positivo':
        comment['feelingValue'] = 1
    if comment['feeling'] == 'Negativo':
        comment['feelingValue'] = 0

print(f'Novos dados: {comments}')
