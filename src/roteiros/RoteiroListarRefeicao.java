package roteiros;

import java.util.ArrayList;

import gateway.IGateway;
import gateway.RefeicaoFinder;

public class RoteiroListarRefeicao {
	
	public RoteiroListarRefeicao() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<IGateway> executar() throws Exception {
		RefeicaoFinder fRefeicao = new RefeicaoFinder();
		
		return fRefeicao.findAll();
		
	}

}
