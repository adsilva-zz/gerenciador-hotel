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
	 * Método verifica se a promoção é válida e cadastra a promoção na lista de
	 * promoções do sistema através do atributo promocaoRepositorio.
	 * 
	 * @param promocao
	 *            a ser cadastrada.
	 * @return true se o cadastro for realizado com sucesso.
	 * @exception IllegalArgumentException
	 *                caso a promocao seja inválida.
	 */
	@Override
	public boolean cadastrarPromocao(Promocao promocao) {
		if (promocao == null) {
			throw new IllegalArgumentException("Promoção inválida.");
		}
		return promocaoRepositorio.cadastrarPromocao(promocao);
	}

	/**
	 * Método verifica se a promoçao não é nula e remove a promoção da lista de
	 * promoções do sistema.
	 * 
	 * @param promocao
	 *            a ser deletada.
	 * @return true se a promoção for deletada com sucesso.
	 * @exception IllegalArgumentException
	 *                caso a promoção seja inválida.
	 */
	@Override
	public boolean deletarPromocao(int idPromocao) {
		if (idPromocao == 0) {
			throw new IllegalArgumentException("Promoção inválida.");
		}
		return promocaoRepositorio.deletarPromocao(idPromocao);
	}

	/**
	 * Método verifica se o id e a promoção são válidos e atualiza uma promoção.
	 * 
	 * @param promocaoNova
	 *            com os dados atuais.
	 * @param idPromocao
	 *            da promoção a ser atualizada.
	 * @return true caso a promoção seja atualizada com sucesso.
	 * @exception IllegalArgumentException
	 *                caso o idPromocao ou promocao sejam inválidos.
	 */
	@Override
	public boolean atualizarPromocao(Promocao promocaoNova, int idPromocao) {
		if (promocaoNova == null || idPromocao == 0) {
			throw new IllegalArgumentException("ID ou promoção inválida.");
		}
		return promocaoRepositorio.atualizarPromocao(promocaoNova, idPromocao);
	}

	/**
	 * Método retorna a lista de promoções cadastradas no sistema.
	 * 
	 * @return listaPromocoes.
	 */
	@Override
	public List<Promocao> getPromocoes() {
		return promocaoRepositorio.getPromocoes();
	}

	/**
	 * Método verifica se um ID de promoção é válido e retorna uma promoção caso o
	 * id informado seja igual a uma das promoções cadastradas na lista de promoções
	 * do sistema.
	 * 
	 * @param idPromocao
	 *            a ser retornado.
	 * @return promoção caso o id seja igual.
	 * @exception IllegalArgumentException
	 *                caso o idPromocao seja inválido.
	 */
	@Override
	public Promocao getPromocao(int idPromocao) {
		if (idPromocao == 0) {
			throw new IllegalArgumentException("ID inválido.");
		}
		return promocaoRepositorio.getPromocao(idPromocao);
	}

	/**
	 * Método verifica se os parametros são válidos
	 * 
	 * @param nome
	 *            da promoção
	 * @param dataValidade
	 *            da promoção
	 * @param tipo
	 *            da promoção
	 * @return true se os parametros forem válidos.
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
