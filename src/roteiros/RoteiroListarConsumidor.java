package roteiros;

import java.util.ArrayList;
import entidades.Aluno;
import entidades.Consumidor;
import entidades.Curso;
import entidades.Departamento;
import entidades.Funcionario;
import gateway.AlunoFinder;
import gateway.AlunoGateway;
import gateway.CursoGateway;
import gateway.DepartamentoGateway;
import gateway.FuncionarioFinder;
import gateway.FuncionarioGateway;
import gateway.IGateway;

public class RoteiroListarConsumidor  {

	public ArrayList<Consumidor> executar() throws Exception {

		AlunoFinder fAluno = new AlunoFinder();
		FuncionarioFinder fFuncionario = new FuncionarioFinder();
		
		ArrayList<Consumidor> retorno = new ArrayList<Consumidor>();
		
		for (IGateway gConsumidor : fAluno.findAll()) {
			CursoGateway gCurso = ((AlunoGateway) gConsumidor).getCurso();
			DepartamentoGateway gDepartamento = gCurso.getDepartamento();
			Departamento departamento = new Departamento(gDepartamento.getNome(), gDepartamento.getSigla()); 
			Curso curso = new Curso(gCurso.getNome(), gCurso.getSigla(), departamento);
			
			retorno.add(new Aluno(((AlunoGateway) gConsumidor).getNome(), ((AlunoGateway) gConsumidor).getMatricula(), ((AlunoGateway) gConsumidor).getAnoIngresso(), ((AlunoGateway) gConsumidor).getSexo(), ((AlunoGateway) gConsumidor).getTitulo(), ((AlunoGateway) gConsumidor).getCpf(), curso));
		}
		for (IGateway gConsumidor : fFuncionario.findAll()) {
			DepartamentoGateway gDepartamento = ((FuncionarioGateway) gConsumidor).getDepartamento();
			Departamento departamento = new Departamento(gDepartamento.getNome(), gDepartamento.getSigla()); 
			retorno.add(new Funcionario(((FuncionarioGateway) gConsumidor).getNome(), ((FuncionarioGateway) gConsumidor).getMatricula(), ((FuncionarioGateway) gConsumidor).getAnoIngresso(), ((FuncionarioGateway) gConsumidor).getSexo(), ((FuncionarioGateway) gConsumidor).getTitulo(), ((FuncionarioGateway) gConsumidor).getCpf(), departamento));
		}

		return retorno;		
	}

}
