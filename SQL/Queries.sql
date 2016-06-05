-- Note: Queries are run on Oracle DB

-- Find second highest salary of an employee
SELECT MAX(SALARY) FROM EMPLOYEE 
	WHERE SALARY NOT IN (SELECT MAX(SALARY) FROM EMPLOYEE);
--------------------------------------------------------------------------------------------
-- Find max salary of each department.
SELECT DEPT_ID, MAX(SALARY) FROM EMPLOYEE GROUP BY DEPT_ID;
--------------------------------------------------------------------------------------------
-- If we need dept name and not dept ID in the above query then
SELECT DEPT_NAME, MAX(SALARY) FROM EMPLOYEE 
	RIGHT JOIN DEPARTMENT ON EMPLOYEE.DEPT_ID == DEPARTMENT.DEPT_ID 
	GROUP BY DEPT_NAME;
--------------------------------------------------------------------------------------------
-- Print date
SELECT GETDATE();
--------------------------------------------------------------------------------------------
-- Get all the students whose DOB is between two given dates
SELECT NAME FROM STUDENT WHERE DOB BETWEEN 'DD/MM/YYYY' AND 'DD/MM/YYYY';
--------------------------------------------------------------------------------------------
-- Count all the employees by gender whose DOB is between given dates.
SELECT COUNT(*), GENDER FROM EMPLOYEE 
	WHERE DOB BETWEEN 'DD/MM/YYYY' AND 'DD/MM/YYYY' 
	GROUP BY GENDER;
--------------------------------------------------------------------------------------------
-- Get all Names of Employees whose salary is >= 100
SELECT NAMES FROM EMPLOYEE WHERE SALARY >= 100;	
--------------------------------------------------------------------------------------------
-- Find Employee whose name start with 'M'
SELECT NAMES FROM EMPLOYEE WHERE NAME LIKE 'M%';
--------------------------------------------------------------------------------------------
-- Find all employees whose name has 'joe'
SELECT NAMES FROM EMPLOYEE WHERE UPPER(NAME) LIKE '%JOE%';
--------------------------------------------------------------------------------------------
-- Get year from given date
SELECT YEAR(GETDATE()) AS "Year";
--------------------------------------------------------------------------------------------
-- Delete all duplicate rows.
-- We will do this in two steps.
-- 1) We will get all the duplicate rows
-- 2) Then we will delete them.
-- Get all the duplicates
SELECT * FROM EMPLOYEE E1 WHERE rowid = (SELECT rowid FROM EMPLOYEE E2 WHERE E1.EMP_NO = E2.EMP_NO);
-- Delete all the duplicates.
DELETE FROM EMPLOYEE E1 WHERE rowid != (SELECT rowid FROM EMPLOYEE E2 WHERE E1.EMP_NO = E2.EMP_NO);

-- OR 

-- Create a new table and add all the distinct rows into this new table.
-- Drop the original table
-- Rename the temp table to original table
CREATE TABLE TEMP_TABLE AS SELECT DISTINCT * FROM ORIGINAL_TABLE;
DROP ORIGINAL_TABLE;
RENAME TEMP_TABLE TO ORIGINAL_TABLE;

-- OR

-- If the duplicates are very few when compared to all rows then this is the best method.
-- Delete all the rows except the min_row having same exployee_id.
DELETE FROM EMPLOYEE A WHERE A.ROW_ID > (SELECT MIN(B.ROW_ID) FROM EMPLOYEE B WHERE A.EMP_ID = B.EMP_ID);
--------------------------------------------------------------------------------------------
-- Get all the students whose marks are greater than the class average marks.
SELECT NAME, MARKS FROM STUDENTS WHERE MARKS > (SELECT AVG(MARKS) FROM STUDENTS);
--------------------------------------------------------------------------------------------
-- Get all employees where employee is also a manager.
SELECT E1.NAME, E2.NAME FROM EMPLOYEE E1, EMPLOYEE E2 WHERE E1.MANAGER_ID = E2.EMP_ID;
--------------------------------------------------------------------------------------------