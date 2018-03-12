package loja;

import loja.AtributoInvalidoRuntimeException;

/**
 * Classe usada para testar valores
 * 
 * @author Melissa
 *
 */
public class testaValores {

	/**
	 * Testa se o nome eh valido
	 * 
	 * @param nome
	 * @throws AtributoInvalidoRuntimeException
	 */
	public static void testaNome(String nome) throws AtributoInvalidoRuntimeException {
		if (nome.equals("") || nome == null) {
			throw new AtributoInvalidoRuntimeException("Nome nao pode ser vazio.");
		}
	}

	/**
	 * Testa o valor do preco
	 * 
	 * @param preco
	 * @throws AtributoInvalidoRuntimeException
	 */
	public static void testaPreco(double preco) throws AtributoInvalidoRuntimeException {
		if (preco < 0.0) {
			throw new AtributoInvalidoRuntimeException("Preco nao pode ser negativo.");
		}
	}

	/**
	 * Testa se o login eh valido
	 * 
	 * @param login
	 * @throws AtributoInvalidoRuntimeException
	 */
	public static void testaLogin(String login) throws AtributoInvalidoRuntimeException {
		if (login.equals("") || login == null) {
			throw new AtributoInvalidoRuntimeException("Login nao pode ser vazio.");

		}
	}

}
