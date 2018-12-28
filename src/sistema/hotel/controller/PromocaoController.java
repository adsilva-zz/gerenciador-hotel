package sistema.hotel.controller;

import java.time.LocalDate;
import java.util.List;

import sistema.hotel.enuns.TipoPromocao;
import sistema.hotel.modelo.Promocao;
import sistema.hotel.servicos.PromocaoServico;
import sistema.hotel.servicos.implementacao.PromocaoServicoImpl;

/**
 * Classe Promo��o Controller
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
	 * M�todo verifica se os paramentros s�o v�lidos e realiza o cadastro da
	 * promo��o no sistema.
	 * 
	 * @param nome
	 *            da promo��o
	 * @param dataValidade
	 *            da promo��o
	 * @param tipo
	 *            da promo��o
	 * @return true se a promo��o for cadastrada com sucesso
	 */
	public boolean cadastrarPromocao(String nome, LocalDate dataValidade, TipoPromocao tipo) {
		if (!promocaoServico.validarPromocao(nome, dataValidade, tipo)) {
			return false;
		}

		Promocao promocao = new Promocao(nome, dataValidade, tipo);
		return promocaoServico.cadastrarPromocao(promocao);
	}

	/**
	 * M�todo verifica se o id da promo��o � v�lido e v�lida os dados a serem
	 * atualizados s�o v�lidos. Atualiza a respectiva promo��o.
	 * 
	 * @param idPromocao
	 *            da promo��o a ser atualizada.
	 * @param nome
	 *            atualizado
	 * @param dataValidade
	 *            atualizada
	 * @param tipo
	 *            atualizado
	 * @return true se a promo��o for atualizada com sucesso.
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
	 * M�todo verifica se o id informado � v�lido e deleta a respectiva promo��o.
	 * 
	 * @param idPromo��o
	 *            da promo��o a ser deletada
	 * @return true se a promo��o for deletada com sucesso.
	 */
	public boolean deletarPromocao(int idPromo��o) {
		if (idPromo��o <= 0) {
			return false;
		}
		return promocaoServico.deletarPromocao(idPromo��o);
	}

	/**
	 * M�todo pega todas as promo��es cadastradas no sistema.
	 * 
	 * @return lista de promo��es
	 */
	public List<Promocao> getPromocoes() {
		return promocaoServico.getPromocoes();
	}

	/**
	 * M�todo verifica se o id informado � v�lido e retorna promo��o do id.
	 * 
	 * @param idPromocao
	 *            da promo��o.
	 * @return promo��o
	 */
	public Promocao getPromocao(int idPromocao) {
		if (idPromocao <= 0) {
			return null;
		}
		return promocaoServico.getPromocao(idPromocao);
	}
}