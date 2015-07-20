package gateway;

import java.util.ArrayList;
import persistencia.ConexaoBD;

public class ConsumidorFinder implements IFinder {
	protected ConexaoBD conexao;
	
	public ConsumidorFinder(){
		conexao = new ConexaoBD();
	}
	
	@Override
	public ArrayList<IGateway> findAll() {
		ArrayList<IGateway> gConsumidor;// = new ArrayList<IGateway>();
		AlunoFinder fAluno = new AlunoFinder();
		FuncionarioFinder fFuncionario = new FuncionarioFinder();
		
		gConsumidor = fAluno.findAll();
		gConsumidor.addAll(fFuncionario.findAll());
		
		return gConsumidor;
	}

	@Override
	public IGateway find(String cpf) {
		IGateway gConsumidor = null;
		AlunoFinder fAluno = new AlunoFinder();
		FuncionarioFinder fFuncionario = new FuncionarioFinder();
		
		gConsumidor = fAluno.find(cpf);
		if ( gConsumidor == null ) {
			gConsumidor = fFuncionario.find(cpf);
		}
		
		return gConsumidor;
	}
}
