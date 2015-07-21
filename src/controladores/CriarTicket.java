package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladores.exceptions.ConsumidorNotFoundException;
import controladores.exceptions.NomeNotFoundException;
import controladores.exceptions.RefeicaoNotFoundException;
import controladores.exceptions.SiglaAlreadyExistsException;
import controladores.exceptions.SiglaNotFoundException;
import roteiros.RoteiroCriarCurso;
import roteiros.RoteiroCriarTicket;
import roteiros.RoteiroListarConsumidor;
import roteiros.RoteiroListarDepartamento;
import roteiros.RoteiroListarRefeicao;
import entidades.Consumidor;
import entidades.Departamento;
import entidades.Refeicao;

/**
 * Servlet implementation class CriarTicket
 */
@WebServlet("/CriarTicket")
public class CriarTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarTicket() {
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
		String acao = (String) request.getParameter("acaoCriar");
		RoteiroListarRefeicao rListarRefeicao = new RoteiroListarRefeicao();
		ArrayList<Refeicao> refeicoesDisponiveis = new ArrayList<Refeicao>();
		try {
			refeicoesDisponiveis = rListarRefeicao.executar();
			request.setAttribute("refeicoesDisponiveis", refeicoesDisponiveis);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		RoteiroListarConsumidor rListarConsumidor = new RoteiroListarConsumidor();
		ArrayList<Consumidor> consumidoresDisponiveis = new ArrayList<Consumidor>();
		try {
			consumidoresDisponiveis = rListarConsumidor.executar();
			request.setAttribute("consumidoresDisponiveis", consumidoresDisponiveis);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		if (acao != null){
			switch (acao) {
				case "Criar":
					criarTicket(request,response);
					break;
				default:
					request.getRequestDispatcher("ListarTicket").forward(request,response);
			}
		}else{
			request.getRequestDispatcher("WEB-INF/CriarTicket.jsp").forward(request,response);	
		}
	}
	
	private void criarTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		String idRefeicao = (String) request.getParameter("idRefeicao");
		boolean pago =  request.getParameter("pago") != null ? true : false;
		String cpfConsumidor =  request.getParameter("cpfConsumidor");

		try {
			RoteiroCriarTicket rCriarTicket = new RoteiroCriarTicket(idRefeicao, pago, cpfConsumidor);
			rCriarTicket.executar();
			request.setAttribute("message", "Novo ticket criado!");
			request.getRequestDispatcher("ListarTicket").forward(request,response);
		} catch (RefeicaoNotFoundException | ConsumidorNotFoundException e2) {
			request.setAttribute("erro", "Um ticket deve se relacionar com uma refeição e com um consumidor");
			request.getRequestDispatcher("WEB-INF/CriarTicket.jsp").forward(request,response);
		}
		
	}

}
