-- 設定忽略空白
SET sql_mode='IGNORE_SPACE'

-- 套件函式庫 DATEDIFF [日期差異天數計算排行] 
SELECT ename,hiredate,DATEDIFF('2007-01-01',hiredate) days
FROM   emp

-- 套件函式庫  LPAD [Name 可以有50個字，若只占5個字其他補空白]
SELECT LPAD(Name, 50, ' ')
FROM   country
WHERE  Continent='Antarctica'

-- 套件函式庫  LEFT 從左邊開始抓兩個字   RIGHT  從右邊開始抓兩個字
-- SUBSTRING 從第2個開始抓到結尾 取三個字
SELECT   LEFT('ABCDE', 2), RIGHT('ABCDE', 2),
         SUBSTRING('ABCDE', 2), SUBSTRING('ABCDE', 2, 3)


SELECT Name || ', ' || Continent || ', ' || Region
FROM   country

-- CONCAT_WS 串接資料 並決定連接符號
SELECT CONCAT_WS(', ', Name, Continent, Region)
FROM   country

-- LENGTH(欄位) 取欄位內容的長度
SELECT   Name, LENGTH(Name) length
FROM     country
ORDER BY length DESC

-- LOCATE 找尋' '位置 (6)
-- 找第一個單字 (0~5)
-- 在 LOCATE 不等於 0 時 (至少要找到一個空白)
SELECT LEFT(Name, LOCATE(' ', Name) - 1) NameOfFirstWord
FROM   country
WHERE  LOCATE(' ', Name) <> 0

-- ROUND 四捨五入 (預設整數)
-- CEIL  無條件進位
-- FLOOR 無條件捨去
SELECT ROUND(3.14159), ROUND(3.14159, 3),
       CEIL(3.14159), FLOOR(3.14159)

-- 亂數排序
SELECT   Name
FROM     country
ORDER BY RAND()
LIMIT    3

-- CURDATE() [抓取目前時間點]
-- YEAR(CURDATE()) [時間只取年份]
SELECT   Name, YEAR(CURDATE()) - IndepYear years -- 資料出現負值
FROM     country
ORDER BY years DESC

-- DAYNAME(date)  返回日期的星期名稱。  用此函數產生星期幾

-- 萃取欄位(hiredate)年份，月份，日
SELECT YEAR(hiredate) hire_year,
       MONTH(hiredate) hire_month,
       DAY(hiredate) hire_day
FROM   cmdev.emp

-- 同上
SELECT EXTRACT(YEAR FROM hiredate) hire_year,
       EXTRACT(MONTH FROM hiredate) hire_month,
       EXTRACT(DAY FROM hiredate) hire_day
FROM   cmdev.emp

-- ADDDATE 日期增加 30 天
SELECT ename, hiredate,
       ADDDATE(hiredate, 30),
       ADDDATE(hiredate, INTERVAL 30 DAY) -- 間隔 30 天
FROM   cmdev.emp e; -- 別稱 e = cmdev.emp (多表格查詢快)

-- IF(判斷式, 成立結果, 不成立結果)
SELECT   ename, hiredate,
         IF( YEAR(hiredate) < 1985, 'Senior', 'General') grade
FROM     cmdev.emp
ORDER BY hiredate

-- 加薪策略 資深+2.5 菜鳥+1.2
SELECT   ename, hiredate,
         salary * IF( YEAR(hiredate) < 1985, 2.5, 1.2) bonus
FROM     cmdev.emp
ORDER BY hiredate

-- 當 條件一成立... 條件二成立... 條件三成立... 結束
SELECT   ename, salary,
         CASE
           WHEN salary >= 3000 THEN 'A'
           WHEN salary >= 1000 AND salary <= 2999 THEN 'B'
           WHEN salary < 1000 THEN 'C'
         END SalaryGrade
FROM     cmdev.emp
ORDER BY salary DESC

-- 當 條件一成立... 條件二成立... 其餘... 結束
SELECT   ename, salary,
         CASE
           WHEN salary >= 3000 THEN 'A'
           WHEN salary >= 1000 AND salary <= 2999 THEN 'B'
           ELSE 'C'
         END SalaryGrade
FROM     cmdev.emp
ORDER BY salary DESC


SELECT   ename, salary, salary *
         CASE
           WHEN salary >= 3000 THEN 2.5
           WHEN salary >= 1000 AND salary <= 2999 THEN 1.5
           ELSE 1.2
         END bonus
FROM     cmdev.emp
ORDER BY salary DESC

-- 州別代碼 CASE 判斷欄位
SELECT Name, Continent,
       CASE Continent
         WHEN 'Asia' THEN 'AS'
         WHEN 'Europe' THEN 'EU'
         WHEN 'Africa' THEN 'AF'
         WHEN 'Oceania' THEN 'OA'
         WHEN 'Antarctica' THEN 'AN'
         WHEN 'North America' THEN 'NA'
         WHEN 'South America' THEN 'SA'
       END ContinentCode
FROM country

-- 州別代碼
SELECT Name, Continent,
       CASE
         WHEN Continent='Asia' THEN 'AS'
         WHEN Continent='Europe' THEN 'EU'
         WHEN Continent='Africa' THEN 'AF'
         WHEN Continent='Oceania' THEN 'OA'
         WHEN Continent='Antarctica' THEN 'AN'
         WHEN Continent='North America' THEN 'NA'
         WHEN Continent='South America' THEN 'SA'
       END ContinentCode
FROM country

-- 無法避免空值運算問題，其一為NULL加總為NULL
SELECT ename, salary, comm, salary + comm FullSalary
FROM   cmdev.emp

-- 避免空值運算問題，若為NULL則用0來相加 (原始NULL值保留)
SELECT ename,salary,comm,salary + IFNULL(comm, 0) FullSalary
FROM   cmdev.emp
