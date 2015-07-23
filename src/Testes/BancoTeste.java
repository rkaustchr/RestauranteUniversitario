package Testes;

import persistencia.ModoTeste;

public class BancoTeste {
	
	public static void zerar()
	{		
		ModoTeste.testeAtivo = true;
		ModoTeste.prepararBanco();
	}

}
