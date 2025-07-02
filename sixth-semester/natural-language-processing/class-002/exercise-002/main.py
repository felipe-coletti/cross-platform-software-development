import re


def tokens(text):
    return re.sub(r'[^\w\s]', '', text).lower().split()


def weights(filePath):
    weights = {}

    with open(filePath, "r", encoding="utf-8") as file:
        for line in file:
            data = line.strip().split(",")
            word = data[0]
            weight = int(data[2])
            weights[word] = weight

    return weights


weights_dict = weights('lexicon.txt')
print(weights_dict)


def feeling(phrase, dictionary):
    score = sum(dictionary.get(token, 0) for token in tokens(phrase))

    return score


print(feeling('Está um dia lindo hoje.', weights_dict))
