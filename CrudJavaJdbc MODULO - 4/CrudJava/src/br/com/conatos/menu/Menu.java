package br.com.conatos.menu;

import java.util.Date;
import java.util.Scanner;

import br.com.agenda.dao.ClienteDAO;
import br.com.agenda.model.Cliente;

public class Menu {
	private String[] cliente = new String[6];
	private int opcoes;
	Scanner sc = new Scanner(System.in);
	Cliente c1 = new Cliente();
	ClienteDAO contatoDao = new ClienteDAO();

	Cliente contato = new Cliente();

	public void option(Scanner sc) {

		do {
			System.out.println("           |==============|           ");
			System.out.println("========== |Recode Airline| ==========");
			System.out.println("===| Você na altura dos seus sonhos! |===");
			System.out.println("   | =============================== |    ");
			System.out.println();
			System.out.println("========== Menu ==========");
			System.out.println("Para encerrar digite 0:");
			System.out.println("Para se cadastrar digite 1:");
			System.out.println("Para consultar cadastro digite 2:");
			System.out.println("Para atualizar cadastro digite 3:");
			System.out.println("Para excluir cadastro digite 4:");

			opcoes = sc.nextInt();

			if (opcoes == 1) {
				cadastrar(sc);

			} else if (opcoes == 2) {
				consultar();
			} else if (opcoes == 3) {
				atualizar(sc);
			} else if (opcoes == 4) {
				deletar(sc);

			} else if (opcoes == 0) {

				System.out.println("========== Encerrada pelo usuário! ==========");
				System.out.println("=============== Volte sempre! ===============");
			} else {
				System.out.println("Opção Invalida");
			}

		} while (opcoes != 0);
	}

	private void cadastrar(Scanner sc) {
		System.out.println("========== Cadastre suas informações ==========");
		for (int i = 0; i < this.cliente.length; i++) {
			if (i == 0) {
				clearBuffer(sc);
				System.out.println("Digite o seu nome: ");
				contato.setNome(sc.nextLine());
			} else if (i == 1) {
				System.out.println("Digite a sua idade: ");
				contato.setIdade(sc.nextInt());
			} else if (i == 2) {
				System.out.println("Digite seu CPF: ");
				contato.setCpf(sc.next());
			} else if (i == 3) {
				System.out.println("Digite o seu email: ");
				contato.setEmail(sc.next());

			} else if (i == 4) {
				System.out.println("Digite seu local atual: ");
				contato.setLocalAtual(sc.nextLine());

			} else {
				clearBuffer(sc);
				System.out.println("Digite o local de destino ");
				contato.setDestino(sc.nextLine());
				clearBuffer(sc);
				contato.setDataCadastro(new Date());
				System.out.println("......................................");
				System.out.println("Cadastrado com sucesso.");
				System.out.println("Seja bem vindo a Recode Airline.");
				System.out.println("......................................");
				System.out.println();
				System.out.println();
			}

		}

		contatoDao.save(contato);
	}

	private void atualizar(Scanner sc) {

		System.out.println("Digite o CPF do consultante:");

		String cpf = sc.next();

		cpf = c1.setCpf(cpf);

		c1.setDataCadastro(new Date());

		Cliente updat = contatoDao.getCadastro(cpf);
		if (updat != null) {

			System.out.println("......................................");
			clearBuffer(sc);
			System.out.println("Digite o seu nome: ");
			c1.setNome(sc.nextLine());
			System.out.println("......................................");
			System.out.println("Digite a sua idade: ");
			c1.setIdade(sc.nextInt());
			System.out.println("......................................");
			System.out.println("Digite o seu email: ");
			c1.setEmail(sc.next());
			clearBuffer(sc);
			System.out.println("......................................");
			System.out.println("Digite seu local atual: ");
			c1.setLocalAtual(sc.nextLine());

			System.out.println("......................................");
			clearBuffer(sc);
			System.out.println("Digite o local de destino ");
			c1.setDestino(sc.nextLine());
			System.out.println("......................................");
			System.out.println("Atualização realizada com sucesso.");
			System.out.println("......................................");
			System.out.println();
			System.out.println();

			contatoDao.update(c1);

		} else {
			System.out.println("Não foi possivel conectar");
		}
	}

	private void consultar() {
		System.out.println("========== Dados cadastrados: ==========");
		System.out.println();

		System.out.println("Digite o CPF do consultante:");
		String cpf = sc.next();
		Cliente consulta = contatoDao.getCadastro(cpf);
		System.out.println(consulta);

	}

	private static void clearBuffer(Scanner sc) {
		if (sc.hasNextLine()) {
			sc.nextLine();
		}
	}

	private void deletar(Scanner sc) {
		System.out.println("Digite o CPF para exclusão da conta:");
		contatoDao.deleteByCpf(sc.next());

		System.out.println("========== Conta excluída com sucesso! ==========");
		System.out.println("==== Esperamos vê-lo outra vez, Volte sempre! ====");

	}

	public String[] getCliente() {
		return cliente;
	}

	public void setCliente(String[] cliente) {
		this.cliente = cliente;
	}

	public int getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(int opcoes) {
		this.opcoes = opcoes;
	}

}
