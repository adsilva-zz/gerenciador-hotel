package sistema.hotel.repositorio.implementacao.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistema.hotel.config.ConnectFactory;
import sistema.hotel.enuns.Categoria;
import sistema.hotel.modelo.Quarto;
import sistema.hotel.repositorio.QuartoRepositorio;

public class QuartoRepositorioBDImpl implements QuartoRepositorio {

	Connection connection = new ConnectFactory().getConnection();

	@Override
	public boolean cadastrarQuarto(Quarto quarto) {
		String sql = "insert into quarto (numero,valor,categoria) values (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, quarto.getNumero());
			stmt.setDouble(2, quarto.getValor());
			stmt.setString(3, quarto.getCategoria().toString());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean deletarQuarto(int idQuarto) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from quarto where id=?");
			stmt.setInt(1, idQuarto);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean atualizarQuarto(Quarto quartoNovo, int idQuarto) {
		String sql = "update quarto set numero=?, valor=?, categoria=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, quartoNovo.getNumero());
			stmt.setDouble(2, quartoNovo.getValor());
			stmt.setString(3, quartoNovo.getCategoria().toString());
			stmt.setInt(4, idQuarto);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Quarto> getQuartos() {
		try {
			List<Quarto> listaQuartos = new ArrayList<>();
			PreparedStatement stmt = connection.prepareStatement("select * from quarto");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Quarto q = new Quarto();
				q.setNumero(rs.getInt("numero"));
				q.setValor(rs.getDouble("valor"));
				q.setCategoria(Categoria.valueOf(rs.getString("categoria")));

				listaQuartos.add(q);
			}
			stmt.close();
			rs.close();
			return listaQuartos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Quarto getQuarto(int idQuarto) {
		try {
			Quarto q = new Quarto();
			PreparedStatement stmt = connection.prepareStatement("select * from quarto where id=?");
			stmt.setInt(1, idQuarto);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				q.setNumero(rs.getInt("numero"));
				q.setValor(rs.getDouble("valor"));
				q.setCategoria(Categoria.valueOf(rs.getString("categoria")));
			}
			stmt.close();
			rs.close();
			return q;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
