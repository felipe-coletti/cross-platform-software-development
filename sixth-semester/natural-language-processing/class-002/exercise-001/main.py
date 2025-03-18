weights = {}

with open("/lexicon.txt", "r", encoding="utf-8") as file:
    for line in file:
        data = line.strip().split(",")
        word = data[0]
        weight = int(data[2])
        weights[word] = weight
