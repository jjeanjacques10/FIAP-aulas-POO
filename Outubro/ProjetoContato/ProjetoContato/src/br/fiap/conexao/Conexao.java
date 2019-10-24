package br.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Connection connection;
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private static final String USUARIO = "RM81524";
	private static final String SENHA = "101099";

	private Conexao() {
	}

	public static synchronized Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL, USUARIO, SENHA);
			} catch (ClassNotFoundException e) {
				System.out.println("Erro ao carregar o driver de conexão\n" + e);
			} catch (SQLException e) {
				System.out.println("Erro ao estabelecer conexão com o banco de dados\n" + e);
			}
		}
		return connection;
	}
}
