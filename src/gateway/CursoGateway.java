package gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;

import persistencia.ConexaoBD;

public class CursoGateway implements IGateway {
	private String nome;
	private String sigla;
	private DepartamentoGateway departamento;
	
	protected ConexaoBD conexao;
	protected Connection con;
	
	public CursoGateway(String nome, String sigla, DepartamentoGateway departamento) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.departamento = departamento;
		
		conexao = new ConexaoBD();
	}
	
	public String getNome() {
		return nome;
	}
	public String getSigla() {
		return sigla;
	}
	public DepartamentoGateway getDepartamento(){
		return departamento;
	}
	
	@Override
	public boolean insert() {
		int res = 0;
		String sql = "INSERT INTO Curso(sigla, nome, siglaDepartamento) VALUES(?, ?, ?);";
		
		con = conexao.abrirConexao();
		if ( con != null ) {
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, this.sigla);
				stmt.setString(2, this.nome);
				stmt.setString(3, this.departamento.getSigla());
				
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
		String sql = "UPDATE curso SET nome=?, siglaDepartamento=? WHERE sigla=?;";
		int res = 0;
		
		con = conexao.abrirConexao();
		if ( con != null ) {
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, this.nome);
				stmt.setString(2, this.departamento.getSigla());
				stmt.setString(3, this.sigla);
				
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
