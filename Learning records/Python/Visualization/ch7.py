# Pandas套件

# %%   Pandas介紹
# ◆ Pandas是用來創建和操作結構化資料的開源函式庫
# ◆ Pandas結和了NumPy的特性和關連式資料庫(SQL)的資料操作
#    能力，可以用來對資料進行重整、切割、合併、篩選等操作
# ◆ Pandas在各種學術和商業領域都有應用，例如金融、經濟學、
#    統計學、網路分析等等

# %%   Pandas資料類型
# ◆ Pandas提供了三種資料類型： Panel、 DataFrame、 Series
#     ◆ Series：儲存一維資料
#     ◆ DataFrame：儲存二維資料
#     ◆ Panel：儲存三維以上資料
# ◆ 平常資料分析最常用到是Series和DataFrame
import pandas as pd
import pandas as np # 不要有中文之數學運算

score = [["小智","小雪","小剛"],
         [95,96,98],
         [88,85,84],
         [90,84,88]]

data1 = np.array(score)
data2 = pd.DataFrame(score)
print(type(data1))
print(type(data2))

# data3 = pd.DataFrame(score,index=["姓名","國文","英文","數學"],columns=["小智","小雪","小剛"])
data3 = pd.DataFrame(score[1:],index=["國文","英文","數學"],columns=["小智","小雪","小剛"])
print(data2.index)
print(data3.index)
print(data2.columns)
print(data3.columns)

# %%   Series資料結構
# ◆ Series本質上是一個含有索引的一維陣列，其包含可自動產生
#    (也可手動指定)的index和values
# ◆ 可以使用s.index、 s.values檢視內容
#     ◆ index傳回一個index物件
#     ◆ values傳回一個array
import pandas as pd
# 系統自訂 index
data1 = pd.Series([1,2,3,4])
# 手動設定 index
data2 = pd.Series([1,2,3,4], index=["A","B","C","D"])
# 查詢 index 內容
print(data1.index)
print(data2.index)
# 查詢 value 內容
print(data1.values)
print(data2.values)

# %%   DataFrame資料結構
# ◆ DataFrame類似excel試算表，為二維陣列，有欄(col)、列(row)和values
#    (多個一維 Series 合併)
import pandas as pd
score = {"姓名":["小智","小雪","小剛"],
         "國文":[95,96,98],
         "英文":[88,85,84],
         "數學":[90,84,88]}
# dict -> DataFrame (系統自訂 index)
data1 = pd.DataFrame(score)
# dict -> DataFrame (手動設定 index)
data2 = pd.DataFrame(score,index=["A","B","C"])
print(data1);print('-'*20)
print(data2);print('-'*20)
# 查詢列名(index)
print(data1.index)
print(data2.index)
# 查詢欄名(columns)
print(data1.columns)
print(data2.columns)
# 查詢內容(values)
print(data1.values)
print(data2.values)

# %%    list、 tuple、 dict、 array 轉 series、 DataFrame
# DataFrame 也可以 一維 (但型態還是DataFrame)
import numpy as np
import pandas as pd
data_list = [1,2,3,4,5]
data_tuple = (3.1,5,10,24.7)
data_dict = {"姓名":["小智","小雪","小剛"],
             "國文":[95,96,98],
             "英文":[88,85,84],
             "數學":[90,84,88]}
data_array = np.arange(33,37)

data1 = pd.Series(data_list)
data2 = pd.DataFrame(data_list)

data3 = pd.Series(data_tuple)
data4 = pd.DataFrame(data_tuple)

data5 = pd.Series(data_dict)
data6 = pd.DataFrame(data_dict)

data7 = pd.Series(data_array)
data8 = pd.DataFrame(data_array)

# %%    從外部讀取資料
# ◆ 讀取csv資料： pd.read_csv(檔名)
# ◆ 讀取excel資料： pd.read_excel(檔名)
# ◆ 讀取json資料： pd.read_json(檔名)
# ◆ 讀取sql資料： pd.read_sql()
# ◆ 讀取html資料： pd.read_html()
import pandas as pd
# 讀取csv資料：
data_csv = pd.read_csv(r"D:\Desktop\機器與深度學習課程\PYTHON-DATA\Exercise\exercise1\Banqiao.csv")
# 讀取excel資料：
data_excel = pd.read_excel(r"D:\Desktop\機器與深度學習課程\PYTHON-DATA\Exercise\exercise1\Banqiao.xlsx")
# 讀取json資料：
data_json = pd.read_json(r"D:\Desktop\機器與深度學習課程\PYTHON-DATA\Exercise\exercise2\youbike_immediate.json")

# %%   DataFrame概觀
# ◆ 可以使用以下屬性來查看DataFrame概觀
#     ◆ ndim：幾維
#     ◆ shape：顯示列與欄的各數(先列再欄)
#     ◆ dtypes：顯示各欄資料的類型
# ◆ 當資料很多時將無法看到完整DataFrame全貌，此時可以使用
#    hear()或tail()函式查看最前面或最後指定筆數資料
#     ◆ head()：預設顯示5筆，若要設定其他筆數則輸入head(10)
#     ◆ tail()：預設顯示5筆， 若要設定其他筆數則輸入tail(10)
import pandas as pd
data = pd.read_csv(r"D:\Desktop\機器與深度學習課程\PYTHON-DATA\Exercise\exercise1\Banqiao.csv")
# 查詢幾維
print(data.ndim)
# 查詢列與欄的各數(先列再欄)
print(data.shape)
# 查詢各欄資料的類型 
print(data.dtypes)
# 預設顯示前5筆
print(data.head())
print(data.head(2))
# 預設顯示後5筆
print(data.tail())
print(data.tail(2))
# 【最開頭顯示索引(欄 & 列)】
# 【欄位無法用預設索引，難顯示多少到多少欄位輸出】

# %%   DataFrame資料的選取
# ◆ 若要選擇指定欄位的資料，可以使用df[欄名]或df[欄名][索引]方法
import pandas as pd
# data = pd.read_csv(r"D:\Desktop\機器與深度學習課程\PYTHON-DATA\Exercise\exercise1\Banqiao.csv")
score = {"姓名":["小智","小雪","小剛"],
         "國文":[95,96,98],
         "英文":[88,85,84],
         "數學":[90,84,88]}
data = pd.DataFrame(score)
print(data.index)
print(data.columns)
print(data["姓名"])
print(data["姓名"][:])
print(data[['姓名', '英文']]) # 注意試兩個中括弧
print(data[['姓名', '英文']][1:3])
print(data.columns[:2])
print(data[data.columns[:2]][:1])
# 以上為先col(欄名)再row(列名)的方式擷取資料

# %%   進階資料選取 – loc索引
# ◆ loc是以先row(列名)再col(欄名)的方式擷取資料
# 【包頭也包尾】 ********************
print(data.loc[:])
print(data.loc[:,"姓名"])
print(data.loc[:,"姓名":'英文'])
print(data.loc[0:2:2,"姓名":'數學'])
print(data.loc[1,"數學"])

# %%   進階資料選取 – iloc索引
# ◆ iloc是以先row(列索引)再col(欄索引)的方式擷取資料，索引皆從0開始
# ◆ 若列或欄標籤的名稱過長不好記時，用iloc就很方便
# 【包頭也不包尾】
print(data.iloc[1,:])
print(data.iloc[:,0:2])
print(data.iloc[0:3:2,1:4:2])
print(data.iloc[2,2])

# %%   新增欄位
# ◆ 若想要新增欄位，可以使用df.insert(x, column=y, value=z)函數
#     ◆ x：要新增的欄位索引位置
#     ◆ y：要新增的欄名
#     ◆ z：要新增的值
import pandas as pd
data = pd.DataFrame({'A':[7,4,9],"B":["apple","google","amazon"]})
print('-'*5,"Original",'-'*5)
print(data)
data.insert(1, column="D", value=0) # 注意順序欄位，先給預設初始值
print('-'*5,"  New  ",'-'*5)
print(data)
data.insert(3, column="G", value=[2,4,6]) # 注意順序欄位
print('-'*5,"  New  ",'-'*5)
print(data)
data["E"]=1   # 新增欄
print('-'*5,"  New  ",'-'*5)
print(data)
data.loc[3]=0   # 新增列
print('-'*5,"  New  ",'-'*5)
print(data)
# data1 = pd.DataFrame([8,0,"banana",8])
# data = pd.concat([data,pd.DataFrame(index=3)],axis=0)
# data.iloc[3] = [8,0,"banana",5]
# print('-'*5,"  New  ",'-'*5)
# print(data)

# %%   刪除欄位
# ◆ 若想刪除指定欄或列，可以使用drop()函數，指定參數axis=0表示要
#    刪除列(row)，指定參數axis=1表示要刪除欄(col)
#     ◆ 刪除欄： drop(欄名, axis=1)
#     ◆ 刪除列： drop(列索引, axis=0)
import pandas as pd
data = pd.DataFrame({'A':[7,4,9],"B":["apple","google","amazon"],"C":[150,240,121]})
print('-'*5,"Original",'-'*5)
print(data)
print('-'*5,"Del row C",'-'*5)
print(data.drop("C",axis=1))
print('-'*5,"Del col 1",'-'*5)
print(data.drop(1,axis=0))

# %%   資料合併
# ◆ 若想將多個series或DataFrame合併，可以使用pd.concat()函數
# ◆ 其中axis表示以列(axis=0)或欄(axis=1)方向合併，預設為axis=0
# ◆ 合併時若有遺漏值，將會以nan代替不存在的值  
# 【以列的方式合併】
import pandas as pd
data1 = pd.DataFrame({'A':[7,4,9],"B":["apple","google","amazon"]})
data2 = pd.DataFrame({"C":[100,54]})
print(pd.concat([data1,data2]))
print(pd.concat([data1,data2],axis=1)) # 新增列(但是是往下增加)
data3 = pd.DataFrame({"C":[100,54,88]})
print(pd.concat([data1,data3]))
print(pd.concat([data1,data3],axis=1)) # 新增欄位
data3 = pd.DataFrame({"A":[100],"B":[54]})
print(pd.concat([data1,data3]))        # 新增列位
print(pd.concat([data1,data3],axis=1)) # 新增列(但是是往右增加)

# %%   刪除空資料
# ◆ 在資料合併時可能會產生遺漏值(nan)，若不想要這些遺漏值可
#    以使用dropna()函數刪除
data = pd.concat([data1,data2],axis=1)
print('-'*5,"Original",'-'*5)
print(data)
print('-'*5,"Del nan",'-'*5)
print(data.dropna())
# 刪掉整列，其中出現一 nan 值
print('-'*5,"Del nan",'-'*5)
print(data.dropna(axis=1))
# 刪掉整欄，其中出現一 nan 值

# %%   修改空資料
# ◆ 刪除空資料會導致不該刪的資料也一併刪除，這並非我們所想
#    要的，故可以使用fillna(x)函數，將遺漏值更改為其他資料
#     ◆ x：要取代的新值
print('-'*5,"Replace nan",'-'*5)
print(data.fillna(-999))


# %%   資料排序
# ◆ 若想要讓資料能有順序的排序，可以使用sort_values()函數
# ◆ 預設為遞增排序，若想要遞減則可使用ascending=False參數
import pandas as pd
data = pd.read_csv(r"D:\Desktop\機器與深度學習課程\PYTHON-DATA\Exercise\exercise1\Banqiao.csv")
print(data.columns)
print('-'*5,"Original",'-'*5)
print(data[["Name","twd97X"]].head())
# print(data["twd97X"].head())
# print(data.head())
print('-'*5,"Sort twd97X (UP)",'-'*5)
print(data[["Name","twd97X"]].sort_values("twd97X").head())
# print('-'*5,"Sort twd97X",'-'*5)
# print(data["twd97X"].sort_values().head())
# print(data.sort_values("twd97X").head())
print('-'*5,"Sort twd97X (DOWN)",'-'*5)
print(data[["Name","twd97X"]].sort_values("twd97X",ascending=False).head())
# print(data["twd97X"].sort_values(ascending=False).head()) # 非上升
# print(data.sort_values("twd97X",ascending=False).head())

# %%   資料分組
# ◆ groupby()函式可將資料依指定欄位進行分組，類似excel的篩選功能
#     data ---> data.groupby(“company”) ---> group
import pandas as pd
data = pd.read_csv(r"D:\Desktop\機器與深度學習課程\PYTHON-DATA\Exercise\exercise1\drugstore.csv")
data = data.iloc[:,:3]
print('-'*5,"Original",'-'*5)
print(data)
data_group = data.groupby("District")
print('-'*5,"Banqiao",'-'*5)
print(data_group.get_group("板橋區").head())
print('-'*5,"Tamsui",'-'*5)
print(data_group.get_group("淡水區").head())

# %%   資料分組後的聚合運算
# ◆ 聚合運算可以用來計算總和、平均值、最大值、最小值…等
import pandas as pd
import numpy as np
data = pd.read_csv(r"./company.csv")
data_group = data.groupby("company")
print('-'*5,"Original",'-'*5)
print(data)
print('-'*5,"  Min  ",'-'*5) # 每組每欄的最小值
print(data_group.min())
print('-'*5,"  Max  ",'-'*5) # 每組每欄的最大值
print(data_group.max())
print('-'*5,"  Sum  ",'-'*5) # 每組每欄的總和
print(data_group.sum())
print('-'*5,"  Mean  ",'-'*5) # 每組每欄的平均值
print(data_group.mean())
# 會自動忽略 nan 值運算
data.loc[8]=["A",np.nan,np.nan]  
data_group = data.groupby("company")
print('-'*5,"Original",'-'*5)
print(data)
print('-'*5,"  Sum  ",'-'*5) 
print(data_group.sum())
print('-'*5,"  Mean  ",'-'*5) 
print(data_group.mean())

# %% missing value by ndarray & list
import numpy as np

a = np.arange(1,6)
print(a)
print(np.sum(a))

a = [1,2,3,4,5,np.nan]
print(a)
print(sum(a))       # python

import math
a = [1,2,3,4,5,math.nan]
print(a)
print(sum(a))       # python

a = np.array(a)
print(a)
print(np.sum(a))   # Numpy
print(np.nansum(a))   

# %%   資料遮罩
# ◆ 除了使用分組可以達到篩選的功用外，遮罩(mask)也能用於資料篩選
# ◆ 遮罩除了可以使用運算元運算，也可以使用between()函式找出指定範圍的值
import pandas as pd
data = pd.read_csv(r"D:\Desktop\機器與深度學習課程\PYTHON-DATA\Exercise\exercise1\drugstore.csv")
mask = (data["District"] == "板橋區") & (data["Name"] == "谷全藥局")  # T / F (Series)
print(data[mask])

# print([data["Name_Per"][i][0] for i in range(len(data["Name_Per"]))])
# d = pd.Series([data["Name_Per"][i][0] for i in range(len(data["Name_Per"]))])
# mask = ( d == "林")  # T / F (Series)
mask = (data["Name_Per"].str.get(0) == "林")
print(data[mask].loc[:,"District":"Name_Per"])

mask = data["District"] == "板橋區"  # T / F (Series)
print(data[mask])
# X>300000
mask1 = data["twd97X"] > 300000
print(data[mask1].head())
# 300000 <= x <= 310000
mask2 = data["twd97X"].between(300000,310000) # 用判斷式寫會錯誤 30000 <= x <=31000
print(data[mask2].head())

# %% Pandas 要寫檔案 
# 還是要用 with open(hp,"w") as file:

# %% 深複製 & 淺複製 (ndarray same as DataFrame)
x = np.arange(1,13).reshape(3,4)
x = pd.DataFrame(x)
y = x            # 淺複製
z = x.copy()     # 深複製
print(x)

# 但修改元件後，只有深複製不會更著改變
x[1][1] = 100

print(x)
print(y)
print(z)

# 判斷是否指向同一記憶體
print(x is y)
print(x is z)
