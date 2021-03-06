package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladores.exceptions.CursoNotFound;
import entidades.Curso;
import roteiros.RoteiroVerCurso;

@WebServlet("/VerCurso")
public class VerCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = (String) request.getParameter("acaoVer");
		if (acao == null)
			acao = "";

		if(request.getParameter("sigla") == null){
			request.setAttribute("erro", "Selecione um departamento!");
			response.sendRedirect("ListarCurso"); 
			//request.getRequestDispatcher("ListarConsumidor.jsp").forward(request,response);
			return;
		}
		
		switch (acao) {
			case "Voltar":
				request.getRequestDispatcher("ListarCurso").forward(request,response);
				break;
			default:
				try {
					RoteiroVerCurso rVerCurso = new RoteiroVerCurso(request.getParameter("sigla"));
					Curso cursoAntigo = rVerCurso.executar();
					
					request.setAttribute("cursoAntigo",cursoAntigo);
					request.getRequestDispatcher("WEB-INF/VerCurso.jsp").forward(request,response);
				} catch (CursoNotFound e) {
					request.setAttribute("erro", "Curso não existe!");
					request.getRequestDispatcher("WEB-INF/VerCurso.jsp").forward(request,response);
				}				
		}
	}
}