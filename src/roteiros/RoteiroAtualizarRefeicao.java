package roteiros;


import controladores.ccu.exceptions.RefeicaoNotFound;
import entidades.Refeicao;
import entidades.Turno;
import gateway.RefeicaoGateway;

public class RoteiroAtualizarRefeicao {
	private String id;
	private String descricao;
	private String opcaoVegan;
	private Turno turno;

	public RoteiroAtualizarRefeicao(String id, String descricao, String opcaoVegan, String turno) {
		this.id = id;
		this.descricao = descricao;
		this.opcaoVegan = opcaoVegan;
		this.turno = Turno.valueOf(turno);
	}

	public Refeicao executar() throws RefeicaoNotFound {
		RefeicaoGateway gRefeicao = new RefeicaoGateway(this.id, this.descricao, this.turno, this.opcaoVegan);
		if ( gRefeicao == null ) throw new RefeicaoNotFound();
		
		gRefeicao.update();

		return new Refeicao(gRefeicao.getId(), gRefeicao.getDescricao(), gRefeicao.getTurno(), gRefeicao.getOpcaoVegan());
	}

}
