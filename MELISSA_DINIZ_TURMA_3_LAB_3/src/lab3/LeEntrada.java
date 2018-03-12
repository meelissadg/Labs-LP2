package lab3;

/* 115211394 - Melissa Diniz Goncalves: LAB 3 - Turma 3 */

import java.util.Scanner;

// classe que usa scanner
public class LeEntrada {

	public Scanner sc = new Scanner(System.in);
	private int inteiro;
	private String string;
	private double flutuante;

	// recebe uma string e retorna a mesma.
	public String leString() {
		this.string = sc.next();
		return string;
	}

	// recebe um inteiro e retorna
	public int leInteiro() {
		this.inteiro = sc.nextInt();
		return inteiro;
	}

	// recebe um double e retorna
	public double leDouble() {
		this.flutuante = sc.nextDouble();
		return flutuante;
	}

}
