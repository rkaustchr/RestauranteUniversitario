package gateway;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.CPF;
import entidades.Sexo;
import entidades.Titulo;
import persistencia.ConexaoBD;

public class AlunoFinder implements IFinder {
	protected ConexaoBD conexao;
	protected Connection con;
	
	public AlunoFinder() {
		conexao = new ConexaoBD();
	}

	@Override
	public ArrayList<IGateway> findAll() {
		ArrayList<IGateway> gAlunos = new ArrayList<IGateway>();
		String sql = "SELECT * FROM Aluno, Consumidor where cpf = cpfConsumidor;";
		
		con = conexao.abrirConexao();
		if ( con != null ) {
			ResultSet rs = conexao.executarSelectQuery(sql);
			
			if ( rs != null ) {
				try {
					while (rs.next()) {
						CursoFinder gCurso = new CursoFinder();
						gAlunos.add( 
								new AlunoGateway(
										rs.getString("nome"), 
										rs.getInt("matricula"), 
										rs.getString("anoIngresso"), 
										Sexo.valueOf(rs.getString("sexo")), 
										Titulo.valueOf(rs.getString("titulo")),
										new CPF(rs.getString("cpf")),
										gCurso.find(rs.getString("siglaCurso"))
									) 
								);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			conexao.fecharConexao();
		}
		
		return gAlunos;
	}

	@Override
	public IGateway find(String id) {
		String sql = "SELECT * FROM Aluno, Consumidor WHERE cpf='"+ id +"' AND cpf = cpfConsumidor;";
		IGateway gAluno = null; //new AlunoGateway("", 0, "", null, null, null, null);
		
		con = conexao.abrirConexao();
		if ( con != null ) {
			ResultSet rs = conexao.executarSelectQuery(sql);
			if ( rs != null ) {
				try {
					while (rs.next()) {
						CursoFinder gCurso = new CursoFinder();
						gAluno = new AlunoGateway(
								rs.getString("nome"), 
								rs.getInt("matricula"), 
								rs.getString("anoIngresso"), 
								Sexo.valueOf(rs.getString("sexo")), 
								Titulo.valueOf(rs.getString("titulo")),
								new CPF(rs.getString("cpf")),
								gCurso.find(rs.getString("siglaCurso"))
								);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			conexao.fecharConexao();
		}
			
		return gAluno;
	}

}
