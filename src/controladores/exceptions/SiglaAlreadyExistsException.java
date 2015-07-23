package controladores.exceptions;

public class SiglaAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;	
	private String sigla;

	public SiglaAlreadyExistsException(String sigla) {
		this.sigla = sigla;
	}
	
	public String getSigla() {
		return sigla;
	}

}
