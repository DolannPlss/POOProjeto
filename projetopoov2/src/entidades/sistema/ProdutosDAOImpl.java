package entidades.sistema;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAOImpl implements ProdutosDAO{
	
	private static final String URL = "jdbc:mariadb://localhost:3306/loja?allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	@Override
	public void adicionar(Produtos p) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
			String sql = String.format("INSERT INTO produtos(nome, marca, preco, tipo) VALUES (?, ?, ?, ?)");
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getMarca());
			stmt.setDouble(3, p.getPreco());
			stmt.setString(4, p.getTipo()
					);
			int i = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Produtos> pesquisarPorTipo(String tipo) {
		List<Produtos> lista = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
			String sql = "SELECT * FROM produtos WHERE tipo LIKE ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + tipo + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Produtos p = new Produtos();
				p.setId(rs.getLong("id"));
				p.setNome(rs.getString("nome"));
				p.setMarca(rs.getString("marca"));
				p.setPreco(rs.getDouble("preco"));
				p.setTipo(rs.getString("tipo"));
				lista.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void apagarPorId(long id) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)){
				String sql = "DELETE FROM produtos WHERE id = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setLong(1, id);
				int i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(long id, Produtos p) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE produtos SET nome=?, marca=?, preco=?, " +
                    "tipo=? WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getMarca());
			stmt.setDouble(3, p.getPreco());
			stmt.setString(4, p.getTipo());
            stmt.setLong(5, id);
            int i = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
