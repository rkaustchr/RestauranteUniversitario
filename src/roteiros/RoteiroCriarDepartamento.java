package roteiros;

import controladores.ccu.exceptions.NomeNotFoundException;
import controladores.ccu.exceptions.SiglaAlreadyExistsException;
import controladores.ccu.exceptions.SiglaNotFoundException;
import gateway.DepartamentoFinder;
import gateway.DepartamentoGateway;

public class RoteiroCriarDepartamento {
	private String nome;
	private String sigla;
	
	public RoteiroCriarDepartamento(String nome, String sigla){
		this.nome = nome;
		this.sigla = sigla;
	}
	
	public void executar() throws SiglaNotFoundException, NomeNotFoundException, SiglaAlreadyExistsException{
		
		DepartamentoFinder fDepartamento = new DepartamentoFinder();
		if(fDepartamento.find(sigla) == null){
			if (sigla==""){
				throw new SiglaNotFoundException();
			}else{
				if (nome==""){
					throw new NomeNotFoundException();
				}else{
					DepartamentoGateway gDepartamento = new DepartamentoGateway(nome, sigla);
					gDepartamento.insert();
				}
			}
		}else{
			throw new SiglaAlreadyExistsException(sigla);
		}
	}
}
