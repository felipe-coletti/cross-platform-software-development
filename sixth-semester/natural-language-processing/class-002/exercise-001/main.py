def weights(filePath):
    weights = {}

    with open(filePath, 'r', encoding='utf-8') as file:
        for line in file:
            data = line.strip().split(',')
            word = data[0]
            weight = int(data[2])
            weights[word] = weight

    return weights


print(weights('lexicon.txt'))
