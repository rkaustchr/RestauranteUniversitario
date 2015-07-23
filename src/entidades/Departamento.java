package entidades;

import java.io.Serializable;

public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private String sigla;
	
	
	public Departamento(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setNome(String nome) {
		// TODO Auto-generated method stub
		this.nome = nome;
	}
	
}
