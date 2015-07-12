package roteiros;

import java.io.IOException;

import controladores.ccu.exceptions.NomeNotFoundException;
import controladores.ccu.exceptions.SiglaAlreadyExistsException;
import controladores.ccu.exceptions.SiglaNotFoundException;
import entidades.Departamento;
import gateway.DepartamentoFinder;
import gateway.DepartamentoGateway;

public class RoteiroCriarDepartamento {

	public void execute(String nome, String sigla) throws SiglaNotFoundException, NomeNotFoundException, SiglaAlreadyExistsException{
		
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
