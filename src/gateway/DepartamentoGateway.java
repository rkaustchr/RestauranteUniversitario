package gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;

import persistencia.ConexaoBD;

public class DepartamentoGateway implements IGateway{
	private String nome;
	private String sigla;
	
	protected ConexaoBD conexao;
	protected Connection con;

	public DepartamentoGateway(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
		
		conexao = new ConexaoBD();
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	@Override
	public boolean insert() {
		int res = 0;
		String sql = "INSERT INTO departamento(sigla, nome) VALUES(?, ?);";
		
		con = conexao.abrirConexao();
		if ( con != null ) {
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, this.sigla);
				stmt.setString(2, this.nome);
				
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
		String sql = "UPDATE departamento SET nome=? WHERE sigla=?;";
		int res = 0;
		
		con = conexao.abrirConexao();
		if ( con != null ) {
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, this.nome);
				stmt.setString(2, this.sigla);
				
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
