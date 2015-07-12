package gateway;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Consumidor;
import entidades.Refeicao;
import persistencia.ConexaoBD;

public class TicketFinder implements IFinder {
	
	protected ConexaoBD conexao;

	public TicketFinder(){
		conexao = new ConexaoBD();
	}
	
	@Override
	public ArrayList<IGateway> findAll() {
		ArrayList<IGateway> gTickets = new ArrayList<IGateway>();
		String sql = "SELECT * FROM ticket;";
		
		if (conexao.abrirConexao()) {
			ResultSet rs = conexao.executarSelectQuery(sql);
			
			if ( rs != null ) {
				try {
					while (rs.next()) {
						RefeicaoFinder fRef = new RefeicaoFinder();
						ConsumidorFinder fCons = new ConsumidorFinder();
						RefeicaoGateway gRef = (RefeicaoGateway) fRef.find(rs.getString("refeicao"));
						ConsumidorGateway gCons = (ConsumidorGateway) fCons.find(rs.getString("consumidor"));
						
						gTickets.add(new TicketGateway(rs.getInt("id"), rs.getBoolean("pago"), gRef, gCons));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			conexao.fecharConexao();
		}
		
		return gTickets;
	}

	@Override
	public IGateway find(String id) {
		String sql = "SELECT * FROM ticket"
				+ "WHERE sigla='"+ id +"';";
		IGateway gTicket = null;
		
		if (conexao.abrirConexao()) {
			ResultSet rs = conexao.executarSelectQuery(sql);
			if ( rs != null ) {
				try {
					while (rs.next()) {
						RefeicaoFinder fRef = new RefeicaoFinder();
						ConsumidorFinder fCons = new ConsumidorFinder();
						RefeicaoGateway gRef = (RefeicaoGateway) fRef.find(rs.getString("refeicao"));
						ConsumidorGateway gCons = (ConsumidorGateway) fCons.find(rs.getString("consumidor"));
						
						gTicket = new TicketGateway(rs.getInt("id"), rs.getBoolean("pago"), gRef, gCons);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			conexao.fecharConexao();
		}
			
		return gTicket;
	}

}
