package sistema.hotel.controller;

import java.util.List;

import sistema.hotel.enuns.Categoria;
import sistema.hotel.modelo.Quarto;
import sistema.hotel.servicos.QuartoServico;
import sistema.hotel.servicos.implementacao.QuartoServicoImpl;

/**
 * Classe Quarto Controller
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public class QuartoController {

	private QuartoServico quartoServico;

	public QuartoController() {
		quartoServico = new QuartoServicoImpl();
	}

	/**
	 * Método verifica se os paramentros são válidos e cadastra o quarto no sistema
	 * 
	 * @param numero
	 *            do quarto
	 * @param valor
	 *            do quarto
	 * @param categoria
	 *            do quarto
	 * @return true se o quarto for cadastrado com sucesso.
	 */
	public boolean cadastrarQuarto(int numero, double valor, Categoria categoria) {
		if (!quartoServico.validarQuarto(numero, valor, categoria)) {
			return false;
		}
		Quarto quarto = new Quarto(numero, valor, categoria);
		return quartoServico.cadastrarQuarto(quarto);
	}

	/**
	 * Método verifica se os paramentros são válidos e atualiza o quarto
	 * 
	 * @param idQuarto
	 *            do quarto a ser atualizado
	 * @param numero
	 *            do quarto
	 * @param valor
	 *            do quarto
	 * @param categoria
	 *            do quarto
	 * @return true se o quarto for atualizado com sucesso
	 */
	public boolean atualizarQuarto(int idQuarto, int numero, double valor, Categoria categoria) {
		if (idQuarto <= 0) {
			return false;
		}
		if (!quartoServico.validarQuarto(numero, valor, categoria)) {
			return false;
		}
		Quarto quarto = new Quarto(numero, valor, categoria);
		return quartoServico.atualizarQuarto(quarto, idQuarto);
	}

	/**
	 * Método verifica se o id informado é válido e deleta o respectivo quarto do
	 * sistema
	 * 
	 * @param idQuarto
	 *            do quarto a ser deletado
	 * @return true se o quarto for deletado com sucesso
	 */
	public boolean deletarQuarto(int idQuarto) {
		if (idQuarto <= 0) {
			return false;
		}
		return quartoServico.deletarQuarto(idQuarto);
	}

	/**
	 * Método pega todos os quartos do sistema
	 * 
	 * @return lista de quartos
	 */
	public List<Quarto> getQuartos() {
		return quartoServico.getQuartos();
	}

	/**
	 * Método verifica se o id informado é válido e retorno o respectivo quarto.
	 * 
	 * @param idQuarto
	 *            do quarto
	 * @return quarto do id.
	 */
	public Quarto getQuarto(int idQuarto) {
		if (idQuarto <= 0) {
			return null;
		}
		return quartoServico.getQuarto(idQuarto);
	}

	/**
	 * Método adiciona item no quarto, após verificar se os mesmos são válidos
	 * 
	 * @param item
	 *            a ser inserido na lista de itens
	 * @param idQuarto
	 * @return true se o item for adicionado com sucesso
	 */
//	public boolean addItem(String item, int idQuarto) {
//		if (item == null || idQuarto <= 0) {
//			return false;
//		}
//		return quartoServico.addItens(item, idQuarto);
//	}

	/**
	 * Método remove um item da lista de itens do quarto, após verificar se os
	 * mesmos são válidos
	 * 
	 * @param item
	 *            a ser removido da lista de itens
	 * @param idQuarto
	 * @return true se o item for removido com sucesso
	 */
	// public boolean deletarItem(String item, int idQuarto) {
	// if (item == null || idQuarto <= 0) {
	// return false;
	// }
	// return quartoServico.deletarItens(item, idQuarto);
	// }
}