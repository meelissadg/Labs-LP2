package budega;
import java.util.Scanner;

public class MenuLojao {
    
    public static Scanner scanner = new Scanner(System.in);
    public static double novoPreco;

    public static void menu(){        
    	int opcao;
    	System.out.println("Bem vindo ao lojao P2 :)");
        System.out.println("Menu Inicial: Digite uma das opções abaixo:\n\n1 Realizar compra.\n2 Mudar preço base de produtos.\n3 Sair\nOpção:");
        opcao = scanner.nextInt();
        
        switch(opcao){
        case 1:           
                BudegaLojaoP2.recebeQnt();
                BudegaLojaoP2.criaCadastro();
                break;
        case 2:
        		BudegaLojaoP2.novoPreco();
        		break;
        case 3:
        		break;
    }
  }
	
    public static void main(String[] args) {
    	menu();    	 

    }
}