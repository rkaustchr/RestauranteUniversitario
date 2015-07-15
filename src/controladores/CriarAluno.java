package controladores;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.CPF;
import entidades.Sexo;
import entidades.Titulo;
import roteiros.RoteiroCriarAluno;

/**
 * Servlet implementation class CriarAluno
 */
@WebServlet("/CriarAluno")
public class CriarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarAluno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = (String) request.getParameter("nome");
		int matricula = Integer.parseInt(request.getParameter("matricula"));
		String anoIngresso = (String) request.getParameter("anoIngresso");
		Sexo sexo = Sexo.valueOf(request.getParameter("sexo"));
		Titulo titulo = Titulo.valueOf(request.getParameter("titulo"));
		CPF cpf = new CPF(request.getParameter("cpf"));
		String siglaCurso = (String) request.getParameter("siglaCurso");
		RoteiroCriarAluno rCriarAluno = new RoteiroCriarAluno();
		
		request.getRequestDispatcher("WEB-INF/CriarAluno.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
