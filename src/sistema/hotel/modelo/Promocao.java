package sistema.hotel.modelo;

import java.time.LocalDate;

/**
 * Classe Promoção do Hotel
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 */
public class Promocao {

	private int idPromocao;
	private String nome;
	private LocalDate dataValidade;
	private LocalDate dataCadastro;
	private Double valor;
	private static int geradorIds;

	public Promocao() {

	}

	public Promocao(String nome, LocalDate dataValidade, Double valor) {
		geradorIds += 1;
		this.idPromocao = geradorIds;
		this.nome = nome;
		this.dataCadastro = LocalDate.now();
		this.dataValidade = dataValidade;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getIdPromocao() {
		return idPromocao;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return "Promocao [idPromocao=" + idPromocao + ", nome=" + nome + ", dataValidade=" + dataValidade
				+ ", dataCadastro=" + dataCadastro + ", valor=" + valor + "]";
	}

}
