text = '''
Python é uma linguagem de programação poderosa e versátil.
É amplamente utilizada em desenvolvimento web, ciência de dados, 
inteligência artificial e muito mais.
'''

start = text.find('.')
end = text.find(',')

# Extração de trecho com laço de repetição
excerpt1 = ''

for i in range(start + 1, end):
    excerpt1 += text[i]
    
print(excerpt1)

# Extra
# Extração de trecho com fatiamento de string
excerpt2 = text[start + 1:end]

print(excerpt2)

# Extração de trecho com fatiamento de string encapisulado
def excerpt(text, start, end):
    if start == -1 or end == -1:
        return ''
    
    return text[start + 1:end].strip()

print(excerpt(text, start, end))
