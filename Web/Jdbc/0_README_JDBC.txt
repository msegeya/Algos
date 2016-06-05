- What is JDBC?
	Full form: Java DataBase Connection.

- How do we make a JDBC connection?

	import java.sql.*;

	Connecton conn = null;
	PreparedStatement stmt = null;
	ResultSet result = null;
	try {
		// Step 1 - Locad the connection driver
		Class.forName(com.mysql.jdbc.driver);

		// Step 2 - Open the connection
		conn = DriverManager.getConnection("jdbc:mysql://localhost/EMP", "<USERNAME>", "<PASSWORD>");
		
		// Step 3 - Prepare Statement.
		stmt = conn.prepareStatement("<Add_Some_SQL_Query_Here>");
		// stmt.setInt(1, <your_int_value_goes_here>);     ---> If your query needs to add some parameters then we do this.
		// stmt.setString(2, "<your_string_value_goes_here>");

		result = stmt.executeQuery();

		while(result.next()) {
			syso(result.getString("<Column_Name>" + " " + result.getInt("<cColumn_Name>")));
		}
		result.close();
	} catch(SQLException sqle) {
		// do soemthing
	} catch(Exception e) {
		// do something
	} finally {
		try {
			if(null != result) result.close();
			if(null != stmt) stmt.close();
			if(null != conn) conn.close();
		} catch(Exception ex) {
			// do something.
		} 
	}

- What are the steps for JDBC connectivity?
	*) Load Driver
	*) Make Connection
	*) Get Statement Object
	*) Execute the Query
	*) Close the connection

- What is dirty read?
	A transaction reads the data that has not yer been commited.

- What are different types of Statements?
	Statement, Prepared Statement, Callable Statement.

	Statement: It won't accept parameter at runtime.
		Statement stmt = conn.createStatement();
		ResultSet set = stmt.executeQuery();

	Prepared Statement: It accepts parameter.
		String SQL = "Select * From Employee";
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		ResultSet set = pstmt.executeQeury();
		
	Callable Statement: To access stored procedure we use Callable statement. It also accepts runtime parameter.
		CallableStatement cs = conn.prepareCall("{call SHOW_SUPPLIERS_PROCEDURE}");
		ResultSet set = cs.executeQuery();

- What is connection pooling?
	Connection pooling is the mechanism by which we reuse the recourse like connection objects  which are  needed to make connection with database.

- RowSet Vs ResultSet
	A ResultSet maintains a connection to a database and because of that it can’t be serialized.
	RowSet is a disconnected, serializable version of a JDBC ResultSet and also the RowSet extends the ResultSet interface so it has all the methods of ResultSet.	