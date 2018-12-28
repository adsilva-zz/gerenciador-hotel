package sistema.hotel.controller;

import java.util.List;

import sistema.hotel.enuns.Cargo;
import sistema.hotel.modelo.Funcionario;
import sistema.hotel.servicos.FuncionarioServico;
import sistema.hotel.servicos.implementacao.FuncionarioSevicoImpl;

/**
 * Classe Funcionário Controller
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public class FuncionarioController {

	private FuncionarioServico funcionarioServico;

	public FuncionarioController() {
		funcionarioServico = new FuncionarioSevicoImpl();
	}

	/**
	 * Método verifica se os parametros informados são válidos e cadastra
	 * funcionario no sistema.
	 * 
	 * @param nome
	 *            do funcionario
	 * @param email
	 *            nome do funcionario
	 * @param senha
	 *            nome do funcionario
	 * @param cargo
	 *            nome do funcionario
	 * @param cpf
	 *            nome do funcionario
	 * @param salario
	 *            nome do funcionario
	 * @return true se o cadastro for realizado com sucesso.
	 */
	public boolean cadastrarFuncionario(String nome, String email, String senha, Cargo cargo, String cpf,
			double salario) {
		if (!funcionarioServico.validarFuncionario(nome, email, senha, cargo, cpf, salario)) {
			return false;
		}
		Funcionario funcionario = new Funcionario(nome, email, senha, cargo, cpf, salario);
		return funcionarioServico.cadastrarFuncionario(funcionario);
	}

	/**
	 * Método verifica se os parametros informados são válidos e atualiza o
	 * funcionario no sistema.
	 * 
	 * @param nome
	 *            do funcionario
	 * @param email
	 *            nome do funcionario
	 * @param senha
	 *            nome do funcionario
	 * @param cargo
	 *            nome do funcionario
	 * @param cpf
	 *            nome do funcionario
	 * @param salario
	 *            nome do funcionario
	 * @return true se a atualização for realizada com sucesso.
	 */
	public boolean atualizarFuncionario(int idFuncionario, String nome, String email, String senha, Cargo cargo,
			String cpf, double salario) {
		if (idFuncionario <= 0) {
			return false;
		}
		if (!funcionarioServico.validarFuncionario(nome, email, senha, cargo, cpf, salario)) {
			return false;
		}
		Funcionario funcionario = new Funcionario(nome, email, senha, cargo, cpf, salario);
		return funcionarioServico.atualizarFuncionario(funcionario, idFuncionario);
	}

	/**
	 * Método verifica se o id informado é válido e deleta o respectivo funcionário
	 * do sistema.
	 * 
	 * @param idFuncionario
	 *            do funcionario
	 * @return true se o funcionario for deletado com sucesso.
	 */
	public boolean deletarFuncionario(int idFuncionario) {
		if (idFuncionario <= 0) {
			return false;
		}
		return funcionarioServico.deletarFuncionario(idFuncionario);
	}

	/**
	 * Método pega todos os funcionarios cadastrados no sistema.
	 * 
	 * @return lista de funcionarios ordenados por cargo.
	 */
	public List<Funcionario> getFuncionarios() {
		return funcionarioServico.getFuncionarios();
	}

	/**
	 * Método verifica se o id informado é válido e retorna o respectivo
	 * funcionário.
	 * 
	 * @param idFuncionario
	 *            do funcionario.
	 * @return funcionário se ele existir no sistema.
	 */
	public Funcionario getFuncionario(int idFuncionario) {
		if (idFuncionario <= 0) {
			return null;
		}
		return funcionarioServico.getFuncionario(idFuncionario);
	}

	/**
	 * Método verifica se a senha e o email são válidos e realiza o logar
	 * 
	 * @param senha
	 *            do funcionario
	 * @param email
	 *            do funcionario
	 * @return funcionario
	 */
	public Funcionario logar(String senha, String email) {
		if (senha == null || email == null) {
			return null;
		}
		return funcionarioServico.logar(senha, email);
	}
}
