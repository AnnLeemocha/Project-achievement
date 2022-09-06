# 例外處理 (Exception Handling)
# ◆ Python直譯器(interpreter)當執行程式發生錯誤時會引發例外
#   (exception)並中斷程式執行
# ◆ 會引發例外並不全然是程式的邏輯錯誤，像是讀檔時但檔案不
#   存在、資料型態不正確、分母為0…等，我們並不想要程式停
#   止執行，而是希望發生例外後能有其他的方式處理
# 例外處理類型： (圖片)

# %% 常見的except錯誤訊息
#    錯誤訊息               說明
# NameError           使用沒有被定義的對象
# IndexError          索引值超過序列的大小
# TypeError           資料型態錯誤
# SyntaxError         語法規則錯誤
# ValueError          傳入值錯誤
# ZeroDivisionError   分母不得為0
# AttributeError      使用不存在的屬性
# IndentationError    語法錯誤(沒有對齊)

# %% 語法 try…except
# ◆ 當try區塊內的程式發生錯誤時，就會執行except區塊的程式；
#    若try區塊內的程式沒有錯誤，就不會執行except區塊
# 例外處理範例：
try:
    x='10'
    print(x+10)
except:
    print('發生錯誤')
# 例外處理範例：
# ◆ 在try…except中最少必須有一個except敘述， except後方可以
#    加上錯誤訊息，例如： except ValueError
# ◆ try.…except的擺放順序必須要由小範圍到大範圍
x = input('數值1：')
y = input('數值2：')
# print(int(x)/int(y))
try:
    print(int(x)/int(y))
except ZeroDivisionError:
    print('分母不得為 0')
# except ValueError:
#     print('必須輸入數值')
except:
    print('發生錯誤')
    
# %% 語法 try…except…else…finally
# ◆ else：沒有發生錯誤時會執行的區塊
# ◆ finally：在try…except完成後一定會執行的區塊
# print(int(x)/int(y))
try:
    x = eval(input('數值1：'))
    y = eval(input('數值2：'))
    ans = x/y
except ZeroDivisionError:
    print('分母不得為 0')
except ValueError:
    print('必須輸入數值')
except:  # 嚴謹，保險起見把其他意外放進來
    print('發生錯誤')
else:
    print(ans)
finally:
    print('程式結束')

