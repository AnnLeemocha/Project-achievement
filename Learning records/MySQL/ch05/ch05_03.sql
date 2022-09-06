-- 更新薪水 (所有人)
UPDATE cmdev.emp
SET    salary = salary + 100

-- 特定條件下 更新薪水
UPDATE cmdev.emp
SET    salary = salary + 100
WHERE  salary < 1500

-- 更改部門編號 (注意變更之編號有無重複)
UPDATE cmdev.dept
SET    deptno = 50
WHERE  deptno = 30

-- 忽略錯誤訊息，但還是有重複值問題，有錯誤則以不更新處理
UPDATE IGNORE cmdev.dept
SET    deptno = 50
WHERE  deptno = 30

-- 字串塞入整數型態(0)
UPDATE cmdev.emp
SET    salary = 'HELLO', comm = 1000
WHERE  empno = 7369 -- 搜尋依據(無則不更新，但不跳錯)

-- 字串塞入整數型態(0)，還是有更新
UPDATE IGNORE cmdev.emp
SET    salary = 'HELLO', comm = 3000
WHERE  empno = 7369 -- 搜尋依據(無則不更新，但不跳錯)


UPDATE   cmdev.emp
SET      salary = salary + 100
ORDER BY salary

-- 原序前三 更新薪水
UPDATE   cmdev.emp
SET      salary = salary + 100
LIMIT    3

-- 排序(升) 前三 更新薪水
UPDATE   cmdev.emp
SET      salary = salary + 100
ORDER BY salary
LIMIT    3

-- 排序(降) 前三 更新薪水
UPDATE   cmdev.emp
SET      salary = salary + 100
ORDER BY salary DESC
LIMIT    3

-- 加入條件
UPDATE   cmdev.emp
SET      salary = salary + 100
WHERE    salary < 2000
ORDER BY salary
LIMIT    3
