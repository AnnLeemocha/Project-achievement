# 視覺化套件  (Matplotlib)

# 前言
# ◆ 所謂一圖抵千言，資料視覺化就是將資料以圖表的方式呈現給使用
#    者閱讀，讓使用者能快速了解資料內容

# 圖表類型
# ◆ 想要製作一份圖表，首先你要先思考以下的問題：
#     ◆ 你擁有什麼樣的資料？
#     ◆ 你想表達什麼訊息？
#     ◆ 你應該採用什麼樣的視覺化方式？
#     ◆ 你從圖表中能獲得什麼樣的資訊？

# matplotlib介紹
# ◆ matplotlib模組主要由python編寫，考慮平台相容特性部份使用
#    C、 objective-C和JavaScript編寫
# ◆ 由John D. Hunter開發
# ◆ matplotlib能繪製出2D及3D圖表，能繪製的圖表有折線圖、長條圖、
#    直方圖、圓餅圖、散佈圖、箱線圖、座標圖…等

# 使用及匯入matplotlib套件
# ◆ 使用matplotlib套件前需要先安裝，語法為：
#       import matplotlib.pyplot as plt
# ◆ matplotlib是一個很龐大的繪圖模組，使用時只要匯入其中的
#    pyplot子模組功能即可完成許多圖表，語法為：
#       pip install matplotlib
# ◆ 若想知道matplotlib的版本，可以使用 matplotlib.__version__
#    語法查詢
#       import matplotlib
#       print(matplotlib.__version__)
   
# %%    常見圖表類型
"""
函數 : (圖表類型)
     核心參數說明
     
plot() : (折線圖)
       x、 y、 color(線條顏色)、 linestyle(線條類型)、
       linewidth(線條寬度)、 marker(標記類型)、 label(標籤)

bar() : (長條圖、堆疊長條圖)
       x、 height(柱形高度)、 width(柱形寬度)、 align(柱形位置)、 
       color(柱形顏色)

barh() : (橫條圖、堆疊橫條圖)
       x、 height(柱形高度)、 width(柱形寬度)、 align(柱形位置)、 
       color(柱形顏色)

pie() : (圓餅圖) 
       colors(填充顏色)、 labels(標籤) 
scatter() : (散點圖、氣泡圖)
        x、 y、 s(散點大小)、 c(散點顏色)、 label、 marker(散點類型)
"""        

# %%   折線圖
# ◆ 使用plot()可以繪製折線圖，語法為：
#      plt.plot(*args [,選擇性參數1=值1, 選擇性參數2=值2, …])
# ◆ 若x軸的數據是0、 1、 …n時，在使用plot()時可省略x軸不寫

import matplotlib.pyplot as plt
x = list(range(9))
y = [i**2 for i in range(9)]
# 資料帶入圖表
plt.plot(x,y)
# plt.show()
# plt.plot(y)
# 顯示圖表
plt.show()
# plt.show(plt.plot(x,y))

# %%    折線圖 – 線條寬度
# ◆ 使用參數linewidth(簡寫lw)設定線條寬度
import matplotlib.pyplot as plt
import numpy as np
x = np.linspace(0, 2*np.pi,500)
y1 = np.sin(x)
y2 = np.cos(x)
# 注意順序 (誰上誰下)
plt.plot(x,y1, linewidth=3)
plt.plot(x,y2, lw=8)
plt.show()

# %%  折線圖 – 線條色彩(一)
# ◆ 若想調整線條顏色，可以在plot()內增添color參數
#       色彩字元   說明
#         “b”   blue(藍色)
#         “c”   cyan(青色)
#         “g”   green(綠色)
#         “k”   black(黑色)
#         “m”   magenta(紅色)
#         “r”   red(紅色)
#         “w”   white(白色)
#         “y”   yellow(黃色)  
plt.plot(x,y1, color="cyan")
plt.plot(x,y2, color="y")
plt.show()

# %%    折線圖 – 線條色彩(二)
# ◆ color參數也可以使用色碼或css色彩表示
plt.plot(x,y1, color="#00ffff")  # 色碼
plt.plot(x,y2, color=(255/255,0/255,0/255)) # RGB 0~255
plt.show()

# %%    折線圖 – 線條色彩(三)
# 參見官方色彩顏色說明 : 
#     List of named colors: https://matplotlib.org/stable/gallery/color/named_colors.html
#     Choosing Colormaps in Matplotlib: https://matplotlib.org/stable/tutorials/colors/colormaps.html

# fig, ax = plt.subplots()

# size = 0.3
# vals = np.array([[60., 32.], [37., 40.], [29., 10.]])

# cmap = plt.colormaps["tab20c"]
# outer_colors = cmap(np.arange(3)*4)
# inner_colors = cmap([1, 2, 5, 6, 9, 10])

# ax.pie(vals.sum(axis=1), radius=1, colors=outer_colors,
#        wedgeprops=dict(width=size, edgecolor='w'))

# ax.pie(vals.flatten(), radius=1-size, colors=inner_colors,
#        wedgeprops=dict(width=size, edgecolor='w'))

# ax.set(aspect="equal", title='Pie plot with `ax.pie`')
# plt.show()

# %%    折線圖 – 線條樣式(一)
# ◆ 使用參數linestyle或ls可以設定線條樣式
# 線條字元    說明
#   “-”    實線(預設)
#   “--”   虛線
#   “-.”   點折線
#   “.”    點線
#   “o”    圓標記
#   “,”    像素標記
#   “v”    三角形向下標記
#   “^”    三角色向上標記
#   “<“    左三角形
#   “>”    右三角色
#   “+”    加號
# 線條字元    說明
#   “1”    三叉標記向上
#   “2”    三叉標記向下
#   “3”    三叉標記向左
#   “4”    三叉標記向右
#   “s”    方形標記
#   “p”    五角標記
#   “*”    星星標記
#   “x”    叉標記
#   “D”    菱形標記
#   “d”    細菱形標記
#   “H”    六邊形標記

import matplotlib.pyplot as plt
import numpy as np

x= np.arange(0,5,0.1)
plt.plot(x,x,'b--',x,x**2,'ro',x,x**3,'g+')
plt.show()

x= np.arange(0,5)
plt.plot(x,x,'--',marker="x")
plt.plot(x,x**2,'--',marker="o")
plt.plot(x,x**3,'--',marker="^")
plt.show()

# %%  設定標題 – 中文字型
# ◆ 標題可分成圖表標題與x軸\y軸標題
# ◆ matplotlib不支援中文字型，若要使用中文字型需先設定

import matplotlib.pyplot as plt
import numpy as np

x = np.arange(-10,11)

# ONE:
plt.rcParams["font.family"] = "Microsoft JhengHei" # 微軟正黑體
plt.rcParams["font.size"] = 20
# 文字正常顯示正負號
plt.rcParams["axes.unicode_minus"] = False

plt.plot(x,x**3,'--',marker="^")
plt.title("折線圖")
plt.xlabel("X軸坐標")
plt.ylabel("Y軸坐標")
plt.show()

plt.plot(x,x**3,'--',marker="^")
plt.title("折線圖")
plt.xlabel("X軸坐標",size=15)
plt.ylabel("Y軸坐標",size=15)
plt.show()

# TWO:
import matplotlib.font_manager as fm
font_path = "C:\Windows\Fonts\msjh.ttc"
font_prop = fm.FontProperties(fname=font_path)

plt.plot(x,x**3,'--',marker="^")
plt.title("折線圖")
plt.xlabel("X軸坐標",size=15)
plt.ylabel("Y軸坐標",size=15,rotation=0)
plt.show()

plt.plot(x,x**3,'--',marker="^")
plt.title("折線圖")
plt.xlabel("X軸坐標",size=15)
plt.ylabel("Y\n軸\n坐\n標\n",size=15,rotation=0)
plt.show()

# 【避免別人沒有(TWO)這種字型，通常會在上方(ONE)預設一個大家都有的字型】

# %%    設定標題 – 可設定的參數
#   參數         說明
# fontsize   字型大小
# fontstyle  設定標題是否傾斜，參數有normal、 italic、 oblique
# loc        設定標題是center(置中)、 left(靠左)、 right(靠右)，預設為置中
# color      設定文字顏色

plt.plot(x,x**3,'--',marker="^")
plt.title("折線圖",loc="left",color="#ff00ff",fontstyle="oblique")
plt.show()

# %%    設定x軸與y軸的刻度
# ◆ axis()可以設定x軸和y軸的範圍，語法為：
#       plt.axis([xmin, xmax, ymin, ymax]) 
#    ◆ xmin是x軸最小刻度， xmax是x軸最大刻度
#    ◆ ymin是y軸最小刻度， ymax是y軸最大刻度
x = np.arange(-10,11)
plt.plot(x,x**3,'--',marker="^")
plt.axis([-10,10,-1000,1000])
plt.show()

plt.plot(x,x**3,'--',marker="^")
plt.axis([-5,5,-500,500])
plt.show()

# ◆ 使用xlim()、 ylim()分別設定x軸與y軸的範圍 
#    ◆ xlim(起始值，終止值)
#    ◆ ylim(起始值，終止值)
plt.plot(x,x**5,'--',marker="o")
plt.xlim(-10,10)
plt.ylim(-500,10000)
plt.show()

# 【間隔?】
plt.plot(x,x**5,'--',marker="o")
plt.xlim(-10,10)
plt.ylim(-500,10000)
ax = plt.gca()
ax.xaxis.set_major_locator(plt.MultipleLocator(1))
plt.show()

# ◆ 使用xticks()、 yticks()可以設定x軸與y軸的標籤
data = {"2010年":[3512,5241,1254],
        "2011年":[4000,4514,3500],
        "2012年":[5210,4514,5350]}
x =[1,2,3]
y1,y2,y3 = data["2010年"], data["2011年"], data["2012年"]
labels = list(data.keys())

plt.xticks(x,labels)
plt.plot(x,y1,'g',x,y2,'r',x,y3,'b')
plt.show()

# %%    圖例
# ◆ 若想在圖表上增加圖例，必需在plot()函數內增加label標籤設定
# ◆ 圖例位置可以修改，語法為plt.legend(loc=數值)
# loc編號    說明
#   0     best
#   1     upper right
#   2     upper left
#   3     lower left
#   4     lower right
#   5     right
#   6     center left
#   7     center right
#   8     lower center
#   9     upper center
#   10    center
plt.plot(x,y1,'g',label="A")
plt.plot(x,y2,'r',label="B")
plt.plot(x,y3,'b',label="C")
plt.legend()
plt.show()

plt.plot(x,y1,'g',label="A")
plt.plot(x,y2,'r',label="B")
plt.plot(x,y3,'b',label="C")
plt.legend(loc="lower center")
plt.show()

plt.plot(x,y1,'g',label="A")
plt.plot(x,y2,'r',label="B")
plt.plot(x,y3,'b',label="C")
plt.legend(loc=10)
plt.show()

plt.plot(x,y1,'g')
plt.plot(x,y2,'r')
plt.plot(x,y3,'b')
plt.legend(["A","B","C"])
plt.show()

p1, = plt.plot(x,y1,'g')
p2, = plt.plot(x,y2,'r')
p3, = plt.plot(x,y3,'b')
plt.legend([p1, p2, p3],["A","B","C"])
plt.show()

# %%    網格
# ◆ 圖表預設是不顯示網格，但若想讓圖表更容易閱讀，可以使用
#    grid()函數顯示網格
import matplotlib.pyplot as plt
import numpy as np
x = np.linspace(0, 2*np.pi,500)
y1 = np.sin(x)
y2 = np.cos(x)
# 注意順序 (誰上誰下)
plt.plot(x,y1, label="sin(x)")
plt.plot(x,y2, label="cos(x)")

plt.legend()
plt.grid()
plt.show()

# %%    設定畫布
# ◆ 可以使用figrue()函數建立畫布
# ◆ figure()函數一定要在plot()函數前先設定
plt.figure(figsize=(6,8), facecolor="#D1BBFF")
plt.plot(x,y1, label="sin(x)")
plt.plot(x,y2, label="cos(x)")
plt.legend()
plt.grid()
plt.show()

# 建立多個畫布
plt.figure(1)
plt.plot(x,y1, 'r-*')
plt.title("sin(x)")
plt.figure(2)
plt.plot(x,y2, 'b-+')
plt.title("cos(x)")
plt.show()

# %%    繪製多個圖表 – 子圖表
# ◆ 函數subplot()可以在視窗圖表(figure)內建立子圖表(axes)，語法為：
#      plt.subplot(*args, **kwargs)
# ◆ *args的參數為(nrows, ncols, index)，三個參數皆為整數，
#    預設為(1,1,1)

# 子圖表 – subplot()
# ◆ plt.subplot(列數, 欄數, 子圖序號)
plt.figure()
# plt.ticks(fontsize=10)
plt.subplot(2,2,1, facecolor="g")
plt.subplot(2,2,2, facecolor="r")
plt.subplot(2,2,3)
plt.show()

plt.figure()
plt.subplot(2,2,1, facecolor="g")
plt.subplot(2,2,2, facecolor="r")
plt.subplot(2,1,2) # 2 row 1 col 整個呈現 2 (1剩白色畫布蓋住上面位置)
plt.show()

plt.figure()
plt.subplot(2,1,1) # 2 row 1 col 整個呈現 1 (2剩白色畫布蓋住下面位置)
plt.subplot(2,2,3, facecolor="g")
plt.subplot(2,2,4, facecolor="r")
plt.show()

plt.figure()
plt.subplot(2,2,1, facecolor="#C4DDB1")
plt.plot(x)
plt.subplot(2,2,2, facecolor="#E6A8E6")
plt.plot(x**2)
plt.subplot(2,1,2, facecolor="#F3F599") # 2 row 1 col 整個呈現 2 (1剩白色畫布蓋住上面位置)
plt.plot(x[::-1])
plt.show()

# 子圖表 – subplot2grid()
# ◆ plt.subplot2grid(表格數, 位置, 列, 欄)
plt.rcParams["font.size"] = 10
plt.figure(figsize=(8,8))
plt.subplot2grid((3,3), (0,0), rowspan=1, colspan=3, facecolor="r")
plt.subplot2grid((3,3), (1,0), rowspan=1, colspan=2, facecolor="b")
plt.subplot2grid((3,3), (1,2), rowspan=2, colspan=1, facecolor="g")
plt.subplot2grid((3,3), (2,0), facecolor="y") # 預設 1 row 1 col
plt.subplot2grid((3,3), (2,1), facecolor="w") # 預設 1 row 1 col
# 關閉坐標軸
plt.gca().axes.get_xaxis().set_visible(False)
plt.gca().axes.get_yaxis().set_visible(False)
plt.show()

# %%    儲存圖表
# ◆ 使用savefig()函數可以儲存圖表，語法為：
#      plt.savefig(檔名, [dpi=120, facecolor=“w”, edgecolor=“w”])
# ◆ dip：解析度，預設為80
# ◆ facecolor：圖表表面的顏色
# ◆ edgecolor：圖表邊緣的顏色
plt.figure()
plt.subplot(2,2,1, facecolor="#C4DDB1")
plt.plot(x)
plt.subplot(2,2,2, facecolor="#E6A8E6")
plt.plot(x**2)
plt.subplot(2,1,2, facecolor="#F3F599") # 2 row 1 col 整個呈現 2 (1剩白色畫布蓋住上面位置)
plt.plot(x[::-1])
# 支援 jpg / png / pdf
plt.savefig("subplot_color_o.png")
plt.savefig("subplot_color_1.png", dpi=120)
plt.savefig("subplot_color_2.png", transparent=True)
plt.savefig("subplot_color_3.png", facecolor="c")
plt.savefig("subplot_color_4.png", edgecolor="b")
plt.show()

# %%    圖表常要元素
"""
函數 : 功能
   核心參數說明 
   
figure() : 設定圖表的大小與解析度
   figsize(圖表尺寸)、 dpi(解析度) 

title() : 設定標題
   str(圖名)、 fontdict(文字格式) 

xlabel()、 ylabel() : 設定x軸與y軸的標題
    xlabel(x軸名)、 ylabel(y軸名) 

axis()、 xlim()、 ylim() : 設定x軸與y軸的範圍

xticks()、 yticks() : 設定x軸與y軸的刻度
    ticks(刻度數值)、 labels(刻度名稱) 

grid() : 設定x軸與y軸的主要和次要格線
    b(有無格線)、 axis(x軸和y軸格線)、 color(格線顏色)、alpha(透明度)

legend() : 控制圖例顯示
   loc(位置) 
"""

# %%    長條圖
# ◆ 長條圖是統計常用的圖表，長條的高度和數據的多寡成正比，
#    預設是垂直顯示，也可以改為水平顯示，語法為：
#       plt.bar(x, height, width, bottom, align, **kwargs)

#     參數           說明
#    x         x座標的序列值
#    height    y座標的序列值，也是長條高度
#    width     長條寬度
#    bottom    長條底部座標
#    align     標籤對齊方式，有center、 edge，預設為center
#    color     長條顏色
#    label     長條標籤
#    linewidth 長條邊框寬度
#    hatch     長條內部造型，例如”/”、 ”\”、 ”|”、 ”o”、 ”+”

import matplotlib.pyplot as plt
name = ["java","c++","python","javaScript","objective-c"]
student = [101,87,98,67,80]

plt.bar(name, student)
plt.show()

# 寬度最高 1 (預設 0.8)
plt.bar(name, student, width=0.5)
plt.show()

# 顏色選擇 + 內部造型
plt.bar(name, student, hatch="o", color="#FFCC00")
plt.show()

# 橫向長條圖 +h
plt.barh(name, student)
plt.show()

# %%    圓餅圖
# ◆ 圓餅圖是一種統計圖表，使用pie()函數，圓餅圖可使用百分比
#    描述數據之間的相對關係，語法為：
#       plt.pie(x, [選擇性參數1=值1,選擇性參數2=值2, …])
#     ◆ explode：設定圓餅圖分離，數值越大分離越遠，預設是0
#     ◆ labels：圓餅標籤
#     ◆ colors：圓餅顏色
#     ◆ autopct：項目的百分比格式，語法為”%格式%%”
#     ◆ pctdistance：圓餅標籤與圓心之間距離的比率，預設0.6

import matplotlib.pyplot as plt
plt.rcParams["font.family"] = ["Microsoft JhengHei"]
area = ["A","B","C","D","E","F"]
people = [10000,12600,9600,7500,5100,4800]
plt.pie(people, labels=area)
plt.show()

# 圓餅圖 – 百分比
plt.pie(people, labels=area, autopct="%d%%")
plt.show()

# 圓餅圖 – 數據分離
exp = [0,0,0,0,0,0.1]
plt.pie(people, labels=area, autopct="%d%%", explode=exp)
plt.show()

# 圓餅圖 – 數據陰影
exp = [0,0,0,0,0,0.3]
plt.pie(people, labels=area, autopct="%d%%", explode=exp, shadow=True)
plt.show()

# 圓餅圖 – 圓餅顏色
color = ['aqua','g','pink',"yellow","m","#0022ff"]
plt.pie(people, labels=area, autopct="%d%%", colors=color)
plt.show()

# %%    散點圖
# ◆ 雖然plot()也可以繪製散點圖，但plot()主要用於做折線圖，而
#    scatter()則是專門繪製散點圖，語法為：
#       plt.scatter(x, y, [選擇性參數1=值1,選擇性參數2=值2, …])，
#     ◆ 散點圖使用一系列的散點在直角座標中展示變數的數值分佈
#     ◆ x、 y：散點圖的位置， x與y必需數量一致
#     ◆ s：繪製點的大小，預設20
#     ◆ c：點的顏色
#     ◆ marker：點的樣式，預設為”o”
import matplotlib.pyplot as plt
import numpy as np
x = np.arange(1,11,0.1)
# y = np.random.randint(1,10,100)
y = np.array([int(np.random.randn()/3*10+5) for _ in range(100)])
z = np.random.randint(1,10,100)
plt.scatter(x, y)
plt.show()

plt.scatter(x, y, c=z, s=100)
plt.show()

# %% 觀望散點測試
import matplotlib.pyplot as plt
import numpy as np

# Fixing random state for reproducibility
np.random.seed(19680801)

# 資料數
N = 100
# 圖形分界值  
r0 = 0.6
# 建立xy資料
x = 0.9 * np.random.rand(N)
y = 0.9 * np.random.rand(N)
# 建立不同大小
area = (20 * np.random.rand(N))**2  # 0 to 10 point radii
# 建立 colorbar 跟隨值
c = np.sqrt(area)
# 與原點間的距離
r = np.sqrt(x ** 2 + y ** 2)
# 遮罩
area1 = np.ma.masked_where(r < r0, area)
area2 = np.ma.masked_where(r >= r0, area)
# 繪圖
plt.scatter(x, y, s=area1, marker='^', c=c)
plt.scatter(x, y, s=area2, marker='o', c=c)
# Show the boundary between the regions:
theta = np.arange(0, np.pi / 2, 0.01)
plt.plot(r0 * np.cos(theta), r0 * np.sin(theta))
# 顯示
plt.show()

# %%    補充
# (1) 中文
# Mac的繁中字體我只找到兩個能用：
# Heiti TC (黑體)
# /System/Library/Fonts/STHeiti Light.ttc
# PingFang (蘋方體)
# ﻿/System/Library/Fonts/PingFang.ttc

# Arial Unicode MS
# SimHei 

# (2) Kite
# 對了，雖然剛才建議大家先不急著裝kite，但還是找一下給同學，現在官網不能下載的情形，有想裝的話可以從Spyder 裡直接裝
# 從Spyder 的工具列裡可以找到安裝選項
# Tools > Install Kite completion engine
