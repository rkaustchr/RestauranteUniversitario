package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladores.exceptions.ConsumidorNotFound;
import entidades.Consumidor;
import roteiros.RoteiroAtualizarConsumidor;
import roteiros.RoteiroVerConsumidor;

@WebServlet("/AtualizarConsumidor")
public class AtualizarConsumidor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = (String) request.getParameter("acaoAtualizar");
		if(request.getParameter("cpf") == null){
			request.setAttribute("erro", "Selecione um consumidor!");
			response.sendRedirect("ListarConsumidor"); 
			//request.getRequestDispatcher("ListarConsumidor.jsp").forward(request,response);
			return;
		}
			
		if (acao == null)
			acao = "";

		switch (acao) {
			case "Cancelar":
			case "Voltar":
				request.getRequestDispatcher("ListarConsumidor").forward(request,response);
				break;
			case "Atualizar":
				atualizarConsumidorAntigo(request,response);
				break;
			default:
				Consumidor consumidorAntigo;
				try {
					RoteiroVerConsumidor rVerConsumidor = new RoteiroVerConsumidor(request.getParameter("cpf"));
					consumidorAntigo = rVerConsumidor.executar();
				} catch (ConsumidorNotFound e) {
					request.setAttribute("erro", "Consumidor não encontrado");
					request.getRequestDispatcher("ListarConsumidor").forward(request,response);
					return;
				}
	
				request.setAttribute("consumidorAntigo", consumidorAntigo);
				request.getRequestDispatcher("WEB-INF/AtualizarConsumidor.jsp").forward(request,response);	
				break;
		}
	}
	
	
	private void atualizarConsumidorAntigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = (String) request.getParameter("nome");
		int matricula = Integer.parseInt(request.getParameter("matricula"));
		String anoIngresso = (String) request.getParameter("anoIngresso");
		String sexo = (String) request.getParameter("sexo");
		String cpf = (String) request.getParameter("cpf");
		
		if (nome == ""){
			request.setAttribute("erro", "Um Consumidor deve conter um nome");
			request.getRequestDispatcher("WEB-INF/AtualizarConsumidor.jsp").forward(request,response);
		}else{
			try {
				RoteiroAtualizarConsumidor rAlterarConsumidor = new RoteiroAtualizarConsumidor(nome, matricula, anoIngresso, sexo, cpf);
				rAlterarConsumidor.executar();
			} catch (ConsumidorNotFound e) {
				request.setAttribute("erro", "Consumidor não encontrado");
				request.getRequestDispatcher("ListarConsumidor").forward(request,response);
			}
			
			request.setAttribute("message", "Consumidor alterado!");
			request.getRequestDispatcher("ListarConsumidor").forward(request,response);			
		}
	}
}