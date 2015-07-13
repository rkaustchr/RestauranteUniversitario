package Teste;

import controladores.ccu.exceptions.DepartamentoNotFound;
import entidades.Departamento;
import junit.framework.TestCase;
import roteiros.RoteiroVerDepartamento;

public class CursoTeste extends TestCase{
	
	public void testVerDepartamento() throws DepartamentoNotFound{
		RoteiroVerDepartamento rVerDepartamento = new RoteiroVerDepartamento("DCC");
		Departamento de = rVerDepartamento.executar();
		assertEquals("DCC", de.getSigla());
	}
}
