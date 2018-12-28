package sistema.hotel.repositorio.implementacao.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistema.hotel.config.ConnectFactory;
import sistema.hotel.enuns.Cargo;
import sistema.hotel.modelo.Funcionario;
import sistema.hotel.repositorio.FuncionarioRepositorio;

public class FuncionarioRepositorioBDImpl implements FuncionarioRepositorio {

	Connection connection = new ConnectFactory().getConnection();

	@Override
	public boolean cadastrarFuncionario(Funcionario funcionario) {
		String sql = "insert into funcionario" + "(nome,email,senha,cargo,cpf,salario)" + "values(?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getEmail());
			stmt.setString(3, funcionario.getSenha());
			stmt.setString(4, funcionario.getCargo().toString());
			stmt.setString(5, funcionario.getCpf());
			stmt.setDouble(6, funcionario.getSalario());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean deletarFuncionario(int idFuncionario) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from funcionario where id=?");
			stmt.setInt(1, idFuncionario);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean atualizarFuncionario(Funcionario funcionarioNovo, int idFuncionario) {
		String sql = "update funcionario set nome=?, email=?, senha=?, cargo=?, cpf=?, salario=? where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionarioNovo.getNome());
			stmt.setString(2, funcionarioNovo.getEmail());
			stmt.setString(3, funcionarioNovo.getSenha());
			stmt.setString(4, funcionarioNovo.getCargo().toString());
			stmt.setString(5, funcionarioNovo.getCpf());
			stmt.setDouble(6, funcionarioNovo.getSalario());
			stmt.setInt(7, idFuncionario);
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Funcionario> getFuncionarios() {
		try {
			List<Funcionario> listaFuncionarios = new ArrayList<>();
			PreparedStatement stmt = connection.prepareStatement("select * from funcionario");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario f = new Funcionario();
				f.setNome(rs.getString("nome"));
				f.setEmail(rs.getString("email"));
				f.setSenha(rs.getString("senha"));
				f.setCargo(Cargo.valueOf(rs.getString("cargo")));
				f.setCpf(rs.getString("cpf"));
				f.setSalario(rs.getDouble("salario"));

				listaFuncionarios.add(f);
			}
			stmt.close();
			rs.close();
			return listaFuncionarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Funcionario getFuncionario(int idFuncionario) {
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from funcionario where id=?");
			stmt.setInt(1, idFuncionario);
			ResultSet rs = stmt.executeQuery();
			Funcionario f = new Funcionario();
			while (rs.next()) {
				f.setNome(rs.getString("nome"));
				f.setEmail(rs.getString("email"));
				f.setSenha(rs.getString("senha"));
				f.setCargo(Cargo.valueOf(rs.getString("cargo")));
				f.setCpf(rs.getString("cpf"));
				f.setSalario(rs.getDouble("salario"));
			}
			rs.close();
			stmt.close();
			return f;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Funcionario logar(String senha, String email) {
		String sql = "select * from funcionario where email=? and senha=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			Funcionario f = new Funcionario();
			while (rs.next()) {
				f.setNome(rs.getString("nome"));
				f.setEmail(rs.getString("email"));
				f.setSenha(rs.getString("senha"));
				f.setCargo(Cargo.valueOf(rs.getString("cargo")));
				f.setCpf(rs.getString("cpf"));
				f.setSalario(rs.getDouble("salario"));
			}
			rs.close();
			stmt.close();
			return f;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
