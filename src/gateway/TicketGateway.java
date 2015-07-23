package gateway;

import persistencia.ConexaoBD;

public class TicketGateway implements IGateway {
	private int id;
	private boolean pago;
	private RefeicaoGateway refeicao;
	private IGateway consumidor;
	
	protected ConexaoBD conexao;
	
	public TicketGateway(int id, boolean pago, RefeicaoGateway refeicao, IGateway consumidor) {
		super();
		this.id = id;
		this.pago = pago;
		this.refeicao = refeicao;
		this.consumidor = consumidor;
		
		conexao = new ConexaoBD();
	}

	public int getId() {
		return id;
	}

	public boolean isPago() {
		return pago;
	}

	public RefeicaoGateway getRefeicao() {
		return refeicao;
	}

	public IGateway getConsumidor() {
		return consumidor;
	}

	@Override
	public boolean insert() {
		int res= 0; 
		String sql = "INSERT INTO ticket(pago, idRefeicao, cpfConsumidor ) "
				+ "VALUES("+ this.pago +", "+ this.refeicao.getId() +", '"+ ( (ConsumidorGateway) this.consumidor).getCpf()+"');";
		
		if ( conexao.abrirConexao() ) {
			res = conexao.executarCUDQuery(sql);
			conexao.fecharConexao();
		}
		
		if ( res == 0 ) {
			System.out.println("SQL: " + sql);
			return false;
		} else {
			return true;
		}
		
	}

	@Override
	public void update() {
		String sql = "UPDATE ticket "
				+ "SET pago="+ this.pago + " WHERE id='"+ this.id +"';";
		
		if ( conexao.abrirConexao() ) {
			conexao.executarCUDQuery(sql);
			conexao.fecharConexao();
		}
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	
}