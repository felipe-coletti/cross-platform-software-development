import csv
import re


def data(filePath):
    inputs = []
    outputs = []

    with open(filePath, 'r', encoding='utf-8') as file:
        csvReader = csv.reader(file, delimiter="\t")
        next(csvReader)

        for row in csvReader:
            feeling = row[0]
            feeling = 1 if feeling == 'positivo' else 0 if feeling == 'neutro' else -1 if feeling == 'negativo'
            phrase = row[1].replace('"', '')
            
            inputs.append(phrase)
            outputs.append(feeling)

    return inputs, outputs


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


def feeling(phrase, dictionary):
    score = sum(dictionary.get(token, 0) for token in tokens(phrase))

    return score


def analyzeSentiment(phrase, dictionary):
    score = feeling(phrase, dictionary)

    result = 1 if score > 0 else -1 if score < 0 else 0

    return result


def evaluateModel(inputs, outputs):
    tp = fp = fn = tn = 0

    for i, sentence in enumerate(inputs):
        try:
            predicted = analyze_sentiment(sentence, weightsDict)
            actual = outputs[i]

            if predicted == 1:
                if actual == 1:
                    tp += 1
                else:
                    fp += 1
            elif predicted == -1:
                if actual == -1:
                    tn += 1
                else:
                    fn += 1
        except Exception as e:
            print(f"Error analyzing sentence {i}: {e}")

    precision = tp / (tp + fp) if (tp + fp) > 0 else 0
    recall = tp / (tp + fn) if (tp + fn) > 0 else 0
    accuracy = (tp + tn) / (tp + tn + fp + fn) if (tp + tn + fp + fn) > 0 else 0

    return precision, recall, accuracy


weightsPath = '/lexicon.txt'
dataPath = '/analise_sentimento_portugues.csv'

weightsDict = weights(weightsPath)
inputs, outputs = data(dataPath)
precision, recall, accuracy = evaluateModel(inputs, outputs)

print(f"Precision: {precision:.4f}")
print(f"Recall: {recall:.4f}")
print(f"Accuracy: {accuracy:.4f}")
