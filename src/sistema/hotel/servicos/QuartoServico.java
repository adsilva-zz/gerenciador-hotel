package sistema.hotel.servicos;

import java.util.List;

import sistema.hotel.enuns.Categoria;
import sistema.hotel.modelo.Quarto;

/**
 * Interface Quarto Serviço possui os métodos para manipular os dados do quarto.
 * 
 * @author Amanda da Silva Ito.
 * 
 * @version 1.0
 *
 */
public interface QuartoServico {

	public boolean cadastrarQuarto(Quarto quarto);

	public boolean deletarQuarto(int idQuarto);

	public boolean atualizarQuarto(Quarto quartoNovo, int idQuarto);

	public List<Quarto> getQuartos();

	public Quarto getQuarto(int idQuarto);

	public boolean validarQuarto(int numero, double valor, Categoria categoria);
	
	// public boolean addItens(String item, int idQuarto);
	//
	// public boolean deletarItens(String item, int idQuarto);
}
