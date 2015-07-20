package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.servlet.http.HttpSession;
import persistencia.RepositorioCurso;

public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private String sigla;
	private Departamento departamento;

	public Curso(String nome, String sigla, Departamento departamento) {
		this.nome = nome;
		this.sigla = sigla;
		this.departamento = departamento;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDepartamento(Departamento departamento){
		this.departamento = departamento;
	}

	public static Collection<Curso> _listarCursosDisponiveis(HttpSession session){
		RepositorioCurso repositorio = new RepositorioCurso(session);
		return repositorio.listar();
	}
	
	public static void _adicionarCurso(HttpSession session, Curso curso) {
		RepositorioCurso repositorio = new RepositorioCurso(session);
		repositorio.adicionar(curso);
	}

	public static Curso _buscarCurso(HttpSession session, String sigla) {
		RepositorioCurso repositorio = new RepositorioCurso(session);
		return repositorio.buscar(new Curso(null, sigla, null));
	}

	public static void _atualizarCurso(HttpSession session, Curso curso) {
		RepositorioCurso repositorio = new RepositorioCurso(session);
		repositorio.atualizar(new Curso(null,curso.getSigla(),null), curso);	
	}
}
