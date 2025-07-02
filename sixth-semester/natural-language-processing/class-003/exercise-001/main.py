import re

normalization_dict = {
    "vc": "você",
    "cê": "você",
    "vcs": "vocês",
    "eh": "é",
    "neh": "não é",
    "né": "não é",
    "mt": "muito",
    "mto": "muito",
    "blz": "beleza",
    "vlw": "valeu",
    "td": "tudo",
    "tds": "todos",
    "tb": "também",
    "tbm": "também",
    "pq": "porque",
    "qnd": "quando",
    "q": "que",
    "oq": "o quê",
    "kd": "cadê",
    "ta": "está",
    "tá": "está",
    "to": "estou",
    "tô": "estou",
    "tava": "estava",
    "fld": "falando",
    "flnd": "falando",
    "msg": "mensagem",
    "naum": "não",
    "mds": "meu deus",
    "mn": "mano",
    "tm": "estamos",
    "tamo": "estamos",
    "pdc": "pode crer",
    "gnt": "gente",
    "mddc": "meu deus do céu",
    "plmds": "pelo amor de deus",
    "plmdds": "pelo amor de deus",
    "sdd": "saudade",
    "sdds": "saudades",
    "sqn": "só que não",
    "vdd": "verdade",
    "slk": "você é louco",
    "mlr": "melhor",
    "tlgd": "tá ligado",
    "pv": "privado",
    "plmns": "pelo menos",
    "ngc": "negócio",
    "fzr": "fazer",
    "dps": "depois",
    "ft": "foto",
    "fml": "família",
    "rlx": "relaxa",
    "fut": "futebol",
    "bj": "beijo",
    "bjs": "beijos",
    "ajd": "ajuda",
    "pls": "please",
    "obg": "obrigado",
    "hrs": "horas",
    "nd": "nada",
    "pfv": "por favor",
    "att": "ah tá",
    "msm": "mesmo",
    "add": "adicionar",
    "amg": "amigo",
    "cmg": "comigo",
    "glr": "galera",
    "pprt": "papo reto",
    "cvs": "conversar",
    "ss": "sim, sim",
    "qt": "quanto",
    "ñ": 'não',
    "num": 'não',
    "naum": 'não',
    "nn": "não, não",
    "clr": "celular",
    "cell": "celular",
    "sla": "sei lá",
    "qria": "queria",
    "qser": "quiser",
    "pft": "perfeito",
    "dnv": "de novo",
    "sm": "sem",
    "cm": "com",
    "vms": "vamos",
    "flw": "falou",
    "trd": "tarde",
    "aq": "aqui",
    "aki": "aqui",
    "bnt": "bonito",
    "ngm": "ninguém",
    "tmj": "tamo junto",
    "hj": "hoje",
}

stop_expressions = {"aff", "tipo", "mano", "man", "véi", "meu", "nossa", "poxa", "sei lá", "rs", "kk", "haha", "lol", "lmao"}

def tokens(text):
    return re.sub(r'[^\w\s]', '', text).lower().split()

def normalize_text(text):
    words = tokens(text)

    normalized_words = []

    for word in words:
        normalized = normalization_dict.get(word, word)

        if normalized not in stop_expressions:
            normalized_words.append(normalized)

    return " ".join(normalized_words)

text = "Vc tava certo, isso eh mt bom!!!"

print(normalize_text(text))
