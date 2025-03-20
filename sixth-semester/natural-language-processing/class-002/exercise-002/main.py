import re


def tokens(text):
    return re.sub(r'[^\w\s]', '', text).lower().split()


def getWeights(filePath):
    weights = {}

    with open(filePath, "r", encoding="utf-8") as file:
        for line in file:
            data = line.strip().split(",")
            word = data[0]
            weight = int(data[2])
            weights[word] = weight

    return weights


weightsDict = getWeights('/lexicon.txt')
print(weightsDict)


def calculateFeeling(phrase, dict):
    feeling = 0
    tokens = tokens(phrase)
    
    for token in tokens:
        feeling += dict.get(token, 0)
    
    return feeling


print(calculateFeeling('Está um dia lindo hoje.', weightsDict))
