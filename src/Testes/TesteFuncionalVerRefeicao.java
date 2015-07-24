package Testes;

import java.sql.SQLException;

import junit.framework.TestCase;
import roteiros.RoteiroCriarDepartamento;
import roteiros.RoteiroCriarRefeicao;
import roteiros.RoteiroVerDepartamento;
import roteiros.RoteiroVerRefeicao;
import entidades.Departamento;
import entidades.Refeicao;

public class TesteFuncionalVerRefeicao  extends TestCase{
	
	public void testVerDepartamento() throws SQLException, Exception
	{
		BancoTeste.zerar();		
		RoteiroCriarRefeicao rCriarRefeicao = new RoteiroCriarRefeicao("Farofa", "NOITE", "Alface");
		rCriarRefeicao.executar();				
		
		RoteiroVerRefeicao rVerRefeicao = new RoteiroVerRefeicao("1");
		Refeicao refeicao = rVerRefeicao.executar();
		
		assertEquals("Farofa", refeicao.getDescricao());			
	}	

}
