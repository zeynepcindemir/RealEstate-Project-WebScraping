
from bs4 import BeautifulSoup
import requests


def replace_letters(string):
    replacements = {
        "Ö": "O",
        "ö": "o",
        "Ü": "U",
        "ü": "u",
        "İ": "I",
        "ı": "i",
        "Ş": "S",
        "ş": "s",
        "Ç": "C",
        "ç": "c",
        "Ğ": "G",
        "ğ": "g"
    }

    for old, new in replacements.items():
        string = string.replace(old, new)

    return string

f = open("properties.txt", "w")

pages = []
for i in range(2, 8):
    pages.append(f"https://www.hepsiemlak.com/izmir-satilik?page={i}")

for page in pages:

    html_text = requests.get(page).text
    soup = BeautifulSoup(html_text, 'html.parser')

    prop_list = soup.find_all('div', class_='list-view-content')

    for prop in prop_list:
        ref = prop.find('a')['href']
        nested_text = requests.get("https://www.hepsiemlak.com" + ref).text
        sp = BeautifulSoup(nested_text, 'html.parser')

        name = sp.find('h1', class_='fontRB').get_text(strip=True)
        name = replace_letters(name)
        price = sp.find('p', class_='fontRB fz24 price').get_text(strip=True)
        price = replace_letters(price)


        f.write("İsim: " + name + "\n")
        f.write("Fiyat: " + price + "\n")

        for span_txt in sp.find_all('span', {'class': 'txt'}):
            if (span_txt.text == "Brüt / Net M2"):

                span_txt_text = replace_letters(span_txt.get_text(strip=True))
                next_sibling_text = replace_letters(span_txt.find_next_sibling().get_text(strip=True))
                next_next_sibling_text = replace_letters(span_txt.find_next_sibling().find_next_sibling().get_text(strip=True))
                f.write(span_txt_text + ": " + next_sibling_text + " " + next_next_sibling_text + "\n")
            else:

                span_txt_text = replace_letters(span_txt.get_text(strip=True))
                next_sibling_text = replace_letters(span_txt.find_next_sibling().get_text(strip=True))
                f.write(span_txt_text + ": " + next_sibling_text + "\n")

f.close()