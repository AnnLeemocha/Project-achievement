from bs4 import BeautifulSoup as bs
from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome("chromedriver")
driver.get("https://www.pet.gov.tw/Web/O302.aspx?PG=1")
# 日期定位
select_start = driver.find_element(By.ID,"txtSDATE")
select_end = driver.find_element(By.ID,"txtEDATE")
year = [2020]
# 選擇日期
select_start.send_keys(str(year[0])+"/01/01")
select_end.send_keys(str(year[0])+"/12/31")
# 選擇選項"全部"
select_type = driver.find_element(By.CLASS_NAME, "circle")
select_type.click()
# 點擊搜尋
driver.find_element(By.ID, "aSearch").click()
driver.implicitly_wait(5)
# 資料解析
soup = bs(driver.page_source, "lxml")
table = soup.select_one("#CountTown")
print(table.prettify)

# 縣市  鄉鎮  登記單位數  登記數  除戶數  轉讓數  變更數  絕育數  絕育除戶數  免絕育數  免絕育除戶數  絕育率  繁殖管理率  
# pet_title = []
# for i in table.find_all("th"):
#     s = (i.text).split("(")[0].replace(" ","").replace("\n","")
#     pet_title.append(s)
#     print(s, end="  ")

with open("test.html","w", encoding="utf8") as file:
    file.write(soup.prettify())

driver.quit()
