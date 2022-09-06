# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""
#pip install pymysql or conda install pymysql


'''
2、建立mysql資料庫，建立students表

create table students(
id int auto_increment primary key,
stuname varchar(10) not null
);

        

        


'''
'''
3、資料操作，新增score欄位，插入一列資訊
alter table students add score int;
insert into students(sname,score) values("apple","500");
'''




'''
4.插入資料
import pymysql

conn = pymysql.connect(host='localhost',port=3306,db='louispython',user='root',passwd='s123456S',charset='utf8')
cur = conn.cursor()
sql =["insert into students(id,stuname,stuscore) values('0','Apple','95')","insert into students(id,stuname,stuscore) values('0','Lg','80')","insert into students(id,stuname,stuscore) values('0','Samsung','85')","insert into students(id,stuname,stuscore) values('0','Sony','90')"]
#sql = "insert into students(id,stuname,stuscore) values('Lg','80')"
#sql = "insert into students(id,stuname,stuscore) values('Samsung','85')"
#sql = "insert into students(id,stuname,stuscore) values('Sony','90')"
#type(sql)
#print(sql)
for i in range(4):
    print(i)
    x=sql[i]
    print(x)
    cur.execute(x)
    conn.commit()
cur.close()
conn.close()
'''

'''
#5.查詢資料程式碼：
import pymysql

conn = pymysql.connect(host='localhost',port=3306,db='louispython',user='root',passwd='s123456S',charset='utf8')
cur = conn.cursor()
sql = "select stuname,stuscore from students"
cur.execute(sql)
# result = cur.fetchone()
result = cur.fetchall()
for data in result:
    print(data)
cur.close()
conn.close()
'''


#!/usr/bin/python
# -*- coding: utf-8 -*-

# 引入 MySQLdb 模組，提供連接 MySQL 的功能
import MySQLdb

# 連接 MySQL 資料庫
db = MySQLdb.connect(host="localhost",
    user="root", passwd="a0952122496", db="louispython")
cursor = db.cursor()

# 執行 MySQL 查詢指令
cursor.execute("SELECT * FROM students")

# 取回所有查詢結果
results = cursor.fetchall()

# 輸出結果
for record in results:
  col1 = record[0]
  col2 = record[1]
  print ("%s, %s" % (col1, col2))

# 關閉連線
db.close()