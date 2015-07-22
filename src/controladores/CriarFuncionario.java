package controladores;

import entidades.Departamento;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladores.exceptions.CpfAlreadyExistsException;
import controladores.exceptions.DepartamentoNotFound;
import controladores.exceptions.NomeNotFoundException;
import controladores.exceptions.SiglaNotFoundException;
import roteiros.RoteiroCriarFuncionario;
import roteiros.RoteiroListarDepartamento;

@WebServlet("/CriarFuncionario")
public class CriarFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarFuncionario() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String acao = (String) request.getParameter("acaoCriar");

		try {
			RoteiroListarDepartamento rListarDepartamento = new RoteiroListarDepartamento();
			ArrayList<Departamento> departamentosDisponiveis;
			
			departamentosDisponiveis = rListarDepartamento.executar();
			request.setAttribute("departamentosDisponiveis", departamentosDisponiveis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
		 if (acao != null){
			switch (acao) {
				case "Criar": 
					criarFuncionario(request, response);
					break;
				default:
					//request.getRequestDispatcher("WEB-INF/ListarConsumidor.jsp").forward(request,response);
					response.sendRedirect("ListarConsumidor"); 
			}
		}else{ 
			request.getRequestDispatcher("WEB-INF/CriarFuncionario.jsp").forward(request,response);	
		}
	}
	
	private void criarFuncionario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = (String) request.getParameter("nome");
		int matricula = Integer.parseInt((String)request.getParameter("matricula"));
		String anoIngresso =  (String)request.getParameter("anoIgresso");
		String sexo =  (String)request.getParameter("sexo");
		String titulo =  (String)request.getParameter("titulo");
		String cpf =  (String)request.getParameter("cpf");
		String siglaDepartamento =  (String)request.getParameter("departamento");

		try {
			RoteiroCriarFuncionario rCriarFuncionario = new RoteiroCriarFuncionario(nome, matricula, anoIngresso, sexo, titulo, cpf, siglaDepartamento);
			rCriarFuncionario.execute();
			request.setAttribute("message", "Novo Funcionario criado!");
			request.getRequestDispatcher("ListarConsumidor").forward(request,response);
		} catch (SiglaNotFoundException | NomeNotFoundException e2) {
			request.setAttribute("erro", "Funcionário deve ter CPF");
			request.getRequestDispatcher("WEB-INF/CriarFuncionario.jsp").forward(request,response);
		}catch (DepartamentoNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CpfAlreadyExistsException e) {
			request.setAttribute("erro", "CPF já existe!");
			request.getRequestDispatcher("WEB-INF/CriarFuncionario.jsp").forward(request,response);
		}
	}
}
