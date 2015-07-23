package Testes;

import org.junit.Test;

import entidades.CPF;
import entidades.Departamento;
import entidades.Funcionario;
import entidades.Sexo;
import entidades.Titulo;
import junit.framework.TestCase;

public class TesteUnitarioFuncionario extends TestCase{

	@Test
	public void testGetDepartamentoConstrutor1() {
		Funcionario funcionario = new Funcionario("Elaine",201154541,"2011",Sexo.FEMININO,Titulo.DOUTORADO,new CPF("12345678901"),
				new Departamento("Departamento de Computacao","DCC"));	
		
		assertEquals("Elaine",funcionario.getNome());
	}
	
	@Test
	public void testGetDepartamentoConstrutor2() {
		Funcionario funcionario = new Funcionario("Racicley",201154541,"2011", new Departamento("Departamento de Computacao","DCC"));
		
		assertEquals("Racicley",funcionario.getNome());
	}
}
