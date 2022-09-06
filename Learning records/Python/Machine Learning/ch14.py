# 機器學習 - 迴歸

# 監督式學習：
#  > 迴歸問題
#  > 分類問題
# 非監督式學習:：
#  > 分群
#  > 降維

# Pyton ---> Scikits.learn
#            from sklearn.linear_model import LineRegression

# %%    簡單線性迴歸
# 1. 匯入套件
import numpy as np
import pandas as pd
from sklearn.linear_model import LinearRegression
import matplotlib.pyplot as plt

# 2. 設定來源資料
# twmp = [29,28,34,31,25,29,32,31,24,33,25,31,26,30]
# sale = [7.7,6.2,9.3,8.4,5.9,6.4,8.0,7.5,5.8,9.1,5.1,7.3,6.5,8.4]
temp = np.array([29,28,34,31,25,29,32,31,24,33,25,31,26,30])
sale = np.array([7.7,6.2,9.3,8.4,5.9,6.4,8.0,7.5,5.8,9.1,5.1,7.3,6.5,8.4])
x = pd.DataFrame(temp, columns=["Temperature"])
y = pd.DataFrame(sale, columns=["Drink_Sales"])

# 3. 建立模型
# 建立物件
lr = LinearRegression() 
# 呼叫 fit(解釋變數,反影變數) 函式訓練模型 (建模)
lr.fit(x,y)
# 取得物件屬性 (迴歸係數：coef_ , 截距：intercept_)
print("迴歸係數：", lr.coef_)
print("截距：", lr.intercept_)

# 4. 使用 predicted(新的解釋變數) 函式進行預測  (氣溫26&30度的業績) 
# 型態必須相同
# new_temp = pd.DataFrame(pd.DataFrame([26,30], columns=["Temperature"]))
new_temp = pd.DataFrame(pd.DataFrame(np.array([26,30]), columns=["Temperature"]))
predicted_sale = lr.predict(new_temp)
print("氣溫26&30度的業績的預測結果：\n", predicted_sale)

# 5. 繪圖
plt.scatter(temp, sale)
regression_sales = lr.predict(x)
plt.plot(temp, regression_sales, color="blue")
plt.plot(new_temp, predicted_sale, color="red",marker="o",markersize=10)
plt.show()

# %%    複迴歸
# 1. 匯入套件
import numpy as np
import pandas as pd
from sklearn.linear_model import LinearRegression

# 2. 設定來源資料
waist_height = np.array([[67,160],[68,165],[70,167],[65,170],[80,165],[85,167],[78,178],[79,182],[95,175],[89,172]])
weight = np.array([50,60,65,65,70,75,80,85,90,81])
x = pd.DataFrame(waist_height, columns=["Waist","Height"])
y = pd.DataFrame(weight, columns=["Weight"])

# 3. 建立模型
# 建立物件
lr = LinearRegression() 
# 呼叫 fit(解釋變數,反影變數) 函式訓練模型 (建模)
lr.fit(x,y)
# 取得物件屬性 (迴歸係數：coef_ , 截距：intercept_)
print("迴歸係數：", lr.coef_)
print("截距：", lr.intercept_)

# 4. 使用 predicted(新的解釋變數) 函式進行預測  (身高和腰圍 [66,164]&[82,172] 的業績) 
new_waist_height = pd.DataFrame(pd.DataFrame(np.array([[66,164],[82,172]]), columns=["Waist","Height"]))
predicted_weight = lr.predict(new_waist_height)
print("身高和腰圍 [66,164]&[82,172] 的業績預測結果：\n", predicted_weight)

# %%    資料集
# Scikits-learn 套件本身的 datasets 物件內建一些現成資料集
from sklearn import datasets
# 主要用於迴歸： botson, dialbetes
boston = datasets.load_boston()
dialbetes = datasets.load_diabetes()
# 主要用於分類： iris, digits
iris = datasets.load_iris()
digits = datasets.load_digits()
# 查看 (都是 utils.Bunch 型態，但表現手法與 dict 類似)
print(boston.keys())
print(dialbetes.keys())
print(iris.keys())
print(digits.keys())
# 顯示內容 (兩種方法)
print(boston.DESCR) # 特殊用法
print(boston["DESCR"])
# 直接顯示所有資料集資訊
print(boston)
print(boston)
# from sklearn.datasets import load_boston
# X, y = load_boston(return_X_y=True)

# %%    使用波士頓資料集預測房價
from sklearn import datasets
boston = datasets.load_boston()
print(boston.keys())
# 輸出資料的欄位與筆數
print(boston.data.shape)
# 查看資料的欄位名稱
print(boston.feature_names)
# 顯示完整描述合個欄位集的說明
print(boston.DESCR)

# 建立成 DataFrame 物件
import pandas as pd
x = pd.DataFrame(boston.data,columns=boston.feature_names)
print(x.head())
y = pd.DataFrame(boston.target,columns=["MEDV"])
print(y.head())

# 訓練模型
from sklearn.linear_model import LinearRegression
lm = LinearRegression().fit(x, y)
print("迴歸係數：", lm.coef_)
print("截距：", lm.intercept_)

# 建立特徵係數與欄位名稱 DataFrame 物件
coef = pd.DataFrame(boston.feature_names,columns=["features"])
# DataFrame 的新增資料與 dict 類似
coef["estimatedCoefficients"] = lm.coef_[0]
print(coef)

# 以最高正相關進行繪圖 (estimatedCoefficients ---> RM)
import matplotlib.pyplot as plt
plt.scatter(x.RM, y)
re_y = LinearRegression().fit(pd.DataFrame(x.RM), y).predict(pd.DataFrame(x.RM))
plt.plot(x.RM, re_y, "r")
plt.title("Relationship between RM and Price", fontsize=20)
plt.xlabel("Average number of rooms per dwelling (RM)", fontsize=14)
plt.ylabel("Housing Price (MEDV)", fontsize=14)
plt.show()
# 以最高負相關進行繪圖 (estimatedCoefficients ---> )

# 繪製預測房價與原來房價
predicted_price = lm.predict(x)
print(predicted_price[:5])
mask = y >= 50
plt.scatter(y, predicted_price)
plt.scatter(y[mask], predicted_price,color="red")
plt.title("Price VS Predicted Price", fontsize=20)
plt.xlabel("Price (Original)", fontsize=14)
plt.ylabel("Predicted Price (MEDV)", fontsize=14)
plt.show()

# %%    資料集分割 - 訓練(Training)和測試(Testing)資料集
from sklearn import datasets
import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
import matplotlib.pyplot as plt

boston = datasets.load_boston()
x = pd.DataFrame(boston.data,columns=boston.feature_names)
y = pd.DataFrame(boston.target,columns=["MEDV"])
# train_test_split： 隨機切割資料集 
# test_size： 測試資料的切割比例，0.33指測試資料集佔33%，訓練資料集佔67%
# random_state： 隨機數種子，指定亂數的種子數，為了保證每次隨機結果都是一樣的 
xTrain, xTest, yTrain, yTest = train_test_split(x,y,test_size=0.33, random_state=5)

lm = LinearRegression().fit(xTrain,yTrain)
pred_test = lm.predict(xTest)

plt.scatter(yTest, pred_test)
plt.title("Price VS Predicted Price", fontsize=20)
plt.xlabel("Price (Actual)", fontsize=14)
plt.ylabel("Predicted Price (MEDV)", fontsize=14)
plt.show()

# %%    預測模型的績效 (是否為好的模型)
# 最小化各資料點至迴歸線距離的總和
# 1. MSE (Mean Squared Error) ---> 0
#    (實際y-預測y)**2 取平均
# 2. R-Squared (R^2) ---> 1
#    1-(MSE/var) ==> score()

xTrain, xTest, yTrain, yTest = train_test_split(x,y,test_size=0.33, random_state=5)

lm = LinearRegression().fit(xTrain,yTrain)

pred_train = lm.predict(xTrain)
pred_test = lm.predict(xTest)
pred_price = LinearRegression().fit(x,y).predict(x)

import numpy as np
MSE_train = np.mean((yTrain-pred_train)**2)
MSE_test = np.mean((yTest-pred_test)**2)
MSE = np.mean((y-pred_price)**2)

print("訓練資料MSE：", MSE_train[0])
print("測試資料MSE：", MSE_test[0])
print("所有資料MSE：", MSE[0])
print("訓練資料R-Squared：", lm.score(xTrain,yTrain))
print("測試資料R-Squared：", lm.score(xTest,yTest))
print("所有資料R-Squared：", lm.score(x,y))
# 若用不同資料種子，績效差不多，則使用隨機將不影響結果

# %%    殘差圖

plt.scatter(pred_train, pred_train-yTrain, c="b", s=40, alpha=0.5, label="Training Data")
plt.scatter(pred_test, pred_test-yTest, c="r", s=40, alpha=0.8, label="Test Data")
plt.hlines(y=0, xmin=0, xmax=50)
# plt.hlines(y=np.std(pred_train-yTrain), xmin=0, xmax=50)
# plt.hlines(y=-np.std(pred_train-yTrain), xmin=0, xmax=50)
# plt.hlines(y=np.std(pred_test-yTest), xmin=0, xmax=50)
# plt.hlines(y=-np.std(pred_test-yTest), xmin=0, xmax=50)
plt.hlines(y=np.std(pred_test-yTest)*2, xmin=0, xmax=50)
plt.hlines(y=-np.std(pred_test-yTest)*2, xmin=0, xmax=50)
plt.title("Price Residual Plots", fontsize=20)
plt.xlabel("Price (Predicted)", fontsize=14)
plt.ylabel("Residual Value (Price)", fontsize=14)
plt.legend()
plt.show()

plt.scatter(yTrain, pred_train-yTrain, c="b", s=40, alpha=0.5, label="Training Data")
plt.scatter(yTest, pred_test-yTest, c="r", s=40, alpha=0.8, label="Test Data")
plt.hlines(y=0, xmin=0, xmax=50)
# plt.hlines(y=np.std(pred_train-yTrain), xmin=0, xmax=50)
# plt.hlines(y=-np.std(pred_train-yTrain), xmin=0, xmax=50)
# plt.hlines(y=np.std(pred_test-yTest), xmin=0, xmax=50)
# plt.hlines(y=-np.std(pred_test-yTest), xmin=0, xmax=50)
plt.hlines(y=np.std(pred_test-yTest)*2, xmin=0, xmax=50)
plt.hlines(y=-np.std(pred_test-yTest)*2, xmin=0, xmax=50)
plt.title("Price Residual Plots", fontsize=20)
plt.xlabel("Price (Actual)", fontsize=14)
plt.ylabel("Residual Value (Price)", fontsize=14)
plt.legend()
plt.show()
