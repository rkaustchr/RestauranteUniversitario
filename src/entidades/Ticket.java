package entidades;

public class Ticket {
	private int id;
	private Refeicao refeicao;
	private boolean pago;
	private Consumidor consumidor;
	
	public Ticket(int id, Refeicao refeicao, boolean pago, Consumidor consumidor) {
		this.id = id;
		this.refeicao = refeicao;
		this.pago = pago;
		this.consumidor = consumidor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public Consumidor getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}
	

}
