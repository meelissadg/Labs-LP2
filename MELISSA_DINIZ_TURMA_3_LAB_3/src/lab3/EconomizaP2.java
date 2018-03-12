package lab3;

/* 115211394 - Melissa Diniz Goncalves: LAB 3 - Turma 3 */


// classe que imprime o menu e as opcoes
public class EconomizaP2 {

	private static LeEntrada entrada = new LeEntrada();
	private static Supermercado supermercado = new Supermercado();

	
	public static void main(String[] args) {
		imprimeMenu();
	}

//	imprime a mensagem do menu
	public static void opcaoMenu() {
		System.out.println("Digite a opção desejada:");
		System.out.println("1 ­ Cadastrar um Produto");
		System.out.println("2 ­ Vender um Produto");
		System.out.println("3 ­ Imprimir Balanço");
		System.out.println("4 ­ Sair\n");
		System.out.print("Opcao: ");

	}

//	opcoes
	public static void imprimeMenu() {
		int opcao;

		System.out.println("= = = = Bem­vindo(a) ao EconomizaP2 = = = =\n");

		do {
			opcaoMenu();
			opcao = entrada.leInteiro();

			switch (opcao) {
			case 1:
				supermercado.cadastraItem();
				break;

			case 2:
				supermercado.vendaItem();
				break;

			case 3:
				supermercado.balanco();

				break;
			}
		} while (opcao != 4);
	}
}
