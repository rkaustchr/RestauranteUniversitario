package roteiros;


import java.util.ArrayList;

import controladores.ccu.exceptions.CursoNotFound;
import controladores.ccu.exceptions.NomeNotFoundException;
import controladores.ccu.exceptions.SiglaNotFoundException;
import entidades.CPF;
import entidades.Curso;
import entidades.Departamento;
import entidades.Sexo;
import entidades.Titulo;
import gateway.AlunoGateway;
import gateway.CursoFinder;
import gateway.CursoGateway;
import gateway.DepartamentoGateway;
import gateway.IGateway;


public class RoteiroCriarAluno {
	private String nome;
	private int matricula;
	private String anoIngresso;
	private Sexo sexo;
	private Titulo titulo;
	private CPF cpf;
	private String siglaCurso;
	
	
	public RoteiroCriarAluno() {
		super();
	}

	public RoteiroCriarAluno(String nome, int matricula, String anoIngresso, String sexo, String titulo, String cpf,
			String siglaCurso) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.anoIngresso = anoIngresso;
		this.sexo = Sexo.valueOf(sexo);
		this.titulo = Titulo.valueOf(titulo);
		this.cpf = new CPF(cpf);
		this.siglaCurso = siglaCurso;
	}

	public void execute() throws NomeNotFoundException, SiglaNotFoundException, CursoNotFound{
		CursoFinder fCurso = new CursoFinder();
		CursoGateway gCurso = (CursoGateway) fCurso.find(this.siglaCurso);
		if( gCurso != null ){			
			if (this.cpf.toString() == ""){
				throw new SiglaNotFoundException();
			}else{
				if (this.nome==""){
					throw new NomeNotFoundException();
				}else{
					AlunoGateway gAluno = new AlunoGateway(this.nome, this.matricula, this.anoIngresso, this.sexo, this.titulo, this.cpf, gCurso);
					gAluno.insert();
				}
			}
		}
		else{
			throw new CursoNotFound();
		}
	}

	public ArrayList<Curso> getListaCurso() {
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
