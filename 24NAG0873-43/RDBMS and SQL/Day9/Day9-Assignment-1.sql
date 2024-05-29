
/*Assignment 1: Write a SELECT query to retrieve all columns from a 'customers' table, 
and modify it to return only the customer name and email address for customers in a specific city.*/

select * from customers; -- to retrieve all columns
select name,email from customers where place="new york"; -- customer name and email for a specific city