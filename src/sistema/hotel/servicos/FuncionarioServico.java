package sistema.hotel.servicos;

import java.util.List;

import sistema.hotel.enuns.Cargo;
import sistema.hotel.modelo.Funcionario;

/**
 * Interface Funcionário Serviço possui os métodos para tratar os dados de
 * funcionário no repositório.
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public interface FuncionarioServico {

	public boolean cadastrarFuncionario(Funcionario funcionario);

	public boolean deletarFuncionario(int idFuncionario);

	public boolean atualizarFuncionario(Funcionario funcionarioNovo, int idFuncionario);

	public List<Funcionario> getFuncionarios();

	public Funcionario getFuncionario(int idFuncionario);

	public Funcionario logar(String senha, String email);

	public boolean validarFuncionario(String nome, String email, String senha, Cargo cargo, String cpf, double salario);

}
