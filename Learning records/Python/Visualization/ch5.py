# JSON檔案讀取  (Data Processing JSON)


# %%  JSON是什麼？
# ◆ JSON的全名是JavaScript Object Notation，是一種使用結構化
#    方式呈現JavaScript物件的格式
# ◆ JSON最初是為了web應用而開發，不過目前JavaScript、 JAVA、C
#    #使用JSON的情況較多， PHP主要還是使用XML
# ◆ C、 C++、 JAVA、 Python…等都支援JSON

# %%  JSON檔案
# ◆ JSON由「 key(鍵)」和「 value(值)」組成，資料型態不限(字串、
#    整數、浮點數、布林、陣列…等)
# ◆ JSON不受換行符號限制，只要資料最外層有大括號包圍即可
# ◆ 若有多筆資料時，以逗號做區隔
# ◆ JSON檔案沒有註解

# %%  JSON結構
# ◆ JSON主要有兩種資料結構：
#   ◆ JSON物件(object)
#   ◆ 用大括號{ }表示
#   ◆ 大括號內的對象是沒有順序的key:value集合
#   ◆ 每個對象以逗號做區隔
# ◆ JSON陣列(array)
#   ◆用中括號[ ]表示
#   ◆中括號內的對象是有順序集合
#   ◆每個對象以逗號做區隔

# %%  JSON物件
# ◆ JSON物件是以「 key:value」方式儲存
# ◆ 所有資料的最外層由大括號{ }所包覆
# ◆ 和python的dict不一樣的是， "JSON的key一定是字串，且是雙引號"；
#    value可以是字串、數值、布林、陣列、物件或null值  

# %%  JSON陣列
# ◆ JSON陣列是由一系列的value所組成
# ◆ 所有資料的最外層由中括號[ ] 所包覆
# ◆ 陣列的值可以是字串、數值、布林、陣列或null值

# %%  JSON常用方法
#  方法                          說明
# load()  針對JSON檔案的操作，使用load()方法讀取檔案做成物件，並回傳成dict型態
# loads() 針對JSON字串的操作，讀取JSON檔案後做成字串，並回傳成dict型態
# dump()  針對JSON檔案的操作，使用dump()方法將dict型態資料寫成JSON檔案
# dumps() 針對JSON字串的操作，將dict型態資料寫成JSON格式的檔案

import json
fp = "test.json"
with open(fp) as file:
    data = json.load(file)
print(data)

# %%   JSON物件讀取 – load()
# ◆ 使用 load() 函數所讀出的JSON檔案格式為dict
import json
# 注意是為有無中文之 JSON 檔 (encoding=)
fp = 'object.json'
with open(fp,encoding="utf-8") as file:
    data = json.load(file)
# print(data)
print(type(data))
# print(data)

# %%   JSON陣列讀取 – load()
# ◆ 使用load()函數所讀出的JSON檔案格式為list
import json
fp = 'array.json'
with open(fp,encoding="utf-8") as file:
    data = json.load(file)
# print(data)
print(type(data))

# %%  JSON物件讀取 – loads()
# ◆ 和load()不同之處在於，要使用loads()前需要先用read()函式讀
#    取JSON檔案，讀出後的格式為字串，然後再用loads()將字串轉成dict
import json
fp = 'object.json'
with open(fp,encoding="utf-8") as file:
    data = file.read() # str
# str -> dict
print(type(data))
data = json.loads(data)
print(type(data))

# %%  JSON陣列讀取 – loads()
# ◆ 先用read()讀檔並得到字串型態資料，再用loads()將字串轉成list
import json
fp = 'array.json'
with open(fp,encoding="utf-8") as file:
    data = file.read()
print(type(data))
# str -> list
data = json.loads(data)
print(type(data))

# %%   JSON物件寫入 – dump()
# ◆ dump()：將 dict型態 的資料直接寫成 JSON檔案
import json
dictObject = {'A':"apple","B":"book","C":"cat"}
fp = "write_object1.json"
with open(fp,"w") as file:
    # dict -> file
    json.dump(dictObject, file)
    
# %%   JSON物件寫入 – dumps()
# ◆ dumps()：先將 dict型態 的資料轉成 字串型態 ，再用 write() 寫入檔案
import json
dictObject = {'A':"apple","B":"book","C":"cat"}
fp = "write_object2.json"
print(type(dictObject))
# dict -> str
dictObject = json.dumps(dictObject)
print(type(dictObject))
with open(fp,"w") as file:
    # str -> file
    file.write(dictObject)

# %%   JSON陣列寫入 – dump()、 dumps()
# ◆ 寫入方式和JSON物件一樣，唯一要注意的就是編碼問題
# ◆ 若寫入的資料有中文，寫入時即便有設定編碼是utf8，但打
#    開檔案看中文字會呈現「 \uXXX」的樣子，其實這不
#    是亂碼，這是ASCII編碼，若想要排除這狀況，可以增加一
#    參數「 ensure_ascii=False」

# %%   JSON陣列寫入 – dump()
import json
dictObject = ["A","apple","B","book","C","cat","D","鴨子"]
fp = "write_array.json"
with open(fp,"w") as file:
    json.dump(dictObject, file)

fp = "write_array1.json"
with open(fp,"w") as file:
    json.dump(dictObject, file, ensure_ascii=False)

# %%   JSON陣列寫入 – dumps()
import json
dictObject = ["A","apple","B","book","C","cat","D","鴨子"]
fp = "write_array2.json"
# unicode -> 中文
print(json.dumps(dictObject))
print(json.dumps(dictObject, ensure_ascii=False))
print(type(dictObject))
# dict -> list
dictObject = json.dumps(dictObject, ensure_ascii=False)
print(type(dictObject))
with open(fp,"w") as file:
    # str -> file
    file.write(dictObject)
    
# %%  JSON和Python資料型態對照
# python 的 dict 不一樣的是：
#     JSON 的 【key 一定是字串】，且是【雙引號】

#       load()
# -------------------------
# JSON         Python
# -------------------------
# object       dict
# array        list
# string       str
# number(int)  int
# number(real) float
# true         True         *** t/T
# false        False        *** f/F
# null         None

#       dump()
# -------------------------
# Python       JSON
# -------------------------
# dict         object
# list         array
# str          string
# int          number(int)
# float        number(real)
# True         true         *** t/T
# False        false        *** f/F
# None        null
