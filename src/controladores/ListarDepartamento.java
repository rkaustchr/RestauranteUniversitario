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

@WebServlet("/ListarDepartamento")
public class ListarDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		RoteiroListarDepartamento rListarDepartamento = new RoteiroListarDepartamento();
		try {
			ArrayList<Departamento> departamentos = rListarDepartamento.executar();
			request.setAttribute("listaDepartamentos", departamentos);
			request.getRequestDispatcher("WEB-INF/ListarDepartamento.jsp").forward(request,response);
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
				request.getRequestDispatcher("CriarDepartamento").forward(request,response);
				break;
			case "Atualizar":
				request.setAttribute("id", request.getParameter("sigla"));
				request.getRequestDispatcher("AtualizarDepartamento").forward(request,response);
				break;
			case "Ver":
				request.setAttribute("id", request.getParameter("sigla"));
				request.getRequestDispatcher("VerDepartamento").forward(request,response);
				break;
			case "":
			default:
				doGet(request,response); 				
		}
	}

}
