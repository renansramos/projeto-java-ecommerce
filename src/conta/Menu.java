package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.util.Cores;
import conta.model.ContaCorrente;


public class Menu {
	public static void main(String[] args) throws Exception {

		Scanner leia = new Scanner(System.in);

		// Variáveis de entrada de dados
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		// Instância da Classe ContaCorrente
		ContaController contas = new ContaController();

		System.out.println("\nCriar Contas\n");

		ContaCorrente cc3 = new ContaCorrente(1, "Renan Ramos");
		
		ContaCorrente cc4 = new ContaCorrente(2, "Maria");

		contas.listarTodas();

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                Loja Ecommerce                       ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar                            ");
			System.out.println("            2 - Listar todas Produtos                ");
			System.out.println("            3 - Listar por ID                        ");
			System.out.println("            4 - Atualizar                            ");
			System.out.println("            5 - Deletar                              ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 6) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nEcommerce - Agradece a preferência!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE + "Criar Produtos\n\n");

					System.out.println("Digite o id do produto: ");
					numero = leia.nextInt();
					System.out.println("Digite o Nome do produto: "); 
					leia.skip("\\R?");
					titular = leia.nextLine();

					keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE + "Listar todos os Produtos\n\n");

					contas.listarTodas();

					keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_WHITE + "Buscar Produto por ID\n\n");

					System.out.println("Digite o número do Produto: "); //ID
					numero = leia.nextInt();

					contas.procurarPorNumero(numero);

					keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_WHITE + "Atualizar informações do produto\n\n");

					System.out.println("Digite o número do Produto: "); //ID
					numero = leia.nextInt();

					var buscaConta = contas.buscarNaCollection(numero);

					if (buscaConta != null) {

						System.out.println("Digite o ID do Produto: "); // pegar digitar o numero da agencia 
						agencia = leia.nextInt();
						
						System.out.println("Digite o Nome Produto: ");
						leia.skip("\\R?");
						titular = leia.nextLine();

						tipo = buscaConta.getNumero();

					} else
						System.out.println("\nProduto não encontrada!");

					keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

					System.out.println("Digite o ID do Produto: ");
					numero = leia.nextInt();

					contas.deletar(numero);

					keyPress();
					break;
		
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
					keyPress();
					break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Renan Ramos");
		System.out.println("renan_dasilvaramos@hotmail.com");
		System.out.println("https://github.com/renansramos");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}

}