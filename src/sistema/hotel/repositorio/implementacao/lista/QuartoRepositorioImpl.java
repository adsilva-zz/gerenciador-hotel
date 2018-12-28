package sistema.hotel.repositorio.implementacao.lista;

import java.util.ArrayList;
import java.util.List;

import sistema.hotel.modelo.Quarto;
import sistema.hotel.repositorio.QuartoRepositorio;

/**
 * Classe Quarto Repositorio Impl implementa a interface Quarto Repositorio.
 * 
 * Possui um atributo lista de quartos.
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public class QuartoRepositorioImpl implements QuartoRepositorio {

	private List<Quarto> listaQuartos;

	public QuartoRepositorioImpl() {
		this.listaQuartos = new ArrayList<>();
	}

	/**
	 * Método cadastra um novo quarto na lista de quartos do sistema.
	 * 
	 * @param quarto
	 *            a ser cadastrado.
	 * @return true se o cadastro for realizado com sucesso.
	 */
	@Override
	public boolean cadastrarQuarto(Quarto quarto) {
		return listaQuartos.add(quarto);
	}

	/**
	 * Método removo o quarto informado da lista de quartos.
	 * 
	 * @param quarto
	 *            a ser deletado.
	 * @return true se o quarto for deletado com sucesso.
	 */
	@Override
	public boolean deletarQuarto(int idQuarto) {
		Quarto encontrado = null;
		for (Quarto q : listaQuartos) {
			if (q.getIdQuarto() == idQuarto) {
				encontrado = q;
			}
		}
		return listaQuartos.remove(encontrado);
	}

	/**
	 * Método atualiza um quarto através do idQuarto informado.
	 * 
	 * @param quartoNovo
	 *            com os dados atuais
	 * @param idQuarto
	 *            a ser atualizado.
	 * @return true se o quarto for atualizado com sucesso.
	 */
	@Override
	public boolean atualizarQuarto(Quarto quartoNovo, int idQuarto) {
		for (Quarto q : listaQuartos) {
			if (q.getIdQuarto() == idQuarto) {
				q.setCategoria(quartoNovo.getCategoria());
				q.setNumero(quartoNovo.getNumero());
				q.setValor(quartoNovo.getValor());
				return true;
			}
		}
		return false;
	}

	/**
	 * Método retorna a lista de quartos cadastrados no sistema.
	 * 
	 * @return listaQuartos.
	 */
	@Override
	public List<Quarto> getQuartos() {
		List<Quarto> lista = new ArrayList<>();
		lista.addAll(listaQuartos);
		return lista;
	}

	/**
	 * Método retorna um quarto da lista de quartos através do idQuarto.
	 * 
	 * @param idQuarto
	 *            do quarto a ser retornado.
	 * @return quarto se o idQuarto for igual ao id de um dos quartos cadastrados na
	 *         lista.
	 */
	@Override
	public Quarto getQuarto(int idQuarto) {
		for (Quarto q : listaQuartos) {
			if (q.getIdQuarto() == idQuarto) {
				return q;
			}
		}
		return null;
	}

	/**
	 * Método adicionar um item na lista de itens do quarto
	 * 
	 * @param item
	 *            a ser inserido
	 * @param idQuarto
	 *            a receber o item
	 * @return true se o item for adicionado com sucesso.
	 */
//	@Override
//	public boolean addItens(String item, int idQuarto) {
//		for (Quarto q : listaQuartos) {
//			if (q.getIdQuarto() == idQuarto) {
//				q.addItens(item);
//				return true;
//			}
//		}
//		return false;
//	}

	/**
	 * Método remove um item da lista de itens do quarto
	 * 
	 * @param item
	 *            a ser removido
	 * @param idQuarto
	 * @return true se o item for removido com sucesso.
	 */
	// @Override
	// public boolean deletarItens(String item, int idQuarto) {
	// for (Quarto q : listaQuartos) {
	// if (q.getIdQuarto() == idQuarto) {
	// q.getItens().remove(item);
	// return true;
	// }
	// }
	// return false;
	// }
}