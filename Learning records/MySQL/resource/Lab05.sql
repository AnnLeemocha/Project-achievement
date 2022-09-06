USE cmdev;

DROP TABLE IF EXISTS myemp;

CREATE TABLE myemp (
  id INT NOT NULL,
  firstname VARCHAR(25) NOT NULL,
  lastname VARCHAR(25) NOT NULL,
  salary INT,
  birthdate DATE,
  PRIMARY KEY (id)
);