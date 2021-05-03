CREATE TABLE positions (ID INT AUTO_INCREMENT,
 Name VARCHAR(255) NOT NULL,
 Salary INT,
 PRIMARY KEY(ID));

CREATE TABLE employees (Age VARCHAR(100), Fname VARCHAR(100),ID INT AUTO_INCREMENT,Lname VARCHAR(100), Position_id INT ,
                        PRIMARY KEY(ID),
                        CONSTRAINT a1 FOREIGN KEY (Position_id)
                        REFERENCES positions(ID));

INSERT INTO `positions`(`Name`, `Salary`) VALUES ('Position1',1000)

INSERT INTO `employees`(`Age`, `Fname`, `Lname`, `Position_id`) VALUES ('30','Ivan','Ivanov',1)

SELECT * FROM employees AS e, positions AS p WHERE e.Position_id = p.id AND p.Salary > 1500