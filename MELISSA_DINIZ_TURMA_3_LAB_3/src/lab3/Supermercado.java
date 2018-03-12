package lab3;

import lab3.Estoque;
import lab3.LeEntrada;

/* 115211394 - Melissa Diniz Goncalves: LAB 3 - Turma 3 */

public class Supermercado {

	private LeEntrada entrada;
	private Estoque estoque;
	private double totalArrecadado = 0;

	// construtor do supermercado
	public Supermercado() {
		entrada = new LeEntrada();
		estoque = new Estoque();
	}

	// faz o cadastro dos produtos no estoque
	public void cadastraItem() {
		String outroCadastro;
		String nomeProduto;
		String tipo;
		double preco;
		int quantidade;
		boolean continua = true;

		do {

			System.out.print("= = = = Cadastro de Produtos = = = =\n");
			System.out.print("Digite o nome do produto:");
			nomeProduto = entrada.leString();

			System.out.print("Digite o preço unitário do produto:");
			preco = entrada.leDouble();

			System.out.print("Digite o tipo do produto:");
			tipo = entrada.leString();

			System.out.print("Digite a quantidade no estoque: ");
			quantidade = entrada.leInteiro();

			// adiciona o produto no estoque
			estoque.adcProdutoEstoque(nomeProduto, preco, tipo, quantidade);

			System.out.print("Deseja cadastrar outro produto? ");
			outroCadastro = entrada.leString();
			System.out.println();

			if (outroCadastro.equals("Nao") || outroCadastro.equals("Não") || outroCadastro.equals("nao")
					|| outroCadastro.equals("não") || outroCadastro.equals("NAO") || outroCadastro.equals("NÃO")) {
				continua = false;
			}

		} while (continua);

	}

	// realiza a venda dos produtos
	public void vendaItem() {
		String item;
		String outraVenda;
		boolean continua = true;
		int quantidadeVenda;

		System.out.println("= = = = Venda de Produtos = = = =");
		System.out.println();

		do {
			// recebe o nome do produto que sera vendido:
			System.out.print("Digite o nome do produto: ");
			item = entrada.leString();

			// usando o metodo procuraItem verifica se o produto esta no estoque
			if (estoque.procuraItem(item) != null) {
				// usa equals para comparar o nome do produto
				if (!estoque.procuraItem(item).getNomeProduto().equals(item)) {
					System.out.println(item + " não cadastrado.");
					// se o produto estiver no estoque, imprime a quantidade
				} else {
					System.out.println(estoque.procuraItem(item).getNomeProduto() + " possui "
							+ estoque.procuraItem(item).getQuantidade() + " unidades(s).");
				}

				System.out.println("Digite a quantidade que deseja vender:");
				quantidadeVenda = entrada.leInteiro();

				// verifica se tem qnt suficiente no estoque e faz um set na
				// quantidade
				if (quantidadeVenda <= estoque.procuraItem(item).getQuantidade()) {
					estoque.procuraItem(item)
							.setQuantidade(estoque.procuraItem(item).getQuantidade() - quantidadeVenda);
					this.totalArrecadado = totalArrecadado + (estoque.procuraItem(item).getPreco() * quantidadeVenda);
					// se não tiver quantidade de produto suficiente no estoque
				} else {
					System.out.println("Não é possível vender pois não ha " + estoque.procuraItem(item).getNomeProduto()
							+ " suficiente.");
				}
			}

			// Se quiser fazer outra venda:
			System.out.print("Deseja vender outro produto? ");
			outraVenda = entrada.leString();

			// se for digitado nao, ele modifica o controlador
			if (outraVenda.equals("Nao") || outraVenda.equals("Não") || outraVenda.equals("nao")
					|| outraVenda.equals("não") || outraVenda.equals("NAO") || outraVenda.equals("NÃO")) {
				continua = false;
			}

		} while (continua);
	}

	// chama metodo imprime balanco e imprime
	public void balanco() {
		estoque.imprimeBalanco();
		System.out.println();
		System.out.printf("==> Total arrecadado em vendas: R$ %.2f", totalArrecadado);
		System.out.println();
		System.out.printf("==> Total que pode ser arrecadado: R$ %.2f", estoque.getTotalPoderaArrecadar());
		System.out.println();
		System.out.println();
	}

}
