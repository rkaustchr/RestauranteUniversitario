package gateway;

import java.util.ArrayList;

import entidades.Refeicao;
import entidades.Turno;

public class RefeicaoFinder implements IFinder {

	@Override
	public ArrayList<IGateway> findAll() {
		ArrayList<IGateway> gRefeicao = new ArrayList<IGateway>();
		
		gRefeicao.add(new RefeicaoGateway(1, "Picanha na brasa", "Cocô" , Turno.NOITE));
		gRefeicao.add(new RefeicaoGateway(2, "Costela acebolada", "Grama" , Turno.MANHA));
		return gRefeicao;
	}

	@Override
	public IGateway find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
