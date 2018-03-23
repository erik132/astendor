DROP TABLE IF EXISTS maps;

CREATE TABLE maps (
  id INT(6)  AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  description VARCHAR(255) NOT NULL
);

INSERT INTO maps (name, description) VALUES
  ("Moria", "Initial 3x3 test map");