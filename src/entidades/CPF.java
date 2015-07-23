package entidades;

import java.util.InputMismatchException;

public class CPF {
	
	private String digitos;
	
	public CPF(String digitos)  {
		this.digitos = digitos;
	}
	
	public boolean isCpfValido() {
		if (digitos.length() != 11) return false;
		
		int[] vetCpf = converterVetInt();
		try {
			int i;
			int sm = 0;
			int peso = 10;
			
			for (i=0; i<9; i++) {     
		        int num = vetCpf[i]; 
		        sm = sm + (num * peso);
		        peso = peso - 1;
		    }
	
			 int r = 11 - (sm % 11);
			 int dig10;
			 if ((r == 10) || (r == 11))
				 dig10 = 0;
			 else 
				 dig10 = r;
			 
			 // Calculo do 2o. Digito Verificador
		     sm = 0;
		     peso = 11;
		     for(i=0; i<10; i++) {
		    	 int num = vetCpf[i];
		    	 sm = sm + (num * peso);
		    	 peso = peso - 1;
		     }
	
		     r = 11 - (sm % 11);
		     int dig11;
		     if ((r == 10) || (r == 11))
		    	 dig11 = 0;
		     else 
		    	 dig11 = r;
	
		     // Verifica se os digitos calculados conferem com os digitos informados.
		     if ( (dig10 == vetCpf[9]) && (dig11 == vetCpf[10]) )
		    	 return true;
		     else 
		    	 return false;
	     } catch (InputMismatchException erro) {
	        return false;
	     }
			
	}
	
	public int getDigitosVerificadores(){
		return Integer.parseInt( String.valueOf(digitos.charAt(9)) ) *10 + Integer.parseInt( String.valueOf(digitos.charAt(10)) );
	}
	
	public int[] converterVetInt(){
		int[] vetCpf = new int[11];
		
		for (int i=0; i < digitos.length(); i++ ) {
			vetCpf[i] = Integer.parseInt( String.valueOf(digitos.charAt(i)) );
		}
		return vetCpf;
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
