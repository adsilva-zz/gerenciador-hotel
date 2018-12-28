package sistema.hotel.utilitarios;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe Validações responsável por validar as regras de neóocio do sistema
 * gerenciador de Hotel.
 * 
 * @author Amanda da Silva Ito
 *
 * @version 1.0
 */
public abstract class Validacoes {

	private static final Pattern PATTERNEMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	private static final Pattern PATTERNTEL = Pattern.compile("^\\(?[0-9]{2}\\)?[9]?[0-9]{4}\\-?[0-9]{4}$");

	/**
	 * Método verifica se o CPF é valido e realiza o calculo de identificação de
	 * pessoa física.
	 * 
	 * @param cpf
	 *            a ser validado
	 * @return true se o CPF for válido.
	 * 
	 */
	public static boolean validarCpf(String cpf) {
		if (cpf == null || cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") || (cpf.length() != 11))
			return false;

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
				return true;
			}
		} catch (Exception erro) {
			return false;
		}
		return false;
	}

	/**
	 * Método verifica se o email é válido.
	 * 
	 * @param email
	 * @return true se o email for válido.
	 * 
	 */
	public static boolean validarEmail(String email) {
		if (email == null) {
			return false;
		}
		Matcher matcher = PATTERNEMAIL.matcher(email);
		return matcher.find();
	}

	/**
	 * Método valida se o telefone ou o celular são válidos (xx)xxxx-xxxx ||
	 * (xx)xxxxx-xxxx
	 * 
	 * @param telefone
	 *            a ser validado
	 * @return true se o telefone ou celular for válido.
	 */
	public static boolean validarTelefone(String telefone) { // testar com null pra ver
		if (telefone == null) {
			return false;
		}

		Matcher matcher = PATTERNTEL.matcher(telefone);
		return matcher.find();
	}

	/**
	 * Método verifica se a data de validade é igual ou maior a data atual.
	 * 
	 * @param dataValidade
	 *            da promoção.
	 * @return true se a data de validade da promoção for igual ou depois da data
	 *         atual.
	 * 
	 */
	public static boolean validarDataValidade(LocalDate dataValidade) {
		if (dataValidade == null) {
			return false;
		}
		if (dataValidade.isAfter(LocalDate.now()) || dataValidade.isEqual(LocalDate.now())) {
			return true;
		}
		return false;
	}

	/**
	 * Método verifica se a data de entrada é igual ou após da data atual.
	 * 
	 * @param dataEntrada
	 *            da reserva
	 * @return true se a data da reserva for igual ou após a data atual.
	 * 
	 * 
	 */
	public static boolean validarDataEntrada(LocalDate dataEntrada) {
		if (dataEntrada == null) {
			return false;
		}
		if (dataEntrada.isAfter(LocalDate.now()) || dataEntrada.isEqual(LocalDate.now())) {
			return true;
		}
		return false;
	}

	/**
	 * Método verifica se a data de saída é após a data de entrada.
	 * 
	 * @param dataSaida
	 *            da reserva
	 * @param dataEntrada
	 *            da reserva
	 * @return true se a data de saída for após a data de entrada.
	 * 
	 */
	public static boolean validarDataSaida(LocalDate dataSaida, LocalDate dataEntrada) {
		if (dataSaida == null || dataEntrada == null) {
			return false;
		}
		return dataSaida.isAfter(dataEntrada);
	}

	/**
	 * Método valida se a senha tem 6 caracteres
	 * 
	 * @param senha
	 *            a ser validada.
	 * @return true se a senha for válida.
	 */
	public static boolean validarSenha(String senha) {
		if (senha.length() == 6) {
			return true;
		}
		return false;
	}
}
