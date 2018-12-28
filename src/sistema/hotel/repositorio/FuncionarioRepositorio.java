package sistema.hotel.repositorio;

import java.util.List;

import sistema.hotel.modelo.Funcionario;

/**
 * Interface possui os métodos para manipular os dados e regras de negócios
 * referente aos funcionários do sistema.
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public interface FuncionarioRepositorio {

	public boolean cadastrarFuncionario(Funcionario funcionario);

	public boolean deletarFuncionario(int idFuncionario);

	public boolean atualizarFuncionario(Funcionario funcionarioNovo, int idFuncionario);

	public List<Funcionario> getFuncionarios();

	public Funcionario getFuncionario(int idFuncionario);

	public Funcionario logar(String senha, String email);

}
