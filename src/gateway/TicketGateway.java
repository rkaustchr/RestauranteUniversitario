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
	public void insert() {
		int res; 
		String sql = "INSERT INTO ticket(pago, idRefeicao, cpfConsumidor ) "
				+ "VALUES("+ this.pago +", "+ this.refeicao.getId() +", '"+ ( (ConsumidorGateway) this.consumidor).getCpf()+"');";
		
		if ( conexao.abrirConexao() ) {
			res = conexao.executarCUDQuery(sql);
			conexao.fecharConexao();
		}
		
	}

	@Override
	public void update() {
		int res;
		String sql = "UPDATE ticket "
				+ "SET pago='"+ this.pago +"','refeicao='"+ this.refeicao +"' "
						+ "WHERE id='"+ this.id +"';";
		
		if ( conexao.abrirConexao() ) {
			res = conexao.executarCUDQuery(sql);
			conexao.fecharConexao();
		}
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	
}
