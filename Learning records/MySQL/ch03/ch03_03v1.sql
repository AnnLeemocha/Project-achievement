-- COUNT() [計算筆數不包含NULL]
SELECT SUM(Population) PopSum, 
       AVG(Population) PopAvg,
       MAX(Population) PopMax, 
       Min(Population) PopMin,
       COUNT(*) Amount
FROM   country


SELECT MIN(hiredate) FirstHireDate, MAX(hiredate) LastHireDate
FROM   cmdev.emp


SELECT COUNT(*), COUNT(Code), COUNT(IndepYear), COUNT(LifeExpectancy)
FROM   country

-- COUNT(*) 欄位最高有幾筆
SELECT COUNT(*), COUNT(comm), COUNT(deptno)
FROM   cmdev.emp


SELECT dname
FROM   cmdev.dept

-- GROUP_CONCAT [合併該欄位內容合併]
SELECT GROUP_CONCAT(dname)
FROM   cmdev.dept

-- 先排序
SELECT GROUP_CONCAT(dname ORDER BY dname)
FROM   cmdev.dept

-- SEPARATOR 更改間隔符號
SELECT GROUP_CONCAT(dname ORDER BY dname SEPARATOR '|')
FROM   cmdev.dept

-- 有重複內容
SELECT Region
FROM   country
WHERE  Continent = 'Europe'

-- 去除重複內容
SELECT DISTINCT Region
FROM   country
WHERE  Continent = 'Europe'


SELECT GROUP_CONCAT(Region)
FROM   country
WHERE  Continent = 'Europe'


SELECT GROUP_CONCAT(DISTINCT Region)
FROM   country
WHERE  Continent = 'Europe'


SELECT   Population
FROM     country


SELECT   SUM(Population) PopSum
FROM     country

-- GROUP BY 分群 ---> 再加總
SELECT   Continent, SUM(Population) PopSum
FROM     country
GROUP BY Continent


SELECT   Continent, SUM(Population) PopSum
FROM     country
GROUP BY Continent


SELECT   Region, SUM(Population) PopSum
FROM     country
GROUP BY Region


SELECT   GovernmentForm, SUM(Population) PopSum
FROM     country
GROUP BY GovernmentForm


SELECT   Continent, COUNT(*) Amount
FROM     country
GROUP BY Continent


SELECT   Region, COUNT(*) Amount
FROM     country
GROUP BY Region


SELECT   GovernmentForm, COUNT(*) Amount
FROM     country
GROUP BY GovernmentForm


SELECT   GovernmentForm, COUNT(*) Amount, SUM(Population) PopSum,
         AVG(Population) PopAvg
FROM     country
GROUP BY GovernmentForm

-- 兩欄位分群
SELECT   Continent, Region, SUM(Population) PopSum
FROM     country
GROUP BY Continent, Region


SELECT   GovernmentForm, COUNT(*) Amount
FROM     country
GROUP BY GovernmentForm

-- 分群完再用原方法排序會有錯誤
SELECT   GovernmentForm, COUNT(*) Amount
FROM     country
GROUP BY GovernmentForm ASC


SELECT   GovernmentForm, COUNT(*) Amount
FROM     country
GROUP BY GovernmentForm DESC


SELECT   GovernmentForm, COUNT(*) Amount
FROM     country
GROUP BY GovernmentForm

-- 小計 ?
SELECT   Continent, COUNT(*) Amount
FROM     country
GROUP BY Continent WITH ROLLUP


SELECT   Continent, COUNT(*) Amount, SUM(Population) PopSum
FROM     country
GROUP BY Continent WITH ROLLUP


SELECT   Continent, Region, COUNT(*) Amount
FROM     country
GROUP BY Continent, Region WITH ROLLUP


SELECT   Region, SUM(Population)
FROM     country
WHERE    Continent = 'Asia'
GROUP BY Region

-- 加總判斷 語法上的問題
SELECT   Region, SUM(Population)
FROM     country
WHERE    SUM(Population) > 100000000
GROUP BY Region

-- 用分群函釋後 ---> WHERE() 改 HAVING()
SELECT   Region, SUM(Population)
FROM     country
GROUP BY Region
HAVING   SUM(Population) > 100000000


SELECT   Continent, Region, COUNT(Continent) Continent1,COUNT(Region) Region1,COUNT(*) Amont, COUNT(Code), COUNT(LifeExpectancy) 
FROM     country
GROUP BY Continent


SET sql_mode = 'ONLY_FULL_GROUP_BY';



SELECT   Continent, Region, COUNT(*) Amount
FROM     country
GROUP BY Continent, Region
