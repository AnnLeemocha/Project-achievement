-- 新增一個欄位(在最後面)
ALTER TABLE cityoftaiwan5 ADD newcolumn int

-- 新增一個欄位(在最前面)
ALTER TABLE cityoftaiwan5 ADD newcolumn2 int FIRST

-- 新增一個欄位(在指定欄位後面)
ALTER TABLE cityoftaiwan5 ADD newcolumn3 int AFTER Description

-- 新增多欄位在最後
ALTER TABLE cityoftaiwan5 
ADD (newcolumn4 int, newcolumn5 int)

-- 修改 newcolumn4 名稱為 changecolumn 並修改資料型態 移動到 newcolumn3 後面
ALTER TABLE cityoftaiwan5 
CHANGE newcolumn4 changecolumn BIGINT AFTER newcolumn3

-- 修改 newcolumn2 資料型態 移動到 newcolumn 後面
ALTER TABLE cityoftaiwan5 
MODIFY newcolumn2 BIGINT AFTER newcolumn

-- 用修改的方式刪除欄位
ALTER TABLE cityoftaiwan5 DROP newcolumn5

-- 用修改的方式改變資料表的名稱
ALTER TABLE cityoftaiwan5 RENAME mynewtable

-- 更改資料表的名稱
RENAME TABLE mynewtable TO cityoftaiwan5
