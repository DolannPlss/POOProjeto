package banco.dados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteBD {
	
	public static final String URL ="jdbc:mariadb://localhost:3306/loja";
	public static final String USER ="root";
	public static final String PASSWORD ="";
	

	public static void main(String[] args) {
		System.out.println("Teste banco de dados");
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Driver carregado na memória");
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conectado no banco de dados");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
