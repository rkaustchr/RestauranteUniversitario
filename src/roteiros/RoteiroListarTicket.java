package roteiros;

import java.util.ArrayList;
import entidades.Aluno;
import entidades.Consumidor;
import entidades.Curso;
import entidades.Departamento;
import entidades.Funcionario;
import entidades.Refeicao;
import entidades.Ticket;
import gateway.AlunoGateway;
import gateway.FuncionarioGateway;
import gateway.IGateway;
import gateway.RefeicaoGateway;
import gateway.TicketFinder;
import gateway.TicketGateway;

public class RoteiroListarTicket {
	public RoteiroListarTicket() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Ticket> executar() throws Exception {
		TicketFinder fTicket = new TicketFinder();
		ArrayList<Ticket> retorno = new ArrayList<Ticket>();
		
		for (IGateway gTicket : fTicket.findAll()) {
			RefeicaoGateway gRefeicao = ((TicketGateway) gTicket).getRefeicao();
			Refeicao refeicao = new Refeicao(gRefeicao.getId(), gRefeicao.getDescricao(), gRefeicao.getTurno(), gRefeicao.getOpcaoVegan());
			
			IGateway gConsumidor = ((TicketGateway) gTicket).getConsumidor();
			Consumidor consumidor;
			try {
				if ( ((AlunoGateway) gConsumidor).getCurso() != null ) {
				}
				consumidor = new Aluno(((AlunoGateway) gConsumidor).getNome(), ((AlunoGateway) gConsumidor).getMatricula(), ((AlunoGateway) gConsumidor).getAnoIngresso(), ((AlunoGateway) gConsumidor).getSexo(), ((AlunoGateway) gConsumidor).getTitulo(), ((AlunoGateway) gConsumidor).getCpf(),  new Curso(((AlunoGateway) gConsumidor).getCurso().getNome(), ((AlunoGateway) gConsumidor).getCurso().getSigla(), new Departamento(((AlunoGateway) gConsumidor).getCurso().getDepartamento().getNome(), ((AlunoGateway) gConsumidor).getCurso().getDepartamento().getSigla())) );
				
			} catch (Exception e) {
																																																																										
				consumidor = new Funcionario(((FuncionarioGateway) gConsumidor).getNome(), ((FuncionarioGateway) gConsumidor).getMatricula(), ((FuncionarioGateway) gConsumidor).getAnoIngresso(), ((FuncionarioGateway) gConsumidor).getSexo(), ((FuncionarioGateway) gConsumidor).getTitulo(), ((FuncionarioGateway) gConsumidor).getCpf(), new Departamento(((FuncionarioGateway) gConsumidor).getDepartamento().getNome(), ((FuncionarioGateway) gConsumidor).getDepartamento().getSigla()));
			}

			retorno.add( new Ticket( ((TicketGateway) gTicket).getId(), refeicao, ((TicketGateway) gTicket).isPago(), consumidor) );
		}
		
		return retorno;		
	}

}
