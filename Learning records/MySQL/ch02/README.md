# ch02 example

> ch02_02
- SELECT   顯示內容，欄位 (可進行運算)
- FROM     資料表名稱 OR 資料庫名稱.資料表名稱
- AS       別名 (可略，若要用關鍵字與空白命名一定要加引號)
- 補充：    除法 = div & 註解 = --

> ch02_03
- WHERE    
    - 篩選條件 (!= = < > <= >= <> BETWEEN) (數值 字串 日期) 
    - 多條件 (AND OR IN)
    - 空值判斷用 (IS NULL ， <=> NULL ， IS NOT NULL) 
    - 精準比對(帳號密碼)  EX. Name = 'w' & Name LIKE 'w'
    - 模糊比對(搜尋引擎)  EX. Name LIKE 'w%' 
                            (% : 零個以上任意字元)
                            (_ : 限定字數長度，_幾個就有任意幾個字) 

> ch02_04
- ORDER BY
    - +欄位名稱  預設 ASC(升序)， DESC(降序) [可用不同排序方式]
    - +數字      排序第 ？ 個欄位
    - 注意：只要在資料表中的都可拿來做排序，不用管是否有顯示

> ch02_05
- LIMIT
    - +數字        顯示前幾筆
    - +數字, 數字  起始位置，顯示筆數
- 顯示
    - 顯示全部  (SELECT ALL 欄位名稱 FROM 資料位置)
    - 去除重複，只顯示一次  (SELECT DISTINCT 欄位名稱 FROM 資料位置)