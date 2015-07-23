package controladores.exceptions;

import entidades.CPF;

public class CpfAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	private CPF cpf;

	public CpfAlreadyExistsException(CPF cpf) {
		this.cpf = cpf;
	}
	
	public CPF getCPF() {
		return cpf;
	}

}
