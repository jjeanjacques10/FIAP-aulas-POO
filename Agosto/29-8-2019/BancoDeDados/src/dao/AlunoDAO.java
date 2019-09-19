package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			System.out.println("Erro ao inserir no banco\n" + e);
			e.printStackTrace();
		}
	}

	public ArrayList<Aluno> listar() {
		ArrayList<Aluno> lista = new ArrayList<Aluno>();
		sql = "SELECT * FROM java_aluno";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				lista.add(new Aluno(rs.getInt("RM"), rs.getString("Nome")));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao selecionar os valores\n" + e);
		}

		return lista;
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
			System.out.println("Erro ao pesquisar no banco\n" + e);
			e.printStackTrace();
		}
		return retorno;
	}
	
	/*Arrumar o Atualizar*/
	public boolean atualicao(int rm , String nome) {
		boolean retorno = false;
		sql = "UPDATE java_aluno SET nome = '?' WHERE rm = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setInt(2, rm);
			ps.execute();
			retorno = true;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar no banco\n" + e);
			e.printStackTrace();
		}
		return retorno;
	}

	public boolean excluir(int rm) {
		boolean retorno = false;
		sql = "DELETE FROM java_aluno WHERE rm=?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, rm);
			ps.execute();
			retorno = true;
		} catch (SQLException e) {
			System.out.println("Erro ao apagar no banco\n" + e);
			e.printStackTrace();
		}
		return retorno;
	}
}
