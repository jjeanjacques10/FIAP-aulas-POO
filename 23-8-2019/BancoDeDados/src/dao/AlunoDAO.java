package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import modelo.Aluno;

public class AlunoDAO {
	private Connection connection;
	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public AlunoDAO() {
		connection = Conexao.getConnection();
	}
	public void inserir(Aluno aluno) {
		sql = "INSERT INTO java_aluno values(?, ?)";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, aluno.getRm());
			ps.setString(2, aluno.getNome());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir no banco\n"+e);
			e.printStackTrace();
		}
	}

	public boolean pesquisa(int rm) {
		boolean retorno = false;
		sql = "select * from java_aluno where rm = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, rm);
			rs = ps.executeQuery();
			retorno = rs.next();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir no banco\n"+e);
			e.printStackTrace();
		}
		return retorno;
	}
}
