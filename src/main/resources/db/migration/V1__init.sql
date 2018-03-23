DROP TABLE IF EXISTS maps;
DROP TABLE IF EXISTS maptiles;

CREATE TABLE maps (
  id INT(6)  AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30) NOT NULL,
  description VARCHAR(255) NOT NULL
);

CREATE TABLE maptiles(
  id INT AUTO_INCREMENT PRIMARY KEY,
  map_id INT(6) NOT NULL,
  x INT(4) NOT NULL,
  y INT(4) NOT NULL,
  name VARCHAR(255) NOT NULL
);

INSERT INTO maps (name, description) VALUES
  ("Moria", "Initial 3x3 test map");

INSERT INTO maptiles(map_id, x, y, name) VALUES
  (1,0,0, "Chaos mountain 1"),
  (1,1,0, "chaos mountain 2"),
  (1,2,0, "Mount Doom"),
  (1,0,1, "Plains 1"),
  (1,1,1, "chaos mountains 3"),
  (1,2,1, "Forest 1"),
  (1,0,2, "Kharakum Desert"),
  (1,1,2, "Plains 2"),
  (1,2,2, "Elvin Forest");