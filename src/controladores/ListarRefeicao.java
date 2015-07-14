package controladores;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidades.Refeicao;
import roteiros.RoteiroListarRefeicao;

/**
 * Servlet implementation class ListarRefeicao
 */
@WebServlet("/ListarRefeicao")
public class ListarRefeicao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarRefeicao() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RoteiroListarRefeicao rListarRefeicao = new RoteiroListarRefeicao();
		try {
			ArrayList<Refeicao> refeicoes = rListarRefeicao.executar();
			request.setAttribute("listaRefeicoes", refeicoes);
			
			request.getRequestDispatcher("WEB-INF/ListarRefeicao.jsp").forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = (String) request.getParameter("acaoListar");
		
		if (acao == null) acao = "";
		switch (acao) {
			case "Criar":
				request.getRequestDispatcher("CriarRefeicao").forward(request,response);
				break;
			case "Atualizar":
				request.getRequestDispatcher("AtualizarRefeicao").forward(request,response);
				break;
			case "Ver":
				request.getRequestDispatcher("VerRefeicao").forward(request,response);
				break;
			case "":
			default:
				doGet(request,response); //listarRefeicoes(request, response);			
		}

	}

}
