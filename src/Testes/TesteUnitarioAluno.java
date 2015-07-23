package Testes;

import org.junit.Test;

import entidades.Aluno;
import entidades.CPF;
import entidades.Curso;
import entidades.Departamento;
import entidades.Sexo;
import entidades.Titulo;
import junit.framework.TestCase;

public class TesteUnitarioAluno extends TestCase{

	Aluno aluno = new Aluno("Thiago",2011,"2011",Sexo.MASCULINO,Titulo.DOUTORADO,new CPF("12345678901"),
			new Curso("Ciencia da Computacao","CC",new Departamento("Departamento de Computacao","DCC")));	

	@Test
	public void testGetCurso() {		
		
		assertEquals("Ciencia da Computacao",aluno.getCurso().getNome());
	}

}
