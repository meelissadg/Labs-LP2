package lab6;

import lab6.RPG;

/**
 * Faz o controle da criacao de jogo
 * @author Melissa
 *
 */
public class JogoControle {
	
	/**
	 * Cria um jogo tipo Plataforma
	 * @param nome
	 * @param preco
	 * @return jogo criado
	 * @throws AtributoInvalidoRuntimeException
	 */
	public Plataforma criarJogoPlataforma(String nome, double preco)throws AtributoInvalidoRuntimeException {
		return new Plataforma(nome, preco);
	}
	
	/**
	 * Cria um jogo tipo RPG
	 * @param nome
	 * @param preco
	 * @return obj
	 * @throws AtributoInvalidoRuntimeException
	 */
	public RPG criaJogoRPG(String nome, double preco)throws AtributoInvalidoRuntimeException {
		return new RPG(nome, preco);
		}
	
	/**
	 * Cria jogo tipo luta
	 * @param nome
	 * @param preco
	 * @return
	 * @throws AtributoInvalidoRuntimeException
	 */
	public Luta criaJogoLuta(String nome, double preco) throws AtributoInvalidoRuntimeException{
		return new Luta(nome, preco);
	}
		
	}

