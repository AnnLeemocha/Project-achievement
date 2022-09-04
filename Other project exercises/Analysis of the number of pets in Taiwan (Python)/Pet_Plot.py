## read data
import pandas as pd
import numpy as np
from sklearn.linear_model import LinearRegression
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
# #  predict ========================== 1
# # LinearRegression 1999~2021 --- 2050
# year = pd.DataFrame(range(1998,2041)).values
# x = pd.DataFrame(pet.loc[dy:,"年份"]).values
# y = pd.DataFrame(pet_sum[dy:])
# xTrain, xTest, yTrain, yTest = train_test_split(x, y, test_size=0.2, random_state=10)
# lm_tt = LinearRegression().fit(xTrain, yTrain)
# lm = LinearRegression().fit(x, y)
# # pet_lm_predict = lm.predict(year) # 全部訓練
# pet_lm_predict_tt = lm_tt.predict(year)

# #  predict ========================== 2
# # https://accandrew2.pixnet.net/blog/post/359720873-python-%E8%AA%9E%E8%A8%80%E5%BB%BA%E7%AB%8B%E5%A4%9A%E9%A0%85%E5%BC%8F%E5%9B%9E%E6%AD%B8%28polynomial-regression%29%E6%A8%A1
# # LinearRegression 1999~2021 --- 2050 (二次方)
# poly = PolynomialFeatures(degree=2).fit(x)
# x_new = poly.transform(x) # 2次方
# xTrain2, xTest2, yTrain2, yTest2 = train_test_split(x_new, y, test_size=0.2, random_state=10)
# lm2_tt = LinearRegression().fit(xTrain2, yTrain2)
# lm2 = LinearRegression().fit(x_new, y)
# # pet_lm2_predict = lm2.predict(poly.transform(year)) # 全部訓練
# pet_lm2_predict_tt = lm2_tt.predict(poly.transform(year))

# #  predict ========================== 3
# # 2012~2020 (金錢，憂鬱`)
# # x_new = pd.DataFrame([data[0], data[1], income.loc[14:22, "月薪總平均"], index.loc[14:22, "總指數"]]).T
# x_new2 = pd.DataFrame([data[1], income.loc[14:22, "月薪總平均"], index.loc[14:22, "總指數"]]).T
# ss = StandardScaler().fit(x_new2)
# x_new2 = ss.transform(x_new2)
# xTrain3, xTest3, yTrain3, yTest3 = train_test_split(x_new2, y.loc[13:21], test_size=0.2, random_state=10)
# lm3_tt = LinearRegression().fit(x_new2, y.loc[13:21])
# lm3 = LinearRegression().fit(x_new2, y.loc[13:21])
# # pet_lm3_predict = lm3.predict(year) # 無未來其他值
# # pet_lm3_predict = lm3.predict(x_new2) # 全部訓練
# pet_lm3_predict_tt = lm3_tt.predict(x_new2)

# #%% 得分 - 20% 測試資料
# print("================================================")
# model = [lm_tt,lm2_tt,lm3_tt]
# x_inp = [xTest, xTest2, xTest3]
# y_inp = [yTest, yTest2, yTest3]
# name_inp = ["線性", "二次", "多元"]
# for i in range(3):
#     print(name_inp[i],"(回歸係數):", model[i].coef_)
#     print(name_inp[i],"(截距):", model[i].intercept_)
#     # print(name_inp[i],"(R^2):", model[i].score(x_inp[i], y_inp[i]))
#     print(name_inp[i],"(R^2):", metrics.r2_score(y_inp[i],model[i].predict(x_inp[i])))
#     print(name_inp[i],"(MSE):", metrics.mean_squared_error(y_inp[i],model[i].predict(x_inp[i])))
#     print(name_inp[i],"(RMSE):", (metrics.mean_squared_error(y_inp[i],model[i].predict(x_inp[i])))**0.5)
#     print(name_inp[i],"(MAE):", metrics.mean_absolute_error(y_inp[i],model[i].predict(x_inp[i])))
#     print(name_inp[i],"(MAPE):", metrics.mean_absolute_percentage_error(y_inp[i],model[i].predict(x_inp[i])))
#     print("================================================")
    
#==============================================================================
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

#%%  ##### 1 #####
plt.title("寵物登記數量 VS 出生人口數", fontsize=18)
plt.plot(pet["年份"], pet["登記數"]/10000, label="寵物登記數")
plt.plot(pet["年份"], pet["除戶數"]/10000, label="寵物除戶數")
plt.plot(range(1998,1998+len(born.iloc[1])-2), born.iloc[1, 2:]/10000, label="出生人數")
# 交點
point = cross_point([2017,pet["登記數"].iloc[19],2018,pet["登記數"].iloc[20]],[2017,born.loc[1,"2017"],2018,born.loc[1,"2018"]])
# 標記
# plt.vlines(point[0], 0, 50,color="k",linestyles="--")
point[1] = point[1]/10000
text = "年份: {:.0f}  \n數量: {:.1f}萬".format(point[0], point[1])
plt.annotate(text, # 標記文字
             point,  # 點的位置
             textcoords="offset points",  # 先對於點的距離
             xytext=(0,25), # 文字雨點的相對關係
             ha="center", # 置中
             fontsize=10,
             arrowprops=dict(arrowstyle="->",
                             color="red",
                             lw=3,
                             ls="-"))
plt.axis([1998,2020,0,50])
plt.xticks(pet["年份"], rotation=-45)
plt.xlabel("年份", fontsize=font)
plt.ylabel("數量 (萬)", fontsize=font)
plt.grid(axis="y")
# 存取圖例被切處理
lg = plt.legend(bbox_to_anchor=(1.35,1), fontsize=font)
# plt.tight_layout()
plt.savefig("./figure/Pet_plot_1.png", dpi=120, bbox_extra_artists=(lg,), bbox_inches="tight")
plt.show()

#%%  ##### 2 #####
plt.title("寵物累計數量 VS 小於15歲人數", fontsize=18)
plt.plot(pet["年份"], np.array(pet_sum_o)/10000, "--", label="寵物隻數(未除戶)")
plt.plot(pet["年份"], np.array(pet_sum)/10000, label="寵物隻數(除戶)")
plt.plot(range(1998,1998+len(population.iloc[0])-1), population.iloc[0,1:]*1000/10000, label="<15歲人數")
# plt.vlines(2018.3, 0, 5000000,color="k",linestyles="--")
point = cross_point([2018,pet_sum_o[20],2019,pet_sum_o[21]],[2018,population.loc[0,2018],2019,population.loc[0,2019]])
plt.axis([1998,2020,0,500])
plt.xticks(pet["年份"], rotation=-45)
plt.grid(axis="y")
plt.xlabel("年份", fontsize=font)
plt.ylabel("數量 (萬)", fontsize=font)
plt.legend(loc="center left", fontsize=font)
plt.tight_layout()
plt.savefig("./figure/Pet_plot_3.png", dpi=120)
plt.show()

#%%  ##### 3 #####
# # ===== train_test_split =====
# plt.title("寵物數量未來推估", fontsize=18)
# plt.broken_barh([(2021, 2040)], (0, 500), facecolors='tab:pink', alpha=0.2)
# plt.plot(range(1998,1998+len(population.iloc[0])-1), population.iloc[0,1:]*1000/10000, label="<15歲人數")
# plt.plot(year, pet_lm_predict_tt/10000, label="寵物隻數(線性回歸)")
# plt.plot(year, pet_lm2_predict_tt/10000, label="寵物隻數(二次回歸)")
# # plt.plot(range(2012,2021), pet_lm3_predict, label="多元回歸", color="k")
# plt.scatter(pet["年份"], np.array(pet_sum)/10000, label="原始寵物隻數(除戶)", s=15, c="k")
# # plt.scatter(pet["年份"], np.array(pet_sum_o)/10000, label="寵物隻數(未除戶)", s=15, c="r")
# # plt.vlines(2021, 0, 5000000,color="k",linestyles="--")
# point = cross_point([2032,pet_lm_predict_tt[34][0],2033,pet_lm_predict_tt[35][0]],[2032,population.loc[0,2032]*1000,2033,population.loc[0,2033]*1000])
# point[1] = point[1]/10000
# text = "年份: {:.0f}  \n數量: {:.1f}萬".format(point[0], point[1])
# plt.annotate(text, # 標記文字
#              point,  # 點的位置
#              textcoords="offset points",  # 先對於點的距離
#              xytext=(0,-50), # 文字雨點的相對關係
#              ha="center", # 置中
#              fontsize=10,             
#              arrowprops=dict(arrowstyle="->",
#                              color="red",
#                              lw=3,
#                              ls="-"))
# point = cross_point([2023,pet_lm2_predict_tt[25][0],2024,pet_lm2_predict_tt[26][0]],[2023,population.loc[0,2023]*1000,2024,population.loc[0,2024]*1000])
# point[1] = point[1]/10000
# text = "年份: {:.0f}  \n數量: {:.1f}萬".format(point[0], point[1])
# plt.annotate(text, # 標記文字
#              point,  # 點的位置
#              textcoords="offset points",  # 先對於點的距離
#              xytext=(-15,25), # 文字雨點的相對關係
#              ha="center", # 置中
#              fontsize=10,
#              arrowprops=dict(arrowstyle="->",
#                              color="red",
#                              lw=3,
#                              ls="-"))
# plt.axis([1998,2040,0,500])
# # plt.grid()
# plt.xlabel("年份", fontsize=font)
# plt.ylabel("數量 (萬)", fontsize=font)
# plt.legend(loc="center left", fontsize=9)
# plt.savefig("./figure/Pet_plot_4(1).png", dpi=120)
# plt.show()

#%%  ##### 4 #####
plt.rcParams["axes.unicode_minus"] = False
fig, ax1 = plt.subplots()
plt.title("月薪總平均 VS 消費者物價指數", fontsize=18)
a = "%.2f"%LinearRegression().fit(pd.DataFrame(income["年份"]), income["月薪總平均"]/10000).coef_
lns1 = ax1.plot(income["年份"], income["月薪總平均"]/10000, label=f"平均月薪斜率：{a}", color="tab:red")
ax1.tick_params(axis="y", labelcolor="tab:red")
ax1.set_ylabel("月薪總平均 (萬元)", color="tab:red", fontsize=font)
ax1.set_xlabel("年份", fontsize=font)
ax2 = ax1.twinx()
a = "%.2f"%LinearRegression().fit(pd.DataFrame(index["統計期"]), index["總指數"]).coef_
lns2 = ax2.plot(index["統計期"], index["總指數"], label=f"消費者物價指數斜率：{a}", color="tab:blue")
ax2.tick_params(axis="y", labelcolor="tab:blue")
ax2.set_ylabel("消費者物價指數 (基準：2016年)", color="tab:blue", rotation=270, labelpad=15, fontsize=font)
ax1.axis([1998,2021,4.4,5.9])
ax2.axis([1998,2021,80,105])
# ax1.grid(axis="y")
# lns = lns1+lns2
# lab = [i.get_label() for i in lns]
# plt.legend(lns, lab)
# plt.legend(loc="upper left")
plt.savefig("./figure/Pet_plot_5.png", dpi=120)
plt.show()

# %% ##### 5 #####
import re
width = 0.1
plt.suptitle("")
plt.subplot(2,2,1)
x = np.array(list(range(2008,2013)))-0.3
# x = sale6["統計期"]-0.3
a = 0
for i in range(0,len(sale6),5):
    plt.bar(x+a, sale6["<b>家數總計</b>"][i:i+5], width, label=re.findall("[^0-9-]+",sale6["行業別"][i])[0])
    a += width
plt.ylabel("2008~2012年", fontsize=font)
plt.title("家數", fontsize=font)
# plt.legend(bbox_to_anchor=(1.05,1))
# plt.show()
plt.subplot(2,2,2)
a = 0
for i in range(0,len(sale6),5):
    plt.bar(x+a, sale6["<b>銷售額總計</b>"][i:i+5]/10000, width, label=re.findall("[^0-9-]+",sale6["行業別"][i])[0])
    a += width
plt.title("銷售額 (萬元)", fontsize=font)
plt.legend(bbox_to_anchor=(1.05,1.1))
# plt.show()

plt.subplot(2,2,3)
x = np.array(list(range(2013,2018)))-0.3
a = 0
for i in range(0,len(sale7),5):
    plt.bar(x+a, sale7["<b>家數總計</b>"][i:i+5], width, label=re.findall("[^0-9-]+",sale7["行業別"][i])[0])
    a += width
plt.ylabel("2013~2018年", fontsize=font)
# plt.legend(bbox_to_anchor=(1.05,1))
# plt.show()
plt.subplot(2,2,4)
a = 0
for i in range(0,len(sale7),5):
    plt.bar(x+a, sale7["<b>銷售額總計</b>"][i:i+5]/10000, width, label=re.findall("[^0-9-]+",sale7["行業別"][i])[0])
    a += width
lg = plt.legend(bbox_to_anchor=(1.05,1.1))
plt.savefig("./figure/Pet_plot_6.png", dpi=120, bbox_extra_artists=(lg,), bbox_inches="tight")
plt.show()

# %%  ##### 8 #####
width = 0.1
plt.suptitle("每年平均花費在寵物上的金額", fontsize=18)
plt.subplots_adjust(top=0.83)
plt.subplot(2,1,1)
x = np.array(list(range(2008,2013)))-0.3
a = 0
b = []
c = pet_minus[10:15].tolist()*6
for i in range(30):#
    b.append(sale6["<b>銷售額總計</b>"][i]/c[i])
# b = (sale6["<b>銷售額總計</b>"]/pd.DataFrame(pet_minus[10:15].tolist()*6)).dropna(axis=1)
for i in range(0,30,5):
    # print(b[i:i+5])
    plt.bar(x+a, b[i:i+5], width=width, label=re.findall("[^0-9-]+", sale6["行業別"][i])[0])
    a += width
plt.ylabel("2008~2013年", fontsize=font)
plt.title("銷售額 (萬元) / 寵物數量 (隻)", fontsize=font)
plt.ylim(0, 200)
# plt.axis([2008,2013,0,10])
plt.legend(bbox_to_anchor=(1.05,1.1))
plt.subplot(2,1,2)
x = np.array(list(range(2013,2018)))-0.3
a = 0
b = []
c = pet_minus[15:20].tolist()*7
for i in range(35):#
    b.append(sale7["<b>銷售額總計</b>"][i]/c[i])
for i in range(0,35,5):
    plt.bar(x+a, b[i:i+5], width=width, label=re.findall("[^0-9-]+", sale7["行業別"][i])[0])
    a += width
plt.ylim(0, 200)
plt.ylabel("2013~2018年", fontsize=font)
plt.xlabel("年份", fontsize=font)
lg = plt.legend(bbox_to_anchor=(1.05,1.1))
# plt.savefig("./figure/Pet_plot_7.png", dpi=120)
plt.savefig("./figure/Pet_plot_7.png", dpi=120, bbox_extra_artists=(lg,), bbox_inches="tight")
plt.show()

# %%  ##### 9 #####
a = 0
b = 2013
for i in range(len(pet_dog)):
    # print(i+2013)
    plt.title(f"{b}年各縣市家貓/犬數量分布", fontsize=18)
    x = np.array(list(range(len(pet_dog[i])-1)))-0.3
    # a = pd.DataFrame(pet_dog[i].iloc[:-1])/10000
    # plt.bar(x, a, 0.4, label="家犬")
    plt.bar(x, pet_dog[i].iloc[:-1]/10000, 0.4, label="家犬")
    plt.bar(x+0.4, pet_cat[i].iloc[:-1]/10000, 0.4, label="家貓")
    plt.xticks(x, pet_dog[i].index[:-1], rotation=-45)
    plt.xlabel("縣市別", fontsize=font)
    plt.ylabel("萬隻", fontsize=font)
    plt.ylim(0,30)
    plt.legend()
    plt.savefig(f"./figure/Pet_plot_8({a}).png", dpi=120)
    a += 1
    b += 2
    plt.show()

# %%  ##### 10 #####
plt.title("家貓/犬數量時序圖", fontsize=18)
inp = pd.DataFrame([i.iloc[-1]/10000 for i in pet_dog])
plt.plot([2013,2015,2017,2019,2021],inp.values, label="家犬")
inp = pd.DataFrame([i.iloc[-1]/10000 for i in pet_cat])
plt.plot([2013,2015,2017,2019,2021],inp.values, label="家貓")
inp = pd.DataFrame([i.iloc[-1]/10000 for i in pet_cat]) + pd.DataFrame([i.iloc[-1]/10000 for i in pet_dog])
plt.plot([2013,2015,2017,2019,2021],inp.values, label="家犬+家貓")
plt.plot(data[0], np.array(data[1])/10000,"--", label="憂鬱症")
plt.axis([2013,2021,50,310])
plt.xlabel("年份", fontsize=font)
plt.ylabel("萬隻/萬人", fontsize=font)
plt.legend()
plt.savefig("./figure/Pet_plot_9.png", dpi=120)
plt.show()

# %%  ##### 11 #####
plt.suptitle("每年飼養貓與狗數量分布", fontsize=18)
plt.subplots_adjust(top=0.82)
b = 2013
for i in range(len(pet_dog)):
    plt.subplot(2,3,i+1)
    plt.title(f"{b}", fontsize=font)
    plt.pie([pet_dog[i].iloc[-1], pet_cat[i].iloc[-1]], labels=["家犬","家貓"], autopct="%d%%", textprops={"fontsize":12})
    b += 2
plt.savefig("./figure/Pet_plot_10.png", dpi=120, transparent=True)
plt.show()
