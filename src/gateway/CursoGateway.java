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
	public void insert() {
		int res;
		String sql = "INSERT INTO Curso(sigla, nome, departamento) "
				+ "VAUES('"+ this.sigla +"', '"+ this.nome +"', '"+ this.departamento +"');";
		
		if ( conexao.abrirConexao() ) {
			res = conexao.executarCUDQuery(sql);
			conexao.fecharConexao();
		}
		
	}

	@Override
	public void update() {
		int res;
		String sql = "UPDATE Curso"
				+ "SET nome='"+ this.nome +"', '" + "'departamento='"+ this.departamento +"'"
						+ "WHERE sigla='"+ this.sigla +"';";
		
		if ( conexao.abrirConexao() ) {
			res = conexao.executarCUDQuery(sql);
			conexao.fecharConexao();
		}
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
