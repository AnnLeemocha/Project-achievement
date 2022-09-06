-- 子查詢 + 交集 (IS NOT NULL)
SELECT Name
FROM   city
WHERE  ID IN ( SELECT Capital 
               FROM   country
               WHERE  Capital IS NOT NULL )


SELECT city.Name
FROM   city, country
WHERE  ID = Capital

-- 子查詢 + 反交集 (IS NOT NULL)
SELECT Name
FROM   city
WHERE  ID NOT IN ( SELECT Capital 
                   FROM   country
                   WHERE  Capital IS NOT NULL )


SELECT city.Name, country.Capital
FROM   city LEFT JOIN country ON city.ID = country.Capital


SELECT city.Name
FROM   city LEFT JOIN country ON city.ID = country.Capital
WHERE  country.Capital IS NULL
