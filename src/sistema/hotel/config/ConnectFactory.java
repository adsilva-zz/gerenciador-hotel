package sistema.hotel.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectFactory {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemahotel", "root", "programas");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
