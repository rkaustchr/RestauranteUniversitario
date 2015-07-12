package gateway;

import java.util.ArrayList;

import com.sun.org.apache.xalan.internal.xsltc.dom.ArrayNodeListIterator;

import entidades.Aluno;
import entidades.CPF;
import entidades.Consumidor;
import entidades.Curso;
import entidades.Sexo;
import entidades.Titulo;
import entidades.value_objects.DepartamentoVO;

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
