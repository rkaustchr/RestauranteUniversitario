package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roteiros.RoteiroAtualizarCurso;
import roteiros.RoteiroAtualizarTicket;
import roteiros.RoteiroVerCurso;
import roteiros.RoteiroVerTicket;
import controladores.exceptions.CursoNotFound;
import controladores.exceptions.TicketNotFound;
import entidades.Consumidor;
import entidades.Curso;
import entidades.Refeicao;
import entidades.Ticket;

/**
 * Servlet implementation class AtualizarTicket
 */
@WebServlet("/AtualizarTicket")
public class AtualizarTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizarTicket() {
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
		String acao = (String) request.getParameter("acaoAtualizar");
		
		if (acao == null)
			acao = "";

		switch (acao) {
			case "Cancelar":
			case "Voltar":
				request.getRequestDispatcher("ListarTicket").forward(request,response);
				break;
			case "Atualizar":
				atualizarTicketAntigo(request,response);
				break;
			default:
				try {					
					RoteiroVerTicket rVerTicket = new RoteiroVerTicket(request.getParameter("id"));
					Ticket ticketAntigo = rVerTicket.executar();

					request.setAttribute("ticketAntigo",ticketAntigo);
					request.getRequestDispatcher("WEB-INF/AtualizarTicket.jsp").forward(request,response);
				} catch (TicketNotFound e) {
					request.setAttribute("erro", "O ticket informado nao existe");
					request.getRequestDispatcher("WEB-INF/AtualizarTicket.jsp").forward(request,response);
				}	
		}
	}
	
	private void atualizarTicketAntigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// int id, Refeicao refeicao, boolean pago, Consumidor consumidor
		int id = Integer.parseInt( request.getParameter("id") );
		boolean pago =  request.getParameter("pago") != null ? true : false;
		
		try {
			RoteiroAtualizarTicket rAlterarTicket = new RoteiroAtualizarTicket( id, pago );
			rAlterarTicket.executar();
			
			//request.setAttribute("cursoNovo", cursoNovo);
			request.setAttribute("message", "Ticket alterado!");
			request.getRequestDispatcher("ListarTicket").forward(request,response);
		} catch (TicketNotFound e) {
			request.setAttribute("erro", "O ticket informado nao existe");
			request.getRequestDispatcher("WEB-INF/TicketCurso.jsp").forward(request,response);
		}			
	}

}
