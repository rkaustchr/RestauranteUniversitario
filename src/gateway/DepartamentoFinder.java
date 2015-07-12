package gateway;

import java.util.ArrayList;

public class DepartamentoFinder implements IFinder {
	public DepartamentoFinder(){
		
	}
	
	@Override
	public ArrayList<IGateway> findAll() {
		ArrayList<IGateway> gDepartamentos = new ArrayList<IGateway>();
									//String nome, int matricula, int anoIngresso, Sexo sexo, Titulo titulo, CPF cpf, Curso curso // (String nome, String sigla, DepartamentoVO departamento)
		gDepartamentos.add(new DepartamentoGateway("Racicley", "CLEY"));
		
		return gDepartamentos;
	}

	@Override
	public IGateway find() {
		// TODO Auto-generated method stub
		return null;
	}
}
