package gateway;

import entidades.CPF;
import entidades.Departamento;
import entidades.Sexo;
import entidades.Titulo;
import persistencia.ConexaoBD;

public class FuncionarioGateway extends ConsumidorGateway implements IGateway {
	private DepartamentoGateway gDepartamento;
	
	protected ConexaoBD conexao;
	
	public FuncionarioGateway(String nome, int matricula, int anoIngresso, Sexo sexo, Titulo titulo, CPF cpf, IGateway departamento) {
		super(nome, matricula, anoIngresso, sexo, titulo, cpf);
		this.gDepartamento = (DepartamentoGateway) departamento;
		
		conexao = new ConexaoBD();
	}
	
	
	
	@Override
	public void insert() {
		int res;
		
		String sql = "INSERT INTO Funcionario(cpfConsumidor, siglaDepartamento)"
				+ "VALUES('"+ this.getCpf() +"','"+this.gDepartamento.getSigla()+"';";
		
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
		
		String sql = "UPDATE Funcionario"
				+ "SET siglaDepartamento='"+this.gDepartamento.getSigla()+"'"
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
