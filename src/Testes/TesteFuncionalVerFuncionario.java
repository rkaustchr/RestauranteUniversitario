package Testes;

import java.sql.SQLException;

import junit.framework.TestCase;

import entidades.Consumidor;
import entidades.Sexo;
import entidades.Titulo;
import roteiros.RoteiroCriarDepartamento;
import roteiros.RoteiroCriarFuncionario;
import roteiros.RoteiroVerConsumidor;

public class TesteFuncionalVerFuncionario extends TestCase {
	
	public void testAtualizarDepartamento() throws SQLException, Exception
	{
		BancoTeste.zerar();		
		
		RoteiroCriarDepartamento rCriarDepartamento = new RoteiroCriarDepartamento("Departamento de Computacao", "DCC");
		rCriarDepartamento.executar();
		
		RoteiroCriarFuncionario rCriarFuncionario = new RoteiroCriarFuncionario("Kaustchr", 2010780154, "2010", Sexo.MASCULINO.toString(), Titulo.DOUTORADO.toString(), "12345678901", "DCC" );
		rCriarFuncionario.executar();	
		
		RoteiroVerConsumidor rVerConsumidor = new RoteiroVerConsumidor("12345678901");
		Consumidor consumidor = rVerConsumidor.executar();
		
		assertEquals("Kaustchr", consumidor.getNome());			
	}	
}
