-- 排序 ORDER BY 欄位名 升序(ASC)/降序(DESC) [不寫預設為升序]
SELECT   CountryCode, Name
FROM     city
ORDER BY CountryCode ASC


SELECT   CountryCode, Name
FROM     city
ORDER BY CountryCode


SELECT   CountryCode, Name
FROM     city
ORDER BY CountryCode DESC


SELECT   CountryCode, Name
FROM     city
ORDER BY CountryCode

-- 先用 CountryCode 排序，再用 Name 排序 (都升序)
SELECT   CountryCode, Name
FROM     city
ORDER BY CountryCode, Name

-- CountryCode, Name 用不同排序方式
SELECT   CountryCode, Name
FROM     city
ORDER BY CountryCode DESC, Name ASC


SELECT   ename, salary * 12 AS AnnualSalary
FROM     cmdev.emp
ORDER BY salary * 12


SELECT   ename, salary * 12 AS AnnualSalary
FROM     cmdev.emp
ORDER BY AnnualSalary

-- 排序第 2 個欄位
SELECT   ename, salary * 12 AS AnnualSalary
FROM     cmdev.emp
ORDER BY 2

-- 只要 city 有的都可做排序
SELECT   CountryCode, Name
FROM     city
ORDER BY Population
