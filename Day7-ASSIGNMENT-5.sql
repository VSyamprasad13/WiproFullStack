/*Assignment 5: Demonstrate the creation of an index on a table and discuss how it improves query performance.
 Use a DROP INDEX statement to remove the index and analyze the impact on query execution.*/

USE LIBRARY_SYSTEM;

-- CREATING AN INDEX ON TABLE BOOKS

CREATE INDEX INDEX_TITLE ON BOOKS(TITLE);

-- This Statement creates index as "index_title" on books table
/*When you execute a query that involves searching for a specific title in the "Books" table, 
the database engine can use the index to quickly locate the rows that match the search criteria.
Instead of scanning the entire table sequentially, which can be time-consuming, 
the database engine can use the index's ordered structure to perform a binary search,
significantly reducing the number of disk reads and improving query execution time, especially for large datasets.*/

-- Dropping an index from databse

DROP INDEX INDEX_TITLE ON BOOKS;

/* This statement removes the "idx_title" index from the "Books" table.

After removing the index, queries that involve searching for books by title may experience degraded performance, especially if the dataset is large. 
Without the index, the database engine will need to perform a full table scan to locate the relevant rows, 
which can be slower compared to using an index.

In summary, creating an index on a table can improve query performance by enabling the database engine to quickly locate the desired rows. 
However, indexes come with overhead in terms of storage and maintenance. 
Dropping an index may result in slower query performance for queries that rely on the indexed column.
It's essential to consider the trade-offs and carefully evaluate the impact on query execution when creating or removing indexes.*/