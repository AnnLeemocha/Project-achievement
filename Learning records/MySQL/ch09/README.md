# ch09 example

> ch09_01
- 資料表內容查詢
    - SELECT * FROM world.city WHERE Name='Taipei'

> ch09_02
- 索引 (搜尋)
    - 先以第一條記錄開始並然後讀完整個表直到它找出相關的行，索引被用來快速找出在一個列上用一特定值的行
    - 所有的MySQL索引(PRIMARY、UNIQUE和INDEX)在B樹中存儲。字符串是自動地壓縮前綴和結尾空間
    - 有索引才能對表格直接進行修改
- 索引分類
    - 主鍵索引：
        - PRIMARY KEY
        - 必須包含唯一的值，不能包含NULL值，每個表只能有一個主鍵
        - 擁有自動定義的 UNIQUE 約束
    - 唯一索引： (不能有重複的，unique index？)
        - UNIQUE KEY
        - 每個表可以有多個 UNIQUE 約束，但是每個表只能有一個 PRIMARY KEY 約束
    - 普通索引： (foreign key？)
        - INDEX
        - 數據庫的物理結構，它只是輔助查詢的，它創建時會在另外的表空間（mysql中的innodb表空間）以一個類似目錄的結構存儲。
    - **可再詳細了解 (KEY與PRIMARY KEY) 及 (KEY與INDEX) 及 (UNIQUE KEY與PRIMARY KEY) 的區別**
    - 我們看到Key那一欄，可能會有4種值，即‘啥也沒有‘,‘PRI‘,‘UNI‘,‘MUL‘
        1. 如果Key是空的，那麽該列值的可以重復，表示該列沒有索引，或者是一個非唯一的復合索引的非前導列
        2. 如果Key是PRI，那麽該列是主鍵的組成部分
        3. 如果Key是UNI，那麽該列是一個唯一值索引的第一列(前導列)，且不能含有空值(NULL)
        4. 如果Key是MUL，那麽該列的值可以重復，該列是一個非唯一索引的前導列(第一列)或者是一個唯一性索引的組成部分但是可以含有空值NULL
        - 顯示的Key值按照優先級來顯示 PRI->UNI->MUL
- 創建索引： (key)
    - create table t (id int not null primary key)  
    [在字段級以key方式建立]
    - create table t(id int, CONSTRAINT pk_t_id PRIMARY key (id))  
    [在表級以constraint方式建立]
    - create table t(id int, primary key (id))  
    [在表級以key方式建立]
- INDEX索引
    - 建立多欄位索引：
        - INDEX (欄位名稱1, 欄位名稱2)
    - 以某欄位內容前？個字的升/降序作為索引：
        - INDEX (欄位名稱 (前？個字) ASC/DESC)
- 增加索引欄位：
    - ALTER TABLE 資料表名稱 ADD PRIMARY KEY (主鍵索引欄位名稱)
    - ALTER TABLE 資料表名稱 ADD UNIQUE KEY (唯一索引欄位名稱)
    - ALTER TABLE 資料表名稱 ADD INDEX (普通索引欄位名稱1, 普通索引欄位名稱2)
- 增加索引欄位，並賦予索引表之欄位名稱：
    - CREATE UNIQUE INDEX 索引表之欄位名稱 ON 資料表名稱 (欄位名稱)
    - CREATE INDEX 索引表之欄位名稱 ON 資料表名稱 (欄位名稱)
    - CREATE INDEX 索引表之欄位名稱 ON 資料表名稱 (欄位名稱1，欄位名稱2)

> ch09_03
- 移除索引
    - ALTER TABLE 資料表名稱
      DROP PRIMARY KEY,
      DROP INDEX 欄位名稱
    - DROP INDEX 欄位名稱 ON 資料表名稱
    - DROP INDEX 索引表之欄位名稱 ON 資料表名稱
    - *不可用'索引(PRIMARY OR UNIQUE)'來刪除，會發生錯誤*

> ch09_04-2
- 創建表格之主索引建立
    - CREATE TABLE 資料表名稱 (
        主鍵索引欄位名稱 INT UNSIGNED NOT NULL AUTO_INCREMENT
        PRIMARY KEY (主鍵索引欄位名稱)
      )
- 插入接續上一筆的索引值： (AUTO_INCREMENT)
    - LAST_INSERT_ID()
        - 普通索引 (無AUTO_INCREMENT) => 0, 0, 0, ...
        - 主鍵索引 (有AUTO_INCREMENT) => 1, 2, 3, ...
    - 直接插入其他欄位資料，有AUTO_INCREMENT之索引鍵會自動遞增
    - 若插入NULL值，因有設定NOT NULL，會接續上一筆索引值遞增
- 插入索引值為0的資料：
    - 直接插入：
        - 若直接插入0值，會接續上一筆索引值遞增，索引值並不會為0
    - 調整設定，必須與插入語法同時使用才能成功插入：
        - SET SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO';
          INSERT INTO 資料表名稱 (索引欄位名稱, 欄位名稱) 
          VALUES (0, 插入資料)
- 多表格索引
    - 若索引數值對上，即能搜尋到 (不管何種類索引)
- 多主索引鍵 
    - EX. PRIMARY KEY (empno, location, counter)
    - 唯一值，三個欄位同時重複才會錯誤，基本不可能重複
    - 若只輸入前兩個欄位，兩者內容相同時，第三個欄位才會自動遞增

> ch09_05
- 顯示資料表索引鍵列表
    - SHOW INDEX FROM 資料表名稱
- 引擎
    - 點擊資料庫 >> 資料表清單的表格中，欄位名稱為類型的欄位，即為該資料表使用的引擎
    - ENGINE = MyISAM (備份功能？)
    - ENGINE = InnoDB (商業化資料庫功能)
    - **可多了獎詳細內容補充**
