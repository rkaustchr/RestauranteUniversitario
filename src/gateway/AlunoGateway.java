package gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidades.CPF;
import entidades.Sexo;
import entidades.Titulo;
import persistencia.ConexaoBD;

public class AlunoGateway extends ConsumidorGateway implements IGateway {
	private CursoGateway gCurso;
	
	protected ConexaoBD conexao;
	protected Connection con;
	
	public AlunoGateway( String nome, int matricula, String anoIngresso, Sexo sexo, Titulo titulo, CPF cpf, IGateway curso ) {
		super(nome, matricula, anoIngresso, sexo, titulo, cpf);
		this.gCurso = (CursoGateway) curso;
		
		conexao = new ConexaoBD();
	}
	
	public CursoGateway getCurso(){
		return this.gCurso;
	}
	@Override
	public boolean insert() {
		int res = 0;
		String sql = "INSERT INTO aluno(cpfConsumidor, siglaCurso) VALUES(?,?); ";
				//+ "VALUES('"+ this.getCpf() +"','"+this.gCurso.getSigla()+"');";
		
		if ( super.insert() == false ) return false;
		
		con = conexao.abrirConexao();
		if ( con != null ) {
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, this.getCpf().toString());
				stmt.setString(2, this.gCurso.getSigla());
				
				res = stmt.executeUpdate();
			} catch (SQLException e) {
				res = 0;
			}
			
			conexao.fecharConexao();
		}
		
		if ( res == 0 ) {
			System.out.println("SQL: " + sql);
			return false;
		} else {
			return true;
		}

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		int res = 0;
		String sql = "UPDATE Aluno SET siglaCurso= ? WHERE cpfConsumidor= ?;";
		super.update();
		
		con = conexao.abrirConexao();
		if ( con != null ) {
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, this.gCurso.getSigla());
				stmt.setString(2, this.getCpf().toString());
				
				res = stmt.executeUpdate();
			} catch (Exception e) {
				res = 0;
			}
		}
		
		conexao.fecharConexao();
		
		if ( res == 0 ) {
			System.out.println("SQL: " + sql);
			//return false;
		} else {
			//return true;
		}

	}

}
