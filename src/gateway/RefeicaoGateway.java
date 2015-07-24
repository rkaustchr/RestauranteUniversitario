package gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entidades.Turno;
import persistencia.ConexaoBD;

public class RefeicaoGateway implements IGateway {
	private String id;
	private String descricao;
	private String opcaoVegan;
	private Turno turno;
	
	protected ConexaoBD conexao;
	protected Connection con;
	
	public RefeicaoGateway(String id, String descricao, Turno turno, String opcaoVegan) {
		super();
		this.id = id;
		this.turno = turno;
		this.descricao = descricao;
		this.opcaoVegan = opcaoVegan;
		
		conexao = new ConexaoBD();
	}
	
	public String getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getOpcaoVegan() {
		return opcaoVegan;
	}

	public Turno getTurno() {
		return turno;
	}

	@Override
	public boolean insert() {
		int res = 0;
		String sql = "INSERT INTO refeicao(turno, descricao, opcaoVegan) VALUES(?, ?, ?);";

		con = conexao.abrirConexao();
		if ( con != null ) {
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, this.turno.toString());
				stmt.setString(2, this.descricao);
				stmt.setString(3, this.opcaoVegan);
				
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
		String sql = "UPDATE refeicao SET descricao=?, opcaoVegan=? WHERE id=?;";
		int res = 0;
	
		con = conexao.abrirConexao();
		if ( con != null ) {
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, this.descricao);
				stmt.setString(2, this.opcaoVegan);
				stmt.setInt(3, Integer.parseInt(this.id) );
				
				res = stmt.executeUpdate();
			} catch (Exception e) {
				res = 0;
				System.out.println("ERRO: Update Refeicao");
			}
		}
		
	}

	@Override
	public void delete() {
		

	}
}
