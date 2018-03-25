DROP TABLE IF EXISTS maps;
DROP TABLE IF EXISTS maptiles;
DROP TABLE IF EXISTS terrains;

CREATE TABLE maps (
  id INT  AUTO_INCREMENT PRIMARY KEY,
  xdim INT(4) NOT NULL,
  ydim INT(4) NOT NULL,
  name VARCHAR(30) NOT NULL,
  description VARCHAR(255) NOT NULL
);

CREATE TABLE maptiles(
  id INT AUTO_INCREMENT PRIMARY KEY,
  map_id INT NOT NULL,
  x INT(4) NOT NULL,
  y INT(4) NOT NULL,
  name VARCHAR(255) NOT NULL,
  terrain_id INT NOT NULL
);

CREATE TABLE terrains(
  id INT PRIMARY KEY,
  name VARCHAR(50),
  description VARCHAR(250)
);

INSERT INTO terrains (id, name, description) VALUES
  (1,"Plains", "Flat land, good for herding"),
  (2,"Mountains", "Rocky area, rich in minerals"),
  (3,"Forest", "Trees everywhere"),
  (4,"Desert", "Sand everywhere"),
  (5,"Grassland", "Animals love it, plants love it even more"),
  (6,"Wetlands", "random resources and wierd stuff in general"),
  (7,"Hills", "Elevated ground with some minerals");

INSERT INTO maps (xdim, ydim, name, description) VALUES
  (3,3,"Moria", "Initial 3x3 test map"),
  (3,3,"Montreal", "Second 3x3 test map");

INSERT INTO maptiles(map_id, x, y, name, terrain_id) VALUES
  (1,0,0, "Chaos mountain 1", 2),
  (1,1,0, "chaos mountain 2", 2),
  (1,2,0, "Mount Doom", 2),
  (1,0,1, "Plains 1", 1),
  (1,1,1, "chaos mountains 3", 2),
  (1,2,1, "Forest 1", 3),
  (1,0,2, "Kharakum Desert", 4),
  (1,1,2, "Plains 2", 1),
  (1,2,2, "Elvin Forest", 3);

INSERT INTO maptiles(map_id, x, y, name, terrain_id) VALUES
  (2,0,0, "Great plains", 1),
  (2,1,0, "Northern crossing", 1),
  (2,2,0, "The delta", 6),
  (2,0,1, "Western plains", 1),
  (2,1,1, "Royal mountains", 2),
  (2,2,1, "Eastern hills", 7),
  (2,0,2, "Lazarus Wetlands", 6),
  (2,1,2, "Guay ruins", 7),
  (2,2,2, "Evergrowth", 5);

