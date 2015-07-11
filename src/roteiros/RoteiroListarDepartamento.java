package roteiros;

import java.util.ArrayList;

import gateway.DepartamentoFinder;
import gateway.IGateway;

public class RoteiroListarDepartamento {
	
	public RoteiroListarDepartamento(){
		
	}
	
	public ArrayList<IGateway> executar() throws Exception {
		DepartamentoFinder fDepartamento = new DepartamentoFinder();
		
		return fDepartamento.findAll();
		
	}
}
