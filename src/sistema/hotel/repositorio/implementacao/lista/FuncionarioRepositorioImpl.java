package sistema.hotel.repositorio.implementacao.lista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sistema.hotel.modelo.Funcionario;
import sistema.hotel.repositorio.FuncionarioRepositorio;

/**
 * Classe Funcionário Repositório Impl implementa a interface Funcionário
 * Repositório.
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public class FuncionarioRepositorioImpl implements FuncionarioRepositorio {

	public List<Funcionario> listaFuncionarios;

	public FuncionarioRepositorioImpl() {
		this.listaFuncionarios = new ArrayList<>();
	}

	/**
	 * Método cadastra funcionário na lista de funcionários.
	 * 
	 * @param funcionario
	 *            a ser cadastrado
	 * @return true se o funcionario for cadastrado com sucesso.
	 *
	 */
	@Override
	public boolean cadastrarFuncionario(Funcionario funcionario) {
		return listaFuncionarios.add(funcionario);
	}

	/**
	 * Método deleta um funcionario da lista de funcionario.
	 * 
	 * @param idFuncionario
	 *            do funcionario a ser deletado.
	 * @return true se o funcionario for deletado com sucesso.
	 */
	@Override
	public boolean deletarFuncionario(int idFuncionario) {
		Funcionario encontrado = null;
		for (Funcionario f : listaFuncionarios) {
			if (f.getId() == idFuncionario) {
				encontrado = f;
			}
		}
		return listaFuncionarios.remove(encontrado);
	}

	/**
	 * Método atualiza um funcionario da lista de funcionarios.
	 * 
	 * @param funcionarioNovo
	 *            com os dados a serem atualizados
	 * @param idFuncionario
	 *            a ser atualizado.
	 * @return true se o funcionario for atualizado com sucesso
	 */
	@Override
	public boolean atualizarFuncionario(Funcionario funcionarioNovo, int idFuncionario) {
		for (Funcionario funcionario : listaFuncionarios) {
			if (funcionario.getId() == idFuncionario) {
				funcionario.setCargo(funcionarioNovo.getCargo());
				funcionario.setCpf(funcionarioNovo.getCpf());
				funcionario.setEmail(funcionarioNovo.getEmail());
				funcionario.setNome(funcionarioNovo.getNome());
				funcionario.setSalario(funcionarioNovo.getSalario());
				return true;
			}
		}
		return false;
	}

	/**
	 * Método retorna a lista de funcionários ordenada por cargo em ordem
	 * alfabética.
	 * 
	 * @return listaFuncionarios ordenado.
	 */
	@Override
	public List<Funcionario> getFuncionarios() {
		Collections.sort(listaFuncionarios);
		return Collections.unmodifiableList(listaFuncionarios);
	}

	/**
	 * Método retorna um funcionário de acordo com o id informado.
	 * 
	 * @param idFuncionario
	 * @return funcionario com o id informado.
	 */
	@Override
	public Funcionario getFuncionario(int idFuncionario) {
		for (Funcionario f : listaFuncionarios) {
			if (f.getId() == idFuncionario) {
				return f;
			}
		}
		return null;
	}

	/**
	 * Método procura um funcionário que tenha a mesma senha e email.
	 * 
	 * @param senha
	 *            do funcionario
	 * @param email
	 *            fo funcionario
	 * @return funcionario caso tenha senha e email igual ao dos parametros.
	 */
	@Override
	public Funcionario logar(String senha, String email) {
		for (Funcionario f : listaFuncionarios) {
			if (f.getEmail().equals(email) && f.getSenha().equals(senha)) {
				return f;
			}
		}
		return null;
	}
}
