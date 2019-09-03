package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connection.Conexao;
import model.Usuario;

public class UsuarioDAO {
	private Connection connection;
	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;

	public UsuarioDAO() {
		connection = Conexao.getConnection();
	}

	public ArrayList<Usuario> listar() {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		sql = "SELECT * FROM JAVA_USUARIO";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				lista.add(new Usuario(rs.getInt("ID"), rs.getString("EMAIL"), rs.getString("SENHA")));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao selecionar os valores\n" + e);
		}

		return lista;
	}

	public String inserir(Usuario usuario) {
		sql = "INSERT INTO JAVA_USUARIO values(?, ?, ?)";
		
			try {
				ps = connection.prepareStatement(sql);
				ps.setInt(1, usuario.getId());
				ps.setString(2, usuario.getEmail());
				ps.setString(3, usuario.getSenha());
				ps.execute();
			} catch (SQLException e) {
				System.out.println("Erro ao inserir no banco\n" + e);
				e.printStackTrace();
			}
		
		return "Usuario Cadastrado";
	}

	public boolean verificarRm(int id) {
		if (pesquisa(id)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean pesquisa(int id) {
		boolean retorno = false;
		sql = "select * from JAVA_USUARIO WHERE ID = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			retorno = rs.next();
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar no banco\n" + e);
			e.printStackTrace();
		}
		return retorno;
	}

	public boolean logar(String email, String senha) {
		boolean retorno = false;
		ArrayList<Usuario> lista = new ArrayList<Usuario>();

		lista = listar();

		for (Usuario usuario : lista) {
			if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				retorno = true;
			}
		}

		return retorno;
	}
}
