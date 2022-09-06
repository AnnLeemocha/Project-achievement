SELECT Name, Continent, Population
FROM   country
WHERE  Continent='Europe' AND Population<10000

-- 測試數值可容納範圍
-- 資料型態 -- 整數 (bigint -2^63~2^63-1)   (int -2^31~2^31-1)
SELECT Population * 10000000000, Population * 100000000000
FROM   world.country
WHERE  Code='USA'

-- 資料型態 -- 小數 (小數點30位)
SELECT 0.098765432109876543210987654321 / 2

-- 判斷式 (T:1, F:0)
SELECT 0.1 + 0.1 = 0.2, 0.1E0 + 0.1E0 = 0.2E0

-- 0.3000000004 != 0.3E0 (盡量不要用浮點數相等)
SELECT 0.1 + 0.2 = 0.3, 0.1E0 + 0.2E0 = 0.3E0

-- 字串(放數值)+數值 --> 可進行運算
SELECT 1+'2', '1'+2, '1E+2'+'2E-2'

-- 字串(放非數值)+數值 --> 不可進行運算 (忽略字串)
SELECT 1+'A', 'B'+2


SELECT 'Hello!' || 'MySQL!'


SET sql_mode = 'PIPES_AS_CONCAT'

-- 合併字串 (搭配使用)
SET sql_mode = 'PIPES_AS_CONCAT';
SELECT 'Hello!' || 'MySQL!'

-- 都不成立(不可執行) NULL
SELECT NULL = NULL, NULL < NULL, NULL != NULL, NULL + 3

-- 都成立() T F T
SELECT NULL IS NULL, NULL IS NOT NULL, NULL <=> NULL
