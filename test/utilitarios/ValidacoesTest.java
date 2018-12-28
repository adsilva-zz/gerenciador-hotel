package utilitarios;

import org.junit.Assert;
import org.junit.Test;

import sistema.hotel.utilitarios.Validacoes;

public class ValidacoesTest {

	@Test
	public void validarCPFComSucesso() {
		String cpf = "40694765805";
		Assert.assertTrue(Validacoes.validarCpf(cpf));
	}

	@Test
	public void validarCPFComLetras() {
		String cpf = "40694765cv5";
		Assert.assertFalse(Validacoes.validarCpf(cpf));
	}

	@Test
	public void validarCPFInvalido() {
		String cpf = "40694765665";
		String cpfNula = null;
		String cpfMaior = "43343440694765665";
		String cpf0 = "00000000000";
		String cpf1 = "11111111111";
		String cpf2 = "22222222222";
		String cpf3 = "33333333333";
		String cpf4 = "44444444444";
		String cpf5 = "55555555555";
		String cpf6 = "66666666666";
		String cpf7 = "77777777777";
		String cpf8 = "88888888888";
		String cpf9 = "99999999999";
		String cpf10 = "           ";
		Assert.assertNull(cpfNula);
		Assert.assertFalse(Validacoes.validarCpf(cpf));
		Assert.assertFalse(Validacoes.validarCpf(cpfMaior));
		Assert.assertFalse(Validacoes.validarCpf(cpf0));
		Assert.assertFalse(Validacoes.validarCpf(cpf1));
		Assert.assertFalse(Validacoes.validarCpf(cpf2));
		Assert.assertFalse(Validacoes.validarCpf(cpf3));
		Assert.assertFalse(Validacoes.validarCpf(cpf4));
		Assert.assertFalse(Validacoes.validarCpf(cpf5));
		Assert.assertFalse(Validacoes.validarCpf(cpf6));
		Assert.assertFalse(Validacoes.validarCpf(cpf7));
		Assert.assertFalse(Validacoes.validarCpf(cpf8));
		Assert.assertFalse(Validacoes.validarCpf(cpf9));
		Assert.assertFalse(Validacoes.validarCpf(cpf10));
	}

	@Test
	public void validarTelefoneComSucesso() {
		String telefone = "(12)3941-6199";
		Assert.assertTrue(Validacoes.validarTelefone(telefone));
	}
	
	@Test
	public void validarTelefoneComFalha() {
		String telefone = "(12)73941-6199";
		Assert.assertFalse(Validacoes.validarTelefone(telefone));
	}
}
