package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladores.ccu.GerirCurso;
import controladores.ccu.exceptions.CursoNotFound;
import entidades.Refeicao;
import entidades.value_objects.CursoVO;

/**
 * Servlet implementation class VerRefeicao
 */
@WebServlet("/VerRefeicao")
public class VerRefeicao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerRefeicao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = (String) request.getParameter("acaoVer");
		if (acao == null)
			acao = "";

		switch (acao) {
			case "Voltar":
				request.getRequestDispatcher("ListarRefeicao").forward(request,response);
				break;
			default:
				// 
				// Atulaizar para 
				//
				/*Refeicao refeicaoAntigo;
				try {
					refeicaoAntigo = GerirCurso.buscarCurso(request.getSession(),request.getParameter("sigla"));
					request.setAttribute("curso antigo",cursoAntigo);
					request.getRequestDispatcher("WEB-INF/VerCurso.jsp").forward(request,response);
				} catch (CursoNotFound e) {
					request.setAttribute("erro", "Curso não existe!");
					request.getRequestDispatcher("WEB-INF/VerCurso.jsp").forward(request,response);
				}	*/			
		}
	}

}
