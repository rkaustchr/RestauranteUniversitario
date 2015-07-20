package gateway;

import entidades.CPF;
import entidades.Departamento;
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
	public void insert() {		
		String sql = "INSERT INTO Funcionario(cpfConsumidor, siglaDepartamento) "
				+ "VALUES('"+ this.getCpf() +"','"+this.gDepartamento.getSigla()+"');";
		
		super.insert();
		if ( conexao.abrirConexao() ) {
			conexao.executarCUDQuery(sql);
			
			conexao.fecharConexao();
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		String sql = "UPDATE Funcionario"
				+ "SET siglaDepartamento='"+this.gDepartamento.getSigla()+"'"
						+ "WHERE cpfConsumidor='"+ this.getCpf()+"';";
		
		if ( conexao.abrirConexao() ) {
			conexao.executarCUDQuery(sql);
	
			conexao.fecharConexao();
		}

	}

}
