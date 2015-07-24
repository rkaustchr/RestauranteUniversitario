package roteiros;

import controladores.exceptions.NomeNotFoundException;
import controladores.exceptions.SiglaAlreadyExistsException;
import controladores.exceptions.SiglaNotFoundException;
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

	public void executar() throws SiglaAlreadyExistsException, NomeNotFoundException, SiglaNotFoundException {
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
					boolean b = gCurso.insert();
					if (b == false)
						throw new SiglaAlreadyExistsException(sigla);
					
				}
			}
		}else{
			throw new SiglaAlreadyExistsException(sigla);
		}
		
	}

}
