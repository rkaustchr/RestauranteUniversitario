package roteiros;

import java.util.ArrayList;

import entidades.Curso;
import entidades.Departamento;
import gateway.CursoFinder;
import gateway.CursoGateway;
import gateway.DepartamentoGateway;
import gateway.IGateway;

public class RoteiroListarCurso {

	public RoteiroListarCurso() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Curso> executar() throws Exception {
		CursoFinder fCurso = new CursoFinder();
		ArrayList<Curso> retorno = new ArrayList<Curso>();
		
		for (IGateway gCurso : fCurso.findAll()) {
			DepartamentoGateway Gdept = ((CursoGateway) gCurso).getDepartamento();
			Departamento dept = new Departamento(Gdept.getNome(), Gdept.getSigla());
			retorno.add(new Curso(((CursoGateway) gCurso).getNome(), ((CursoGateway) gCurso).getSigla(), dept));
		}
		
		return retorno;		
	}

}
