package Testes;

import java.sql.SQLException;

import junit.framework.TestCase;
import roteiros.RoteiroCriarCurso;
import roteiros.RoteiroCriarDepartamento;
import roteiros.RoteiroVerCurso;
import roteiros.RoteiroVerDepartamento;
import entidades.Curso;
import entidades.Departamento;

public class TesteFuncionalVerDepartamento extends TestCase{
	
	public void testVerDepartamento() throws SQLException, Exception
	{
		BancoTeste.zerar();		
		
		RoteiroCriarDepartamento rCriarDepartamento = new RoteiroCriarDepartamento("Departamento de Computacao", "DCC");
		rCriarDepartamento.executar();		
		
		RoteiroVerDepartamento rVerDepartamento = new RoteiroVerDepartamento("CC");
		Departamento departamento = rVerDepartamento.executar();
		
		assertEquals("Departamento de Computacao", departamento.getNome());			
	}	

}
