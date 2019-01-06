package sistema.hotel.repositorio;

import java.time.LocalDate;
import java.util.List;

import sistema.hotel.modelo.Reserva;

/**
 * Interface possui métodos para tratar os dados no repositório.
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public interface ReservaRepositorio {

	public boolean cadastrarReserva(Reserva reserva);

	public boolean deletarReserva(int idReserva);

	public boolean atualizarReserva(Reserva reserva, int idReserva);

	public List<Reserva> getReservas();

	public Reserva getReserva(int idReserva);

	public boolean verificarDisponibilidade(LocalDate dataEntrada, LocalDate dataSaida, int idQuarto);

}
