
package sistema.hotel.repositorio.implementacao.lista;

import java.util.ArrayList;
import java.util.List;

import sistema.hotel.modelo.Promocao;
import sistema.hotel.repositorio.PromocaoRepositorio;

/**
 * Classe Promo��o Repositorio Impl implementa a interface Promo��o Repositorio.
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
	 * M�todo cadastra a promo��o na lista de promo��es do sistema.
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
	 * M�todo remove a promo��o da lista de promo��es do sistema.
	 * 
	 * @param promocao
	 *            a ser deletada.
	 * @return true se a promo��o for deletada com sucesso.
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
	 * M�todo atualiza um promo��o atrav�s do seu ID.
	 * 
	 * @param promocaoNova
	 *            com os dados atuais.
	 * @param idPromocao
	 *            da promo��o a ser atualizada.
	 * @return true caso a promo��o seja atualizada com sucesso.
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
	 * M�todo retorna a lista de promo��es cadastradas no sistema.
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
	 * M�todo retorna uma promo��o caso o id informado seja igual a uma das
	 * promo��es cadastradas na lista de promo��es do sistema.
	 * 
	 * @param idPromocao
	 *            a ser retornado.
	 * @return promo��o caso o id seja igual.
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
