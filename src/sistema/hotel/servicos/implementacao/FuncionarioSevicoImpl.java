package sistema.hotel.servicos.implementacao;

import java.util.List;

import sistema.hotel.enuns.Cargo;
import sistema.hotel.modelo.Funcionario;
import sistema.hotel.repositorio.FuncionarioRepositorio;
import sistema.hotel.repositorio.implementacao.lista.FuncionarioRepositorioImpl;
import sistema.hotel.servicos.FuncionarioServico;
import sistema.hotel.utilitarios.Validacoes;

/**
 * Classe Funcion�rio Servi�o Impl implementa a interface Funcion�rio Servi�o.
 * Possui atributo funcionarioRepositorio para manipular os dados de
 * funcion�rios.
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
	 * M�todo v�lida se o funcion�rio n�o � nulo e cadastra no sistema.
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
			throw new IllegalArgumentException("Funcion�rio inv�lido.");
		}
		return funcionarioRepositorio.cadastrarFuncionario(funcionario);
	}

	/**
	 * M�todo verifica se o idFuncion�rio informado � v�lido e deleta o funcionario
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
			throw new IllegalArgumentException("Funcion�rio inv�lido.");
		}
		return funcionarioRepositorio.deletarFuncionario(idFuncionario);
	}

	/**
	 * M�todo atualiza um funcionario da lista de funcionarios.
	 * 
	 * @param funcionarioNovo
	 *            com os dados a serem atualizados
	 * @param idFuncionario
	 *            a ser atualizado.
	 * @return true se o funcionario for atualizado com sucesso
	 * @exception IllegalArgumentException
	 *                se o id ou funcionario forem inv�lidos.
	 */
	@Override
	public boolean atualizarFuncionario(Funcionario funcionarioNovo, int idFuncionario) {
		if (funcionarioNovo == null || idFuncionario == 0) {
			throw new IllegalArgumentException("Funcion�rio ou ID inv�lidoS.");
		}
		return funcionarioRepositorio.atualizarFuncionario(funcionarioNovo, idFuncionario);
	}

	/**
	 * M�todo retorna a lista de funcion�rios ordenada por cargo em ordem
	 * alfab�tica.
	 * 
	 * @return listaFuncionarios ordenado.
	 */
	@Override
	public List<Funcionario> getFuncionarios() {
		return funcionarioRepositorio.getFuncionarios();
	}

	/**
	 * M�todo verifica se o ID � v�lido e retorna um funcion�rio de acordo com o id
	 * informado.
	 * 
	 * @param idFuncionario
	 * @return funcionario com o id informado.
	 * @exception IllegalArgumentException
	 *                caso o idFuncionario seja inv�lido.|
	 */
	@Override
	public Funcionario getFuncionario(int idFuncionario) {
		if (idFuncionario == 0) {
			throw new IllegalArgumentException("ID inv�lidoS.");
		}
		return funcionarioRepositorio.getFuncionario(idFuncionario);
	}

	/**
	 * M�todo verifica se a senha e o email s�o v�lidos e realiza o logar
	 * 
	 * @param senha
	 *            do funcionario
	 * @param email
	 *            do funcionario
	 * @return funcionario
	 * @exception IllegalArgumentException
	 *                caso a senha ou o email sejam inv�lidos.
	 */
	@Override
	public Funcionario logar(String senha, String email) {
		if (senha == null || email == null) {
			throw new IllegalArgumentException("Senha ou email inv�lidos.");
		}
		return funcionarioRepositorio.logar(senha, email);
	}

	/**
	 * M�todo verifica se os paramentros informados s�o v�lidos.
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
	 * @return true se os parametros forem v�lidos.
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
