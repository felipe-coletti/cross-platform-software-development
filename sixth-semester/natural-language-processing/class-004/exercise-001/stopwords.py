import nltk
nltk.download('stopwords', quiet=True)
from nltk.corpus import stopwords
from swears import swears

stop_words = set(stopwords.words('portuguese'))

stop_words.update(swears)