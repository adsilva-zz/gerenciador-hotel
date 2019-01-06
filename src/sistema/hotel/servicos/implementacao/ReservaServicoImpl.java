package sistema.hotel.servicos.implementacao;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import sistema.hotel.modelo.Reserva;
import sistema.hotel.repositorio.ReservaRepositorio;
import sistema.hotel.repositorio.implementacao.lista.ReservaRepositorioImpl;
import sistema.hotel.servicos.ReservaServico;
import sistema.hotel.utilitarios.Validacoes;

public class ReservaServicoImpl implements ReservaServico {

	private ReservaRepositorio reservaRepositorio;

	public ReservaServicoImpl() {
		this.reservaRepositorio = new ReservaRepositorioImpl();
	}

	/**
	 * M�todo verifica se a reserva � valida e cadastra no sistema.
	 * 
	 * @param reserva
	 *            a ser cadastrada.
	 * @return true se o cadastro for realizado com sucesso.
	 * @exception IllegalArgumentException
	 *                caso a reserva seja inv�lida.
	 */
	@Override
	public boolean cadastrarReserva(Reserva reserva) {
		if (reserva == null) {
			throw new IllegalArgumentException("Reserva inv�lida.");
		}
		return reservaRepositorio.cadastrarReserva(reserva);
	}

	/**
	 * M�todo verifica se a reserva n�o � nula e deleta a reserva do sistema.
	 * 
	 * @param reserva
	 *            a ser deletada.
	 * @return true se a reserva for deletada com sucesso.
	 */
	@Override
	public boolean deletarReserva(int idReserva) {
		if (idReserva <= 0) {
			throw new IllegalArgumentException("Reserva inv�lida.");
		}
		return reservaRepositorio.deletarReserva(idReserva);
	}

	/**
	 * M�todo verifica se o ID e a reserva informados s�o v�lidos e realiza a
	 * atualiza��o da reserva.
	 * 
	 * @param reserva
	 *            com dados atuais
	 * @param id
	 *            da reserva a ser atualizada.
	 * @return true se a reserva for atualizada.
	 */
	@Override
	public boolean atualizarReserva(Reserva reserva, int idReserva) {
		if (idReserva == 0 || reserva == null) {
			throw new IllegalArgumentException("ID ou reserva inv�lidos.");
		}
		return reservaRepositorio.atualizarReserva(reserva, idReserva);
	}

	/**
	 * M�todo retorna as reservas cadastradas no sistema.
	 * 
	 * @return lista de reservas.
	 */
	@Override
	public List<Reserva> getReservas() {
		return reservaRepositorio.getReservas();
	}

	/**
	 * M�todo verifica se o id informado � v�lido e retorna a reserva
	 * correspondente.
	 * 
	 * @param id
	 *            da reserva
	 * @return reserva.
	 * @exception IllegalArgumentException
	 *                caso o id seja inv�lido.
	 */
	@Override
	public Reserva getReserva(int idReserva) {
		if (idReserva == 0) {
			throw new IllegalArgumentException("ID inv�lido.");
		}
		return reservaRepositorio.getReserva(idReserva);
	}

	/**
	 * M�todo verifica se os parametros informados s�o v�lidos.
	 * 
	 * @param idQuarto
	 *            do quarto a ser reservado
	 * @param idPromocao
	 * @param idCliente
	 *            que est� reservando o quarto
	 * @param valor
	 *            da reserva
	 * @param dataEntrada
	 * @param dataSaida
	 * @return true se o paramentros forem v�lidos.
	 */
	@Override
	public boolean validarReserva(int idQuarto, int idPromocao, int idCliente, LocalDate dataEntrada,
			LocalDate dataSaida) {
		if (idQuarto <= 0 || idPromocao <= 0 || idCliente <= 0) {
			return false;
		}
		if (!Validacoes.validarDataEntrada(dataEntrada)) {
			return false;
		}
		if (!Validacoes.validarDataSaida(dataSaida, dataEntrada)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean verificarDisponibilidade(LocalDate dataEntrada, LocalDate dataSaida, int idQuarto) {
		return reservaRepositorio.verificarDisponibilidade(dataEntrada, dataSaida, idQuarto);
	}

	@Override
	public double calcularValorReserva(LocalDate dataEntrada, LocalDate dataSaida, double valorDoQuarto) {
		int dias = Period.between(dataEntrada, dataSaida).getDays();
		return dias*valorDoQuarto;
	}

	@Override
	public double aplicarDescontoReserva(double valorReserva, double valorPromocao) {
		return valorReserva-valorPromocao;
	}
}