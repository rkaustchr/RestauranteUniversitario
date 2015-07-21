package roteiros;

import controladores.exceptions.CursoNotFound;
import entidades.Curso;
import entidades.Departamento;
import gateway.CursoFinder;
import gateway.CursoGateway;

public class RoteiroVerCurso {
	private String id;
	
	public RoteiroVerCurso( String id ) {
		this.id = id;
	}

	public Curso executar() throws CursoNotFound {
		CursoFinder fCurso = new CursoFinder();
		Curso retorno;
		CursoGateway gCurso = (CursoGateway) fCurso.find(id);
		if ( gCurso == null )  throw new CursoNotFound();
		retorno = new Curso( gCurso.getNome(), gCurso.getSigla(), new Departamento( gCurso.getDepartamento().getNome(), gCurso.getDepartamento().getSigla()) );
		
		return retorno;
	}

}