/*Create a new database user with specific privileges using 
the CREATE USER and GRANT commands. Then, write a script to REVOKE certain privileges and DROP the user.*/

SELECT USER,HOST FROM MYSQL.USER;
-- creating user
CREATE USER 'syam'@'localhost' IDENTIFIED BY "syam@123";
-- granting privileges to user
GRANT select, insert, update ON wipro_training.* TO 'syam'@'localhost';
-- revoking or removing privileges from user
revoke select on wipro_training.* from 'syam'@'localhost';
-- dropping the user from user
DROP USER 'syam'@'localhost';