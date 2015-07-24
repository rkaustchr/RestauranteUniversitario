package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controladores.exceptions.RefeicaoNotFound;
import entidades.Refeicao;
import roteiros.RoteiroAtualizarRefeicao;
import roteiros.RoteiroVerRefeicao;

@WebServlet("/AtualizarRefeicao")
public class AtualizarRefeicao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = (String) request.getParameter("acaoAtualizar");
		if(request.getParameter("id") == null){
			request.setAttribute("erro", "Selecione uma Refeicao!");
			response.sendRedirect("ListarRefeicao"); 
			//request.getRequestDispatcher("ListarConsumidor.jsp").forward(request,response);
			return;
		}
		if (acao == null)
			acao = "";

		switch (acao) {
			case "Cancelar":
			case "Voltar":
				request.getRequestDispatcher("ListarRefeicao").forward(request,response);
				break;
			case "Atualizar":
				atualizarRefeicaoAntigo(request,response);
				break;
			default:
				try {
					RoteiroVerRefeicao rVerRefeicao= new RoteiroVerRefeicao(request.getParameter("id"));
					Refeicao refeicaoAntigo = rVerRefeicao.executar();
					request.setAttribute("refeicaoAntigo",refeicaoAntigo);
					request.getRequestDispatcher("WEB-INF/AtualizarRefeicao.jsp").forward(request,response);
				} catch (RefeicaoNotFound e ) {
					request.setAttribute("erro", "A refeicaoinformada nao existe");
					request.getRequestDispatcher("WEB-INF/AtualizarRefeicao.jsp").forward(request,response);
				}				
		}
	}
	
	
	private void atualizarRefeicaoAntigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoteiroAtualizarRefeicao rAtualizarRefeicao = new RoteiroAtualizarRefeicao(request.getParameter("id"), request.getParameter("descricao"), request.getParameter("opcaoVegan"), request.getParameter("turno"));
		
		try {
			rAtualizarRefeicao.executar();
			
			//request.setAttribute("departamentoNovo",departamentoNovo);
			request.getRequestDispatcher("ListarRefeicao").forward(request,response);
		} catch ( RefeicaoNotFound e ) {
			request.setAttribute("erro", "A refeição informada nao existe");
			request.getRequestDispatcher("WEB-INF/AtualizarRefeicao.jsp").forward(request,response);
		} 
		
	}
}