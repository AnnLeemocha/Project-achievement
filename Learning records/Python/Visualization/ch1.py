# 模組與套件
# import numpy as np
# import pandas as pd

# %% 模組 (module)

# %%  時間模組 – time
import time
# 取得目前時間數值
# 表示從 1970年1月1日到目前過了 ()秒
print(time.time())   ## 較常用
# 取得目前時間
# tm_year 顯示年
# tm_mon 顯示月， 1到12
# tm_mday 顯示日， 1到31
# tm_hour 顯示小時， 0到23
# tm_min 顯示分， 0到59
# tm_sec 顯示秒， 0到61(60或61是潤秒)
# tm_wday 顯示星期， 0到6(0是周一)   ****
# tm_yday 顯示一年中的第幾天， 1到366
# tm_isdst 是否為夏令時間， 1為夏令時， 0為否   **** 歐美
print(time.localtime(time.time()))
# 取得格式化時間
print(time.asctime(time.localtime(time.time())))
# 程式停止執行n秒 [爬蟲時會用到，偽裝並非機器人]
print(1)
time.sleep(2)   ## 較常用
print(5)
# 程式跑幾秒
total = 0
startTime = time.time()
for i in range(100000):
    total += 1
print(total)
print(time.time() - startTime)

# %%  日曆模組 – calendar
import calendar 
# 取得x年y月的日曆
print(calendar.month(2022, 7))
# 取得x年的所有月份日曆
print(calendar.calendar(2022))
# 查詢x年是否為潤年，潤年為True，否則為False
print(calendar.isleap(2022))
# 查詢x年y月z日的日期碼， 0(週一)到6(週日)
print(calendar.weekday(2022, 7, 6))

# %%  時間與日期模組 – datetime
import datetime
print(datetime.date.today())
from datetime import date
today = date.today()
print(today)                    # 2022-07-25
print(today.year)               # 2022
print(today.month)              # 7
print(today.day)                # 25
print(today.weekday())          # 0 (0~6)
print(today.isoweekday())       # 1 (1~7)
print(today.isocalendar())      # (2022)年 第幾(07)周 星期幾(1)
print(today.isoformat())        # 思考更改輸出格式

# %% 套件 (Package)
# 原則上，只要是包含__init__.py檔案的資料夾就會被視為python的一個套件
# 安裝anaconda幫載好的：
# 預設位置 --> C:\Users\annle\anaconda3\Lib\site-packages
# ◆ 陣列計算 NumPy
# ◆ 科學計算 SciPy
# ◆ 數據處理與資料分析 Pandas
# ◆ 視覺化工具 Matplotlib
# ◆ 視窗界面(GUI)開發 PyQt、 tkinter
# ◆ 存取網際網路資料 Requests
# ◆ HTML/XML解析器 BeautifulSoup
# ◆ Web框架 Django、 Flask
# ◆ 圖形處理 Pillow
# ◆ 遊戲開發 PyGame
# ◆ 機器學習 scikit-lean

# %% 安裝第三方套件 – 指令安裝
# [1] Spyder
# ◆ 安裝： pip install 套件名稱
# ◆ 更新： pip install --upgrade  套件名稱
#          pip install -U  套件名稱
# ◆ 移除： pip uninstall 套件名稱
# ◆ 查看目前安裝套件及版本： pip list
# 自我更新： pip install --upgrade pip
#           pip install -U pip
# 或者用Python命令参数-m选项来安装也是可以的，-m的意思是用Python解释器来运行pip再更新，Python更新pip命令如下：
#           python -m pip install --upgrade pip
#           python -m pip install -U pip
# [2] Anaconda Prompt(anaconda3)
# 使用 Anaconda3(64-bit) >> Anaconda Prompt(anaconda3) [以使用者身分開啟]
# pip install django
# [3] CMD
# 若有自行安裝 python 預設會先被吃進，Spyder 會吃不到

# %% 安裝第三方套件 – 網路下載
# ◆ 到python官網>PyPi裡搜尋要安裝的套件名稱並下載安裝

