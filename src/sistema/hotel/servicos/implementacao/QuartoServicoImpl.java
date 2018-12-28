package sistema.hotel.servicos.implementacao;

import java.util.List;

import sistema.hotel.enuns.Categoria;
import sistema.hotel.modelo.Quarto;
import sistema.hotel.repositorio.QuartoRepositorio;
import sistema.hotel.repositorio.implementacao.lista.QuartoRepositorioImpl;
import sistema.hotel.servicos.QuartoServico;

/**
 * Classe Quarto Servico Impl implementa a interface Quarto Servi�o para
 * manipular os dados do quarto atrav�s do atributo quartoRepositorio.
 * 
 * @author Amanda da Silva Ito
 * 
 * @version 1.0
 *
 */
public class QuartoServicoImpl implements QuartoServico {

	private QuartoRepositorio quartoRepositorio;

	public QuartoServicoImpl() {
		this.quartoRepositorio = new QuartoRepositorioImpl();
	}

	/**
	 * M�todo val�da um quarto e cadastra no sistema caso seja v�lido.
	 * 
	 * @param quarto
	 *            a ser cadastrado.
	 * @return true se o cadastro for realizado com sucesso.
	 * @exception IllegalArgumentException
	 *                caso o quarto seja inv�lido.
	 */
	@Override
	public boolean cadastrarQuarto(Quarto quarto) {
		if (quarto == null) {
			throw new IllegalArgumentException("Quarto inv�lido.");
		}
		return quartoRepositorio.cadastrarQuarto(quarto);
	}

	/**
	 * M�todo verifica se o quarto informado � v�lido e remove do sistema.
	 * 
	 * @param quarto
	 *            a ser deletado.
	 * @return true se o quarto for deletado com sucesso.
	 * @exception IllegalArgumentException
	 *                caso o quarto seja inv�lido.
	 */
	@Override
	public boolean deletarQuarto(int idQuarto) {
		if (idQuarto <= 0) {
			throw new IllegalArgumentException("Quarto inv�lido.");
		}
		return quartoRepositorio.deletarQuarto(idQuarto);
	}

	/**
	 * M�todo verifica se o id e o quarto s�o v�lidos e atualiza o quarto atrav�s do
	 * idQuarto informado.
	 * 
	 * @param quartoNovo
	 *            com os dados atuais
	 * @param idQuarto
	 *            a ser atualizado.
	 * @return true se o quarto for atualizado com sucesso.
	 * @exception IllegalArgumentException
	 *                caso o quartoNovo ou idQuarto forem inv�lidos.
	 */
	@Override
	public boolean atualizarQuarto(Quarto quartoNovo, int idQuarto) {
		if (quartoNovo == null || idQuarto == 0) {
			throw new IllegalArgumentException("Quarto ou ID inv�lidoS.");
		}
		return quartoRepositorio.atualizarQuarto(quartoNovo, idQuarto);
	}

	/**
	 * M�todo retorna a lista de quartos cadastrados no sistema.
	 * 
	 * @return listaQuartos.
	 */
	@Override
	public List<Quarto> getQuartos() {
		return quartoRepositorio.getQuartos();
	}

	/**
	 * M�todo verifica se o id � v�lido e retorna um quarto da lista de quartos
	 * atrav�s do idQuarto.
	 * 
	 * @param idQuarto
	 *            do quarto a ser retornado.
	 * @return quarto se o idQuarto for igual ao id de um dos quartos cadastrados na
	 *         lista.
	 * @exception IllegalArgumentException
	 *                caso o idQuarto seja inv�lido.
	 */
	@Override
	public Quarto getQuarto(int idQuarto) {
		if (idQuarto == 0) {
			throw new IllegalArgumentException("ID inv�lido.");
		}
		return quartoRepositorio.getQuarto(idQuarto);
	}

	/**
	 * M�todo verifica se os paramentros informados s�o v�lidos.
	 * 
	 * @param numero
	 *            do quarto
	 * @param valor
	 *            da di�ria do quarto
	 * @param categoria
	 *            do quarto
	 * @return true se os parametros forem v�lidos.
	 */
	@Override
	public boolean validarQuarto(int numero, double valor, Categoria categoria) {
		if (numero <= 0 || valor <= 0 || categoria == null) {
			return false;
		}
		return true;
	}

	/**
	 * M�todo verifica os paramentros e adiciona o item no quarto
	 * 
	 * @param id
	 *            do quarto
	 * @param item
	 *            a ser adicionado
	 * @return true se o item for adicionado com sucesso
	 * @exception IllegalArgumentException
	 *                caso o id ou o item for inv�lidos.
	 */
//	@Override
//	public boolean addItens(String item, int idQuarto) {
//		if (item == null || idQuarto <= 0) {
//			throw new IllegalArgumentException("Item ou ID inv�lidos.");
//		}
//		return quartoRepositorio.addItens(item, idQuarto);
//	}

	/**
	 * M�todo verifica se os parametros s�o v�lidos e deleta o item do quarto
	 * informado
	 * 
	 * @param id
	 *            do quarto
	 * @param item
	 *            a ser removido
	 * @return true se o item for removido da lista de itens do quarto
	 * @exception IllegalArgumentException
	 *                caso o id ou o item sejam inv�lidos.
	 */
//	@Override
//	public boolean deletarItens(String item, int idQuarto) {
//		if (item == null || idQuarto <= 0) {
//			throw new IllegalArgumentException("Item ou ID inv�lidos.");
//		}
//		return quartoRepositorio.deletarItens(item, idQuarto);
//	}
}
