package persistencia;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBStatus
 */
@WebServlet("/DBStatus")
public class DBStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ConexaoBD conexao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBStatus() {
        super();
        conexao = new ConexaoBD();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			conectar(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/DBStatus.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		resetDB();
		doGet(request, response);
	}
	
	private void resetDB() {
		Connection con;
        String sql = "DROP TABLE STATUS, ALUNO, FUNCIONARIO, TICKET, REFEICAO, CURSO, DEPARTAMENTO, CONSUMIDOR;";
        
        con = conexao.abrirConexao();
		if ( con != null ) {
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("Erro ao resetar Banco!");
			}
			
			conexao.fecharConexao();
		}
		
	}

	public void conectar( HttpServletRequest request, HttpServletResponse response ) throws ClassNotFoundException, SQLException, ServletException, IOException {
		Connection con ;
        String status = "ERRO!";
        int res;
        String sql = "Update status set value = '1' where id = 1";
        
        con = conexao.abrirConexao();
		if ( con != null ) {
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				res = stmt.executeUpdate();
				status = "Ok!";
			} catch (SQLException e) {
				res = 0;
				status = "Banco de dados não existia!<br/>";
				status += "Tentando criar as tabelas do banco de dados...<br/>";
				
				sql = "create table Departamento(sigla varchar(255) PRIMARY KEY NOT NULL, nome VARCHAR(255));"
						+ "create table Curso(sigla varchar(255) PRIMARY KEY NOT NULL, nome varchar(255),  siglaDepartamento varchar(255), FOREIGN KEY (siglaDepartamento) references Departamento(sigla));"
						+ "create table Consumidor(cpf varchar(11) PRIMARY KEY, nome varchar(255), matricula integer, anoIngresso varchar(10), sexo varchar(255), titulo varchar(255));"
						+ "create table Funcionario(cpfConsumidor varchar(11) PRIMARY KEY, siglaDepartamento varchar(255), FOREIGN KEY (siglaDepartamento) references Departamento(sigla),  FOREIGN KEY (cpfConsumidor) references Consumidor(cpf));"
						+ "create table Aluno(cpfConsumidor varchar(11) PRIMARY KEY, siglaCurso varchar(255), FOREIGN KEY (siglaCurso) references Curso(sigla), FOREIGN KEY (cpfConsumidor) references Consumidor(cpf));"
						+ "create table Refeicao(id integer auto_increment PRIMARY KEY, turno varchar(255), descricao varchar(255), opcaoVegan varchar(255));"
						+ "create table Ticket(id integer auto_increment PRIMARY KEY, idRefeicao integer, pago boolean, FOREIGN KEY (idRefeicao) references Refeicao(id), cpfConsumidor varchar(11), FOREIGN KEY (cpfConsumidor) references Consumidor(cpf) );"
						+ "create table status(id int primary key, value varchar(10));"
						+ "insert into status(id, value) values(1, '1');";
				con.createStatement().execute(sql);
				
				status += "Tabelas criadas com sucesso!";
			}
			
			conexao.fecharConexao();
		}
        
        request.setAttribute("dbstatus", status);
        //request.getRequestDispatcher("WEB-INF/DBStatus.jsp").forward(request,response);
	}

}
