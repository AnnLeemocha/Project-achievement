# ch10 example

> ch10_01
- 子查詢語法 (前結果後再判斷)
    - EX. SELECT Code, Population
          FROM   country
          WHERE  Population > ( SELECT Population
                                FROM   country
                                WHERE  Code = 'USA' )

> ch10_02
- 子查詢注意事項：
    - 注意，判斷式後的查詢欄位數量必須相符
    -  ... WHERE  欄位1 = ( SELECT 欄位2, 欄位3 ... ) <= 錯誤(多放一)
- 不同資料表再查詢： (IN/NOT IN)
    - WHERE  欄位1 = ( SELECT 欄位2 FROM 資料表 WHERE 欄位3>? ) <= 錯誤(多放一)
    - EX. SELECT Name
            FROM   country
            WHERE  Code IN/NOT IN ( SELECT CountryCode
                            FROM   city
                            WHERE  Population > 9000000 )
    - EX. SELECT * 
          FROM   outertable
          WHERE  n <> ALL ( SELECT n
                            FROM   innertable )
- 兩資料表有無交集補充：
    - <> (不包含) / IN / NOT IN
    - ALL：是所有，表示全部都满足才返回true (找尋無交集資料)
    - ANY/SOME：是任意一个，似OR，表示有任何一个滿足就返回true (找尋交集資料)
- 多條件篩選 + 子查詢：
    - EX. SELECT Name
           FROM   country
           WHERE  Region = ( SELECT Region
                             FROM   country
                             WHERE  Name = 'Iraq' )
                  AND
                  GovernmentForm = ( SELECT GovernmentForm
                                     FROM   country
                                     WHERE  Name = 'Iraq' )
- 多條件篩選 + 子查詢 (簡併)：
    - 使用先決條件，子查詢的判斷式相同
    - EX. SELECT Name
          FROM   country
          WHERE  (Region, GovernmentForm) = ( SELECT Region, GovernmentForm
                                              FROM   country
                                              WHERE  Name = 'Iraq' )
- 多條件 + 子查詢 (簡併) + 分群：
    - EX. SELECT Continent, Name, GNP
          FROM   country
          WHERE  (Continent, GNP) IN ( SELECT   Continent, MAX(GNP)
                                       FROM     country
                                       GROUP BY Continent )

> ch10_03
- 串接語法：
    - CONCAT(字串, 欄位名稱)
- 子查詢 + 串接：
    - 於該數據位置作子查詢
    - EX. SELECT CONCAT('The GNP of Japan is ',
                 ( SELECT GNP FROM country WHERE  Name = 'Japan' ) )
- 子查詢 + 運算：
    - 於該數據位置作子查詢
    - EX. SELECT ( SELECT Population FROM country WHERE Name = 'India' ) /
                 ( SELECT SUM(Population) FROM country )

> ch10_04
- 子查詢 + 排序：
    - 一定要給自查詢產出的資料表暫時的資料表別名
    - EX. SELECT   Name, GNP
          FROM     ( SELECT *
                     FROM   country
                     WHERE  Continent = 'Asia' ) asiacountry 
          ORDER BY GNP DESC
          LIMIT    10
- 子查詢 + 多表格篩選：
    - EX. SELECT Name, Language, Population * Percentage
          FROM   country, ( SELECT CountryCode, Language, Percentage
                            FROM   countrylanguage
                            WHERE  IsOfficial = 'T' ) officiallanguage
          WHERE  Code = CountryCode

> ch10_05
- 子查詢 + 插入資料：
    - 注意，插入資料時欄位輸入數量不要超過要插入的資料表
    - EX. INSERT INTO mycountry
          ( SELECT Code, Name, Continent, Region, Population, GNP
            FROM country
           WHERE Continent = 'Asia' )
- 子查詢 + 更新資料：
    - EX. UPDATE cmdev.emp
          SET    salary = salary * 1.05
          WHERE  deptno = ( SELECT deptno
                            FROM   cmdev.dept
                            WHERE  dname = 'SALES' )

> ch10_06
- 子查詢 + 別名：
    - EX. SELECT Continent, Name, GNP
          FROM   country oc
          WHERE  GNP = ( SELECT MAX(GNP) 
                         FROM   country
                         WHERE  Continent = oc.Continent )
- 子查詢 + 多表格： (存不存在)
    - EXISTS 存在 / NOT EXISTS 不存在
    - EX. SELECT Name
          FROM   country c
          WHERE  EXISTS / NOT EXISTS ( SELECT *
                          FROM   city
                          WHERE  CountryCode = c.Code AND
                                 Population > 8000000 )

> ch10_07
- 子查詢 + 交集/反交集：
    - EX. SELECT Name
          FROM   city
          WHERE  ID IN / NOT IN ( SELECT Capital 
                         FROM   country
                         WHERE  Capital IS NOT NULL )
- 補充NULL判斷：
    - IS NOT NULL
    - IS NULL
