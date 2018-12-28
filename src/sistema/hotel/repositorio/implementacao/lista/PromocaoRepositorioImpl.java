
package sistema.hotel.repositorio.implementacao.lista;

import java.util.ArrayList;
import java.util.List;

import sistema.hotel.modelo.Promocao;
import sistema.hotel.repositorio.PromocaoRepositorio;

/**
 * Classe Promoção Repositorio Impl implementa a interface Promoção Repositorio.
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public class PromocaoRepositorioImpl implements PromocaoRepositorio {

	private List<Promocao> listaPromocoes;

	public PromocaoRepositorioImpl() {
		this.listaPromocoes = new ArrayList<>();
	}

	/**
	 * Método cadastra a promoção na lista de promoções do sistema.
	 * 
	 * @param promocao
	 *            a ser cadastrada.
	 * @return true se o cadastro for realizado com sucesso.
	 */
	@Override
	public boolean cadastrarPromocao(Promocao promocao) {
		return listaPromocoes.add(promocao);
	}

	/**
	 * Método remove a promoção da lista de promoções do sistema.
	 * 
	 * @param promocao
	 *            a ser deletada.
	 * @return true se a promoção for deletada com sucesso.
	 */
	@Override
	public boolean deletarPromocao(int idPromocao) {
		Promocao encontrado = null;
		for (Promocao p : listaPromocoes) {
			if (p.getIdPromocao() == idPromocao) {
				encontrado = p;
			}
		}
		return listaPromocoes.remove(encontrado);
	}

	/**
	 * Método atualiza um promoção através do seu ID.
	 * 
	 * @param promocaoNova
	 *            com os dados atuais.
	 * @param idPromocao
	 *            da promoção a ser atualizada.
	 * @return true caso a promoção seja atualizada com sucesso.
	 */
	@Override
	public boolean atualizarPromocao(Promocao promocaoNova, int idPromocao) {
		for (Promocao p : listaPromocoes) {
			if (p.getIdPromocao() == idPromocao) {
				p.setDataValidade(promocaoNova.getDataValidade());
				p.setNome(promocaoNova.getNome());
				p.setTipo(promocaoNova.getTipo());
				return true;
			}
		}
		return false;
	}

	/**
	 * Método retorna a lista de promoções cadastradas no sistema.
	 * 
	 * @return listaPromocoes.
	 */
	@Override
	public List<Promocao> getPromocoes() {
		List<Promocao> lista = new ArrayList<>();
		lista.addAll(listaPromocoes);
		return lista;
	}

	/**
	 * Método retorna uma promoção caso o id informado seja igual a uma das
	 * promoções cadastradas na lista de promoções do sistema.
	 * 
	 * @param idPromocao
	 *            a ser retornado.
	 * @return promoção caso o id seja igual.
	 * 
	 */
	@Override
	public Promocao getPromocao(int idPromocao) {
		for (Promocao p : listaPromocoes) {
			if (p.getIdPromocao() == idPromocao) {
				return p;
			}
		}
		return null;
	}
}
