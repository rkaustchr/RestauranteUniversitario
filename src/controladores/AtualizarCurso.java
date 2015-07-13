package controladores;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controladores.ccu.GerirCurso;
import controladores.ccu.exceptions.CursoNotFound;
import controladores.ccu.exceptions.DepartamentoNotFound;
import entidades.Curso;
import entidades.Departamento;
import gateway.DepartamentoFinder;
import gateway.DepartamentoGateway;
import roteiros.RoteiroAtualizarCurso;
import roteiros.RoteiroListarDepartamento;
import roteiros.RoteiroVerCurso;

@WebServlet("/AtualizarCurso")
public class AtualizarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = (String) request.getParameter("acaoAtualizar");
		
		if (acao == null)
			acao = "";

		switch (acao) {
			case "Cancelar":
			case "Voltar":
				request.getRequestDispatcher("ListarCurso").forward(request,response);
				break;
			case "Atualizar":
				atualizarCursoAntigo(request,response);
				break;
			default:
				try {					
					RoteiroVerCurso rVerCurso = new RoteiroVerCurso(request.getParameter("sigla"));
					Curso cursoAntigo = rVerCurso.execute();

					request.setAttribute("cursoAntigo",cursoAntigo);
					request.getRequestDispatcher("WEB-INF/AtualizarCurso.jsp").forward(request,response);
				} catch (CursoNotFound e2) {
					request.setAttribute("erro", "O curso informado nao existe");
					request.getRequestDispatcher("WEB-INF/AtualizarCurso.jsp").forward(request,response);
				}	
		}
	}
	
	
	private void atualizarCursoAntigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = (String) request.getParameter("nome");
		String sigla = (String) request.getParameter("sigla");
		
		if (nome=="" || sigla=="" || request.getParameter("departamento") == null){
			request.setAttribute("erro", "Um curso deve conter um nome, uma sigla e um departamento");
			request.getRequestDispatcher("WEB-INF/AtualizarCurso.jsp").forward(request,response);
		}else{
			try {
				GerirCurso.atualizarCurso(request.getSession(), nome, sigla, request.getParameter("departamento"));
				request.setAttribute("message", "Novo curso criado!");
				request.getRequestDispatcher("ListarCurso").forward(request,response);
			}catch (DepartamentoNotFound e) {
				request.setAttribute("erro", "Informe um departamento valido");
				request.getRequestDispatcher("WEB-INF/CriarCurso.jsp").forward(request,response);
			} catch (CursoNotFound e) {
				request.setAttribute("erro", "O curso informado nao existe");
				request.getRequestDispatcher("WEB-INF/CriarCurso.jsp").forward(request,response);
			}			
		}
	}
}