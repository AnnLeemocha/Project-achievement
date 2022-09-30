# ch05 example

> ch05_01
- 描述資料表內容： (Field，Type，Null，Key，Default，Extra)
    - DESC 資料庫名稱.資料表名稱

> ch05_02
- 插入資料
    - 注意，先使用 DESC 查看資料表內容，確定允許輸入內容
    - 欄位順序錯誤，雖然照塞入，但有警告問題
    - 直接插入資料：
        - INSERT INTO 資料庫名稱.資料表名稱 
          VALUES (欄位1, 欄位2, 欄位3)
        - INSERT INTO 資料庫名稱.資料表名稱 
          VALUES (欄位1, 欄位2, DEFAULT)
    - 給輸入順序後，再依順序塞入
        - INSERT INTO 資料庫名稱.資料表名稱 (欄位名稱1, 欄位名稱2, 欄位名稱3)
          VALUES (欄位1, 欄位2, 欄位3)
        - INSERT INTO 資料庫名稱.資料表名稱 (欄位名稱1, 欄位名稱2, 欄位名稱3)
          VALUES (欄位1, 欄位2)
            - 少輸入欄位直接以DEFAULT補，若無DEFAULT將以空白顯示，但這樣資料品質差
        - INSERT INTO cmdev.dept () VALUES ()
            - 也可以成功插入空資料，但這樣資料品質很差
    - 用 SET 方法插入資料：
        - INSERT INTO 資料庫名稱.資料表名稱 
          SET 欄位名稱1 = 插入資料, 欄位名稱2 = 插入資料
    - 插入多筆資料：
        - INSERT INTO 資料庫名稱.資料表名稱 VALUES 
          (欄位1, 欄位2, 欄位3),
          (欄位1, 欄位2, 欄位3)
          ...
    - 重複值問題： (IGNORE，忽略錯誤訊息，出現重複則以不插入處理)
        - 注意，PRI 為唯一值，不可插入相同數值
        - INSERT IGNORE INTO 資料庫名稱.資料表名稱
          VALUES (欄位1, 欄位2, DEFAULT)
- 更新資料 
    - 修改某欄位數據： (SET)
        - UPDATE 資料庫名稱.資料表名稱
          SET    欄位名稱 = 欄位名稱 + 1
          WHERE  篩選條件 
    - 插入新數據或(複製並)更新某欄位數據： (ON DUPLICATE KEY UPDATE)
        - INSERT INTO 資料庫名稱.資料表名稱
          VALUES (欄位1, 欄位2, 欄位3)
          ON DUPLICATE KEY UPDATE 欄位名稱 = 欄位名稱 + 1
- 取代資料
    - 單一格數據內容修改：
        - REPLACE INTO 資料庫名稱.資料表名稱
          VALUES (欄位1更新數據, 欄位2更新數據, 欄位3更新數據)

> ch05_03
- 更新資料 + 條件設置
    - UPDATE 資料庫名稱.資料表名稱
      SET    欄位名稱 = 更新數據
      WHERE  篩選條件(符合才進行更改)
- 更新資料之重複值問題： (IGNORE，忽略錯誤訊息，出現重複則以不更新處理)
    - UPDATE IGNORE 資料庫名稱.資料表名稱
      SET    欄位名稱 = 更新數據
      WHERE  篩選條件(符合才進行更改)
- 更新時將字串塞入整數型態，將以0輸入更新資料
- 更新"前？筆"數據：
    - UPDATE   資料庫名稱.資料表名稱
      SET      欄位名稱 = 欄位名稱 + 更新運算
      LIMIT    前？筆
- 更新"排序"後前？筆數據：
    - UPDATE   資料庫名稱.資料表名稱
      SET      欄位名稱 = 欄位名稱 + 更新運算
      ORDER BY 排序欄位名稱 (升/降序)
      LIMIT    前？筆
- 更新符合"篩選條件"並進行排序後之前？筆數據：
    - UPDATE   資料庫名稱.資料表名稱
      SET      欄位名稱 = 欄位名稱 + 更新運算
      WHERE    篩選條件
      ORDER BY 排序欄位名稱 (升/降序)
      LIMIT    前？筆

> ch05_04
- 刪除整個資料表內容： (注意不同刪除方式)
    - DELETE FROM 資料庫名稱.資料表名稱
    - TRUNCATE TABLE 資料庫名稱.資料表名稱
- 刪除符合條件之內容：
    - DELETE FROM  資料庫名稱.資料表名稱
      WHERE  篩選刪除條件
- 刪除排序後前？筆內容：
    - DELETE FROM 資料庫名稱.資料表名稱
      ORDER BY 欄位名稱 (升/降序)
      LIMIT    前？筆
