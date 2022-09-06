# 學生成績輸入系統 

>使用版本

- JAVA SDK jdk-18.0.1.1
- MAVEN 4.0.4

> Mark Down 語法：

- https://www.mdeditor.tw/
- 可用撿取工具增加圖示

> 畫面 GUI設定 

- 左邊輸入功能
  - 姓名/成績輸入
  - 按鈕測試
- 右邊輸出區域
  - TextArea
  - ScrollPane
- 下方功能按鈕
  - 新增/讀取/清除/核取按鈕

>輸入功能測試

- 輸入錯誤測試
- 輸入為空測試
- 輸入不合法數字

> 輸出到 TextArea

- 使用 StringBuilder
- [x] 清空功能?
  - 提示是否清除(視窗)

> 儲存功能

- 資料為空測試
- 寫入檔案函式化
- 儲存檔案名稱
  - student.csv
- 寫入檔頭測試
  - 姓名,國文,英文,數學
    - 需要偵測檔案不存在強制寫入 header
    - append=false(寫入檔頭)
- 增加勾選功能
  - 清空寫入模式
  - 往後附加模式

> 讀取功能
  - 讀取使用OpenFileDialog
    - 取代目前fileName
    - 資料讀取後更新outputArea
  - 顯示目前編修檔案
  - 儲存也使用fileName

> 後續其他優化
  - 輸出Excel編碼格式(ANSI=>BIG5)
  - 輸出UTF8(UTF8-Bom)