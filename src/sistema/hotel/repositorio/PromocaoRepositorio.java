package sistema.hotel.repositorio;

import java.util.List;

import sistema.hotel.modelo.Promocao;

/**
 * Interface Promo��o Repositorio possui os m�todos para tratar em reposit�rio
 * os dados de Promo��o
 * 
 * @author Amanda da Silva Ito.
 * 
 * @version 1.0
 *
 */
public interface PromocaoRepositorio {

	public boolean cadastrarPromocao(Promocao promocao);

	public boolean deletarPromocao(int idPromocao);

	public boolean atualizarPromocao(Promocao promocaoNova, int idPromocao);

	public List<Promocao> getPromocoes();

	public Promocao getPromocao(int idPromocao);
}
