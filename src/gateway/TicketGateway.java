package gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;

import persistencia.ConexaoBD;

public class TicketGateway implements IGateway {
	private int id;
	private boolean pago;
	private RefeicaoGateway refeicao;
	private IGateway consumidor;
	
	protected ConexaoBD conexao;
	protected Connection con;
	
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
		String sql = "INSERT INTO ticket(pago, idRefeicao, cpfConsumidor ) VALUES(?, ?, ?);";
		
		con = conexao.abrirConexao();
		if ( con != null ) {
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setBoolean(1, this.pago);
				stmt.setInt(2, Integer.parseInt( this.refeicao.getId()) );
				stmt.setString(3, ( (ConsumidorGateway) this.consumidor).getCpf().toString());
				
				
				res = stmt.executeUpdate();
			} catch (Exception e) {
				res = 0;
			}
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
		String sql = "UPDATE ticket SET pago=? WHERE id=?;";
		int res = 0;
		
		con = conexao.abrirConexao();
		if ( con != null ) {
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setBoolean(1, this.pago);
				stmt.setInt(2, this.id );
				
				res = stmt.executeUpdate();
			} catch (Exception e) {
				res = 0;
			}
		}
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	
}
