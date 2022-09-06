# 爬蟲應用相關模組套件
#  urllib
#  requests
#  BeautifulSoup
# 【注意短網址問題，瀏覽器可行，但爬蟲不一定可行】
# 【網頁語法有單雙引號差別，為了判斷正確，網頁原始碼手動寫入食用三個引號最好】

# 下載下來之本地端模組要用 url = "file:read.html"

# %%    urllib 套件
# urllib 套件下，四個主要模組
#    request       : 用於打開和讀取 URL
#    error         : 處理 urllib.request 引發的異常訊息
#    parse         : 用於解析 URL
#    robotparser   : 用於解析 robot.txt 文件
# urllib.request 模組下，兩個主要函式
#    urlopen()     : 進行網頁擷取
#    urlparse()    : 進行網址解析
# res = urllib.request.urlopen() 函式回傳之物件，可使用之屬性與函式
#    res.read()       : 網頁內容(原始碼)
#    res.info()       : 基本資訊
#    res.status       : 讀取狀態
#    res.geturl()     : 網址
#    res.getheaders() : 表頭資訊
# %% 
import urllib
res = urllib.request.urlopen("http://python.org/")
content = res.read() # HTML 為 Bytes 型態
print(content)
# %% 
import urllib.request as ur
res = ur.urlopen("https://www.ncu.edu.tw/")
print("1. 網址:",res.geturl())
print("2. 基本資訊:",res.info())
print("3. 讀取狀態:",res.status)
print("4. 網頁表頭資訊:",res.getheaders()); print()
content = res.read() # HTML 為 Bytes 型態
print("5. 網頁資料(Byte格式)",content); print()
print("6. 網頁資料(字串格式)",content.decode())

# %%    requests 套件
# requests 套件下，主要函式
#    get()  : 讀取網頁資料，對伺服器提出請求後回應網頁的原始碼內容
# res = requests.get() 函式回傳之物件，可使用之屬性與函式
#    status_code : 請求結果代碼 (讀取狀態)
#    headers     : 請求所回傳之標題內容 (dict)
#    encoding    : 所回傳內容之編碼方式
#    text        : 所回傳之文字內容
#    json()      : 讀取 json 格式
# %% 
import requests
# JSON 檔案
res = requests.get("https://bit.ly/2OU9LQb")
# res = requests.get("https://reurl.cc/D3v8vd")
print(res.status_code)
if res.status_code == 200:
    print(res.headers)
    print(res.encoding)
    print(res.text)
    # 似 json.lod() 功能
    data = res.json()
    print(data["success"])
    print(data["result"])
# 【注意短網址問題，瀏覽器可行，但爬蟲不一定可行】

# %% 
import requests
# 從網頁擷取原始碼內容 (HTML)
url = "https://data.gov.tw/"
res = requests.get(url)
if res.status_code == requests.codes.ok:
    print("網頁內容取得成功")
else:    
    print(f"網頁內容取得失敗 [回應狀態:{res.status_code}]")
print(res.encoding)
res.encoding="utf-8"
print(res.text)
print("網頁內容大小:",len(res.text))
print(format("分隔線", "-^30"))

# %% 
import requests
# url = "http://www.thu.edu.tw/"
url = "https://tw.yahoo.com/"
res = requests.get(url)
if res.status_code == requests.codes.ok:
    res.encoding="utf-8"
    data = res.text.splitlines()
    print(len(data))
n = 0
# keyword = input("請輸入要搜尋的字串:")
keyword = "奇摩"
for row in data:
    if keyword in row:
        n += 1
print(f"{keyword}在網頁中找到{n}筆")
# 【若在一行中出現兩次則無法發現，後續正則表示式可解決】

# %%    BeautifulSoup 套件
# 【網頁語法有單雙引號差別，為了判斷正確，網頁原始碼手動寫入食用三個引號最好】
# 定義一個 html 類型檔案
html_doc = """
<html><head><title>The Dormouse's story</title></head> <body> <p class="title"><b>The Dormouse's story</b></p> <p class="story">Once upon a time there were three little sisters; and their names were <a href="http://example.com/elsie" class="sister" id="link1">Elsie</a>, <a href="http://example.com/lacie" class="sister" id="link2">Lacie</a> and <a href="http://example.com/tillie" class="sister" id="link3">Tillie</a>; and they lived at the bottom of a well.</p> <p class="story">...</p>
"""
# 匯入 BeaytifulSoup ， 並使用 lxml 這個 python 解析器
# import bs4
# soup = bs4.BeautifulSoup(html_doc,"lxml")
from bs4 import BeautifulSoup as bs
# 解析結果
soup = bs(html_doc,"lxml")

# 右上角不會顯示變數，但他是有資料
# 與上面輸出一致，但實質上並不相同 (已解析可使用函式與屬性)
print(soup) ; print()

# 以網頁規格格式化輸出 (樹狀架構)
print(soup.prettify()) ; print()

# 解析結構 (soup.標籤)
print(soup.title) ; print()
print(soup.head) ; print()
print(soup.head.title) ; print()
print(soup.title.string) ; print()  # 有些時候不能使用
print(soup.title.text) ; print()    # 基本上都能使用 (V)
print(soup.a) ; print() # 不管寫幾次，都只會抓第一個
print(soup.p) ; print() # 不管寫幾次，都只會抓第一個

# 找到所有標籤 (soup.find_all(標籤)) ==> 整行
soup.find_all()
soup.find_all("p")
soup.find_all("b")
soup.find_all("head")
soup.find_all("a") # 超連結 a 的標籤
soup.find_all("a",{"id":"link1"}) # 進階搜索 (指定屬性與屬性內容)

# 找出所有標籤 a 中， "href" 屬性中的資料/連結 (soup.標籤.get("屬性")) ==> 內容
print(soup.a.get("href"))
for i in soup.find_all("a"):
    # print(i.get("class"))
    print("\t",i.get("href"))
# 找出所有標籤中(p? 同層?)， "class" 屬性中的資料
for i in soup.find_all("p"):
    print(i.get("class"))
# for i in soup.find_all():
#     print(i.get("class"))
print(soup.find("a",{"id":"link1"}).get("href")) # 進階搜尋 + 屬性內容抓取

# 依照 ? 來取資料 (標籤 & 屬性=屬性內容)
print(soup.find("a"))           # 以標籤為主
# HTML 的 id 為唯一值 (特殊)
print(soup.find(id))            # 以屬性為主 
soup.find(id="link3")    # 屬性+屬性內容
soup.find(class_="sister")  # CSS 語法 class == class_
soup.find(href="http://example.com/tillie")
# print(soup.find(href)) # 無法

# 取出文字內容 (注意!並非屬性內容)
print(soup.get_text())
print(soup.text)
print(soup.find(class_="sister").get_text())
print(soup.find(class_="sister").text)

# %%

from bs4 import BeautifulSoup as bs
html_data = """
<html><head><title>國立臺灣大學系統</title></head>
<body>
<p class="title"><b>三校聯盟 NTU SYSTEM</b></p>
<p class="ntu_system">
<a href="http://www.ntu.edu.tw" class="union" id="link1">臺灣大學</a>
<a href="http://www.ntnu.edu.tw" class="union" id="link2">臺灣師範大學</a>
<a href="http://www.ntust.edu.tw" class="union" id="link3">臺灣科技大學</a>
</p></body></html>
"""
# soup = bs(html_data)
soup = bs(html_data,"lxml")
# print(soup.prettify())
print(format(" 1. ","-^30"))
print(soup.title)
print(format(" 2. ","-^30"))
print(soup.a)                # print(soup.find("a"))
print(format(" 3. ","-^30"))
print(soup.b)                # print(soup.find("b"))
print(format(" 4. ","-^30"))
# 印出所有標籤 <a> 且屬性 class 為 union
print(soup.find_all("a",{"class":"union"})) # (ResultSet) # ************
print(format(" 5. ","-^30"))
# 印出所有標籤 <a> 且屬性 id 為 link2
print(soup.find("a",{"id":"link2"}))
print(format(" 6. ","-^30"))
print(soup.find("a",{"href":"http://www.ntust.edu.tw"}))
print(format(" 7. ","-^30"))
print(soup.find("a",{"id":"link1"}).get("href"))
print(format(" 8. ","-^30"))
# soup.select("屬性中的內容")  # CSS 語法 (class = union) == (.union)
data = soup.select(".union") # 樹撞集合 (ResultSet)  # ************
print(data[0].text)
print(format(" 9. ","-^30"))
print(data[1].text)
print(format(" 10. ","-^30"))
# soup.select("屬性中的內容")  # CSS 語法 (id = link3) == (#link3)
print(soup.select("#link3"))                # ************
# print(soup.select_one("#link3"))

# %%    正則(規)表示式 (Regular Expression)
# \b[\w.%+-]+@[\w.-]+\.[a-zA-Z]{2,6}\b
# 資料混亂用正則查找
# 【小寫為一定要，大寫依定不要】
# \d  : 數字  [A\dB --> A0B  |  A\DB --> ANB]
# \s  : 空白  [A\sB --> A B  |  A\SB --> ANB]
# \b  : 邊界(限) [\bAB --> ABN  |  \BAB --> NAB]
# \w  : 字母，數字，底線  [A\wB --> A_B  |  A\WB --> A$B]
# ^   : 字首  [^pos --> pose]
#  $  : 字尾  [ing$ --> spring]
# .     : 任一字元 (不含換行)     [A.B --> A+B A1B AZB]
# *     : 匹配前一字元 0 ~ 多次   [A*B --> B AB AAAB]
# +     : 匹配前一字元 1 ~ 多次   [A+B --> AB AAAB]
# ?     : 匹配前一字元 0 ~ 1次    [A?B --> B AB]
# []    : 括號中的字元           [A[XYZ]B --> AXB AYB AZB]
# [^]   : 不在括號中的字元        [A[^XYZ]B --> A1B A+B ANB]
# -     : 指定範圍               [A[C-E]B --> ACB ADB AEB]
# \     : 跳脫字元               [\+ --> 尋找加號]
# |     : 分隔樣式符號            [A[CD|12]B --> ACB ADB A1B A2B]
# {n}   : 前面字元重複 n 次      [A[B-D]{3} --> ABBB ABDB ABCD]
# {n,}  : 前面字元重複 n 次以上   [A[B-D]{3,} --> ABBB ABDBC ABCDCBB]
# {n,m} : 前面字元重複 n~m 次    [A[B-D]{2,3} --> ABB ABBB ADC ABCD]

# 只搜尋(匹配)一次 : match() , 
# 搜尋(匹配)所有的 : findall(str,起始,結束)

import re
pattern = re.compile(r"\d+")  # 至少一個以上的數字
result1 = pattern.findall("runoob 123 google 456")
result2 = pattern.findall("run88oob123google456",0,10)
print(result1)
print(result2)
print()
# %%

key = "abcde@a"
p = "@."
pattern = re.compile(p)
print(pattern.findall(key))
p = "@.+"
pattern = re.compile(p)
print(pattern.findall(key))
p = "@.+."
pattern = re.compile(p)
print(pattern.findall(key))
a = re.findall(p, key) 
if a==None: 
    print("YES")

key = "abcde@abc.edu.tw"
p = "@.+."   # @後，最少兩個字元
pattern = re.compile(p)
print(pattern.findall(key))

p = "@.+\."  # @後，結尾一定要是. (貪婪模式) 找最長
pattern = re.compile(p)
print(pattern.findall(key))

p = "@.+?\."  # @後，結尾一定要是. (勉強模式) 長最短
pattern = re.compile(p)
print(pattern.findall(key))

# %%
import requests, re

# url = "http://tw.yahoo.com"
# url = "http://www.pchome.com.tw/"
url = "http://www.google.com"
# pattern = "yahoo"
# pattern = "pchome"
pattern = "google"

htmlfile = requests.get(url)
if htmlfile.status_code == requests.codes.ok:
    print("網頁下載成功")
    if pattern in htmlfile.text:
        print(f"搜尋{pattern}成功")
    else:
        print(f"搜尋{pattern}失敗")
    name = re.findall(pattern, htmlfile.text) 
    if name != None:
        print(f"{pattern}出現{len(name)}次")
    else:
        print("搜尋失敗") # 基本不會
    #     print(f"{pattern}出現0次")
else:
    print("網頁下載失敗")

# %%    *********************   結合章節的應用   ************************
import requests, re
from bs4 import BeautifulSoup
resp = requests.get("https://bit.ly/3gkZaJa")
soup = BeautifulSoup(resp.text,'lxml') # 輸入 str 格式並解析
# 找出所有 h 開頭的標題文字
titles = soup.find_all(["h1", "h2", "h3", "h4", "h5", "h6"]) # 可以一次找多個
for title in titles:
    print(title.text.strip())       
# 找出所有 .png 結尾的圖片
imgs = soup.find_all("img") # 可以一次找多個
for img in imgs:
    if "src" in img.attrs:
        if img["src"].endswith(".png"):
            print(img["src"])       
# 找出所有 .png 結尾，且含 beginner 的圖片
imgs = soup.find_all("img") # 可以一次找多個
for img in imgs:
    if "src" in img.attrs:
        if "beginners" in img["src"] and img["src"].endswith(".png"):
            print(img["src"])       
            
print(format(" 使用正則 ","-^30")) # ***************************

# 利用 reggex 找出所有 h 開頭的標題文字
for title in soup.find_all(re.compile("h[1-6]")):
    print(title.text.strip())           
# 利用 reggex 找出所有 .png 結尾的圖片
for img in soup.find_all("img", {"src":re.compile("\.png$")}):
    print(img["src"])           
# 利用 reggex 找出所有 .png 結尾，且含 beginner 的圖片
for img in soup.find_all("img", {"src":re.compile("beginners.*\.png$")}):
    print(img["src"])       
