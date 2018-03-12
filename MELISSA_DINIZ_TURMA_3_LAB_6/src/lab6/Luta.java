package lab6;

/**
 * classe que define um jogo do tipo Luta
 * Extends Jogo
 * @author Melissa
 *
 */
public class Luta extends Jogo {

	/**
	 * Construtor de luta, testa os valores de nome e preco usando
	 * AtributoInvalidoRuntimeException
	 * 
	 * @param nome
	 * @param preco
	 * @throws AtributoInvalidoRuntimeException
	 */
	public Luta(String nome, double preco) throws AtributoInvalidoRuntimeException {
		super(nome, preco);

		testaValores.testaNome(nome);
		testaValores.testaPreco(preco);
	}

	@Override
	public String toString() {
		return "Luta [nome=" + nome + ", preco=" + preco + ", maiorScore=" + maiorScore + ", qntVezesJogou="
				+ qntVezesJogou + ", qntVezesZerou=" + qntVezesZerou + ", zerou=" + zerou + "]";
	}

	/**
	 * Sobreescrita de metodo de jogo
	 * Calcula o x2p para um jogo do tipo Luta
	 */
	@Override
	public int calcularX2p() {
		return getMaiorScore() / 1000;
	}

}
