package persistencia;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBStatus() {
        super();
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void conectar( HttpServletRequest request, HttpServletResponse response ) throws ClassNotFoundException, SQLException, ServletException, IOException {
		Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:file:~/restaurante", "admin", "admin");
        
        String status;
        
        String sql = "Update status set value = '1' where id = 1";
        try {
			conn.createStatement().execute(sql);
			status = "Ok!";
		} catch (SQLException e) {
			status = "Banco de dados não existia!<br/>";
			status += "Tentando criar as tabelas do banco de dados...<br/>";
			
			sql = 
					"CREATE TABLE Departamento(sigla varchar(255) PRIMARY KEY NOT NULL, nome VARCHAR(255));"
					+ "create table Curso(sigla varchar(255) PRIMARY KEY NOT NULL, nome varchar(255),  siglaDepartamento varchar(255), FOREIGN KEY (siglaDepartamento) references Departamento(sigla));"
					+ "create table Consumidor(cpf varchar(11) PRIMARY KEY, nome varchar(255), matricula integer, anoIngresso date, sexo varchar(255), titulo varchar(255));"
					+ "create table Funcionario(cpfConsumidor varchar(11) PRIMARY KEY, siglaDepartamento varchar(255), FOREIGN KEY (siglaDepartamento) references Departamento(sigla),  FOREIGN KEY (cpfConsumidor) references Consumidor(cpf));"
					+ "create table Aluno(cpfConsumidor varchar(11) PRIMARY KEY, siglaCurso varchar(255), FOREIGN KEY (siglaCurso) references Curso(sigla), FOREIGN KEY (cpfConsumidor) references Consumidor(cpf));"
					+ "create table Refeicao(id integer auto_increment PRIMARY KEY, turno varchar(255), descricao varchar(255), opcaoVegan varchar(255));"
					+ "create table Ticket(id integer auto_increment PRIMARY KEY, idRefeicao integer, pago boolean, FOREIGN KEY (idRefeicao) references Refeicao(id), cpfConsumidor varchar(11), FOREIGN KEY (cpfConsumidor) references Consumidor(cpf) );"
					+ "create table status(id int primary key, value varchar(10));"
					+ "insert into status(id, value) values(1, '1');";
			conn.createStatement().execute(sql);
			
			status += "Tabelas criadas com sucesso!";
		}
        //conn.createStatement().executeQuery(sql);
        conn.close();
        
        request.setAttribute("dbstatus", status);
        //request.getRequestDispatcher("WEB-INF/DBStatus.jsp").forward(request,response);
	}

}
