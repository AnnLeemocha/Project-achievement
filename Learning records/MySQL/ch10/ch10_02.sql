SELECT Name, GNP
FROM   country
WHERE  GNP = ( SELECT MAX(GNP)
               FROM   country )

-- = 再查詢可否用兩個欄位 (語法不通，X) ---> 多放一
SELECT Name, GNP
FROM   country
WHERE  GNP = ( SELECT Code, MAX(GNP)
               FROM   country )

-- = 可否分群再查詢 (語法不通，X) ---> 多放一
SELECT Name, GNP
FROM   country
WHERE  GNP = ( SELECT   MAX(GNP)
               FROM     country
               GROUP BY Continent )


SELECT CountryCode
FROM   city
WHERE  Population > 9000000


SELECT Name
FROM   country
WHERE  Code IN ('BRA','IDN','IND',
                'CHN','KOR','PAK')

-- 不同資料表再查詢，使用 IN 放多筆
SELECT Name
FROM   country
WHERE  Code IN ( SELECT CountryCode
                 FROM   city
                 WHERE  Population > 9000000 )

-- = 不同資料表再查詢，使用 = 放多筆 (語法不通，X) ---> 多放一
SELECT Name
FROM   country
WHERE  Code = ( SELECT CountryCode
                FROM   city
                WHERE  Population > 9000000 )

-- 不同資料表再查詢，使用 NOT IN 放多筆
SELECT Name
FROM   country
WHERE  Code NOT IN ( SELECT CountryCode
                     FROM   city
                     WHERE  Population > 9000000 )


SELECT * FROM outertable


SELECT * FROM innertable

-- 再查詢成功但無資料
SELECT * 
FROM   outertable
WHERE  n > ALL ( SELECT n
                 FROM   innertable )
				 
-- 找尋無交集資料 <> ALL (不包含)
SELECT * 
FROM   outertable
WHERE  n <> ALL ( SELECT n
                  FROM   innertable )
				  
-- 找尋無交集資料 NOT IN (不包含)
SELECT * 
FROM   outertable
WHERE  n NOT IN ( SELECT n
                  FROM   innertable )

-- ANY (似 OR)，只要有一個成立就通過
-- 找尋交集資料 ANY
SELECT * 
FROM   outertable
WHERE  n = ANY ( SELECT n
                 FROM   innertable )

-- 找尋交集資料 IN
SELECT * 
FROM   outertable
WHERE  n IN ( SELECT n
              FROM   innertable )

-- 多條件 1
SELECT Name, GNP
FROM   country
WHERE  Continent = 'Asia' AND GovernmentForm = 'Republic'

-- 多條件 2
SELECT Name, GNP
FROM   country
WHERE  ( Continent, GovernmentForm ) = ( 'Asia', 'Republic' )

-- 多條件 + 子查詢
SELECT Name
FROM   country
WHERE  Region = ( SELECT Region
                  FROM   country
                  WHERE  Name = 'Iraq' )
       AND
       GovernmentForm = ( SELECT GovernmentForm
                          FROM   country
                          WHERE  Name = 'Iraq' )

-- 多條件 + 子查詢 (使用先決條件，子查詢是同一個判斷式，簡併)
SELECT Name
FROM   country
WHERE  (Region, GovernmentForm) = ( SELECT Region, GovernmentForm
                                    FROM   country
                                    WHERE  Name = 'Iraq' )


SELECT   Continent, MAX(GNP)
FROM     country
GROUP BY Continent

-- 多條件 + 分群再查詢
SELECT Continent, Name, GNP
FROM   country
WHERE  (Continent, GNP) IN ( SELECT   Continent, MAX(GNP)
                             FROM     country
                             GROUP BY Continent )
