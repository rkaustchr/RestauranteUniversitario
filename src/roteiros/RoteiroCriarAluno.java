package roteiros;

import controladores.ccu.exceptions.CursoNotFound;
import controladores.ccu.exceptions.NomeNotFoundException;
import controladores.ccu.exceptions.SiglaAlreadyExistsException;
import controladores.ccu.exceptions.SiglaNotFoundException;
import entidades.CPF;
import entidades.Curso;
import entidades.Sexo;
import entidades.Titulo;
import gateway.AlunoGateway;
import gateway.CursoFinder;
import gateway.CursoGateway;


public class RoteiroCriarAluno {
	private String nome;
	private int matricula;
	private int anoIngresso;
	private Sexo sexo;
	private Titulo titulo;
	private CPF cpf;
	private String siglaCurso;
	
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
}
