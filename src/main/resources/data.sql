/*-------------------------------------------------------------------------------------------*/
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS client;

/*-------------------------------------------------------------------------------------------*/
CREATE TABLE client (
  clientid INT NOT NULL,
  datatime DATE NOT NULL,
  direction VARCHAR(45) NOT NULL,
  PRIMARY KEY (clientid));
/*-------------------------------------------------------------------------------------------*/
CREATE TABLE product (
  idIncrement INT NOT NULL AUTO_INCREMENT,
  id INT NOT NULL,
  clientidPK INT NOT NULL,
  quantity INT NOT NULL,
  cost INT NOT NULL,
  PRIMARY KEY (idIncrement));

ALTER TABLE product 
ADD CONSTRAINT clientidPK
  FOREIGN KEY (clientidPK)
  REFERENCES client (clientid);
/*-------------------------------------------------------------------------------------------*/