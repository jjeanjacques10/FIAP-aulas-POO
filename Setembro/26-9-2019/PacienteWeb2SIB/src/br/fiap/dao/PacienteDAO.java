package br.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.fiap.conexao.Conexao;
import br.fiap.modelo.Paciente;

public class PacienteDAO {
	private Connection connection;
	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public PacienteDAO() {
		connection = Conexao.getConnection();
	}
	
	public boolean cadastrar(Paciente paciente) {
		boolean sucesso = false;
		sql = "INSERT INTO JAVA_PACIENTE values(?, ?, ?)";
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, paciente.getCpf());
			ps.setString(2, paciente.getNome());
			ps.setString(3, paciente.getFone());
			ps.execute();
			sucesso = true;
		} catch (SQLException e) {
			System.out.println("Erro ao inserir no banco\n" + e);
			e.printStackTrace();
		}
		return sucesso;
	}
	
	public List<Paciente> listarPaciente(){
		List<Paciente> lista = new ArrayList<Paciente>();
		
		sql = "SELECT * FROM JAVA_PACIENTE";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new Paciente(rs.getString("cpf"),rs.getString("nome"), rs.getString("fone")));
			}
		}catch(SQLException e) {
			System.out.println("Erro ao buscar os paciente\n" + e);
		}
		
		return lista;
	}
}
