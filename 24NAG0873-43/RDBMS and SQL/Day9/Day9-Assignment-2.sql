/*Assignment 2: Craft a query using an INNER JOIN to combine 'orders' and 'customers' tables for customers in a specified region,
 and a LEFT JOIN to display all customers including those without orders.*/
 
 select c.*, o.* from customers c inner join orders o on c.id=o.customer_id where c.place='new york'
 union
 select c.*, o.* from customers c left join orders o on c.id=o.customer_id;
 

 
 