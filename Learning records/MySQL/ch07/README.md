# ch07 example

> ch07_02
- 資料型態 (https://dev.mysql.com/doc/refman/8.0/en/data-types.html)
    - 結構 --- 動作 --- 修改
    - 超出原資料型態範圍可能"報錯"或"顯示出的最大/最小值"
    - 超過自訂資料型態位數，但包含在原資料型態範圍中，輸入資料型態可存 
      (但結構中顯示原設定)
    - 整數型態：
        - tinyint < smallint < mediumint < int < bigint
        - 插入數值範圍 (帶正負號 [Signed]) => -32766 ~ 32767
        - 插入數值範圍 (不帶正負號 [Unsigned]) => 0 ~ 65535
        - 插入小數 => 四捨五入到整數
    - *屬性 UNSIGNED ZEROFILL*
        - *有設定資料型態位數，值輸入完，剩餘空位補0*
    - 浮點數型態：
        - float < double < 	decimal(總長?位，小數點?位)
        - float & double => 包含小數點之長度
        - decimal => 不包含小數點之長度
    - 位元型態：
        - bit(長度)
        - EX. INSERT INTO bittable VALUES
              (1, 255, 65536),
              (b'1', b'11111111', b'1111111111111111')
    - 字串/元型態：
        - 超過設定長度，直接砍掉右側多於輸入
        - EX. INSERT INTO nonbinarytable VALUES 
              ('', ''),
              ('123', '123'),
              ('1234567890', '1234567890')
        - 字串長度：
            - LENGTH(欄位名稱)  [佔幾個byte]
              (中文可能佔2bytes：BIG5 3bytes：UTF8))
            - CHAR_LENGTH(欄位名稱)  [佔幾個字元] 
    - *主索引鍵：*
        - *資料庫要有主索引鍵(唯一)才能編輯/複製/刪除*
        - *結構 >> 新增欄位 >> 欄位名稱 長度 A_I(自動遞增，詢問是否為主索引PRIMARY)*
    - 十六進制：(4bits) 4*12/8 => (6bytes)
        - binary & varbinary
    - enum型態：
        - 設立特定清單(字串)結果 
        - 僅能輸入清單中的內容，不符合清單內容則輸入預設值
        - 清單有順序性，可以對應編號輸入或查詢
        - 使用排序時，將以清單順序輸出
        - 注意編碼有無區分大小寫
    - 集合型態：
        - 設立特定清單(字串)結果 
        - 輸入單筆時，可塞多資料(逗號隔開)，但內容不可重複
        - 若塞多資料中有重複內容，只顯示該內容一次
        - 不在集合中的內容則忽略不顯示
        - 0  => 插入空值
          1  => 插入清單第一個 (2^0=1)
          4  => 插入清單第一個 (2^1=2)
          16 => 插入清單第一個 (2^2=4)
          21 => 插入清單第一~三個 (1+4+16)
        - 注意編碼有無區分大小寫
    - *編碼設定：*
        - *區分大小寫編碼 (尾部接_cs [case sensitive])*
        - *不區分大小寫編碼 (尾部接_ci [case insensitive])*
    - 日期型態：
        - date： (年-月-日)
            - EX1. INSERT INTO dttable (d) VALUES ('9000-1-1') => [9000-01-01]
            - EX2. INSERT INTO dttable (d) VALUES ('900-1-1') => [0900-01-01]
            - EX3. INSERT INTO dttable (d) VALUES ('90-1-1') => [1990-01-01]
            - 年份輸入 >= 70 為 19XX (1970)
              年份輸入 <  70 為 20XX (2069)
        - time： (時:分:秒) | (時:分) | (兩位數分割)
            - 代表時間的長度 
            - EX1. INSERT INTO dttable (t) VALUES ('200:30:30')
            - EX2. INSERT INTO dttable (t) VALUES ('-1:20:30') => [-01:20:30]
            - EX3. INSERT INTO dttable (t) VALUES ('200:30') => [200:30:00]
            - EX4. INSERT INTO dttable (t) VALUES ('200') => [00:02:00]
        - datetime： (年-月-日 時:分:秒)
            - 不限制中間空格數
            - 只輸入 年-月-日 ，自動補 時:分:秒
            - 注意時的格式[200:00:00 X]，若格式不符合，則輸入 0000-00-00 00:00:00
        - year：
            - 不限制輸入為字串或數值形式
            - 範圍有被限定  '1901' to '2155' ('0000')
            - 若只輸入三位數，自動轉為0000 [要注意範圍，但看起來MySQL基本都轉為0000]
            - EX1. INSERT INTO dttable (y4) VALUES ('2000'),(2000) => [2000]
            - EX2. INSERT INTO dttable (y4) VALUES ('200') => [0000]
            - EX3. INSERT INTO dttable (y4) VALUES ('20') => [2020]
            - EX4. INSERT INTO dttable (y4) VALUES ('2') => [2002]
            - EX5. INSERT INTO dttable (y4) VALUES ('0000'),(0) => [0000]
            - EX6. INSERT INTO dttable (y4) VALUES ('000') => [2000]
            - EX7. INSERT INTO dttable (y4) VALUES ('00') => [2000]
            - EX8. INSERT INTO dttable (y4) VALUES ('0') => [2000]
        - timestamp： (UTC)
            - 依時區設定變更日期數值
            - 注意傳換UTC時的範圍
            - 範圍是'1970-01-01 00:00:01.000000'UTC 到'2038-01-19 03:14:07.999999'UTC
            - EX. INSERT INTO dttable (ts) VALUES ('1970-1-01 8:0:1')
        - *時區設定：*
            - *GLOBAL(整個系統SQL(SERVER)架構)*
              *SESSION(針對個人資訊溝通)*
            - *SELECT @@GLOBAL.TIME_ZONE, @@SESSION.TIME_ZONE*
                - *原皆為 SYSTEM*
                - *手動設定為 +00:00*
                  *SET SESSION TIME_ZONE = '+00:00';*
                  *SET GLOBAL TIME_ZONE = '+00:00'*
                  
            
