package Testes;

import java.sql.SQLException;

import junit.framework.TestCase;
import roteiros.RoteiroCriarDepartamento;
import roteiros.RoteiroCriarFuncionario;
import roteiros.RoteiroCriarRefeicao;
import roteiros.RoteiroCriarTicket;
import roteiros.RoteiroVerRefeicao;
import roteiros.RoteiroVerTicket;
import entidades.Ticket;
import entidades.Refeicao;
import entidades.Sexo;
import entidades.Titulo;

public class TesteFuncionalVerTicket extends TestCase{
	
	public void testVerDepartamento() throws SQLException, Exception
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
		
		RoteiroVerTicket rVerTicket = new RoteiroVerTicket("1");
		Ticket ticket = rVerTicket.executar();
		
		
		assertEquals(true, ticket.isPago());			
	}	

}
