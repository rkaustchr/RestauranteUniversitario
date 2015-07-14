package gateway;

import java.util.ArrayList;

import entidades.Aluno;
import entidades.CPF;
import entidades.Consumidor;
import entidades.Curso;
import entidades.Departamento;
import entidades.Sexo;
import entidades.Titulo;
import persistencia.ConexaoBD;

public class ConsumidorGateway implements IGateway{
	private String nome;
	private int matricula;
	private int anoIngresso;
	private Sexo sexo;
	private Titulo titulo;
	private CPF cpf;
	
	protected ConexaoBD conexao;
	
	
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

	public int getAnoIngresso() {
		return anoIngresso;
	}

	public void setAnoIngresso(int anoIngresso) {
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
	
	public ConsumidorGateway(String nome, int matricula, int anoIngresso) {
		this.nome = nome;
		this.matricula = matricula;
		this.anoIngresso = anoIngresso;
		
		conexao = new ConexaoBD();
	}

	public ConsumidorGateway(String nome, int matricula, int anoIngresso, Sexo sexo, Titulo titulo, CPF cpf) {
		this(nome,matricula,anoIngresso);
		this.sexo = sexo;
		this.titulo = titulo;
		this.cpf = cpf;
	}

	@Override
	public void insert() {
		int res;
		/* cpf varchar(11) PRIMARY KEY, 
		 * nome varchar(255), 
		 * matricula integer, 
		 * anoIngresso date, 
		 * sexo varchar(255), 
		 * titulo varchar(255)*/
		String sql = "INSERT INTO Consumidor("
				+ "cpf, nome, matricula, anoIngresso, sexo, titulo)"
				+ "VALUES('"+ this.cpf +"','"+this.nome+"','"+this.matricula+"'"
						+ ",'"+this.anoIngresso+"','"+this.sexo+"','"+this.titulo+"';";
		
		if ( conexao.abrirConexao() ) {
			res = conexao.executarCUDQuery(sql);
			
			/*if ( res = -1 ) {
				return false;
			} else {
				return true;
			}*/
			conexao.fecharConexao();
		}
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		int res;
		String sql = "UPDATE Consumidor"
				+ "SET nome='"+ this.nome +"',"
						+ "matricula='"+this.matricula+"',"
						+ "anoIngresso='"+this.anoIngresso+"',"
						+ "sexo='"+this.sexo+"',"
						+ "titulo='"+this.titulo+"',"
						+ "WHERE cpf='"+ this.cpf+"';";
		
		if ( conexao.abrirConexao() ) {
			res = conexao.executarCUDQuery(sql);
			
			/*if ( res = -1 ) {
				return false;
			} else {
				return true;
			}*/
			conexao.fecharConexao();
		}
		
	}

}
