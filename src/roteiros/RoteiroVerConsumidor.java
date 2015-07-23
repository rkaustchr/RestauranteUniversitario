package roteiros;

import entidades.Aluno;
import entidades.Consumidor;
import entidades.Curso;
import entidades.Departamento;
import entidades.Funcionario;
import gateway.AlunoGateway;
import gateway.ConsumidorFinder;
import gateway.FuncionarioGateway;
import gateway.IGateway;
import controladores.exceptions.ConsumidorNotFound;

public class RoteiroVerConsumidor {
	private String cpf;
	
	public RoteiroVerConsumidor(String cpf){
		this.cpf = cpf;
	}
	
	public Consumidor executar() throws ConsumidorNotFound {
		ConsumidorFinder fConsumidor = new ConsumidorFinder();
		Consumidor retorno;
		
		IGateway gConsumidor = fConsumidor.find(cpf);
		
		if ( gConsumidor instanceof AlunoGateway) {
			retorno = new Aluno(((AlunoGateway) gConsumidor).getNome(), ((AlunoGateway) gConsumidor).getMatricula(), ((AlunoGateway) gConsumidor).getAnoIngresso(), ((AlunoGateway) gConsumidor).getSexo(), ((AlunoGateway) gConsumidor).getTitulo(), ((AlunoGateway) gConsumidor).getCpf(),  new Curso(((AlunoGateway) gConsumidor).getCurso().getNome(), ((AlunoGateway) gConsumidor).getCurso().getSigla(), new Departamento(((AlunoGateway) gConsumidor).getCurso().getDepartamento().getNome(), ((AlunoGateway) gConsumidor).getCurso().getDepartamento().getSigla())) );
		} else { // ( gConsumidor instanceof FuncionarioGateway) {
			retorno = new Funcionario(((FuncionarioGateway) gConsumidor).getNome(), ((FuncionarioGateway) gConsumidor).getMatricula(), ((FuncionarioGateway) gConsumidor).getAnoIngresso(), ((FuncionarioGateway) gConsumidor).getSexo(), ((FuncionarioGateway) gConsumidor).getTitulo(), ((FuncionarioGateway) gConsumidor).getCpf(), new Departamento(((FuncionarioGateway) gConsumidor).getDepartamento().getNome(), ((FuncionarioGateway) gConsumidor).getDepartamento().getSigla()));
		}
		
		/*
		try {
			/*
			if ( ((AlunoGateway) gConsumidor).getCurso() != null ) {
				System.out.println("Try: Aluno");
			}			
			
			retorno = new Aluno(((AlunoGateway) gConsumidor).getNome(), ((AlunoGateway) gConsumidor).getMatricula(), ((AlunoGateway) gConsumidor).getAnoIngresso(), ((AlunoGateway) gConsumidor).getSexo(), ((AlunoGateway) gConsumidor).getTitulo(), ((AlunoGateway) gConsumidor).getCpf(),  new Curso(((AlunoGateway) gConsumidor).getCurso().getNome(), ((AlunoGateway) gConsumidor).getCurso().getSigla(), new Departamento(((AlunoGateway) gConsumidor).getCurso().getDepartamento().getNome(), ((AlunoGateway) gConsumidor).getCurso().getDepartamento().getSigla())) );
			
		} catch (Exception e) {																																																								
			retorno = new Funcionario(((FuncionarioGateway) gConsumidor).getNome(), ((FuncionarioGateway) gConsumidor).getMatricula(), ((FuncionarioGateway) gConsumidor).getAnoIngresso(), ((FuncionarioGateway) gConsumidor).getSexo(), ((FuncionarioGateway) gConsumidor).getTitulo(), ((FuncionarioGateway) gConsumidor).getCpf(), new Departamento(((FuncionarioGateway) gConsumidor).getDepartamento().getNome(), ((FuncionarioGateway) gConsumidor).getDepartamento().getSigla()));
		}
		*/
		return retorno;
	}

}
