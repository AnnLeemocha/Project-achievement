-- 建立檢視表
CREATE VIEW cmdev.EmpDept30View AS
SELECT empno, ename, job, manager, hiredate, salary, comm
FROM   cmdev.emp
WHERE  deptno = 30

-- 更新檢視表 (原始表也跟著更改)
UPDATE EmpDept30View
SET    comm = 600
WHERE  empno = 7844


SELECT * FROM EmpDept30View WHERE empno = 7844
SELECT * FROM emp WHERE empno = 7844

-- 插入檢視表  (檢視表無 deptno (=30)，所以無法插入檢視表，但原始表中有插入)
INSERT INTO EmpDept30View
VALUES (9001, 'SIMON', 'SALESMAN', 7698, 
        '2000-04-01', 1000, 250)


SELECT * FROM EmpDept30View WHERE empno = 9001
SELECT * FROM emp WHERE empno = 9001

-- 檢視表中刪除原始表才有的東西，則甚麼都沒發生
DELETE FROM EmpDept30View WHERE empno = 9001


SELECT * FROM EmpDept30View WHERE empno = 9001
SELECT * FROM emp WHERE empno = 9001

-- WITH CHECK OPTION 會幫判斷檢視表的條件，符合條件才插入，否則錯誤 (防呆裝置)
CREATE OR REPLACE VIEW cmdev.EmpDept30View AS
SELECT empno, ename, job, manager, hiredate, salary, comm
FROM   cmdev.emp
WHERE  deptno = 30
WITH CHECK OPTION

-- 防呆出現
INSERT INTO EmpDept30View
VALUES (9002, 'MARY', 'SALESMAN', 7698,
        '2000-05-01', 1200, 150)
		
-- 加入條件欄位
CREATE OR REPLACE VIEW cmdev.EmpDept30View2 AS
SELECT empno, ename, job, manager, hiredate, salary, comm, deptno
FROM   cmdev.emp
WHERE  deptno = 30
WITH CHECK OPTION

-- 防呆出現
INSERT INTO EmpDept30View2
VALUES (9002, 'MARY', 'SALESMAN', 7698,
        '2000-05-01', 1200, 150)
-- 防呆出現
INSERT INTO EmpDept30View2
VALUES (9003, 'MARY', 'SALESMAN', 7698,
        '2000-05-01', 1200, 150, 15)
-- 條件符合，成功插入
INSERT INTO EmpDept30View2
VALUES (9003, 'MARY', 'SALESMAN', 7698,
        '2000-05-01', 1200, 150, 30)


UPDATE EmpDept30View2
SET    comm = 1200
WHERE  empno = 7844

-- 建立薪水檢視表
CREATE VIEW cmdev.EmpSalaryView AS
SELECT * FROM cmdev.emp WHERE salary >= 1500

-- 依薪水檢視表建立新檢視表
-- WITH LOCAL CHECK OPTION (預設同為 LOCAL 只判斷本地條件符不符合)
CREATE OR REPLACE VIEW cmdev.EmpDept20View AS
SELECT * FROM cmdev.EmpSalaryView WHERE deptno = 20
WITH LOCAL CHECK OPTION


SELECT * FROM EmpDept20View

-- 新檢視表判斷條件的欄位更改，條件不符合(不允許通過)，錯誤
UPDATE EmpDept20View
SET    deptno = 30
WHERE  empno = 7566

-- 成功更改，但不符合薪水檢視表，只有在原始表砍到更改後資訊
-- 一層歸一層，原始+條件-->薪水檢視表+新條件-->新檢視表 (故更新後該筆資料消失於薪水與新簡檢視表中)
UPDATE EmpDept20View
SET    salary = 1000
WHERE  empno = 7566

-- WITH CASCADED CHECK OPTION (判斷本地條件符不符合外，還會判斷上層條件符合不符合)
-- 更嚴謹的防呆
CREATE OR REPLACE VIEW cmdev.EmpDept20View2 AS
SELECT * FROM cmdev.EmpSalaryView WHERE deptno = 20
WITH CASCADED CHECK OPTION

-- 薪水檢視表判斷條件的欄位更改，條件不符合(不允許通過)，錯誤
UPDATE EmpDept20View2
SET    salary = 1000
WHERE  empno = 7902
