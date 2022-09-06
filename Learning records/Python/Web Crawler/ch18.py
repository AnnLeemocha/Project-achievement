# 網頁爬蟲 實戰演練 II

# %%    selenium 換頁擷取
# 大樂透開

from bs4 import BeautifulSoup as bs
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
# from matplotlib import pyplot as plt
# import numpy as py
# import pandas as pd

lotto_list = []

driver = webdriver.Chrome(r"D:\Desktop\機器與深度學習課程\PYTHON\程式\chromedriver")
driver.get("http://www.taiwanlottery.com.tw/lotto/superlotto638/history.aspx")

# 勾選以年月查詢選項
driver.find_element(By.ID,"SuperLotto638Control_history1_radYM").click()

while True:
    select_years = Select(driver.find_element(By.ID,"SuperLotto638Control_history1_dropYear"))
    year = input("請選擇你要找的年份(國立103年開始):\t")
    print("請稍後...")
    select_years.select_by_value(year) # 不用做型態轉換，必須接字串
    for i in range(12):
        # 選擇月份
        select_month = Select(driver.find_element(By.ID,"SuperLotto638Control_history1_dropMonth"))
        select_month.select_by_value(str(i+1))
        # 點擊查詢
        driver.find_element(By.ID, "SuperLotto638Control_history1_btnSubmit").click()
        # 抓取內容
        html = driver.page_source
        soup = bs(html, "html.parser")
        # 獲取 table(表格) 數目
        table_count = len(soup.findAll("table",{"class":"td_hm"}))
        # 抓取號碼
        for i in range(table_count):
            for j in range(1,7):
                temp = soup.find("span",{"id":"SuperLotto638Control_history1_dlQuery_No"+str(j)+"_"+str(i)})
                lotto_list.append(int(temp.text))
    check = input("還要繼續選擇其他年份嗎?繼續請輸入Y:\t")
    if check.upper() != "Y":
        print("已結束，謝謝!")
        break
driver.quit()

# %%    JavaScript 動態網頁擷取
# https://hahow.in/courses
# 檢視無法看到內容，檢查可以看到
from bs4 import BeautifulSoup as bs
from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome("chromedriver")
driver.implicitly_wait(5)
driver.get("https://hahow.in/courses")
print(driver.title)
soup = bs(driver.page_source, "lxml")
with open("hahow.html","w",encoding="utf8") as fp:
    fp.write(soup.prettify())
    print("寫入 hahow.html ...")
# 發現被屏蔽，只一瞬閃過，但檢視有(檢查無) (只有IE開啟有完整資料顯示)
# script 特效功能，刪除之後可常運作，也可檢視到內容
items = driver.find_elements(By.CSS_SELECTOR,"h4.title")
for item in items:
    print(item.text)
driver.quit()

# %%
# https://www.nba.com/stats/players/traditional/?sort=PTS&dir=-1
from bs4 import BeautifulSoup as bs
from selenium import webdriver
import pandas as pd
import time
from selenium.webdriver.common.by import By

driver = webdriver.Chrome("chromedriver")
driver.implicitly_wait(5)
driver.get("http://stats.nba.com/players/traditional/?sort=PTS&dir=-1")
# driver.get("https://www.nba.com/stats/players/traditional/?sort=PTS&dir=-1")
# print(driver.title)

pages_remaining = True
page_num = 1
while pages_remaining:
    # bs4 解析 HTML 網頁
    soup = bs(driver.page_source, "lxml")
    # table = soup.select("body > main > div > div > div.row > div > div > nba-stat-table > div.nba-stat-table > div.nba-stat-table__overflow > table")
    table = soup.select_one("body > main > div > div > div.row > div > div > nba-stat-table > div.nba-stat-table > div.nba-stat-table__overflow > table > tbody")
    df = pd.read_html(str(table))
    # print(df[0].to_csv())
    df[0].to_csv("All_players_stats"+(page_num)+"csv")
    print("儲存頁面:",page_num)
    
    try:
        # 自動下一頁
        next_link = driver.find_element(By.XPATH,"/html/body/main/div/div/div[2]/div/div/nba-stat-table/div[1]/div/div/a[2]")
        next_link.click()
        time.sleep(5)
        if page_num < 11:
            page_num += 1
        else:
            pages_remaining = False
    except Exception:
        pages_remaining = False
        
# driver.quit()







