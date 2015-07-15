package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBD {

	/**
	 * == MANUAL H2 SQL ==
	 * Fonte: https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html
	 * 
	 * To execute a query, call an execute method from Statement 
	 * such as the following:
	 *   	execute: Returns true if the first object that the query 
	 *   				returns is a ResultSet object. Use this method 
	 *   				if the query could return one or more ResultSet 
	 *   				objects. Retrieve the ResultSet objects returned 
	 *   				from the query by repeatedly calling 
	 *   				Statement.getResultSet.
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
	
	private Connection conexao;
	
	// request.getContextPath()
	public boolean abrirConexao( )  {
	    try {
			Class.forName("org.h2.Driver");
			
			if( ModoTeste.testeAtivo == false)
				conexao = DriverManager.getConnection("jdbc:h2:~/restaurante", "admin", "admin");
			else
				conexao = DriverManager.getConnection("jdbc:h2:~/restauranteTeste", "admin", "admin");
			return true;
			
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao abrir conexão: Classe Não encontrada!");
			return false;
		} catch (SQLException e) {
			System.out.println("Erro ao abrir conexão: " + e.getMessage());
			return false;
		}
	    	    
	}
	
	public void fecharConexao() {
		try {
			conexao.close();
		} catch (SQLException e) {
			// Erro ao fechar conexão com o bancos
		}
	}
	
	/**
	 * Método que executa uma consulta de Insert/Update/Delete ao banco de dados, deve-se fazer uma chamada ao método 
	 * 		abrirConexao() antes;
	 * @param sql Consulta de Insert/Update/Delete a ser executada.
	 * @return Número de linhas afetadas pela consulta, -1 se ocorrer um erro.
	 */
	public int executarCUDQuery( String sql) {
		try {
			return conexao.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			return -1;
		}
	}
	
	/**
	 * Método que executa uma consulta de Select ao banco de dados,  deve-se fazer uma chamada ao método 
	 * 		abrirConexao() antes;
	 * @param sql Consulta Select a ser executada
	 * @return Resultados da consulta, NULL se ocorrer um erro.
	 */
	public ResultSet executarSelectQuery( String sql ) {
		try {
			return conexao.createStatement().executeQuery(sql);
		} catch (SQLException e) {
			return null;
		}
	}

	
}
