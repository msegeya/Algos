Joins:
1) INNER Join - Returns all rows when there is at least one match in BOTH tables
2) Left Outer Join - Return all rows from the left table, and the matched rows from the right table
3) Right Outer Join - Return all rows from the right table, and the matched rows from the left table
4) Full Outer Join - Return all rows when there is a match in ONE of the tables

Refer - Inner_Join.gif, Left_Outer_Join.gif, Right_Outer_Join.gif, Full_Outer_Join.gif

- INNER Join
	SELECT column_name(s)
		FROM table1
		JOIN table2
		ON table1.column_name=table2.column_name;

- Left Outer Join
	SELECT column_name(s)
		FROM table1
		LEFT OUTER JOIN table2
		ON table1.column_name=table2.column_name;

- Right Outer Join
	SELECT column_name(s)
		FROM table1
		RIGHT OUTER JOIN table2
		ON table1.column_name=table2.column_name;

- Full Outer Join
	SELECT column_name(s)
		FROM table1
		FULL OUTER JOIN table2
		ON table1.column_name=table2.column_name;