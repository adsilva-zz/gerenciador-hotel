package sistema.hotel.modelo;

import java.time.LocalDate;

/**
 * Classe Reserva do sistema gerenciador de Hotel
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public class Reserva {

	private int idReserva;
	private int idQuarto;
	private int idPromocao;
	private int idCliente;
	private double valor;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private static int geradorIds;

	public Reserva() {

	}

	public Reserva(int idQuarto, int idPromocao, int idCliente, double valor, LocalDate dataEntrada,
			LocalDate dataSaida) {
		geradorIds += 1;
		this.idReserva = geradorIds;
		this.idCliente = idCliente;
		this.idPromocao = idPromocao;
		this.idQuarto = idQuarto;
		this.valor = valor;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public int getIdQuarto() {
		return idQuarto;
	}

	public void setIdQuarto(int idQuarto) {
		this.idQuarto = idQuarto;
	}

	public int getIdPromocao() {
		return idPromocao;
	}

	public void setIdPromocao(int idPromocao) {
		this.idPromocao = idPromocao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

}