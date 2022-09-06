# 圖形化介面 (Tkinter)

# %%    Tkinter介紹
# ◆ GUI開發也叫圖形介面開發， Tkinter是Python內建的圖形介面
#    開發庫，它簡單實用，速度很快
# ◆ Tkinter支援跨平台，可以在Windows、 Mac、 Linux、 UNIX上
#    開發執行
# ◆ Tkinter的全名為Tk interface
# ◆ 除了Tkinter之外，還有其他幾種GUI庫可代替，例如PyQt、
#    Pygame、 PySide等
# ◆ Python2時用Tkinter， Python3更改為tkinter

# %%    建立tkinter視窗
# ◆ Tkinter是Python內建函式庫，只要匯入即可使用
# ◆ 使用Tk()方法建立Tkinter視窗
# ◆ 使用mainloop()放在主迴圈中一直執行，直到關閉視窗才會停止運作
# ◆ title()：設定視窗標題
# ◆ geometry()：設定視窗大小，一定要是字串

# from tkinter import *
# # 建立Tkinter視窗
# window = Tk()
# # 放在主迴圈中一直執行，直到關閉視窗才會停止運作
# window.mainloop()

import tkinter as tk 
# 建立Tkinter視窗
window = tk.Tk()
# 放在主迴圈中一直執行，直到關閉視窗才會停止運作 (桌面執行，放最後)
# window.mainloop()
# 設定視窗標題
window.title("MY視窗")
# 設定視窗大小，一定要是字串 ("400x300")
window.geometry("400x300")
# 將 png 轉成 ico (不轉標題的圖標會出現方框)
from PIL import Image
icon = Image.open("images (1).jpg")
icon.save("images.ico")
# 變更視窗 icon
window.iconbitmap("images.ico")
# 設定三種背景顏色
for color in ["red","orange","#0066FF"]:
    # 放到視窗上 .pack()
    tk.Frame(bg=color, height=30,width=300).pack()


# %%    Tkinter建立流程
# 匯入tkinter 
# 建立視窗 
# 設定視窗大小、標題等
# 新增元件 (label 、button等)
# 將元件布置到視窗
# 對元件加入監聽
# 進入事件處理迴圈

# %%    GUI元件
#  元件           說明
# Label        文字標籤
# Button       按鈕
# Entry        文字方塊
# Text         文字區塊
# Listbox      清單方塊
# Radiobutton  選項按鈕
# Checkbutton  核取按鈕
# Canvas       畫布
# Menu         功能表
# Menubutton   功能表按鈕
# Scrollbar    捲軸
# Scale        滑杆
# Spinbox      調整鈕
# messagebox   對話方塊
# Frame        視窗

# %%    GUI元件 – label(文字標籤)
#  參數               說明
# anchor      擺放位置，可以設定n、 s、 w、 e，預設center
# text        文字內容，可以用換行符號(\n)
# width       寬度，預設0
# height      高度，預設0
# bg          背景顏色
# fb          文字顏色
# font        字型設定，包含大小(px)、粗體(bold) 、斜體 (italic)
# padx、 pady 內容和標籤左右(px)、上下(px)的間距，預設1

label1 = tk.Label(window, text="帳號", font=50, fg="#146E68")
label2 = tk.Label(window, text="密碼", font=50, fg="#146E68")
label1.pack()
label2.pack()

# %%    GUI元件 – Button(按鈕)
#     參數                   說明
# anchor            擺放位置，可以設定n、 s、 w、 e，預設center
# text              文字內容，可以用換行符號(\n)
# width             寬度，預設0
# height            高度，預設0
# bg                背景顏色
# fb                文字顏色
# font              字型設定，包含大小(px)、粗體(bold) 、斜體(italic)
# padx、 pady       內容和標籤左右(px)、上下(px)的間距，預設1
# image             圖片
# command           按下按鈕時要執行的函式
# activeforeground  按下按鈕時的按鈕顏色

buttom1 = tk.Button(window, text="按鈕 1", font=50)
buttom2 = tk.Button(window, text="按鈕 2", font=50, activeforeground="red")
buttom1.pack(side=tk.TOP)
buttom2.pack(side=tk.LEFT)

num = 0
# 設定文字變數
word = tk.StringVar()
# 設定 word 內容
word.set(num)
# 設定成全域變數獲取全域資料
def add():
    global num
    num += 1
    word.set(num)     
    # 思考如何更新按鈕上的文字
    # buttom3["text"] = f"總共按了{num}次"
# 加監聽 (command)
label3 = tk.Label(window, textvariable=word, font=50, fg="#146E68")
# buttom3 = tk.Button(window, textvariable=word, font=50, command=add)
buttom3 = tk.Button(window, text="請按我", font=50, command=add)

label3.pack()
buttom3.pack()

# %%    GUI元件 – Entry(文字方塊)

word2 = tk.StringVar()
word2.set("")

tk.Label(window, textvariable=word2, font=50, fg="#146E68").pack(side=tk.LEFT)
# 思考灰灰的提示字
tk.Entry(window, textvariable=word2, font=50).pack(side=tk.LEFT)

window.mainloop()

# %%  新視窗
import tkinter as tk

win = tk.Tk()
win.geometry("600x400")

def add():
    result.set(num1.get() + num2.get())
num1 = tk.DoubleVar()
num2 = tk.DoubleVar()
result = tk.DoubleVar()

# 思考點上就成空

tk.Entry(win,width=10, textvariable=num1, font=50).pack(side=tk.LEFT)
tk.Label(win, text="+", font=50, fg="#146E68").pack(side=tk.LEFT)
tk.Entry(win,width=10, textvariable=num2, font=50).pack(side=tk.LEFT)
tk.Label(win, text="=", font=50, fg="#146E68").pack(side=tk.LEFT)
tk.Entry(win,width=10, textvariable=result, font=50).pack(side=tk.LEFT)
tk.Button(win, text="計算", command=add).pack(side=tk.LEFT)
win.mainloop()

# %%    GUI元件 – Text(文字區塊)
#   參數            說明
# width        寬度，單位是字元數
# height       高度，單位是字元數
# bg           背景顏色
# fb           文字顏色
# font         字型設定，包含大小(px)、粗體(bold) 、斜體(italic)
# padx、 pady  內容和標籤左右(px)、上下(px)的間距，預設1
# bd           邊框粗細，預設1
# relief       邊框樣式，有flat、 sunken、 raised、 ridge、solid，預設flat
# textvariable 文字內容的變數名稱

# 方法             參數               說明
# get()          first,last=None  取得文字區塊內容，以小數點方式表示。例如0.0=第一個字元
# delete()       first,last=None  刪除指定範圍的內容
# see()          index            取得第幾個位置的字元
# index()        index            取得指定的索引值
# insert()       index,s          在指定索引值位置插入內

# %%  新視窗  BY  Text(文字區塊)
import tkinter as tk

win = tk.Tk()
win.geometry("600x400")

word = tk.StringVar()    # 設定文字變數word
word.set("")             # 設定word的內容

label = tk.Label(win, textvariable=word)
label.pack()
text = tk.Text(win, bg="#CCFFCC", fg="#0000FF", height=10)
text.pack()

def show():
    word.set(text.get("1.0", "end-1c"))
    # 1.0表示從第一個字元開始取值
    # end-1c表示從倒數第二個字元取值 (去掉最後一行的換行符號)

def clear():
    # 清除顯示的文字
    word.set("")
    # 刪除文字區塊的內容
    text.delete("1.0","end")

btn1 = tk.Button(win, text="顯示文字", command=show).pack()
btn2 = tk.Button(win, text="清除文字", command=clear).pack()

win.mainloop()

# %%    新視窗  BY  SQL 連線範例
# 可應用範例 : 遊戲排名 & 帳號密碼
# # tkinter + SQL
# # 輸出員編、姓名、地址

# import mariadb
# import tkinter  as tk	

# conn = mariadb.connect(host="localhost",user="root",
#                         password="12345678",db="mydb",port=3307)

# cusr = conn.cursor()
# #進SQL查所有員工資料
# def findEmployeeAll():
#     sql = "SELECT * FROM employee ORDER BY num ASC"
#     cusr.execute(sql)
#     rs = cusr.fetchall()
#     line=""
#     for i in range(len(rs)):      
#         line+="%s  %s  %s" %(rs[i][0],rs[i][1],rs[i][5])
#         line+="\n"
#     return line

# #進SQL查指定員工資料
# def findEmployee(word1):
#     sql = "SELECT * FROM employee WHERE num='{}'".format(word1[:-1])
#     cusr.execute(sql)
#     try:          
#         # 先確認是否有資料，有則輸出，無則顯示「查無此員工」
#         rs = cusr.fetchone()
#         # 取出查詢結果
#         result = (rs[0],rs[1],rs[5])   
#         return result            
#     except:
#         result = ("查無此員工")
#         return result

# #讀取文字功能
# def getText():
#     result = edit.get("1.0","end")
#     return result        

# #清除文字功能
# def clearText():
#     #"1.0"和"end"是指 Tkinter 文字框控制元件中內容的第一個字元和最後一個字元
#     edit.delete("1.0","end")

# #按鈕事件
# def show1(event):
#     word2 = findEmployeeAll()
#     clearText()
#     edit.insert(tk.END, word2)

# def show2(event):
#     word1 = getText()
#     clearText()
#     word2 = findEmployee(word1)
#     edit.insert(tk.END, word2)
    
# 		
# win = tk.Tk()
# win.title("Tkinter + SQL")
# win.geometry("500x300")

# #輸入方塊
# edit = tk.Text(win,font="微軟粗黑體", width='50', height='14')	   
# #查詢按鈕
# button1 = tk.Button(win, text ="查詢全部",width = 6, height = 2)	
# #清除按鈕
# button2 = tk.Button(win, text ="清除",width = 6, height = 2, command = clearText)
# #個別查詢按鈕
# button3 = tk.Button(win, text ="查詢員工",width = 6, height = 2)	

# button1.bind("<Button-1>", show1)
# button3.bind("<Button-1>", show2)

# #添加元件
# edit.pack()
# button1.place(x=5, y=240)
# button2.place(x=75, y=240)
# button3.place(x=145,y=240)
# win.mainloop()

# cusr.close()
# conn.close()

# %%    GUI元件 – Radiobutton(選項按鈕) 單選
#  參數           說明
# anchor       擺放位置，可以設定n、 s、 w、 e，預設center
# text         文字內容，可以用換行符號(\n)
# width        寬度，預設0
# height       高度，預設0
# bg           背景顏色
# fb           文字顏色
# font         字型設定，包含大小(px)、粗體(bold) 、斜體 (italic)
# padx、 pady  內容和標籤左右(px)、上下(px)的間距，預設1
# variable     綁定變數
# value        選擇按鈕時要回傳變數的值
# command      按下按鈕時要執行的函式

# %%  新視窗  BY  Radiobutton(選項按鈕) 單選
import tkinter as tk

win = tk.Tk()
win.geometry("600x400")

def show():
    select = word.get()
    label.config(text=select)

# 設定文字變數 word
word = tk.StringVar()    

# 設定第一個選項按鈕JAVA
radio1 = tk.Radiobutton(win, text="JAVA", variable=word, 
                     value="JAVA (回傳)", command=show)
# 預設勾選的為JAVA
radio1.select()
# 思考預設系統不勾

# 設定第二個選項按鈕PYTHON
radio2 = tk.Radiobutton(win, text="PYTHON", variable=word, 
                     value="PYTHON (回傳)", command=show)

# 設定一個文字標籤
label = tk.Label(win)

radio1.pack()
radio2.pack()
label.pack()

win.mainloop()

# %%    GUI元件 – Checkbutton(核取按鈕) 多選
#  參數              說明
# anchor       擺放位置，可以設定n、 s、 w、 e，預設center
# text         文字內容，可以用換行符號(\n)
# width        寬度，預設0
# height       高度，預設0
# bg           背景顏色
# fb           文字顏色
# font         字型設定，包含大小(px)、粗體(bold) 、斜體(italic)
# padx、 pady  內容和標籤左右(px)、上下(px)的間距，預設1
# variable     綁定變數
# onavlue      選取按鈕時回傳到變數的值，預設0
# offvalue     取消選取按鈕時回傳到變數的值，預設0
# command      按下按鈕時要執行的函式

# %%  新視窗  BY  Checkbutton(核取按鈕) 多選
from tkinter import Tk, StringVar, Checkbutton, Label, Button

win = Tk()
win.geometry("600x400")

def show():
    text = var1.get() + var2.get() + var3.get()
    word.set(text)

# 設定文字變數
word = StringVar()
word.set("")

var1 = StringVar()
check1 = Checkbutton(win, text="大麥克", variable=var1, 
                     onvalue="大麥克", offvalue="", command=show)
                     # 勾選回傳        # 不勾選回傳
check1.pack()
check1.deselect()

var2 = StringVar()
check2 = Checkbutton(win, text="麥香魚", variable=var2, 
                     onvalue="麥香魚", offvalue="", command=show)
check2.pack()
check2.deselect()

var3 = StringVar()
check3 = Checkbutton(win, text="麥香雞", variable=var3, 
                     onvalue="麥香雞", offvalue="", command=show)
check3.pack()
check3.deselect()

label = Label(win, textvariable=word, font=30)
label.pack()

def clear_selection():
    check1.deselect()
    check2.deselect()
    check3.deselect()
    show()
Button(win, text='Deselect All Check buttons', command=clear_selection).pack()

win.mainloop()

# %%    GUI元件 – Canvas(畫布)
#  參數         說明
# anchor       擺放位置，可以設定n、 s、 w、 e，預設center
# width        寬度，預設0
# height       高度，預設0
# bg           背景顏色
# padx、 pady  內容和標籤左右(px)、上下(px)的間距，預設1
# relief       邊框樣式，有flat、 sunken、 raised、 ridge、 solid，預設flat
# bd           邊框粗細，預設1

#     參數               說明
# create_text         繪製文字
# create_line         繪製直線
# create_rectangle()  繪製矩形
# create_oval()       繪製圓形、橢圓形
# create_arc()        繪製圓弧
# create_polygon()    繪製多邊形
# create_image()      繪製圖像

# %%  新視窗  BY  Canvas(畫布)-1
# from tkinter import *
from tkinter import Tk,Canvas

win = Tk()
win.geometry("200x200")

# 設置畫布大小100*100，顏色粉紅色
canvas = Canvas(win, width=100, height=100, bg="#FFCCCC")
canvas.pack()

win.mainloop()

# %%  新視窗  BY  Canvas(畫布)-2
from tkinter import Tk,Canvas

win = Tk()

# 設置畫布大小400*300
canvas = Canvas(win, width=400, height=300)
canvas.pack()

# bind 中放的 paint函式 括號中一定要加上名稱
# 繪製圓形，其大小設置，左上至右下
def paint(event):
    x1, y1 = (event.x -1),(event.y -1)
    x2, y2 = (event.x +1),(event.y +1)
    canvas.create_oval(x1,y1,x2,y2, outline="black")
# 監聽滑鼠
canvas.bind("<B1-Motion>", paint)
# 【bind 監聽】

win.mainloop()

# %%    GUI元件 – Menu(功能表)
from tkinter import Tk, Menu

win = Tk()
win.geometry("200x200")

# 建立主選單
menu = Menu(win)
menu.add_command(label="檔案")  # 建立主選單項目
menu.add_command(label="編輯")  # 建立主選單項目
menu.add_command(label="工具")  # 建立主選單項目

win.config(menu=menu)     # 將主選單添加到視窗上

win.mainloop()

# %%  新視窗  BY  Menu(功能表) + 子選單
from tkinter import Tk, Menu

win = Tk()
win.geometry("200x200")

# 建立主選單
menu = Menu(win)

# 建立子選單
submenu = Menu(menu)
submenu.add_command(label="開啟舊檔")  # 建立子選單項目
submenu.add_command(label="存檔")  # 建立子選單項目
submenu.add_command(label="另存新檔")  # 建立子選單項目

# 建立主選單「檔案」，內容為submenu
menu.add_cascade(label="檔案", menu=submenu)
win.config(menu=menu)     # 將主選單添加到視窗上

win.mainloop()

# %%  新視窗  BY  Menu(功能表) + 孫選單
from tkinter import Tk, Menu

win = Tk()
win.geometry("200x200")

menu = Menu(win)

# 建立第一個選單
menu1 = Menu(menu)
menu1.add_command(label="開啟舊檔")          # 建立第一個選單項目
menu1.add_command(label="存檔")              # 建立第一個選單項目
menu1.add_command(label="另存新檔")          # 建立第一個選單項目
menu.add_cascade(label="檔案", menu=menu1)   # 將第一個選單項目綁定在「檔案」下

# 建立第二個選單
menu2 = Menu(menu)
menu2.add_command(label="剪下")              # 建立第二個選單項目
menu2.add_command(label="貼上")              # 建立第二個選單項目
menu.add_cascade(label="常用", menu=menu2)   # 將第二個選單項目綁定在「常用」下

# 建立子選單的子選單
menu2_more = Menu(menu2)
menu2_more.add_command(label="複製物件")      # 建立第二個選單項目的子選單
menu2_more.add_command(label="複製格式")      # 建立第二個選單項目的子選單
menu2.add_cascade(label="複製", menu=menu2_more)   # 將子選單綁定在「複製」下
# menu2.add_command(label="複製")  # 多出現一次
    
win.config(menu=menu)     # 將主選單添加到視窗上

win.mainloop()

# %%    Menu(功能表) BY Mac
# main3 = tk.Menu(main)
# main.add_cascade(label="test", menu=main3)
# 直接不要設子選單就好
# https://steam.oxxostudio.tw/category/python/tkinter/menu.html

# %%    GUI元件 – messagebox(對話方塊)
#  方法種類           說明
# showinfo         普通訊息
# showwarning      警告訊息
# showerror        錯誤訊息
# askquestion      提問(yes/no)
# askyesno         是或否(yes/no)
# askokcancel      確認或取消(ok/cancel)
# askretrycancel   重試(retry/cancel)

from tkinter import Tk,Button
from tkinter import messagebox

win = Tk()
win.geometry("200x200")

def showinfo():
    messagebox.showinfo("showinfo", "訊息測試")

btn_showinfo = Button(win, text="訊息測試", command=showinfo)
btn_showinfo.pack()
    
def showwarning():
    messagebox.showwarning("showwarning", "警告訊息")

btn_showwarning = Button(win, text="警告訊息", command=showwarning)
btn_showwarning.pack()
    
def showerror():
    messagebox.showerror("showerror", "錯誤訊息")

btn_showerror = Button(win, text="錯誤訊息", command=showerror)
btn_showerror.pack()

def askquestion():
    messagebox.askquestion("askquestion", "提問訊息")
 
btn_askquestion = Button(win, text="提問訊息", command=askquestion)
btn_askquestion.pack()

def askyesno():
    messagebox.askyesno("askyesno", "是或否訊息")
    
btn_askyesno = Button(win, text="是或否訊息", command=askyesno)
btn_askyesno.pack()

def askokcancel():
    messagebox.askokcancel("askokcancel", "確認取消訊息")

btn_askokcancel = Button(win, text="確認取消訊息", command=askokcancel)
btn_askokcancel.pack()

def askretrycancel():
    messagebox.askretrycancel("askretrycancel", "重試訊息")
    
btn_askretrycancel = Button(win, text="重試訊息", command=askretrycancel)
btn_askretrycancel.pack()

win.mainloop()


# %%    GUI元件 – Listbox(列表)
#  參數               說明
# anchor        擺放位置，可以設定n、 s、 w、 e，預設center
# width         寬度，預設0
# height        高度，預設0
# bg            背景顏色
# fb            文字顏色
# font          字型設定，包含大小(px)、粗體(bold) 、斜體(italic)
# relief        邊框樣式，有flat、 sunken、 raised、 ridge、 solid，預設flat
# bd            邊框粗細，預設1
# listvariable  綁定清單變數，可動態存取listbox內容
# selectmode    選取模式，可以設browse(預設，等同單選)、 single(單選)、
#               multiple(多選)、 extended(等同多選，可以用滑鼠拖曳選取)

# %%    新視窗  BY  Listbox(列表) 滑鼠按住拖曳會隨之移動
from tkinter import Tk, Listbox, StringVar

win = Tk()
win.geometry("200x200")

# 設定文字變數
word = StringVar()
word.set(("apple", "banana", "cherry", "lemon", "grape", "guava"))

# 設定列表
listbox = Listbox(win, listvariable=word)
listbox.pack()

win.mainloop()

# %%    新視窗  BY  Listbox(列表)  選擇模式 (單選 多選 多選+可用滑鼠按住拖曳會增加選項)
from tkinter import Tk, Listbox, StringVar

win = Tk()
win.geometry("200x200")

# 設定文字變數
word = StringVar()
word.set(("apple", "banana", "cherry", "lemon", "grape", "guava"))

# 單選模式
# listbox = Listbox(win, listvariable=word, selectmode="single")
# 多選模式
listbox = Listbox(win, listvariable=word, selectmode="multiple")
# 多選模式(可用滑鼠拖曳)
# listbox = Listbox(win, listvariable=word, selectmode="extended")
listbox.pack()

win.mainloop()


# %%    GUI元件- Scrollbar(捲軸)
from tkinter import Tk,Scrollbar

win = Tk()
win.geometry("200x200")

# 建立捲軸
scrollbar = Scrollbar(win)
# 將捲軸設定在視窗右邊，垂直填滿
scrollbar.pack(side="right", fill="y")

win.mainloop()

# %%    新視窗  BY  Scrollbar(捲軸) + Listbox(列表)
from tkinter import Tk,Frame,Scrollbar

win = Tk()
win.geometry("200x200")

# 建立frame
frame = Frame(win, width=15)
frame.pack()

# 在frame裡放入捲軸
scrollbar = Scrollbar(frame)
# 將捲軸設定在frame右邊，垂直填滿
scrollbar.pack(side="right", fill="y")

# 設定列表清單
word = StringVar()
word.set(("大麥克", "麥香魚", "麥香雞", "麥克雞塊",
          "麥脆雞", "勁辣雞腿堡", "牛肉吉事堡"))

# 列表設定
listbox = Listbox(frame, listvariable=word, height=5, 
                  width=15, yscrollcommand=scrollbar.set)
                            # 監聽右側卷軸 (下拉位置同步，沒寫就會不同步)
listbox.pack(side="left", fill="y")

# 兩者連動 (拖曳時左側清單一起移動)
scrollbar.config(command=listbox.yview)

win.mainloop()

# %%    GUI元件 – 布局
# ◆ 元件布局有三種方法
# ◆ pack(side=XXXX)： xxx可以是TOP、 LEFT、 BOTTOM、 RIGHT
# ◆ grid(row=x, column=y)：以行列布局
# ◆ place(x=10,y=50)：以坐標方式布局
from tkinter import *

win = Tk()

# 思考元件隨視窗等比例縮放
# x = 400
# y = 300
# win.geometry(f"{x}x{y}")

label1 = Label(win, text="標籤一",width=20, height=5, bg="red")
label2 = Label(win, text="標籤二",width=20, height=5, bg="blue")
label3 = Label(win, text="標籤三",width=20, height=5, bg="green")

# 使用pack()
# label1.pack(side=RIGHT)
# label2.pack(side= BOTTOM)
# label3.pack(side=LEFT)

# 使用grid()
# label1.grid(row=0, column=0)
# label2.grid(row=1, column=0)
# label3.grid(row=2, column=1)
# label3.grid(row=4, column=1)
# 無法空格

# 使用place()
# label1.place(x=0, y=10)
# label2.place(x=40, y=50)
# label3.place(x=100, y=100)

# label1.place(x=x/40, y=y/30)
# label2.place(x=40, y=50)
# label3.place(x=100, y=100)

win.mainloop()

# %%    GUI元件 – 布局管理元件
# ◆ Tkinter提供了幾種布局管理元件，主要作用為為其他元件提供
#    容器，將主視窗劃分成多個區域，進而方便管理
#   ◆ Frame ： Frame可以放在主視窗內， Frame內還能再放Frame
#   ◆ LabelFrame ：為Frame的進階版，功能屬性跟Frame相似
#   ◆ PanedWindow ：在Tkinter8.4版後新增功能，和Frame不同之處在於
#                    PanedWindow可以讓使用者自訂每個區塊的大小

# %%    布局管理元件 – Frame
from tkinter import *

win = Tk()
# 視窗大小400*400，距離螢幕左邊及上邊各500 (預設視窗出現大小&位置)
win.geometry("400x400+500+500")  # 思考置中出現

# 在主視窗上添加Frame元件
frame = Frame(win)
frame.pack()

# 在Frame元件上再添加兩個Frame，分別放在左跟右
# Frame元件上添加左Frame
frame_left = Frame(frame)
Label(frame_left, text="標籤1", bg="green", width=10, height=5).grid(row=0, column=0)
Label(frame_left, text="標籤2", bg="purple", width=10, height=5).grid(row=2, column=2)
frame_left.pack(side=LEFT)

# Frame元件上添加右Frame
frame_right = Frame(frame)
Label(frame_right, text="標籤3", bg="yellow", width=10, height=5).grid(row=0, column=1)
Label(frame_right, text="標籤4", bg="blue", width=10, height=5).grid(row=1, column=0)
Label(frame_right, text="標籤5", bg="red", width=10, height=5).grid(row=1, column=1)
frame_right.pack(side=RIGHT)

win.mainloop()


# %%    布局管理元件 – LabelFrame
from tkinter import *

win = Tk()
# 視窗大小400*400，距離螢幕左邊及上邊各500
win.geometry("400x400+500+500")

# 設定左邊LabelFrame，裡面有2個label
frame_left = LabelFrame(win, text="左邊LabelFrame",bg="yellow") # 預設有框
frame_left.pack(side=LEFT)
label_1 = Label(frame_left, text="C++")
label_1.pack()
label_2 = Label(frame_left, text="VB")
label_2.pack()

# 設定右邊LabelFrame，裡面有3個label
frame_right = LabelFrame(win, text="右邊LabelFrame",bg="pink")
frame_right.pack(side=RIGHT)
label_3 = Label(frame_right, text="JAVA")
label_3.pack()
label_4 = Label(frame_right, text="Python")
label_4.pack()
label_5 = Label(frame_right, text="SQL")
label_5.pack()

win.mainloop()


# %%    布局管理元件 – PanedWindow
from tkinter import *

win = Tk()
# 視窗大小400*400，距離螢幕左邊及上邊各500
win.geometry("400x400+500+500")

# 創建一個水平方向的panel
left_panel = PanedWindow(win)
left_panel.pack(fill=BOTH, expand=1)

# 在左邊panel裡添加一個label
left = Label(left_panel, text="左panel", bg="#CC99FF")
left_panel.add(left)

# 創建一個垂直方向的panel
right_panel = PanedWindow(orient=VERTICAL)
# 將垂直方向panel添加至水平方向panel內
left_panel.add(right_panel)
# 設置垂直方向panel內的2個label
top = Label(right_panel, text="右上panel", bg="#66CCFF", height=10)
bottom = Label(right_panel, text="右下panel", bg="#CCFF99")
right_panel.add(top)
right_panel.add(bottom)

win.mainloop()

# %%    Tkinter事件處理
# ◆ 我們希望在按下滑鼠按鈕或是拖曳滑鼠時會觸發事件，此時就
#    需要使用bind方法
# ◆ bind(“<Button>”,函式名)的Button是指使用者點擊滑鼠時所觸發的事件
#     ◆ Button-1：滑鼠左鍵
#     ◆ Button-2：滑鼠中鍵
#     ◆ Button-3：滑鼠右鍵
#     ◆ Button-4： 滾輪向上滾
#     ◆ Button-5： 滾輪向下滾
# ◆ bind(“<Motion>”,函式名)的Motion是指使用者移動滑鼠時所觸發的事件

# %%    新視窗  BY  事件處理 (滑鼠在label按下任一鍵才呼叫觸發)
from tkinter import *

win = Tk()
win.geometry("200x200")

def mouseClick(event):
    print("滑鼠點擊")

label = Label(win, text="請按我", font=30)
label.pack()
label.bind("<Button>", mouseClick)

win.mainloop()

# %%    新視窗  BY  事件處理 (滑鼠在視窗任意一處按下左鍵才呼叫觸發)
from tkinter import *

win = Tk()
win.geometry("200x200")

def mouseCall(event):
    print("滑鼠位置：%s,%s" %(event.x, event.y))

win.bind("<Button-1>", mouseCall)

win.mainloop()


# %%    新視窗  BY  事件處理 (滑鼠進入視窗就會呼叫觸發)
from tkinter import *

win = Tk()
win.geometry("200x200")

def mouseMove(event):
    print("滑鼠位置：%s,%s" %(event.x, event.y))

win.bind("<Motion>", mouseMove)

win.mainloop()
