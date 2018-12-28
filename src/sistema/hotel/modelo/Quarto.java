package sistema.hotel.modelo;

import sistema.hotel.enuns.Categoria;

/**
 * Classe quarto do sistema gerenciador de Hotel.
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public class Quarto {

	private int idQuarto;
	private int numero;
	private double valor;
	private Categoria categoria;
	// private List<String> itens;
	private static int geradorIds;

	public Quarto() {

	}

	public Quarto(int numero, double valor, Categoria categoria) {
		geradorIds += 1;
		this.idQuarto = geradorIds;
		this.valor = valor;
		this.categoria = categoria;
		this.numero = numero;
		// this.itens = new ArrayList<>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	// public List<String> getItens() {
	// return itens;
	// }
	//
	// public void addItens(String itens) {
	// this.itens.add(itens);
	// }
	//
	// public void setItens(List<String> listaItens) {
	// this.itens = listaItens;
	// }

	public int getIdQuarto() {
		return idQuarto;
	}

	@Override
	public String toString() {
		return "Quarto: " + numero + " categoria: " + categoria;
	}
}
