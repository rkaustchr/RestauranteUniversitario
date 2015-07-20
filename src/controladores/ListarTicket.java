package controladores;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import roteiros.RoteiroListarTicket;
import entidades.Ticket;

/**
 * Servlet implementation class ListarTicket
 */
@WebServlet("/ListarTicket")
public class ListarTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoteiroListarTicket rListarTicket = new RoteiroListarTicket();
		try {
			ArrayList<Ticket> tickets = rListarTicket.executar();
			request.setAttribute("listaTickets", tickets);
			request.getRequestDispatcher("WEB-INF/ListarTicket.jsp").forward(request,response);
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
				request.getRequestDispatcher("CriarTicket").forward(request,response);
				break;
			case "Atualizar":
				request.getRequestDispatcher("AtualizarTicket").forward(request,response);
				break;
			case "Ver":
				request.getRequestDispatcher("VerTicket").forward(request,response);
				break;
			case "":
			default:
				doGet(request,response);			
		}
	}

}
