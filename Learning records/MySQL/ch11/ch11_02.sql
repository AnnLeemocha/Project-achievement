-- 檢視表 + 子查詢
CREATE VIEW CountryMaxGNP AS
SELECT Name, GNP
FROM   world.country
WHERE  (Region, GNP) IN ( SELECT   Region, MAX(GNP)
                          FROM     world.country
                          GROUP BY Region )

-- 想多一欄位，但又名稱重複
CREATE VIEW CountryMaxGNP AS
SELECT Code, Name, GNP
FROM   world.country
WHERE  (Region, GNP) IN ( SELECT   Region, MAX(GNP)
                          FROM     world.country
                          GROUP BY Region )

-- 名稱重複，則覆蓋修改 CREATE OR REPLACE VIEW 
CREATE OR REPLACE VIEW CountryMaxGNP AS
SELECT Code, Name, GNP
FROM   world.country
WHERE  (Region, GNP) IN ( SELECT   Region, MAX(GNP)
                          FROM     world.country
                          GROUP BY Region )


DESC CountryMaxGNP


SELECT co.Name, ci.Name, co.Population, ci.Population,
       ROUND(ci.Population / co.Population, 2) Scale
FROM   world.country co, world.city ci
WHERE  co.Code = ci.CountryCode

-- 檢視表建立時，欄位名稱重複錯誤
CREATE VIEW ScaleView AS
SELECT co.Name, ci.Name, co.Population, ci.Population,
       ROUND(ci.Population / co.Population, 2) Scale
FROM   world.country co, world.city ci
WHERE  co.Code = ci.CountryCode


CREATE VIEW ScaleView AS
SELECT co.Name CountryName, ci.Name CityName,
       co.Population CountryPop, ci.Population CityPop,
       ROUND(ci.Population / co.Population, 2) Scale
FROM   world.country co, world.city ci
WHERE  co.Code = ci.CountryCode

-- 檢視表先給欄位名稱 AS 再給篩選的資料表
CREATE VIEW ScaleView2 
(CountryName, CityName, CountryPop, CityPop, Scale)
AS
SELECT co.name, ci.Name, co.Population, ci.Population,
       ROUND(ci.Population / co.Population, 2) Scale
FROM   world.country co, world.city ci
WHERE  co.Code = ci.CountryCode
