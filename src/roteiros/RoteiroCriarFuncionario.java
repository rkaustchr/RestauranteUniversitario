package roteiros;

import controladores.ccu.exceptions.DepartamentoNotFound;
import controladores.ccu.exceptions.NomeNotFoundException;
import controladores.ccu.exceptions.SiglaNotFoundException;
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
	
	public void execute() throws NomeNotFoundException, SiglaNotFoundException, DepartamentoNotFound{
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
					gFuncionario.insert();
				}
			}
		}
		else{
			throw new DepartamentoNotFound();
		}
	}
}
