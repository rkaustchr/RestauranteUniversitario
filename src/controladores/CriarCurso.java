package controladores;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controladores.ccu.exceptions.NomeNotFoundException;
import controladores.ccu.exceptions.SiglaAlreadyExistsException;
import controladores.ccu.exceptions.SiglaNotFoundException;
import entidades.Departamento;
import roteiros.RoteiroCriarCurso;
import roteiros.RoteiroListarDepartamento;

@WebServlet("/CriarCurso")
public class CriarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = (String) request.getParameter("acaoCriar");
		RoteiroListarDepartamento rListarDepartamento = new RoteiroListarDepartamento();
		ArrayList<Departamento> departamentosDisponiveis = new ArrayList<Departamento>();
		try {
			departamentosDisponiveis = rListarDepartamento.executar();
			request.setAttribute("departamentosDisponiveis", departamentosDisponiveis);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		if (acao != null){
			switch (acao) {
				case "Criar":
					criarCurso(request,response);
					break;
				default:
					request.getRequestDispatcher("ListarCurso").forward(request,response);
			}
		}else{
			request.getRequestDispatcher("WEB-INF/CriarCurso.jsp").forward(request,response);	
		}
	}

	private void criarCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = (String) request.getParameter("nome");
		String sigla = (String) request.getParameter("sigla");
		String siglaDepartamento =  request.getParameter("departamento");

		try {
			RoteiroCriarCurso rCriarCurso = new RoteiroCriarCurso(nome, sigla, siglaDepartamento);
			rCriarCurso.executar();
			request.setAttribute("message", "Novo departamento criado!");
			request.getRequestDispatcher("ListarCurso").forward(request,response);
		} catch (SiglaNotFoundException | NomeNotFoundException e2) {
			request.setAttribute("erro", "Um curso deve conter um nome, uma sigla e um departamento");
			request.getRequestDispatcher("WEB-INF/CriarCurso.jsp").forward(request,response);
		}catch (SiglaAlreadyExistsException e) {
			request.setAttribute("erro", "Sigla informada já existe");
			request.getRequestDispatcher("WEB-INF/CriarCurso.jsp").forward(request,response);
		}
		
	}
}