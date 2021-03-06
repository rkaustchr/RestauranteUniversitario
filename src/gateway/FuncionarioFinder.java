package gateway;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.CPF;
import entidades.Sexo;
import entidades.Titulo;
import persistencia.ConexaoBD;

public class FuncionarioFinder implements IFinder {
	protected ConexaoBD conexao;
	protected Connection con;
	
	public FuncionarioFinder() {
		conexao = new ConexaoBD();
	}
	
	@Override
	public ArrayList<IGateway> findAll() {
		ArrayList<IGateway> gFuncionarios = new ArrayList<IGateway>();
		String sql = "SELECT * FROM Funcionario, Consumidor where cpf = cpfConsumidor;";
		
		con = conexao.abrirConexao();
		if ( con != null ) {
			ResultSet rs = conexao.executarSelectQuery(sql);
			
			if ( rs != null ) {
				try {
					while (rs.next()) {
						DepartamentoFinder gDepartamento = new DepartamentoFinder();
						gFuncionarios.add( 
								new FuncionarioGateway(
										rs.getString("nome"), 
										rs.getInt("matricula"), 
										rs.getString("anoIngresso"), 
										Sexo.valueOf(rs.getString("sexo")), 
										Titulo.valueOf(rs.getString("titulo")),
										new CPF(rs.getString("cpf")),
										gDepartamento.find(rs.getString("siglaDepartamento"))
									) 
								);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			conexao.fecharConexao();
		}
		
		return gFuncionarios;
	}

	@Override
	public IGateway find(String id) {
		String sql = "SELECT * FROM Funcionario, Consumidor WHERE cpf='"+ id +"' AND cpf = cpfConsumidor;";
		IGateway gFuncionario = null; // new FuncionarioGateway("", 0, "", null, null, null, null);

		con = conexao.abrirConexao();
		if ( con != null ) {
			ResultSet rs = conexao.executarSelectQuery(sql);
			if ( rs != null ) {
				try {
					while (rs.next()) {
						DepartamentoFinder gDepartamento = new DepartamentoFinder();
						gFuncionario = new FuncionarioGateway(
								rs.getString("nome"), 
								rs.getInt("matricula"), 
								rs.getString("anoIngresso"), 
								Sexo.valueOf(rs.getString("sexo")), 
								Titulo.valueOf(rs.getString("titulo")),
								new CPF(rs.getString("cpf")),
								gDepartamento.find(rs.getString("siglaDepartamento"))
								);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			conexao.fecharConexao();
		}
			
		return gFuncionario;
	}

}
