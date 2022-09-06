# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""
# Connect MySQL
import mysql.connector

maxdb = mysql.connector.connect(
  host = "localhost",
  user = "root",
  password = "a0952122496",
  database = "cmdev",
  auth_plugin='mysql_native_password'
  )
cursor=maxdb.cursor()


# # Create db
# cursor.execute("CREATE DATABASE maxdb")

# # Create table
# cursor.execute("CREATE TABLE users (name VARCHAR(255), age INTEGER(99), user_id INTEGER AUTO_INCREMENT PRIMARY Key)")

# # Insert Multiple Records
# sqlStuff = "INSERT INTO users (name, age) VALUES (%s,%s)"
# records = [("Steve", 24),
#            ("Max", 25),
#            ("Chang" ,26),]
# cursor.executemany(sqlStuff, records)
# maxdb.commit()


# Read
# cursor.execute("SELECT * FROM users Where name Like 'M%'")
cursor.execute("SELECT * FROM users ")
result = cursor.fetchall()
for row in result:
    print(row)
    
# Update
update_users = "UPDATE users SET age = 23 WHERE user_id = 3"
cursor.execute(update_users)
maxdb.commit()



# Delete
delete_users = "DELETE FROM users WHERE user_id = 4"
cursor.execute(delete_users)
maxdb.commit()


# Delete Drpo Table
delete_table = "DROP TABLE IF EXISTS users"
cursor.execute(delete_table)