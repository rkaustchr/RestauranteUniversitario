package entidades;

public class Refeicao {
	private int id;
	private String descricao;
	private Turno turno;
	private String opcaoVegan;
	
	public Refeicao( int id,String descricao, Turno turno, String opcaoVegan) {
		this.id = id;
		this.descricao = descricao;
		this.turno = turno;
		this.opcaoVegan = opcaoVegan;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public String getOpcaoVegan() {
		return opcaoVegan;
	}

	public void setOpcaoVegan(String opcaoVegan) {
		this.opcaoVegan = opcaoVegan;
	}

}
