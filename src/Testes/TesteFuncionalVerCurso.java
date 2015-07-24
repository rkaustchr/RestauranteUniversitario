package Testes;

import java.sql.SQLException;

import junit.framework.TestCase;
import roteiros.RoteiroCriarCurso;
import roteiros.RoteiroCriarDepartamento;
import roteiros.RoteiroCriarFuncionario;
import roteiros.RoteiroVerConsumidor;
import roteiros.RoteiroVerCurso;
import entidades.Consumidor;
import entidades.Curso;
import entidades.Sexo;
import entidades.Titulo;

public class TesteFuncionalVerCurso extends TestCase{
	
	public void testVerCurso() throws SQLException, Exception
	{
		BancoTeste.zerar();		
		
		RoteiroCriarDepartamento rCriarDepartamento = new RoteiroCriarDepartamento("Departamento de Computacao", "DCC");
		rCriarDepartamento.executar();
		
		RoteiroCriarCurso rCriarCurso = new RoteiroCriarCurso("Ciencia da Computacao", "CC", "DCC");
		rCriarCurso.executar();
		
		RoteiroVerCurso rVerCurso = new RoteiroVerCurso("CC");
		Curso curso = rVerCurso.executar();
		
		assertEquals("Ciencia da Computacao", curso.getNome());			
	}	

}
