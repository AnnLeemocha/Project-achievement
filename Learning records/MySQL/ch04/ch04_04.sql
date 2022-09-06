SELECT Region, Name, Population
FROM   country
WHERE  Region = 'Southeast Asia' AND Population < 2000000


SELECT Region, Name, Population
FROM   country
WHERE  Region = 'Eastern Asia' AND Population < 1000000

-- UNION 同時顯示多種查詢結果，查詢結果並在後面 (欄位需要相同)
SELECT Region, Name, Population
FROM   country
WHERE  Region = 'Southeast Asia' AND Population < 2000000
UNION
SELECT Region, Name, Population
FROM   country
WHERE  Region = 'Eastern Asia' AND Population < 1000000

-- UNION 合併多次查詢，注意欄位名稱不同就很奇怪 (還是可以併)
SELECT Region, Name, Population
FROM   country
WHERE  Region = 'Southeast Asia' AND Population < 2000000
UNION
SELECT Region, Name, Population
FROM   country
WHERE  Region = 'Eastern Asia' AND Population < 1000000
UNION
SELECT ename, job, salary
FROM   cmdev.emp
WHERE  salary < 1000


SELECT Region, Name, Population
FROM   country
WHERE  Region = 'Southeast Asia' AND Population < 2000000
UNION
SELECT Region, Name, Population
FROM   country
WHERE  Region = 'Eastern Asia' AND Population < 1000000
UNION
SELECT ename, job, salary, comm
FROM   cmdev.emp
WHERE  salary < 1000

-- 用 WHERE -> OUT1接OUT2 用 UNION -> 按照順序OUT1，OUT2交替 (輸出順序問題)
SELECT Region, Name, Population
FROM   country
WHERE  (Region = 'Southeast Asia' AND Population < 2000000) OR
       (Region = 'Eastern Asia' AND Population < 1000000)


SELECT Region, Name, Population
FROM   country
WHERE  Region = 'Southeast Asia' AND Population < 2000000
UNION
SELECT Region, Name, Population
FROM   country
WHERE  Region = 'Eastern Asia' AND Population < 1000000
