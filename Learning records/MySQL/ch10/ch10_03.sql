-- 連接
SELECT CONCAT('The GNP of Japan is ', GNP)
FROM   country
WHERE  Name = 'Japan'

-- 連接 + 子查詢 (於該數據位置作子查詢)
SELECT CONCAT('The GNP of Japan is ',
       ( SELECT GNP FROM country WHERE  Name = 'Japan' ) )

-- 子查詢 + 運算 (於該數據位置作子查詢)
SELECT ( SELECT Population FROM country WHERE Name = 'India' ) /
       ( SELECT SUM(Population) FROM country )
