package roteiros;

import controladores.ccu.exceptions.CursoNotFound;
import controladores.ccu.exceptions.DepartamentoNotFound;
import entidades.Curso;
import entidades.Departamento;
import gateway.CursoFinder;
import gateway.CursoGateway;
import gateway.DepartamentoFinder;
import gateway.DepartamentoGateway;

public class RoteiroAtualizarCurso {
	private String id;
	private String nome;
	private String siglaDepartamento;
	
	public RoteiroAtualizarCurso(String id, String nome, String siglaDepartamento) {
		this.id = id;
		this.nome = nome;
		this.siglaDepartamento = siglaDepartamento;
	}

	public Curso execute() throws CursoNotFound {
		DepartamentoFinder fDepartamento = new DepartamentoFinder();
		CursoGateway gCurso = new CursoGateway(this.nome, this.id, (DepartamentoGateway) fDepartamento.find(siglaDepartamento));
		gCurso.update();
		
		if ( gCurso == null ) throw new CursoNotFound();
		
		return new Curso(gCurso.getNome(), gCurso.getSigla(), new Departamento(gCurso.getDepartamento().getNome(), gCurso.getDepartamento().getSigla()) );
		
	}

}
