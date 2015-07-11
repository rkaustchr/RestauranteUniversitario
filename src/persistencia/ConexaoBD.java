package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

	/**
	 * == MANUAL H2 SQL ==
	 * Fonte: https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html
	 * 
	 * To execute a query, call an execute method from Statement 
	 * such as the following:
	 *   	execute: Returns true if the first object that the query 
	 *   				returns is a ResultSet object. Use this method if the query could return one or more ResultSet objects. Retrieve the ResultSet objects returned from the query by repeatedly calling Statement.getResultSet.
	 *   	executeQuery: Returns one ResultSet object.
	 *   	executeUpdate: Returns an integer representing the number 
	 *   				of rows affected by the SQL statement. 
	 *   				Use this method if you are using INSERT, DELETE, or 
	 *   				UPDATE SQL statements.
	 * 
	 * 
	 * 	>> Exemplo de Uso ResultSet:
	 * 		String query = "select COF_NAME, SUP_ID, PRICE, " +
     *              "SALES, TOTAL " + "from " + dbName + ".COFFEES";
	 * 		Statement stmt = con.createStatement();
	 *	    ResultSet rs = stmt.executeQuery(query);
	 *	    while (rs.next()) {
	 *	    	String coffeeName = rs.getString("COF_NAME");
	 *	        int supplierID = rs.getInt("SUP_ID");
	 *	        float price = rs.getFloat("PRICE");
	 *	        int sales = rs.getInt("SALES");
	 *	        int total = rs.getInt("TOTAL");
	 *	        System.out.println(coffeeName + "\t" + supplierID +
	 *	                           "\t" + price + "\t" + sales +
	 *	                           "\t" + total);
	 *		}
	 *		if (stmt != null) { stmt.close(); }
	 *
	 */
	
	
	
	public void conectar( ) throws ClassNotFoundException, SQLException {
	    Class.forName("org.h2.Driver");
	    Connection conn = DriverManager.getConnection("jdbc:h2:~/restaurante", "admin", "admin");
	    // add application code here
	    System.out.println("Conectou! :) ");
	    conn.close();
	}

}
