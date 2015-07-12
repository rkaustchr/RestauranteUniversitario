package roteiros;

import java.util.ArrayList;

import gateway.CursoFinder;
import gateway.IGateway;
import gateway.RefeicaoFinder;

public class RoteiroListarCurso {

	public RoteiroListarCurso() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<IGateway> executar() throws Exception {
		CursoFinder fCurso = new CursoFinder();
		
		return fCurso.findAll();
		
	}

}
