package budega;
import java.util.Scanner;

public class BudegaLojaoP2 {
	
	        public static Scanner scanner = new Scanner(System.in);
	        public static int quantidade;
	        public static int[] arrayQuant;
	        public static String[] arrayProduto;
	        public static int totalProdutos;
	        public static double preco = 1.99;
	        
	  
	        public static void recebeQnt(){
	            System.out.print("Digite a quantidade de produtos diferentes que sera comprada: ");
	            
	            quantidade = scanner.nextInt();
	            scanner.nextLine();
	        }
	        	               
	        public static void novoPreco(){
	        	double novoPreco;
	            System.out.print("Qual o novo preco?");
	            novoPreco = scanner.nextDouble();
	            preco = novoPreco;
	            System.out.println("Novo preço é> "+novoPreco);
	        }
	        
	        public static void criaCadastro(){
	        	int[] arrayQuant = new int[quantidade];
	        	String[] arrayProduto = new String[quantidade];
	        	
	        	System.out.println("-- Cadastro de produtos --");
	        
	            for(int n = 0; n < quantidade; n=n+1){
	                //recebe o nome do produto
	                System.out.print("Nome do produto " + (n+1) + ": ");
	                String nomeProduto = scanner.nextLine();
	                arrayProduto[n] = nomeProduto;
	                
	               
	                //recebe a quantidade de produtos
	                System.out.print("Quantidade de " + nomeProduto +": ");
	                int quantProduto = scanner.nextInt();
	                scanner.nextLine();
	                arrayQuant[n] = quantProduto;
	        		totalProdutos = totalProdutos+ quantProduto;
	            }
	            
	            System.out.println("");
	            System.out.println("-- Cadastro concluido -- ");
	            System.out.println("A sua compra foi:");
	            
	            for(int i =0;i<quantidade;i=i+1){
	            	System.out.println(arrayQuant[i]+" "+arrayProduto[i]+" ( "+(100*arrayQuant[i])/totalProdutos+" % )");
	            }
	            System.out.println("Total de produtos: " + totalProdutos);
	            System.out.println("Total gastos: " + (totalProdutos * preco));
	            System.out.println("-- Fim da execucao --");
	        }
}