# ch04 example

> ch04_02
- 選取多資料表
    - 需要有可以互相對應的欄位
       - WHERE  資料表名稱A.欄位名稱 = 資料表名稱B.欄位名稱
    - 有重複欄位名稱： (SELECT)
        - 資料表名稱.欄位名稱
    - 無重複欄位名稱： (SELECT)
        - 資料表名稱.欄位名稱
        - 欄位名稱 (可略資料表名稱)
    - 資料表名稱以別名取代： (FROM)
        - 資料表名稱 AS 別名
        - 資料表名稱 別名 (可略AS)
        - 取用時可選擇用 資料表名稱.欄位名稱  OR  別名.欄位名稱
    - 兩資料表結合：INNER JOIN (內結合)
        - 兩個表格欄位名稱"不相同" => ON
            - FROM 資料表名稱A INNER JOIN 資料表名稱B ON 欄位名稱A = 欄位名稱B
            - FROM 資料表名稱A 別名A INNER JOIN 資料表名稱B 別名B ON 欄位名稱A = 欄位名稱B
        - 兩個表格欄位名稱"相同" => USING
            - WHERE  資料表名稱A.欄位名稱 = 資料表名稱B.欄位名稱
            - FROM 資料表名稱A 別名A INNER JOIN 資料表名稱B 別名B ON 別名A.欄位名稱 = 別名B.欄位名稱
            - FROM 資料表名稱A INNER JOIN 資料表名稱B USING (欄位名稱)
            - FROM 資料表名稱A 別名A INNER JOIN 資料表名稱B 別名B USING (欄位名稱)

> ch04_03
- 兩資料表結合： LEFT/RIGHT OUTER JOIN (外結合)
    - 注意，不管有無配對成功，都要顯示NULL (與內結合最大差別)
    - 以哪個資料表為主(LEFT/RIGHT)：
        - LEFT=>以左方資料表為主
        - RIGHT=>以右方資料表為主
    - FROM   資料表名稱A 別名A RIGHT OUTER JOIN 資料表名稱B 別名B
       ON 欄位名稱A = 欄位名稱B
    - FROM   資料表名稱A 別名A RIGHT OUTER JOIN 資料表名稱B 別名B
       USING (欄位名稱)

> ch04_04
- 合併顯示多次查詢結果： UNION
    - 注意，欄位需要相同，而查詢結果並在後面
    - 注意，可合併不同表格，但欄位名稱不同就很奇怪，還是可以合併，欄位名稱依第一次查詢為主，請確認清楚合併欄位內容
    - 表格篩選結果(語法)1 UNION 表格篩選結果(語法)2 UNION 表格篩選結果(語法)3 ...
    - 使用OR 與 使用UNION： (兩者相差在輸出順序不同)
        - WHERE (條件1) OR (條件2)
        - 表格篩選結果(語法)1 UNION 表格篩選結果(語法)2
    