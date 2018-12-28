package sistema.hotel.servicos;

import java.util.List;

import sistema.hotel.modelo.Cliente;

/**
 * Interface Cliente Serviço possui métodos para manipular os dados dos
 * clientes.
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public interface ClienteServico {

	public boolean cadastrarCliente(Cliente cliente);

	public boolean deletarCliente(int idCliente);

	public boolean atualizarCliente(Cliente clienteNovo, int idCliente);

	public List<Cliente> getClientes();

	public Cliente getCliente(int idCliente);

	public boolean validarCliente(String nome, String cpf, String email, String telefone, String senha);
	
	public Cliente logar(String senha, String email);
}
