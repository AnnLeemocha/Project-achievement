# ch06 example

> ch06_01
- 顯示所有資料編碼：
    - SHOW CHARACTER SET
- 顯示所有連建校對編碼：
    - SHOW COLLATION
- 尋找特定編碼型態：
    - SHOW COLLATION LIKE 'latin1%'
- 尋找特定變數編碼
    - show variables like '%char%'

> ch06_02
- 查詢資料庫的路徑： (通常用在程式語言與資料庫連接後的查詢)
- 建立資料庫： (CREATE)
    - 資料庫名稱"不存在"：
        - CREATE DATABASE 資料庫名稱
    -資料庫名稱"已存在"： (若存在不報錯，若不存在則建立)
        - CREATE DATABASE IF NOT EXISTS 資料庫名稱
    - 建立資料時，決定自訂字元集 與 編碼連線校對： (可只修改其一)
        - CREATE DATABASE 資料庫名稱 CHARACTER SET utf8 COLLATE utf8_unicode_ci
- 修改資料庫： (ALTER)
    - 修改字元集 與 編碼連線校對： (可只修改其一)
        - ALTER DATABASE 資料庫名稱 CHARACTER SET utf8 COLLATE utf8_unicode_ci
- 刪除資料庫：
    - 資料庫名稱"不存在"：
        - DROP DATABASE 資料庫名稱
    - 資料庫名稱"已存在"： (若不存在不報錯，若存在則刪除)
        - DROP DATABASE IF EXISTS 資料庫名稱
- 顯示資料庫清單：
    - SHOW DATABASES
    - SHOW SCHEMAS
- 顯示更詳細的資料庫資訊： (*=所有資訊)
    - SELECT * FROM information_schema.SCHEMATA
- 查詢建立該資料庫的流程語法：
    - SHOW CREATE DATABASE 資料庫名稱
