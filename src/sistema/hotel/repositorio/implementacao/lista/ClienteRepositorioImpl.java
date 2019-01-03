package sistema.hotel.repositorio.implementacao.lista;

import java.util.ArrayList;
import java.util.List;

import sistema.hotel.modelo.Cliente;
import sistema.hotel.repositorio.ClienteRepositorio;

/**
 * Classe implementa a interface Cliente Repositorio para realizar ações no
 * repositório.
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public class ClienteRepositorioImpl implements ClienteRepositorio {

	private List<Cliente> listaClientes;

	public ClienteRepositorioImpl() {
		this.listaClientes = new ArrayList<>();
	}

	/**
	 * Método cadastra o cliente na lista de clientes do sistema.
	 * 
	 * @param cliente
	 *            a ser cadastrado.
	 * @return true se o cadastro for realizado com sucesso.
	 */
	@Override
	public boolean cadastrarCliente(Cliente cliente) {
		return listaClientes.add(cliente);
	}

	/**
	 * Método remove um cliente da lista de clientes do sistema.
	 * 
	 * @param cliente
	 *            a ser deletado da lista.
	 * @return true se o cliente for removido com sucecsso.
	 */
	@Override
	public boolean deletarCliente(int idCliente) {
		Cliente encontrado = null;
		for (Cliente c : listaClientes) {
			if (c.getIdCliente() == idCliente) {
				encontrado = c;
				break;
			}
		}

		return listaClientes.remove(encontrado);
	}

	/**
	 * Método atualiza um cliente através do id informado.
	 * 
	 * @param idCliente
	 *            a ser atualizado.
	 * @param clienteNovo
	 *            com as atualizações.
	 * @return true se o cliente for atualizado com sucesso.
	 */
	@Override
	public boolean atualizarCliente(Cliente clienteNovo, int idCliente) {
		for (Cliente c : listaClientes) {
			if (c.getIdCliente() == idCliente) {
				c.setCpf(clienteNovo.getCpf());
				c.setEmail(clienteNovo.getEmail());
				c.setNome(clienteNovo.getNome());
				c.setTelefone(clienteNovo.getTelefone());
				return true;
			}
		}
		return false;
	}

	/**
	 * Método retorna a lista de clientes cadastrados no sistema.
	 * 
	 * @return listaClientes
	 */
	@Override
	public List<Cliente> getClientes() {
		List<Cliente> lista = new ArrayList<>();
		lista.addAll(listaClientes);
		return lista;
	}

	/**
	 * Método retorna um cliente de acordo com o ID informado.
	 * 
	 * @param idCliente
	 *            a ser retornado.
	 * @return Cliente com o mesmo idCliente
	 */
	@Override
	public Cliente getCliente(int idCliente) {
		for (Cliente c : listaClientes) {
			if (c.getIdCliente() == idCliente) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Método verifica se a senha e o email é igual a senha e email de um dos
	 * clientes cadastrados no sistema.
	 * 
	 * @param senha
	 *            do cliente
	 * @param email
	 *            do cliente
	 * @return cliente caso tenha o email e a senha igual.
	 */
	@Override
	public Cliente logar(String senha, String email) {
		for (Cliente c : listaClientes) {
			if (c.getEmail().equals(email) && c.getSenha().equals(senha)) {
				return c;
			}
		}
		return null;
	}
}
