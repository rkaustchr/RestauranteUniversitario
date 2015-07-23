package gateway;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Turno;
import persistencia.ConexaoBD;

public class RefeicaoFinder implements IFinder {
	
	protected ConexaoBD conexao;
	
	public RefeicaoFinder() {
		conexao = new ConexaoBD();
	}
	
	@Override
	public ArrayList<IGateway> findAll() {
		ArrayList<IGateway> gRefeicoes = new ArrayList<IGateway>();
		String sql = "SELECT * FROM refeicao;";
		
		if (conexao.abrirConexao()) {
			ResultSet rs = conexao.executarSelectQuery(sql);
			
			if ( rs != null ) {
				try {
					while (rs.next()) {
						gRefeicoes.add(new RefeicaoGateway(rs.getString("id"), rs.getString("descricao"), Turno.valueOf(rs.getString("turno")), rs.getString("opcaoVegan")));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			conexao.fecharConexao();
		}
		
		return gRefeicoes;
	}

	@Override
	public IGateway find(String id) {
		String sql = "SELECT * FROM refeicao WHERE id='"+ id +"';";
		IGateway gRefeicao = null;
		
		if (conexao.abrirConexao()) {
			ResultSet rs = conexao.executarSelectQuery(sql);
			if ( rs != null ) {
				try {
					while (rs.next()) {
						gRefeicao = new RefeicaoGateway(rs.getString("id"), rs.getString("descricao"), Turno.valueOf(rs.getString("turno")), rs.getString("opcaoVegan"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			conexao.fecharConexao();
		}
			
		return gRefeicao;
	}
}