-- 檢視表，用修改的方式改變欄位數 (3->4)
ALTER VIEW CountryMaxGNP AS
SELECT Continent, Code, Name, GNP
FROM   world.country
WHERE  (Region, GNP) IN ( SELECT   Region, MAX(GNP)
                          FROM     world.country
                          GROUP BY Region )

-- 檢視表，用建立或覆蓋的方式改變欄位數 (3->4)
CREATE OR REPLACE VIEW CountryMaxGNP AS
SELECT Continent, Code, Name, GNP
FROM   country
WHERE  (Region, GNP) IN ( SELECT   Region, MAX(GNP)
                          FROM     country
                          GROUP BY Region )

-- 刪除檢視表
DROP VIEW CountryMax

-- 刪除檢視表 (有澤山，無則不報錯)
DROP VIEW IF EXISTS CountryMax