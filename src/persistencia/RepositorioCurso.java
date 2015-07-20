package persistencia;

import java.util.Collection;
import javax.servlet.http.HttpSession;

import entidades.Curso;

public class RepositorioCurso extends Repositorio<Curso> {
	
	public RepositorioCurso(HttpSession session) {
		super(session, "cursosDisponiveis");
	}
	
	@Override
	public void atualizar(Curso antigo, Curso novo) {
		Collection<Curso> cursosDisponiveis = listar();
		Curso cursoAntigo = buscar(antigo);
		cursoAntigo.setNome(novo.getNome());
		cursoAntigo.setDepartamento(novo.getDepartamento());
		cursosDisponiveis.add(cursoAntigo);
	}
		
	@Override
	public Curso buscar(Curso alvo) {
		Collection<Curso> cursosDisponiveis = listar();
		for(Curso di : cursosDisponiveis){
			if (alvo.getSigla().equals(di.getSigla()))
				return di;
		}
		return null;	
	}
}