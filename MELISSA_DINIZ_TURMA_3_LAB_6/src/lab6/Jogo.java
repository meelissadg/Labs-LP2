package lab6;

import lab6.testaValores;

/**
 * Classe Jogo
 * @author Melissa
 *
 */

public abstract class Jogo {

	protected String nome;
	protected double preco;
	protected int maiorScore;
	protected int qntVezesJogou;
	protected int qntVezesZerou;
	protected boolean zerou;

	/**
	 * Construtor da classe Jogo, testa usando AtributoInvalidoRuntimeException
	 * os valores do nome e preco
	 * 
	 * @param nome
	 * @param preco
	 * @throws AtributoInvalidoRuntimeException
	 */
	public Jogo(String nome, double preco) throws AtributoInvalidoRuntimeException {

		testaValores.testaNome(nome);
		testaValores.testaPreco(preco);

		this.nome = nome;
		this.preco = preco;
		this.maiorScore = 0;
		this.qntVezesJogou = 0;
		this.qntVezesZerou = 0;
	}

	/**
	 * Atualiza a quantidade de vezes que o usuario jogou e atualiza a pontuacao
	 * 
	 * @param tipoJogo
	 * @param score
	 * @param zerou
	 */
	public void registraJogada(int score, boolean zerou) {
		this.qntVezesJogou = qntVezesJogou + 1;

		if (score > maiorScore) {
			this.maiorScore = score;
		}
		if (zerou) {
			this.qntVezesZerou = qntVezesZerou + 1;
		}

	}

	/**
	 * Metodo abstrato
	 * 
	 * @return
	 */
	public abstract int calcularX2p();

	/**
	 * Recupera o maior score
	 * 
	 * @return inteiro maior score
	 */
	public int getMaiorScore() {
		return maiorScore;
	}

	/**
	 * Atualiza o valor do maior score
	 * 
	 * @param maiorScore
	 */
	public void setMaiorScore(int maiorScore) {
		this.maiorScore = maiorScore;
	}

	/**
	 * Recupera a quantidade de vezes que o jogo foi zerado
	 * 
	 * @return inteiro QntVezesZerou o jogo
	 */
	public int getQntVezesZerou() {
		return qntVezesZerou;
	}

	/**
	 * Atualiza o valor de quantas vezes zerou o jogo
	 * 
	 * @param qntVezesZerou
	 */
	public void setQntVezesZerou(int qntVezesZerou) {
		this.qntVezesZerou = qntVezesZerou;
	}

	/**
	 * Recupera o nome
	 * 
	 * @return String nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Atualiza o parametro nome
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Recupera o preco
	 * 
	 * @return double preco
	 */
	public double getPreco() {
		return preco;
	}

	/**
	 * Atualiza o valor do preco
	 * 
	 * @param preco
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

	/**
	 * Recupera o valor do maiorScore
	 * 
	 * @return inteiro maiorScore
	 */
	public int getScore() {
		return maiorScore;
	}

	/**
	 * Atualiza o valor do maiorScore
	 * 
	 * @param maiorScore
	 */
	public void seScore(int maiorScore) {
		this.maiorScore = maiorScore;
	}

	/**
	 * Recupera o valor de quantas vezes jogou - qntVezesJogou
	 * 
	 * @return inteiro qntVezesJogou
	 */
	public int getQntVezesJogou() {
		return qntVezesJogou;
	}

	/**
	 * Atualiza o valor de qntVezesJogou
	 * 
	 * @param qntVezesJogou
	 */
	public void setQntVezesJogou(int qntVezesJogou) {
		this.qntVezesJogou = qntVezesJogou;
	}

	/**
	 * Recupera o valor de zerou
	 * 
	 * @return boolean
	 */
	public boolean getZerou() {
		return zerou;
	}

	/**
	 * Atualiza o valor de zerou
	 * 
	 * @param zerou
	 */
	public void setZerou(boolean zerou) {
		this.zerou = zerou;
	}

	@Override
	public abstract String toString();

	/**
	 * hashCode apenas do nome
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Jogo))
			return false;
		Jogo other = (Jogo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
