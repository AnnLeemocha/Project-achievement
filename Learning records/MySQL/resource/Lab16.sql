CREATE TABLE petlog (
  logno SERIAL,
  logdt timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  message varchar(64)
);