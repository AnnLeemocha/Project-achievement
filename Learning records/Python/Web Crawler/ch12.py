# API 應用

# 觀察連結

# %%    新北勢電影名冊 (CSV)
import requests as rq
import csv
import pandas as pd

url = "https://data.ntpc.gov.tw/api/datasets/61C99F42-8A90-4ADC-9C40-BA9E0EA097AA/csv"
res = rq.request("GET", url)
# GET or POST

# print(res.text)
# print(res.text.split())

data = list(csv.reader(res.text.split()))

print(data[0])

df = pd.DataFrame(data[1:],columns=["name", 'address', 'tel', 'number'])

df.index+=1

print(df)

# %%    新北市公共自行車 (JSON)
import requests as rq

url = "https://data.ntpc.gov.tw/api/datasets/71CD1490-A2DF-4198-BEF1-318479775E8A/json"
res = rq.get(url)
data = res.json()

# print(data[0].items())
# print(list(data[0].keys()))
for i in list(data[0].keys()):
    print(i,end="\t")
print()
for i in data:
    for j in list(i.values()):
        print(j,end="\t")
    print()
    

