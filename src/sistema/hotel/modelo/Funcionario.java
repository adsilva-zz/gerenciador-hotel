package sistema.hotel.modelo;

import sistema.hotel.enuns.Cargo;

/**
 * Classe Funcionário do Sistema Gerenciador do Hotel
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public class Funcionario implements Comparable<Funcionario> {

	private int idFuncionario;
	private String nome;
	private String email;
	private String senha;
	private Cargo cargo;
	private String cpf;
	private double salario;
	private static int geradorId;

	public Funcionario() {
	}

	public Funcionario(String nome, String email, String senha, Cargo cargo, String cpf, double salario) {
		geradorId += 1;
		this.idFuncionario = geradorId;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
		this.cpf = cpf;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getId() {
		return idFuncionario;
	}

	@Override
	public String toString() {
		return "Funcionário: " + nome + " cargo: " + cargo;
	}

	@Override
	public int compareTo(Funcionario f) {
		return this.cargo.compareTo(f.getCargo());
	}
}
