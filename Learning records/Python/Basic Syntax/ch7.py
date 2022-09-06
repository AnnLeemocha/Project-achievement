# 基礎檔案存取

# 基本輸入/出 (input()/print())

# 電腦系統標準預設入鍵盤，輸出螢幕
# 輸出至檔案
text='''~ 檔頭 ~
1.A
2.B
3.C
4.D
~ 結尾 ~'''
# fileName='D:\Desktop\機器與深度學習課程\PYTHON\data.txt' # 就算可以使用，但最好不要使用
# fileName='D:\\Desktop\\機器與深度學習課程\\PYTHON\\data.txt'
# fileName='D:/Desktop/機器與深度學習課程/PYTHON/data.txt'
# fileName=r'D:\Desktop\機器與深度學習課程\PYTHON\data.txt'
fileName=R'D:\Desktop\機器與深度學習課程\PYTHON\data.txt'
# r/R 原始字串，忽略跳脫字元
# mac 使用 R+/  or  R+//  or  R+\ 方式
# mac路徑設定測試完
# 1. /
# 2. //
# 3. R'/ 
# 只有這三種可用(但1跟3基本上一樣，所以不太需要)，
# 反斜線\都不能用，\會直接被當作檔名的一部份存在預設位置。
print(fileName)
print(text,file=open(fileName,'x'))  # 若檔案已存在，則不讓寫入(失敗跳出)
print(text,file=open(fileName,'w'))  
print(text,file=open(fileName,'a'))  # 若檔案已存在，則資料附加
print((open(fileName,'r')).read())
# print(text,file=open('data.txt','w')) # 存的路徑看右上方的路徑
# print(text,end='',file=open(fileName,'w')) 去除預設存留於最後的換行符號

# %% open() 函數 --> 檔案讀寫 (參數 file(檔名/路徑),mode(讀r/寫w))
# 寫入檔案
# 1. 開啟檔案
file = open('data.txt','w')
# 2. 寫入資料 (一定要是字串)
file.write('資料 : ')
file.write('ABCD\n') # 換行自己寫
file.write('1234')
# 3. 關閉檔案
file.close()   # print() 會自動關閉檔案

import random
# 開啟檔案
file = open('writedata.txt','w')
# 寫入資料 (一定要是字串)
for i in range(10):
    file.write(str(random.randint(1,100))+'\n')
# 關閉檔案
file.close() 

# %% open() 函數 --> 檔案讀寫 (參數 file(檔名/路徑),mode(讀r/寫w))
# 讀取檔案
# 1. 開啟檔案
file = open('data.txt','r')
# 2. 讀取資料
print(file.read())
# 3. 關閉檔案
file.close() 


# %% with 敘述
# 將存取檔案的動作包裝在一區塊
# 當區塊裡面之程式執行完畢時，會自動關閉檔案
with open('writedata.txt','r') as file:
    print(file.read())
with open('data.txt','w') as file:
    file.write('ABCD')
    file.write('中文')
    file.write('1234')
    file.write('3.14')
    
# %% 快捷
# 選擇 + Tab          (增加縮排) 
# 選擇 + Shift + Tab  (減少縮排)
# 選擇 + Ctrl + 1     (增加/去除註解)
