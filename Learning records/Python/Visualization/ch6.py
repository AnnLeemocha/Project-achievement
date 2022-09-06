# NumPy套件

# %% NumPy簡介
# ◆ NumPy是Python的第三方函式庫，支援大量維度的陣列和矩陣運算，
#    也具備大量的數學與統計函式庫
# ◆ 可以有效的進行科學運算和資料數據分析
# ◆ Python許多知名套件，例如Pandas、 SciPy、 Matplotlib、SymPy…等，
#    都是架構在NumPy基礎上做應用
# ◆ NumPy是Numerical Python的簡稱，是高性能計算和資料分析的基礎套件
# ◆ ndarray(n-dimensional array)是NumPy的核心，即多維陣列，以下為NumPy官
#   網對ndarray的定義 :
#      An ndarray is a (usually fixed-size) multidimensional container of items of the same
#      type and size
# ◆ 意思是NumPy是由相同型別(type)和相同大小(size)的元素構成的多維容器。
#    而ndarray只能儲存具有相同型別的元素，且各維的元素數量必需固定
# ◆ NumPy的底層是由C或Fortran語言撰寫，在處理NumPy陣列時，這些運算可以
#    經過最佳化的NumPy函式來處理，它們會將繁重的工作委託給底層，做到高速運算


# %%   使用NumPy套件
# ◆ 使用NumPy套件時，需要先匯入，語法為：
#     import numpy as np
# ◆ 建立第一個NumPy一維陣列，跟list的一維陣列做比較
# 【list 與 ndarray 並不相同】
# 右上角變數淺到深(紅->紫)為大到小，裡面內容可改，但並不改變實際儲存值

import numpy as np
x = np.array([100,3.14,True,'abc']) # str
print(type(x))
print(x)  # 型態必須一致，所以全部轉成 str 型態

x1 = np.array([100,3.14,True,'123']) # str
print(x1)   # 型態必須一致，所以全部轉成 str 型態
x1 = np.array([100,3.14,True,123]) # float
print(x1)   # 型態必須一致，所以全部轉成 float 型態
print(x1*2) # 陣列運算，為數學運算，所以內容必須皆為數值

x2 = [100,3.14,True,'abc'] # list
print(type(x2))
print(x2)
print(x2*2) # 串列內容重複兩次

# %%   NumPy的資料結構
# ◆ NumPy的核心「 ndarray」 的資料結構是一個多維度、同性質、
#    固定大小的陣列物件
# ◆ 1-dimensional array(一維陣列)
#           col 0 
#    row 0    A
#    row 1    B
#    row 2    C
#    row 3    D
#    row 4    E
# ◆ 2-dimensional array(二維陣列)
#           col 0 col 1 col 2 col 3 col 4
#    row 0    A     B     C     D     E
#    row 1    A     B     C     D     E
x1 = np.array([1,2,3]) # int
x2 = np.array([[1,2,3],[4,5,6],[7,8,9]]) # int
x3 = np.array([[1,2,3],[4,5,6],[7,8,9],[10,11]]) # object (非一致)

# %%   體驗NumPy的處理速度
# ◆ 先產生10萬個數值，分別以ndarray和list儲存，再比較「將所
#    有數值加總」所需要的時間

import numpy as np
import time
# 用 numpy 個產生10萬個亂數
x = np.random.rand(100000)  # ndarray
y = list(x)                 # list
# numpy
sTime = time.time()
for _ in range(1000):
    sum1 = np.sum(x)
print('使用 numpy 所花時間 %f 秒' % (time.time()-sTime))
# list
sTime = time.time()
for _ in range(1000):
    sum1 = sum(y)
print('使用 list 所花時間 %f 秒' % (time.time()-sTime))

# %%   NumPy快速的原因
# ◆ 由於list在存放時， list內的元素是分散在記憶體各處，因此在讀取資料時
#    需要花費較長的時間
# ◆ 但ndarray在存放時，是儲存在有連續性的記憶體上，因此讀取時效率較
#    list來的要高

# %%   常用的屬性
# ◆ ndarray屬性使用方式：
#        物件名稱.屬性名稱
# ◆ 要注意的是執行屬性後ndarray的原始資料不會改變，例如用T
#    會將ndarray轉置，但原始資料不變
#     屬性            說明
#    ndim      顯示ndarray有幾維
#    shape     用tuple顯示ndarray的形狀
#    T         轉置
#    data      顯示ndarray的記憶體位置
#    dtype     顯示ndarray中元素的資料型別
#    size      顯示ndarray的總元素數量

import numpy as np
data1 = [1,2,3,4]
x1 = np.array(data1)
print('x型態為:',type(x1))
print('x維度為:',x1.ndim)
print('x記憶體位置為:',x1.data)
print('x元素型態為:',x1.dtype)
print('x形狀為:',x1.shape)
print('x元素數量為:',x1.size)
print('x內容為:',x1)
print('x轉置為:',x1.T)
print('x轉置後形狀為:',x1.T.shape)
print()
data2 = [[1,2,3,4], [5,6,7,8]]
x2 = np.array(data2)
print('x型態為:',type(x2))
print('x維度為:',np.ndim(x2))
print('x記憶體位置為:',x2.data)
print('x元素型態為:',x2.dtype)
print('x形狀為:',x2.shape)
print('x元素數量為:',x2.size)
print('x內容為:',x2)
print('x轉置為:',x2.T)
print('x轉置後形狀為:',x2.T.shape)

# %%   dtype屬性
# ◆ dtype是指陣列內資料的型態，資料型態包含帶符號整數int、不
#    帶符號整數unit、浮點數float、布林值bool等

#    資料型態        說明
#     int8     8位元帶符號整數(-128~127)
#     int16    16位元帶符號整數(-32768~32767)
#     int32*   32位元帶符號整數(-2147483648~2147483647)
#     int64    64位元帶符號整數(-9223372036854775808~9223372036854775807)

#     unit8    8位元不帶符號整數(0~255)
#     unt16    16位元不帶符號整數(0~65535)
#     uint32   32位元不帶符號整數(0~4294967295)
#     uint64   64位元不帶符號整數(0~18446744073709551615)

#     float16  16位元浮點數
#     float32  32位元浮點數
#     float64* 64位元浮點數
#     float128 128位元浮點數

#     bool    8位元，顯示True或False
# 【*代表預設】
# ◆ 若想修改NumPy中的資料型態，不能在設定NumPy時修改dtype，
#    而是要先將NumPy產出後，再使用astype()函數修改

import numpy as np
data = [0,1,2,3,4]

x1 = np.array(data)
x2 = np.array(data, dtype=float) # 不可在此修改資料型態
x3 = np.array(data, dtype=bool)

print(x1,' #',x1.dtype)
print(x2,' #',x2.dtype)
print(x3,' #',x3.dtype)

x = np.array(data, dtype=np.float32) 
print(x,' #',x.dtype)
x = np.array(data, dtype="float32") 
print(x,' #',x.dtype)
x = np.array(data, dtype=float)
# float64 -> float32
x = x.astype(np.float32)
print(x,' #',x.dtype)

# %%   建立ndarray
# ◆ np.array(物件, [選擇性參數1=值1, 選擇性參數2=值2, …])
# ◆ np.arrange([起始值], 終止值, [間隔值], [選擇性參數1=值1, …])
# ◆ np.ones(shape, [選擇性參數1=值1,…])與np.zeros(shape, [選擇性參數1=值1,…])，
#    建立元素為0或1的ndarray，資料型態預設為float64
# ◆ np.linspace(起始值, 終止值, 總數, [選擇性參數1=值1,…])
#    (包頭包尾)

# %%   建立一維ndarray
# np.array()    list[1,2,3,4,5] -> ndarray
print(np.array([1,2,3,4]))
# np.arange()  1~5 ndarray
print(np.arange(1,6))
# np.arrange()  1~11 間隔 2 ndarray
print(np.arange(1,12,2))
# np.ones()     5個1 ndarray
print(np.ones(5))
# np.zeros()    5個0 ndarray
print(np.zeros(5))
# np.linspace() 1~30用10個數字均分 ndarray
print(np.linspace(1,30,10))

# %%   建立二維ndarray
# ◆ 使用reshape()函式可以改變ndarray的形狀
# np.array()    list[[1,2,3],[4,5,6]] -> ndarray
print(np.array([[1,2,3],[4,5,6]]));print('-'*20)
# np.arange()  10~15 2row 3col ndarray
print(np.arange(10,16).reshape(2,3));print('-'*20)
# np.arange()  1~11 間隔 2 2row 3col ndarray
print(np.arange(1,12,2).reshape(2,3));print('-'*20)
# np.ones()     6個1 3row 2col ndarray
print(np.ones(6).reshape(3,2));print('-'*20)
# np.zeros()    6個0 3row 2col ndarray
print(np.zeros(6).reshape(3,2));print('-'*20)
# np.linspace() 1~30用10個數字均分 2row 5col ndarray
print(np.linspace(1, 30, 10).reshape(2,5))

# %%   NumPy的索引
# 【起始:終止:間隔，不寫代表全部】
a = np.arange(36).reshape(6,6)
# [[ 0  1  2  3  4  5]
#  [ 6  7  8  9 10 11]
#  [12 13 14 15 16 17]
#  [18 19 20 21 22 23]
#  [24 25 26 27 28 29]
#  [30 31 32 33 34 35]]
# row 0 col 3~4
print(a[0,3:5])
# row 4~end col 4~end
print(a[4:,4:])
# row all col 2
print(a[:,2])
# row 2~end 間隔2 col all 間隔2
print(a[2::2,::2])

# %%   NumPy的索引
# ◆ 可以用多個陣列來指定要取的值
# ◆ 若想將特定列與特定欄交叉點位置的元素取出時，
#    可使用np.ix_函式
x = np.arange(20).reshape(4,5)
# print(x)
# [[ 0  1  2  3  4]
#  [ 5  6  7  8  9]
#  [10 11 12 13 14]
#  [15 16 17 18 19]]
print(x[1:3,2:4])   # [[7,8],[12,13]]
print(x[[0,1,2],[0,2,2]])  # [ 0 7 12 ] 【x[[r1,r2,r3],[c1,c2,c3]]】
print(x[np.ix_([1,3],[2,4])])  # [[ 7 9 ],[ 17 19 ]] 【[[r1c1 r1c2],[r2c1 r2c2]]】

# %%   NumPy的切片  (list也適用)
# ◆ 切片(slicing)就是從ndarray切出一個片段，語法為：
#      np[起始值:終止值]
#      np[起始值:終止值:間隔值]
# Numpy
x = np.arange(1,11)
# [1 2 3 4 5 6 7 8 9 10]
print(x[4:7])
print(x[1:8:2])
print(x[::-1])
print(x[:2])
print(x[:])

# list
x =  [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
print(x[4:7])
print(x[1:8:2])
print(x[::-1])
print(x[:2])
print(x[:])

# 【切片後修改值，list不改變原始值，但Numpy會跟著改變原始值(所以最好先複製一份)】
z = [0,1,2,3,4,5]
z = list(range(6))
z = [i for i in range(6)]
print(z)

x = [list(range(0,6)), list(range(6,12))]
print(x)
# [[0, 1, 2, 3, 4, 5], [6, 7, 8, 9, 10, 11]]
print(x)
y = x[1][2:]
print(y)     # [8, 9, 10, 11]
y[2] = 100
print(y)     # [8, 9, 100, 11]
print(x)
# [[0, 1, 2, 3, 4, 5], [6, 7, 8, 9, 10, 11]]
print('list 原始陣列不改變')

x = np.arange(12).reshape(3,4)
print(x)
# [[ 0  1  2  3]
#  [ 4  5  6  7]
#  [ 8  9 10 11]]
y = x[2][1:]
print(y)     # [9 10 11]
y[1] = 350
print(y)     # [9 350 11]
print(x)
# [[ 0  1  2  3]
#  [ 4  5  6  7]
#  [ 8  9 350 11]]
print('ndarray 原始陣列將被改變')

# %%   深拷貝 (不改變原始陣列值)
# import copy
# y = copy.deepcopy(x)[2][1:]
y = x.copy()[2][1:]
# y = np.array([i for i in x])[2][1:]
print(y)
y[1] = 666
print(y)
print(x)

# %% 深複製 & 淺複製
x = np.arange(1,13).reshape(3,4)
y = x            # 淺複製
z = x.copy()     # 深複製

# 【注意記憶體位置每次都不相同(會重新賦予)】

# 主要陣列的記憶體位置都一樣
print(x.data)
print(y.data)
print(z.data)

# 運用 id() 查找元件
print(id(x[1,1]))
print(id(y[1,1]))
print(id(z[1,1]))


# 但修改元件後，只有深複製不會更著改變
x[1,1] = 100

# 判斷是否指向同一記憶體
print(x is y)
print(x is z)
# print(x in y)
# print(x in z)

# 運用 id() 查找元件
print(id(x[1,1]))
print(id(y[1,1]))
print(id(z[1,1]))

# %%   數學運算函式
# 函數 說明
# np.mean()       計算平均值
# np.average()    加權平均值
# np.var()        計算平方差
# 【np.var()        計算均方差，np.std()的平方=np.var()
# np.std()        計算標準差
# np.max()        計算最大值
# np.min()        計算最小值
# np.sum()        計算總和
# np.median()     計算中位數
# np.corrcoef() 計算相關係數
x = np.random.randint(1,51,10)
print(x)
print('總合為:',x.sum())
print('最大值為:',x.max())
print('最小值為:',x.min())
print('平均值為:',x.mean())
print('平均值為:',np.average(x))
print('中位數為:',np.median(x))
print('標準差為:',x.std())
print('均方差為:',x.var())
print('相關係數為:',np.corrcoef(x))

# %%   NumPy的排序
# ◆ np.sort()與np.argsort()可以將陣列中的元素由小到大排序
# ◆ np.sort()是傳回排序後的陣列元素 (遞增)
# ◆ np.argsort()是傳回排序後陣列元素的"索引值"
x = np.random.randint(1,11,10)
print(x)
print(np.sort(x))
print(np.argsort(x))
print(np.sort(x)[::-1])
print(np.argsort(x)[::-1])
x.sort()
print(x)
print(np.argsort(x))
print('-'*30)
x = np.random.randint(1,11,10).reshape(2,5)
print(x)
print(np.sort(x))          # row 排序
print(np.argsort(x))
print(np.sort(x,axis=0))   # col 排序 
print(np.argsort(x,axis=0))

# %%   NumPy的random模組
# ◆ Python函式庫中有random模組可以產生亂數， 
#    NumPy中也有同名的random模組
# ◆ np.random.randint()：產生整數亂數
# ◆ np.random.rand()：從0到1(不含1)的範圍內產生浮點數亂數
# ◆ np.random.randn()：從-3到3(不含3)的範圍內產生浮點數亂數

print(np.random.randint(10)) # 0~9 產生1個整數
print(np.random.randint(1,11)) # 1~10 產生1個整數
print(np.random.randint(1,11,10)) # 1~10 產生10個整數
# 出現機率幾乎一致
print(np.random.rand()) # 0~1(不含1) 產生1個浮點數
print(np.random.rand(5)) # 0~1(不含1) 產生5個浮點數
print(np.random.rand(1,1,2)) # [[[rand1 rand2]]]
print(np.random.rand()*10) # 0~10(不含10) 產生1個浮點數
print(np.random.rand()*10+5) # 5~15(不含15) 產生1個浮點數
# 出現機率為常態分佈
print(np.random.randn()) # -3~3(不含3) 產生1個浮點數
print(np.random.randn(5)) # -3~3(不含3) 產生5個浮點數
print(np.random.randn(1,1,2)) # [[[rand1 rand2]]]
print(np.random.randn()*10) # -30~30(不含30) 產生1個浮點數
print(np.random.randn()*10+5) # -25~35(不含35) 產生1個浮點數
