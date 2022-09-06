-- 排序 + 子查詢
SELECT   Name, GNP
FROM     ( SELECT *
           FROM   country
           WHERE  Continent = 'Asia' ) asiacountry -- 一定要給暫時的資料表別名
ORDER BY GNP DESC
LIMIT    10

-- 子查詢得暫時資料表
SELECT Name, Language, Population * Percentage
FROM   country, ( SELECT CountryCode, Language, Percentage
                  FROM   countrylanguage
                  WHERE  IsOfficial = 'T' ) officiallanguage
WHERE  Code = CountryCode
