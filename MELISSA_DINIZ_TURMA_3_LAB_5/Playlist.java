package lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lab4.Musica;

public class Playlist {

	// passo 5: ordenacao pode usar TreeSet ou arrayList
	private Map<String, ArrayList<Musica>> playList;
	protected static String nomePlaylist;
	private ArrayList<Album> listaAlbuns;

	@Override
	public String toString() {
		return "Playlist [playList=" + playList + ", listaAlbuns=" + listaAlbuns + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Playlist))
			return false;
		Playlist other = (Playlist) obj;
		if (listaAlbuns == null) {
			if (other.listaAlbuns != null)
				return false;
		} else if (!listaAlbuns.equals(other.listaAlbuns))
			return false;
		if (playList == null) {
			if (other.playList != null)
				return false;
		} else if (!playList.equals(other.playList))
			return false;
		return true;
	}

	public Playlist(String nomePlaylist) throws Exception {

		testaErroNomePlaylist(nomePlaylist);
		this.playList = new HashMap<String, ArrayList<Musica>>();
	}

	public ArrayList<Album> getListaAlbuns() {
		return listaAlbuns;
	}

	public void setListaAlbuns(ArrayList<Album> listaAlbuns) {
		this.listaAlbuns = listaAlbuns;
	}

	public boolean removeMusicaPorNome(String nomeMusica) {
		
		for (String chave : playList.keySet()) {
			for (int i = 0; i < playList.size(); i++) {
				
			}
		}
		return false;

	}

	public boolean removeMusica(Musica musica) {
		if (playList.containsValue(musica)) {
			playList.remove(musica);
			return true;
		}
		return false;

	}

	public int duracaoPlaylist() {
		int duracao=0;
		for (String chave : playList.keySet()) {
			for (int i = 0; i < playList.size(); i++) {
				duracao = duracao + playList.get(chave).get(i).getDuracao();
			}
		}
		return duracao;

	}

	public boolean contemPlaylistNoAlbum(String nomePlaylist) {
		if (playList.containsKey(nomePlaylist)) {
			return true;
		}
		return false;

	}

	public void testaErroFaixa(int faixa) throws Exception {
		if (faixa <= 0) {
			throw new Exception("Numero da faixa dever ser maior que 0.");
		}
	}

	public void testaErroAlbum(String nomeAlbum) throws Exception {
		if (nomeAlbum == null || nomeAlbum.equals("")) {
			throw new Exception("O nome do album nao pode ser vazio ou nulo.");
		}
	}

	public void testaErroNomePlaylist(String nomePlaylist) throws Exception {
		if (nomePlaylist == null || nomePlaylist.equals("")) {
			throw new Exception("O nome da Playlist nao pode ser vazio ou nulo");
		}
	}

	

	
}
