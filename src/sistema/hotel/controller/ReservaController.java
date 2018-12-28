package sistema.hotel.controller;

import java.time.LocalDate;

import sistema.hotel.servicos.ReservaServico;
import sistema.hotel.servicos.implementacao.ReservaServicoImpl;

public class ReservaController {

	private ReservaServico reservaServico;
	
	public ReservaController() {
		reservaServico = new ReservaServicoImpl();
	}
	
	public boolean realizarReserva(int idQuarto, int idPromocao, int idCliente, double valor, LocalDate dataEntrada,
			LocalDate dataSaida) {
		return false;
	}
}
