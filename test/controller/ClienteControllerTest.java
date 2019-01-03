package controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sistema.hotel.controller.ClienteController;

public class ClienteControllerTest {

	private ClienteController controller;
	String nome = "Amanda da Silva Ito";
	String cpf = "40694765805";
	String email = "test@eisi.com";
	String telefone = "(12)98127-6795";
	String senha = "324543";

	@Before
	public void inicializacao() {
		controller = new ClienteController();
	}

	@Test
	public void validarCadastroClienteSucesso() {
		boolean cadastroCliente = controller.cadastroCliente(nome, cpf, email, telefone, senha);
		Assert.assertTrue(cadastroCliente);
	}

	@Test
	public void validarCadastroClienteFalhaComTelefoneInvalido() {
		String telefone = null;
		boolean cadastroCliente = controller.cadastroCliente(nome, cpf, email, telefone, senha);
		Assert.assertFalse(cadastroCliente);
	}

	@Test
	public void validarCadastroClienteFalhaComEmailInvalido() {
		String email = "test@.eisi.";
		boolean cadastroCliente = controller.cadastroCliente(nome, cpf, email, telefone, senha);
		Assert.assertFalse(cadastroCliente);
	}

	@Test
	public void validarCadastroClienteFalhaComCPFInvalido() {
		String cpf = "40694765824";
		boolean cadastroCliente = controller.cadastroCliente(nome, cpf, email, telefone, senha);
		Assert.assertFalse(cadastroCliente);
	}

}
