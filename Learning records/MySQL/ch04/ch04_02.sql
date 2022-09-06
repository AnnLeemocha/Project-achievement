-- 選取多表格之欄位
SELECT country.Code, country.Capital, city.Name
FROM   country, city
WHERE  country.Capital = city.ID

-- 只要多表格中無相同欄位名 (省略)
SELECT Code, Capital, city.Name
FROM   country, city
WHERE  Capital = ID

-- 多表格中有重複欄位名就會顯示錯誤
SELECT Code, Capital, Name
FROM   country, city
WHERE  Capital = ID

-- 欄位 別名
SELECT country.name, country.Population coPop,
        city.Name, city.Population ciPop,
        city.Population / country.Population * 100 Scale
FROM   country, city
WHERE  Capital = ID

-- 表格 別名 (1)
SELECT country.name, country.Population coPop,
       city.Name, city.Population ciPop,
       city.Population / country.Population * 100
FROM   country a, city b
WHERE  Capital = ID

-- 表格 別名 (2)
SELECT a.name, a.Population coPop,
       b.Name, b.Population ciPop,
       b.Population / a.Population * 100
FROM   country a, city b
WHERE  Capital = ID

-- 表格A INNER JOIN (內結合) 表格B ON 條件 (同上)
SELECT Code, Capital, city.Name
FROM   country INNER JOIN city ON Capital = ID

-- INNER JOIN  ON + 別名
SELECT a.name, a.Population coPop,
       b.Name, b.Population ciPop,
       b.Population / a.Population * 100
FROM   country a INNER JOIN city b ON Capital = ID


SELECT empno, ename, dname
FROM   cmdev.emp e, cmdev.dept d
WHERE  e.deptno = d.deptno


SELECT empno, ename, dname
FROM   cmdev.emp e INNER JOIN cmdev.dept d
       ON e.deptno = d.deptno

-- 兩個表格欄位名稱相同 ON -> USING
SELECT empno, ename, dname
FROM   cmdev.emp e INNER JOIN cmdev.dept d
       USING (deptno)
