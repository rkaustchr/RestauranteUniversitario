package roteiros;

import controladores.exceptions.DepartamentoNotFound;
import entidades.Departamento;
import gateway.DepartamentoGateway;

public class RoteiroAtualizarDepartamento {
	private String id;
	private String nome;
	
	public RoteiroAtualizarDepartamento(String id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Departamento executar() throws DepartamentoNotFound {
		DepartamentoGateway gDepartamento = new DepartamentoGateway(this.nome, this.id);
		gDepartamento.update();
		
		return new Departamento(gDepartamento.getNome(), gDepartamento.getSigla());
		
	}
}
