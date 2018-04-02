DROP TABLE IF EXISTS warlords;

CREATE TABLE warlords(
  id INT AUTO_INCREMENT PRIMARY KEY,
  world_id INT NOT NULL,
  user_id INT NOT NULL,
  x INT NOT NULL,
  y INT NOT NULL
);

CREATE TABLE orders(
  id INT AUTO_INCREMENT PRIMARY KEY,
  warlord_id INT NOT NULL,
  order_type INT NOT NULL
);

INSERT INTO warlords (world_id, user_id, x, y) VALUES
  (1,1,0,0);