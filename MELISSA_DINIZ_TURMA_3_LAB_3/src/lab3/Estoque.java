package lab3;

/* 115211394 - Melissa Diniz Goncalves: LAB 3 - Turma 3 */

public class Estoque {

	private Produto[] produto;
	private int quantidadeDeProdutos;
	private double totalPoderaArrecadar = 0;

	// construtor do Estoque, inicializa o estoque vazio
	public Estoque() {
		produto = new Produto[10];
	}

	// imprime o balanco do supermercado
	public void imprimeBalanco() {

		System.out.println("= = = = Impressao de Balanço = = = =");
		System.out.println();

		System.out.println("Produtos cadastrados: ");
		System.out.println();

		// varre o estoque e imprime o toString de cada produto se for diferente
		// de null
		for (int i = 0; i < produto.length; i++) {
			if (produto[i] != null) {
				System.out.println(produto[i].toString());
			}
		}

		// verifica se tem produto cadastrado no estoque
		if (getQuantidadeDeProdutos() == 0) {
			System.out.println("Nenhum produto cadastrado.");
		}

	}

	// adiciona produto no estoque
	public void adcProdutoEstoque(String nomeProduto, double preco, String tipo, int quantidade) {

		// verifica se a quantidade de produtos é igual ao tamanho do array
		if (getQuantidadeDeProdutos() == produto.length) {
			aumentaArrayEstoque(nomeProduto, preco, tipo, quantidade);
		}

		// adiciona no final do array
		produto[quantidadeDeProdutos] = new Produto(nomeProduto, preco, tipo, quantidade);

		System.out.println();
		System.out.println(produto[quantidadeDeProdutos].getQuantidade() + " "
				+ produto[quantidadeDeProdutos].getNomeProduto() + "(s)" + " cadastrado(s) com sucesso.");
		System.out.println();
		// atualiza o valor da quantidade de produtos
		this.quantidadeDeProdutos = quantidadeDeProdutos + 1;

	}

	// duplica o tamanho do array
	public void aumentaArrayEstoque(String nomeProduto, double preco, String tipo, int quantidade) {

		if (getQuantidadeDeProdutos() == produto.length) {
			this.produto = copiaArray();
		}

		produto[quantidadeDeProdutos++] = new Produto(nomeProduto, preco, tipo, quantidade);
	}

	// copia os produtos
	public Produto[] copiaArray() {

		Produto[] novoArray = new Produto[quantidadeDeProdutos * 2];

		for (int i = 0; i < produto.length; i++) {
			novoArray[i] = produto[i];
		}
		return novoArray;
	}

	// procura um item pelo nome no estoque
	public Produto procuraItem(String nome) {
		// varre o estoque e retorna o produto
		for (int i = 0; i < produto.length; i++) {
			if (produto[i] != null) {
				if (nome.equals(produto[i].getNomeProduto())) {
					return produto[i];
				}
			}
		}
		// se a quantidade de produtos for zero, imprime que nao tem produto no
		// estoque
		if (getQuantidadeDeProdutos() == 0) {
			System.out.println("Nenhum produto cadastrado.");
		}
		return null;

	}

	// retorna a quantidade de produtos
	public int getQuantidadeDeProdutos() {
		return quantidadeDeProdutos;
	}

	
	public int retornaQntProdutos() {
		for (int i = 0; i < produto.length; i++) {
			if (produto[i] != null) {
				this.quantidadeDeProdutos = produto[i].getQuantidade() + quantidadeDeProdutos;
			}
			
		}return quantidadeDeProdutos;
	}

	// retorna o valor que podera ser arrecadado
	public double getTotalPoderaArrecadar() {
		return this.totalPoderaArrecadar;
	}

	// calcula o valor que podera ser arrecad
	public void totalPoderaSerArrecadado() {
		for (int i = 0; i < produto.length; i++) {
			if (produto[i] != null) {
				this.totalPoderaArrecadar = totalPoderaArrecadar + (getQuantidadeDeProdutos() * produto[i].getPreco());
			}

		}
	}

}