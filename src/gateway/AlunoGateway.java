package gateway;

import entidades.Aluno;
import entidades.CPF;
import entidades.Curso;
import entidades.Sexo;
import entidades.Titulo;
import persistencia.ConexaoBD;

public class AlunoGateway extends ConsumidorGateway implements IGateway {
	Curso curso;
	
	protected ConexaoBD conexao;
	
	public AlunoGateway( String nome, int matricula, int anoIngresso, Sexo sexo, Titulo titulo, CPF cpf, Curso curso ) {
		super(nome, matricula, anoIngresso, sexo, titulo, cpf);
		this.curso = curso;
		
		conexao = new ConexaoBD();
	}
	@Override
	public void insert() {
		int res;
		
		String sql = "INSERT INTO aluno(cpfConsumidor, siglaCurso)"
				+ "VALUES('"+ this.getCpf() +"','"+this.curso.getSigla()+"';";
		
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
				+ "SET siglaCurso='"+this.curso.getSigla()+"'"
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
