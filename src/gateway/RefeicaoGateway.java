package gateway;

import entidades.Turno;

public class RefeicaoGateway implements IGateway {
	private int id;
	private String descricao;
	private String opcaoVegan;
	private Turno turno;
	
	public RefeicaoGateway(int id, String descricao, String opcaoVegan, Turno turno) {
		super();
		this.id = id;
		this.turno = turno;
		this.descricao = descricao;
		this.opcaoVegan = opcaoVegan;
	}
	
	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getOpcaoVegan() {
		return opcaoVegan;
	}

	public Turno getTurno() {
		return turno;
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
