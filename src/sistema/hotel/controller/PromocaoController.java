package sistema.hotel.controller;

import java.time.LocalDate;
import java.util.List;

import sistema.hotel.enuns.TipoPromocao;
import sistema.hotel.modelo.Promocao;
import sistema.hotel.servicos.PromocaoServico;
import sistema.hotel.servicos.implementacao.PromocaoServicoImpl;

/**
 * Classe Promoção Controller
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public class PromocaoController {

	private PromocaoServico promocaoServico;

	public PromocaoController() {
		promocaoServico = new PromocaoServicoImpl();
	}

	/**
	 * Método verifica se os paramentros são válidos e realiza o cadastro da
	 * promoção no sistema.
	 * 
	 * @param nome
	 *            da promoção
	 * @param dataValidade
	 *            da promoção
	 * @param tipo
	 *            da promoção
	 * @return true se a promoção for cadastrada com sucesso
	 */
	public boolean cadastrarPromocao(String nome, LocalDate dataValidade, TipoPromocao tipo) {
		if (!promocaoServico.validarPromocao(nome, dataValidade, tipo)) {
			return false;
		}

		Promocao promocao = new Promocao(nome, dataValidade, tipo);
		return promocaoServico.cadastrarPromocao(promocao);
	}

	/**
	 * Método verifica se o id da promoção é válido e válida os dados a serem
	 * atualizados são válidos. Atualiza a respectiva promoção.
	 * 
	 * @param idPromocao
	 *            da promoção a ser atualizada.
	 * @param nome
	 *            atualizado
	 * @param dataValidade
	 *            atualizada
	 * @param tipo
	 *            atualizado
	 * @return true se a promoção for atualizada com sucesso.
	 */
	public boolean atualizarPromocao(int idPromocao, String nome, LocalDate dataValidade, TipoPromocao tipo) {
		if (idPromocao <= 0) {
			return false;
		}
		if (!promocaoServico.validarPromocao(nome, dataValidade, tipo)) {
			return false;
		}
		Promocao promocao = new Promocao(nome, dataValidade, tipo);
		return promocaoServico.atualizarPromocao(promocao, idPromocao);
	}

	/**
	 * Método verifica se o id informado é válido e deleta a respectiva promoção.
	 * 
	 * @param idPromoção
	 *            da promoção a ser deletada
	 * @return true se a promoção for deletada com sucesso.
	 */
	public boolean deletarPromocao(int idPromoção) {
		if (idPromoção <= 0) {
			return false;
		}
		return promocaoServico.deletarPromocao(idPromoção);
	}

	/**
	 * Método pega todas as promoções cadastradas no sistema.
	 * 
	 * @return lista de promoções
	 */
	public List<Promocao> getPromocoes() {
		return promocaoServico.getPromocoes();
	}

	/**
	 * Método verifica se o id informado é válido e retorna promoção do id.
	 * 
	 * @param idPromocao
	 *            da promoção.
	 * @return promoção
	 */
	public Promocao getPromocao(int idPromocao) {
		if (idPromocao <= 0) {
			return null;
		}
		return promocaoServico.getPromocao(idPromocao);
	}
}