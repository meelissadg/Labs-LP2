package budega;
import java.util.Scanner;

public class CompraLojaoP2 {
	public static Scanner scanner = new Scanner(System.in);
	public static final int REALIZAR_COMPRA = 1;
	public static final int MUDAR_PRECO = 2;
	public static final int SAIR = 3;
	public static int totalProdutos = 0;
	public static int quantidade;
	
	
	public static int imprimeMenu(){
		System.out.println("Bem vindo ao lojao P2 :)");
		System.out.println("Menu Inicial: Digite uma das opções abaixo:\n\n1 Realizar compra.\n2 Mudar preço base de produtos.\n3 Sair\nOpção:");
		int opcao = scanner.nextInt();
		return opcao;
	}
	
	public static int pedeQuantidade(){
		System.out.println("-- Cadastro de produtos --");
		System.out.print("Digite a quantidade de produtos diferentes que sera comprada: ");
		int quantidade = scanner.nextInt();
		scanner.nextLine();
		return quantidade;
	}
	public static int cadastraProduto(){
		int[] quantProduto = new int[quantidade];
	    String[] arrayProduto = new String[quantidade];
	    
        for(int n = 0; n < quantidade; n=n+1){
            //recebe o nome do produto e add no array
            System.out.print("Nome do produto " + (n+1) + ": ");
            String produto = scanner.nextLine();
            arrayProduto[n] = produto;
            
            //recebe a quantidade de produtos e add no array
            System.out.print("Quantidade de " + produto +": ");
            int quantPrato = scanner.nextInt();
            scanner.nextLine();
            quantProduto[n] = quantPrato;
            totalProdutos = totalProdutos + quantPrato; 
            }
		return totalProdutos;	
	}
	
	public static void imprimeCadastro(int quantidade){
		System.out.println("-- Cadastro concluido --");
		System.out.println("A sua compra foi:");
		
//		for(int i = 0; i < quantidade ; i=i+1){
//			   System.out.println(quantProduto[i] + " " + arrayProduto[i] + " ( " + ((100*quantProduto[i])/totalProdutos) + "% )" );
//		}
		System.out.println("Total de produtos: " + totalProdutos);
        System.out.println("Total gastos: " + (totalProdutos * 1.99)); 
	}
		
	public static void main(String[] args) {
		       
		imprimeMenu();
		pedeQuantidade();
        cadastraProduto();
//        imprimeCadastro(quantidade);
        System.out.println("-- Fim da execucao --");
        System.out.println(quantidade);
      }
        
        
       
        
}

