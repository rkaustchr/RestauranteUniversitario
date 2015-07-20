package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import roteiros.RoteiroCriarRefeicao;

/**
 * Servlet implementation class CriarRefeicao
 */
@WebServlet("/CriarRefeicao")
public class CriarRefeicao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarRefeicao() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = (String) request.getParameter("acaoCriar");
		
		if (acao != null){
			switch (acao) {
				case "Criar":
					criarRefeicao(request,response);
					break;
				default:
					request.getRequestDispatcher("ListarRefeicao").forward(request,response);
			}
		}else{
			request.getRequestDispatcher("WEB-INF/CriarRefeicao.jsp").forward(request,response);	
		}
		
	}


	private void criarRefeicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descricao = request.getParameter("descricao");
		String turno = request.getParameter("turno");
		String opcaoVegan = request.getParameter("opcaoVegan");
		
		RoteiroCriarRefeicao rCriarRefeicao = new RoteiroCriarRefeicao(descricao, turno, opcaoVegan);
		rCriarRefeicao.executar();
		
		request.setAttribute("message", "Nova refeição criada!");
		request.getRequestDispatcher("ListarRefeicao").forward(request,response);
		
	}

}
