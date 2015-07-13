package roteiros;

import controladores.ccu.exceptions.CursoNotFound;
import controladores.ccu.exceptions.SiglaNotFoundException;
import entidades.Curso;
import entidades.Departamento;
import gateway.CursoFinder;
import gateway.CursoGateway;

public class RoteiroVerCurso {
	private String id;
	
	public RoteiroVerCurso( String id ) {
		this.id = id;
	}

	public Curso execute() throws CursoNotFound {
		CursoFinder fCurso = new CursoFinder();
		Curso retorno;
		CursoGateway gCurso = (CursoGateway) fCurso.find(id);
		if ( gCurso == null )  throw new CursoNotFound();
		retorno = new Curso( gCurso.getNome(), gCurso.getSigla(), new Departamento( gCurso.getDepartamento().getNome(), gCurso.getDepartamento().getSigla()) );
		
		return retorno;
	}
	

}
