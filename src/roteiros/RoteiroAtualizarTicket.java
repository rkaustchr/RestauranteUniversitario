package roteiros;

import controladores.exceptions.TicketNotFound;
import gateway.TicketGateway;

public class RoteiroAtualizarTicket {
	private int id;
	private boolean pago;
	
	public RoteiroAtualizarTicket(int id, boolean pago) {
		this.id = id;
		this.pago = pago;
	}

	public void executar() throws TicketNotFound {
		TicketGateway gTicket = new TicketGateway(this.id, this.pago, null, null);
		gTicket.update();
		
	}

}
