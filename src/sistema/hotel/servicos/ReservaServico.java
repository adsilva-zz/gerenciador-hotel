package sistema.hotel.servicos;

import java.time.LocalDate;
import java.util.List;

import sistema.hotel.modelo.Reserva;

/**
 * Interface Reserva Serviço possui métodos para manipular os dados das reservas
 * do sistema.
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public interface ReservaServico {

	public boolean cadastrarReserva(Reserva reserva);

	public boolean deletarReserva(int idReserva);

	public boolean atualizarReserva(Reserva reserva, int idReserva);

	public List<Reserva> getReservas();

	public Reserva getReserva(int idReserva);

	public boolean validarReserva(int idQuarto, int idPromocao, int idCliente, double valor, LocalDate dataEntrada,
			LocalDate dataSaida);

}
