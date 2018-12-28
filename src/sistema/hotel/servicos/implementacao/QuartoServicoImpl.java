package sistema.hotel.servicos.implementacao;

import java.util.List;

import sistema.hotel.enuns.Categoria;
import sistema.hotel.modelo.Quarto;
import sistema.hotel.repositorio.QuartoRepositorio;
import sistema.hotel.repositorio.implementacao.lista.QuartoRepositorioImpl;
import sistema.hotel.servicos.QuartoServico;

/**
 * Classe Quarto Servico Impl implementa a interface Quarto Serviço para
 * manipular os dados do quarto através do atributo quartoRepositorio.
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
	 * Método valída um quarto e cadastra no sistema caso seja válido.
	 * 
	 * @param quarto
	 *            a ser cadastrado.
	 * @return true se o cadastro for realizado com sucesso.
	 * @exception IllegalArgumentException
	 *                caso o quarto seja inválido.
	 */
	@Override
	public boolean cadastrarQuarto(Quarto quarto) {
		if (quarto == null) {
			throw new IllegalArgumentException("Quarto inválido.");
		}
		return quartoRepositorio.cadastrarQuarto(quarto);
	}

	/**
	 * Método verifica se o quarto informado é válido e remove do sistema.
	 * 
	 * @param quarto
	 *            a ser deletado.
	 * @return true se o quarto for deletado com sucesso.
	 * @exception IllegalArgumentException
	 *                caso o quarto seja inválido.
	 */
	@Override
	public boolean deletarQuarto(int idQuarto) {
		if (idQuarto <= 0) {
			throw new IllegalArgumentException("Quarto inválido.");
		}
		return quartoRepositorio.deletarQuarto(idQuarto);
	}

	/**
	 * Método verifica se o id e o quarto são válidos e atualiza o quarto através do
	 * idQuarto informado.
	 * 
	 * @param quartoNovo
	 *            com os dados atuais
	 * @param idQuarto
	 *            a ser atualizado.
	 * @return true se o quarto for atualizado com sucesso.
	 * @exception IllegalArgumentException
	 *                caso o quartoNovo ou idQuarto forem inválidos.
	 */
	@Override
	public boolean atualizarQuarto(Quarto quartoNovo, int idQuarto) {
		if (quartoNovo == null || idQuarto == 0) {
			throw new IllegalArgumentException("Quarto ou ID inválidoS.");
		}
		return quartoRepositorio.atualizarQuarto(quartoNovo, idQuarto);
	}

	/**
	 * Método retorna a lista de quartos cadastrados no sistema.
	 * 
	 * @return listaQuartos.
	 */
	@Override
	public List<Quarto> getQuartos() {
		return quartoRepositorio.getQuartos();
	}

	/**
	 * Método verifica se o id é válido e retorna um quarto da lista de quartos
	 * através do idQuarto.
	 * 
	 * @param idQuarto
	 *            do quarto a ser retornado.
	 * @return quarto se o idQuarto for igual ao id de um dos quartos cadastrados na
	 *         lista.
	 * @exception IllegalArgumentException
	 *                caso o idQuarto seja inválido.
	 */
	@Override
	public Quarto getQuarto(int idQuarto) {
		if (idQuarto == 0) {
			throw new IllegalArgumentException("ID inválido.");
		}
		return quartoRepositorio.getQuarto(idQuarto);
	}

	/**
	 * Método verifica se os paramentros informados são válidos.
	 * 
	 * @param numero
	 *            do quarto
	 * @param valor
	 *            da diária do quarto
	 * @param categoria
	 *            do quarto
	 * @return true se os parametros forem válidos.
	 */
	@Override
	public boolean validarQuarto(int numero, double valor, Categoria categoria) {
		if (numero <= 0 || valor <= 0 || categoria == null) {
			return false;
		}
		return true;
	}

	/**
	 * Método verifica os paramentros e adiciona o item no quarto
	 * 
	 * @param id
	 *            do quarto
	 * @param item
	 *            a ser adicionado
	 * @return true se o item for adicionado com sucesso
	 * @exception IllegalArgumentException
	 *                caso o id ou o item for inválidos.
	 */
//	@Override
//	public boolean addItens(String item, int idQuarto) {
//		if (item == null || idQuarto <= 0) {
//			throw new IllegalArgumentException("Item ou ID inválidos.");
//		}
//		return quartoRepositorio.addItens(item, idQuarto);
//	}

	/**
	 * Método verifica se os parametros são válidos e deleta o item do quarto
	 * informado
	 * 
	 * @param id
	 *            do quarto
	 * @param item
	 *            a ser removido
	 * @return true se o item for removido da lista de itens do quarto
	 * @exception IllegalArgumentException
	 *                caso o id ou o item sejam inválidos.
	 */
//	@Override
//	public boolean deletarItens(String item, int idQuarto) {
//		if (item == null || idQuarto <= 0) {
//			throw new IllegalArgumentException("Item ou ID inválidos.");
//		}
//		return quartoRepositorio.deletarItens(item, idQuarto);
//	}
}
