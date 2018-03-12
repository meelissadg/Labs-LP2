package usuario;

import lab6.Jogo;

/**
 * 
 * @author Melissa
 *
 */

public class Noob implements TipoJogador{

	/** Classe com definicao do jogador tipo Noob
	 */

	private final double DESCONTO_NOOB = 0.1;
	private double precoJogo;
	
	/**
	 * Calcula o preco do jogo com desconto
	 * @param jogo
	 * @return double - precoJogo
	 */
	public double calculaPrecoJogo(Jogo jogo) {
		this.precoJogo = jogo.getPreco() - (jogo.getPreco() * DESCONTO_NOOB);
		return precoJogo;

	}

	@Override
	public String toString() {
		return "Noob [DESCONTO_NOOB=" + precoJogo + "]";
	}

	

	
}
