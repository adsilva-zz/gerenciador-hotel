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
import sistema.hotel.modelo.Reserva;
import sistema.hotel.repositorio.ReservaRepositorio;

public class ReservaRepositorioBDImpl implements ReservaRepositorio {

	Connection connection = new ConnectFactory().getConnection();

	@Override
	public boolean cadastrarReserva(Reserva reserva) {
		String sql = "insert into reserva (valor,dataEntrada,dataSaida,idQuarto,idPromocao,idCliente) values (?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, reserva.getValor());
			stmt.setString(2, reserva.getDataEntrada().toString());
			stmt.setString(3, reserva.getDataSaida().toString());
			stmt.setInt(4, reserva.getIdQuarto());
			stmt.setInt(5, reserva.getIdPromocao());
			stmt.setInt(6, reserva.getIdCliente());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean deletarReserva(int idReserva) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from reserva where id=?");
			stmt.setInt(1, idReserva);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean atualizarReserva(Reserva reserva, int idReserva) {
		String sql = "update reserva set valor=?, dataEntrada=?, dataSaida=?, idQuarto=?, idPromocao=?, idCliente=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDouble(1, reserva.getValor());
			stmt.setString(2, reserva.getDataEntrada().toString());
			stmt.setString(3, reserva.getDataSaida().toString());
			stmt.setInt(4, reserva.getIdQuarto());
			stmt.setInt(5, reserva.getIdPromocao());
			stmt.setInt(6, reserva.getIdCliente());
			stmt.setInt(7, idReserva);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Reserva> getReservas() {
		try {
			List<Reserva> listaReservas = new ArrayList<>();
			PreparedStatement stmt = connection.prepareStatement("select * from reserva");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Reserva reserva = new Reserva();
				reserva.setValor(rs.getDouble("valor"));
				DateTimeFormatter format = DateTimeFormatter.ofPattern("yyy-MM-dd");
				reserva.setDataEntrada(LocalDate.parse(rs.getString("dataEntrada"), format));
				reserva.setDataSaida(LocalDate.parse(rs.getString("dataSaida"), format));
				reserva.setIdQuarto(rs.getInt("idQuarto"));
				reserva.setIdPromocao(rs.getInt("idPromocao"));
				reserva.setIdCliente(rs.getInt("idCliente"));

				listaReservas.add(reserva);
			}
			stmt.close();
			rs.close();
			return listaReservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Reserva getReserva(int idReserva) {
		try {
			Reserva reserva = new Reserva();
			PreparedStatement stmt = connection.prepareStatement("select * from reserva where id=?");
			stmt.setInt(1, idReserva);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				reserva.setValor(rs.getDouble("valor"));
				DateTimeFormatter format = DateTimeFormatter.ofPattern("yyy-MM-dd");
				reserva.setDataEntrada(LocalDate.parse(rs.getString("dataEntrada"), format));
				reserva.setDataSaida(LocalDate.parse(rs.getString("dataSaida"), format));
				reserva.setIdQuarto(rs.getInt("idQuarto"));
				reserva.setIdPromocao(rs.getInt("idPromocao"));
				reserva.setIdCliente(rs.getInt("idCliente"));
			}
			stmt.close();
			rs.close();
			return reserva;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean verificarDisponibilidade(LocalDate dataEntrada, LocalDate dataSaida, int idQuarto) {
		try {
			Reserva reserva = new Reserva();
			PreparedStatement stmt = connection.prepareStatement("select * from reserva where id=?");
			stmt.setInt(1, idReserva);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				reserva.setValor(rs.getDouble("valor"));
				DateTimeFormatter format = DateTimeFormatter.ofPattern("yyy-MM-dd");
				reserva.setDataEntrada(LocalDate.parse(rs.getString("dataEntrada"), format));
				reserva.setDataSaida(LocalDate.parse(rs.getString("dataSaida"), format));
				reserva.setIdQuarto(rs.getInt("idQuarto"));
				reserva.setIdPromocao(rs.getInt("idPromocao"));
				reserva.setIdCliente(rs.getInt("idCliente"));
			}
			stmt.close();
			rs.close();
			return reserva;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return false;
	}
}
