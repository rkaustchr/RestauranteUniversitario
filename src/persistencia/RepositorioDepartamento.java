package persistencia;

import java.util.Collection;
import java.util.Set;
import javax.servlet.http.HttpSession;

import entidades.Departamento;


public class RepositorioDepartamento extends Repositorio<Departamento> {
	
	public RepositorioDepartamento(HttpSession session) {
		super(session, "departamentosDisponiveis");
	}

	@Override
	public void atualizar(Departamento antigo, Departamento novo) {
		Collection<Departamento> departamentosDisponiveis = listar();
		Departamento departamentoAntigo = buscar(antigo);
		departamentoAntigo.setNome(novo.getNome());
		departamentosDisponiveis.add(departamentoAntigo);
		
	}

	@Override
	public Departamento buscar(Departamento alvo) {
		Collection<Departamento> departamentosDisponiveis = listar();
		for(Departamento di : departamentosDisponiveis){
			if (alvo.getSigla().equals(di.getSigla()))
				return di;
		}
		return null;	
	}
}