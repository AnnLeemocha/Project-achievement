# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""
import mysql.connector as sql

# 若有更改 port 記得加
conn=sql.connect(host='localhost', user='root', passwd='a0952122496')
# 解密方式，可能有權限問題
# https://stackoverflow.com/questions/50557234/authentication-plugin-caching-sha2-password-is-not-supported
# conn=sql.connect(host='localhost', user='root', passwd='a0952122496', auth_plugin='mysql_native_password')
c = conn.cursor()
a = c.execute("SHOW DATABASES")
for row in c.fetchall():
    print(row)
