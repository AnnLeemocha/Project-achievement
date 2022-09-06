# -*- coding: utf-8 -*-
"""
Created on Wed Feb 19 21:19:04 2020

@author: user
"""

import pandas as pd
from sqlalchemy import create_engine
# 建立引擎 (繞道 連線到 mysql 使用 pymysql 套件)
# https://docs.sqlalchemy.org/en/14/core/engines.html
# 雲端：postgresql
# SQLite
engine = create_engine("mysql+pymysql://root:a0952122496@localhost:3306/cmdev")
# SQL 語法
sql = "select * from travel";
# 輸入 pandas
df = pd.read_sql_query(sql, engine)
# 輸出 employee 表的查詢結果
print(df)

# engine = create_engine("mysql+pymysql://root:a0952122496@localhost:3306/louispython")
# sql = "select * from students";
# df = pd.read_sql_query(sql, engine)
# print(df)