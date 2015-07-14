package roteiros;

import java.util.ArrayList;

import entidades.Departamento;
import entidades.Refeicao;
import entidades.Turno;
import gateway.DepartamentoGateway;
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
			retorno.add(new Refeicao( ((Refeicao) gRefeicao).getId(), ((Refeicao) gRefeicao).getDescricao(), ((Refeicao) gRefeicao).getTurno(), ((Refeicao) gRefeicao).getOpcaoVegan() ));
		}
		
		return retorno;		
	}

}
