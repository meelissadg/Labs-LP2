package lab6;

/**
 * Classe que define o tipo de jogo RPG
 * extends Jogo
 * @author Melissa
 *
 */
public class RPG extends Jogo {

	/**
	 * Construtor de RPG
	 * @param nome
	 * @param preco
	 * @throws AtributoInvalidoRuntimeException
	 */
	public RPG(String nome, double preco) throws AtributoInvalidoRuntimeException {
		super(nome, preco);

		testaValores.testaNome(nome);
		testaValores.testaPreco(preco);
	}

	@Override
	public String toString() {
		return "RPG [nome=" + nome + ", preco=" + preco + ", maiorScore=" + maiorScore + ", qntVezesJogou="
				+ qntVezesJogou + ", qntVezesZerou=" + qntVezesZerou + ", zerou=" + zerou + "]";
	}

	/**
	 * Calcula o x2p para um jogo de RPG
	 */
	@Override
	public int calcularX2p() {
		return getQntVezesJogou() * 10;
	}

}
