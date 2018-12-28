package sistema.hotel.repositorio;

import java.util.List;

import sistema.hotel.modelo.Quarto;

/**
 * Interface Quarto Repositório possui métodos para tratar os dados dos Quartos
 * no repositório do sistema do Hotel.
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public interface QuartoRepositorio {

	public boolean cadastrarQuarto(Quarto quarto);

	public boolean deletarQuarto(int idQuarto);

	public boolean atualizarQuarto(Quarto quartoNovo, int idQuarto);

	public List<Quarto> getQuartos();

	public Quarto getQuarto(int idQuarto);

	// public boolean addItens(String item, int idQuarto);
	//
	// public boolean deletarItens(String item, int idQuarto);
}
