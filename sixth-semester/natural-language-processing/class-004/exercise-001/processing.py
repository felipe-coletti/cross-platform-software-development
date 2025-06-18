import re
import string

def clean_text(text):
    text = text.lower()
    text = re.sub(f"[{re.escape(string.punctuation)}]", "", text)
    text = re.sub(r"\d+", "", text)
    text = re.sub(r"\s+", " ", text)
    return text.strip()

def read_file(filename):
    with open(filename, 'r', encoding='utf-8') as f:
        text = f.read()
    return clean_text(text)