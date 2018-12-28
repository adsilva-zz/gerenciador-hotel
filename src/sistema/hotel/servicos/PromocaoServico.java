package sistema.hotel.servicos;

import java.time.LocalDate;
import java.util.List;

import sistema.hotel.enuns.TipoPromocao;
import sistema.hotel.modelo.Promocao;

/**
 * Interface Promo��o Servi�o possui os m�todos para manipular os dados de
 * Promo��o
 * 
 * @author Amanda da Silva Ito.
 * 
 * @version 1.0
 *
 */
public interface PromocaoServico {

	public boolean cadastrarPromocao(Promocao promocao);

	public boolean deletarPromocao(int idPromocao);

	public boolean atualizarPromocao(Promocao promocaoNova, int idPromocao);

	public List<Promocao> getPromocoes();

	public Promocao getPromocao(int idPromocao);
	
	public boolean validarPromocao(String nome, LocalDate dataValidade, TipoPromocao tipo);
}
