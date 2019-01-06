package sistema.hotel.repositorio.implementacao.lista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import sistema.hotel.modelo.Reserva;
import sistema.hotel.repositorio.ReservaRepositorio;

/**
 * Classe implementa a interface ReservaRepositorio
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public class ReservaRepositorioImpl implements ReservaRepositorio {

	private List<Reserva> listaReservas;

	public ReservaRepositorioImpl() {
		this.listaReservas = new ArrayList<>();
	}

	/**
	 * Método cadastra uma reserva na lista de reservas.
	 * 
	 * @param reserva
	 *            a ser cadastrada.
	 * @return true se o cadastro for realizado com sucesso.
	 */
	@Override
	public boolean cadastrarReserva(Reserva reserva) {
		return listaReservas.add(reserva);
	}

	/**
	 * Método deleta a reserva da lista de reservas.
	 * 
	 * @param reserva
	 *            a ser deletada.
	 * @return true se a reserva for deletada com sucesso.
	 */
	@Override
	public boolean deletarReserva(int idReserva) {
		Reserva reserva = null;
		for (Reserva r : listaReservas) {
			if (r.getIdReserva() == idReserva) {
				reserva = r;
			}
		}
		return listaReservas.remove(reserva);
	}

	/**
	 * Método atualiza a reserva.
	 * 
	 * @param reserva
	 *            com os dados atuais.
	 * @param id
	 *            da reserva a ser atualizada.
	 * 
	 * @return true se a reserva for atualizada com sucesso.
	 * 
	 */
	@Override
	public boolean atualizarReserva(Reserva reserva, int idReserva) {
		for (Reserva r : listaReservas) {
			if (r.getIdCliente() == idReserva) {
				r.setDataEntrada(reserva.getDataEntrada());
				r.setDataSaida(reserva.getDataSaida());
				r.setIdPromocao(reserva.getIdPromocao());
				r.setIdQuarto(reserva.getIdQuarto());
				r.setValor(reserva.getValor());
				return true;
			}
		}
		return false;
	}

	/**
	 * Método retorna uma lista de reservas cadastradas no sistema.
	 * 
	 * @return lista de reservas.
	 */
	@Override
	public List<Reserva> getReservas() {
		return listaReservas;
	}

	/**
	 * Método retorna uma reserva de acordo com o idReserva informado.
	 * 
	 * @param idReserva
	 * @return reserva localizada.
	 */
	@Override
	public Reserva getReserva(int idReserva) {
		for (Reserva r : listaReservas) {
			if (r.getIdReserva() == idReserva) {
				return r;
			}
		}
		return null;
	}

	@Override
	public boolean verificarDisponibilidade(LocalDate dataEntrada, LocalDate dataSaida, int idQuarto) {
		List<Reserva> lista = new ArrayList<>();
		for (Reserva reserva : listaReservas) {
			if (idQuarto == reserva.getIdQuarto()
					&& (reserva.getDataEntrada().equals(dataEntrada) && reserva.getDataSaida().equals(dataSaida)// Mesmo
							|| dataEntrada.isAfter(reserva.getDataEntrada())
									&& dataSaida.isBefore(reserva.getDataSaida()) // Dentro
							|| dataEntrada.isAfter(reserva.getDataEntrada())
									&& dataSaida.isAfter(reserva.getDataSaida()) // Dentroe
							|| dataEntrada.isBefore(reserva.getDataEntrada())
									&& dataSaida.isBefore(reserva.getDataSaida())
							|| dataEntrada.isAfter(reserva.getDataEntrada())
									&& dataSaida.isEqual(reserva.getDataSaida())
							|| dataSaida.isEqual(reserva.getDataEntrada())
									&& dataEntrada.isBefore(reserva.getDataEntrada()))) {
				return false;
			}
		}
		return true;
	}
}
