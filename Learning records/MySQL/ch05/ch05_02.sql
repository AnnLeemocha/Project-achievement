-- 插入資料
INSERT INTO cmdev.dept VALUES (60, 'EDU', 'NEW YORK')

-- DEFAULT 用 DESC 可知適用否 (注意不同重複值之欄位(最前面的編號))
INSERT INTO cmdev.dept
VALUES (70, 'MARKETING', DEFAULT)

-- 少寫欄位會出現錯誤
INSERT INTO cmdev.dept
VALUES (80, 'PURCHASING')

-- 欄位順序錯誤，雖然照塞入，但有警告問題
INSERT INTO cmdev.dept
VALUES ('PURCHASING', 80, 'NEW YORK')

-- 給欄位順序後，再依順序塞入
INSERT INTO cmdev.dept (dname, deptno, location)
VALUES ('PURCHASING', 80, 'NEW YORK')

-- 給欄位順序後，少寫欄位會出現直接走DEFAULT
INSERT INTO cmdev.dept (deptno, dname, location)
VALUES (90, 'SHIPPING')


INSERT INTO cmdev.dept
VALUES (90, 'SHIPPING', DEFAULT)

-- 給欄位順序，但少給，就算無DEFAULT也可以插入，但為空白，為很差的資料
INSERT INTO cmdev.dept (deptno, dname)
VALUES (90, 'SHIPPING')


INSERT INTO cmdev.dept (deptno, location)
VALUES (80, 'NEW YORK')

-- 插入空，也可成功，但為很差的資料
INSERT INTO cmdev.dept () VALUES ()


INSERT INTO cmdev.dept (deptno, dname)
VALUES (90, 'SHIPPING')

-- INSERT INTO 用 VALUES 用 SET 兩種插入方法
INSERT INTO cmdev.dept 
SET deptno = 90, dname = 'SHIPPING'

-- 插入多筆
INSERT INTO cmdev.emp VALUES 
(8001, 'SIMON', 'MANAGER', 7369, '2001-02-03', 3300, NULL, 50),
(8002, 'JOHN', 'PROGRAMMER', 8001, '2002-01-01', 2300, NULL, 50),
(8003, 'GREEN', 'ENGINEER', 8001, '2003-05-01', 2000, NULL, 50)

-- INSERT INTO
INSERT INTO cmdev.dept
VALUES (50, 'MIS', DEFAULT);

-- INSERT IGNORE INTO (忽略錯誤訊息，但還是有重複值問題，有則以不插入處理)
INSERT IGNORE INTO cmdev.dept
VALUES (50, 'MIS', DEFAULT);


INSERT IGNORE INTO cmdev.dept
VALUES (500, 'MIS', DEFAULT);

-- 員工編號 地點 次數
SELECT *
FROM   cmdev.travel
WHERE  empno = 7900 AND 
       location = 'BOSTON'


INSERT INTO cmdev.travel
VALUES (7900, 'BOSTON', 1);

-- 更新次數(修改某欄位數據) UPDATE ---> SET 欄位 = 欄位+1
UPDATE cmdev.travel
SET    counter = counter + 1
WHERE  empno = 7900 AND 
       location = 'BOSTON'

-- 插入 1.沒去過 2.曾去過更新次數
-- ON DUPLICATE KEY (複製)
INSERT INTO cmdev.travel
VALUES (7900, 'BOSTON', 1)
ON DUPLICATE KEY UPDATE counter = counter + 1


INSERT INTO cmdev.dept
VALUES (50, 'MIS', DEFAULT)


INSERT IGNORE INTO cmdev.dept
VALUES (50, 'MIS', DEFAULT)

-- 取代 (單一位置更改內容) REPLACE INTO
REPLACE INTO cmdev.dept
VALUES (50, 'MIS', DEFAULT)
