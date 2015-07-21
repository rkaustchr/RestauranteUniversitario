package roteiros;

import entidades.Aluno;
import entidades.CPF;
import entidades.Consumidor;
import entidades.Curso;
import entidades.Departamento;
import entidades.Funcionario;
import entidades.Sexo;
import entidades.Titulo;
import gateway.AlunoGateway;
import gateway.ConsumidorFinder;
import gateway.CursoFinder;
import gateway.CursoGateway;
import gateway.DepartamentoFinder;
import gateway.DepartamentoGateway;
import gateway.FuncionarioGateway;
import gateway.IGateway;

public class RoteiroAtualizarConsumidor {

	private String nome;
	private int matricula;
	private String anoIngresso;
	private Sexo sexo;
	private Titulo titulo;
	private CPF cpf;
	private String sigla;
	private String tipo;

	public RoteiroAtualizarConsumidor() {
		super();
	}

	public RoteiroAtualizarConsumidor(String nome, int matricula,
			String anoIngresso, String sexo, String titulo, String cpf, String sigla, String tipo) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.matricula = matricula;
		this.anoIngresso = anoIngresso;
		this.sexo = Sexo.valueOf(sexo);
		this.titulo = Titulo.valueOf(titulo);
		this.cpf = new CPF(cpf);
		this.sigla = sigla;
		this.tipo = tipo;
	}

	public Consumidor executar() {
		Consumidor retorno;
		if(tipo.equals("A")){
			CursoFinder fCurso = new CursoFinder();
			AlunoGateway gAluno = new AlunoGateway(nome, matricula, anoIngresso, sexo, titulo, cpf, fCurso.find(sigla));
			gAluno.update();
			CursoGateway gCurso = gAluno.getCurso();
			DepartamentoGateway gDepartamento = gCurso.getDepartamento();
			Curso curso = new Curso(gCurso.getNome(), gCurso.getSigla(), new Departamento(gDepartamento.getNome(), gDepartamento.getSigla()));
			retorno = new Aluno(gAluno.getNome(), gAluno.getMatricula(), gAluno.getAnoIngresso(), gAluno.getSexo(), gAluno.getTitulo(), gAluno.getCpf(), curso);
		}
		else{
			DepartamentoFinder fDepartamento = new DepartamentoFinder();
			DepartamentoGateway gDepartamento = (DepartamentoGateway) fDepartamento.find(sigla);
			FuncionarioGateway gFuncionario = new FuncionarioGateway(nome, matricula, anoIngresso, sexo, titulo, cpf, gDepartamento);
			gFuncionario.update();
			Departamento departamento = new Departamento(gDepartamento.getNome(), gDepartamento.getSigla());
			retorno = new Funcionario(gFuncionario.getNome(), gFuncionario.getMatricula(), gFuncionario.getAnoIngresso(), gFuncionario.getSexo(), gFuncionario.getTitulo(), gFuncionario.getCpf(), departamento);
		}
		return retorno;
	}
	
	public Consumidor getConsumidor(String cpf) {
		ConsumidorFinder fConsumidor = new ConsumidorFinder();
		Consumidor retorno;
		
		IGateway gConsumidor = fConsumidor.find(cpf);
		try {
			if ( ((AlunoGateway) gConsumidor).getCurso() != null ) {
			}
			retorno = new Aluno(((AlunoGateway) gConsumidor).getNome(), ((AlunoGateway) gConsumidor).getMatricula(), ((AlunoGateway) gConsumidor).getAnoIngresso(), ((AlunoGateway) gConsumidor).getSexo(), ((AlunoGateway) gConsumidor).getTitulo(), ((AlunoGateway) gConsumidor).getCpf(),  new Curso(((AlunoGateway) gConsumidor).getCurso().getNome(), ((AlunoGateway) gConsumidor).getCurso().getSigla(), new Departamento(((AlunoGateway) gConsumidor).getCurso().getDepartamento().getNome(), ((AlunoGateway) gConsumidor).getCurso().getDepartamento().getSigla())) );
			
		} catch (Exception e) {
																																																																									
			retorno = new Funcionario(((FuncionarioGateway) gConsumidor).getNome(), ((FuncionarioGateway) gConsumidor).getMatricula(), ((FuncionarioGateway) gConsumidor).getAnoIngresso(), ((FuncionarioGateway) gConsumidor).getSexo(), ((FuncionarioGateway) gConsumidor).getTitulo(), ((FuncionarioGateway) gConsumidor).getCpf(), new Departamento(((FuncionarioGateway) gConsumidor).getDepartamento().getNome(), ((FuncionarioGateway) gConsumidor).getDepartamento().getSigla()));
		}
		return retorno;
	}
}
