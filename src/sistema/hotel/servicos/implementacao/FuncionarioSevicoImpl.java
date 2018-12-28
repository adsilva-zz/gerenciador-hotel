package sistema.hotel.servicos.implementacao;

import java.util.List;

import sistema.hotel.enuns.Cargo;
import sistema.hotel.modelo.Funcionario;
import sistema.hotel.repositorio.FuncionarioRepositorio;
import sistema.hotel.repositorio.implementacao.lista.FuncionarioRepositorioImpl;
import sistema.hotel.servicos.FuncionarioServico;
import sistema.hotel.utilitarios.Validacoes;

/**
 * Classe Funcionário Serviço Impl implementa a interface Funcionário Serviço.
 * Possui atributo funcionarioRepositorio para manipular os dados de
 * funcionários.
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public class FuncionarioSevicoImpl implements FuncionarioServico {

	private FuncionarioRepositorio funcionarioRepositorio;

	public FuncionarioSevicoImpl() {
		this.funcionarioRepositorio = new FuncionarioRepositorioImpl();
	}

	/**
	 * Método válida se o funcionário não é nulo e cadastra no sistema.
	 * 
	 * @param funcionario
	 *            a ser cadastrado
	 * @return true se o funcionario for cadastrado com sucesso.
	 * @exception IllegalArgumentException
	 *                se o funcionario for nulo.
	 *
	 */
	@Override
	public boolean cadastrarFuncionario(Funcionario funcionario) {
		if (funcionario == null) {
			throw new IllegalArgumentException("Funcionário inválido.");
		}
		return funcionarioRepositorio.cadastrarFuncionario(funcionario);
	}

	/**
	 * Método verifica se o idFuncionário informado é válido e deleta o funcionario
	 * do sistema.
	 * 
	 * @param idFuncionario
	 *            do funcionario a ser deletado.
	 * @return true se o funcionario for deletado com sucesso.
	 * @exception IllegalArgumentException
	 *                se o funcionario for nulo.
	 */
	@Override
	public boolean deletarFuncionario(int idFuncionario) {
		if (idFuncionario == 0) {
			throw new IllegalArgumentException("Funcionário inválido.");
		}
		return funcionarioRepositorio.deletarFuncionario(idFuncionario);
	}

	/**
	 * Método atualiza um funcionario da lista de funcionarios.
	 * 
	 * @param funcionarioNovo
	 *            com os dados a serem atualizados
	 * @param idFuncionario
	 *            a ser atualizado.
	 * @return true se o funcionario for atualizado com sucesso
	 * @exception IllegalArgumentException
	 *                se o id ou funcionario forem inválidos.
	 */
	@Override
	public boolean atualizarFuncionario(Funcionario funcionarioNovo, int idFuncionario) {
		if (funcionarioNovo == null || idFuncionario == 0) {
			throw new IllegalArgumentException("Funcionário ou ID inválidoS.");
		}
		return funcionarioRepositorio.atualizarFuncionario(funcionarioNovo, idFuncionario);
	}

	/**
	 * Método retorna a lista de funcionários ordenada por cargo em ordem
	 * alfabética.
	 * 
	 * @return listaFuncionarios ordenado.
	 */
	@Override
	public List<Funcionario> getFuncionarios() {
		return funcionarioRepositorio.getFuncionarios();
	}

	/**
	 * Método verifica se o ID é válido e retorna um funcionário de acordo com o id
	 * informado.
	 * 
	 * @param idFuncionario
	 * @return funcionario com o id informado.
	 * @exception IllegalArgumentException
	 *                caso o idFuncionario seja inválido.|
	 */
	@Override
	public Funcionario getFuncionario(int idFuncionario) {
		if (idFuncionario == 0) {
			throw new IllegalArgumentException("ID inválidoS.");
		}
		return funcionarioRepositorio.getFuncionario(idFuncionario);
	}

	/**
	 * Método verifica se a senha e o email são válidos e realiza o logar
	 * 
	 * @param senha
	 *            do funcionario
	 * @param email
	 *            do funcionario
	 * @return funcionario
	 * @exception IllegalArgumentException
	 *                caso a senha ou o email sejam inválidos.
	 */
	@Override
	public Funcionario logar(String senha, String email) {
		if (senha == null || email == null) {
			throw new IllegalArgumentException("Senha ou email inválidos.");
		}
		return funcionarioRepositorio.logar(senha, email);
	}

	/**
	 * Método verifica se os paramentros informados são válidos.
	 * 
	 * @param nome
	 *            do funcionario
	 * @param email
	 *            do funcionario
	 * @param senha
	 *            do funcionario
	 * @param cargo
	 *            do funcionario
	 * @param cpf
	 *            do funcionario
	 * @param salario
	 *            do funcionario
	 * @return true se os parametros forem válidos.
	 */
	@Override
	public boolean validarFuncionario(String nome, String email, String senha, Cargo cargo, String cpf,
			double salario) {
		if (nome == null || "".equals(nome.trim()) || salario < 954.00 || cargo == null) {
			return false;
		}
		if (!Validacoes.validarEmail(email)) {
			return false;
		}
		if (!Validacoes.validarSenha(senha)) {
			return false;
		}
		if (!Validacoes.validarCpf(cpf)) {
			return false;
		}
		return true;
	}
}
