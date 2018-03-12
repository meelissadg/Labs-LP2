package lab4;

public class Musica {

	protected String tituloMusica;
	protected int duracao;
	protected String genero;

	//construtor
	public Musica(String titulo, int duracao, String genero) throws Exception {
		this.duracao = duracao;
		this.genero = genero;
		this.tituloMusica = titulo;

		verificaErroDuracao(duracao);
		verificaErroGenero(genero);
		verificaErroTituloMusica(tituloMusica);
	}

//	se o titulo da musica for vazia ou null
	public void verificaErroTituloMusica(String tituloMusica) throws Exception {
		if (tituloMusica == null || tituloMusica.equals(""))
			throw new Exception("Titulo não pode ser nulo ou vazio. ");
	}

//	se a duracao da musica for menor que 0
	public void verificaErroDuracao(int duracao) throws Exception {
		if (duracao <= 0)
			throw new Exception("Duracao da musica nao pode ser negativa. ");
	}

//	se o genero da musica for vazia ou null
	public void verificaErroGenero(String genero) throws Exception {
		if (genero == null || genero.equals(""))
			throw new Exception("Genero da musica nao pode ser vazio. ");
	}

	public String getTitulo() {
		return tituloMusica;
	}

	public int getDuracao() {
		return duracao;
	}

	public String getGenero() {
		return genero;
	}

	@Override
	public String toString() {
		return "Musica [titulo=" + tituloMusica + ", duracao=" + duracao + ", genero=" + genero + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musica other = (Musica) obj;
		if (duracao != other.duracao)
			return false;
		if (tituloMusica == null) {
			if (other.tituloMusica != null)
				return false;
		} else if (!tituloMusica.equals(other.tituloMusica))
			return false;
		return true;
	}

}