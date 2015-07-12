package gateway;

import entidades.Turno;
import persistencia.ConexaoBD;

public class RefeicaoGateway implements IGateway {
	private int id;
	private String descricao;
	private String opcaoVegan;
	private String turno;
	
	protected ConexaoBD conexao;
	
	public RefeicaoGateway(int id, String descricao, String opcaoVegan, String turno) {
		super();
		this.id = id;
		this.turno = turno;
		this.descricao = descricao;
		this.opcaoVegan = opcaoVegan;
		
		conexao = new ConexaoBD();
	}
	
	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getOpcaoVegan() {
		return opcaoVegan;
	}

	public String getTurno() {
		return turno;
	}

	@Override
	public void insert() {
		int res;
		String sql = "INSERT INTO refeicao(turno, descricao, opcaVegan) "
				+ "VAUES('"+ this.turno +"', '"+ this.descricao +"', '"+ this.opcaoVegan +"');";
		
		if ( conexao.abrirConexao() ) {
			res = conexao.executarCUDQuery(sql);
			conexao.fecharConexao();
		}
		
	}

	@Override
	public void update() {
		int res;
		String sql = "UPDATE refeicao"
				+ "SET descricao='"+ this.descricao +"', '" + "'opcaoVegan='"+ this.opcaoVegan +"'"
						+ "WHERE id='"+ this.id +"';";
		
		if ( conexao.abrirConexao() ) {
			res = conexao.executarCUDQuery(sql);
			conexao.fecharConexao();
		}
		
	}	// TODO Auto-generated method stub

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}
}
