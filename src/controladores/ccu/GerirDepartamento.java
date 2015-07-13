package controladores.ccu;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import controladores.ccu.exceptions.DepartamentoNotFound;
import controladores.ccu.exceptions.NomeNotFoundException;
import controladores.ccu.exceptions.SiglaAlreadyExistsException;
import controladores.ccu.exceptions.SiglaNotFoundException;
import entidades.Departamento;

public class GerirDepartamento {
	
	public static Collection<Departamento> listarDepartamentos(HttpSession session) {
		return Departamento._listarDepartamentosDisponiveis(session);
	}
	
	public static Departamento buscarDepartamento(HttpSession session, String sigla) throws DepartamentoNotFound{
		Departamento departamentoAntigo = new Departamento("", sigla);
		try {
			departamentoAntigo = Departamento._buscarDepartamento(session, departamentoAntigo.getSigla());
		} catch (NullPointerException e) {
			throw new DepartamentoNotFound();
		}
		if (departamentoAntigo == null){
			throw new DepartamentoNotFound();
		}
		
		return departamentoAntigo;
	}	
	
	public static void criarDepartamento(HttpSession session, String nome, String sigla) throws SiglaNotFoundException, NomeNotFoundException, SiglaAlreadyExistsException {
		
		Departamento dpto = new Departamento(nome,sigla);
		
		if (Departamento._buscarDepartamento(session,sigla) == null){
			if (sigla==""){
				throw new SiglaNotFoundException();
			}else{
				if (nome==""){
					throw new NomeNotFoundException();
				}else{
					Departamento._adicionarDepartamento(session,dpto);
				}
			}
		}else{
			throw new SiglaAlreadyExistsException(sigla);
		}
	}
	
	public static void atualizarDepartamento(HttpSession session, String nome, String sigla) throws DepartamentoNotFound{
		Departamento dpto = new Departamento(nome,sigla);
		
		Departamento departamentoAntigo = buscarDepartamento(session,sigla);
		if (departamentoAntigo == null){
			throw new DepartamentoNotFound();	
		}else{
			Departamento._atualizarDepartamento(session, dpto);
		}
	}	
}
