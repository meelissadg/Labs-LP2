package lab4;

import java.util.ArrayList;

public class Album {

	private String tituloAlbum;
	private String artista;
	private int ano;
	private ArrayList<Musica> listaDeMusicas;

	public Album(String tituloAlbum, String artista, int ano) throws Exception {

		testaErroAnoDeLancamento(ano);
		testaErroArtista(artista);
		testaErroTitulo(tituloAlbum);

		this.listaDeMusicas = new ArrayList<Musica>();
		this.ano = ano;
		this.artista = artista;
		this.tituloAlbum = tituloAlbum;

	}

	/**
	 * testaErroMusica testaErroTitulo testaErroAnoDeLancamento testaErroArtista
	 * nao permitem criar musica/titulo/artista vazio ou null e verifica o ano
	 */

	public void testaErroMusica(Musica musica) throws Exception {
		if (musica == null) {
			throw new Exception("A Musica nao pode ser nulo. ");
		}
	}

	public void testaErroTitulo(String titulo) throws Exception {
		if (titulo == null || titulo.equals(""))
			throw new Exception("Titulo do Album nao pode ser vazio. ");
	}

	public void testaErroAnoDeLancamento(int anoDeLancamento) throws Exception {
		if (anoDeLancamento <= 1900)
			throw new Exception("Ano de Lancamento do Album nao pode ser negativo. ");
	}

	public void testaErroArtista(String artista) throws Exception {
		if (artista == null || artista.equals("")) {
			throw new Exception("Artista nao pode ser nulo ou vazio. ");
		}
	}

	// retorna a duracao total do album
	public int getDuracaoTotalDoAlbum() {
		int duracao = 0;

		for (Musica musica : listaDeMusicas) {
			duracao = duracao + musica.getDuracao();
		}
		return duracao;
	}

	public boolean adicionaMusicaNoAlbum(Musica musicaParaAdicionar) throws Exception {
		testaErroMusica(musicaParaAdicionar);

		if (pesquisaMusicaNoAlbum(musicaParaAdicionar)) {
			return false;
		} else {
			listaDeMusicas.add(musicaParaAdicionar);
			return true;
		}
	}

	/** remove a musica pelo nome 
	 * e pelo objeto
	 */
	public boolean removeMusica(Musica musicaRemover) throws Exception {
		testaErroMusica(musicaRemover);
		for (Musica musica : listaDeMusicas) {
			if (musica.equals(musicaRemover)) {
				listaDeMusicas.remove(musicaRemover);
				return true;
			}
		}
		return false;
	}

	public boolean removeMusicaDoAlbum(String nomeMusica) throws Exception {
		if (nomeMusica == null || nomeMusica.equals(""))
			throw new Exception("Nome da musica nao pode ser nula ou vazia.");

		for (Musica musica : listaDeMusicas) {
			if (musica.getTitulo().equals(nomeMusica)) {
				listaDeMusicas.remove(musica);
				return true;
			}
		}

		return false;
	}

	// pesquisa musica pela faixa no album
	public Musica pesquisaMusicaPelaFaixa(int faixa) throws Exception {

		if (faixa < 1 || faixa > listaDeMusicas.size()) {
			throw new Exception("Numero da faixa precisa ser maior ou igual a 1 .");
		}
		for (int i = 0; i < listaDeMusicas.size(); i++) {
			if (listaDeMusicas.get(i).equals(listaDeMusicas.get(faixa))) {
				return listaDeMusicas.get(i - 1);
			}
		}
		return null;
	}

	// pesquisa musica no album
	public boolean pesquisaMusicaNoAlbum(Musica musica) {

		if (listaDeMusicas.contains(musica)) {
			return true;
		}
		return false;
	}

	// pesquina musica no album pelo nome
	public boolean pesquisaMusicaPeloNome(String nome) {
		for (Musica musica : listaDeMusicas) {

			if (musica.getTitulo().equals(nome)) {
				return true;
			}
		}
		return false;

	}

	public ArrayList<Musica> getListaDeMusicas() {
		return listaDeMusicas;
	}

	public String getTituloAlbum() {
		return this.tituloAlbum;
	}

	public String getArtista() {
		return artista;
	}

	public int getAno() {
		return ano;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((tituloAlbum == null) ? 0 : tituloAlbum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Album))
			return false;
		Album other = (Album) obj;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (tituloAlbum == null) {
			if (other.tituloAlbum != null)
				return false;
		} else if (!tituloAlbum.equals(other.tituloAlbum))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return artista;
	}

}