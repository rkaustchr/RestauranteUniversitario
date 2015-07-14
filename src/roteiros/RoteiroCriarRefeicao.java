package roteiros;

import entidades.Turno;
import gateway.RefeicaoGateway;

public class RoteiroCriarRefeicao {
	private String descricao;
	private Turno turno;
	private String opcaoVegan;
	
	public RoteiroCriarRefeicao(String descricao, String turno, String opcaoVegan) {
		this.descricao = descricao;
		this.turno = Turno.valueOf(turno);
		this.opcaoVegan = opcaoVegan;
	}
	
	public void executar() {
		
		RefeicaoGateway gRefeicao = new RefeicaoGateway(null, descricao, turno, opcaoVegan);
		gRefeicao.insert();
		
	}

}
