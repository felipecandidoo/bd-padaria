package br.com.padaria;

import java.util.Scanner;
 
public class Teclado {
	private static Scanner scanner = new Scanner(System.in);

	
	public static String leString() {
		String texto = scanner.nextLine();
		return texto;
	}
	
	public static int leInt() {
		 
		while (true) { 
			String texto = leString();
			try {
				 
				return Integer.parseInt(texto);
			} catch (NumberFormatException ex) {
				 
				System.out.println("O valor digitado n�o � um n�mero inteiro v�lido");
				System.out.print("Tente novamente: ");
			}
		}
	}
	
	/**
	 * Método que lê valores numéricos decimais a partir do teclado.
	 * 
	 * @return Valor numérico decimal digitado no teclado.
	 */
	public static double leDouble() {
		// Esse laço se repetirá enquanto um número válido não for digitado
		while (true) {
			String texto = leString();
			try {
				// Caso um número válido tenha sido digitado, retorna
				return Double.parseDouble(texto);
			} catch (NumberFormatException ex) {
				// Caso contrário, exibe uma mensagem de erro e repete
				System.out.println("O valor digitado não é um número decimal válido");
				System.out.print("Tente novamente: ");
			}
		}
	}
	
	/**
	 * Método de testes demonstrando como deve-se utilizar a classe Teclado
	 */
	public static void main(String[] args) {
		// Como ler valores textuais
		System.out.print("Digite seu nome: ");
		String nome = Teclado.leString();
		System.out.println("Oi " + nome + ", como vai ?");
		
		// Como ler valores numéricos inteiros
		System.out.print("Digite a sua idade: ");
		int idade = Teclado.leInt();
		int ano = 2021 - idade;
		System.out.println("Você deve ter nascido em " + ano);
		
		// Como ler valores numéricos decimais
		System.out.println("Vamos abastecer o carro");
		System.out.print("Quantos litros você vai abastecer? ");
		double litros = Teclado.leDouble();
		System.out.print("Qual o valor do litro? ");
		double valorLitro = Teclado.leDouble();
		double total = litros * valorLitro;
		System.out.println("Valor total: R$ " + total);
	}
}
