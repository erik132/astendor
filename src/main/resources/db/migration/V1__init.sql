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
  terrain_id INT NOT NULL,
  race_id INT NOT NULL
);

CREATE TABLE terrains(
  id INT PRIMARY KEY,
  name VARCHAR(50),
  description VARCHAR(250)
);

CREATE TABLE races(
  id INT PRIMARY KEY,
  name VARCHAR(50),
  description VARCHAR(250)
);

INSERT INTO races (id, name, description) VALUES
  (1, "Orcs", "A warrior race usually living on tough environments like mountains, hills or swamps"),
  (2, "Dwarves", "Short and strong miners usually prefering mountains"),
  (3, "High elves", "Magical beings that usually live in forests or grasslands"),
  (4, "Halflings", "Little peaceful creatures who prefer plains. They make good farmers"),
  (5, "Nomads", "Demon like race, who prefers deserts and plains. Excellent herd keepers");

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

INSERT INTO maptiles(map_id, x, y, name, terrain_id, race_id) VALUES
  (1,0,0, "Chaos mountain 1", 2,1),
  (1,1,0, "chaos mountain 2", 2,2),
  (1,2,0, "Mount Doom", 2, 1),
  (1,0,1, "Plains 1", 1, 4),
  (1,1,1, "chaos mountains 3", 2, 2),
  (1,2,1, "Forest 1", 3, 3),
  (1,0,2, "Kharakum Desert", 4, 5),
  (1,1,2, "Plains 2", 1, 4),
  (1,2,2, "Elvin Forest", 3, 3);

INSERT INTO maptiles(map_id, x, y, name, terrain_id, race_id) VALUES
  (2,0,0, "Great plains", 1, 5),
  (2,1,0, "Northern crossing", 1, 4),
  (2,2,0, "The delta", 6, 1),
  (2,0,1, "Western plains", 1, 5),
  (2,1,1, "Royal mountains", 2, 2),
  (2,2,1, "Eastern hills", 7, 2),
  (2,0,2, "Lazarus Wetlands", 6, 1),
  (2,1,2, "Guay ruins", 7, 3),
  (2,2,2, "Evergrowth", 5, 3);

