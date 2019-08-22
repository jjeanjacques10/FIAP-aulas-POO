import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	Connection connection = null;
	String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	String user = "***";
	String password = "***";
	
	public Connection conectar() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, user, password);
		}catch (ClassNotFoundException ex) {
			System.out.println("Erro ao carregar o driver \n" + ex);
		} catch (SQLException e) {
			System.out.println("Erro ao tentar conectar \n" + e);
		}
		
		
		return connection;
	}
}
