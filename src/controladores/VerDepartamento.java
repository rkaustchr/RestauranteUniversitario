package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controladores.ccu.exceptions.DepartamentoNotFound;
import entidades.Departamento;
import roteiros.RoteiroVerDepartamento;

@WebServlet("/VerDepartamento")
public class VerDepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = (String) request.getParameter("acaoVer");
		if (acao == null)
			acao = "";

		switch (acao) {
			case "Voltar":
				request.getRequestDispatcher("ListarDepartamento").forward(request,response);
				break;
			default:
				Departamento departamentoAntigo;
			try {
				RoteiroVerDepartamento rVerDepartamento = new RoteiroVerDepartamento(request.getParameter("sigla"));
				departamentoAntigo = rVerDepartamento.executar();
				request.setAttribute("departamentoAntigo",departamentoAntigo);
				request.getRequestDispatcher("WEB-INF/VerDepartamento.jsp").forward(request,response);
			} catch (DepartamentoNotFound e) {
				request.setAttribute("erro", "Departamento não existe!");
				request.getRequestDispatcher("WEB-INF/VerDepartamento.jsp").forward(request,response);
			}
		}
	}
}