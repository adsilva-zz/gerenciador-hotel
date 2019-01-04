package sistema.hotel.repositorio.implementacao.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import sistema.hotel.config.ConnectFactory;
import sistema.hotel.enuns.TipoPromocao;
import sistema.hotel.modelo.Promocao;
import sistema.hotel.repositorio.PromocaoRepositorio;

public class PromocaoRepositorioBDImpl implements PromocaoRepositorio {

	Connection connection = new ConnectFactory().getConnection();

	@Override
	public boolean cadastrarPromocao(Promocao promocao) {
		String sql = "insert into promocao (nome,dataValidade,dataCadastro) values(?,?,?,)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, promocao.getNome());
			stmt.setString(2, promocao.getDataValidade().toString());
			stmt.setString(3, promocao.getDataCadastro().toString());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean deletarPromocao(int idPromocao) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from promocao where id=?");
			stmt.setInt(1, idPromocao);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean atualizarPromocao(Promocao promocaoNova, int idPromocao) {
		String sql = "update promocao set nome=?, dataValidade=?, dataCadastro=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, promocaoNova.getNome());
			stmt.setString(2, promocaoNova.getDataValidade().toString());
			stmt.setString(3, promocaoNova.getDataCadastro().toString());
			stmt.setInt(5, idPromocao);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Promocao> getPromocoes() {
		try {
			List<Promocao> listaPromocoes = new ArrayList<Promocao>();
			PreparedStatement stmt = connection.prepareStatement("select * from promocao");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Promocao p = new Promocao();
				p.setNome(rs.getString("nome"));
				DateTimeFormatter format = DateTimeFormatter.ofPattern("yyy-MM-dd");
				p.setDataValidade(LocalDate.parse(rs.getString("dataValidade"), format));
				p.setDataCadastro(LocalDate.parse(rs.getString("dataCadastro"), format));

				listaPromocoes.add(p);
			}

			stmt.close();
			rs.close();
			return listaPromocoes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Promocao getPromocao(int idPromocao) {
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from promocao where id=?");
			stmt.setInt(1, idPromocao);
			ResultSet rs = stmt.executeQuery();
			Promocao p = new Promocao();
			while (rs.next()) {
				p.setNome(rs.getString("nome"));
				DateTimeFormatter format = DateTimeFormatter.ofPattern("yyy-MM-dd");
				p.setDataValidade(LocalDate.parse(rs.getString("dataValidade"), format));
				p.setDataCadastro(LocalDate.parse(rs.getString("dataCadastro"), format));
			}

			stmt.close();
			rs.close();
			return p;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
