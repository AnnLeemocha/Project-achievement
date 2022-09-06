# 機器學習 - 分群

# 無標籤答案進行分類
# 照理說分類比分群好，但相反情況也有，就是難說明分析

# K-means
# 1. 設定群數 K=? ， 隨機在資料集中給 K 點
# 2. 資料到點的距離分類
# 3. 各類重心點
# 4. 重新進行資料到點的距離分類
# 5. 3. & 4. 蝶帶至收斂 (不動 OR 變化小)

# DBSCAN 

# %%    K-means 分群
import pandas as pd
import numpy as np
from sklearn import cluster
import matplotlib.pyplot as plt

df = pd.DataFrame({
    "lengh":  [51,46,51,45,51,50,33,38,37,33,33,21,23,24],
    "weight": [10.2,8.8,8.1,7.7,9.8,7.2,4.8,4.6,3.5,3.3,4.3,2.0,1.0,2.0]})
k = 3

kmeans = cluster.KMeans(n_clusters=k, random_state=12)
kmeans.fit(df)
print(kmeans.labels_)

colmap = np.array(["r","g","y"])
plt.scatter(df["lengh"], df["weight"], color=colmap[kmeans.labels_])
plt.show()

# %%    K-means 鳶尾花
import pandas as pd
import numpy as np
from sklearn import cluster, datasets
import matplotlib.pyplot as plt
import sklearn.metrics as ms

iris = datasets.load_iris()

x = pd.DataFrame(iris.data, columns=iris.feature_names)
y = iris.target
k = 3

kmeans = cluster.KMeans(n_clusters=k, random_state=12)
kmeans.fit(x)

colmap = np.array(["r","g","y"])
plt.figure(figsize=(10,5))
plt.subplot(1,2,1)
plt.scatter(x["petal length (cm)"], x["petal width (cm)"], color=colmap[y])
plt.xlabel("petal length (cm)")
plt.ylabel("petal width (cm)")
plt.title("Real Classification")
plt.subplot(1,2,2)
plt.scatter(x["petal length (cm)"], x["petal width (cm)"], color=colmap[kmeans.labels_])
plt.xlabel("petal length (cm)")
plt.ylabel("petal width (cm)")
plt.title("K-means Classification")
plt.show()

# 注意標籤要改成一致
# preds = kmeans.labels_ #np.choose(kmeans.labels_, [2,0,1])
preds = np.choose(kmeans.labels_, [2,0,1])
print("K-means Classification")
print(kmeans.labels_)
print("K-means Fix Classification")
print(preds)
print("Real Classification")
print(y)

colmap = np.array(["r","g","y"])
plt.figure(figsize=(10,5))
plt.subplot(1,2,1)
plt.scatter(x["petal length (cm)"], x["petal width (cm)"], color=colmap[y])
plt.xlabel("petal length (cm)")
plt.ylabel("petal width (cm)")
plt.title("Real Classification")
plt.subplot(1,2,2)
plt.scatter(x["petal length (cm)"], x["petal width (cm)"], color=colmap[preds])
plt.xlabel("petal length (cm)")
plt.ylabel("petal width (cm)")
plt.title("K-means Classification")
plt.show()

for i in range(len(y)):
    if (y[i] == preds[i]) == False:
        print(f"index {i} 預測錯誤： 原{y[i]}  預{preds[i]}")

print(ms.accuracy_score(y, preds))
print("Real\Predict",ms.confusion_matrix(y, preds))

# %%    DBSCAN 分群
from sklearn.cluster import DBSCAN
import numpy as np

# y = [[2,3],[3,4],[4,5],[18.71],[19,73],[20,67],[125,180]]

x = np.array([[2,3], [3,4], [4,5], [18,71], [19,73], [20,67], [125,180]])
clustering = DBSCAN(eps=3, min_samples=2)
clustering.fit(x)
preds = clustering.labels_
print(preds)
# [ 0  0  0  1  1 -1 -1]
# -1 為離群值
print(f"共分為{max(preds)+1}群")
print("離群值數量：",preds.tolist().count(-1))
# print(preds) # 離群值數量
