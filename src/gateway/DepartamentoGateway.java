package gateway;

import persistencia.ConexaoBD;

public class DepartamentoGateway implements IGateway{
	private String nome;
	private String sigla;
	
	protected ConexaoBD conexao;

	public DepartamentoGateway(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
		
		conexao = new ConexaoBD();
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	@Override
	public void insert() {
		int res;
		String sql = "INSERT INTO departamento(sigla, nome) "
				+ "VAUES('"+ this.sigla +"', '"+ this.nome +"');";
		
		if ( conexao.abrirConexao() ) {
			res = conexao.executarCUDQuery(sql);
			
			/*if ( res = -1 ) {
				return false;
			} else {
				return true;
			}*/
		}
		
	}

	@Override
	public void update() {
		int res;
		String sql = "UPDATE departamento"
				+ "SET nome='"+ this.nome +"'"
						+ "WHERE sigla='"+ this.sigla +"';";
		
		if ( conexao.abrirConexao() ) {
			res = conexao.executarCUDQuery(sql);
			
			/*if ( res = -1 ) {
				return false;
			} else {
				return true;
			}*/
		}
		
	}
	
	@Override
	public void delete() {
		// TODO Auto-generated method stub
	}

}
