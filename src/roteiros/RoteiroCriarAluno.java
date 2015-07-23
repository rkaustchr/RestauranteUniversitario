package roteiros;

import controladores.exceptions.CpfAlreadyExistsException;
import controladores.exceptions.CursoNotFound;
import controladores.exceptions.NomeNotFoundException;
import controladores.exceptions.SiglaNotFoundException;
import entidades.CPF;
import entidades.Sexo;
import entidades.Titulo;
import gateway.AlunoGateway;
import gateway.CursoFinder;
import gateway.CursoGateway;


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

	public void executar() throws NomeNotFoundException, SiglaNotFoundException, CursoNotFound, CpfAlreadyExistsException{
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
					if ( gAluno.insert() == false ) 
						throw new CpfAlreadyExistsException(this.cpf);
				}
			}
		}
		else{
			throw new CursoNotFound();
		}
	}
}
