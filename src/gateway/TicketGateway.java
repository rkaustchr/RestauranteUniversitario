package gateway;

import entidades.Consumidor;
import persistencia.ConexaoBD;

public class TicketGateway implements IGateway {
	private int id;
	private boolean pago;
	private RefeicaoGateway refeicao;
	private ConsumidorGateway consumidor;
	
	protected ConexaoBD conexao;
	
	public TicketGateway(int id, boolean pago, RefeicaoGateway refeicao, ConsumidorGateway consumidor) {
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

	public ConsumidorGateway getConsumidor() {
		return consumidor;
	}

	@Override
	public void insert() {
		int res;
		String sql = "INSERT INTO ticket(id, pago, refeicao) "
				+ "VAUES('"+ this.id +"', '"+ this.pago +"', '"+ this.refeicao +"');";
		
		if ( conexao.abrirConexao() ) {
			res = conexao.executarCUDQuery(sql);
			conexao.fecharConexao();
		}
		
	}

	@Override
	public void update() {
		int res;
		String sql = "UPDATE ticket"
				+ "SET pago='"+ this.pago +"', '" + "'refeicao='"+ this.refeicao +"'"
						+ "WHERE sigla='"+ this.id +"';";
		
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
