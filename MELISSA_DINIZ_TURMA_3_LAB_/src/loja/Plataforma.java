package loja;

import loja.AtributoInvalidoRuntimeException;

/**
 * classe que define um jogo do tipo Plataforma
 * Extends Jogo
 * @author Melissa
 *
 */
public class Plataforma extends Jogo {

	public Plataforma(String nome, double preco) throws AtributoInvalidoRuntimeException {
		super(nome, preco);

		testaValores.testaNome(nome);
		testaValores.testaPreco(preco);
	}

	@Override
	public String toString() {
		return "Plataforma [nome=" + nome + ", preco=" + preco + ", maiorScore=" + maiorScore + ", qntVezesJogou="
				+ qntVezesJogou + ", qntVezesZerou=" + qntVezesZerou + ", zerou=" + zerou + "]";
	}
	
	/**
	 * Calcula o x2p para um jogodo tipo plataforma
	 */
	@Override
	public int calcularX2p() {

		return getQntVezesZerou() * 10;
	}

}

