package controladores;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Departamento;
import roteiros.RoteiroListarDepartamento;

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
		String acao = (String) request.getParameter("acaoCriar");
	
		 if (acao != null){
			switch (acao) {
				case "Criar":
					//criarAluno(request,response);
					request.getRequestDispatcher("WEB-INF/CriarAluno.jsp").forward(request,response);	
					break;
				default:
					request.getRequestDispatcher("ListarConsumidor").forward(request,response);
			}
		}else{ 
			request.getRequestDispatcher("WEB-INF/ListarConsumidor.jsp").forward(request,response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
