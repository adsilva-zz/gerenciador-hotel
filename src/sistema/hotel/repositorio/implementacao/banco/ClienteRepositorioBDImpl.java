package sistema.hotel.repositorio.implementacao.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistema.hotel.config.ConnectFactory;
import sistema.hotel.modelo.Cliente;
import sistema.hotel.repositorio.ClienteRepositorio;

public class ClienteRepositorioBDImpl implements ClienteRepositorio {

	Connection connection = new ConnectFactory().getConnection();

	@Override
	public boolean cadastrarCliente(Cliente cliente) {
		String sql = "insert into cliente" + "(nome,cpf,email,senha,telefone)" + " values(?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getSenha());
			stmt.setString(5, cliente.getTelefone());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean deletarCliente(int idCliente) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from cliente where id=?");
			stmt.setInt(1, idCliente);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean atualizarCliente(Cliente clienteNovo, int idCliente) {
		String sql = "update cliente set nome=?, cpf=?, email=?, senha=?, telefone=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, clienteNovo.getNome());
			stmt.setString(2, clienteNovo.getCpf());
			stmt.setString(3, clienteNovo.getEmail());
			stmt.setString(4, clienteNovo.getSenha());
			stmt.setString(5, clienteNovo.getTelefone());
			stmt.setInt(6, idCliente);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Cliente> getClientes() {
		try {
			List<Cliente> listaClientes = new ArrayList<>();
			PreparedStatement stmt = connection.prepareStatement("select * from cliente");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Cliente c = new Cliente();
				c.setNome(rs.getString("nome"));
				c.setCpf(rs.getString("cpf"));
				c.setEmail(rs.getString("email"));
				c.setSenha(rs.getString("senha"));
				c.setTelefone(rs.getString("telefone"));

				listaClientes.add(c);
			}
			stmt.close();
			return listaClientes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public Cliente getCliente(int idCliente) {
		String sql = "select * from cliente where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, idCliente);
			ResultSet rs = stmt.executeQuery();
			Cliente c = new Cliente();
			while (rs.next()) {
				c.setNome(rs.getString("nome"));
				c.setCpf(rs.getString("cpf"));
				c.setEmail(rs.getString("email"));
				c.setSenha(rs.getString("senha"));
				c.setTelefone(rs.getString("telefone"));
			}
			rs.close();
			stmt.close();
			return c;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public Cliente logar(String senha, String email) {
		String sql = "select * from cliente where email=? and senha=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			Cliente c = new Cliente();
			while (rs.next()) {
				c.setNome(rs.getString("nome"));
				c.setCpf(rs.getString("cpf"));
				c.setEmail(rs.getString("email"));
				c.setSenha(rs.getString("senha"));
				c.setTelefone(rs.getString("telefone"));

			}
			rs.close();
			stmt.close();
			return c;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
