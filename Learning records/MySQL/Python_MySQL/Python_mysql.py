# -*- coding: utf-8 -*-
"""
Created on Mon Dec 20 13:20:04 2021

@author: USER
"""

#!/usr/bin/python3
#coding=utf-8
#%%
import pymysql

# Open database connection
db = pymysql.connect(host='localhost', port=3306, user='root', passwd='a0952122496', db='cmdev', charset='utf8' )

cursor = db.cursor()

cursor.execute("SELECT VERSION()")

data = cursor.fetchone()

print ("Database version : %s " % data)

db.close()

#%%
import pymysql

# Open database connection
db = pymysql.connect(host='localhost', port=3306, user='root', passwd='a0952122496', db='cmdev', charset='utf8' )

cursor = db.cursor()

# cursor.execute("SELECT * from louis")

# data = cursor.fetchone()

# print (data)

# dataall = cursor.fetchall()

# print(dataall)


# 插入資料語法
cursor.execute("INSERT INTO louis (NAME,Tel) VALUES ('Paul', 'California')")

db.commit()
print ("資料插入成功")


# 查詢資料
cursor.execute("SELECT * from louis")
print(cursor)

for row in cursor:
    print("ID = ", row[0])
    print("NAME = ", row[1])
    print("ADDRESS = ", row[2])

db.close()

'''
CREATE TABLE `louis` (
  `id` int(15) NOT NULL auto_increment primary key,
  `name` varchar(20) NOT NULL,
  `address` int(8) NOT NULL,
  `Tel` varchar(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
'''



