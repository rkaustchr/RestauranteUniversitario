package roteiros;


import controladores.exceptions.RefeicaoNotFound;
import entidades.Refeicao;
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
