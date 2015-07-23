package entidades;

import java.io.Serializable;

public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private String sigla;
	private Departamento departamento;

	public Curso(String nome, String sigla, Departamento departamento) {
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
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDepartamento(Departamento departamento){
		this.departamento = departamento;
	}

}
