from processing import read_file
from tokens import extract_tokens, clean_tokens, top_20_words
from graph import generate_chart

def analyze_song(file_path):
    text = read_file(file_path)
    tokens = extract_tokens(text)
    cleaned = clean_tokens(tokens)
    top_words = top_20_words(cleaned)
    generate_chart(top_words, title=f"Top 20 - {file_path}")

if __name__ == "__main__":
    analyze_song("song.txt")