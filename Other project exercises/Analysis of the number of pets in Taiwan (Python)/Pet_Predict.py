## read data
import pandas as pd
import numpy as np
from sklearn.linear_model import LinearRegression # , Ridge, Lasso
from sklearn.preprocessing import PolynomialFeatures # 多項式特徵
import xml.etree.ElementTree as ET
from sklearn.preprocessing import StandardScaler
from sklearn import metrics
from sklearn.model_selection import train_test_split
dy = 1 # 去除開頭幾年
#==============================================================================
#%% 1. pet.csv
pet = pd.read_csv("./data/pet.csv")
pet_minus = pet["登記數"]-pet["除戶數"]
pet_sum_o = []
a = 0
for i in pet["登記數"]:
    a += i
    pet_sum_o.append(a)
pet_sum = []
a = 0
for i in pet_minus:
    a += i
    pet_sum.append(a)
    
#%% 2. 出生人口
born = pd.read_csv("./data/出生人數.csv", skiprows=6, thousands=",")
born = born.iloc[:3,:-1]
a = [str(i) for i in list(range(1960,1998))]
born = born.drop(columns=a)

#%% 3. 三階段年齡人口
population = pd.read_excel("./data/三階段年齡人口.xlsx", skiprows=5, thousands=",")
population = population.iloc[:3,1:]
a = list(range(1960,1998))
population = population.drop(columns=a)

#%% 4. 消費者物價基本分類指數
index = pd.read_csv(r"./data/消費者物價基本分類指數.csv", skiprows=2, usecols=[0,1])
index = index.dropna()
index["統計期"] = index["統計期"].str.replace("年","").astype(int)+1911

#%% 5. 平均薪資
income = pd.read_excel(r"./data/平均薪資.xlsx", thousands=",")
income["月薪總平均"] = income.mean(axis=1, numeric_only=True, skipna=True)
income["年份"] = income["年份"].str.replace("年","").astype(int)+1911
income = income[["年份","月薪總平均"]]

#%% 6. 銷售額與家數 (六) (七)
sale6 = pd.read_csv(r"./data/營利事業家數及銷售額－第6次修訂.csv", encoding=("ANSI"))
sale6.dropna(inplace=True)
sale6["統計期"] = sale6["統計期"].str.replace("年","").astype(int)+1911
sale6.sort_values(["行業別","統計期"], inplace=True)
sale6.replace("(D)", np.nan, inplace=True)
sale6.dropna(inplace=True)
sale6.reset_index(drop=True, inplace=True)
sale6["<b>家數總計</b>"] = sale6["<b>家數總計</b>"].astype(int)
sale6["<b>銷售額總計</b>"] = sale6["<b>銷售額總計</b>"].astype(int)
sale7 = pd.read_csv(r"./data/營利事業家數及銷售額－第7次修訂.csv", encoding=("ANSI"))
sale7.dropna(inplace=True)
sale7["統計期"] = sale7["統計期"].str.replace("年","").astype(int)+1911
sale7.sort_values(["行業別","統計期"], inplace=True)
sale7.replace("(D)", np.nan, inplace=True)
sale7.replace("－", np.nan, inplace=True)
sale7.dropna(inplace=True)
sale7.reset_index(drop=True, inplace=True)
sale7["<b>家數總計</b>"] = sale7["<b>家數總計</b>"].astype(int)
sale7["<b>銷售額總計</b>"] = sale7["<b>銷售額總計</b>"].astype(int)

#%% 7. 抗憂鬱藥物使用人數統計─按縣市別分.XML
tree = ET.ElementTree(file="./data/抗憂鬱藥物使用人數統計─按縣市別分.XML")
root = tree.getroot()
data = [[],[]]
for inp in root.findall("DataTable"):
    if "總計" == inp.find("Category1Title").text:
        data[0].append(int(int(inp.find("Period").text)/100+1911))
        data[1].append(float(inp.find("Val").text))
        # print(int(int(inp.find("Period").text)/100+1911))
        # print(inp.find("Val").text)

#%% 8. Pet_2013 2015 2017 2021 家貓與家狗
import glob #, os
pet_cat = []
pet_dog = []
# for i in os.listdir("data"):
#     print(i)
for i in glob.glob("data/Pet_*.csv"):
    # print(os.path.join(os.getcwd(),i))
    # print(i[9:13])
    a = pd.read_csv(i, encoding=("utf-8"), thousands=",")
    # a.info()
    if i[9:13] == "2021":
        pet_t = a["縣市別"].tolist()
    #     print(pet_t)
    a.index = a["縣市別"]
    a.drop(["縣市別"], axis=1, inplace=True)
    a.columns = [i[9:13],i[9:13]]
    pet_dog.append(a.iloc[:,0])
    pet_cat.append(a.iloc[:,1])
    

#%% predict
#  predict ========================== 1
# LinearRegression 1999~2021 --- 2050
year = pd.DataFrame(range(1998,2041)).values
x = pd.DataFrame(pet.loc[dy:,"年份"]).values
y = pd.DataFrame(pet_sum[dy:])
xTrain, xTest, yTrain, yTest = train_test_split(x, y, test_size=0.25, random_state=100)
lm_tt = LinearRegression(positive=True).fit(xTrain, yTrain) # 非負
pet_lm_predict_tt = lm_tt.predict(year)

#  predict ========================== 2
# https://accandrew2.pixnet.net/blog/post/359720873-python-%E8%AA%9E%E8%A8%80%E5%BB%BA%E7%AB%8B%E5%A4%9A%E9%A0%85%E5%BC%8F%E5%9B%9E%E6%AD%B8%28polynomial-regression%29%E6%A8%A1
# LinearRegression 1999~2021 --- 2050 (二次方)
poly = PolynomialFeatures(degree=2).fit(xTrain) # 2次方
x_new = poly.transform(xTrain)
lm2_tt = LinearRegression().fit(x_new, yTrain)
pet_lm2_predict_tt = lm2_tt.predict(poly.transform(year))
# from sklearn.pipeline import make_pipeline
# lm4_tt = make_pipeline(PolynomialFeatures(degree=2), LinearRegression()).fit(xTrain, yTrain)
# pet_lm4_predict_tt = lm4_tt.predict(year)
# pet_lm2_predict_tt = lm2_tt.predict(year)

#  predict ========================== 3
# 2012~2020 (金錢，憂鬱`)
# 無未來預測，直接訓練全部
x_new2 = pd.DataFrame([data[1], income.loc[14:22, "月薪總平均"], index.loc[14:22, "總指數"]]).T
ss = StandardScaler().fit(x_new2)
x_new2 = ss.transform(x_new2)
lm3_tt = LinearRegression().fit(x_new2, y.loc[14-dy:22-dy])
pet_lm3_predict_tt = lm3_tt.predict(x_new2)

#%% 得分 - 20% 測試資料
print("================================================")
model = [lm_tt,lm2_tt,lm3_tt]
x_inp = [xTest, poly.transform(xTest), x_new2]
y_inp = [yTest, yTest, y.loc[14-dy:22-dy]]
# x_inp = [xTest, xTest2, xTest3]
# y_inp = [yTest, yTest2, yTest3]
name_inp = ["線性", "二次", "多元"]
for i in range(3):
    print(f"【{name_inp[i]}回歸】")
    print("    回歸係數  ：", model[i].coef_[0])
    print("    截距      ：", model[i].intercept_)
    print("    R-Squared：", metrics.r2_score(y_inp[i], model[i].predict(x_inp[i])))
    print("    MSE      ：", metrics.mean_squared_error(y_inp[i], model[i].predict(x_inp[i]))) # , multioutput='raw_values'))
    print("    RMSE     ：", (metrics.mean_squared_error(y_inp[i], model[i].predict(x_inp[i])))**0.5)
    print("    MAE      ：", metrics.mean_absolute_error(y_inp[i], model[i].predict(x_inp[i])))
    print("    MAPE     ：", metrics.mean_absolute_percentage_error(y_inp[i], model[i].predict(x_inp[i])))
    print("================================================")
    
print("二次(訓練)","(R^2):", metrics.r2_score(yTrain,lm2_tt.predict(poly.transform(xTrain))))
# Root Mean Square Error (RMSE)：
# Mean Absolute Error (MAE)：
# Mean Absolute Percentage Error (MAPE)：

# print(np.mean(abs(yTest-lm2_tt.predict(poly.transform(xTest)))))
# print(np.mean((yTest-lm2_tt.predict(poly.transform(xTest)))**2)**0.5)

# %% function
# 兩嚼鍵的交點計算 (應有更好的方法)
def cross_point(line1,line2):
    #取四點座標
    x1=line1[0]; y1=line1[1]; x2=line1[2]; y2=line1[3]
    x3=line2[0]; y3=line2[1]; x4=line2[2]; y4=line2[3]
    
    k1=(y2-y1)*1.0/(x2-x1) # 計算k1,避免點均爲整數，需要進行浮點數轉化
    b1=y1*1.0-x1*k1*1.0    # 整型轉浮點型是關鍵
    if (x4-x3)==0:         # L2直線斜率不存在操作
        k2=None
        b2=0
    else:
        k2=(y4-y3)*1.0/(x4-x3)#斜率存在操作
        b2=y3*1.0-x3*k2*1.0
    if k2==None:
        x=x3
    else:
        x=(b2-b1)*1.0/(k1-k2)
        # if (min([x1,x2]) >= x) | (x >= max([x1,x2])):
        #     return None
    y=k1*x*1.0+b1*1.0
    return [x,y]

# %% figure
import matplotlib.pyplot as plt
import matplotlib.font_manager as fm
# 中文設定
plt.rcParams["font.family"] = "Microsoft JhengHei" # 微軟正黑體
# plt.rcParams["font.size"] = 20
# 負號設定
font_path = "C:\Windows\Fonts\msjh.ttc"
font_prop = fm.FontProperties(fname=font_path)
# 字型大小設定
font = 12

#%%  ##### 3 #####
# ===== train_test_split =====
plt.title("寵物數量未來推估", fontsize=18)
plt.broken_barh([(2021, 2040)], (0, 500), facecolors='tab:pink', alpha=0.2)
plt.plot(range(1998,1998+len(population.iloc[0])-1), population.iloc[0,1:]*1000/10000, label="<15歲人數")
plt.plot(year, pet_lm_predict_tt/10000, label="寵物隻數(線性回歸)")
plt.plot(year, pet_lm2_predict_tt/10000, label="寵物隻數(二次回歸)")
# plt.plot(range(2012,2021), pet_lm3_predict_tt/10000, label="多元回歸")#, color="k")
plt.scatter(pet["年份"], np.array(pet_sum)/10000, label="原始寵物隻數(除戶)", s=15, c="k")
plt.scatter(xTest, yTest/10000, label="測試點", s=15, c="r")
# plt.scatter(pet["年份"], np.array(pet_sum_o)/10000, label="寵物隻數(未除戶)", s=15, c="r")
# plt.vlines(2021, 0, 5000000,color="k",linestyles="--")
point = cross_point([2032,pet_lm_predict_tt[34][0],2033,pet_lm_predict_tt[35][0]],[2032,population.loc[0,2032]*1000,2033,population.loc[0,2033]*1000])
point[1] = point[1]/10000
text = "年份: {:.0f}  \n數量: {:.1f}萬".format(point[0], point[1])
plt.annotate(text, # 標記文字
             point,  # 點的位置
             textcoords="offset points",  # 先對於點的距離
             xytext=(0,-50), # 文字雨點的相對關係
             ha="center", # 置中
             fontsize=10,             
             arrowprops=dict(arrowstyle="->",
                             color="red",
                             lw=3,
                             ls="-"))
point = cross_point([2023,pet_lm2_predict_tt[25][0],2024,pet_lm2_predict_tt[26][0]],[2023,population.loc[0,2023]*1000,2024,population.loc[0,2024]*1000])
point[1] = point[1]/10000
text = "年份: {:.0f}  \n數量: {:.1f}萬".format(point[0], point[1])
plt.annotate(text, # 標記文字
             point,  # 點的位置
             textcoords="offset points",  # 先對於點的距離
             xytext=(-15,25), # 文字雨點的相對關係
             ha="center", # 置中
             fontsize=10,
             arrowprops=dict(arrowstyle="->",
                             color="red",
                             lw=3,
                             ls="-"))
plt.axis([1998,2040,0,500])
# plt.grid()
plt.xlabel("年份", fontsize=font)
plt.ylabel("數量 (萬)", fontsize=font)
plt.legend(loc="center left", fontsize=9)
plt.savefig("./figure/Pet_plot_4(2).png", dpi=120)
plt.show()

# %% 多元
t = f'''
R-Squared：{metrics.r2_score(y.loc[14-dy:22-dy], lm3_tt.predict(x_new2)):.3f}
RMSE：{(metrics.mean_squared_error(y.loc[14-dy:22-dy], lm3_tt.predict(x_new2)))**0.5:.3f}
MAPE：{metrics.mean_absolute_percentage_error(y.loc[14-dy:22-dy], lm3_tt.predict(x_new2)):.3f}

Regression coefficients：
         {lm3_tt.coef_[0][0]:.2f}  (抗憂鬱症藥物人數)
         {lm3_tt.coef_[0][1]:.2f}  (總平均月薪)
         {lm3_tt.coef_[0][2]:.2f}    (消費者物價指數)
'''
# print(t)
fig, ax = plt.subplots()
plt.title("多元回歸結果 (全部資料訓練)", fontsize=18)
plt.plot(range(2012,2021), pet_lm3_predict_tt/10000, label="多元回歸", color="red")
plt.scatter(pet["年份"], np.array(pet_sum)/10000, label="原始寵物隻數(除戶)", s=15, c="k")
plt.axis([1998,2021,0,200])
ax.text(2000, 50, t, color="red")
# plt.grid()
plt.xlabel("年份", fontsize=font)
plt.ylabel("數量 (萬)", fontsize=font)
plt.legend(loc="upper left", fontsize=9)
plt.savefig("./figure/Pet_plot_11.png", dpi=120)
plt.show()


# %% 二次
# plt.title("線性回歸結果", fontsize=18)
# plt.plot(year, pet_lm2_predict_tt/10000, label="二次回歸")#, color="k")
# # plt.plot(year, pet_lm4_predict_tt/10000, label="二次2回歸")#, color="k")
# plt.plot(year, pet_lm_predict_tt/10000, label="線性回歸")
# plt.scatter(pet["年份"], np.array(pet_sum)/10000, label="原始寵物隻數(除戶)", s=15, c="k")
# plt.scatter(xTest, yTest/10000, label="測試點", s=15, c="r")
# plt.axis([1998,2021,0,200])
# # plt.grid()
# plt.xlabel("年份", fontsize=font)
# plt.ylabel("數量 (萬)", fontsize=font)
# plt.legend(loc="upper left", fontsize=9)
# plt.show()