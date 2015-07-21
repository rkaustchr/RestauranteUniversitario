package roteiros;

import controladores.exceptions.TicketNotFound;
import entidades.Aluno;
import entidades.Refeicao;
import entidades.Ticket;
import gateway.TicketFinder;
import gateway.TicketGateway;
import gateway.ConsumidorGateway;

public class RoteiroVerTicket {
	private String id;
	
	public RoteiroVerTicket(String id) {
		this.id = id;
	}

	public Ticket executar() throws TicketNotFound{
		TicketFinder fTicket = new TicketFinder();
		Ticket retorno;
		TicketGateway gTicket = (TicketGateway) fTicket.find(id);
		if ( gTicket == null )  throw new TicketNotFound();
		retorno = new Ticket( gTicket.getId(), new Refeicao(gTicket.getRefeicao().getId(), gTicket.getRefeicao().getDescricao(), gTicket.getRefeicao().getTurno(), gTicket.getRefeicao().getOpcaoVegan() ), gTicket.isPago(), new Aluno( ((ConsumidorGateway) gTicket.getConsumidor()).getNome(), ((ConsumidorGateway) gTicket.getConsumidor()).getMatricula(), ((ConsumidorGateway) gTicket.getConsumidor()).getAnoIngresso(), ((ConsumidorGateway) gTicket.getConsumidor()).getSexo(), ((ConsumidorGateway) gTicket.getConsumidor()).getTitulo(), ((ConsumidorGateway) gTicket.getConsumidor()).getCpf(), null));
		
		return retorno;
	}

}
