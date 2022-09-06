# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""
import pymysql # pip install pymysql
'''
# 建立資料苦與資料表
CREATE DATABASE louispython
CREATE TABLE `students` (
  `id` int(15) NOT NULL auto_increment primary key,
  `stuname` varchar(20) NOT NULL,
  `stuscore` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
'''
# 連線
# port --> show GLOBAL VARIABLES LIKE 'port'
# MySQL 設定檔 ---> my.ini (C:\AppServ\MySQL\my.ini 更改port)
conn = pymysql.connect(host='localhost',port=3306,db='louispython',user='root',passwd='a0952122496',charset='utf8')
# 游標
cur = conn.cursor()
sql =["insert into students(id,stuname,stuscore) values('0','Apple','95')",
      "insert into students(id,stuname,stuscore) values('0','Lg','80')",
      "insert into students(id,stuname,stuscore) values('0','Samsung','85')",
      "insert into students(id,stuname,stuscore) values('0','Sony','90')"]
#sql = "insert into students(stuname,stuscore) values('Lg','80')"
#sql = "insert into students(stuname,stuscore) values('Samsung','85')"
#sql = "insert into students(stuname,stuscore) values('Sony','90')"
#sql = "insert into students(id,stuname,stuscore) values('Lg','80')"
#sql = "insert into students(id,stuname,stuscore) values('Samsung','85')"
#sql = "insert into students(id,stuname,stuscore) values('Sony','90')"
#type(sql)
#print(sql)
# 刪除後 primary key 重新排序 - 1
# cur.execute("DELETE FROM students")
# cur.execute("ALTER TABLE students auto_increment = 1")
# 刪除後 primary key 重新排序 - 2
cur.execute("TRUNCATE TABLE students")
for i in range(4):
    print(i)
    x=sql[i]
    print(x)
    cur.execute(x) # 游標指向SQL語法 (暫存SQL語法)
    # conn.commit()  # 執行 (寫在迴圈中會降低速度，可寫在迴圈外)
conn.commit()
cur.close()
conn.close()