from bs4 import BeautifulSoup
import requests
import csv

pages = []
for i in range(2, 8):
    pages.append(f"https://www.hepsiemlak.com/izmir-satilik?page={i}")

header = ["Name", "Price", "Size", "Size Unit", "Room Count", "Building Type", "Heating Type", "Floor", "Building Age"]

with open('homeList.csv', 'w', newline='', encoding='utf-8') as file:
    writer = csv.DictWriter(file, fieldnames=header)
    writer.writeheader()

    for page in pages:
        html_text = requests.get(page).text
        soup = BeautifulSoup(html_text, 'html.parser')

        prop_list = soup.find_all('div', class_='list-view-content')

        for prop in prop_list:
            prop_data = {}
            ref = prop.find('a')['href']
            nested_text = requests.get("https://www.hepsiemlak.com" + ref).text
            sp = BeautifulSoup(nested_text, 'html.parser')

            prop_data["Name"] = sp.find('h1', class_='fontRB').get_text(strip=True)
            prop_data["Price"] = sp.find('p', class_='fontRB fz24 price').get_text(strip=True)

            for span_txt in sp.find_all('span', {'class': 'txt'}):
                if (span_txt.text == "Brüt / Net M2"):
                    prop_data["Size"] = span_txt.find_next_sibling().get_text(strip=True)
                    prop_data["Size Unit"] = span_txt.find_next_sibling().find_next_sibling().get_text(strip=True)
                elif (span_txt.text == "Oda Sayısı"):
                    prop_data["Room Count"] = span_txt.find_next_sibling().get_text(strip=True)
                elif (span_txt.text == "Bina Tipi"):
                    prop_data["Building Type"] = span_txt.find_next_sibling().get_text(strip=True)
                elif (span_txt.text == "Isıtma"):
                    prop_data["Heating Type"] = span_txt.find_next_sibling().get_text(strip=True)
                elif (span_txt.text == "Kat"):
                    prop_data["Floor"] = span_txt.find_next_sibling().get_text(strip=True)
                elif (span_txt.text == "Bina Yaşı"):
                    prop_data["Building Age"] = span_txt.find_next_sibling().get_text(strip=True)
            writer.writerow(prop_data)
