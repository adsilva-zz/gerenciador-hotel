package sistema.hotel.modelo;

import java.time.LocalDate;

import sistema.hotel.enuns.TipoPromocao;

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
	private TipoPromocao tipo;
	private static int geradorIds;

	public Promocao() {

	}

	public Promocao(String nome, LocalDate dataValidade, TipoPromocao tipo) {
		geradorIds += 1;
		this.idPromocao = geradorIds;
		this.nome = nome;
		this.dataCadastro = LocalDate.now();
		this.dataValidade = dataValidade;
		this.tipo = tipo;
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

	public TipoPromocao getTipo() {
		return tipo;
	}

	public void setTipo(TipoPromocao tipo) {
		this.tipo = tipo;
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
				+ ", dataCadastro=" + dataCadastro + ", tipo=" + tipo + "]";
	}

}
