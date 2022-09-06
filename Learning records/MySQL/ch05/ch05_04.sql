-- 刪除整個 cmdev.emp 內容
DELETE FROM cmdev.emp

-- 刪除+條件
DELETE FROM  cmdev.emp
WHERE  salary < 1500

-- 排序後還是刪除整個 
DELETE FROM cmdev.emp
ORDER BY salary

-- 刪除前三 
DELETE FROM cmdev.emp
LIMIT    3

-- 刪除排序(升)前三 [小]
DELETE FROM cmdev.emp
ORDER BY salary
LIMIT    3

-- 刪除排序(降)前三 [大]
DELETE FROM cmdev.emp
ORDER BY salary DESC
LIMIT    3

-- 刪除整個 cmdev.emp 內容
DELETE FROM cmdev.emp

-- 刪除整個 cmdev.emp 內容
TRUNCATE TABLE cmdev.emp
