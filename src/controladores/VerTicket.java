package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import roteiros.RoteiroVerTicket;
import controladores.exceptions.TicketNotFound;
import entidades.Ticket;

/**
 * Servlet implementation class VerTicket
 */
@WebServlet("/VerTicket")
public class VerTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerTicket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = (String) request.getParameter("acaoVer");
		if (acao == null)
			acao = "";
		
		if(request.getParameter("id") == null){
			request.setAttribute("erro", "Selecione uma Refeicao!");
			response.sendRedirect("ListarTicket"); 
			//request.getRequestDispatcher("ListarConsumidor.jsp").forward(request,response);
			return;
		}
		
		switch (acao) {
			case "Voltar":
				request.getRequestDispatcher("ListarTicket").forward(request,response);
				break;
			default:
				try {
					RoteiroVerTicket rVerTicket = new RoteiroVerTicket(request.getParameter("id"));
					Ticket ticketAntigo = rVerTicket.executar();
					
					request.setAttribute("ticketAntigo",ticketAntigo);
					request.getRequestDispatcher("WEB-INF/VerTicket.jsp").forward(request,response);
				} catch (TicketNotFound e) {
					request.setAttribute("erro", "Ticket não existe!");
					request.getRequestDispatcher("WEB-INF/VerTicket.jsp").forward(request,response);
				}				
		}
	}

}
