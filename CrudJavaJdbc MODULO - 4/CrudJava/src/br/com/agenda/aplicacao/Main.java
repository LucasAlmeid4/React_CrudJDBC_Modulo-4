package br.com.agenda.aplicacao;

import java.util.Scanner;

import br.com.conatos.menu.Menu;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char opcao;
		do {
			Menu cliente = new Menu();
			cliente.option(sc);

			System.out.println("");
			System.out.println("Deseja realizar um novo acesso (s/n) ?");
			opcao = sc.next().charAt(0);
			if (opcao == 's' || opcao == 'S') {
				Menu cliente1 = new Menu();
				cliente1.option(sc);
			} else {
				System.out.println("");
				System.out.println("A Recode Airline agradece a preferencia.");
				break;
			}

		} while (opcao == 'n');

	}

}
