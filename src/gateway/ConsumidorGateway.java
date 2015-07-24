package gateway;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entidades.CPF;
import entidades.Sexo;
import entidades.Titulo;
import persistencia.ConexaoBD;

public class ConsumidorGateway implements IGateway{
	private String nome;
	private int matricula;
	private String anoIngresso;
	private Sexo sexo;
	private Titulo titulo;
	private CPF cpf;
	
	protected ConexaoBD conexao;
	protected Connection con;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getAnoIngresso() {
		return anoIngresso;
	}

	public void setAnoIngresso(String anoIngresso) {
		this.anoIngresso = anoIngresso;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public CPF getCpf() {
		return cpf;
	}
	
	public ConsumidorGateway() {
		
	}
	
	public ConsumidorGateway(String nome, int matricula, String anoIngresso) {
		this.nome = nome;
		this.matricula = matricula;
		this.anoIngresso = anoIngresso;
		
		conexao = new ConexaoBD();
	}

	public ConsumidorGateway(String nome, int matricula, String anoIngresso, Sexo sexo, Titulo titulo, CPF cpf) {
		this(nome,matricula,anoIngresso);
		this.sexo = sexo;
		this.titulo = titulo;
		this.cpf = cpf;
	}

	@Override
	public boolean insert()  {
		int res = 0;
		String sql = "INSERT INTO Consumidor(cpf, nome, matricula, anoIngresso, sexo, titulo) VALUES(?,?,?,?,?,?);";
				// + "VALUES('"+ this.cpf +"','"+this.nome+"','"+this.matricula+"'"
				//		+ ",'"+this.anoIngresso+"','"+this.sexo+"','"+this.titulo+"');";
		
		con = conexao.abrirConexao();
		if ( con != null ) {
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, this.cpf.toString());
				stmt.setString(2, this.nome);
				stmt.setInt(3, this.matricula);
				stmt.setString(4, this.anoIngresso);
				stmt.setString(5, this.sexo.toString());
				stmt.setString(6, this.titulo.toString());
				
				res = stmt.executeUpdate();
			} catch ( Exception e ) {
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
		String sql = "UPDATE Consumidor SET nome=?, matricula=?, anoIngresso=?, sexo=? WHERE cpf=?;";
		int res = 0;
		
		con = conexao.abrirConexao();
		if ( con != null ) {
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, this.nome);
				stmt.setInt(2, this.matricula);
				stmt.setString(3, this.anoIngresso);
				stmt.setString(4, this.sexo.toString());
				stmt.setString(5, this.cpf.toString());
				
				res = stmt.executeUpdate();
			} catch (Exception e) {
				res = 0;
			}
		}
		
	}

}
