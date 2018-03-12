package loja;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import usuario.Usuario;

/**
 * Classe fachada
 * 
 * @author Melissa
 *
 */
public class LojaController {

	private List<Usuario> listaUsuarios;
	private List<Jogo> listaJogos;

	/**
	 * Construtor da classe fachada inicia um ArrayList de usuarios e um
	 * ArrayList de jogos
	 */
	public LojaController() {
		this.listaUsuarios = new ArrayList<Usuario>();
		this.listaJogos = new ArrayList<Jogo>();
	}

	/**
	 * Busca um usuario na lista de usuarios, se encontrar retorna true
	 * 
	 * @param usuario
	 * @return boolean
	 */
	public boolean buscaUsuario(Usuario usuario) {
		if (listaUsuarios.contains(usuario)) {
			return true;
		}
		return false;
	}

	public double totalPrecoJogos() {
		double valor = 0.0;
		for (Jogo jogo : listaJogos) {
			valor = valor + jogo.getPreco();
		}
		return valor;
	}

	/**
	 * Recupera a quantidade de usuarios na lista de usuarios
	 * 
	 * @return inteiro
	 */
	public int quantidadeDeUsuarios() {
		return listaUsuarios.size();
	}

	/**
	 * Verifica se um jogo esta na lista de jogos
	 * 
	 * @param jogo
	 * @return boolean
	 */
	public boolean contemJogoNaLista(Jogo jogo) {
		return this.listaJogos.contains(jogo);
	}

	/**
	 * Recupera o joogo na lista de jogos usando Iterator
	 * 
	 * @param nomeDoJogo
	 * @return
	 * @throws ObjetoNaoExisteException
	 */
	public Jogo getJogo(String nomeDoJogo) throws ObjetoNaoExisteException {
		Iterator<Jogo> jogo = this.listaJogos.iterator();
		while (jogo.hasNext()) {

			Jogo jogoAtual = (Jogo) jogo.next();

			if (jogoAtual.getNome().equalsIgnoreCase(nomeDoJogo)) {
				return jogoAtual;
			}
		}
		throw new ObjetoNaoExisteException("Jogo nao existe na lista");
	}

	/**
	 * Adiciona jogo na lista de jogos
	 * 
	 * @param jogo
	 * @return boolean
	 */
	public boolean addJogo(Jogo jogo) {
		return this.listaJogos.add(jogo);
	}

	/**
	 * Recupera a quantidade de jogos na lista de jogos
	 * 
	 * @return inteiro
	 */
	public int getQntDeJogos() {
		return this.listaJogos.size();
	}

	/**
	 * Busca um usuario usando o login na lista de usuarios usando Iterador
	 * 
	 * @param login
	 * @return objeto usuario
	 * @throws ObjetoNaoExisteException
	 */
	public Usuario buscaUsuarioPorLogin(String login) throws ObjetoNaoExisteException {

		Iterator<Usuario> iteradorUsuario = this.listaUsuarios.iterator();
		while (iteradorUsuario.hasNext()) {
			Usuario usuarioAtual = (Usuario) iteradorUsuario.next();
			if (usuarioAtual.getLogin().equalsIgnoreCase(login)) {
				return usuarioAtual;
			}
		}
		return null;

	}

	/**
	 * Recupera a quantidade de usuarios na lista de usuarios
	 * 
	 * @return
	 */
	public int getTotalUsuario() {
		return this.listaUsuarios.size();
	}

	/**
	 * Adiciona um usuario na lista de usuarios
	 * 
	 * @param usuario
	 * @return
	 */
	public boolean addUsuario(Usuario usuario) {
		return this.listaUsuarios.add(usuario);
	}

	/**
	 * Cria um jogo usando o nome do jogo
	 * 
	 * @param login
	 * @param nomeJogo
	 * @throws ObjetoNaoExisteException
	 */
	public void venderJogo(String login, String nomeJogo) throws ObjetoNaoExisteException {
		Usuario usuario = buscaUsuarioPorLogin(login);
		Jogo jogo = getJogo(nomeJogo);

		if (usuario.getDinheiro() > jogo.getPreco()) {
			usuario.adicionaJogo(jogo);
		}
	}

	/**
	 * Cria um novo usuario
	 * 
	 * @param nome
	 * @param login
	 * @return
	 * @throws AtributoInvalidoRuntimeException
	 */
	public boolean criarUsuario(String nome, String login) throws AtributoInvalidoRuntimeException {
		Usuario novoUsuario = new Usuario(nome, login);
		return addUsuario(novoUsuario);
	}

	/**
	 * Adiciona dinheiro na conta do usuario faz busca pelo usuario pelo login
	 * 
	 * @param login
	 * @param quantidadeDeDinheiro
	 * @throws ObjetoNaoExisteException
	 */
	public void depositarNaContaDeUsuario(String login, double valor) throws ObjetoNaoExisteException {
		Usuario usuario = buscaUsuarioPorLogin(login);
		usuario.addDinheiro(valor);
	}

	@Override
	public String toString() {
		return "Fachada [listaUsuarios=" + listaUsuarios + ", listaJogos=" + listaJogos + "]";
	}

}
