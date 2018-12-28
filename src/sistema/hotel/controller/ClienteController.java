package sistema.hotel.controller;

import java.util.List;

import sistema.hotel.modelo.Cliente;
import sistema.hotel.servicos.ClienteServico;
import sistema.hotel.servicos.implementacao.ClienteServicoImpl;

/**
 * Classe Cliente Controller
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public class ClienteController {

	private ClienteServico clienteServico;

	public ClienteController() {
		clienteServico = new ClienteServicoImpl();
	}

	/**
	 * M�todo cadastra cliente no sistema. Verifica se o cliente � v�lido.
	 * 
	 * @param nome
	 *            do cliente.
	 * @param cpf
	 *            do cliente.
	 * @param email
	 *            do cliente.
	 * @param telefone
	 *            do cliente.
	 * @param senha
	 *            do cliente.
	 * @return true se o cliente for cadastrado com sucesso.
	 */
	public boolean cadastroCliente(String nome, String cpf, String email, String telefone, String senha) {
		boolean validarCliente = clienteServico.validarCliente(nome, cpf, email, telefone, senha);
		if (!validarCliente) {
			return false;
		}

		Cliente cliente = new Cliente(nome, cpf, email, telefone, senha);
		return clienteServico.cadastrarCliente(cliente);
	}

	/**
	 * M�todo atualiza um cliente na lista de clientes do sistema. V�lida se o
	 * idCliente � v�lido e verifica se as informa��es s�o v�lidas.
	 * 
	 * @param idCliente
	 *            do cliente a ser atualizado.
	 * @param nome
	 *            a ser atualizado.
	 * @param cpf
	 *            a ser atualizado.
	 * @param email
	 *            a ser atualizado.
	 * @param telefone
	 *            a ser atualizado.
	 * @return true se o cliente for atualizado com sucesso.
	 */
	public boolean atualizarCliente(int idCliente, String nome, String cpf, String email, String telefone,
			String senha) {
		if (idCliente <= 0) {
			return false;
		}

		boolean validarCliente = clienteServico.validarCliente(nome, cpf, email, telefone, senha);
		if (!validarCliente) {
			return false;
		}

		Cliente clienteNovo = new Cliente(nome, cpf, email, telefone, senha);
		return clienteServico.atualizarCliente(clienteNovo, idCliente);
	}

	/**
	 * M�todo deleta um cliente da lista de cliente
	 * 
	 * @param idCliente
	 *            do cliente a ser deletado
	 * @return true se o cliente for deletado com sucesso.
	 */
	public boolean deletarCliente(int idCliente) {
		if (idCliente <= 0) {
			return false;
		}
		return clienteServico.deletarCliente(idCliente);
	}

	/**
	 * M�todo pega todos os clientes do sistema.
	 * 
	 * @return lista de clientes cadastrados.
	 */
	public List<Cliente> getClientes() {
		return clienteServico.getClientes();
	}

	/**
	 * M�todo verifica se o idCliente informado � v�lido e busca no sistema o
	 * respectivo cliente.
	 * 
	 * @param idCliente
	 *            do cliente
	 * @return cliente com o id igual.
	 */
	public Cliente getCliente(int idCliente) {
		if (idCliente <= 0)
			return null;

		return clienteServico.getCliente(idCliente);
	}

	/**
	 * M�todo verifica se os parametros s�o v�lidos e loga no sistema.
	 * 
	 * @param senha
	 *            do cliente
	 * @param email
	 *            do cliente
	 * @return cliente
	 */
	public Cliente logar(String senha, String email) {
		if (senha == null || email == null) {
			return null;
		}
		return clienteServico.logar(senha, email);
	}
}
