-- 移除索引
ALTER TABLE addressbook11
DROP PRIMARY KEY,
DROP INDEX email,
DROP INDEX name,
DROP INDEX address

-- XX 無法操作，錯誤
DROP INDEX 'PRIMARY' ON addressbook12
-- XX 無法操作，錯誤
DROP INDEX 'UNIQUE' ON addressbook12


DROP INDEX email ON addressbook12

-- 索引名稱
DROP INDEX email_index ON addressbook12


DROP INDEX name ON addressbook12


DROP INDEX address ON addressbook12
