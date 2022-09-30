# ch11 example

> ch11_01
- 檢視表
    - 連結/語法 (點入等同執行語法，即時更新資料表)
    - 檢視表與原始表連動 (其一更改刪除另一都會改變)
    - EX. CREATE VIEW CountryView AS
          SELECT   Continent, Region, Code, Code2, Name
          FROM     world.country
          ORDER BY Continent, Region, Code

> ch11_02
- 檢視表 + 子查詢：
    - EX. CREATE VIEW CountryMaxGNP AS
          SELECT Name, GNP
          FROM   world.country
          WHERE  (Region, GNP) IN ( SELECT   Region, MAX(GNP)
                                    FROM     world.country
                                    GROUP BY Region )
- 覆蓋修改檢視表
    - 同名稱之檢視表，想增加欄位於同個檢視表中
    - CREATE OR REPLACE VIEW 檢視表 AS
    - ALTER VIEW 檢視表 AS
- 顯示檢視表的欄位詳細資訊：
    - DESC 檢視表名稱
- 以多表格篩選結果建立檢視表：
    - 注意欄位名稱相同時會出現錯誤，記得以別名取代欄位名稱，或先給欄位名稱
    - (X) 欄位名稱相同時會出現錯誤：
          CREATE VIEW ScaleView AS
          SELECT co.Name, ci.Name, co.Population, ci.Population 
          FROM   world.country co, world.city ci
          WHERE  co.Code = ci.CountryCode
    - (O) 以別名取代欄位名稱：
          CREATE VIEW ScaleView AS
          SELECT co.Name CountryName, ci.Name CityName, co.Population CountryPop, ci.Population CityPop
          FROM   world.country co, world.city ci
          WHERE  co.Code = ci.CountryCode
    - (O) 先給欄位名稱：
          CREATE VIEW ScaleView 
          (CountryName, CityName, CountryPop, CityPop, Scale) AS
          SELECT co.name, ci.Name, co.Population, ci.Population
          FROM   world.country co, world.city ci
          WHERE  co.Code = ci.CountryCode

> ch11_03
- 刪除檢視表
    - 檢視表存在： (若不存在會報錯)
        - DROP VIEW CountryMax
    - 檢視表不存在：
        - DROP VIEW IF EXISTS CountryMax

> ch11_04
- 更新檢視表
    - 注意，檢視表為捷徑的概念，若原始表檢視表任一方做修正，另一方也會跟著改變
    - EX. CREATE VIEW cmdev.EmpDept30View AS
          SELECT empno, ename, job, manager, hiredate, salary, comm
          FROM   cmdev.emp
          WHERE  deptno = 30
- 插入檢視表
    - EX. INSERT INTO EmpDept30View
          VALUES (9001, 'SIMON', 'SALESMAN', 7698, '2000-04-01', 1000, 250)
- 檢視表中刪除原始表才有的東西，則甚麼都沒發生
- 修改檢視表的防呆裝置：
    - WITH CHECK OPTION：
        - 若要在檢視表插入資料時，自動判斷檢視表的條件，符合條件才插入，否則錯誤 
        - 此時記得建立檢視表時，要加入條件判斷的欄位資料，插入時才不會被防呆裝置阻擋
        - EX. CREATE OR REPLACE VIEW cmdev.EmpDept30View AS
              SELECT empno, ename, job, manager, hiredate, salary, comm, deptno
              FROM   cmdev.emp
              WHERE  deptno = 30
              WITH CHECK OPTION
    - WITH LOCAL CHECK OPTION：
        - 預設同為LOCAL，只判斷本地條件符不符合 (同上)
        - 補充注意，成功更改，但不符合薪水檢視表，只有在原始表看到更改後資訊
        - 一層歸一層： (多層檢視表)
          原始+條件 --> 薪水檢視表+新條件 --> 新檢視表 
          (故更新後該筆資料消失於薪水與新簡檢視表中)
    - WITH CASCADED CHECK OPTION：
        - 判斷本地條件符不符合外，還會判斷上層條件符合不符合 (更嚴謹的防呆)
        - 只要有一層不符合，即會顯示錯誤並阻擋

> ch11_05
- 檢視表處理算法： (ALGORITHM)
    - 可取三個值 => MERGE、TEMPTABLE或UNDEFINED
    - 如果沒有ALGORITHM子句，默認算法是UNDEFINED (未定義的)，算法會影響MySQL處理檢視表的方式
      (如果不存在 ALGORITHM 子句，則默認算法由 optimizer_switch 系統變量的 derived_merge 標誌的值確定)
    - MERGE：
        - 引用檢視表和檢視表定義的語句文本被合併，以便檢視表定義的部分替換語句的相應部分
        - EX. CREATE ALGORITHM = MERGE VIEW cmdev.EmpSalaryView00 AS
              SELECT * FROM cmdev.emp WHERE salary >= 1500
    - TEMPTABLE：
        - 檢視表的結果被檢索到臨時表中，然後用於執行語句
        - 使用了臨時表，視圖是不可更新的。就是因為這個算法生成的視圖其實就是一個結果的臨時表，是無法執行update語句的
        - 最重要的是，TEMPTABLE算法會創建臨時表，這個過程是會影響效率的
        - EX. CREATE ALGORITHM = TEMPTABLE VIEW cmdev.EmpSalaryView01 AS
              SELECT * FROM cmdev.emp WHERE salary >= 1500
    - UNDEFINED：
        - MySQL 選擇使用哪種算法。如果可能，它更喜歡 MERGE 而不是 TEMPTABLE，因為 MERGE 通常更有效，並且如果使用臨時表，則檢視表無法更新

> ch11_06
- 檢查一個或多個表是否有錯誤，及檢查視圖是否存在問題
    - CHECK TABLE EmpDept20View
- 提供有關資料庫中檢視表的資訊
    - SELECT *
      FROM   information_schema.VIEWS

