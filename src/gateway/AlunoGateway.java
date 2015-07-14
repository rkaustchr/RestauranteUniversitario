package gateway;

import entidades.CPF;
import entidades.Sexo;
import entidades.Titulo;
import persistencia.ConexaoBD;

public class AlunoGateway extends ConsumidorGateway implements IGateway {
	private CursoGateway gCurso;
	
	protected ConexaoBD conexao;
	
	public AlunoGateway( String nome, int matricula, int anoIngresso, Sexo sexo, Titulo titulo, CPF cpf, IGateway curso ) {
		super(nome, matricula, anoIngresso, sexo, titulo, cpf);
		this.gCurso = (CursoGateway) curso;
		
		conexao = new ConexaoBD();
	}
	
	public CursoGateway getCurso(){
		return this.gCurso;
	}
	@Override
	public void insert() {
		int res;
		
		String sql = "INSERT INTO aluno(cpfConsumidor, siglaCurso)"
				+ "VALUES('"+ this.getCpf() +"','"+this.gCurso.getSigla()+"';";
		
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
		
		String sql = "UPDATE Aluno"
				+ "SET siglaCurso='"+this.gCurso.getSigla()+"'"
						+ "WHERE cpfConsumidor='"+ this.getCpf()+"';";
		
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
