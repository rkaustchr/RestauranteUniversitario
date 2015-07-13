package roteiros;

import controladores.ccu.exceptions.NomeNotFoundException;
import controladores.ccu.exceptions.SiglaAlreadyExistsException;
import controladores.ccu.exceptions.SiglaNotFoundException;
import gateway.CursoGateway;
import gateway.DepartamentoFinder;
import gateway.DepartamentoGateway;

public class RoteiroCriarCurso {
	private String nome;
	private String sigla;
	private String siglaDepartamento;
	
	public RoteiroCriarCurso(String nome, String sigla, String siglaDepartamento) {
		this.nome = nome;
		this.sigla = sigla;
		this.siglaDepartamento = siglaDepartamento;
	}

	public void execute() throws SiglaAlreadyExistsException, NomeNotFoundException, SiglaNotFoundException {
		DepartamentoFinder fDepartamento = new DepartamentoFinder();
		DepartamentoGateway gDepartamento = (DepartamentoGateway) fDepartamento.find(this.siglaDepartamento);
		if( gDepartamento != null ){			
			if (this.sigla==""){
				throw new SiglaNotFoundException();
			}else{
				if (this.nome==""){
					throw new NomeNotFoundException();
				}else{
					CursoGateway gCurso = new CursoGateway(nome, sigla, gDepartamento);
					gCurso.insert();
				}
			}
		}else{
			throw new SiglaAlreadyExistsException(sigla);
		}
		
	}

}
