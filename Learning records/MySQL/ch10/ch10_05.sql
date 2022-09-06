-- 建立資料表
CREATE TABLE mycountry (
  Code char(3) NOT NULL DEFAULT '',
  Name char(52) NOT NULL DEFAULT '',
  Continent enum('Asia','Europe','North America','Africa','Oceania','Antarctica','South America') NOT NULL DEFAULT 'Asia',
  Region char(26) NOT NULL DEFAULT '',
  Population int(11) NOT NULL DEFAULT '0',
  GNP float(10,2) DEFAULT NULL,
  PRIMARY KEY (Code)
)

-- 用子查詢插入資料
INSERT INTO mycountry
( SELECT Code, Name, Continent, Region, Population, GNP
  FROM country
  WHERE Continent = 'Asia' )

-- 注意欄位個數不要超過
INSERT INTO mycountry
( SELECT *
  FROM country
  WHERE Continent = 'Africa' )

-- 資料更新 + 子查詢
UPDATE cmdev.emp
SET    salary = salary * 1.05
WHERE  deptno = ( SELECT deptno
                  FROM   cmdev.dept
                  WHERE  dname = 'SALES' )

-- 資料更新 + 子查詢
UPDATE cmdev.emp
SET    salary = salary * 1.05
WHERE  job = ( SELECT job
               FROM   cmdev.emp
               WHERE  empno = 'BLAKE' )


