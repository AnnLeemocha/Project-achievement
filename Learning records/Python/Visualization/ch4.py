# CSV檔案讀取 (Data Processing CSV)

# %% CSV (Comma-Separated Values)
# ◆ 也稱字元分隔值(因為分隔字元也可以不是逗號)， 
#    是一種以「逗號分隔」的檔案格式，並以「純文字形式」儲存資料
# ◆ CSV是一種通常並相對簡單的檔案格式，廣泛應用於商業、科
#    學領域，幾乎所有的分析軟體和應用程式都支援CSV格式
# ◆ CSV可以用excel開啟，第一行可以做為普通的內容，也可以做為表格的欄名
# ◆ OpenOffice的Calc和LibreOffice的Calc也可以處理CSV檔案

# %% 補充
# Notepad++ : 不管什麼編碼都能開啟檢視，也能儲存任何檔案型態
#             Python, SQL, XML ...
#             載點： https://github.com/notepad-plus-plus/notepad-plus-plus/releases/download/v8.4.4/npp.8.4.4.Installer.x64.exe

# %%  CSV常用方法
#        方法                    說明
# reader(csvfile)      讀取CSV檔案(以list形式呈現)
# writer(csvfile)      寫入CSV檔案(以list形式呈現)
# DictReader(csvfile)  讀取CSV檔案(以dict形式呈現)
# DictWriter(csvfile)  寫入CSV檔案(以dict形式呈現)

# %%  讀取CSV檔案
# ◆ (1) 要讀取CSV檔案前，需要先匯入CSV模組
#        import csv
# ◆ (2) 使用open函式開啟CSV檔案
#        with open(檔名, encoding=“utf8”) as 別名
# ◆ (3) 使用reader函式，建立讀取物件
#        變數 = csv.reader(別名)
# ◆ (4) 讀出來的檔案是以list方式呈現，因此可以用list+迴圈方式帶出資料
#        變數 = list(變數)

# %%   CSV編碼問題
# ◆ 讀取檔案時，最常遇到的就是編碼問題，特別是中文有多種編
#    碼，若IDE與檔案編碼不一致時，可能會發生檔案無法讀取的問題
# ◆ Spyder、 excel的預設編碼為 ANSI，但有些檔案的編碼可能是
#    cp950、 utf-8等等，在讀檔時就會發生錯誤
# 通常 excel異常並不代表檔案壞掉，記事本正常才正確
# 若是 utf_8_BOM 要用 utf-8-sig
import csv
fp = "test.csv"
# 同預設 ANSI 編碼
with open(fp) as file:   
    readFile = csv.reader(file)   # 以list形式呈現
    print(readFile) # 記憶體位置
    data = list(readFile)
    print(data)
    print()
    for i in data:
        print(i)
        
print()
with open(fp) as file:   
    readFile = csv.DictReader(file)   # 以dict形式呈現
    for i in readFile:
        print(i)

print()
fp = "test3.csv"
# utf-8 編碼
with open(fp,encoding="utf-8") as file:   
    readFile = csv.reader(file)
    data = list(readFile)
    for i in data:
        print(i)

print()
fp = "test4.csv"
# utf_8_BOM 編碼 ( utf16 用 utf8 讀?)
with open(fp,encoding="utf-8-sig") as file:   
    readFile = csv.reader(file)
    data = list(readFile)
    for i in data:
        print(i)


# %%  寫入CSV檔案
# ◆ (1) 要寫入CSV檔案前，需要先匯入CSV模組
#    import csv
# ◆ (2) 使用open函式開啟CSV檔案
#    with open(檔名,”w”,newline=‘’, encoding=“utf8”) as 別名
#       ◆ “w”：寫入模式，常用的有w、 a
#       ◆ newline=“”：為了避免輸出時每行之間都有空一行(\n) ****
#       ◆ encoding=“utf8”：編碼格式
# ◆ (3) 使用writer函式，建立讀取物件
#    變數 = csv.writer(別名)
# ◆ writer()函式預設是以逗號區隔，若想要更改區隔符號，
#    可以使用參數delimiter

import csv
fp = "write.txt"
with open(fp,"w", encoding="utf8") as file:
    writeFile = csv.writer(file)
    writeFile.writerow(["Name","Age","Phone"])
    writeFile.writerow(["Lisa",18,"0952123456"])
    writeFile.writerow(["Jerry",20,"0987654321"])
    writeFile.writerow(["DD",87,"0999999999"])
    writeFile.writerow(["老鼠",66,"0911111111"])

fp = "write2.txt"
with open(fp,"w",newline="", encoding="utf8") as file:
    writeFile = csv.writer(file)
    writeFile.writerows(data)
    
fp = "write3.txt"
with open(fp,"w",newline="", encoding="utf8") as file:
    writeFile = csv.writer(file,delimiter='\t')
    writeFile.writerows(data)

with open(fp,encoding="utf-8") as file:   
    readFile = csv.reader(file,delimiter='\t')
    data = list(readFile)
    for i in data:
        # i[0].split('\t')
        print(i)
    
# %%
# 讀寫CSV檔案
# ◆ 若想要將讀取的檔案寫至新檔案中(複製檔案)，可以用以下方式達成
import csv
indata = "test3.csv"
outdata = "copy_test.csv"
with open(indata,encoding="utf-8") as file:   
    readFile = csv.reader(file)
    data = list(readFile)
with open(outdata,"w",newline="", encoding="utf8") as file:
    writeFile = csv.writer(file)
    for i in data:
        writeFile.writerow(i)




