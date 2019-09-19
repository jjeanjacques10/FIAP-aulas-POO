import java.sql.*;
import java.util.ArrayList;

public class Teste {

	public static <T> void main(String[] args) throws SQLException {
		
		Conexao conexao = new Conexao();
		Statement stmt = conexao.conectar().createStatement();
		
		System.out.println();
		
		ResultSet rows = stmt.executeQuery("SELECT * FROM EMP");
		
		while(rows.next()) {
			System.out.println(rows.getString("NOME"));
		}
		
	}

}
