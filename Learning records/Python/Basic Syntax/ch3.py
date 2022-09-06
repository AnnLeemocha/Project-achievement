a= eval(input(":"))
print(a)

# %% 函數
# 函數名稱一樣，括號中的各數一樣，即可呼叫
# 定義函數
def sayhello():    # a
    print('hello')
# 呼叫函數
sayhello()         # 1,'1',False,3>2 (不行 x=30)

# 定義函數
def CtoF(degreeC):
    degreeF=degreeC*1.8+32
    print('攝氏',degreeC,'度可轉換成華氏',degreeF,'度')
    return
# 呼叫函數
CtoF(50)

# %%  參數(Parameter)與引數(Argument)
# 參數(Parameter) : 函數運行時之參考
# 引數(Argument) : 用以引發函數
# 定義函數
def teaTime(dessert,drink='紅茶'):   
    print('我的甜點：',dessert,'\n    飲料：',drink,sep='')
# 呼叫函數
# 函數執行時，將引數內容賦予給參數 (位置對位置)
teaTime('馬卡龍','咖啡')
# 預設引數值，有預設值的放後面
teaTime('帕尼尼')
# 呼叫時更改，引數想更改位置輸入，加上參數名稱   
# 參數名稱 = 引數 (最好全用這種方式寫)
teaTime(drink='奶茶',dessert='三明治')
# 錯誤不好的寫法
teaTime('紅豆餅',drink='綠茶') # 反過來寫即錯誤
# teaTime(drink='綠茶','紅豆餅') <--- (X)

# %%  變數的有效範圍
# 名稱賦予值即可為變數，並建立起自己的作用範圍 (Scope)
# 讀取變數時，會就目前範圍檢查是否有變數內容(有就使用)，
# 如果沒有則會向外尋找，但無法向內
x=100
def test():
    print(x) # 向外尋找
test()

def test():
    x=200
    print(x) # 向外尋找
test()
print(x) # 無法向內尋找

# 每個變數有其有效範圍，也就是被認定(認識)的範圍
#     全域變數：定義在函數外，範圍是整個模組
#     區域變數：定義在函數內，範圍是整個函數
# 當痊癒與區域變數名稱相同，產生衝突時，
# 函數內以區域為主，函數外以全域為主

# def test():
#     y=100
# test()
# print(y)  # name 'y' is not defined

# %% 函數的回傳值 return
# return : 無條件直接離開(結束)函數，也可回傳某個或某些值(可忽略不回傳)
# 未使用 return 與 return 不回傳值，接回傳 None (預設)
def test():
    print('test')
x=test()           # 預設回傳 None
print(x)

def test():
    print('test 1')
    return           # 回傳 None
    print('test 2')  # 無條件直接離開(結束)函數
x=test()
print(x)

# 回傳單一值或物件
def test():
    print('test')
    return 10        # 回傳 10
x=test()
print(x)

# 回傳多個值或物件所構成的容器型態
def cal(x,y):
    div = x//y
    mod = x%y
    return div,mod        # 回傳 div,mod
a=cal(120,7)
print(a)
a,b=cal(120,7)
print('120 除以 7 的商數為',a,'，餘數為',b)
a,b=cal(250,15)
print('250 除以 15 的商數為',a,'，餘數為',b)