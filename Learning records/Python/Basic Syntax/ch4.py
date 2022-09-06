# 內建函數

# %% 字串運算子
# + : 連接運算子
print('Happy'+'Day'+'Yeah!')

# * : 重複運算子
print('Yeah!'*3)

# 比較運算子 (轉成 ASCII code 再比較)
print('X'>'M')
print('123'>'456')
print('XYZ'>'xyz')
# unicode table (0x000~0xfff -> 0~65535) [前面一小區塊為 ASCII]
# ASCII table (0~127) [1.有什麼 2.順序(符，數，大寫英，小寫英)]

# in 與 not in 運算子
print('or' in 'forever')
print('for' not in 'forever')

# 索引運算子 []
s='Python程式設計'
# 從前端開始：  0 ~ N-1
print(s[0])
print(s[1])
print(s[10-3]) # 共 10 個字，取倒數第 3 個
# 從後端開始： -1 ~ -N
print(s[-3]) # 共6個字，取倒數第 3 個

# 索引運算子 [start:end]
# 包前不包後
print(s[2:5])  # 取第 3~5 個字 --> [索引 2~4 (不含5)]
print(s[5:-1]) # 取第 6~倒數第2 個字 -->[索引 5~-2 (不含-1)] 索引-1前一個字為索引-2 
# 省略開頭，預設值為 0
print(s[:-2])  # 去除尾端兩個字
# 省略結尾，預設值為 字串長度
print(s[2:])   # 去除開頭兩個字 

# %% Exercise
s1='HappyNewYear'
s2='happynewyear'
s3='new'
# s1 長度
print(len(s1))
# s1, s2 是否相等
print(s1==s2)
# s1 中 Unicode 碼最大字元
print(max(s1))
# s1 中 Unicode 碼最小字元
print(max(s1))
# s3 是否不存在於 s1
print(s3 not in s1)
# s3 是否存在於 s2
print(s3 in s2)
# s1 第 5~9 個字元
print(s1[4:9])

# %% 字串處理函數
# 基本字串處理函數
# ord(c) : 傳回字元參數 c (Unicode 字元) 的 Unicode 碼
print(ord('A'))
# chr(u) : 傳回整數參數 u (Unicode 碼) 的 Unicode 字元
print(chr(8364))
# len(s) : 傳回字元參數 s 的長度 (共幾個字元)
print(len(s))
# max(s) : 傳回字元參數 s 中 Unicode 碼最大字元
print(max(s))
# min(s) : 傳回字元參數 s 中 Unicode 碼最小字元
print(min(s))
# str(n) : 傳回數值參數 n 轉換成字串的結果 
print(str(123.4))

# %% 字串處理函數
# 字串處理函數
# 1. 字串轉換函數
x='Good Afternoon! How are you?'
x1='are you OK?'
print(str.upper(x))        # 兩種皆可 
print(x.lower())           # 兩種皆可 
print(str.swapcase(x))     # 兩種皆可 
print(str.capitalize(x1))  # 兩種皆可 
print(str.title(x))        # 兩種皆可 
print(x.replace('oo','xx')) # 僅這一種? 

# %% 字串處理函數
# 2. 字串測試函數
print(str.isupper(s))
print(str.islower(s))
print(str.isidentifier(s))
print(str.isspace(s))
print(str.istitle(s))

print('abc中文'.isalpha())
print('abc中文'.encode( 'UTF-8' ).isalpha())
print('abc123'.isalpha())

print('12345'.isdigit())
print('一二三四五'.isdigit())

print('123'.isdecimal())
print('123.45'.isdecimal())
print('一二三四五'.isdecimal())

print('123'.isnumeric())
print('123.45'.isnumeric())
print('一二三四五'.isnumeric()) # 中文數字 OK
print('一二三四五'.isnumeric())
print('你好'.isnumeric())
# 羅馬數字的 1 非大寫 i

# %% 字串處理函數
# 3. 搜尋子字串函數
y='Hi'*5
print(y.count('i'))
print(y.count('Hi'))
print(y.startswith('H'))  # 開頭:bool
print(y.startswith('Hi')) 
print(y.startswith('i'))
print(y.endswith('H'))    # 結尾:bool
print(y.endswith('i'))
print(y.endswith('iHi'))
print(y.find('iHi'))  # 最小(第一符合條件者)索引之首字位置 # 開頭:index
print(y.rfind('iHi')) # 最大(最後符合條件者)索引之首字位置 # 結尾:index

# %% 字串處理函數
# 4-1. 字串切割函數
x='A B C D E'
print(x.split()) # 預設為空白進行字串切割
x='A    B    C    D   E'
print(x.split()) # 無論空多少格
x='1,3,5,7,9'
print(x.split(','))  # 根據參數設定進行字串切割
x='1,3,5,7,9 11'
print(x.split(','))

# 4-2. 刪除指定字元/空白函數
print('  abcd  '.strip())  # 預設為空白，即刪除兩側空白 
# ''.strip('') ： 從字串"兩側"刪除參數指定字元，一旦碰到非指定字元就停止刪除
print('abcxyzd ef'.strip('abcdef'))  # 碰到空白停止
print('cbaxyzd fe'.strip('abcdef'))  # 與順序無關
print('abcxyzd ef '.strip('abcdef')) # 可重複
print('abcxyzd ef '.strip('abcdef '))
print('tw.yahoo.com'.strip('.tomw'))
# ''.lstrip('') ： 從字串"左側"刪除參數指定字元，...
print('tw.yahoo.com'.lstrip('.tomw'))
# ''.rstrip('') ： 從字串"右側"刪除參數指定字元，...
print('tw.yahoo.com'.rstrip('.tomw'))

# %% 字串處理函數
# 5. 格式化函數
x='Hello Python'
print(x.center(5))  # 給的字元的欄寬太小，不變
print(x.center(20)) # 給大小為 20 字元的欄寬，把字串 x 置中放置並顯示
print(x.ljust(20))  # 置左
print(x.rjust(20))  # 置右
print(x.zfill(20))  # 給大小為 20 字元的欄寬，於字串左側補 0 ，至補滿欄寬，保留寫在最左側的 +/- 在最左側
print('+Hello'.zfill(20))
print('H+ello'.zfill(20))
print('+100'.zfill(2))  # 給的字元的欄寬太小，不變
print('+100'.zfill(20))
print('-100'.zfill(20))
x='Hello Python'       # 字串預設靠左
print(format(x+' 預設','20'))  # 預設
print(format(x,'20'))  # 預設
print(format(x,'>20'))
print(format(x,'<20'))
x=12345                # 數字預設靠右
print(format(x,'20'))  # 預設
print(format(x,'>20'))
print(format(x,'<20'))

# %%   字串處理函數，使用之表現方式有三種
# 1. len(s)
print(len(s))
# 2. str.len(s)
print(str.upper(s))
# 3. 'yeah'.len()
print('yeah'.upper())

# %% 數值處理函數
print(abs(50))
print(abs(-50))
print(pow(2,5))
print(pow(2,-2))
print(divmod(100,8))
print(divmod(125,9.5))
# 進行比較後，回傳容器內內容
print(max(10,20,30))
print(max(-10,-20,-30))
print(max(True,-20,-30))
print(min(1,3,False))
print(max('a','b','c'))
print(min('A','a','b','c'))
print(bin(100)) # 十 -> 二
print(oct(100)) # 十 -> 八
print(hex(100)) # 十 -> 十六
print(int(66.66)) 
print(int('666')) # 不能 '66.66', '六六六'
print(float(666))
print(float('666')) # 不能 '六六六'
print(float('666.66'))

# round(x) 傳回最接近 x 之整數
# round(x,y) 傳回"最接近" x 精確到小數點第 y 位之小數，但...
print(round(123.123))     # 123
print(round(123.123,2))   # 123.12
print(round(-567.567))    # -568
print(round(-567.567,2))  # -567.57 "最接近"
# 【注意! round(x) 並非四捨五入 !!! (不建議用round)】
# 在只有小數點一位時，
# 正數時，整數位 "奇進，偶不進" (原:5.5 -> 6 / 6.5 ->7) (round: 5.5 -> 6(進) / 6.5 -> 6(不進))
print(round(5.5))
print(round(6.5))
# 負數時，整數位 "偶進，奇不進" (原:-5.5 -> -5 / -6.5 ->-6) (round: -5.5 -> -6(不進) / -6.5 -> -6(進))
print(round(-5.5))
print(round(-6.5))
# 在小數點二位以上時，"無特殊準則可循"
print(round(55.005,2))
print(round(55.015,2))
print(round(55.025,2))
print(round(55.035,2))
print(round(55.045,2))
print(round(55.055,2))
print(round(55.065,2))
print(round(55.075,2))
print(round(55.085,2))
print(round(55.095,2))
print()
print(round(-55.005,2))
print(round(-55.015,2))
print(round(-55.025,2))
print(round(-55.035,2))
print(round(-55.045,2))
print(round(-55.055,2))
print(round(-55.065,2))
print(round(-55.075,2))
print(round(-55.085,2))
print(round(-55.095,2))

# %% 數值處理函數
# 數學函數 (math 模駔)
import math

print(math.pi)
print(math.e)
print(math.nan)
print(math.inf)    # ?

print(math.ceil(10))    # ?
print(math.fabs(10.5))    # ?
print(math.factorial(10))    # ?
print(math.floor(10))    # ?
print(math.gcd(10,5))    # ?
print(math.exp(-1))
print(math.log(math.e))
print(math.log(10,10))
print(math.log10(10))
print(math.log(4,2))
print(math.log2(4))
print(math.log1p(math.e))
print(math.sqrt(25))

print(math.isfinite(30))    # ?
print(math.isfinite(math.nan))    # ?
print(math.isinf(math.inf))
print(math.isinf(10))
print(math.isnan(math.nan))
print(math.isnan(30))
print(45*math.pi/180)
print(math.radians(45))
print(math.degrees(45*math.pi/180))

print(math.cos(math.radians(0))) # 弧度
print(math.sin(math.radians(90)))
print(math.tan(math.radians(90)))
print(math.acos(math.radians(0))) # 弧度
print(math.asin(math.radians(0)))
print(math.atan(math.radians(0)))

# %% 數值處理函數
# 亂數函數
import random
# random.randint(x,y) 包前也包後 (特例)
print(random.randint(1,10)) # 1~10 隨機
print(random.random()) # >0.0 <1
x=[1.1,2.2,3.3,4.4,5.5]
random.shuffle(x)  # 免賦值
for i in x:
    print(i)

# %% 數值處理函數
# format 格式化
print(format(123,'^10'))
print(format(123,'!^10'))
print(format(123456789,','))
print(format(1234.5678,'10.2f'))
print(format(1234.5678,'<10.2f'))

# %% Exercise

