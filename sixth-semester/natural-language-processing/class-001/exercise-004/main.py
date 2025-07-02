import re

text1 = 'exemplo exemplo'
text2 = 'exemplo'
text3 = 'exemplo exemplo exemplo'


def tokens(text):
    return re.sub(r'[^\w\s]', '', text).lower().split()


def vocabulary(list):
    dict = {}

    for token in list:
        if token in dict:
            dict[token] += 1
        else:
            dict[token] = 1

    return dict


def lexical_richness(text):
    text_vocabulary = vocabulary(tokens(text))
    unique_words_number = sum(1 for word_times in text_vocabulary.values() if word_times == 1)
    words_number = len(text_vocabulary)
    lexical_richness = unique_words_number / words_number

    return lexical_richness


lexical_richness = {
    'text1': lexical_richness(text1),
    'text2': lexical_richness(text2),
    'text3': lexical_richness(text3)
}

lexical_richness_ranking = {}

for i in sorted(lexical_richness, key = lexical_richness.get, reverse=True):
    lexical_richness_ranking[i] = lexical_richness[i]

richer_text = next(iter(lexical_richness_ranking))

print(f'Texto com a maior riqueza lexical: {richer_text}')

# Extra
print(f'Textos com maior riqueza lexical: {lexical_richness_ranking}')
