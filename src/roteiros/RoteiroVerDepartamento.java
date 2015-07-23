package roteiros;

import controladores.exceptions.DepartamentoNotFound;
import entidades.Departamento;
import gateway.DepartamentoFinder;
import gateway.DepartamentoGateway;
import gateway.IGateway;

public class RoteiroVerDepartamento {
	String id;
	
	public RoteiroVerDepartamento(String id){
		this.id = id;
	}
	
	public Departamento executar() throws DepartamentoNotFound {
		DepartamentoFinder fDepartamento = new DepartamentoFinder();
		Departamento retorno;
		
		IGateway gDepartamento = fDepartamento.find(id);
		retorno = new Departamento(((DepartamentoGateway) gDepartamento).getNome(), ((DepartamentoGateway) gDepartamento).getSigla());
		
		return retorno;
	}
		
	
}
