CREATE TABLE positions (ID INT AUTO_INCREMENT,
 Name VARCHAR(255) NOT NULL,
 Salary INT,
 PRIMARY KEY(ID));

CREATE TABLE employees (Age VARCHAR(100), Fname VARCHAR(100),ID INT AUTO_INCREMENT,Lname VARCHAR(100), Position_id INT ,
                        PRIMARY KEY(ID),
                        CONSTRAINT a1 FOREIGN KEY (Position_id)
                        REFERENCES positions(ID));