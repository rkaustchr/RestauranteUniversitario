package gateway;

import persistencia.ConexaoBD;

public class CursoGateway implements IGateway {
	private String nome;
	private String sigla;
	private DepartamentoGateway departamento;
	
	protected ConexaoBD conexao;
	
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
		String sql = "INSERT INTO Curso(sigla, nome, siglaDepartamento) "
				+ "VALUES('"+ this.sigla +"', '"+ this.nome +"', '"+ this.departamento.getSigla() +"');";
		
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
		String sql = "UPDATE curso SET nome='"+ this.nome +"', siglaDepartamento='"+ this.departamento.getSigla() +"' "
		+ "WHERE sigla='"+ this.sigla +"';";
		
		if ( conexao.abrirConexao() ) {
			conexao.executarCUDQuery(sql);
			conexao.fecharConexao();
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}