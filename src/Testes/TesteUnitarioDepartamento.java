package Testes;

import org.junit.Test;

import entidades.Departamento;
import junit.framework.TestCase;

public class TesteUnitarioDepartamento  extends TestCase{
	
	Departamento departamento = new Departamento("Departamento de Computacao","DCC");

	@Test
	public void testGetNome() {
		assertEquals("Departamento de Computacao", departamento.getNome());
	}

	@Test
	public void testGetSigla() {
		assertEquals("DCC", departamento.getSigla());
	}

	@Test
	public void testSetNome() {
		departamento.setNome("Departamento de Letras");
		assertEquals("Departamento de Letras", departamento.getNome());		
	}
}
