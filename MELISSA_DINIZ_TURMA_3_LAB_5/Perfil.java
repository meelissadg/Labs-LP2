package lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lab4.Musiteca;

public class Perfil {

	private String nomePerfil;
	private ArrayList<Album> listaAlbumSimples;
	private ArrayList<Album> listaAlbumFavoritos;
	private Map<String, ArrayList<Musica>> playList;
	private Musiteca musiteca;
	
	public Perfil(String nomePerfil) throws Exception {

		testaNomePerfil(nomePerfil);
		this.musiteca = new Musiteca();
		
		this.nomePerfil = nomePerfil;
		this.listaAlbumSimples = new ArrayList<Album>();
		this.playList = new HashMap<String, ArrayList<Musica>>();
		this.listaAlbumFavoritos = new ArrayList<Album>();
	}

	public String getNomePerfil() {
		return nomePerfil;
	}

	public ArrayList<Album> getListaAlbumSimples() {
		return listaAlbumSimples;
	}

	public ArrayList<Album> getListaAlbumFavoritos() {
		return listaAlbumFavoritos;
	}

	public Map<String, ArrayList<Musica>> getPlayList() {
		return playList;
	}
	
	public boolean adicionaAlbumAosFavoritos(Album album) throws Exception{
		return musiteca.adicionaAlbumAosFavorito(album);

	}
	
	public boolean adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception{
		return musiteca.adicionaPlaylist(nomePlaylist, nomeAlbum, faixa);

	}
	
	public boolean adicionaAlbumSimples(Album album) throws Exception {
		return musiteca.adicionaAlbumSimples(album);
	}

	public boolean buscaAlbum(Album album){
		return musiteca.buscaAlbum(album);
	}

	public boolean removeAlbum(Album album) throws Exception{
		return musiteca.removeAlbum(album);
	}
	
	public Album buscaAlbumPeloNome(String nomeAlbum) throws Exception{
		return musiteca.buscaAlbumPeloNome(nomeAlbum);
	}
	
	public void testaNomePerfil(String nomePerfil) throws Exception {
		if (nomePerfil == null || nomePerfil.equals("")) {
			throw new Exception("Nome do ususario do perfil nao pode ser nulo ou vazio. ");
		}
	}

}
