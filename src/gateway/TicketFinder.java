package gateway;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
						RefeicaoGateway gRef = (RefeicaoGateway) fRef.find(rs.getString("idRefeicao"));
						
						IFinder fCons =  new AlunoFinder();
						IGateway gCons = fCons.find(rs.getString("cpfConsumidor"));
						if ( gCons == null ) {
							fCons =  new FuncionarioFinder();
							gCons = fCons.find(rs.getString("cpfConsumidor"));
						}
						
						gTickets.add(new TicketGateway(rs.getInt("idRefeicao"), rs.getBoolean("pago"), gRef, gCons));
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
		String sql = "SELECT * FROM ticket WHERE idRefeicao='"+ id +"';";
		IGateway gTicket = null;
		
		if (conexao.abrirConexao()) {
			ResultSet rs = conexao.executarSelectQuery(sql);
			if ( rs != null ) {
				try {
					while (rs.next()) {
						RefeicaoFinder fRef = new RefeicaoFinder();
						RefeicaoGateway gRef = (RefeicaoGateway) fRef.find(id); // fRef.find(rs.getString("idRefeicao"));
						
						IFinder fCons =  new AlunoFinder();
						IGateway gCons = fCons.find(rs.getString("cpfConsumidor"));
						if ( gCons == null ) {
							fCons =  new FuncionarioFinder();
							gCons = fCons.find(rs.getString("cpfConsumidor"));
						}
						
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
