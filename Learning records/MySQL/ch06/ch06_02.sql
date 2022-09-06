-- 查詢資料庫的路徑 (用在程式語言)
SHOW VARIABLES LIKE 'datadir'

-- 建立資料庫
CREATE DATABASE mydb

-- 如果不存在，就建立資料庫
CREATE DATABASE IF NOT EXISTS mydb

-- 建立資料時，自訂字元集 與 編碼連線校對
CREATE DATABASE mydb CHARACTER SET utf8 COLLATE utf8_unicode_ci


CREATE DATABASE mydb CHARACTER SET utf8


CREATE DATABASE mydb COLLATE utf8_unicode_ci

-- 修改字元集 與 編碼連線校對
ALTER DATABASE mydb CHARACTER SET utf8 COLLATE utf8_unicode_ci


ALTER DATABASE mydb CHARACTER SET utf8 


ALTER DATABASE mydb COLLATE utf8_unicode_ci

-- 刪除資料庫
DROP DATABASE something

-- 如果資料庫存在，就刪除資料庫
DROP DATABASE IF EXISTS something

-- 資料庫清單 
SHOW DATABASES

-- 資料庫清單 
SHOW SCHEMAS

-- 查詢建立資料庫的流程
SHOW CREATE DATABASE mydb

-- 列出更詳細的資料庫資訊
SELECT * FROM information_schema.SCHEMATA
