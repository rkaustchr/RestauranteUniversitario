package gateway;

import java.util.ArrayList;

import entidades.Aluno;
import entidades.CPF;
import entidades.Consumidor;
import entidades.Curso;
import entidades.Sexo;
import entidades.Titulo;
import entidades.value_objects.DepartamentoVO;

public class GatewayConsumidor {
	
	public GatewayConsumidor() {
		
	}
	
	public ArrayList<Consumidor> listarConsumidores() throws Exception {
		ArrayList<Consumidor> consumidores = new ArrayList<Consumidor>();
							//String nome, int matricula, int anoIngresso, Sexo sexo, Titulo titulo, CPF cpf, Curso curso // (String nome, String sigla, DepartamentoVO departamento)
		consumidores.add(new Aluno("Racicley", 2010780238, 2012, Sexo.MASCULINO, Titulo.MESTRADO, new CPF("12345678910"), new Curso("Ciênca da Transância", "CT", new DepartamentoVO())));
		
		return consumidores;
	}

}
