DROP TABLE IF EXISTS warlords;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS order_types;

CREATE TABLE warlords(
  id INT AUTO_INCREMENT PRIMARY KEY,
  world_id INT NOT NULL,
  user_id INT NOT NULL,
  race_id INT NOT NULL,
  x INT NOT NULL,
  y INT NOT NULL
);

CREATE TABLE orders(
  id INT AUTO_INCREMENT PRIMARY KEY,
  warlord_id INT NOT NULL,
  order_type INT NOT NULL,
  order_params VARCHAR(250) NOT NULL
);

CREATE TABLE order_types(
  id INT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  order_bean VARCHAR(250) NOT NULL
);

INSERT INTO warlords (world_id, user_id, race_id, x, y) VALUES
  (1,1,2,0,0);

INSERT INTO order_types (id, name, order_bean) VALUES
  (1,"Movement","movementOrder");

INSERT INTO orders (warlord_id, order_type, order_params) VALUES
  (1,1,"north"),
  (1,1,"east");