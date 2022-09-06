SELECT empno, ename, deptno
FROM   cmdev.emp


SELECT empno, ename, e.deptno, d.dname
FROM   cmdev.emp e, cmdev.dept d
WHERE  e.deptno = d.deptno

-- 表格A LEFT/RIGHT OUTER JOIN (外結合) 表格B ON 條件
-- 以哪個資料表為主(LEFT/RIGHT)，不管有無配對成功(NULL)，都要顯示
SELECT empno, ename, e.deptno, d.dname
FROM   cmdev.emp e LEFT OUTER JOIN cmdev.dept d
       ON e.deptno = d.deptno


SELECT empno, ename, e.deptno, d.dname
FROM   cmdev.dept d RIGHT OUTER JOIN cmdev.emp e
       ON e.deptno = d.deptno


SELECT empno, ename, e.deptno, d.dname
FROM   cmdev.emp e LEFT OUTER JOIN cmdev.dept d
       ON e.deptno = d.deptno


SELECT empno, ename, e.deptno, d.dname
FROM   cmdev.emp e RIGHT OUTER JOIN cmdev.dept d
       ON e.deptno = d.deptno
