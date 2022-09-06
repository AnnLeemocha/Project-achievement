-- 新建資料表 (注意資料表名稱，重複會報錯)
-- auto_increment 自動遞增 ---> 設定從 1000 開始 (字元集拉丁)
-- default 自訂
CREATE TABLE city2 (
  ID int(11) NOT NULL auto_increment,
  Name char(35) NOT NULL default '',
  CountryCode char(3) NOT NULL default '',
  District char(20) NOT NULL default '',
  Population int(11) NOT NULL default '0',
  PRIMARY KEY  (ID)
) AUTO_INCREMENT=1000 DEFAULT CHARSET=latin1

-- VARCHAR 可變長度字串
-- 預設 big5(依所處的區域國家) 預設可接受NULL
CREATE TABLE addressbook (
  name      VARCHAR(20),
  tel       VARCHAR(20),
  address   VARCHAR(80),
  birthdate DATE
)

-- 設定引擎，字元集，編碼 (預設？)
CREATE TABLE addressbook2 (
  name      VARCHAR(20),
  tel       VARCHAR(20),
  address   VARCHAR(80),
  birthdate DATE -- 無編碼排序
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci

-- 顯示引擎
SHOW ENGINES

-- 設定單一字元集 (其他自定預設)
CREATE TABLE addressbook3 (
  name      VARCHAR(20) CHARACTER SET big5,
  tel       VARCHAR(20),
  address   VARCHAR(80),
  birthdate DATE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_unicode_ci

-- 錯誤型態或空白 (NOT NULL為空  NULL為NULL)
CREATE TABLE addressbook4 (
  name      VARCHAR(20) NOT NULL,
  tel       VARCHAR(20) NULL,
  address   VARCHAR(80),
  birthdate DATE
)

-- 驗證 name NOT NULL
INSERT INTO addressbook4 (name) VALUES ('Simon Johnson')
INSERT INTO addressbook4 (name) VALUES (null)
-- 驗證 address 預設 NULL
INSERT INTO addressbook4 (address) VALUES ('Taipei')
INSERT INTO addressbook4 (address) VALUES (null)

-- 等同 addressbook4
CREATE TABLE addressbook (
  name      VARCHAR(20) NOT NULL,
  tel       VARCHAR(20) NULL,
  address   VARCHAR(80),
  birthdate DATE
)

-- 驗證 DEFAULT NULL
CREATE TABLE addressbook5 (
  name      VARCHAR(20) NOT NULL,
  tel       VARCHAR(20) DEFAULT NULL,
  address   VARCHAR(80) DEFAULT NULL,
  birthdate DATE DEFAULT NULL
)


INSERT INTO addressbook5 (name) VALUES ('Simon Johnson')
INSERT INTO addressbook5 (name) VALUES ('Simon Johnson1')
INSERT INTO addressbook5 (name) VALUES ('Simon Johnson2')

-- 驗證 DEFAULT 'Taipei'
CREATE TABLE addressbook6 (
  name      VARCHAR(20) NOT NULL,
  tel       VARCHAR(20),
  address   VARCHAR(80) DEFAULT 'Taipei',
  birthdate DATE
)

INSERT INTO addressbook6 (name) VALUES ('Simon Johnson')
INSERT INTO addressbook6 (name,address) VALUES ('Simon Johnson','Tainan')
INSERT INTO addressbook6 (name,address) VALUES ('Simon Johnson1','Taichung')
INSERT INTO addressbook6 (name) VALUES ('Simon Johnson2')
-- 更新所有的 address 都設定成 DEFAULT (整個欄位都改變)
-- Workbench 若有錯誤 ---> SET SQL_SAFE_UPDATES=0;//關閉
UPDATE addressbook6 SET address = DEFAULT


-- TIMESTAMP
CREATE TABLE tstable (
  ts TIMESTAMP,
  ts2 TIMESTAMP,
  area VARCHAR(20) NOT NULL,
  temp INT NOT NULL
)


INSERT INTO tstable (area, temp) VALUES ('NORTH', 25)
INSERT INTO tstable (area, temp) VALUES ('CENTRAL', 28)
INSERT INTO tstable (area, temp) VALUES ('SOUTH', 30)

-- TIMESTAMP 預設當前時間
CREATE TABLE tstable2 (
  ts timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  ts2 timestamp NOT NULL default '0000-00-00 00:00:00',
  area varchar(20) NOT NULL,
  temp int(11) NOT NULL
)


INSERT INTO tstable2 (area, temp) VALUES ('NORTH', 25)
INSERT INTO tstable2 (area, temp) VALUES ('CENTRAL', 28)
INSERT INTO tstable2 (area, temp) VALUES ('SOUTH', 30)

UPDATE tstable2 SET temp = 32 WHERE area = 'South'

-- TIMESTAMP 測試 當前時間
-- on update CURRENT_TIMESTAMP ---> 更新資料時，時間更新為修改時的時間
--                                  (無加此行，則為建立當下時的時間)
CREATE TABLE tstable3 (
  ts timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  ts2 timestamp NOT NULL default CURRENT_TIMESTAMP,
  area varchar(20) NOT NULL,
  temp int(11) NOT NULL
)


INSERT INTO tstable3 (area, temp) VALUES ('NORTH', 25)
INSERT INTO tstable3 (area, temp) VALUES ('CENTRAL', 28)
INSERT INTO tstable3 (area, temp) VALUES ('SOUTH', 30)

UPDATE tstable3 SET temp = 32 WHERE area = 'South'

-- 預設 更新 測試
CREATE TABLE tstable4 (
  created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  area VARCHAR(20) NOT NULL,
  temp INT NOT NULL
)


INSERT INTO tstable4 (created, area, temp) VALUES (NULL, 'NORTH', 25)
INSERT INTO tstable4 (created, area, temp) VALUES (NULL, 'CENTRAL', 28)
INSERT INTO tstable4 (created, area, temp) VALUES (NULL, 'SOUTH', 30)

UPDATE tstable4 SET temp = 31 WHERE area = 'South'

-- 預設 0 測試
CREATE TABLE tstable5 (
  created TIMESTAMP DEFAULT 0,
  updated TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  area VARCHAR(20) NOT NULL,
  temp INT NOT NULL
)


INSERT INTO tstable5 (created, area, temp) VALUES (NULL, 'NORTH', 25)
INSERT INTO tstable5 (created, area, temp) VALUES (NULL, 'CENTRAL', 28)
INSERT INTO tstable5 (created, area, temp) VALUES (NULL, 'SOUTH', 30)
INSERT INTO tstable5 (area, temp) VALUES ('NORTH', 25)

UPDATE tstable5 SET temp = 31 WHERE area = 'South'


SELECT Name, Population
FROM   world.city
WHERE  CountryCode='TWN'

-- 把篩選出來的結果存入新資料表
CREATE TABLE cityoftaiwan
SELECT Name, Population
FROM   world.city
WHERE  CountryCode='TWN'

-- 存入新資料表後，可以設定新的資料型態
CREATE TABLE cityoftaiwan2 (
  Name VARCHAR(30),
  Population INT UNSIGNED)
SELECT Name, Population
FROM   world.city
WHERE  CountryCode='TWN'


-- 存入新資料表後，更改欄位名稱
CREATE TABLE cityoftaiwan3 (
  TWN_Name VARCHAR(30),
  TWN_Population INT UNSIGNED)
SELECT Name TWN_Name, Population TWN_Population
FROM   world.city
WHERE  CountryCode='TWN'

-- 存入新資料表後，新增欄位
CREATE TABLE cityoftaiwan4 (
  Name VARCHAR(30),
  Population INT UNSIGNED,
  Description VARCHAR(50))
SELECT Name, Population
FROM   world.city
WHERE  CountryCode='TWN'

-- 多表格篩選 & 新增欄位
CREATE TABLE cityoftaiwan5 (
  Description VARCHAR(50))
SELECT city.Name, city.Population, Region
FROM   world.city,world.country
WHERE  CountryCode=Code
