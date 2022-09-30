# ch03 example

> ch03_01
- 資料型態
    - 整數 (bigint -2^63~2^63-1)
           (int -2^31~2^31-1)
    - 小數 (小數點30位)
    - 字串 (放數值+數值 --> 可進行運算)
           (放非數值+數值 --> 不可進行運算 (忽略字串))
- 合併字串
    - 設定合併：
    - EX. SET sql_mode = 'PIPES_AS_CONCAT'; 
          SELECT 'Hello!' || 'MySQL!'  AS 'Concat String'

> ch03_02
- 設定忽略空白：
    - SET sql_mode='IGNORE_SPACE'
- 套件函式庫 (接在SELECT後) 
    - 日期差異天數計算+排序：
        - DATEDIFF(固定日期，日期欄位名稱)
    - 從字串左邊開始抓？個字：
        - LEFT(字串，抓幾個字)
    - 從字串右邊開始抓？個字：
        - RIGHT(字串，抓幾個字)
    - 從字串第？個字開始抓？個字：
        - SUBSTRING(字串，起始位置) 預設到結尾
        - SUBSTRING(字串，起始位置，抓幾個字) 
    - 串接資料，並決定連接符號：
        - SELECT 欄位名稱1 || ', ' || 欄位名稱2 || ', ' || 欄位名稱3
        - SELECT CONCAT_WS(', ', 欄位名稱1, 欄位名稱2, 欄位名稱2)
    - 取該欄位的資料長度(筆數)：
        - LENGTH(欄位名稱)
    - 找尋'字串'位置：
        - LOCATE(字串，欄位名稱)
    - 四捨五入：
        - ROUND(小數數值) (預設到整數)
        - ROUND(小數數值, 小數點後幾位)
    - 無條件進位：
        - CEIL(小數數值) (預設到整數)
        - CEIL(小數數值, 小數點後幾位)
    - 無條件捨去：
        - FLOOR(小數數值) (預設到整數)
        - FLOOR(小數數值, 小數點後幾位)
    - 抓取目前時間點：
        - CURDATE()
    - 萃取日期欄位：
        - 年份 => YEAR(日期)    OR   EXTRACT(YEAR FROM 日期)
        - 月份 => MONTH(日期)   OR   EXTRACT(MONTH FROM 日期)
        - 幾日 => DAY(日期)     OR   EXTRACT(DAY FROM 日期)
        - 星期 => DAYNAME(日期)
    - 增減日期天數：
        - ADDDATE(日期, 增減天數)
        - ADDDATE(日期, INTERVAL 增減天數 DAY)
    - 判斷式(三元運算子？)： [範例->加薪策略]
        - IF(判斷條件, 成立結果, 不成立結果)
    - 多條件判斷式：
        - CASE (欄位名稱，可略，但判斷條件寫法不同)
            WHEN 判斷條件1 THEN 成立結果
            WHEN 判斷條件2 THEN 成立結果
            WHEN 判斷條件3 THEN 成立結果
            ELSE 成立結果
          END 別名
    - 空值運算問題：
        - 欄位1+欄位2 
          (若其一為NULL，則加總結果為NULL)
        - 欄位1+IFNULL(欄位2，0) 
          (若為NULL，則用0來替代，並保留原始的NULL值)
- 補充：
    - 亂數排序：
        - ORDER BY RAND()
        
> ch03_03v1 (ch03_03重複)
- 運算函式
    - 最多有幾個欄位：
        - COUNT(*)
    - 計算該欄位不包含NULL的筆數：
        - COUNT(*) 欄位名稱
    - 總和值：
        - SUM(欄位名稱)
    - 平均值：
        - AVG(欄位名稱)
    - 最大值：
        - MAX(欄位名稱)
    - 最小值：
        - Min(欄位名稱)
- 去除重複內容：
    -SELECT DISTINCT 欄位名稱
- 合併該欄位中所有內容：
    - 逗號分隔
        - GROUP_CONCAT(欄位名稱)  
    - 先排序在合併
        - GROUP_CONCAT(欄位名稱 ORDER BY 欄位名稱)
    - 更改間隔符號 (SEPARATOR)
        - SELECT GROUP_CONCAT(欄位名稱 ORDER BY 欄位名稱 SEPARATOR '|')
    - 去除重複內容
        - SELECT GROUP_CONCAT(DISTINCT 欄位名稱)
- 分群：
    - 一欄位分群
        - GROUP BY 欄位名稱
    - 多欄位分群
        - GROUP BY 欄位名稱1，欄位名稱1
    - 分群後多一列總計 (ROLLUP)
        - GROUP BY 欄位名稱 WITH ROLLUP
    - 先分群後排序
        - GROUP BY 欄位名稱
          ORDER BY 欄位名稱 升降序
    - 加上篩選條件 (注意語法順序)
        - GROUP BY 欄位名稱
          HAVING   判斷條件
- 設定資料分群 (？)
    - SET sql_mode = 'ONLY_FULL_GROUP_BY' (預設)