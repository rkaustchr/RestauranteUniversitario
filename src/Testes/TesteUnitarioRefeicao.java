package Testes;

import org.junit.Test;

import entidades.Refeicao;
import entidades.Turno;
import junit.framework.TestCase;

public class TesteUnitarioRefeicao extends TestCase{

	Refeicao refeicao = new Refeicao("1", "Bife", Turno.TARDE, "Grama");
	
	@Test
	public void testGetDescricao() {
		assertEquals("Bife", refeicao.getDescricao());		
	}

	@Test
	public void testSetDescricao() {		
		refeicao.setDescricao("Batatas");
		assertEquals("Batatas", refeicao.getDescricao());		
	}

	@Test
	public void testGetTurno() {
		assertEquals(Turno.TARDE, refeicao.getTurno());
	}

	@Test
	public void testSetTurno() {
		refeicao.setTurno(Turno.NOITE);
		assertEquals(Turno.NOITE, refeicao.getTurno());
	}

	@Test
	public void testGetOpcaoVegan() {
		assertEquals("Grama", refeicao.getOpcaoVegan());	
	}

	@Test
	public void testSetOpcaoVegan() {
		refeicao.setOpcaoVegan("Alface");;
		assertEquals("Alface", refeicao.getOpcaoVegan());
	}
}
