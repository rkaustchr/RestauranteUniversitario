package entidades;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import persistencia.RepositorioDepartamento;
import entidades.value_objects.DepartamentoVO;

public class Departamento {

	public static Collection<DepartamentoVO> _listarDepartamentosDisponiveis(HttpSession session){
		RepositorioDepartamento repositorio = new RepositorioDepartamento(session);
		return 	repositorio.listar();
	}

	// metodos de persistencia para Departamento
	
	public static void _adicionarDepartamento(HttpSession session, DepartamentoVO dpto) {
		RepositorioDepartamento repositorio = new RepositorioDepartamento(session);
		repositorio.adicionar(dpto);
	}

	public static DepartamentoVO _buscarDepartamento(HttpSession session, String sigla) {
		RepositorioDepartamento repositorio = new RepositorioDepartamento(session);
		return 	repositorio.buscar(new DepartamentoVO(null,sigla));
	}

	public static void _atualizarDepartamento (HttpSession session, DepartamentoVO dpto){
		RepositorioDepartamento repositorio = new RepositorioDepartamento(session);
		repositorio.atualizar(new DepartamentoVO(null,dpto.getSigla()), dpto);
	}
}
