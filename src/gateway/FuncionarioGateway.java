package gateway;

import entidades.CPF;
import entidades.Departamento;
import entidades.Sexo;
import entidades.Titulo;

public class FuncionarioGateway extends ConsumidorGateway implements IGateway {
	private Departamento departamento;
	
	public FuncionarioGateway(String nome, int matricula, int anoIngresso, Departamento departamento) {
		super(nome, matricula, anoIngresso);
		this.departamento = departamento;
	}
		   
	public FuncionarioGateway(String nome, int matricula, int anoIngresso, Sexo sexo, Titulo titulo, CPF cpf, Departamento departamento) {
		super(nome, matricula, anoIngresso, sexo, titulo, cpf);
		this.departamento = departamento;
	}
	
	@Override
	public void insert() {
		int res;
		
		String sql = "INSERT INTO Funcionario(cpfConsumidor, siglaDepartamento)"
				+ "VALUES('"+ this.getCpf() +"','"+this.departamento.getSigla()+"';";
		
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
				+ "SET siglaDepartamento='"+this.departamento.getSigla()+"'"
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
