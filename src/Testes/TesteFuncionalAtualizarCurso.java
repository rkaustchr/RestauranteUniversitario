package Testes;

import java.io.FileInputStream;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;

import roteiros.RoteiroAtualizarCurso;
import roteiros.RoteiroCriarCurso;
import roteiros.RoteiroCriarDepartamento;

public class TesteFuncionalAtualizarCurso extends DBTestCase{
	
private FlatXmlDataSet bancoCarregado;
	
	@Before
	public void setUp() throws Exception {
		 	System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.h2.Driver" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:h2:~/restauranteTeste" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "admin" );
	        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "admin" );        
	}
	
	protected DatabaseOperation getSetUpOperation() throws Exception{			
		return DatabaseOperation.REFRESH;		
	}
	
	protected DatabaseOperation getTearDownOperation() throws Exception{
		return DatabaseOperation.DELETE_ALL;
	}
	
	public void testAtualizarCurso() throws SQLException, Exception
	{
		BancoTeste.zerar();		
		
		RoteiroCriarDepartamento rCriarDepartamento = new RoteiroCriarDepartamento("Departamento de Computacao", "DCC");
		rCriarDepartamento.executar();		
		
		RoteiroCriarCurso rCriarCurso = new RoteiroCriarCurso("Ciencia da Computacao", "CC", "DCC");
		rCriarCurso.executar();	
		
		RoteiroAtualizarCurso rAtualizarCurso = new RoteiroAtualizarCurso("CC", "Historia","DCC");
		rAtualizarCurso.executar();		
		
		IDataSet dadosSetBanco = getConnection().createDataSet();
		ITable dadosNoBanco = dadosSetBanco.getTable("curso");
		
		IDataSet dadosSetEsperado = new FlatXmlDataSetBuilder().build(new FileInputStream("xml/datasetAtualizarCurso.xml"));
		ITable dadosEsperados = dadosSetEsperado.getTable("curso");
		
		Assertion.assertEquals(dadosEsperados, dadosNoBanco);
	}
	
	@Override
	protected void setUpDatabaseConfig(DatabaseConfig config){
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		bancoCarregado = new FlatXmlDataSetBuilder().build( new FileInputStream("xml/datasetAtualizarCurso.xml"));
		return bancoCarregado;
	}

}
