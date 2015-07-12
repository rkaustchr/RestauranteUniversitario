package gateway;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.ConexaoBD;

public class CursoFinder implements IFinder {
	protected ConexaoBD conexao;

	public CursoFinder(){
		conexao = new ConexaoBD();
	}
	@Override
	public ArrayList<IGateway> findAll() {
		ArrayList<IGateway> gCursos = new ArrayList<IGateway>();
		String sql = "SELECT * FROM curso;";
		
		if (conexao.abrirConexao()) {
			ResultSet rs = conexao.executarSelectQuery(sql);
			
			if ( rs != null ) {
				try {
					while (rs.next()) {
						DepartamentoFinder fDept = new DepartamentoFinder();
						DepartamentoGateway gDept = (DepartamentoGateway) fDept.find(rs.getString("departamento"));
						
						gCursos.add( new CursoGateway(rs.getString("nome"), rs.getString("sigla"), gDept) );
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			conexao.fecharConexao();
		}
		
		return gCursos;
	}

	@Override
	public IGateway find(String id) {
		String sql = "SELECT * FROM curso"
				+ "WHERE sigla='"+ id +"';";
		IGateway gCurso = null;
		
		if (conexao.abrirConexao()) {
			ResultSet rs = conexao.executarSelectQuery(sql);
			if ( rs != null ) {
				try {
					while (rs.next()) {
						DepartamentoFinder fDept = new DepartamentoFinder();
						DepartamentoGateway gDept = (DepartamentoGateway) fDept.find(rs.getString("departamento"));
						
						gCurso = new CursoGateway(rs.getString("nome"), rs.getString("sigla"), gDept);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			conexao.fecharConexao();
		}
			
		return gCurso;
	}

}
