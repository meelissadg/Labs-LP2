package usuario;

import lab6.Jogo;

/**
 * Classe que define o tipo jogador veterano
 * @author Melissa
 *
 */

public class Veterano implements TipoJogador{
	
	private final double DESCONTO_VETERANO = 0.2;
	private double precoJogo;
	
	/**
	 * Calcula o preco do jogo com desconto
	 * @param jogo
	 * @return double - precoJogo 
	 */
	public double calculaPrecoJogo(Jogo jogo){
		this.precoJogo = jogo.getPreco() - (jogo.getPreco()*DESCONTO_VETERANO);
		return precoJogo;
		
	}
	
	/**
	 * Recupera o preco do jogo
	 * @return double preco
	 */
	private double getPrecoJogo(){
		return precoJogo;
	}

	@Override
	public String toString() {
		return "Veterano [DESCONTO_VETERANO=" + precoJogo + "]";
	}
	
}
