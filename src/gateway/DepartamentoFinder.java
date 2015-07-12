package gateway;

import java.util.ArrayList;

public class DepartamentoFinder implements IFinder {
	public DepartamentoFinder(){
		
	}
	
	@Override
	public ArrayList<IGateway> findAll() {
		ArrayList<IGateway> gDepartamentos = new ArrayList<IGateway>();
		gDepartamentos.add(new DepartamentoGateway("Racicley", "CLEY"));
		
		return gDepartamentos;
	}

	@Override
	public IGateway find() {
		// TODO Auto-generated method stub
		return null;
	}
}
