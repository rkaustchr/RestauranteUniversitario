package gateway;

public class CursoGateway implements IGateway {
	private String nome;
	private String sigla;
	private DepartamentoGateway departamento;
	
	public CursoGateway(String nome, String sigla, DepartamentoGateway departamento) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.departamento = departamento;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
