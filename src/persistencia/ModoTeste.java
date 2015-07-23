package persistencia;

public class ModoTeste {
	
	public static boolean testeAtivo = false;
	
	public static void prepararBanco () {
		String sql = "Drop table DEPARTAMENTO, CURSO, REFEICAO, CONSUMIDOR, ALUNO, FUNCIONARIO, TICKET, STATUS ";
				
		testeAtivo = true;
		
		ConexaoBD conexao = new ConexaoBD();
		
		if ( conexao.abrirConexao() ) {
			conexao.executarCUDQuery(sql);
			conexao.fecharConexao();
		}
		
		sql = "create table Departamento(sigla varchar(255) PRIMARY KEY NOT NULL, nome VARCHAR(255));"
				+ "create table Curso(sigla varchar(255) PRIMARY KEY NOT NULL, nome varchar(255),  siglaDepartamento varchar(255), FOREIGN KEY (siglaDepartamento) references Departamento(sigla));"
				+ "create table Consumidor(cpf varchar(11) PRIMARY KEY, nome varchar(255), matricula integer, anoIngresso varchar(10), sexo varchar(255), titulo varchar(255));"
				+ "create table Funcionario(cpfConsumidor varchar(11) PRIMARY KEY, siglaDepartamento varchar(255), FOREIGN KEY (siglaDepartamento) references Departamento(sigla),  FOREIGN KEY (cpfConsumidor) references Consumidor(cpf));"
				+ "create table Aluno(cpfConsumidor varchar(11) PRIMARY KEY, siglaCurso varchar(255), FOREIGN KEY (siglaCurso) references Curso(sigla), FOREIGN KEY (cpfConsumidor) references Consumidor(cpf));"
				+ "create table Refeicao(id integer auto_increment PRIMARY KEY, turno varchar(255), descricao varchar(255), opcaoVegan varchar(255));"
				+ "create table Ticket(id integer auto_increment PRIMARY KEY, idRefeicao integer, pago boolean, FOREIGN KEY (idRefeicao) references Refeicao(id), cpfConsumidor varchar(11), FOREIGN KEY (cpfConsumidor) references Consumidor(cpf) );"
				+ "create table status(id int primary key, value varchar(10));"
				+ "insert into status(id, value) values(1, '1')";
	
		
		if ( conexao.abrirConexao() ) {
			conexao.executarCUDQuery(sql);
			conexao.fecharConexao();
		}		
	}	
}