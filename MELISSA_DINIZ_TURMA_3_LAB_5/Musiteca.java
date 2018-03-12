package lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Musiteca {

	private ArrayList<Album> listaAlbumSimples;
	private ArrayList<Album> listaAlbumFavoritos;
	private Map<String, ArrayList<Musica>> playList;

	public Musiteca() throws Exception {
		this.listaAlbumSimples = new ArrayList<Album>();
		this.playList = new HashMap<String, ArrayList<Musica>>();
		this.listaAlbumFavoritos = new ArrayList<Album>();

	}

	/** getListaAlbumFavoritos()  getListaAlbum() retornam as listas de albuns
	 * 	o metodo buscaAlbum() procura um album na lista de albuns e retorna true se encontrar
	 *  adicionaPlaylist() adiciona uma playlist
	 */
	public ArrayList<Album> getListaAlbumFavoritos() {
		return listaAlbumFavoritos;
	}

	public ArrayList<Album> getListaAlbum() {
		return listaAlbumSimples;
	}

	public Map<String, ArrayList<Musica>> getPlayList() {
		return playList;
	}

	public boolean adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception {

		if (nomeAlbum == null || nomeAlbum.equals(""))
			throw new Exception("Nome do Album nao pode ser nula ou vazia.");
		testaErroNome(nomePlaylist);
		testaErroFaixa(faixa);

		ArrayList<Musica> musicasDaPlayList;
		Album albumAtual;

		if (!playList.keySet().contains(nomePlaylist)) {
			playList.put(nomeAlbum, new ArrayList<Musica>());
		} else {
			musicasDaPlayList = playList.get(nomePlaylist);
			if ((albumAtual = buscaAlbumPeloNome(nomeAlbum)) == null) {
				throw new Exception("Álbum não pertence ao Perfil especificado");
			} else {
				musicasDaPlayList.add(albumAtual.getListaDeMusicas().get(faixa - 1));
				return true;
			}
		}
		return false;

	}
	//ok
	public boolean buscaAlbum(Album album){
		if (listaAlbumSimples.contains(album)) {
			return true;
		}
		return false;
	}
	
	//ok
	public Album buscaAlbumPeloNome(String nomeAlbum) throws Exception{
		for (Album album : listaAlbumSimples) {
			if (album.getTituloAlbum().equals(nomeAlbum)) {
				return album;
			}
		}
		return null;
		
	}

	public boolean adicionaAlbumSimples(Album album) throws Exception {
		testaErroNomeAlbum(album);

		if (!listaAlbumSimples.contains(album)) {
			listaAlbumSimples.add(album);
			return true;

		}
		return false; 
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Musiteca))
			return false;
		Musiteca other = (Musiteca) obj;
		if (listaAlbumFavoritos == null) {
			if (other.listaAlbumFavoritos != null)
				return false;
		} else if (!listaAlbumFavoritos.equals(other.listaAlbumFavoritos))
			return false;
		if (listaAlbumSimples == null) {
			if (other.listaAlbumSimples != null)
				return false;
		} else if (!listaAlbumSimples.equals(other.listaAlbumSimples))
			return false;
		if (playList == null) {
			if (other.playList != null)
				return false;
		} else if (!playList.equals(other.playList))
			return false;
		return true;
	}

	public String toString() {
		return "Musiteca [listaAlbumSimples=" + listaAlbumSimples + ", listaAlbumFavoritos=" + listaAlbumFavoritos
				+ ", playList=" + playList + "]";
	}

//	adiciona um album na lista de albuns favoritos
	public boolean adicionaAlbumAosFavorito(Album album) throws Exception {
		testaErroNomeAlbum(album);

		if (!listaAlbumFavoritos.contains(album)) {
			listaAlbumFavoritos.add(album);
			return true;
		} else {
			throw new Exception("O album ja existe na playList.");
		}

	}

//	verifica o nome da playlist, nao pode ser null
	public void verificaErroNomePlaylist(String nomePlaylist) throws Exception {
		if (nomePlaylist == null || nomePlaylist.equals("")) {
			throw new Exception("O nome da PlayList nao pode ser");
		}

	}

	public void testaErroAlbum(Album nomeAlbum) throws Exception {
		if (nomeAlbum == null || nomeAlbum.equals(""))
			throw new Exception("Titulo do Album nao pode ser vazio ou nulo. ");
	}

	public void testaErroFaixa(int faixa) throws Exception {
		if (faixa <= 0 || faixa > listaAlbumSimples.size()) {
			throw new Exception("O numero de faixas nao pode ser igual ou menor que zero");
		}

	}

	//ok
	public void testaErroNome(String nomePlaylist) throws Exception {
		if (nomePlaylist == null || nomePlaylist.equals(""))
			throw new Exception("Nome da Playlist não pode ser nulo ou vazio. ");
	}

	public void testaErroNomeAlbum(Album albumNome) throws Exception {
		if (albumNome == null || albumNome.equals(""))
			throw new Exception("Nome do album nao pode ser vazio ou nulo.");
	}
// remove album da lista de albuns
	public boolean removeAlbum(Album album) throws Exception {
		if (!listaAlbumSimples.contains(album)) {
			throw new Exception("Album nao encontrado. ");
		} else {
			listaAlbumSimples.remove(album);
			return true;
		}
	}
}
