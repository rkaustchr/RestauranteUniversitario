package roteiros;

import controladores.ccu.exceptions.DepartamentoNotFound;
import controladores.ccu.exceptions.RefeicaoNotFound;
import entidades.Departamento;
import entidades.Refeicao;
import entidades.Turno;
import gateway.DepartamentoFinder;
import gateway.DepartamentoGateway;
import gateway.IGateway;
import gateway.RefeicaoFinder;
import gateway.RefeicaoGateway;

public class RoteiroVerRefeicao {
	private String id;
	
	public RoteiroVerRefeicao(String id) {
		this.id = id;
	}

	public Refeicao executar() throws RefeicaoNotFound{
		RefeicaoFinder fRefeicao = new RefeicaoFinder();
		Refeicao retorno;
		
		IGateway gRefeicao = fRefeicao.find(id);
		retorno = new Refeicao(((RefeicaoGateway) gRefeicao).getId(), ((RefeicaoGateway) gRefeicao).getDescricao(), ((RefeicaoGateway) gRefeicao).getTurno(), ((RefeicaoGateway) gRefeicao).getOpcaoVegan() );
		
		return retorno;
	}

}
