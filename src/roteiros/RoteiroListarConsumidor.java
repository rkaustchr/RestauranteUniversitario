package roteiros;

import java.util.ArrayList;

import entidades.Aluno;
import entidades.Consumidor;
import entidades.Curso;
import entidades.Departamento;
import gateway.AlunoFinder;
import gateway.AlunoGateway;
import gateway.ConsumidorGateway;
import gateway.CursoFinder;
import gateway.CursoGateway;
import gateway.DepartamentoGateway;
import gateway.FuncionarioFinder;
import gateway.IGateway;

public class RoteiroListarConsumidor  {

	public ArrayList<Consumidor> executar() throws Exception {
		AlunoFinder fAluno = new AlunoFinder();
		FuncionarioFinder fFuncionario = new FuncionarioFinder();
		
		ArrayList<Consumidor> retorno = new ArrayList<Consumidor>();
		
		for (IGateway gConsumidor : fAluno.findAll()) {
			CursoGateway gCurso = ((AlunoGateway) gConsumidor).getCurso();
			retorno.add(new Aluno(((AlunoGateway) gConsumidor).getNome(), ((AlunoGateway) gConsumidor).getMatricula(), dept));
		}
		
		return retorno;		
	
	}

}
