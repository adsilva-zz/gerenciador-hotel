package sistema.hotel.servicos.implementacao;

import java.time.LocalDate;
import java.util.List;

import sistema.hotel.enuns.TipoPromocao;
import sistema.hotel.modelo.Promocao;
import sistema.hotel.repositorio.PromocaoRepositorio;
import sistema.hotel.repositorio.implementacao.lista.PromocaoRepositorioImpl;
import sistema.hotel.servicos.PromocaoServico;
import sistema.hotel.utilitarios.Validacoes;

public class PromocaoServicoImpl implements PromocaoServico {

	private PromocaoRepositorio promocaoRepositorio;

	public PromocaoServicoImpl() {
		this.promocaoRepositorio = new PromocaoRepositorioImpl();
	}

	/**
	 * M�todo verifica se a promo��o � v�lida e cadastra a promo��o na lista de
	 * promo��es do sistema atrav�s do atributo promocaoRepositorio.
	 * 
	 * @param promocao
	 *            a ser cadastrada.
	 * @return true se o cadastro for realizado com sucesso.
	 * @exception IllegalArgumentException
	 *                caso a promocao seja inv�lida.
	 */
	@Override
	public boolean cadastrarPromocao(Promocao promocao) {
		if (promocao == null) {
			throw new IllegalArgumentException("Promo��o inv�lida.");
		}
		return promocaoRepositorio.cadastrarPromocao(promocao);
	}

	/**
	 * M�todo verifica se a promo�ao n�o � nula e remove a promo��o da lista de
	 * promo��es do sistema.
	 * 
	 * @param promocao
	 *            a ser deletada.
	 * @return true se a promo��o for deletada com sucesso.
	 * @exception IllegalArgumentException
	 *                caso a promo��o seja inv�lida.
	 */
	@Override
	public boolean deletarPromocao(int idPromocao) {
		if (idPromocao == 0) {
			throw new IllegalArgumentException("Promo��o inv�lida.");
		}
		return promocaoRepositorio.deletarPromocao(idPromocao);
	}

	/**
	 * M�todo verifica se o id e a promo��o s�o v�lidos e atualiza uma promo��o.
	 * 
	 * @param promocaoNova
	 *            com os dados atuais.
	 * @param idPromocao
	 *            da promo��o a ser atualizada.
	 * @return true caso a promo��o seja atualizada com sucesso.
	 * @exception IllegalArgumentException
	 *                caso o idPromocao ou promocao sejam inv�lidos.
	 */
	@Override
	public boolean atualizarPromocao(Promocao promocaoNova, int idPromocao) {
		if (promocaoNova == null || idPromocao == 0) {
			throw new IllegalArgumentException("ID ou promo��o inv�lida.");
		}
		return promocaoRepositorio.atualizarPromocao(promocaoNova, idPromocao);
	}

	/**
	 * M�todo retorna a lista de promo��es cadastradas no sistema.
	 * 
	 * @return listaPromocoes.
	 */
	@Override
	public List<Promocao> getPromocoes() {
		return promocaoRepositorio.getPromocoes();
	}

	/**
	 * M�todo verifica se um ID de promo��o � v�lido e retorna uma promo��o caso o
	 * id informado seja igual a uma das promo��es cadastradas na lista de promo��es
	 * do sistema.
	 * 
	 * @param idPromocao
	 *            a ser retornado.
	 * @return promo��o caso o id seja igual.
	 * @exception IllegalArgumentException
	 *                caso o idPromocao seja inv�lido.
	 */
	@Override
	public Promocao getPromocao(int idPromocao) {
		if (idPromocao == 0) {
			throw new IllegalArgumentException("ID inv�lido.");
		}
		return promocaoRepositorio.getPromocao(idPromocao);
	}

	/**
	 * M�todo verifica se os parametros s�o v�lidos
	 * 
	 * @param nome
	 *            da promo��o
	 * @param dataValidade
	 *            da promo��o
	 * @param tipo
	 *            da promo��o
	 * @return true se os parametros forem v�lidos.
	 */
	@Override
	public boolean validarPromocao(String nome, LocalDate dataValidade) {
		if (nome.trim().equals("") || nome == null) {
			return false;
		}
		if (!Validacoes.validarDataValidade(dataValidade)) {
			return false;
		}
		return true;
	}
}
