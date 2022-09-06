-- 使用(進入) world
USE world  

-- 運算式 : 顯示字串與數學式
SELECT 'My name is Simon Johnson', 35 * 12 
SELECT 'My name is Simon Johnson' Name, 35 * 12 'Value'

-- 沒說在哪個資料庫底下 先到 world
SELECT * FROM city 

-- 有指定資料庫在哪都可用
SELECT * FROM cmdev.emp 


SELECT * FROM city

-- city 中找 ID, Name
SELECT ID, Name 
FROM   city

-- 顯示順序改變
SELECT Name, ID 
FROM   city


SELECT ID, Name, District
FROM   city 

 -- 運算: 年薪+獎金 (DIV:除法)
SELECT ename, salary, salary * 12,
       (salary * 12) + (salary DIV 2)
FROM   cmdev.emp

-- 欄位 AS 別名
SELECT ename, salary AS MonthSalary,
       salary * 12 AS AnnualSalary,
       (salary * 12) + (salary DIV 2) AnnualFullSalary
FROM   cmdev.emp

-- 欄位 別名 (AS 可省略)
SELECT ename, salary MonthSalary,
       salary * 12 AnnualSalary,
       (salary * 12) + (salary DIV 2) AnnualFullSalary
FROM   cmdev.emp

-- 別名要用關鍵字與空白一定要加引號
SELECT ename, salary * 12 AS 'Annual Salary'
FROM   cmdev.emp


SELECT ename, salary * 12 AS 'select'
FROM   cmdev.emp
