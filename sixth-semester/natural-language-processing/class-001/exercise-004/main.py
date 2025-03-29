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


def lexicalRichness(text):
    textVocabulary = vocabulary(tokens(text))
    uniqueWordsNumber = sum(1 for wordTimes in textVocabulary.values() if wordTimes == 1)
    wordsNumber = len(textVocabulary)
    lexicalRichness = uniqueWordsNumber / wordsNumber

    return lexicalRichness


lexicalRichness = {
    'text1': lexicalRichness(text1),
    'text2': lexicalRichness(text2),
    'text3': lexicalRichness(text3)
}

lexicalRichnessRanking = {}

for i in sorted(lexicalRichness, key = lexicalRichness.get, reverse=True):
    lexicalRichnessRanking[i] = lexicalRichness[i]

richerText = next(iter(lexicalRichnessRanking))

print(f'Texto com a maior riqueza lexical: {richerText}')

# Extra
print(f'Textos com maior riqueza lexical: {lexicalRichnessRanking}')
