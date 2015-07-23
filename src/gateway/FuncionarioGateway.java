package gateway;

import entidades.CPF;
import entidades.Sexo;
import entidades.Titulo;
import persistencia.ConexaoBD;

public class FuncionarioGateway extends ConsumidorGateway implements IGateway {
	private DepartamentoGateway gDepartamento;
	
	protected ConexaoBD conexao;
	
	public FuncionarioGateway(String nome, int matricula, String anoIngresso, Sexo sexo, Titulo titulo, CPF cpf, IGateway departamento) {
		super(nome, matricula, anoIngresso, sexo, titulo, cpf);
		this.gDepartamento = (DepartamentoGateway) departamento;
		
		conexao = new ConexaoBD();
	}
	
	public DepartamentoGateway getDepartamento(){
		return gDepartamento;
	}
	
	@Override
	public boolean insert() {	
		int res = 0;
		String sql = "INSERT INTO Funcionario(cpfConsumidor, siglaDepartamento) "
				+ "VALUES('"+ this.getCpf() +"','"+this.gDepartamento.getSigla()+"');";
		
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
		String sql = "UPDATE Funcionario "
				+ "SET siglaDepartamento='"+this.gDepartamento.getSigla()+"'"
						+ "WHERE cpfConsumidor='"+ this.getCpf()+"';";
		super.update();
		if ( conexao.abrirConexao() ) {
			conexao.executarCUDQuery(sql);

			conexao.fecharConexao();
		}

	}

}
