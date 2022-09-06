-- 多欄位 + 子查詢
SELECT Continent, Name, GNP
FROM   country
WHERE  (Continent, GNP) IN ( SELECT   Continent, MAX(GNP)
                             FROM     country
                             GROUP BY Continent )

-- 子查詢 + 別名
SELECT Continent, Name, GNP
FROM   country oc
WHERE  GNP = ( SELECT MAX(GNP) -- 分群函式？
               FROM   country
               WHERE  Continent = oc.Continent )

-- 多表格 + 子查詢 (EXISTS 存在)
SELECT Name
FROM   country c
WHERE  EXISTS ( SELECT *
                FROM   city
                WHERE  CountryCode = c.Code AND
                       Population > 8000000 )

-- 多表格 + 子查詢 (NOT EXISTS 不存在)
SELECT Name
FROM   country c
WHERE  NOT EXISTS ( SELECT *
                    FROM   city
                    WHERE  CountryCode = c.Code AND
                           Population > 8000000 )
