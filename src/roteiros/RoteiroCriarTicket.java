package roteiros;

import gateway.ConsumidorFinder;
import gateway.ConsumidorGateway;
import gateway.CursoGateway;
import gateway.DepartamentoFinder;
import gateway.DepartamentoGateway;
import gateway.IGateway;
import gateway.RefeicaoFinder;
import gateway.RefeicaoGateway;
import gateway.TicketGateway;
import controladores.ccu.exceptions.ConsumidorNotFoundException;
import controladores.ccu.exceptions.NomeNotFoundException;
import controladores.ccu.exceptions.RefeicaoNotFoundException;
import controladores.ccu.exceptions.SiglaAlreadyExistsException;
import controladores.ccu.exceptions.SiglaNotFoundException;

public class RoteiroCriarTicket {
	private String idRefeicao;
	private boolean pago;
	private String cpfConsumidor;
	
	public RoteiroCriarTicket(String idRefeicao, boolean pago, String cpfConsumidor) {
		this.idRefeicao = idRefeicao;
		this.pago = pago;
		this.cpfConsumidor = cpfConsumidor;
	}

	public void executar() throws RefeicaoNotFoundException, ConsumidorNotFoundException  {
		RefeicaoFinder fRefeicao = new RefeicaoFinder();
		RefeicaoGateway gRefeicao = (RefeicaoGateway) fRefeicao.find(this.idRefeicao);
		if( gRefeicao != null ){			
			
				ConsumidorFinder fConsumidor = new ConsumidorFinder();
				ConsumidorGateway gConsumidor = (ConsumidorGateway) fConsumidor.find(this.cpfConsumidor);
				if ( gConsumidor == null ){
					throw new ConsumidorNotFoundException();
				}else{
					
					TicketGateway gTicket = new TicketGateway(0, this.pago, gRefeicao, (IGateway)gConsumidor);
					gTicket.insert();
				}
		}else{
			throw new RefeicaoNotFoundException();
		}
		
	}

}
