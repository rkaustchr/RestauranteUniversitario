package entidades;

public class Funcionario extends Consumidor{
	private Departamento departamento;

	public Funcionario(String nome, int matricula, String anoIngresso, Departamento departamento) {
		super(nome, matricula, anoIngresso);
		this.departamento = departamento;
	}

	public Funcionario(String nome, int matricula, String anoIngresso, Sexo sexo, Titulo titulo, CPF cpf, Departamento departamento) {
		super(nome, matricula, anoIngresso, sexo, titulo, cpf);
		this.departamento = departamento;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
}
