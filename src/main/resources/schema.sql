CREATE TABLE purchase (
  id INTEGER NOT NULL AUTO_INCREMENT,
  customerid INTEGER NOT NULL,
  yearmonth INTEGER NOT NULL,
  amount INTEGER NOT NULL,
  PRIMARY KEY (id)
);