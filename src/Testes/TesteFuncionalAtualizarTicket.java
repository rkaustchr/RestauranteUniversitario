package Testes;

import java.io.FileInputStream;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;

import entidades.Sexo;
import entidades.Titulo;
import roteiros.RoteiroAtualizarRefeicao;
import roteiros.RoteiroAtualizarTicket;
import roteiros.RoteiroCriarDepartamento;
import roteiros.RoteiroCriarFuncionario;
import roteiros.RoteiroCriarRefeicao;
import roteiros.RoteiroCriarTicket;

public class TesteFuncionalAtualizarTicket extends DBTestCase{
	
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
	
	public void testAtualizarTicket() throws SQLException, Exception
	{
		BancoTeste.zerar();		
		
		RoteiroCriarDepartamento rCriarDepartamento = new RoteiroCriarDepartamento("Departamento de Computacao", "DCC");
		rCriarDepartamento.executar();
		
		RoteiroCriarRefeicao rCriarRefeicao = new RoteiroCriarRefeicao("Farofa", "NOITE", "Alface");
		rCriarRefeicao.executar();			
		
		RoteiroCriarFuncionario rCriarFuncionario = new RoteiroCriarFuncionario("Kaustchr", 2010780154, "2010", Sexo.MASCULINO.toString(), Titulo.DOUTORADO.toString(), "12345678901", "DCC" );
		rCriarFuncionario.executar();	
		
		RoteiroCriarTicket rCriarTicket = new RoteiroCriarTicket("1", true, "12345678901");
		rCriarTicket.executar();	
		
		RoteiroAtualizarTicket rAtualizarTicket = new RoteiroAtualizarTicket(1, true);
		rAtualizarTicket.executar();
		
		IDataSet dadosSetBanco = getConnection().createDataSet();
		ITable dadosNoBanco = dadosSetBanco.getTable("ticket");
		ITable filteredTable = DefaultColumnFilter.excludedColumnsTable(dadosNoBanco, new String[]{"id"});
		
		IDataSet dadosSetEsperado = new FlatXmlDataSetBuilder().build(new FileInputStream("xml/datasetAtualizarTicket.xml"));
		ITable dadosEsperados = dadosSetEsperado.getTable("ticket");
		
		Assertion.assertEquals(dadosEsperados, filteredTable);
	}
	
	@Override
	protected void setUpDatabaseConfig(DatabaseConfig config){
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		bancoCarregado = new FlatXmlDataSetBuilder().build( new FileInputStream("xml/datasetAtualizarTicket.xml"));
		return bancoCarregado;
	}

}
