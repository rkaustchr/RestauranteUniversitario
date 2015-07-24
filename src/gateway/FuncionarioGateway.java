package gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entidades.CPF;
import entidades.Sexo;
import entidades.Titulo;
import persistencia.ConexaoBD;

public class FuncionarioGateway extends ConsumidorGateway implements IGateway {
	private DepartamentoGateway gDepartamento;
	
	protected ConexaoBD conexao;
	protected Connection con;
	
	public FuncionarioGateway(String nome, int matricula, String anoIngresso, Sexo sexo, Titulo titulo, CPF cpf, IGateway departamento) {
		super(nome, matricula, anoIngresso, sexo, titulo, cpf);
		this.gDepartamento = (DepartamentoGateway) departamento;
		
		conexao = new ConexaoBD();
	}
	
	public DepartamentoGateway getDepartamento(){
		return gDepartamento;
	}
	
	@Override
	public boolean insert() {	
		int res = 0;
		String sql = "INSERT INTO Funcionario(cpfConsumidor, siglaDepartamento) VALUES(?, ?);";
		
		if ( super.insert() == false ) return false;
		
		con = conexao.abrirConexao();
		if ( con != null ) {
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, this.getCpf().toString());
				stmt.setString(2, this.getDepartamento().getSigla());
				
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
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		String sql = "UPDATE Funcionario SET siglaDepartamento=? WHERE cpfConsumidor=?;";
		int res = 0;
		super.update();
		
		con = conexao.abrirConexao();
		if ( con != null ) {
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, this.getDepartamento().getSigla());
				stmt.setString(2, this.getCpf().toString());
				
				res = stmt.executeUpdate();
			} catch (Exception e) {
				res = 0;
			}
		}

	}

}
