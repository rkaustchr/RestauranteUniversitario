package roteiros;

import java.util.ArrayList;
import entidades.Departamento;
import gateway.DepartamentoFinder;
import gateway.DepartamentoGateway;
import gateway.IGateway;

public class RoteiroListarDepartamento {
	
	public RoteiroListarDepartamento(){
		
	}
	
	public ArrayList<Departamento> executar() throws Exception {
		DepartamentoFinder fDepartamento = new DepartamentoFinder();
		ArrayList<Departamento> retorno = new ArrayList<Departamento>();
		
		for (IGateway gDepartamento : fDepartamento.findAll()) {
			retorno.add(new Departamento(((DepartamentoGateway) gDepartamento).getNome(), ((DepartamentoGateway) gDepartamento).getSigla()));
		}
		
		return retorno;
	}
}
