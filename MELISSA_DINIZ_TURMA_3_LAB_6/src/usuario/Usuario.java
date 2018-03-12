package usuario;

import java.util.ArrayList;

import usuario.Noob;
import usuario.Veterano;
import lab6.AtributoInvalidoRuntimeException;

import lab6.Fachada;
import lab6.Jogo;
import lab6.testaValores;

/**
 * Classe que representa o usuario que possui como parametros um nome, login,
 * dinheiro em conta, x2p, inicia como jogador tipo Noob cria uma lista de jogos
 * 
 * @author Melissa
 *
 */

public class Usuario {
	protected String nome;
	protected String login;
	protected ArrayList<Object> listaJogo;
	protected double dinheiro;
	protected int x2p;
	private static TipoJogador tipoJogador;
	private Fachada fachada;

	/**
	 * Construtor Usuario que testa
	 * 
	 * @param nome
	 * @param login
	 * @throws AtributoInvalidoRuntimeException
	 */

	public Usuario(String nome, String login) throws AtributoInvalidoRuntimeException {

		testaValores.testaNome(nome);
		testaValores.testaLogin(login);
		this.nome = nome;
		this.login = login;
		this.listaJogo = new ArrayList<>();
		x2p = 0;
		dinheiro = 0.0;
		tipoJogador = new Noob();

	}

	/**
	 * Atualiza o parametro login
	 * 
	 * @param login
	 */

	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Recupera a quantidade de jogos na lista
	 * 
	 * @return inteiro
	 */
	public int getQntJogos() {
		return fachada.getQntDeJogos();
	}

	/**
	 * Busca o jogo na lista de jogos
	 * 
	 * @param jogo
	 * @return boolean
	 */
	public boolean buscajogo(Jogo jogo) {
		return this.listaJogo.contains(jogo);
	}

	/**
	 * Adiciona um jogo na lista de jogos
	 * 
	 * @param jogo
	 */
	public void adicionaJogo(Jogo jogo) {
		this.listaJogo.add(jogo);
	}

	/**
	 * Efetua a compra do jogo, verifica se possui dinheiro suficiente na conta
	 * adiciona na lista de jogos e diminui na quantidade de dinheiro
	 * 
	 * @param jogo
	 * @return
	 * @throws Exception
	 */

	public boolean compraJogo(Jogo jogo) throws Exception {

		double valorCompra = tipoJogador.calculaPrecoJogo(jogo);

		if (valorCompra <= dinheiro) {
			listaJogo.add(jogo);
			dinheiro = dinheiro - valorCompra;
			return true;

		} else {
			throw new Exception("Voce nao possui dinheiro suficiente. ");

		}

	}

	/**
	 * Adiciona dinheiro na conta
	 * 
	 * @param valor
	 */
	public void addDinheiro(double valor) {
		dinheiro = dinheiro + valor;
	}

	/**
	 * Recupera o nome do usuario
	 * 
	 * @return string nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Atualiza o nome do usuario
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Recupera a lista de jogos
	 * 
	 * @return ArrayList lista de jogos
	 */
	public ArrayList<Object> getListaJogo() {
		return listaJogo;
	}

	/**
	 * Recupera o valor do dinheiro
	 * 
	 * @return inteiro dinheiro
	 */
	public double getDinheiro() {
		return dinheiro;
	}

	/**
	 * Atualiza o valor de dinheiro
	 * 
	 * @param dinheiro
	 */
	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	/**
	 * hashCode do login do usuario
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	/**
	 * Atualiza o tipo de jogador, se o x2p for maior que 1000 o usuario passa a
	 * ser veterano
	 */
	public void atualizarJogador() {
		if (this.x2p < 1000)
			this.tipoJogador = new Noob();
		else
			this.tipoJogador = new Veterano();
	}

	/**
	 * Recupera o x2p
	 * 
	 * @return inteiro x2p
	 */
	public int getX2p() {
		return x2p;
	}

	/**
	 * Atualiza o valor de x2p
	 * 
	 * @param x2p
	 */
	public void setX2p(int x2p) {
		this.x2p = x2p;
	}

	/**
	 * Recupera o login
	 * 
	 * @return String login
	 */
	public String getLogin() {
		return login;
	}

}
