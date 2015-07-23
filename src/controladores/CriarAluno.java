package controladores;

import entidades.CPF;
import entidades.Curso;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.Integer;
import controladores.exceptions.CpfAlreadyExistsException;
import controladores.exceptions.CursoNotFound;
import controladores.exceptions.NomeNotFoundException;
import controladores.exceptions.SiglaNotFoundException;
import roteiros.RoteiroCriarAluno;
import roteiros.RoteiroListarCurso;

@WebServlet("/CriarAluno")
public class CriarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CriarAluno(){
		super();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String acao = (String) request.getParameter("acaoCriar");
		
		try {
			RoteiroListarCurso rListarCurso = new RoteiroListarCurso();
			ArrayList<Curso> cursosDisponiveis;
			
			cursosDisponiveis = rListarCurso.executar();
			request.setAttribute("cursosDisponiveis", cursosDisponiveis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		 if (acao != null){
			switch (acao) {
				case "Criar": 
					criarAluno(request, response);
					break;
				default:
					//request.getRequestDispatcher("WEB-INF/ListarConsumidor.jsp").forward(request,response);
					response.sendRedirect("ListarConsumidor"); 
			}
		}else{ 
			request.getRequestDispatcher("WEB-INF/CriarAluno.jsp").forward(request,response);	
		}
	}
	
	private void criarAluno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = (String) request.getParameter("nome");
		int matricula = Integer.parseInt((String) request.getParameter("matricula"));
		String anoIngresso =  (String)request.getParameter("anoIgresso");
		String sexo =  (String)request.getParameter("sexo");
		String titulo =  (String)request.getParameter("titulo");
		String cpf =  (String)request.getParameter("cpf");
		String siglaCurso =  (String)request.getParameter("curso");

		CPF testeCPF = new CPF(cpf);
		if ( testeCPF.isCpfValido() == false ) {
			request.setAttribute("erro", "Deve ser informado um CPF válido!");
			request.getRequestDispatcher("WEB-INF/CriarAluno.jsp").forward(request,response);
			return;
		}
		
		try {
			RoteiroCriarAluno rCriarAluno = new RoteiroCriarAluno(nome, matricula, anoIngresso, sexo, titulo, cpf, siglaCurso);
			rCriarAluno.executar();
			request.setAttribute("message", "Novo Aluno criado!");
			request.getRequestDispatcher("ListarConsumidor").forward(request,response);
		} catch (SiglaNotFoundException | NomeNotFoundException e2) {
			request.setAttribute("erro", "Um curso deve conter um nome, uma sigla e um departamento");
			request.getRequestDispatcher("WEB-INF/CriarAluno.jsp").forward(request,response);
		}catch (CursoNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CpfAlreadyExistsException e) {
			request.setAttribute("erro", "CPF já existe!");
			request.getRequestDispatcher("WEB-INF/CriarAluno.jsp").forward(request,response);
		}
	}
}
