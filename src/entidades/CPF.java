package entidades;

public class CPF {
	
	private String digitos;
	
	public CPF(String digitos) throws Exception {
		if (digitos.length() != 11){
			throw new Exception("O CPF deve conter 11 digitos!");
			// tambem podemos validar os calculos do dv aqui!
		}else{
			// usando o clone = nao permitir alteracoes externas a classe CPF nos valores do array
			this.digitos = digitos;
		}
	}
	
	public int getDigitosVerificadores(){
		return Integer.parseInt( String.valueOf(digitos.charAt(9)) ) *10 + Integer.parseInt( String.valueOf(digitos.charAt(10)) );
	}

	public String getListaDigitosVerificadores(){
		return digitos.charAt(9) + "" + digitos.charAt(10);
	}

	public String getListaDigitos(){
		return digitos;
	}
	
	public String toString() {
		return digitos;
	}
}
