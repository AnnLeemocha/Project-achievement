-- 限定比數 : LIMIT 比數
SELECT empno, ename 
FROM   cmdev.emp 
LIMIT  5

-- 限定比數 : LIMIT 起始位置 比數
SELECT empno, ename 
FROM   cmdev.emp 
LIMIT  5, 5

-- 排序 ORDER BY 欄位名 升序(ASC)/降序(DESC) [不寫預設為升序]
SELECT   empno, ename, salary
FROM     cmdev.emp
ORDER BY salary DESC
LIMIT    3


SELECT   empno, ename, salary
FROM     cmdev.emp
ORDER BY salary ASC
LIMIT    3

-- 顯示全部
SELECT Continent FROM country


SELECT ALL Continent FROM country

-- 去除重複 (只顯示一次) --> 幾種類別
SELECT DISTINCT Continent FROM country