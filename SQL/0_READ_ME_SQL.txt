Keys:
	Unique Key: Ensures that each row for a column must have a unique value
	Primary Key: A primary key is a special relational database table column (or combination of columns) designated to uniquely identify all table records.
	Foreign Key: Ensure the referential integrity of the data in one table to match values in another table
	Composite Key: A composite key, in the context of relational databases, is a combination of two or more columns in a table that can be used to uniquely identify each row in the table.

- What is the difference between Primary Key and Unique key?
	PK:	Can be only one PK per table.
	UK: Can be more than one UK per table.

	PK: Cannot have null
	UK: Can have null. 

Triggers: Triggers are stored programs, which are automatically executed or fired when some events occur.

Indexes: Indexes are special lookup tables that the database search engine can use to speed up data retrieval. 

ACID Properties: 
	A - Atomicity (Either all or nothing.)
	C - Consistency (A transaction should be in a valid state. That is it should not show different values for different users.)
	I - Isolation (Transaction must be isolated from other transactions.)
	D - Durability (Commited data should be persistent.)

Cursors: A curosr could be referred to in a program to fetch and process the rows returned by the SQL statement, one at a time. 
		 A cursor is a pointer to this context area. A curosr holds the rows returned by the SQL statement.

		Two types of Curosors,
			1) Implicit Cursor - DB creates the cursors automatically when a SQL statement is executed. If there is an explicit cursor then DB won't create a implicit cursor. Programmers don't have control over implicit cursors.
			2) Explicit Cursor - Explicit cursors are programmer defined cursors for gaining more control over the context area.