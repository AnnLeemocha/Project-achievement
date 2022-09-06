# selenium 基礎
# 動態網頁 (固定網址 >> 使用者互動 >> 內容改變)
# 安裝兩步驟：
# 1. pip install selenium
# 2. 瀏覽器驅動程式 (從網頁下載[chromedriver.exe]後，放到同路徑下)
# 功能同時有擷取與解析

# %%    基本用法 -1 
from selenium import webdriver
import time
driver = webdriver.Chrome("chromedriver") # 瀏覽器驅動程式 (打開)
time.sleep(3) # 停滯三秒
driver.quit() # 關閉視窗

# %%    基本用法 -2 
from selenium import webdriver
driver = webdriver.Chrome("chromedriver")
driver.implicitly_wait(8) # 等待8秒鐘來載入HTML，但是不管是否為8秒內外，成功就立即等待結束
driver.get("http://example.com")
print(driver.title)
html = driver.page_source
print(html)
driver.quit()

# %%    基本用法 -3 
from selenium import webdriver
from bs4 import BeautifulSoup
driver = webdriver.Chrome("chromedriver")
driver.implicitly_wait(10) # 等待8秒鐘來載入HTML，但是不管是否為8秒內外，成功就立即等待結束
driver.get("http://example.com")
print(driver.title)
soup = BeautifulSoup(driver.page_source, "lxml")
with open("index.html", "w", encoding="utf8") as fp:
    fp.write(soup.prettify())
    print("寫入檔案 index.html ...")
driver.quit() # 之前都在本地端，這邊則是在瀏覽器端

# %%    基本用法 -4 
# selenium 的定位函數
from selenium import webdriver
driver = webdriver.Chrome("chromedriver")
driver.implicitly_wait(10) # 等待8秒鐘來載入HTML，但是不管是否為8秒內外，成功就立即等待結束
driver.get("http://example.com")
# h1 = driver.find_element_by_tag_name("h1") # 已棄用
from selenium.webdriver.common.by import By
h1 = driver.find_element(By.TAG_NAME, "h1")
print(h1.text,"\n")
p = driver.find_element(By.TAG_NAME, "p")
print(p.text,"\n")
print("="*30)
from bs4 import BeautifulSoup
soup = BeautifulSoup(driver.page_source, "lxml")
h1_b = soup.find("h1")
print(h1_b.text,"\n")
p_b = soup.find("p")
print(p_b.text,"\n")
# selenium 有換行處理，BeautifulSoup吳煥行處理，保留換行與空白
meta = driver.find_element(By.TAG_NAME, "meta")
print(meta.get_attribute("charset"),"\n")
meta = driver.find_elements(By.TAG_NAME, "meta")
for i in meta:
    print(i.get_attribute("content"))
driver.quit()

# %%    定位網頁資料
from selenium import webdriver
import os
from selenium.webdriver.common.by import By
driver = webdriver.Chrome("chromedriver")
html_path = os.path.abspath("SeleniumTest.html")
# html_path = "file:D:\Desktop\機器與深度學習課程\PYTHON\程式\SeleniumTest.html"
driver.implicitly_wait(6)
driver.get(html_path)
# tag
h3 = driver.find_element(By.TAG_NAME, "h3")
print(h3.text)
p = driver.find_element(By.TAG_NAME, "p")
print(p.text)
# class
content = driver.find_element(By.CLASS_NAME, "content")
print(content.text)
# id
form = driver.find_element(By.ID, "loginForm")
print(form.text)
print(form.tag_name)
print(form.get_attribute("id"))
# 超連結
link1 = driver.find_element(By.LINK_TEXT ,"Continue")
print(link1.text)
link2 = driver.find_element(By.PARTIAL_LINK_TEXT,"Conti")
print(link2.text)
link3 = driver.find_element(By.LINK_TEXT,"取消")
print(link3.text)
link4 = driver.find_element(By.PARTIAL_LINK_TEXT,"取")
print(link4.text)
# name
user = driver.find_element(By.NAME,"username")
print(user.tag_name)
print(user.get_attribute("type"))
eles = driver.find_elements(By.NAME,"continue")
for ele in eles:
    print(ele.get_attribute("type"))
# CSS
# content = driver.find_element(By.CSS_SELECTOR, "body > h3")
content = driver.find_element(By.CSS_SELECTOR, "h3")
# content = driver.find_element(By.CSS_SELECTOR, "h3.content")
print(content.text)
p = driver.find_element(By.CSS_SELECTOR, "body > p")
# p = driver.find_element(By.CSS_SELECTOR, "p")
# p = driver.find_element(By.CSS_SELECTOR, "p.question")
print(p.text)
# driver.find_element(By.,"")
driver.quit()

# %%    例外處理
from selenium import webdriver
import os
from selenium.webdriver.common.by import By
from selenium.common.exceptions import NoSuchElementException

driver = webdriver.Chrome("chromedriver")
html_path = os.path.abspath("SeleniumTest.html")
# html_path = "file:D:\Desktop\機器與深度學習課程\PYTHON\程式\SeleniumTest.html"
driver.implicitly_wait(6)
driver.get(html_path)
try:
    content = driver.find_element(By.CSS_SELECTOR, "h2.content") # 原 h3
    print(content.text)    
except NoSuchElementException:
    print("選取元素不存在")
driver.quit()





















