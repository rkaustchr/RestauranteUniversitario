package Testes;

import junit.framework.TestCase;

import org.junit.Test;

import entidades.Aluno;
import entidades.CPF;
import entidades.Curso;
import entidades.Departamento;
import entidades.Refeicao;
import entidades.Sexo;
import entidades.Ticket;
import entidades.Titulo;
import entidades.Turno;

public class TesteUnitarioTicket extends TestCase{

	Ticket ticket = new Ticket(0, new Refeicao("1", "Bife", Turno.TARDE, "Grama"), true, new Aluno("Thiago",2011,"2011",Sexo.MASCULINO,Titulo.DOUTORADO,new CPF("12345678901"),
			new Curso("Ciencia da Computacao","CC",new Departamento("Departamento de Computacao","DCC"))));
	
	@Test
	public void testGetRefeicao() {
		assertEquals("Bife", ticket.getRefeicao().getDescricao());
	}

	@Test
	public void testGetConsumidor() {
		assertEquals("Thiago", ticket.getConsumidor().getNome());
	}
}
