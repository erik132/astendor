DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS user_roles;

CREATE TABLE users(
  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  active int NOT NULL ,
  email VARCHAR(255) NOT NULL ,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);


CREATE TABLE roles(
  id INT NOT NULL PRIMARY KEY ,
  role VARCHAR(255) NOT NULL
);


CREATE TABLE user_roles(
  user_id INT NOT NULL ,
  role_id INT NOT NULL,
  PRIMARY KEY (user_id, role_id)
);

INSERT INTO roles (id, role) VALUES
  (1,"ADMIN");

INSERT INTO users (active, email, username, password) VALUES
  (1,"erik@erik.com", "sabre", "pliiats");

INSERT INTO user_roles (user_id, role_id) VALUES
  (1,1);