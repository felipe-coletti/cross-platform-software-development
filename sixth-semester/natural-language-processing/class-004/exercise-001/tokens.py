from collections import Counter
from stopwords import stop_words

def extract_tokens(text):
    return text.split()

def clean_tokens(token_list):
    return [token for token in token_list if token not in stop_words]

def top_20_words(token_list):
    count = Counter(token_list)
    return count.most_common(20)