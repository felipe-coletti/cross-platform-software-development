import matplotlib.pyplot as plt

def generate_chart(matrix, title="Top 20 palavras mais frequentes"):
    words, frequencies = zip(*matrix)
    plt.figure(figsize=(12, 6))
    plt.bar(words, frequencies, color='teal')
    plt.xlabel("Palavras")
    plt.ylabel("Frequência")
    plt.title(title)
    plt.xticks(rotation=45)
    plt.tight_layout()
    plt.show()