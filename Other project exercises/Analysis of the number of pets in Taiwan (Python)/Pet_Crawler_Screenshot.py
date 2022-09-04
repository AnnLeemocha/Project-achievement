# 截圖
# https://www.learncodewithmike.com/2021/09/python-selenium-screenshot.html
# https://pythonmana.com/2022/02/202202102035045330.html
# from selenium.webdriver.common.action_chains import ActionChains
# from selenium.webdriver.support.ui import WebDriverWait
# # pip install webdriver-manager
# from webdriver_manager.chrome import ChromeDriverManager
# driver = webdriver.Chrome(ChromeDriverManager().install())
from selenium import webdriver
from PIL import Image
import time
from selenium.webdriver.common.by import By

driver = webdriver.Chrome("chromedriver")
driver.get("https://www.pet.gov.tw/Web/O302.aspx?PG=1")

year = list(range(1998,2022))
# year =[1998]
def get_pic(year, path):
    for i in range(len(year)):
        print(year[i])
        filename = path+str(year[i])+".png" 
        select_start = driver.find_element(By.ID,"txtSDATE")
        select_end = driver.find_element(By.ID,"txtEDATE")
        date = str(year[i])+"/01/01"
        select_start.send_keys(date)
        date = str(year[i])+"/12/31"
        select_end.send_keys(date)
        
        driver.find_element(By.ID, "aSearch").click()
        time.sleep(10)
        # 調整式窗大小與比例
        driver.execute_script("document.body.style.zoom='0.5';")
        driver.execute_script("var action=document.documentElement.scrollTop=350")
        # 截圖
        # driver.get_screenshot_as_file("2330.png")
        driver.get_screenshot_as_file(filename)
        webpage=Image.open(filename)
        # image_crop=webpage.crop(box=(left,upper,right,bottom))
        # 截圖範圍選取
        image_crop=webpage.crop(box=(15, 90, 1025, 750))
        # 存取截圖結果
        image_crop.save(filename)
        image_crop=Image.open(filename)
        # 調回式窗比例 (避免定位查詢鍵會出現問題)
        driver.execute_script("document.body.style.zoom='1';")
        # 清空時間選項
        select_start.clear()
        select_end.clear()
        time.sleep(10)

for j in driver.find_elements(By.CLASS_NAME, "form-check-label"):
    # print(i.text)
    if j.text == "全部":
        print(format(" 全部 ","=^30"))
        j.click()
        path = "./data/pic/Pet_All_"
        get_pic(year, path)
    elif j.text == "狗":
        print(format(" 狗 ","=^30"))
        j.click()
        path = "./data/pic/Pet_Dog_"
        get_pic(year, path)
    elif j.text == "貓":
        print(format(" 貓 ","=^30"))
        j.click()
        path = "./data/pic/Pet_Cat_"
        get_pic(year, path)

driver.quit()
