# ch08 example

> ch08_01-2
- 新建資料表
    - 注意資料表名稱，重複會報錯
    - 欄位名稱  欄位資料型態  是否允許NULL值  設定default值 
    - auto_increment (唯一) 自動遞增，可設定起始值
      設定預設字元集
      設定預設引擎，字元集，編碼 
        - 顯示引擎： SHOW ENGINES
    - VARCHAR(長度)：
        - 可變長度字串，預設big5(依所處的區域國家)，預設可接受NULL
    - *將該欄位整欄都更新成預設：*
        - *UPDATE addressbook6 SET address = DEFAULT*
        - *Workbench 若有錯誤 ---> SET SQL_SAFE_UPDATES=0; -- 關閉*
    - 資料建立時的時間：
        - CURRENT_TIMESTAMP
    - 更新為資料修改時的時間：
        - CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP (還會顯示建立時時間)
        - ON UPDATE CURRENT_TIMESTAMP (只顯示修改時間)
    - CREATE TABLE 資料表名稱 (
      欄位名稱1 新資料型態1(容納長度) NOT NULL auto_increment,
      欄位名稱2 新資料型態2(容納長度) NOT NULL default 預設值(注意符合資料型態),
      PRIMARY KEY  (欄位名稱1)
      ) AUTO_INCREMENT = 設定預設起始值 
        DEFAULT CHARSET = 設定預設字元集 (或是 CHARACTER SET = 設定預設字元集)
        ENGINE = 設定預設字元集
        COLLATE = 設定預設編碼
- 篩選結果存入新資料表
    - CREATE TABLE 資料表名稱
      SELECT 篩選之欄位名稱1, 篩選之欄位名稱2
      FROM   資料庫名稱.資料表名稱
      WHERE  篩選條件
- 篩選結果存入新資料表後 (1) 設定新的資料型態 (2) 設定新欄為名稱 (3) 新增欄位
    - CREATE TABLE 資料表名稱 (
        新欄位名稱1 新資料型態1 ... ...,
        新欄位名稱2 新資料型態2 無正負號  ... ...,
        新增之欄位名稱 資料型態 ... ...)
      SELECT 篩選之欄位名稱1, 篩選之欄位名稱2
      FROM   資料庫名稱.資料表名稱
      WHERE  篩選條件
    - **多表格篩選也可將結果存入新資料表**
> ch08_02
- 現有資料表中新增欄位 (ADD)
    - 新增一個欄位在"最後"：
        - ALTER TABLE 資料表名稱 ADD 新增欄位名稱 資料型態
    - 新增一個欄位在"最前"：
        - ALTER TABLE 資料表名稱 ADD 新增欄位名稱 資料型態 FIRST
    - 新增一個欄位在"指定位置"：
        - ALTER TABLE 資料表名稱 ADD 新增欄位名稱 資料型態 AFTER 定位之欄位名稱
    - 新增"多個"欄位在"最後"：
        - ALTER TABLE 資料表名稱 ADD (新增欄位名稱1 資料型態1, 新增欄位名稱2 資料型態2)
- 修改資料表 (ALTER TABLE)
    - 修改欄位名稱並進行移動： (CHANGE)
        - ALTER TABLE 資料表名稱 CHANGE 原欄位名稱 更改之欄位名稱 資料型態 AFTER 定位之欄位名稱
    - 修改資料型態並進行移動： (MODIFY)
        - ALTER TABLE 資料表名稱 MODIFY 欄位名稱 新資料型態 AFTER 定位之欄位名稱
    - 用修改的方式刪除欄位： (DROP)
        - ALTER TABLE 資料表名稱 DROP 欲刪除之欄位名稱
    - 用修改的方式改變資料表的名稱： (RENAME)
        - ALTER TABLE 原資料表名稱 RENAME 新資料表名稱
    - 更改資料表的名稱：
        - RENAME TABLE 原資料表名稱 TO 新資料表名稱
> ch08_03
- 顯示"某資料庫"中的資料表名單
    - SHOW TABLES FROM 資料庫名稱
- 顯示"某資料庫"中"特定名稱"的資料表名單
    - SHOW TABLES FROM 資料庫名稱 LIKE '%y'
- 顯示"某資料庫"中所有資料表的詳細資訊
    - SELECT *
      FROM   information_schema.TABLES
      WHERE  TABLE_SCHEMA = '資料庫名稱'
- 顯示"某資料表"中詳細的欄位訊息
    - DESCRIBE 資料庫名稱.資料表名稱
    - DESC 資料庫名稱.資料表名稱
    - SHOW COLUMNS FROM 資料庫名稱.資料表名稱
    - SHOW FIELDS FROM 資料庫名稱.資料表名稱
- 顯示建立與現有資料表相同的資料表，所需要的語法
    - SHOW CREATE TABLE 資料庫名稱.資料表名稱
