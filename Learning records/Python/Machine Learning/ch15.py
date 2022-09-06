# 機器學習 - 分類

# 邏輯迴歸 (二元)
# 樹狀結構和決策樹 (多元)
# K 鄰近驗算法 ()

# %%    邏輯迴歸
import numpy as np
import matplotlib.pyplot as plt

t = np.arange(-6,6,0.1)
s = 1/(1+(np.e**(-t)))

plt.plot(t,s)
plt.title("sigmoid function")
plt.show()

# %%    邏輯迴歸 - 鐵達尼號
import pandas as pd
import numpy as np
from sklearn import preprocessing, linear_model # 預處理，線性模型

titanic = pd.read_csv("titanic.csv")
titanic.info()
# <class 'pandas.core.frame.DataFrame'>
# RangeIndex: 1313 entries, 0 to 1312
# Data columns (total 7 columns):
#  #   Column       Non-Null Count  Dtype  
# ---  ------       --------------  -----  
#  0   PassengerId  1313 non-null   int64  
#  1   Name         1313 non-null   object 
#  2   PClass       1313 non-null   object 
#  3   Age          756 non-null    float64
#  4   Sex          1313 non-null   object 
#  5   Survived     1313 non-null   int64  
#  6   SexCode      1313 non-null   int64  
# dtypes: float64(1), int64(3), object(3)
# memory usage: 71.9+ KB

# 缺失值處理
age_median = np.nanmedian(titanic["Age"])
print("\n年齡中位數：",age_median)
print("年齡中位數：",np.median(titanic["Age"]))
# where(T/F, T時填入, F時填入) <- 類似三元運算子
# isnull() -> nan
new_age = np.where(titanic["Age"].isnull(), age_median, titanic["Age"])
titanic["Age"] = new_age
print()
titanic.info()

# 轉換成數值欄位
label_encoder = preprocessing.LabelEncoder() # 標籤編碼器
encoded_class = label_encoder.fit_transform(titanic["PClass"])
# a  = label_encoder.fit_transform(titanic["Sex"])

# 訓練模型
x = pd.DataFrame([encoded_class, titanic["SexCode"], titanic["Age"]]).T # 等級 性別 年齡
y = titanic["Survived"] # 生S

logistic = linear_model.LogisticRegression()
logistic.fit(x, y)
print("\n迴歸係數：",logistic.coef_[0])
print("截距",logistic.intercept_)

# 線性的 0.5以上為T / 0.5以下為F

# logistic = linear_model.LinearRegression()
# logistic.fit(x, y)
# print("\n迴歸係數：",logistic.coef_)
# print("截距",logistic.intercept_)

# 混淆矩陣
preds = pd.DataFrame(logistic.predict(x),columns=["Predict"])
# pd.crosstab(真實,預測)
confusion = pd.crosstab(titanic["Survived"], preds["Predict"]) # 交叉表
print("\n混淆矩陣：\n", confusion)

# 準確度
print()
print((confusion.iloc[0,0]+confusion.iloc[1,1])/np.sum(confusion.values))
print("準確率",logistic.score(x, y))

x = pd.DataFrame([encoded_class, titanic["SexCode"]]).T # 等級 性別 年齡
y = titanic["Survived"] # 生S
logistic = linear_model.LogisticRegression()
logistic.fit(x, y)
# print("\n迴歸係數：",logistic.coef_[0])
# print("截距",logistic.intercept_)
# 混淆矩陣
preds = pd.DataFrame(logistic.predict(x),columns=["Predict"])
# pd.crosstab(真實,預測)
confusion = pd.crosstab(titanic["Survived"], preds["Predict"]) # 交叉表
print("\n混淆矩陣：\n", confusion)
# 準確度
print()
print((confusion.iloc[0,0]+confusion.iloc[1,1])/np.sum(confusion.values))
print(logistic.score(x, y))

# %%    樹狀結構和決策樹 - 鳶尾花
import pandas as pd
from sklearn import datasets, tree
from sklearn.model_selection import train_test_split

iris = datasets.load_iris()

print(iris.keys())
print(iris.data.shape)
print(iris.feature_names)
# 花萼 長/寬 花瓣 長/寬
# print(iris.DESCR)
"""
    :Summary Statistics:
    ============== ==== ==== ======= ===== ====================
                    Min  Max   Mean    SD   Class Correlation
    ============== ==== ==== ======= ===== ====================
    sepal length:   4.3  7.9   5.84   0.83    0.7826
    sepal width:    2.0  4.4   3.05   0.43   -0.4194
    petal length:   1.0  6.9   3.76   1.76    0.9490  (high!)
    petal width:    0.1  2.5   1.20   0.76    0.9565  (high!)
    ============== ==== ==== ======= ===== ====================
"""
print()
x = pd.DataFrame(iris.data, columns=iris.feature_names)
target = pd.DataFrame(iris.target, columns=["target"])
y = target["target"]

xTrain, xTest, yTrain, yTest = train_test_split(x, y, test_size=0.33, random_state=1)
# 建立決策樹分類器物件 (決定深度)
dtree = tree.DecisionTreeClassifier(max_depth=4)
dtree.fit(xTrain, yTrain)

print("準確率",dtree.score(xTest, yTest))
# print(dtree.predict(xTest))
# print(yTest.values)
# check = dtree.predict(xTest) == yTest.values
check = dtree.predict(x) == y.values
for i in range(len(check)):
    if check[i] == False:
        print(i)

# %%    K 鄰近驗算法 (KNN)
# 近朱者赤近墨者黑的分類概念
import pandas as pd
import numpy as np
from sklearn import neighbors

x = pd.DataFrame({
    "durability":[7,7,3,1],
    "strength":  [7,4,4,4]})
# 1 好 0 壞
y = np.array([0,0,1,1]) 
# 原則上用單數，避免平手選不出來
k = 3 

knn = neighbors.KNeighborsClassifier(n_neighbors=k)
knn.fit(x,y)

new_tissue = pd.DataFrame(np.array([[3,7]]))
pred = knn.predict(new_tissue)
print("評價為：",np.where(pred==0,"壞","好")[0])

# %%    K 鄰近驗算法 (KNN)
import numpy as np
import pandas as pd
from sklearn import datasets, neighbors
from sklearn.model_selection import train_test_split
import matplotlib.pyplot as plt

iris = datasets.load_iris()
# print(iris.feature_names)
# ['sepal length (cm)', 'sepal width (cm)', 'petal length (cm)', 'petal width (cm)']
x = pd.DataFrame(iris.data, columns=iris.feature_names)
target = pd.DataFrame(iris.target, columns=["target"])
y = target["target"]

colmap = np.array(["r","g","y"])
# plt.figure(figsize=(10,5))
plt.figure(figsize=(5,10))
# plt.subplot(1,2,1)
plt.subplot(2,1,1)
# plt.subplots_adjust(hspace=.5)
# plt.subplots_adjust(wspace=.5)
# plt.subplots_adjust(left=0.125,
#                     bottom=0.1, 
#                     right=0.9, 
#                     top=0.9, 
#                     wspace=0.2, 
#                     hspace=0.35)
plt.scatter(x["sepal length (cm)"], x["sepal width (cm)"], color=colmap[y])
plt.xlabel("sepal length (cm)")
plt.ylabel("sepal width (cm)")
# plt.subplot(1,2,2)
plt.subplot(2,1,2)
plt.subplots_adjust(hspace=(.5))
plt.scatter(x["petal length (cm)"], x["petal width (cm)"], color=colmap[y])
plt.xlabel("petal length (cm)")
plt.ylabel("petal width (cm)")
plt.show()


xTrain, xTest, yTrain, yTest = train_test_split(x, y, test_size=0.33, random_state=1)
k = 3 

knn = neighbors.KNeighborsClassifier(n_neighbors=k)
knn.fit(xTrain,yTrain)

print("準確率",knn.score(xTest, yTest))
# print(dtree.predict(xTest))
# print(yTest.values)
# check = dtree.predict(xTest) == yTest.values
check = knn.predict(x) == y.values
for i in range(len(check)):
    if check[i] == False:
        print(i)


