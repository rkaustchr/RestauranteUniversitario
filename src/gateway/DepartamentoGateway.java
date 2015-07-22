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
	public boolean insert() {
		int res = 0;
		String sql = "INSERT INTO departamento(sigla, nome) "
				+ "VALUES('"+ this.sigla +"', '"+ this.nome +"');";
		
		if ( conexao.abrirConexao() ) {
			conexao.executarCUDQuery(sql);

			conexao.fecharConexao();
		} else {
			System.out.println("Erro: Não foi possivel abrir a conexão!");
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
		String sql = "UPDATE departamento SET nome='"+ this.nome +"' WHERE sigla='"+ this.sigla +"';";
		
		if ( conexao.abrirConexao() ) {
			res = conexao.executarCUDQuery(sql);
			
			/*if ( res = -1 ) {
				return false;
			} else {
				return true;
			}*/
			conexao.fecharConexao();
		} else {
			System.out.println("Erro: Não foi possivel abrir a conexão!");
		}
		
	}
	
	@Override
	public void delete() {
		// TODO Auto-generated method stub
	}

}
