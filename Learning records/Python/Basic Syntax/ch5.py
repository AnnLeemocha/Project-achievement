# 流程控制 (非流程控制)

# %% 選擇結構
# 單向 if 
a,b=100,200
if a<b:
    print(a)
    
if 2**10 ==1024:
    print('2^10=1024')
    print('^是XOR')
# 雙向 if ... else
score=eval(input('輸入分數(0~100)：'))
if score>=60:
    print('及格!')
else:
    print('不及格!')
# 多向 if ... elif ... else 
#score=eval(input('輸入分數(0~100)：'))
if score>=90:
    print('優')
elif score >=80:
    print('甲')
elif score >=70:
    print('乙')
elif score >=60:
    print('丙')
else:
    print('不及格!')
# 巢狀 if (閱讀不易，不建議使用) [注意! ": + 縮排"]
#score=eval(input('輸入分數(0~100)：'))
if score>=90:
    print('優')
else:
    if score >=80:
        print('甲')
    else:
        if score >=70:
            print('乙')
        else:
            if score >=60:
                print('丙')
            else:
                print('不及格!')
    
# %% 迴圈結構
# while 迴圈 (條件成立，執行區塊，再次檢查) - "不清楚"重複次數
i=0
while i<5:
    print(i)
    i+=1
print('輸出:',i)
# 較特殊有 while ... else (條件為 False 進入 else 跑)
ans=input("請輸入快樂的英文：")
while (ans.upper() != 'HAPPY'):
    ans=input("回答錯誤，請重新輸入快樂的英文：")
else:   
    print("答對了!")
# 也可不使用
ans=input("請輸入快樂的英文：")
while (ans.upper() != 'HAPPY'):
    ans=input("回答錯誤，請重新輸入快樂的英文：")
print("答對了!")

# %%
# iterator -> range()函數
# range(stop)
print(range(5)) # 0~4 (不含5)
# range(start, stop)
print(range(1,10)) # 1~9 (不含10)
# range(start, stop, step)
print(range(10,-10,-2)) # 10,8,6,4,2,0,-2,-4,-6,-8 (不含-10)

# %% 迴圈結構
# for 迴圈 - "清楚"重複次數
# for var in (欄/箱子[容器]): # 一個一個丟進 var
i=0
for i in range(5): # 不可取與全域變數同名，會修改到值
    if i == len(range(5))-1:
        print(i)
    else:
        print(i,end=', ')
print(i) # 區域與全域變數同名，會修改到值

name='AnnLee'
for i in range(len(name)):
    print(i,name[i])
    
for i in name:
    print(i,end='')
print()

for i in ['Sun.','Mon.','Tues.','Wed.','Thurs.','Fri.','Sat.']:
    print(i,end='  ')
print()

# break (離開迴圈)
ans=input("請輸入快樂的英文(quit:exit)：")
while (ans.upper() != 'HAPPY'):
    if ans.upper() == "QUIT":
        print("結束不玩了!")
        break
        # 同層縮排後面不應有程序，已跳出不執行
    ans=input("回答錯誤，請重新輸入快樂的英文(quit:exit)：")
else:   
    print("答對了!")  # break 跳出不會執行 else
    
# continue (跳到下一輪迴圈)
i=0
while i<10:
    i+=1
    if i%3!=0:
        continue
        # 同層縮排後面不應有程序，已跳出不執行
    print(i)

