package br.fiap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.fiap.conexao.Conexao;
import br.fiap.entidade.Contato;

public class ContatoDAO {
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	public ContatoDAO() {
		connection = Conexao.getConnection();
	}

	public void cadastrar(Contato contato) {
		sql = "insert into java_contato values (?, ?, ?, ?, ?)";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getEmail());
			ps.setString(3, contato.getEndereco());
			ps.setDate(4, contato.getData());
			ps.setString(5, contato.getGenero());
			ps.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void deletar(String email) {
		sql = "DELETE FROM java_contato WHERE email = ?";
		try {			
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Contato> listar() {
		List<Contato> lista = null;
		sql = "select * from java_contato";

		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			lista = gerarObjeto();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	private List<Contato> gerarObjeto() throws SQLException {
		List<Contato> lista = new ArrayList<Contato>();
		String nome, email, endereco, genero;
		Date data;

		while (rs.next()) {
			nome = rs.getString("nome");
			email = rs.getString("email");
			endereco = rs.getString("endereco");
			genero = rs.getString("genero");
			data = rs.getDate("data");
			lista.add(new Contato(nome, email, endereco, data, genero));
		}

		return lista;
	}
}
