package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladores.exceptions.DepartamentoNotFound;
import entidades.Departamento;
import roteiros.RoteiroAtualizarDepartamento;
import roteiros.RoteiroVerDepartamento;

@WebServlet("/AtualizarDepartamento")
public class AtualizarDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = (String) request.getParameter("acaoAtualizar");
		if(request.getParameter("sigla") == null){
			request.setAttribute("erro", "Selecione um departamento!");
			response.sendRedirect("ListarDepartamento"); 
			//request.getRequestDispatcher("ListarConsumidor.jsp").forward(request,response);
			return;
		}
		if (acao == null)
			acao = "";

		switch (acao) {
			case "Cancelar":
			case "Voltar":
				request.getRequestDispatcher("ListarDepartamento").forward(request,response);
				break;
			case "Atualizar":
				atualizarDepartamentoAntigo(request,response);
				break;
			default:
				try {
					RoteiroVerDepartamento rVerDepartamento = new RoteiroVerDepartamento(request.getParameter("sigla"));
					Departamento departamentoAntigo = rVerDepartamento.executar();
					request.setAttribute("departamentoAntigo",departamentoAntigo);
					request.getRequestDispatcher("WEB-INF/AtualizarDepartamento.jsp").forward(request,response);
				} catch (DepartamentoNotFound e2) {
					request.setAttribute("erro", "O departamento informado nao existe");
					request.getRequestDispatcher("WEB-INF/AtualizarDepartamento.jsp").forward(request,response);
				}				
		}
	}
	
	
	private void atualizarDepartamentoAntigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoteiroAtualizarDepartamento rAtualizarDepartamento = new RoteiroAtualizarDepartamento(request.getParameter("sigla"), request.getParameter("nome"));
		
		try {
			rAtualizarDepartamento.executar();
			
			//request.setAttribute("departamentoNovo",departamentoNovo);
			request.getRequestDispatcher("ListarDepartamento").forward(request,response);
		} catch (DepartamentoNotFound e2) {
			request.setAttribute("erro", "O departamento informado nao existe");
			request.getRequestDispatcher("WEB-INF/AtualizarDepartamento.jsp").forward(request,response);
		} 
		
	}
}