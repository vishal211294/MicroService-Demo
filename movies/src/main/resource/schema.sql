DROP TABLE IF EXISTS MOVIES;

CREATE TABLE MOVIES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  genre VARCHAR(250) NOT NULL,
);