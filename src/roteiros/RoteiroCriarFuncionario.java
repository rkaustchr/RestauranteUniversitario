package roteiros;

import controladores.exceptions.CpfAlreadyExistsException;
import controladores.exceptions.DepartamentoNotFound;
import controladores.exceptions.NomeNotFoundException;
import controladores.exceptions.SiglaNotFoundException;
import entidades.CPF;
import entidades.Sexo;
import entidades.Titulo;
import gateway.DepartamentoFinder;
import gateway.DepartamentoGateway;
import gateway.FuncionarioGateway;


public class RoteiroCriarFuncionario {
	private String nome;
	private int matricula;
	private String anoIngresso;
	private Sexo sexo;
	private Titulo titulo;
	private CPF cpf;
	private String siglaDepartamento;
	
	public RoteiroCriarFuncionario() {
		
	}
	
	public RoteiroCriarFuncionario(String nome, int matricula,
			String anoIngresso, String sexo, String titulo, String cpf,
			String siglaDepartamento) {
		this.nome = nome;
		this.matricula = matricula;
		this.anoIngresso = anoIngresso;
		this.sexo = Sexo.valueOf(sexo);
		this.titulo = Titulo.valueOf(titulo);
		this.cpf = new CPF(cpf);
		this.siglaDepartamento = siglaDepartamento;
	}

	public void execute() throws NomeNotFoundException, SiglaNotFoundException, DepartamentoNotFound, CpfAlreadyExistsException{
		DepartamentoFinder fDepartamento = new DepartamentoFinder();
		DepartamentoGateway gDepartamento = (DepartamentoGateway) fDepartamento.find(this.siglaDepartamento);
		if( gDepartamento != null ){			
			if (this.cpf.toString() == ""){
				throw new SiglaNotFoundException();
			}else{
				if (this.nome==""){
					throw new NomeNotFoundException();
				}else{
					FuncionarioGateway gFuncionario = new FuncionarioGateway(this.nome, this.matricula, this.anoIngresso, this.sexo, this.titulo, this.cpf, gDepartamento);
					if ( gFuncionario.insert() == false ) {
						throw new CpfAlreadyExistsException(this.cpf);
					}
				}
			}
		}
		else{
			throw new DepartamentoNotFound();
		}
	}

}
