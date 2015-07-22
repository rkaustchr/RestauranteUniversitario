package controladores.exceptions;

import entidades.CPF;

public class CpfAlreadyExistsException extends Exception {
	
	private CPF cpf;

	public CpfAlreadyExistsException(CPF cpf) {
		this.cpf = cpf;
	}

}
