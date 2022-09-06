-- 資料型態 (語法)
-- 整數
INSERT INTO integertable VALUES (1, 2, 3, 4, 5)

-- 整數(帶符號) 65536 ---> 32767 (有可能報錯)
INSERT INTO integertable VALUES (1, 65536, 3, 4, 5)

-- 整數 四捨五入到整數
INSERT INTO integertable VALUES (1.2, 2.3, 3.4, 4.5, 5.6)

-- 浮點數
INSERT INTO numerictable (i4, f2) VALUES (1, 1),(-1, -1)

-- 屬性 Signed 與 Unsigned(無負值) (注意，避免超過資料型態之範圍)
INSERT INTO numerictable (i, f) VALUES (-1, -1)


INSERT INTO numerictable (i, i2, i3, i4, i5)
VALUES (1, 1, 1, 1, 1),
       (123, 123, 123, 123, 123),
       (123, 12345, 1234567, 1234567890, 1234567890123456789)

-- 	decimal(10,0) 總長10位 小數點0位
INSERT INTO numerictable (f, f2, f3)
VALUES (123.12, 123.12, 123.12),
       (123.123, 123.123, 123.123)


INSERT INTO numerictable (f, f2, f3) VALUES (0.1, 12345.12, 0.1)

-- 屬性 UNSIGNED ZEROFILL，有設定資料型態位數，值輸入完補空位補0
-- float double 包含小數點之長度   decimal 不包含小數點之長度
-- 結構 >> 動作 >> 修改
INSERT INTO numerictable3 VALUES (1, 1, 1, 1, 1, 1.1, 1.1, 1.1)

-- 超過設定資料型態位數，但為該資料型態範圍中，回資料型態可存 (結構中顯示原設定)
-- int(6)---> 7 (OK)
INSERT INTO numerictable3 (i4) VALUES (123), (1234567)

-- 位元型態
INSERT INTO bittable 
VALUES (1, 255, 65536),
       (b'1', b'11111111', b'1111111111111111') -- (1, 255, 65535)

-- 字串/元 (空值沒存)
INSERT INTO nonbinarytable 
VALUES ('', ''),('123', '123'),('1234567890', '1234567890')

-- 字串長度 (佔幾個byte，中文可能佔2bytes：BIG5 3bytes：UTF8)
SELECT s, LENGTH(s), s2, LENGTH(s2), s3, LENGTH(s3) 
FROM   nonbinarytable2

-- 字串長度 (佔幾個字元)
SELECT s,CHAR_LENGTH(s),s2,CHAR_LENGTH(s2),s3,CHAR_LENGTH(s3) 
FROM   nonbinarytable2

-- 資料庫要有主索引鍵(唯一)才能編輯/複製/刪除
-- 結構 >> 新增欄位 >> 欄位名稱 長度 A_I(自動遞增，詢問是否為主索引PRIMARY)
-- 新增中文 ---> 測試兩種長度


SELECT * FROM nonbinarytable3

-- 編碼不區分大小寫 (模糊比對)
SELECT   * 
FROM     nonbinarytable3
ORDER BY s

-- 編碼區分大小寫
SELECT   * 
FROM     nonbinarytable3
ORDER BY s2

-- 編碼不區分大小寫 AAA aaa
SELECT * 
FROM   nonbinarytable3 
WHERE  s = 'aaa'

-- 編碼區分大小寫 aaa
SELECT * 
FROM   nonbinarytable3 
WHERE  s2 = 'aaa'

-- 十六進制(4bits) 4*12/8 (6bytes)
SELECT b, LENGTH(b), b2, LENGTH(b2)
FROM   binarytable

-- 設定資料型態 enum 設立特定清單(字串)結果
INSERT INTO enumtable 
VALUES ('XS', 'XS'),('S', 'S'),('M', 'M'),
       ('L', 'L'),('XL', 'XL');


INSERT INTO enumtable (stringsize) VALUES ('QQ');

-- 不符合清單則為預設
INSERT INTO enumtable (enumsize) VALUES ('QQ')


INSERT INTO enumtable (enumsize)
VALUES ('XS'),('S'),('M'),('L'),('XL')

-- 對應清單順序(編號)
INSERT INTO enumtable (enumsize)
VALUES (1),(2),(3),(4),(5)

-- 依照對應清單順序(編號)排序
SELECT   enumsize 
FROM     enumtable 
ORDER BY enumsize


SELECT   stringsize 
FROM     enumtable 
ORDER BY stringsize

-- 查詢
SELECT * FROM enumtable where enumsize = 'M'

-- 查詢 對應清單順序(編號)
SELECT * FROM enumtable where enumsize = 3

-- 集合 ： 不可重複，但可塞多筆(逗號隔開)
INSERT INTO settable
VALUES ('MON,WED,FRI'),
       ('TUE,THU'),
       ('SAT,SUN'),
       ('MON,TUE,WED,THU,FRI,SAT,SUN')

-- 集合 輸入多筆，但有重複內容，只顯示該內容一次

-- 不在集合中則忽略
INSERT INTO settable VALUES ('MON,HELLO,FRI')

-- (0) ---> 插入空   
-- 2^0=1('MON')  2^1=2('TUE')  2^2=4('WED')  2^3=8('THU')  2^4=16('FRI') ...
INSERT INTO settable VALUES (0),(1),(4),(16)


INSERT INTO settable VALUES (''),('MON'),('WED'),('FRI')


INSERT INTO settable VALUES ('MON,WED,FRI')

-- 1+4+16 ---> ('MON,WED,FRI')
INSERT INTO settable VALUES (21)

-- enum VS set
-- ci 不區分大小寫 ---> 輸入小寫自動轉大寫
-- cs 區分大小寫 ---> 輸入小寫，清單中若無小寫，則會以預設值輸入(NULL)
INSERT INTO estable 
VALUES (1, 1, 21, 21),
       ('M','M','MON','MON'),
       ('m','M','mon','MON')


INSERT INTO estable (enumsize2, workingday2)
VALUES ('m','mon')

-- 日期
-- 新增欄位查詢 (YEAR限制) (DATE DATETIME差異)
-- 時間 Date
INSERT INTO dttable (d) VALUES ('9000-1-1')


INSERT INTO dttable (d) VALUES ('900-1-1')

-- >= 70 為 19XX (1970)
INSERT INTO dttable (d) VALUES ('90-1-1')


INSERT INTO dttable (d) VALUES ('9-1-1')


INSERT INTO dttable (d) VALUES ('2000-1-1')


INSERT INTO dttable (d) VALUES ('200-1-1')

-- < 70 為 20XX (2069)
INSERT INTO dttable (d) VALUES ('20-1-1')


INSERT INTO dttable (d) VALUES ('2-1-1')

-- 時間(長度) Time
INSERT INTO dttable (t) VALUES ('200:30:00')

-- 時間長度 (負)
INSERT INTO dttable (t) VALUES ('-1:20:30')

-- 時:分:秒
INSERT INTO dttable (t) VALUES ('200:30:30')

-- 時:分
INSERT INTO dttable (t) VALUES ('200:30')

-- 兩位數切割 
INSERT INTO dttable (t) VALUES ('200')

-- 時間 DateTime
-- 年-月-日 時:分:秒
INSERT INTO dttable (dt) 
VALUES ('2000-01-01 10:10:10')

-- 不限制中間空格數
INSERT INTO dttable (dt) 
VALUES ('2000-01-01     10:10:10')

-- 自動補 時:分:秒
INSERT INTO dttable (dt) 
VALUES ('2000-01-01')

-- 時 格式不符合 ---> 0000-00-00 00:00:00
INSERT INTO dttable (dt) 
VALUES ('2000-01-01 200:00:00')

-- 時間 year
-- 範圍有被限定  '1901' to '2155' ('0000')
-- 三位數自動補0，但要注意範圍
-- 2000
INSERT INTO dttable (y4) VALUES ('2000'),(2000)

-- 0000
INSERT INTO dttable (y4) VALUES ('200'),(200)

-- 2020
INSERT INTO dttable (y4) VALUES ('20'),(20)

-- 2002
INSERT INTO dttable (y4) VALUES ('2'),(2)

-- 0000
INSERT INTO dttable (y4) VALUES ('0000'), (0)

-- 2000
INSERT INTO dttable (y4) VALUES ('000')


INSERT INTO dttable (y4) VALUES ('00')


INSERT INTO dttable (y4) VALUES ('0')

-- 時間 TimeStamp (UTC)
-- 範圍是'1970-01-01 00:00:01.000000'UTC 到'2038-01-19 03:14:07.999999'UTC
-- 原 SYSTEM
INSERT INTO dttable (ts) VALUES ('1970-1-01 8:0:1')


INSERT INTO dttable (ts) VALUES ('1970-1-01 0:0:1')

-- GLOBAL(整個系統SQL(SERVER)架構)   SESSION(針對個人資訊溝通)
SELECT @@GLOBAL.TIME_ZONE, @@SESSION.TIME_ZONE


SET SESSION TIME_ZONE = '+00:00'


SET GLOBAL TIME_ZONE = '+00:00'


SELECT @@GLOBAL.TIME_ZONE, @@SESSION.TIME_ZONE


INSERT INTO dttable (dt, ts)
VALUES ('2000-01-01 00:00:00', '2000-01-01 00:00:00')


SELECT dt,ts FROM dttable 


SET GLOBAL TIME_ZONE = '+08:00'


SELECT dt,ts FROM dttable
