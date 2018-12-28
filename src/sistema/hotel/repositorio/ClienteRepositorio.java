package sistema.hotel.repositorio;

import java.util.List;

import sistema.hotel.modelo.Cliente;

/**
 * Interface Cliente Repositorio possui métodos para tratar os dados dos
 * clientes no repositório.
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public interface ClienteRepositorio {

	public boolean cadastrarCliente(Cliente cliente);

	public boolean deletarCliente(int idCliente);

	public boolean atualizarCliente(Cliente clienteNovo, int idCliente);

	public List<Cliente> getClientes();

	public Cliente getCliente(int idCliente);

	public Cliente logar(String senha, String email);

}
