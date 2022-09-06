-- 顯示 world 資料庫中資料表有哪些
SHOW TABLES FROM world

-- 顯示 world 資料庫中"特定名稱的"資料表有哪些
SHOW TABLES FROM world LIKE '%y'

-- 顯示 world 資料庫中 詳細資料 (篩選其中幾項 ： 引擎，筆數...)
SELECT TABLE_SCHEMA, TABLE_NAME, ENGINE, TABLE_ROWS,
       AUTO_INCREMENT,TABLE_COLLATION
FROM   information_schema.TABLES
WHERE  TABLE_SCHEMA = 'world'

-- 顯示 world.country 資料表中 欄位的詳細資料
DESCRIBE world.country

-- 同上
DESC world.country

-- 同上
SHOW COLUMNS FROM world.country

-- 同上
SHOW FIELDS FROM world.country

-- 顯示 建立與 world.country 一樣的資料表，需要下的語法
SHOW CREATE TABLE world.country
