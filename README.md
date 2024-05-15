
[4:29 PM] Maria (Unverified)
CREATE TABLE employees

( emp_id int ,

  emp_name varchar(50) ,

address varchar(50) , 

  dept_id int,

  dept_name  varchar(50),

   salary int

);
 
insert into employees values(101,'Maria','NY',1,'Fashion',1000000);

insert into employees values(102,'Jeni','SF',2,'Finance',50000000);

insert into employees values(103,'Guru','NY',2,'Finance',6780000);

insert into employees values(104,'Swathi','NY',3,'HR',5600000);

insert into employees values(105,'Pooja','SF',3,'HR',3450000);

insert into employees values(106,'Rahul','SF',3,'HR',7860000);

insert into employees values(107,'Mani','SF',3,'HR',7860000);

insert into employees values(108,'Ram','SF',1,'Fashion',7860000);

insert into employees values(109,'Teddy','SF',1,'Fashion',777000);
 
 
select * from employees;

-- ---------------
 
-- rank() -- Here we are partioning the tablee by dept_id, here we have 3 dept, different partition will have different ranking

SELECT  * 

, rank() OVER (PARTITION BY dept_id ORDER BY salary DESC) AS 'Rank'

, dense_rank() OVER (PARTITION BY dept_id ORDER BY salary DESC) AS 'Dense_rank'

, row_number() OVER (PARTITION BY dept_id ORDER BY salary DESC) AS 'Row_number'

FROM employees;
 
 
select * 

-- , lead(emp_id) over (PARTITION BY dept_id ORDER BY salary DESC) AS 'Lead'

, lag (emp_id) over (PARTITION BY dept_id ORDER BY salary DESC) AS 'Lag'

from employees;
 
 
select * 

, first_value(salary) over (PARTITION BY dept_id  ORDER BY salary DESC) AS 'first_value'

, last_value (salary) over (PARTITION BY dept_id  ORDER BY salary DESC) AS 'last_value'

from employees 

[4:30 PM] Maria (Unverified)


Assignment 4: Compose SQL statements to BEGIN a transaction, INSERT a new record into the 'orders' table, COMMIT the transaction, then UPDATE the 'products' table, and ROLLBACK the transaction.
 
Assignment 5: Begin a transaction, perform a series of INSERTs into 'orders', setting a SAVEPOINT after each, rollback to the second SAVEPOINT, and COMMIT the overall transaction.
 
Assignment 6: Draft a brief report on the use of transaction logs for data recovery and create a hypothetical scenario where a transaction log is instrumental in data recovery after an unexpected shutdown.

[4:30 PM] Maria (Unverified)
Assignment 6: Create a new database user with specific privileges using the CREATE USER and GRANT commands. Then, write a script to REVOKE certain privileges and DROP the user.
