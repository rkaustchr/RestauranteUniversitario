package roteiros;

import controladores.exceptions.ConsumidorNotFound;
import entidades.CPF;
import entidades.Sexo;
import gateway.ConsumidorGateway;

public class RoteiroAtualizarConsumidor {

	private String nome;
	private int matricula;
	private String anoIngresso;
	private Sexo sexo;
	private CPF cpf;

	public RoteiroAtualizarConsumidor(String nome, int matricula, String anoIngresso, String sexo, String cpf ) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.matricula = matricula;
		this.anoIngresso = anoIngresso;
		this.sexo = Sexo.valueOf(sexo);
		this.cpf = new CPF(cpf);
	}

	public void executar() throws ConsumidorNotFound {
		
		ConsumidorGateway gConsumidor = new ConsumidorGateway(nome, matricula, anoIngresso, sexo, null, cpf);
		gConsumidor.update();

		if ( gConsumidor == null ) throw new ConsumidorNotFound();
		
	}

}
