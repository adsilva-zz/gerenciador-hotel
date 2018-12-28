package sistema.hotel.modelo;

/**
 * Classe Cliente do sistema gerenciador de Hotel
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public class Cliente {

	private String nome;
	private int idCliente;
	private String cpf;
	private String email;
	private String senha;
	private String telefone;
	private static int geradorIds;

	public Cliente() {
		
	}
	
	public Cliente(String nome, String cpf, String email, String telefone, String senha) {
		geradorIds += 1;
		this.idCliente = geradorIds;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIdCliente() {
		return idCliente;
	}

	@Override
	public String toString() {
		return "Cliente: " + nome + " CPF: " + cpf;
	}
}
