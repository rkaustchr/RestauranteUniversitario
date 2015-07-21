package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roteiros.RoteiroVerConsumidor;
import roteiros.RoteiroVerDepartamento;
import controladores.exceptions.ConsumidorNotFound;
import controladores.exceptions.DepartamentoNotFound;
import entidades.Consumidor;
import entidades.Departamento;

/**
 * Servlet implementation class VerConsumidor
 */
@WebServlet("/VerConsumidor")
public class VerConsumidor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerConsumidor() {
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

		switch (acao) {
			case "Voltar":
				request.getRequestDispatcher("ListarConsumidor").forward(request,response);
				break;
			default:
				Consumidor consumidorAntigo;
				try {
					if ( request.getParameter("cpf") == null ) {
						request.setAttribute("erro", "Selecione um consumidor!");
						request.getRequestDispatcher("WEB-INF/ListarConsumidor.jsp").forward(request,response);
					}
					RoteiroVerConsumidor rVerConsumidor = new RoteiroVerConsumidor(request.getParameter("cpf"));
					consumidorAntigo = rVerConsumidor.executar();
					request.setAttribute("consumidorAntigo",consumidorAntigo);
					request.getRequestDispatcher("WEB-INF/VerConsumidor.jsp").forward(request,response);
				} catch (ConsumidorNotFound e) {
					request.setAttribute("erro", "Consumidor não existe!");
					request.getRequestDispatcher("WEB-INF/VerDepartamento.jsp").forward(request,response);
				}
		}
	}

}
