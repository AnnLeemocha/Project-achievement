-- 索引 (搜尋用)
CREATE TABLE addressbook7 (
  id        INT UNSIGNED PRIMARY KEY,  -- 主索引
  name      VARCHAR(20),
  tel       VARCHAR(20),
  address   VARCHAR(80),
  birthdate DATE,
  email     VARCHAR(36) UNIQUE KEY -- 唯一值 (不能有重複的) <--- 若單純只需要此概念
)


CREATE TABLE addressbook8 (
  id        INT UNSIGNED,  
  name      VARCHAR(20),
  tel       VARCHAR(20),
  address   VARCHAR(80),
  birthdate DATE,
  email     VARCHAR(36),
  PRIMARY KEY (id),
  UNIQUE KEY (email)
)

-- 建立索引多欄位 INDEX(A,B)
CREATE TABLE addressbook9 (
  id        INT UNSIGNED,  
  name      VARCHAR(20),
  tel       VARCHAR(20),
  address   VARCHAR(80),
  birthdate DATE,
  email     VARCHAR(36),
  PRIMARY KEY (id),
  UNIQUE KEY (email),
  INDEX (name, tel)
)

-- 以 address 前五個字 降序作索引
CREATE TABLE addressbook10 (
  id        INT UNSIGNED,  
  name      VARCHAR(20),
  tel       VARCHAR(20),
  address   VARCHAR(80),
  birthdate DATE,
  email     VARCHAR(36),
  INDEX (address (5) DESC)
)


CREATE TABLE addressbook11 (
  id        INT UNSIGNED,  
  name      VARCHAR(20),
  tel       VARCHAR(20),
  address   VARCHAR(80),
  birthdate DATE,
  email     VARCHAR(36)
)

-- 增加索引
ALTER TABLE addressbook11
ADD PRIMARY KEY (id)


ALTER TABLE addressbook11
ADD UNIQUE KEY (email)


ALTER TABLE addressbook11
ADD INDEX (name, tel)


ALTER TABLE addressbook11
ADD INDEX (address (5) DESC)


CREATE TABLE addressbook12 (
  id        INT UNSIGNED,  
  name      VARCHAR(20),
  tel       VARCHAR(20),
  address   VARCHAR(80),
  birthdate DATE,
  email     VARCHAR(36)
)


ALTER TABLE addressbook12
ADD PRIMARY KEY (id)

-- 索引的欄位名稱
CREATE UNIQUE INDEX email_index 
ON addressbook12 (email)


CREATE INDEX name_tel_index 
ON addressbook12 (name, tel)


CREATE INDEX address_index 
ON addressbook12 (address (5) DESC)

-- 與前面相同
ALTER TABLE addressbook12 ADD PRIMARY KEY (id)

-- 與前面相同
CREATE UNIQUE INDEX email_index ON addressbook12 (email)
