/*Assignment 7: Prepare a series of SQL statements to INSERT new records into the library tables,
UPDATE existing records with new information, and DELETE records based on specific criteria. 
Include BULK INSERT operations to load data from an external source."*/

USE LIBRARY_SYSTEM;

-- Inserting into the tables

INSERT INTO BOOKS VALUES('98765432356','HARRY POTTER AND BLOOD PRINCE','JK ROWLING','SCHOLOSTIC',2003,10);
INSERT INTO BOOKS VALUES('98765432335','HARRY POTTER AND DEATHLY HALLOWS','JK ROWLING','SCHOLOSTIC',2004,13);

SELECT * FROM BOOKS;

INSERT INTO MEMBERS VALUES('GH5775','JOHN DOE','123 MAIN STREET, BANGALORE','JOHN.DOE@GMAIL.COM',9876544564);

-- UPDATING RECORDS

UPDATE BOOKS
SET QUANTITY=15 WHERE QUANTITY=10;
SELECT * FROM BOOKS;

-- DELETING RECORDS
DELETE FROM BOOKS
WHERE QUANTITY=15;
SELECT * FROM BOOKS;

-- BULK DATA IS ADDED INTO THE EMPLOYEE TABLE
SELECT * FROM EMPLOYEE;