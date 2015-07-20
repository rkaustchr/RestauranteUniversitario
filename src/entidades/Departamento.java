package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpSession;
import persistencia.RepositorioDepartamento;

public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private String sigla;
	
	
	public Departamento(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}

	
	public static Collection<Departamento> _listarDepartamentosDisponiveis(HttpSession session){
		RepositorioDepartamento repositorio = new RepositorioDepartamento(session);
		return 	repositorio.listar();
	}
	

	// metodos de persistencia para Departamento
	
	
	public static void _adicionarDepartamento(HttpSession session, Departamento dpto) {
		RepositorioDepartamento repositorio = new RepositorioDepartamento(session);
		repositorio.adicionar(dpto);
	}
	
	
	public static Departamento _buscarDepartamento(HttpSession session, String sigla) {
		RepositorioDepartamento repositorio = new RepositorioDepartamento(session);
		return 	repositorio.buscar(new Departamento(null,sigla));
	}
	

	
	public static void _atualizarDepartamento (HttpSession session, Departamento dpto){
		RepositorioDepartamento repositorio = new RepositorioDepartamento(session);
		repositorio.atualizar(new Departamento(null,dpto.getSigla()), dpto);
	}

	public void setNome(String nome) {
		// TODO Auto-generated method stub
		this.nome = nome;
	}
	
}
