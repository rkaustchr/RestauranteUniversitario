package Teste;

import controladores.exceptions.CursoNotFound;
import controladores.exceptions.NomeNotFoundException;
import controladores.exceptions.SiglaAlreadyExistsException;
import controladores.exceptions.SiglaNotFoundException;
import entidades.Curso;
import gateway.CursoFinder;
import gateway.CursoGateway;
import junit.framework.TestCase;
import roteiros.RoteiroCriarCurso;
import roteiros.RoteiroCriarDepartamento;
import roteiros.RoteiroVerCurso;

public class CursoTeste extends TestCase {
	
	public void testCriarCurso() throws SiglaAlreadyExistsException, NomeNotFoundException, SiglaNotFoundException, CursoNotFound{
		Teste.zerar();		
		RoteiroCriarDepartamento rCriarDepartamento = new RoteiroCriarDepartamento("Departamento de Computacao", "DCC");
		rCriarDepartamento.executar();		
		RoteiroCriarCurso rCriarCurso = new RoteiroCriarCurso("Ciencia da Computacao", "CC", "DCC");
		rCriarCurso.executar();
		
		CursoFinder fCurso = new CursoFinder();
		CursoGateway gCurso = (CursoGateway) fCurso.find("CC");
		assertNotNull(gCurso);
	}
	
	public void testVerCurso() throws CursoNotFound, SiglaAlreadyExistsException, NomeNotFoundException, SiglaNotFoundException{
		Teste.zerar();	
		RoteiroCriarDepartamento rCriarDepartamento = new RoteiroCriarDepartamento("Departamento de Computacao", "DCC");
		rCriarDepartamento.executar();		
		RoteiroCriarCurso rCriarCurso = new RoteiroCriarCurso("Ciencia da Computacao", "CC", "DCC");
		rCriarCurso.executar();		
		
		RoteiroVerCurso rVerCurso = new RoteiroVerCurso("CC");
		Curso de = rVerCurso.executar();
		assertEquals("CC", de.getSigla());
	}
}
