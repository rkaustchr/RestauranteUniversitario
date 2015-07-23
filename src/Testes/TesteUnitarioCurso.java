package Testes;

import org.junit.Test;

import entidades.Curso;
import entidades.Departamento;
import junit.framework.TestCase;

public class TesteUnitarioCurso extends TestCase{

	Curso curso = new Curso("Ciencia da Computacao","CC",new Departamento("Departamento de Computacao","DCC"));
	
	@Test
	public void testGetNome() {
		assertEquals("Ciencia da Computacao", curso.getNome());
	}

	@Test
	public void testGetSigla() {
		assertEquals("CC",curso.getSigla());
	}

	@Test
	public void testGetDepartamento() {
		assertEquals("Departamento de Computacao", curso.getDepartamento().getNome());
	}
	
	@Test
	public void testSetNome() {
		curso.setNome("Letras");		
		assertEquals("Letras", curso.getNome());
	}

	@Test
	public void testSetDepartamento() {
		curso.setDepartamento(new Departamento("Departamento de Letras","DL"));
		assertEquals("Departamento de Letras", curso.getDepartamento().getNome());
	}
}
