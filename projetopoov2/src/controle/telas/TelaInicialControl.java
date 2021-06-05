package controle.telas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.sistema.Roteador;

public class TelaInicialControl {
	
	private static final String URL ="jdbc:mariadb://localhost:3306/loja";
	private static final String USER ="root";
	private static final String PASSWORD ="";
	
	private List<Roteador> listaDeRoteadores = new ArrayList<>();
	
	public void adicionar(Roteador r) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)){
			String sql = String.format("INSERT INTO roteador(nome, marca, qtdAntenas, preco) values ('%s', '%s', %f, %d)",
					r.getNome(), r.getMarca(), r.getQtdAntenas(), r.getPreco());
			System.out.println("SQL => " + sql);
			PreparedStatement stmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Roteador pesquisarPorNome(String nome) {
		for(Roteador r : listaDeRoteadores) {
			if(r.getNome().contains(nome)) {
				return r;
			}
		}
		return null;
	}
	
	

}
