package Teste;

import controladores.exceptions.DepartamentoNotFound;
import controladores.exceptions.NomeNotFoundException;
import controladores.exceptions.SiglaAlreadyExistsException;
import controladores.exceptions.SiglaNotFoundException;
import entidades.Departamento;
import gateway.DepartamentoFinder;
import gateway.DepartamentoGateway;
import junit.framework.TestCase;
import roteiros.RoteiroCriarDepartamento;
import roteiros.RoteiroVerDepartamento;

public class DepartamentoTeste extends TestCase {	
	
	public void testCriarDepartamento() throws SiglaAlreadyExistsException, NomeNotFoundException, SiglaNotFoundException{
		Teste.zerar();
		RoteiroCriarDepartamento rCriarDepartamento = new RoteiroCriarDepartamento("Departamento de Computacao", "DCC");
		rCriarDepartamento.executar();
		
		DepartamentoFinder fDepartamento = new DepartamentoFinder();
		DepartamentoGateway gDepartamento = (DepartamentoGateway) fDepartamento.find("DCC");
		assertNotNull(gDepartamento);		
	}
	
	public void testVerDepartamento() throws DepartamentoNotFound, SiglaNotFoundException, NomeNotFoundException, SiglaAlreadyExistsException{
		Teste.zerar();		
		RoteiroCriarDepartamento rCriarDepartamento = new RoteiroCriarDepartamento("Departamento de Computacao", "DCC");
		rCriarDepartamento.executar();
		
		RoteiroVerDepartamento rVerDepartamento = new RoteiroVerDepartamento("DCC");
		Departamento de = rVerDepartamento.executar();
		assertEquals("DCC", de.getSigla());
	}

}
