package gateway;

import entidades.CPF;
import entidades.Sexo;
import entidades.Titulo;
import persistencia.ConexaoBD;

public class AlunoGateway extends ConsumidorGateway implements IGateway {
	private CursoGateway gCurso;
	
	protected ConexaoBD conexao;
	
	public AlunoGateway( String nome, int matricula, String anoIngresso, Sexo sexo, Titulo titulo, CPF cpf, IGateway curso ) {
		super(nome, matricula, anoIngresso, sexo, titulo, cpf);
		this.gCurso = (CursoGateway) curso;
		
		conexao = new ConexaoBD();
	}
	
	public CursoGateway getCurso(){
		return this.gCurso;
	}
	@Override
	public boolean insert() {
		int res = 0;
		String sql = "INSERT INTO aluno(cpfConsumidor, siglaCurso) "
				+ "VALUES('"+ this.getCpf() +"','"+this.gCurso.getSigla()+"');";
		
		if ( super.insert() == false ) return false;
		
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
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		String sql = "UPDATE Aluno "
				+ "SET siglaCurso='"+this.gCurso.getSigla()+"'"
						+ "WHERE cpfConsumidor='"+ this.getCpf()+"';";
		super.update();
		if ( conexao.abrirConexao() ) {
			conexao.executarCUDQuery(sql);
			
			conexao.fecharConexao();
		}

	}

}
