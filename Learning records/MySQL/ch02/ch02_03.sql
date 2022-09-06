SELECT *
FROM   city

-- 判斷式 : WHERE
-- 在 city 資料表中，找符合 CountryCode 欄位='TWN' 的所有資料
SELECT *
FROM   city
WHERE  CountryCode = 'TWN'


SELECT *
FROM   city
WHERE  Population < 800


SELECT *
FROM   city
WHERE  Population <= 800

-- 日期也可用判斷
SELECT *
FROM   cmdev.emp
WHERE  hiredate = '1981-09-08'


SELECT *
FROM   cmdev.emp
WHERE  hiredate > '1981-09-08'


SELECT *
FROM   cmdev.emp
WHERE  hiredate < '1981-09-08'

-- != 等於 NOT
SELECT *
FROM   city
WHERE  CountryCode != 'TWN'


SELECT *
FROM   city
WHERE  NOT CountryCode = 'TWN'

-- 多判斷式結合 (AND OR)
SELECT *
FROM   city
WHERE  CountryCode = 'TWN' AND Population < 100000


SELECT *
FROM   city
WHERE  CountryCode = 'TWN' OR CountryCode='USA'


SELECT Name, Continent, Population
FROM   country
WHERE  Continent='Europe' OR Continent='Africa' AND Population<10000


SELECT Name, Continent, Population
FROM   country
WHERE  (Continent='Europe' OR Continent='Africa') AND Population<10000

-- 介於 BETWEEN : 包含等號 (日期與數值區間)
SELECT *
FROM   city
WHERE  Population >= 80000 AND Population <= 90000


SELECT *
FROM   city
WHERE  Population BETWEEN 80000 AND 90000


SELECT *
FROM   city
WHERE  Population > 80000 AND Population < 90000


SELECT *
FROM   city
WHERE  Population BETWEEN 80000 AND 90000

-- 日期也可用 BETWEEN
SELECT ename, hiredate
FROM   cmdev.emp
WHERE  hiredate BETWEEN '1981-01-01' AND '1981-06-30'

-- 多判斷寫法 當 CountryCode 有符合其中一個 (IN)
SELECT *
FROM   city
WHERE  CountryCode = 'TWN' OR 
       CountryCode = 'USA' OR
       CountryCode = 'JPN' OR
       CountryCode = 'ITA' OR
       CountryCode = 'KOR'


SELECT *
FROM   city
WHERE  CountryCode IN ('TWN','USA','JPN','ITA','KOR')

-- 空值判斷用 = 錯誤
SELECT Name, LifeExpectancy
FROM   country
WHERE  LifeExpectancy = NULL

-- 空值判斷用 IS <=>
SELECT Name, LifeExpectancy
FROM   country
WHERE  LifeExpectancy IS NULL


SELECT Name, LifeExpectancy
FROM   country
WHERE  LifeExpectancy <=> NULL

-- 空值判斷用 <> 錯誤
SELECT Name, LifeExpectancy
FROM   country
WHERE  LifeExpectancy <> NULL

-- 非空值
SELECT Name, LifeExpectancy
FROM   country
WHERE  LifeExpectancy IS NOT NULL

-- 模糊比對(搜尋引擎) VS 精準比對(帳號密碼) --> (是否只取字串片段)
SELECT Name FROM   city WHERE  Name = 'w' -- 精準比對


SELECT Name
FROM   city
WHERE  Name LIKE 'w' -- 精準比對 (但可加更多變化)

-- (正則?) % : 一個以上任意字元
SELECT Name
FROM   city
WHERE  Name LIKE 'w%' -- 字首


SELECT Name
FROM   city
WHERE  Name LIKE 'w%' 


SELECT Name
FROM   city
WHERE  Name LIKE '%w' -- 字尾


SELECT Name
FROM   city
WHERE  Name LIKE '%w%' -- 只要有包含

-- 限定字數長度
SELECT Name
FROM   city
WHERE  Name LIKE 'w_____' -- w 開頭後面任意五個字 (共六個字)


SELECT Name
FROM   city
WHERE  Name LIKE '_____w' -- w 結尾前面任意五個字 (共六個字)


SELECT Name
FROM   city
WHERE  Name LIKE '_____w%' -- w 前面任意五個字，w 後面任意字數


SELECT Name
FROM   city
WHERE  Name LIKE '______________________________%'
