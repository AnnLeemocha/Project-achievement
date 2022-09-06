# XML 檔案讀寫

# %%    XML 檔案讀取
"""
<menu>
    <breakfast hours="7-11">
        <item price="$50">cakes</item>
        <item price="$60">tea</item>
    </breakfast>
    <lunch hours="11-3">
        <item price="$70">hamburger</item>
    </lunch>
    <dinner hours="3-10">
        <item price="$90">fries</item>
    </dinner>
</menu>
"""
# 匯入所需套件
import xml.etree.ElementTree as ET
# 利用套件中的 ElementTree 函式讀取 menu.xml 檔案，取得 tree 物件
tree = ET.ElementTree(file="menu.xml")
# 利用 tree 物件的 getroot() 函式取得 root 物件 (找(移動)到根目錄)
root = tree.getroot()
# 輸出 root 物件的 tag 屬性 (得到 menu )
print('根目錄標籤名稱:')
print(root.tag); print()
# 使用迴圈尋找 root 物件的 child 子節點，並輸出 tag 與 attrib 屬性
for child in root:
    print("Tag:",child.tag,"Attributes:",child.attrib)
# 使用迴圈尋找 child 節點的 grandchild 子節點(孫節點)，並輸出 tag 與 attrib 屬性
    for grandchild in child:
        print("\t  Tag:",grandchild.tag,"Attributes:",grandchild.attrib)
print()
# 輸出 menu 選項數目
print(len(root)); print()
# 輸出 breakfast 選項數目
print(len(root[0])); print()
# 
print(root[0][0].tag, type(root[0].tag))       # str
print(root[0][0].attrib, type(root[0].attrib)) # dict
print(root[0][0].text, type(root[0].text))     # str
print(root.find("breakfast").attrib)
print(root.find("lunch").attrib)
print(root[0].find("item").attrib)
print(root[0].findall("item")[0].text)
print(root[0].findall("item")[1].text)

# %%    XML 檔案寫入
# 匯入所需套件
import xml.etree.ElementTree as ET
# 利用套件中的 ElementTree 函式讀取 menu.xml 檔案，取得 tree 物件
tree = ET.ElementTree(file="country_data.xml")
# 利用 tree 物件的 getroot() 函式取得 root 物件 (找(移動)到根目錄)
root = tree.getroot()
# 使用迴圈取得滿足所有滿足條件的元素，並使用 remove() 指定刪除
for country in root.findall("country"):
# for country in root:
    rank = int(country.find("rank").text)
    if rank > 50:
        root.remove(country)
# 利用 write() 函示建立檔案，並把 xml 寫入新的檔案，同時指定寫入內容的編碼
tree.write("xmloutput.xml",encoding="utf-8")

# Element()     : 建立節點
# set()         : 設置屬性及相對應的資料
# append()      : 添加子節點
# extend()      : 結合循環器中的 chain() 合成列表添加一組節點
# text()        : 屬性設置文本值
# ElementTree() : 傳入根節點建立樹
# write()       : 寫入 xml 檔案

# %%    補充
# import 各自並讀取數字
# txt   --->  str
# csv   --->  str
# json  --->  int
# xml   --->  str