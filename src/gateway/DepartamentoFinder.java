package gateway;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.ConexaoBD;



public class DepartamentoFinder implements IFinder {
	protected ConexaoBD conexao;
	
	public DepartamentoFinder(){
		conexao = new ConexaoBD();
	}
	
	@Override
	public ArrayList<IGateway> findAll() {
		ArrayList<IGateway> gDepartamentos = new ArrayList<IGateway>();
		String sql = "SELECT * FROM departamento;";
		
		if (conexao.abrirConexao()) {
			ResultSet rs = conexao.executarSelectQuery(sql);
			
			if ( rs != null ) {
				try {
					while (rs.next()) {
						gDepartamentos.add( new DepartamentoGateway(rs.getString("nome"), rs.getString("sigla")) );
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			conexao.fecharConexao();
		}
		
		return gDepartamentos;
	}

	@Override
	public IGateway find(String id) {
		String sql = "SELECT * FROM departamento WHERE sigla='"+ id +"';";
		IGateway gDepartamento = null;
		
		if (conexao.abrirConexao()) {
			ResultSet rs = conexao.executarSelectQuery(sql);
			if ( rs != null ) {
				try {
					while (rs.next()) {
						gDepartamento = new DepartamentoGateway(rs.getString("nome"), rs.getString("sigla"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else {
				System.out.println("SQL returna null");
			}
			
			conexao.fecharConexao();
		}
		
		return gDepartamento;
	}
}
