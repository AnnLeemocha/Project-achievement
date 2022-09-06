# 初識 python

# 整數(int)
print(123)
# 浮點數(float)
print(123.21*123.124)
# 布林(bool)
print(13>31)

# 注意不可縮排，有層級問題

# Run ---> F5
# Selection Run ---> F9

# 區域劃分 #%%
# %%   字串 (str)

# 單行 '' OR ""
print('it is a good day')
print("it is a good day")
# 多行 (換房，包含換行後前面的空白) ''' ''' OR """ """
print('''it is a goo
      d day''')
print("""it is a goo
d day""")

# %%    跳脫字元 (Escape character)

# 反斜線
print('C:\todo')
print('C:\\todo')
# 單雙引號
print('it\'s')
print('it\"s')
# Tab
print('is\t it ?')
# 換行
print('is it OK?\nYes!')

# %%   變數指派方式 (指定運算子) " = " [賦值運算]
# 相對於 JAVA 不用先宣告型態
# Python 型態是以結果推論決定
name='小明'
print(name)
x=3
print(x)
x=x+1
print(x)
x=y=z=123
print(x)
print(y)
print(z)

# %%   變數型態
# Python 型態是以結果推論決定
# 為動態型態程式語言可更替型態
test=123
print(type(test))
test=123.123
print(type(test))
test="Ann Lee"
print(type(test))
test=123.2>123
print(type(test))

# 會記憶變數，右下請先 X 關閉清除

# %%  型態轉換
# str -> int
test=int('10')
# float -> int
test=int(3.14)
# bool -> int  ***
test=int(True)   # 1
test=int(False)  # 0
# float -> str
test=str(1.23)


# %%   變數刪除 del 變數
del name
del x
del y
del z
del test

# 搜不到即中斷程式

# %% 算術運算子
# 加 +
print(1+2)
print(1.5+2.3)
# 與 JAVA 不同，不可 print(1+"arr")
# 減 -
print(15-6)
print(20-True)  # bool 自動轉成數值
# 乘 *
print(12*21)
print("ABC"*2)  # 重複次數
# 除 /  (浮點數除法) 
print(6/3)
print(12/True) # bool 自動轉成數值
# 除 // (整數除法) 
print(8//3)
print(108//11)
# 餘 %
print(28%10)
print(12.5%10)
# 指數 ** (次方)
print(5**3)
print(3**5)

# %% 比較運算子
print(123=='123')    # 型態
print('ABC'=='abc')  # 大小寫
print(True==1)       # bool 自動轉換
print(False==0)
print((3>2)==True)
print(3>2==True)  # 注意！ 先 3>2? 再 2==1?

# %% 邏輯運算子
print((1>2) & (3>2))
print((1>2) and (3>2))
print((1>2) | (3>2))
print((1>2) or (3>2))
print(not(1>2)) # 無 !

# %% 指派運算子
# 無 a++ 、 a--
x,y,z=10,20,30
x*=y
print(x)
z%=5
print(z)

# %% 註解
# : 單行註解
''' 多行註解 '''
""" 多行註解 """

# %% 輸入 input()
# 右下角區域中，方形亮起代表執行中
input() # 預設 None
input("提示句：")
name=input("輸入姓名：")
print(name)
# 輸入均為字串(str)，轉乘值運算可使用 eval() 轉乘數值
num=eval(input('輸入數值：'))
print(type(num))
# 12, 12.5, True, 'ann', 變數名稱, 運算, 判斷
radius=eval(input('輸入半徑：'))
print('半徑為 ',radius,' 的圓面積為 ',3.14159*radius**2)

#  eval() 評估型態
num=eval(input('輸入：'))     # num <- 123, str <- 'abc' (not found <- abc)
print(type(num))
num=eval('input("輸入：")')   # str <- 123, abc
print(type(num))

# %% 輸出 print()
# value : 要印出多個值以逗號隔開
print(3,True,'xyz',name)
print(3,4,5)
# sep= : 選擇性參數，隔開兩個值的字串，預設為空格
# end= : 選擇性參數，印出最後一個值後所要加上的字串，預設為\n
# file= : 選擇性參數，用來輸出的裝置，預設為sys.stdout(標準輸出，即螢幕)
# print(3,4,5,sep=' ',end='\n',file=sys.stdout)
print(3,4,5,sep=', ',end=' --- ')
print('ABC')
print(3,4,5,sep=', ',end='\n --- ')
print('ABC')

# %% 格式化字串輸出
# 方法一
# %s : 字串格式
# %d : 10進為整數
# %f : 10進為浮點數
# string % data
# string % (data1, data2, ...)
print('Hi! %s' % 'Ann')
print('存款只剩 %d 元' % 666) 
print('存款只剩 %d 元' % 666.66) # 會無條件捨去
print('%d/%d = %f' % (20,7,20/7) )
print('%3d/%3d = %f' % (20,7,20/7) )
print('%d/%d = %.2f' % (20,7,20/7) )
print('%-3d/%-3d = %.3f' % (20,7,20/7) )
print('%-3d/%-3d = %5.3f' % (20,7,20/7) ) # 整+點+小數
print('%-3d/%-3d = %8.3f' % (20,7,20/7) )

# %% 格式化字串輸出
# 方法二
# '{格式化(字串)方式}'.format(數字/字串)
# 前字串中的 %->{:} ,  後 %->.format()
print('{:.2f}'.format(3.1415926))
print('{:+.2f}'.format(3.1415926))   # 帶正號
print('{:-.2f}'.format(-3.1415926))  # 帶負號
print('{: .2f}'.format(3.1415926))   # 正數前空格
print('{: .2f}'.format(-3.1415926))  # 負數前負號 
print('{:<-10d}'.format(-13))  # 帶負號 + 左對齊
print('{:.0f}'.format(3.555))    # 四捨五入到整數
print('{:10s}'.format('ABCDE'))
print('{:0>2d}'.format(5))    # 靠右，往前補 0
print('{:u>2d}'.format(5))        # 可替換
print('{:x<4d}'.format(10))   # 靠前，往後補 x
print('{:v<4d}'.format(10))       # 可替換
print('{:w^6d}'.format(10))   # 置中，其餘空位補 w
print('{:k^6d}'.format(10))       # 可替換
print('{:,}'.format(10000000))  # 加逗號輸出
print('{:10d}'.format(13))      # 靠右對齊
print('{:<10d}'.format(13))     # 靠左對齊
print('{:^10d}'.format(13))     # 置中對齊
print('{:%}'.format(0.25))      # 百分比 0.25 -> 25%
print('{:.2%}'.format(0.25))    # 小數位數
print('{:.0%}'.format(0.25))
print('{:e}'.format(10000000))   # 科學記號
print('{:.2e}'.format(10000000)) # 小數位數
print('{:.0e}'.format(10000000))
# 從後到前

# %% 格式化字串輸出
# 方法二
# 將數值轉為不同進制
# decimal : 十  (d)
# binary :  二  (b)
# octal :   八  (o)
# hex :   十六  (x)
# {索引值:?進制輸出}
print('{0:d}--{0:b}--{0:o}--{0:x}'.format(10))
print('{2:d}--{0:b}--{1:o}--{0:x}'.format(10,20,30))
print('%d 除以 %d = %.2f'% (10,3,10/3) )              # 方法一
print('{0:d} 除以 {1:d} = {2:f}'.format(10,3,10/3) )  # 方法二
print('{0:5d} 除以 {1:5d} = {2:8.2f}'.format(10,3,10/3) )
# 索引值可賦予代號
print('{n1:5d} 除以 {n2:5d} = {n3:.2f}'.format(n1=10,n2=3,n3=10/3) )
print('{n1:<5d} 除以 {n2:<5d} = {n3:<8.2f}'.format(n1=10,n2=3,n3=10/3) )
print('{n1:>5d} 除以 {n2:>5d} = {n3:>8.2f}'.format(n1=10,n2=3,n3=10/3) )
print('{n1:^5d} 除以 {n2:^5d} = {n3:^8.2f}'.format(n1=10,n2=3,n3=10/3) )
print('{n1:!^5d} 除以 {n2:?^5d} = {n3:@^8.2f}'.format(n1=10,n2=3,n3=10/3) )
# 索引值可賦予代號，但不能用變數
n1,n2,n3=10,3,10/3
print('{n1:d} 除以 {n2:d} = {n3:f}'.format(n1=n1,n2=n2,n3=n3) )



