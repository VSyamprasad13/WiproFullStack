/*
Assignment 3: Utilize a subquery to find customers who have placed orders above the average order value, 
and write a UNION query to combine two SELECT statements with the same number of columns.*/


select customer_id from orders 
where order_value > (select avg(order_value) from orders)
union
select id from customers;