-- 建立實體資料表 (建立時的資料，備份)
CREATE TABLE Louis AS
SELECT   Continent, Region, Code, Code2, Name
FROM     country
ORDER BY Continent, Region, Code

-- 檢視表 --> 連結/語法 (點入等同執行語法，即時更新資料表)
-- 檢視表與原始表連動 (其一更改刪除另一都會改變)
CREATE VIEW CountryView AS
SELECT   Continent, Region, Code, Code2, Name
FROM     world.country
ORDER BY Continent, Region, Code


SELECT * FROM CountryView


SELECT   Continent, COUNT(*)
FROM     CountryView
GROUP BY Continent


SELECT Name, Language
FROM   CountryView, world.countrylanguage
WHERE  Code = CountryCode
