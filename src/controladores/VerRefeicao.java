package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladores.ccu.exceptions.DepartamentoNotFound;
import controladores.ccu.exceptions.RefeicaoNotFound;
import entidades.Departamento;
import entidades.Refeicao;
import roteiros.RoteiroVerDepartamento;
import roteiros.RoteiroVerRefeicao;
/**
 * Servlet implementation class VerRefeicao
 */
@WebServlet("/VerRefeicao")
public class VerRefeicao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerRefeicao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
				request.getRequestDispatcher("ListarRefeicao").forward(request,response);
				break;
			default:
				Refeicao refeicaoAntigo;
				try {
					if ( request.getParameter("id") == null ) {
						request.setAttribute("erro", "Selecione uma refeição!");
						request.getRequestDispatcher("WEB-INF/ListarRefeicao.jsp").forward(request,response);
						return;
					}

					RoteiroVerRefeicao rVerRefeicao = new RoteiroVerRefeicao(request.getParameter("id"));
					refeicaoAntigo = rVerRefeicao.executar();
					request.setAttribute("refeicaoAntigo",refeicaoAntigo);
					request.getRequestDispatcher("WEB-INF/VerRefeicao.jsp").forward(request,response);
				} catch (RefeicaoNotFound e) {
					request.setAttribute("erro", "Refeicao não existe!");
					request.getRequestDispatcher("WEB-INF/VerRefeicao.jsp").forward(request,response);
				}
						
		}
	}

}
