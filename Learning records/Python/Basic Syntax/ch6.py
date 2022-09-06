# 容器型態 (非陣列!!!)
# 可存放不同資料型態 (與陣列不同)
# 容器中的資料稱為元素

# 容器型態  list(串列)  tuple(數組)  set(集合)  dict(字典)
# 前後符號      []          ()          {}        {}
# 有無順序      有          有          無        無
# 內容更動      可         不可         可        可

# %% 串列 (list) [a,b,c,...]
# "有序"，"可改變"內容，索引取值
x=list()
print(x)
x=list([1,2,3])  # 似轉換型態
print(x)
x=[]
print(x)
x=[1,2,3]
print(x)
# 可存放不同資料型態
x=x+['xyz']
x=x+[False]
print(x)
print(type(x))
print(x[0])
print(x[3])
del x[2]
print(x)
# 任意物件的串列
a=[3,6,9]
b=[2,5,8.5,'Hello']
c=[]
d=[16,[a,b]]
print(d)
e=a+b
print(e)
# 串列的操作
print(b)
b[0]=42
print(b)
print(a[1])
print(b[1:3])
print(d[1][0][1])
# %% 串列 (list) [a,b,c,...]
# 相關運算子
# 串列的連接運算子 +
print([1,2,3]+[4,5,6])
print([1,2,3]+['A','B','C'])
print([1,2,3]+['A',True,2.5,0])
# 串列的重複運算子 *
print([1,2,3]*3)
print([1,2,3]+['A',True,2.5,0]*3)
# 串列的比較運算子 
print([1,3.5,'x']==[1,3.5,'X'])
print([1,3.5,'x']==[3.5,'x',1])
print([1,2,3]==[3,2,1])
# 串列的 in/not in 運算子
print(3 in [1,2,3,4,5])
print('Y' in ['XYZ','ABC'])
print('XYZ' in ['XYZ','ABC'])
# 串列的(+/-)索引運算子 
x=[5,10,15,20,25,30,35,40,45,50]
print(x[0])
print(x[len(x)-1])
print(x[len(x)-5]) # 倒數第 5 個
print(x[-5])       # 倒數第 5 個
# 串列的片段運算子 
print(x[1:5])      # 到 5 的 前一個 4
print(x[2:-2])     # 到 -2 的 前一個 -3

# %% 串列 (list) [a,b,c,...]
# 串列的建構 (生成、理解、解析)
# 有一定規則(律)，利用迴圈生成
x=[i for i in range(10)] # 0~9 
print(x)
x=[j+3 for j in range(10)] #0+3~9+3
print(x)
# 適用於串列的 python 內建相關函數
print(len(x))
print(max(x))
print(min(x))
print(sum(x))
# 串列的容器內建相關函數
x=[1,3,5,7,9]
y=[2,5,8,11,14]
x.append(11)     # 似 + (元素/容器) --> 元素
print(x)
x.append([12,13])
print(x)
x.extend(y)     # 似 + (容器) --> 串接
print(x)
print(x.count(11))
print(x.count(12))
print(x.index(11))   # 第一個 11 的索引位置
x.insert(6, 88)
print(x)
print(x.pop())   # 預設最後一個
print(x.pop(2))  # 索引值 5
x.remove(5)      # 只移除一個 5
print(x)
y=[1,2,3,4,5]
y.reverse()
print(y)
y.sort() # 像 x 巢狀陣列不可用
print(y)
y.sort(reverse=True)
y=sorted(y)              # 唯一?保留原串列
print(sorted(y,reverse=True))
print(sorted(y))
# 拆解串列中的元素 (*b: 剩下其他的賦予給 b)
a,b,c=[1,2,3]
print(a,b,c)
a,*b=[1,2,3,4,5]
print(a,b)
a,*b,c=[1,2,3,4,5]
print(a,b,c)

# %% 數組 (tuple) (a,b,c,...) [唯一不可更新內容的容器]
# "有序"，"不可改變"內容，索引取值
# 【與串列(list)只差在不可改變內容】
# 數組的連接運算子 +
# 數組的重複運算子 *
# 數組的比較運算子 
# 數組的 in/not in 運算子
# 數組的(+/-)索引運算子 
# 數組的片段運算子 
# 適用於數組的內建相關函數
# (len(), max(), min(), sum(), count(), ...)
# 【不支援更改內容】
x=(1,3,5)
print(x)
x=tuple([1,3,5])   # 似轉換型態
print(x)
a=(3,5,2,6)
b=()
c=(2,[4,6],(10,11,12)) # 元素可有 list & tuple
print(c)
c[1][0]=88  # tuple 中的 list 可更改
print(c)
d=a[1]
print(d)
e=a[1:3]
print(e)
f=c[1][1]
print(f)
# 拆解數組中的元素
x=(3,False,'XYZ')
print(x)
a,b,c=x
print(a)
print(b)
print(c)
a,*b=(1,3,5,7,9)  #  (*b: 剩下其他的賦予給 b，並為 list 型態)
print(a,b)
*a,b=(1,3,5,7,9)
print(a,b)
a,*b,c=(1,3,5,7,9)
print(a,b,c)
a,*b,c,d=(1,3,5,7,9)
print(a,b,c,d)

# %% 集合 (set) {a,b,c,...}
# "無序"，"不可重複(輸入可)"，"可改變"內容
# 建立"空集合"不可使用 x={}(視為dict)，要使用 set()
x=set()  # x={} (X)
print(x)
x.add(3)
print(x)
x.add('ABC')
print(x)
x.add(True)
print(x)
# 【支援 !=/== 比較運算子，以及 in/not in 運算子】
print(3 in x)
x={'a','b',1,2}
y={1,2,'a','b'}
print(x==y) # 無序
print(x)
print(y)
x={1,1,2,2,2,2,3,3,5,5,6,6,6}
y={6,3,1,5,2,2,2,2}
print(x==y) # 不可重複
print(x)
print(y)
# 數組的 in/not in 運算子
# 【不支援與順序(索引)相關 (+,*,[],[start:end])】
x={1,2,3,4,5}
y={3,4,5,6,7}
print(x-y) # 差集 保留 x 剩下
print(y-x) # 差集 保留 y 剩下
# 適用於數組的內建相關函數
# (len(), max(), min(), sum(), ...)
x={1,5,3,7,9,5,9,7,3}
print(len(x)) # 1,3,5,7,9
print(max(x))
print(min(x))
print(sum(x))# 1+3+5+7+9

# %% 字典 (dictionary, dict) {'a':1,'b':2,'c':3,...}
# "無序"，"不可重複"，"可改變"內容的多個(鍵(key):值(value pair))的對應方式
# 以 key 做為索引來取字典中的值
# 資料型態： key 不可變(數字、字串...)， value 無限制

a={'one':1,'two':2,'three':3}
b=dict({'three':3,'one':1,'two':2})
c=dict(one=1,two=2,three=3)           # 常使用 (V)
d=dict([('two',2),('one',1),('three',3)])
print(a==b==c==d)
print(a,b,c,d,sep='\n')   # 輸出以原輸入順序輸出，判別則還是依無序的規則判斷
# 取得，新增，變更，刪除
x={}
print(x)
print(type(x))
x['1']=10                       # 新增
x['2']=20
x['3']=30
print(x)
del a['one']                    # 刪除
print(a)
a={'one':1,'two':2,'three':3}
x=a['one']                      # 取得
print(x)
a['two']=200                    # 變更
print(a)
# 【支援 !=/== 比較運算子，以及 in/not in 運算子】
a={'a':1,'b':2,'c':3}
b={'a':7,'b':2,'c':9}
print(a['a']==b['a']) # 比較對應的 value
print(a['b']==b['b'])
print(a['c']!=b['c'])
print(1 in a)
print('a' in a) # 查找包含的 key  
a={1:123,2:223,3:333}
print(a)
print(1 in a)
print(a[1])

# 【不支援與順序(索引)相關 (+,*,[],[start:end])】
x={'x':13,'y':456,'z':789}
print(x)
print(x.keys())
print(x.values())
print(x.items())

# %%
x={'A':567,'B':789}
y={'B':789,'A':567}
print(x==y)
print(x)
print(y)
x={'A':567,'B':101}
y={'B':789,'A':567}
print(x==y)
print(x)
print(y)
x={'A':567,'B':789,'B':789}
y={'B':789,'A':567}
print(x==y)
print(x)
print(y)
x={'A':567,'B':789,'B':101}  # 後更新前，警告
y={'B':789,'A':567}
print(x==y)
print(x)
print(y)

# %%
a=[1,2,3]
b=(1,2,3)
c={1,2,3}
print(a==b)
print(a==c)
print(c==b)
