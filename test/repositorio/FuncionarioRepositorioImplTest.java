package repositorio;

import org.junit.Assert;
import org.junit.Test;

import sistema.hotel.enuns.Cargo;
import sistema.hotel.modelo.Funcionario;
import sistema.hotel.repositorio.implementacao.lista.FuncionarioRepositorioImpl;

public class FuncionarioRepositorioImplTest {

	FuncionarioRepositorioImpl funcionarioRepositorio = new FuncionarioRepositorioImpl();

	Funcionario fCamila = new Funcionario("Camila", "ca@gmail.com", "123455", Cargo.GERENTE, "40694765805", 10.000);
	Funcionario fAna = new Funcionario("Ana Julia", "ana@gmail.com", "435323", Cargo.ATENDENTE, "40694965805", 3.000);

	@Test
	public void validarGetFuncionariosOrdemCargo() {
		funcionarioRepositorio.cadastrarFuncionario(fCamila);
		funcionarioRepositorio.cadastrarFuncionario(fAna);
		Assert.assertNotNull(funcionarioRepositorio.getFuncionarios());
		Assert.assertEquals(fAna, funcionarioRepositorio.listaFuncionarios.get(0));
	}
}
