package controladores;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Curso;
import roteiros.RoteiroListarCurso;

@WebServlet("/ListarCurso")
public class ListarCurso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//listarCursos(request, response);
		RoteiroListarCurso rListarCurso = new RoteiroListarCurso();
		try {
			ArrayList<Curso> cursos = rListarCurso.executar();
			request.setAttribute("listaCursos", cursos);
			request.getRequestDispatcher("WEB-INF/ListarCurso.jsp").forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = (String) request.getParameter("acaoListar");
		
		if (acao == null) acao = "";
		
		switch (acao) {
			case "Criar":
				request.getRequestDispatcher("CriarCurso").forward(request,response);
				break;
			case "Atualizar":
				request.getRequestDispatcher("AtualizarCurso").forward(request,response);
				break;
			case "Ver":
				request.getRequestDispatcher("VerCurso").forward(request,response);
				break;
			case "":
			default:
				doGet(request,response);			
		}
	}

}
