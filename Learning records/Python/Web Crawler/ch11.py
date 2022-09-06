# 網頁爬蟲 實戰演練 I

# %%    台灣彩券
# 大樂透開獎資訊
import requests
from bs4 import BeautifulSoup
url = "https://www.taiwanlottery.com.tw"
html = requests.get(url)
# soup = BeautifulSoup(html.text, "lxml")
soup = BeautifulSoup(html.text, "html.parser")

# data = soup.find_all("div",{"class":"contents_box02"})
data1 = soup.select(".contents_box02")
# div class="contents_box02"
# data2 = data1[2].find_all("div",{"class":"ball_tx"})
data2 = data1[2].select(".ball_tx")
# div class="ball_tx ball_yellow"
# data3 = data1[2].find("div",{"class":"ball_red"})
data3 = data1[2].select(".ball_red")
# div class="ball_red"

print("大樂透開出順序:", end=" ")
for i in range(6):
    print(data2[i].text, end="  ")
print("\n大樂透大小順序:", end=" ")
for i in range(6,len(data2)):
    print(data2[i].text, end="  ")
print("\n(紅球) 特別號:", end=" ")
# print(data3.text)
print(data3[0].text)

# %%    蘋果日報今日焦點新聞
# https://tw.appledaily.com/realtime/hot/

# soup.find_all([tag1, tag2, tag3])
# soup.find(tag)
# soup.find(tag,屬性內容)
# soup.find(tag,{屬性:屬性內容})
# soup.select(CSS語法) # class:內容 = .內容  |  id:3 = #3

# %%    Yahoo 新聞
import requests
from bs4 import BeautifulSoup
url = "https://tw.news.yahoo.com"
html = requests.get(url)
print(html) # 檢查回應狀況
# if html.status_code === requests.codes.ok:
soup = BeautifulSoup(html.text,'lxml')

# 取所有
print(format(" 取所有新聞標題 ","-^30"))
data = soup.find_all("li","Pos(r)")
n = 0
for i in data:
    n += 1
    print(f"{n}. ", i.find("a").text)

# 只取焦點
print(format(" 只取焦點新聞標題 ","-^30"))
data = soup.find("div",{"id":"mrt-node-Col1-1-Hero"})
data = data.find_all("li","Pos(r)")    
n = 0
for i in data:
    n += 1
    print(f"{n}. ", i.find("a").text)

# %%    教育部圖片下載
import requests, urllib, os, re
from bs4 import BeautifulSoup
url = "https://www.edu.tw"
html = requests.get(url).text
# html = urllib.request.urlopen(url).read()
soup = BeautifulSoup(html,"lxml")
data = soup.find_all("img")
##### 測試 #####
# for i in data:
#     print(i.attrs)
#     print(i.get("src"))

# 在工作目錄下建立目錄 pics 來儲存圖片
pics_dir = "pics"
if not os.path.exists(pics_dir):
    os.mkdir(pics_dir)

# n = 0
# ch = []
for i in data:
#     src = i.get("src")
#     attrs=[src]
    attrs = [i.get("src")]
    # 意義不大的作為
    for attr in attrs:
        # n += 1
        # ch.append(attr)
        print(attr)
        if attr!=None and (".jpg" in attr or ".png" in attr or ".gif" in attr):
            ful_path = attr
            file_n = ful_path.split("/")[-1]
            print(format("","=^40"))
            print("圖檔下載路徑:")
            print("\t",ful_path)
            # file = open(os.path.join(pics_dir,file_n),"wb")
            try:
                image = urllib.request.urlopen(ful_path)
            # 要寫入 bit 格式的圖檔
                file = open(os.path.join(pics_dir,file_n),"wb")
                file.write(image.read())
                print("下載成功:", file_n)
                file.close()
            except:
                print("下載失敗:", file_n, "(無法下載)")
            # finally:
            #     file.close()
                                  
# print(n)

# %%    教育部圖片下載
import requests
from bs4 import BeautifulSoup
url = "https://www.edu.tw"
html = requests.get(url).text
soup = BeautifulSoup(html,"lxml")
data = soup.find_all("img")
##### 測試 #####
name = [[],[]]
for i in data:
    # print(i.attrs)
    # print(re.findall("[^/]*\..{3}$", i.get("src")))
    list1 = re.findall(".*/", i.get("src"))
    list2 = re.findall("[^/]*\..{3}$", i.get("src"))
    # print(list1)
    name[0].append(list1)
    name[1].append(list2)
    # print(i.get("src")[-4:])

data = soup.find_all("img",{"class":"_1p6f _1p6g img"})
# for i in data:
#     print(i.get("src"))
# <img class="_1p6f _1p6g img" src="https://scontent.ftpe8-2.fna.fbcdn.net/v/t39.30808-6/297001128_432569448916337_2735893015240637295_n.jpg?stp=dst-jpg_p296x100&amp;_nc_cat=101&amp;ccb=1-7&amp;_nc_sid=8024bb&amp;_nc_ohc=3bUGBY3A-UUAX_R7I0p&amp;_nc_ht=scontent.ftpe8-2.fna&amp;oh=00_AT_CU585-Tm8h1a_3__cAoFJXKhxL3tsXHQprv3vg_XRAg&amp;oe=62F0D566" alt="" style="max-width:283px;max-height:188px;" width="283" height="188">

# # %%
# import urllib
# url = "https://www.facebook.com/photo.php?fbid=432569452249670&set=a.350627493777200&type=3"
# html = urllib.request.urlopen(url).read()
# soup = BeautifulSoup(html,"html.parser")
# # print(soup)
# data = soup.find_all("img")
# # print(data.get("src"))

