package controladores.ccu;

import javax.servlet.http.HttpSession;
import controladores.ccu.exceptions.CursoNotFound;
import controladores.ccu.exceptions.DepartamentoNotFound;
import controladores.ccu.exceptions.NomeNotFoundException;
import controladores.ccu.exceptions.SiglaAlreadyExistsException;
import controladores.ccu.exceptions.SiglaNotFoundException;
import entidades.Curso;
import entidades.Departamento;

public class GerirCurso {
	public static Object listarCursos(HttpSession session) {
		return Curso._listarCursosDisponiveis(session);
	}

	public static Curso buscarCurso(HttpSession session, String sigla) throws CursoNotFound{
		Curso cursoAntigo = new Curso("", sigla,null);
		try {
			cursoAntigo = Curso._buscarCurso(session, cursoAntigo.getSigla());
		} catch (NullPointerException e) {
			throw new CursoNotFound();
		}
		if (cursoAntigo == null){
			throw new CursoNotFound();
		}
		
		return cursoAntigo;
	}

	public static void criarCurso(HttpSession session, String nome, String sigla, String siglaDpto) throws SiglaNotFoundException, NomeNotFoundException, SiglaAlreadyExistsException, DepartamentoNotFound {
		Departamento dpto = Departamento._buscarDepartamento(session,siglaDpto);
		
		if (dpto == null){
			throw new DepartamentoNotFound();
		} else{
			Curso curso = new Curso(nome,sigla,dpto);
			
			if (Curso._buscarCurso(session,sigla) == null){
				if (sigla==""){
					throw new SiglaNotFoundException();
				}else{
					if (nome==""){
						throw new NomeNotFoundException();
					}else{
						Curso._adicionarCurso(session,curso);
					}
				}
			}else{
				throw new SiglaAlreadyExistsException(sigla);
			}
		}
	}

	public static void atualizarCurso(HttpSession session, String nome, String sigla, String siglaDpto) throws CursoNotFound, DepartamentoNotFound{
		Departamento dpto = Departamento._buscarDepartamento(session,siglaDpto);
		
		if (dpto == null){
			throw new DepartamentoNotFound();
		} else{
			Curso cursoAntigo = buscarCurso(session,sigla);
			if (cursoAntigo == null){
				throw new CursoNotFound();
			}else{
				cursoAntigo.setNome(nome);
				cursoAntigo.setDepartamento(dpto);
				Curso._atualizarCurso(session, cursoAntigo);
			}
		}
	}			
}
