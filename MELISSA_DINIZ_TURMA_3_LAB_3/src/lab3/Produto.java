package lab3;

/* 115211394 - Melissa Diniz Goncalves: LAB 3 - Turma 3 */


public class Produto {
	private String nomeProduto;
	private String tipo;
	private double preco;
	private int quantidade;

	// construtor de Produto
	public Produto(String nomeProduto, double preco, String tipo, int quantidade) {

		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.tipo = tipo;
		this.quantidade = quantidade;
	}

	// retorna o preco do produto
	public double getPreco() {
		return this.preco;
	}

	// retorna o nome do produto
	public String getNomeProduto() {
		return this.nomeProduto;
	}

	// retorna o tipo do produto
	public String getTipo() {
		return this.tipo;
	}

	// retorna a quantidade do produto em estoque
	public int getQuantidade() {
		return this.quantidade;
	}

	// faz um set na quantidade do produto em estoque
	public void setQuantidade(int qntVenda) {
		this.quantidade = qntVenda;
	}

	// imprime como string o objeto produto
	@Override
	public String toString() {
		return nomeProduto + " (" + tipo + "). R$" + preco + " Restante " + quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeProduto == null) ? 0 : nomeProduto.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantidade;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Produto) {
			Produto produtos = (Produto) obj;

			if (produtos.getNomeProduto().equals(this.getNomeProduto()) && produtos.getTipo().equals(this.getTipo())) {
				return true;
			}
		}
		return false;
	}

}
