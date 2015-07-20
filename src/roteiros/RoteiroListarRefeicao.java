package roteiros;

import java.util.ArrayList;
import entidades.Refeicao;
import gateway.IGateway;
import gateway.RefeicaoFinder;
import gateway.RefeicaoGateway;

public class RoteiroListarRefeicao {
	
	public RoteiroListarRefeicao() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Refeicao> executar() throws Exception {
		RefeicaoFinder fRefeicao = new RefeicaoFinder();
		ArrayList<Refeicao> retorno = new ArrayList<Refeicao>();
		
		for (IGateway gRefeicao : fRefeicao.findAll()) {
			retorno.add(new Refeicao( ((RefeicaoGateway) gRefeicao).getId(), ((RefeicaoGateway) gRefeicao).getDescricao(), ((RefeicaoGateway) gRefeicao).getTurno(), ((RefeicaoGateway) gRefeicao).getOpcaoVegan() ));
		}
		
		return retorno;		
	}

}
