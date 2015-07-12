package gateway;

import java.util.ArrayList;

public class CursoFinder implements IFinder {

	@Override
	public ArrayList<IGateway> findAll() {
		ArrayList<IGateway> gCurso = new ArrayList<IGateway>();
		
		gCurso.add(new CursoGateway("Racicley", "CLEY", new DepartamentoGateway("DepRacicley", "DCLEY")));
		return gCurso;
	}

	@Override
	public IGateway find() {
		// TODO Auto-generated method stub
		return null;
	}

}
