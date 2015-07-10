package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
	
	public void conectar( ) throws ClassNotFoundException, SQLException {
	    Class.forName("org.h2.Driver");
	    Connection conn = DriverManager.getConnection("jdbc:h2:~/restaurante", "admin", "admin");
	    // add application code here
	    System.out.println("Conectou! :) ");
	    conn.close();
	}

}
