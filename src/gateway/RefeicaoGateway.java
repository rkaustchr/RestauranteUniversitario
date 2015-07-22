package gateway;

import entidades.Turno;
import persistencia.ConexaoBD;

public class RefeicaoGateway implements IGateway {
	private String id;
	private String descricao;
	private String opcaoVegan;
	private Turno turno;
	
	protected ConexaoBD conexao;
	
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
		String sql = "INSERT INTO refeicao(turno, descricao, opcaoVegan) "
				+ "VALUES('"+ this.turno.toString() +"', '"+ this.descricao +"', '"+ this.opcaoVegan +"');";

		if ( conexao.abrirConexao() ) {
			res = conexao.executarCUDQuery(sql);
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
	public void update() {
		int res;
		String sql = "UPDATE refeicao "
				+ "SET descricao='"+ this.descricao +"', opcaoVegan='"+ this.opcaoVegan +"' "
						+ "WHERE id='"+ this.id +"';";
		
		if ( conexao.abrirConexao() ) {
			res = conexao.executarCUDQuery(sql);
			conexao.fecharConexao();
		}
		
	}

	@Override
	public void delete() {
		

	}
}
