
CREATE TABLE meeting (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  title VARCHAR(36),
  PRIMARY KEY (id)
)

-- 一般索引 (無AUTO_INCREMENT)
CREATE TABLE participate (
  id INT UNSIGNED NOT NULL,
  empno INT(11),
  INDEX (id)
)


INSERT INTO meeting (title) VALUES ('Sales meeting');
INSERT INTO meeting (title) VALUES ('Sales meeting2');
INSERT INTO meeting (title) VALUES ('Sales meeting3');

-->****************   1
INSERT INTO participate (id, empno) 
VALUES (LAST_INSERT_ID(), 7499),
       (LAST_INSERT_ID(), 7521),
       (LAST_INSERT_ID(), 7654),
       (LAST_INSERT_ID(), 7844)	   
	   
	   
-- 主索引
CREATE TABLE participate2 (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  title VARCHAR(36),
  PRIMARY KEY (id)
)

-->****************   2
INSERT INTO participate2 (id, title)   
VALUES (LAST_INSERT_ID(), 7499),
       (LAST_INSERT_ID(), 7521),
       (LAST_INSERT_ID(), 7654),
       (LAST_INSERT_ID(), 7844)





CREATE TABLE participate3 (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  empno VARCHAR(36),
  PRIMARY KEY (id)
)


-->****************   3
INSERT INTO participate3 (id, empno) 
VALUES (LAST_INSERT_ID(), 7499),
       (LAST_INSERT_ID(), 7521),
       (LAST_INSERT_ID(), 7654),
       (LAST_INSERT_ID(), 7844)	   
	   
	   
-->****************
-- 多表格查詢 --- 3
SELECT m.id, m.title, p.empno, e.ename
FROM   meeting m, participate3 p, cmdev.emp e
WHERE  m.id = p.id AND p.empno = e.empno
-->****************


-- 多表格查詢 --- 1
-- meeting 的 id 對應不上 participate 的 id
SELECT m.id, m.title, p.empno, e.ename
FROM   meeting m, participate p, cmdev.emp e
WHERE  m.id = p.id AND p.empno = e.empno

-- id 皆會正常遞增
INSERT INTO meeting (title) 
VALUES ('Analyst meeting')


INSERT INTO meeting (id, title) 
VALUES (0, 'Manager  meeting')


INSERT INTO meeting (id, title) 
VALUES (NULL, 'Clerk meeting')

-- 新增所引為 0 的資料，需一起使用才能新增
SET SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO';
INSERT INTO meeting (id, title) 
VALUES (0, 'Manager  meeting')

-- 多主索引鍵 (唯一值，三個同時重複才會錯誤，基本不可能重複)
CREATE TABLE travelautoincr (
  empno INT(11) NOT NULL,
  location VARCHAR(16) NOT NULL,
  counter SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (empno, location, counter)
) ENGINE=MyISAM -- 資料庫的引擎

-- counter 在前兩個一樣時自動遞增
INSERT INTO travelautoincr (empno, location)
VALUES (7369, 'CHICAGO'), (7369, 'CHICAGO'),
       (7499, 'DALLAS'), (7499, 'DALLAS'), (7499, 'DALLAS'),
       (7566, 'BOSTON'), (7566, 'BOSTON')
