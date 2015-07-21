package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladores.ccu.exceptions.CursoNotFound;
import entidades.Consumidor;
import roteiros.RoteiroAtualizarConsumidor;
import roteiros.RoteiroAtualizarCurso;
import roteiros.RoteiroVerConsumidor;

@WebServlet("/AtualizarConsumidor")
public class AtualizarConsumidor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = (String) request.getParameter("acaoAtualizar");
		
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
				RoteiroAtualizarConsumidor rAtualizarConsumidor = new RoteiroAtualizarConsumidor();
				Consumidor consumidorAntigo = rAtualizarConsumidor.getConsumidor(request.getParameter("cpf"));
	
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
		String titulo = (String) request.getParameter("titulo");
		String cpf = (String) request.getParameter("cpf");
		String sigla = (String) request.getParameter("sigla");
		String tipo = (String) request.getParameter("tipo");
		
		if (nome == ""){
			request.setAttribute("erro", "Um Consumidor deve conter um nome");
			request.getRequestDispatcher("WEB-INF/AtualizarConsumidor.jsp").forward(request,response);
		}else{
			RoteiroAtualizarConsumidor rAlterarConsumidor = new RoteiroAtualizarConsumidor(nome, matricula, anoIngresso, sexo, titulo, cpf, sigla, tipo);
			Consumidor consumidorNovo = rAlterarConsumidor.executar();
			
			request.setAttribute("message", "Novo consumidor criado!");
			request.getRequestDispatcher("ListarConsumidor").forward(request,response);			
		}
	}
}