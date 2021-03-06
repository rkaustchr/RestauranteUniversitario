package controladores;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Consumidor;
import roteiros.RoteiroListarConsumidor;

@WebServlet("/ListarConsumidor")
public class ListarConsumidor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoteiroListarConsumidor rListarConsumidor = new RoteiroListarConsumidor();
		try {
			ArrayList<Consumidor> consumidores = rListarConsumidor.executar();
			request.setAttribute("listaConsumidores", consumidores);
			request.getRequestDispatcher("WEB-INF/ListarConsumidor.jsp").forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = (String) request.getParameter("acaoListar");
		
		if (acao == null) acao = "";
		
		switch (acao) {
			case "Criar Aluno":
				request.getRequestDispatcher("CriarAluno").forward(request,response);
				break;
			case "Criar Funcionario":
				request.getRequestDispatcher("CriarFuncionario").forward(request,response);
				break;
			case "Atualizar":
				request.getRequestDispatcher("AtualizarConsumidor").forward(request,response);
				break;
			case "Ver":
				request.getRequestDispatcher("VerConsumidor").forward(request,response);
				break;
			case "":
			default:
				doGet(request, response); 		
		}
	}
}
