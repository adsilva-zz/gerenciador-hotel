package sistema.hotel.servicos.implementacao;

import java.util.List;

import sistema.hotel.modelo.Cliente;
import sistema.hotel.repositorio.ClienteRepositorio;
import sistema.hotel.repositorio.implementacao.lista.ClienteRepositorioImpl;
import sistema.hotel.servicos.ClienteServico;
import sistema.hotel.utilitarios.Validacoes;

/**
 * Classe Cliente Servi�o Impl implementa a interface Cliente Servi�o. Utiliza o
 * atributo clienteRepositorio para manipular os dados do cliente na lista de
 * cliente do sistema.
 * 
 * @author Amanda da Silva Ito.
 * 
 * @version 1.0
 *
 */
public class ClienteServicoImpl implements ClienteServico {

	private ClienteRepositorio clienteRepositorio;

	public ClienteServicoImpl() {
		this.clienteRepositorio = new ClienteRepositorioImpl();
	}

	/**
	 * M�todo verifica se um cliente � v�lido e cadastra o cliente no sistema.
	 * 
	 * @param cliente
	 *            a ser cadastrado.
	 * @return true se o cadastro for realizado com sucesso.
	 * @exception IllegalArgumentException
	 *                caso o cliente seja inv�lido.
	 */
	@Override
	public boolean cadastrarCliente(Cliente cliente) {
		if (cliente == null) {
			throw new IllegalArgumentException("Cliente inv�lido.");
		}
		return clienteRepositorio.cadastrarCliente(cliente);
	}

	/**
	 * M�todo remove um cliente da lista de clientes do sistema.
	 * 
	 * @param cliente
	 *            a ser deletado da lista.
	 * @return true se o cliente for removido com sucecsso.
	 * @exception IllegalArgumentException
	 *                caso o cliente seja inv�lido.
	 */
	@Override
	public boolean deletarCliente(int idCliente) {
		if (idCliente <= 0) {
			throw new IllegalArgumentException("Cliente inv�lido.");
		}
		return clienteRepositorio.deletarCliente(idCliente);
	}

	/**
	 * M�todo verifica se o cliente e o ID do cliente a ser atualizado s�o v�lidos e
	 * atualiza um cliente atrav�s do id informado.
	 * 
	 * @param idCliente
	 *            a ser atualizado.
	 * @param clienteNovo
	 *            com as atualiza��es.
	 * @return true se o cliente for atualizado com sucesso.
	 * @exception IllegalArgumentException
	 *                caso o idCliente ou clienteNovo sejam inv�lidos.
	 */
	@Override
	public boolean atualizarCliente(Cliente clienteNovo, int idCliente) {
		if (clienteNovo == null || idCliente == 0) {
			throw new IllegalArgumentException("Cliente ou ID inv�lidos.");
		}
		return clienteRepositorio.atualizarCliente(clienteNovo, idCliente);
	}

	/**
	 * M�todo retorna a lista de clientes cadastrados no sistema.
	 * 
	 * @return listaClientes
	 */
	@Override
	public List<Cliente> getClientes() {
		return clienteRepositorio.getClientes();
	}

	/**
	 * M�todo retorna um cliente de acordo com o ID informado.
	 * 
	 * @param idCliente
	 *            a ser retornado.
	 * @return Cliente com o mesmo idCliente
	 * @exception IllegalArgumentException
	 *                caso o ID seja inv�lido.
	 */
	@Override
	public Cliente getCliente(int idCliente) {
		if (idCliente == 0) {
			throw new IllegalArgumentException("ID inv�lido.");
		}
		return clienteRepositorio.getCliente(idCliente);
	}

	/**
	 * M�todo verifica se os paramentros informados s�o v�lidos.
	 */
	@Override
	public boolean validarCliente(String nome, String cpf, String email, String telefone, String senha) {
		if (nome == null || "".equals(nome.trim())) {
			return false;
		}
		if (!Validacoes.validarCpf(cpf)) {
			return false;
		}
		if (!Validacoes.validarEmail(email)) {
			return false;
		}

		if (!Validacoes.validarSenha(senha)) {
			return false;
		}

		if (!Validacoes.validarTelefone(telefone)) {
			return false;
		}
		return true;
	}

	/**
	 * M�todo logar verifica os parametros e realiza o logar
	 * 
	 * @param senha
	 *            do cliente
	 * @param email
	 *            do cliente
	 * @return cliente
	 * @exception caso
	 *                os paramentros sejam nulos.
	 */
	@Override
	public Cliente logar(String senha, String email) {
		if (senha == null || email == null) {
			throw new IllegalArgumentException("Email ou senha inv�lidos.");
		}
		return clienteRepositorio.logar(senha, email);
	}
}
